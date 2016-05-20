package com.gestiune.dao;

import com.gestiune.model.ProductEntry;

import java.util.Date;
import java.util.List;

/**
 * Created by sdonose on 2/22/2016.
 */
public interface ProductEntryDao {

    ProductEntry findById(int productId);

    void saveProd(int productId, double priceUnit, int quantity, Date dateProduction);

    void saveProductEntry(ProductEntry productEntity);

    List<ProductEntry> findAllProductsEntry();
}
