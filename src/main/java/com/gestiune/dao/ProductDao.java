package com.gestiune.dao;

import com.gestiune.model.Product;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */
public interface ProductDao {

    Product findById(int id);

    void saveProduct(Product product);

    List<Product> findAllProducts();

    List<Product> findByIdDetail(int id);

    List<Product> findAllProduct();

    Product findProductByName(String name);

    void deleteProductById(int id);
}
