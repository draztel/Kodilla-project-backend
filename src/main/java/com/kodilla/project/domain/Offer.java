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
@Table(name = "OFFERS")
public class Offer {

    @Id
    @GeneratedValue
    @Column(name = "OFFER_ID")
    private Long id;

    @Column(name = "OFFER_NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "OFFER_DESCRIPTION")
    private String description;

    @Column(name = "OFFER_PRICE")
    private double price;

    public static final class Builder {
        private String name;
        private String description;
        private double price;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Offer build() {
            Offer offer = new Offer();
            offer.name = this.name;
            offer.description = this.description;
            offer.price = this.price;
            return offer;
        }
    }
}
