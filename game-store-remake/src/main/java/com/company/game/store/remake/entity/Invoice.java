package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // one to one customer
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // one to many invoice item
    @OneToMany(mappedBy = "invoice",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    public Invoice() {
    }

    public Invoice(Customer customer, List<InvoiceItem> invoiceItems) {
        this.customer = customer;
        this.invoiceItems = invoiceItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id &&
                customer.equals(invoice.customer) &&
                invoiceItems.equals(invoice.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, invoiceItems);
    }
}
