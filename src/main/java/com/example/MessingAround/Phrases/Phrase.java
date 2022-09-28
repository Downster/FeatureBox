package com.example.MessingAround.Phrases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Phrases")
public class Phrase{
    private @Id @GeneratedValue Long id;
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
}

