package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_shirt")
public class TShirt extends InvoiceItem {

    @Column(name = "art", columnDefinition = "VARCHAR(20)")
    private String art;

    @Column(name = "size", columnDefinition = "VARCHAR(20)")
    private String size;


}
