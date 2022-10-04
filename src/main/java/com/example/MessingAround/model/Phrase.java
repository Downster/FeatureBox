package com.example.MessingAround.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Phrases")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Phrase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String phrase;

    public String toPhraseString(){
        return this.phrase;
    }

}

