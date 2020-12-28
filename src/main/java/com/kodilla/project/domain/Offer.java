package com.kodilla.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OFFERS")
public class Offer {

    @Id
    @GeneratedValue
    @Column(name = "OFFER_ID")
    private Long id;

    @Column(name = "OFFER_NAME", unique = true)
    private String name;

    @Column(name = "OFFER_DESCRIPTION")
    private String description;

    @Column(name = "OFFER_PRICE")
    private double price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @OneToOne(mappedBy = "offer")
    private Order order;

    public Offer(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private double price;
        private Group group;
        private Order order;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

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

        public Builder group(Group group) {
            this.group = group;
            return this;
        }

        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        public Offer build() {
            Offer offer = new Offer();
            offer.id = this.id;
            offer.name = this.name;
            offer.description = this.description;
            offer.price = this.price;
            offer.group = this.group;
            offer.order = this.order;
            return offer;
        }
    }
}
