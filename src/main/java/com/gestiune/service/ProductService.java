package com.gestiune.service;

import com.gestiune.model.Product;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */
public interface ProductService {

    Product findById(int productId);

    void saveProduct(Product product);


    List<Product> findAllProducts();
    List<Product> findAllProductOrder();

    Product findProductByName(String name);
}
