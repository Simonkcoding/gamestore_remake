package com.company.game.store.remake.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "t_shirt")
public class TShirt extends InvoiceItem {

    @Column(name = "art", columnDefinition = "VARCHAR(20)")
    private String art;

    @Column(name = "size", columnDefinition = "VARCHAR(20)")
    private String size;

    public TShirt( BigDecimal unitPrice, int quantity, String art, String size) {
        super(unitPrice, quantity);
        this.art = art;
        this.size = size;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return art.equals(tShirt.art) &&
                size.equals(tShirt.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), art, size);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "art='" + art + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

}
