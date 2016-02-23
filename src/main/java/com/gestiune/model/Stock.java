package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

/**
 * Created by sdonose on 2/23/2016.
 */
@Entity
public class Stock {
    private int id;
    private int productEntryId;
    private Integer remainingStock;
    private ProductEntry prodEntry;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_entry_id", nullable = false)
    public int getProductEntryId() {
        return productEntryId;
    }

    public void setProductEntryId(int productEntryId) {
        this.productEntryId = productEntryId;
    }

    @Basic
    @Column(name = "remaining_stock", nullable = true)
    @Formula("select pe.quantity-op.quantity from Stock s inner join s.prodEntry pe inner join pe.orderProducts op")
    public Integer getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (id != stock.id) return false;
        if (productEntryId != stock.productEntryId) return false;
        if (remainingStock != null ? !remainingStock.equals(stock.remainingStock) : stock.remainingStock != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productEntryId;
        result = 31 * result + (remainingStock != null ? remainingStock.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "product_entry_id", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    @JsonIgnore
    public ProductEntry getProdEntry() {
        return prodEntry;
    }

    public void setProdEntry(ProductEntry prodEntry) {
        this.prodEntry = prodEntry;
    }
}
