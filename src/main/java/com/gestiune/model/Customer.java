package com.gestiune.model;


import javax.persistence.*;
import javax.persistence.criteria.Order;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sdonose on 2/8/2016.
 */

@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;

    @Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        return name.equals(customer.name);

    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}
