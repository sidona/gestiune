package com.gestiune.service;

import com.gestiune.dao.ProductDao;
import com.gestiune.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sdonose on 2/6/2016.
 */

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao dao;



    public Product findById(int productId) {
        return dao.findById(productId);
    }

    public void saveProduct(Product product) {
        dao.saveProduct(product);
    }

    public void deleteProductById(int id) {
        dao.deleteProductById(id);
    }


    public List<Product> findAllProducts() {
        return dao.findAllProducts();
    }

    public List<Product> findAllProduct() {
        return dao.findAllProduct();
    }

    public List<Product> findByIdDetail(int id) {
        return dao.findByIdDetail(id);
    }

    public Product findProductByName(String name) {
        return dao.findProductByName(name);
    }
}
