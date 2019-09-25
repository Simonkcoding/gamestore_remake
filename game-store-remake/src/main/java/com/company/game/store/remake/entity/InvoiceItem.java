package com.company.game.store.remake.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="invoice_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Many to one with invoice
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Invoice invoice;

    @Column(name = "unit_price", columnDefinition = "decimal(10,2)")
    private BigDecimal unitPrice;

    @Column(name = "quantity", columnDefinition = "int(10)")
    private int quantity;

    @Column(name = "subtotal", columnDefinition = "decimal(10,2)")
    private BigDecimal subtotal;


}
