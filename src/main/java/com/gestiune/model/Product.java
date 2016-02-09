package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sdonose on 2/6/2016.
 */

@Entity
@Table(name="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;

    @Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "ORDER_PRODUCT",
            joinColumns = { @JoinColumn(name = "ORD_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PROD_ID") })
    private Set<Order> orderSet=new HashSet<Order>();

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (!name.equals(product.name)) return false;
        if (!price.equals(product.price)) return false;
        return orderSet.equals(product.orderSet);

    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + orderSet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderSet=" + orderSet +
                '}';
    }
}
