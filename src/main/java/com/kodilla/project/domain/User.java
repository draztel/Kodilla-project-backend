package com.kodilla.project.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @NotNull
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
