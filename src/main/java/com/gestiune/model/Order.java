package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by sdonose on 2/8/2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false)
    private int orderId;
   @Column(name = "CUST_ID", nullable = false, insertable = false, updatable = false)
    private int custId;


    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "CUST_ID" , nullable = false)
    private Customer customer;

    public int getOrderId() {
        return orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        return customer.equals(order.customer);

    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + customer.hashCode();
        return result;
    }

}
