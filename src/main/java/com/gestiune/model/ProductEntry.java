package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinFormula;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sdonose on 2/21/2016.
 */
@Entity
@Table(name = "product_entry", schema = "gestiune")

public class ProductEntry implements Serializable {
    private int id;
    private int productId;
    private double priceUnit;
    private int quantity;
    private Date dateProduction;
    private Set<OrderProduct> orderProducts;
    private Product products;
    private Integer remainingStock;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "price_unit", nullable = false, precision = 0)
    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "date_production", nullable = false)
    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ProductEntry that = (ProductEntry) o;
//
//        if (id != that.id) return false;
//        if (productId != that.productId) return false;
//        if (Double.compare(that.priceUnit, priceUnit) != 0) return false;
//        if (quantity != that.quantity) return false;
//        if (!dateProduction.equals(that.dateProduction)) return false;
//        if (!orderProducts.equals(that.orderProducts)) return false;
//        return products.equals(that.products) && remainingStock.equals(that.remainingStock);
//
//    }

//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = id;
//        result = 31 * result + productId;
//        temp = Double.doubleToLongBits(priceUnit);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + quantity;
//        result = 31 * result + dateProduction.hashCode();
//        result = 31 * result + orderProducts.hashCode();
//        result = 31 * result + products.hashCode();
//        result = 31 * result + remainingStock.hashCode();
//        return result;
//    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entryProduct")
    @JsonIgnore
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "remaining_stock", nullable = false)
    @Check(constraints = "remaining_stock >= 0")
    public Integer getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
        stockDetail();
    }
    public void stockDetail(){
        int sum=0;
        for(OrderProduct o:orderProducts){

            sum+=o.getQuantity();
        }
        remainingStock=quantity-sum;
    }
}
