package com.gestiune.service;

import com.gestiune.model.Product;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */
public interface ProductService {

    Product findById(int id);

    void saveProduct(Product product);

    void deleteProductById(int id);

    List<Product> findAllProducts();

    List<Product> findAllProduct();

    List<Product> findByIdDetail(int id);

    Product findProductByName(String name);
}
