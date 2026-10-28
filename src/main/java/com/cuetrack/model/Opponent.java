package com.cuetrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "opponents")

public class Opponent {

    //variable declaration
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opponent_id")
    private Integer opponentId;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    public Opponent(){

    }

    //Getters
    public Integer getOpponentId(){

        return opponentId;
    }

    public String getName(){
        return name;
    }

    //Setters
    public void setOpponentId(Integer opponentId){

        this.opponentId = opponentId;
    }

    public void setName(String name){
        this.name = name;
    }
}
