package com.gestiune.controller;

import com.gestiune.model.ProductEntry;
import com.gestiune.service.ProductEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by sdonose on 2/22/2016.
 */

@Controller
@RequestMapping("/")
public class ProductEntryController {

    @Autowired
    private ProductEntryService productEntryService;

    @RequestMapping(value = "/getAllProductEntry", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ProductEntry> listProductEntry(ModelMap model) {
        List<ProductEntry> productEntryList = productEntryService.findAllProductsEntry();
        model.addAttribute("productEntryList", productEntryList);
        return productEntryList;
    }

    @RequestMapping(value = "/newProductEntry", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveProduct(@RequestBody ProductEntry productEntry) {

        this.productEntryService.saveProductEntry(productEntry);
        return true;
    }

    @RequestMapping(value = "/productEntry/{productId}", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    boolean saveProductId(@PathVariable int productId, @RequestBody double priceUnit, int quantity, Date dateProduction) {
       this. productEntryService.saveProd(productId,priceUnit,quantity,dateProduction);
        return true;

    }
}


