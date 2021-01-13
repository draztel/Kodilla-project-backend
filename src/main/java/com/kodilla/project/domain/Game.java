package com.kodilla.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "GAMES")
public class Game {

    @Id
    @GeneratedValue
    @Column(name = "GAME_ID")
    private Long id;

    @NotNull
    @Column(name = "GAME_NAME", unique = true)
    private String name;

    @Column(name = "GAME_DESCRIPTION")
    private String description;

    @Column(name = "GAME_PRICE")
    private double price;
}
