package com.gestiune.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sdonose on 2/15/2016.
 */
public class OrdersPK implements Serializable {
    private int orderId;
    private int customerId;

    @Column(name = "order_id")
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "customer_id")
    @Id
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

        OrdersPK ordersPK = (OrdersPK) o;

        if (orderId != ordersPK.orderId) return false;
        if (customerId != ordersPK.customerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + customerId;
        return result;
    }
}
