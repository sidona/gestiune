package com.gestiune.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by sdonose on 2/21/2016.
 */
@Entity
public class Product implements Serializable {
    private int id;
    private String name;
    private Set<ProductEntry> productEntry;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "products")
    @JsonIgnore
    public Set<ProductEntry> getProductEntry() {
        return productEntry;
    }

    public void setProductEntry(Set<ProductEntry> productEntry) {
        this.productEntry = productEntry;
    }
}
