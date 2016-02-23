package com.gestiune.service;

import com.gestiune.model.ProductEntry;

import java.util.Date;
import java.util.List;

/**
 * Created by sdonose on 2/22/2016.
 */
public interface ProductEntryService {

    ProductEntry findById(int id);

    void saveProductEntry(ProductEntry productEntity);

    List<ProductEntry> findAllProductsEntry();

   void saveProd(int productId, double priceUnit, int quantity, Date dateProduction);
}
