package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(20)")
    private String name;

    @Column(name="phone", columnDefinition="VARCHAR(20)")
    private String phone;

    @Column(name="address", columnDefinition="VARCHAR(20)")
    private String address;

    @OneToOne(mappedBy = "customer", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Invoice invoice;

    public Customer() {
    }

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                name.equals(customer.name) &&
                phone.equals(customer.phone) &&
                address.equals(customer.address) &&
                invoice.equals(customer.invoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, address, invoice);
    }


}
