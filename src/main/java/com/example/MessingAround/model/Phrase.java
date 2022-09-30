package com.example.MessingAround.model;

import javax.persistence.*;

@Entity
@Table(name="Phrases")
public class Phrase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String phrase;

    public Phrase(String phrase) {
        this.phrase = phrase;
    }

    public Phrase(){};

    public Long getId() {
        return id;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }


    public String toString(){
        return "" + phrase;
    }
}

