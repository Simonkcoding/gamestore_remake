package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "game")
public class Game extends InvoiceItem {

    @Column(name = "company", columnDefinition = "VARCHAR(20)")
    private String company;

    @Column(name = "rating", columnDefinition = "VARCHAR(20)")
    private String rating;

}
