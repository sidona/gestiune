package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * Created by sdonose on 2/21/2016.
 */
@Entity
public class Orders implements Serializable{
    private int id;
    private int customerId;
    private Customer customer;
    private Set<OrderProduct> orderProduct;
    private Date dateOrders;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (customerId != orders.customerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + customerId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    @JsonIgnore
    public Set<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    @Basic
    @Column(name = "date_orders", nullable = false)
    public Date getDateOrders() {
        return dateOrders;
    }

    public void setDateOrders(Date dateOrders) {
        this.dateOrders = dateOrders;
    }


}
