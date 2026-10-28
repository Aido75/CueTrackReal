package com.cuetrack.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "game")

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "opponent_id", nullable = false)
    private Opponent opponent;

    @Column(name = "result", nullable = false, length = 10)
    private String result;

    @Column(name = "venue", length = 45)
    private String venue;

    @Column(name = "table_size", precision = 3, scale = 1)
    private BigDecimal tableSize;

    @Column(name = "cue_weight", precision = 4, scale = 1)
    private BigDecimal cueWeight;

    @Column(name = "scratches", nullable = false)
    private int scratches = 0;

    @Column(name = "longest_run", nullable = false)
    private int longestRun = 0;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

}
