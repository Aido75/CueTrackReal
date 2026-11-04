
package com.cuetrack.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "practice_session")
public class PracticeSession {

    //variable declaration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practice_id")
    private Integer practiceId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "venue", length = 45)
    private String venue;

    @Column(name = "table_size", precision = 3, scale = 1)
    private BigDecimal tableSize;

    @Column(name = "cue_weight", precision = 4, scale = 1)
    private BigDecimal cueWeight;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "focus", length = 100)
    private String focus;

    @Column(name = "scratches", nullable = false)
    private int scratches = 0;

    @Column(name = "longest_run", nullable = false)
    private int longestRun = 0;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    // Default Constructor
    public PracticeSession() {
    }

    // Getters

    public Integer getPracticeId() {
        return practiceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public BigDecimal getTableSize() {
        return tableSize;
    }

    public BigDecimal getCueWeight() {
        return cueWeight;
    }

    public int getDuration() {
        return duration;
    }

    public String getFocus() {
        return focus;
    }

    public int getScratches() {
        return scratches;
    }

    public int getLongestRun() {
        return longestRun;
    }

    public String getNotes() {
        return notes;
    }

    // Setters

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setTableSize(BigDecimal tableSize) {
        this.tableSize = tableSize;
    }

    public void setCueWeight(BigDecimal cueWeight) {
        this.cueWeight = cueWeight;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public void setScratches(int scratches) {
        this.scratches = scratches;
    }

    public void setLongestRun(int longestRun) {
        this.longestRun = longestRun;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
