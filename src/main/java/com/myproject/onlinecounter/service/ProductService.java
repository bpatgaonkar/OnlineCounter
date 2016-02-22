/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.service;

import com.myproject.onlinecounter.model.Product;
import java.util.List;

/**
 *
 * @author 160665
 */
public interface ProductService {
    public Product getProduct(Integer productId);
    public Integer addProduct(Product product);
    public void updateProduct(Product product);
    public List<Product> getAllProducts();
    public void deleteProduct(Product product);    
}
