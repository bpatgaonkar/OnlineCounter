/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.controller;

import com.myproject.onlinecounter.model.Product;
import com.myproject.onlinecounter.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author 160665
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/list", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProduct(ModelMap model) {
        return productService.getAllProducts();
    }
    @RequestMapping(value="/{productId}",produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable String productId) {
        System.out.println("++++ productid "+productId);
        System.out.println("++++ productService "+productService);
        return productService.getProduct(Integer.valueOf(productId));
    }    
}
