package com.gestiune.service;

import com.gestiune.dao.ProductEntryDao;
import com.gestiune.model.ProductEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by sdonose on 2/22/2016.
 */

@Service("productEntryService")
@Transactional
public class ProductEntryServiceImpl implements ProductEntryService {
    @Autowired
    private ProductEntryDao dao;

    public ProductEntry findById(int productId) {
        return dao.findById(productId);
    }

    public void saveProductEntry(ProductEntry productEntity) {
        dao.saveProductEntry(productEntity);
    }

    public List<ProductEntry> findAllProductsEntry() {
        return dao.findAllProductsEntry();
    }

    public void saveProd(int productId, double priceUnit, int quantity, Date dateProduction) {
        dao.saveProd(productId,priceUnit,quantity,dateProduction);
    }
}
