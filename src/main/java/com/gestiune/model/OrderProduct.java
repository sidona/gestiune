package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sdonose on 2/21/2016.
 */
@Entity
@Table(name = "order_product", schema = "gestiune")
public class OrderProduct implements Serializable {
    private int id;
    private int orderId;
    private int entryId;
    private int quantity;
    private Orders order;
    private ProductEntry entryProduct;
    private Double totalProduct;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "entry_id", nullable = false)
    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderProduct that = (OrderProduct) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (entryId != that.entryId) return false;
        if (quantity != that.quantity) return false;
        if (!order.equals(that.order)) return false;
        if (!entryProduct.equals(that.entryProduct)) return false;
        return totalProduct.equals(that.totalProduct);

    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderId;
        result = 31 * result + entryId;
        result = 31 * result + quantity;
        result = 31 * result + order.hashCode();
        result = 31 * result + entryProduct.hashCode();
        result = 31 * result + totalProduct.hashCode();
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    @JsonIgnore
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "entry_id", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    @JsonIgnore
    public ProductEntry getEntryProduct() {
        return entryProduct;
    }

    public void setEntryProduct(ProductEntry entryProduct) {
        this.entryProduct = entryProduct;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "total_product", nullable = false)
    public Double getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(Double totalProduct) {
        this.totalProduct = totalProduct;
        updateTotal();
    }

    public void updateTotal(){
        this.totalProduct=this.quantity*entryProduct.getPriceUnit();
    }
}
