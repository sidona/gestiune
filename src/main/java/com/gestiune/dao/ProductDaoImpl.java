package com.gestiune.dao;

import com.gestiune.model.Product;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        List<Product> list=(List<Product>)sessionFactory.getCurrentSession().createSQLQuery(String.format("SELECT * \n" +
                "FROM product p \n" +
                "\tINNER JOIN order_product op ON ( p.product_id = op.product_id  )  ")).addEntity(Product.class).list();

        return list;
    }

    public Product findProductByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Product) criteria.uniqueResult();
    }

    public void deleteProductByName(String name) {
        SQLQuery query=getSession().createSQLQuery(String.format("delete FROM product where name=:name"));
        query.setParameter("name",name);
        query.executeUpdate();
    }
}

