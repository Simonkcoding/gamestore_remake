package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "game")
public class Game extends InvoiceItem {

    @Column(name = "company", columnDefinition = "VARCHAR(20)")
    private String company;

    @Column(name = "rating", columnDefinition = "VARCHAR(20)")
    private String rating;

    public Game() {
    }

    public Game(BigDecimal unitPrice, int quantity, String company, String rating) {
        super(unitPrice, quantity);
        this.company = company;
        this.rating = rating;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return company.equals(game.company) &&
                rating.equals(game.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, rating);
    }

    @Override
    public String toString() {
        return "Game{" +
                "company='" + company + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

}
