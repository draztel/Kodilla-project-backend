package com.kodilla.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "GAME_NAME", unique = true)
    private String name;

    @Column(name = "GAME_DESCRIPTION")
    private String description;

    @Column(name = "GAME_PRICE")
    private double price;
}
