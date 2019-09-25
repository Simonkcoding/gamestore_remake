package com.company.game.store.remake.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    @JoinColumn(name="fk_invoice_id")
    private Invoice invoice;

    @Column(name = "unit_price", columnDefinition = "decimal(10,2)")
    private BigDecimal unitPrice;

    @Column(name = "quantity", columnDefinition = "int(10)")
    private int quantity;

    @Column(name = "subtotal", columnDefinition = "decimal(10,2)")
    private BigDecimal subtotal;

    public InvoiceItem() {
    }

    public InvoiceItem( BigDecimal unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return id == that.id &&
                quantity == that.quantity &&
                invoice.equals(that.invoice) &&
                unitPrice.equals(that.unitPrice) &&
                subtotal.equals(that.subtotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoice, unitPrice, quantity, subtotal);
    }

}
