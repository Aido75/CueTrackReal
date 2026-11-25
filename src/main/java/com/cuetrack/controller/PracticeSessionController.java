package com.cuetrack.controller;

import com.cuetrack.model.PracticeSession;
import com.cuetrack.repository.PracticeSessionRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/practice")
public class PracticeSessionController {

    private final PracticeSessionRepository practiceSessionRepository;

    // Constructor
    public PracticeSessionController(
            PracticeSessionRepository practiceSessionRepository) {
        this.practiceSessionRepository = practiceSessionRepository;
    }

    // Retrieve all practice sessions
    @GetMapping
    public List<PracticeSession> getAllPracticeSessions() {
        return practiceSessionRepository.findAll();
    }

    // Record a new practice session
    /*
    @PostMapping
    public PracticeSession addPracticeSession(
            @RequestBody PracticeSession practiceSession) {

        practiceSession.setPracticeId(null);

        return practiceSessionRepository.save(practiceSession);
    }
    */
}