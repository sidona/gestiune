package com.gestiune.dao;

import com.gestiune.model.Product;
import org.hibernate.*;
import org.hibernate.Query;
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


    public List<Product> findByIdDetail(int id) {
    List<Product> list=sessionFactory.getCurrentSession()
            .createQuery("select p.name, pe.priceUnit,pe.quantity,pe.dateProduction from Product p inner join p.productEntry pe where p.id=:id")
            .setInteger("id",id)
            .list();
        return list;
    }

    public Product findById(int productId) {
        return getByKey(productId);
    }

    public void saveProduct(Product product) {
        persist(product);
    }

    public List<Product> findAllProducts() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        return (List<Product>) criteria.list();
    }

    public List<Product> findAllProduct() {
        List<Product> products = sessionFactory.getCurrentSession()
                .createQuery("select p.name, pe.priceUnit,pe.quantity,pe.dateProduction from Product p inner join p.productEntry pe")
                .list();

        return products;
    }


//    public List<Product> findAllProducts() {
//       List<Product>list=sessionFactory.getCurrentSession().createQuery("select p.name, pp.price from Product p inner join p.priceProduct pp").list();
//    return list;
//    }


    public Product findProductByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Product) criteria.uniqueResult();
    }

    public void deleteProductById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Product where id=:id");
        query.setInteger("id", id).executeUpdate();

    }
}

