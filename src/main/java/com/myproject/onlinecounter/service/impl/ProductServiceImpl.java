/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.service.impl;

import com.myproject.onlinecounter.dao.ProductDao;
import com.myproject.onlinecounter.model.Product;
import com.myproject.onlinecounter.service.ProductService;
import java.util.List;

/**
 *
 * @author 160665
 */
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    @Override
    public Product getProduct(Integer productId) {
        return productDao.getProduct(productId);
    }

    @Override
    public Integer addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
    
}
