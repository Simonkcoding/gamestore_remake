package com.company.game.store.remake.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "console")
public class Console extends InvoiceItem {

    @Column(name = "company", columnDefinition = "VARCHAR(20)")
    private String company;

    @Column(name = "specs", columnDefinition = "VARCHAR(20)")
    private String specs;


}
