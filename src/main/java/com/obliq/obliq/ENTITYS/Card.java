package com.obliq.obliq.ENTITYS;


import javax.persistence.*;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "card_name", nullable = false, length = 250, unique = true)
    private String card;

    public Card() {
    }

    public Card(String card) {
        this.card = card;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String title) {
        this.card = card;
    }
}
