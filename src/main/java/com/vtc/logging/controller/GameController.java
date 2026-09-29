package com.vtc.logging.controller;

import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import com.vtc.logging.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000","http://117.103.203.180:3000", "http://localhost:30080", "http://117.103.203.180:30080", "http://118.107.77.204:3000", "http://118.107.77.204:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<?> getAllGames(@RequestParam(required = false) Platform platform,
                                         @RequestParam(required = false) PubStatus status) {
        try {
            return ResponseEntity.ok(gameService.filterGames(platform, status));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGame(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(gameService.getGame(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addGame(@RequestBody GameRequest game) {
        try {
            return ResponseEntity.ok(gameService.addGame(game.name, game.description, game.platform, game.status));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Integer id) {
        try {
            gameService.deleteGame(id);
            return ResponseEntity.ok("Successfully deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGame(@PathVariable Integer id,
                                        @RequestBody GameRequest game) {
        try {
            return ResponseEntity.ok(gameService.updateGame(id, game.name, game.description, game.platform, game.status));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
