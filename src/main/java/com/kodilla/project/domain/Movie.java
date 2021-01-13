package com.kodilla.project.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "MOVIE_ID")
    private Long id;

    @Column(name = "MOVIE_NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "MOVIE_DESCRIPTION")
    private String description;

    @Column(name = "MOVIE_AUTHOR")
    private String author;
}
