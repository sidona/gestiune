package com.gestiune.dao;

import com.gestiune.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */

@Repository("productDao")

public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {


    @Autowired
    private SessionFactory sessionFactory;

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

    public List<Product> findAllProductOrder() {
        List<Product> list=(List<Product>)sessionFactory.getCurrentSession().createQuery(String.format(" select p FROM Product p")).list();

        return list;
    }

    public Product findProductByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Product) criteria.uniqueResult();
    }
}

