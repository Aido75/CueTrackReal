package com.cuetrack.controller;

import com.cuetrack.model.Game;
import com.cuetrack.model.Opponent;
import com.cuetrack.repository.GameRepository;
import com.cuetrack.repository.OpponentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;
    private final OpponentRepository opponentRepository;

    // Constructor
    public GameController(GameRepository gameRepository,
                          OpponentRepository opponentRepository) {
        this.gameRepository = gameRepository;
        this.opponentRepository = opponentRepository;
    }

    // Retrieve all games
    @GetMapping
    @Transactional(readOnly = true)
    public List<GameResponse> getAllGames() {

        List<Game> games = gameRepository.findAll();
        List<GameResponse> responses = new ArrayList<>();

        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            GameResponse response = toResponse(game);
            responses.add(response);
        }

        return responses;
    }

    /*
    // Record a new game
    @PostMapping
    @Transactional
    public GameResponse addGame(@RequestBody Game game) {

        if (game.getOpponent() == null ||
                game.getOpponent().getOpponentId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "An opponent is required."
            );
        }

        Integer opponentId = game.getOpponent().getOpponentId();

        Opponent opponent = opponentRepository.findById(opponentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Opponent not found."
                ));

        game.setGameId(null);
        game.setOpponent(opponent);

        return toResponse(gameRepository.save(game));
    }
     */

    // Convert game data into response data
    private GameResponse toResponse(Game game) {

        Opponent opponent = game.getOpponent();

        OpponentResponse opponentResponse = new OpponentResponse(
                opponent.getOpponentId(),
                opponent.getName()
        );

        GameResponse gameResponse = new GameResponse(
                game.getGameId(),
                game.getDate(),
                opponentResponse,
                game.getResult(),
                game.getVenue(),
                game.getTableSize(),
                game.getCueWeight(),
                game.getScratches(),
                game.getLongestRun(),
                game.getNotes()
        );

        return gameResponse;
    }

    public record OpponentResponse(
            Integer opponentId,
            String name
    ) {}

    public record GameResponse(
            Integer gameId,
            LocalDate date,
            OpponentResponse opponent,
            String result,
            String venue,
            BigDecimal tableSize,
            BigDecimal cueWeight,
            int scratches,
            int longestRun,
            String notes
    ) {}
}