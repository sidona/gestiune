package com.gestiune.dao;

import com.gestiune.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {


    public Product findById(int productId) {
        return getByKey(productId);
    }

    public void saveProduct(Product product) {
        persist(product);

    }

    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        return (List<Product>) criteria.list();
    }

    public Product findProductByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Product) criteria.uniqueResult();
    }
}

