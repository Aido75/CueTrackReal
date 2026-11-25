package com.cuetrack.controller;

import com.cuetrack.model.Opponent;
import com.cuetrack.repository.OpponentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/opponents")
public class OpponentController {

    private final OpponentRepository opponentRepository;

    // Constructor
    public OpponentController(OpponentRepository opponentRepository) {
        this.opponentRepository = opponentRepository;
    }

    // Retrieve all opponents
    @GetMapping
    public List<Opponent> getAllOpponents() {
        return opponentRepository.findAll();
    }

    // Add a new opponent
    @PostMapping
    public Opponent addOpponent(@RequestBody Opponent opponent) {
        opponent.setOpponentId(null);
        return opponentRepository.save(opponent);
    }
}
