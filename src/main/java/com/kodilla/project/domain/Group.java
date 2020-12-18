package com.kodilla.project.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OFFER_GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID")
    private Long id;

    @NotNull
    @Column(name = "GROUP_NAME", unique = true)
    private String name;

    @OneToMany(
            targetEntity = Offer.class,
            mappedBy = "group",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Offer> offers = new ArrayList<>();
}
