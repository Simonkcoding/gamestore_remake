package com.company.game.store.remake.entity;


import javax.persistence.*;

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

}
