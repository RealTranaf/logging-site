package com.vtc.logging.service;

import com.vtc.logging.model.Game;
import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import com.vtc.logging.repository.GameRepository;
import com.vtc.logging.repository.GameSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import io.opentelemetry.api.trace.Span;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> filterGames(Platform platform, PubStatus status) {
        log.info("Filtering games with platform={} status={}", platform, status);

        Specification<Game> spec = Specification
                .where(GameSpecification.hasPlatform(platform))
                .and(GameSpecification.hasStatus(status));

        List<Game> games = gameRepository.findAll(spec);
        log.info("Found {} games", games.size());

        return games;
    }

    public Game getGame(Integer id) {
        Span.current().setAttribute("game.id", id);
        log.info("Fetching game with id={}", id);

        Game game = gameRepository.findById(id).orElseThrow(() -> {
                    log.error("Game not found with id={}", id);
                    return new RuntimeException("Game not found");
        });

        log.debug("Game fetched: {}", game.getName());

        return game;
    }

    public Game addGame(String name, String description, Platform platform, PubStatus status) {
        log.info("Adding new game: name={}, platform={}, status={}", name, platform, status);

        Game game = new Game(name, description, platform, status);
        Game savedGame = gameRepository.save(game);


        log.info("Game created successfully with id={}", savedGame.getId());
        return savedGame;
    }

    public void deleteGame(Integer id) {
        Span.current().setAttribute("game.id", id);
        log.warn("Deleting game with id={}", id);
        gameRepository.deleteById(id);
        log.info("Game deleted successfully id={}", id);
    }

    public Game updateGame(Integer id, String name, String description, Platform platform, PubStatus status) {
        Span.current().setAttribute("game.id", id);
        log.info("Updating game id={}", id);

        Game game = gameRepository.findById(id).orElseThrow(() -> {
                    log.error("Game not found for update id={}", id);
                    return new RuntimeException("Game not found");
        });

        game.setName(name);
        game.setDescription(description);
        game.setPlatform(platform);
        game.setStatus(status);
        Game updated = gameRepository.save(game);

        log.info("Game updated successfully id={}", id);

        return updated;
    }
}
