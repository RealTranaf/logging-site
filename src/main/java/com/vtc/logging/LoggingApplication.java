package com.vtc.logging;

import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import com.vtc.logging.repository.GameRepository;
import com.vtc.logging.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class LoggingApplication implements CommandLineRunner {

    private final GameRepository gameRepository;
    private final GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (gameRepository.count() == 0) {
            gameService.addGame(
                    "Game 1",
                    "Phần mô tả của game 1",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 2",
                    "Phần mô tả của game 2",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 3",
                    "Phần mô tả của game 3",
                    Platform.PC,
                    PubStatus.PUBLISHED
            );

            gameService.addGame(
                    "Game 4",
                    "Phần mô tả của game 4",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 5",
                    "Phần mô tả của game 5",
                    Platform.PC,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 6",
                    "Phần mô tả của game 6",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 7",
                    "Phần mô tả của game 7",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 8",
                    "Phần mô tả của game 8",
                    Platform.MOBILE,
                    PubStatus.ONGOING
            );

            gameService.addGame(
                    "Game 9",
                    "Phần mô tả của game 9",
                    Platform.MOBILE,
                    PubStatus.PUBLISHED
            );

            gameService.addGame(
                    "Game 10",
                    "Phần mô tả của game 10",
                    Platform.MOBILE,
                    PubStatus.PUBLISHED
            );
        }
    }
}
