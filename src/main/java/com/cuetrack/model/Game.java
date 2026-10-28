package com.cuetrack.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "game")

public class Game {

    //variable declaration
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

    //Constructor
    public Game() {

    }

    //getters
    public Integer getGameId(){
        return gameId;
    }

    public LocalDate getDate(){
        return date;
    }

    public Opponent getOpponent(){
        return opponent;
    }

    public String getResult(){
        return result;
    }

    public String getVenue(){
        return venue;
    }

    public BigDecimal getTableSize(){
        return tableSize;
    }

    public BigDecimal getCueWeight(){
        return cueWeight;
    }

    public int getScratches(){
        return scratches;
    }

    public int getLongestRun(){
        return longestRun;
    }

    public String getNotes(){
        return notes;
    }

    //setters

    public void setGameId(Integer gameId){
        this.gameID = gameId;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setOpponent(Opponent opponent){
        this.opponent = opponent;
    }

    public void setResult(String result){
        this.result = result;
    }

    public void setVenue(String venue){
        this.venue = venue;
    }





}

