package com.gestiune.dao;

import com.gestiune.model.ProductEntry;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by sdonose on 2/22/2016.
 */

@Repository("productEntityDao")
public class ProductEntryDaoImpl extends AbstractDao<Integer,ProductEntry> implements ProductEntryDao {
    @Autowired
    private SessionFactory sessionFactory;

    public ProductEntry findById(int productId) {
         return getByProductId(productId);
    }

    public void saveProd(int productId, double priceUnit, int quantity, Date dateProduction) {
         sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO product_entry  (product_id,price_unit,quantity,date_production) VALUE (:product_id,:priceUnit,:quantity,\"2016-02-22\")")
                .executeUpdate();
    }

    public void saveProductEntry(ProductEntry productEntity) {
        persist(productEntity);
    }

    public List<ProductEntry> findAllProductsEntry() {
        List<ProductEntry> productEntries=sessionFactory.getCurrentSession().createQuery("from ProductEntry ").list();
        return productEntries;
    }
}
