package com.company.game.store.remake.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "console")
public class Console extends InvoiceItem {

    @Column(name = "company", columnDefinition = "VARCHAR(20)")
    private String company;

    @Column(name = "specs", columnDefinition = "VARCHAR(20)")
    private String specs;

    public Console() {
    }

    public Console(BigDecimal unitPrice, int quantity, String company, String specs) {
        super(unitPrice, quantity);
        this.company = company;
        this.specs = specs;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return company.equals(console.company) &&
                specs.equals(console.specs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, specs);
    }

    @Override
    public String toString() {
        return "Console{" +
                "company='" + company + '\'' +
                ", specs='" + specs + '\'' +
                '}';
    }


}
