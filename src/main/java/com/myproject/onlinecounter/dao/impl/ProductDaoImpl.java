/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.onlinecounter.dao.impl;

import com.myproject.onlinecounter.dao.ProductDao;
import com.myproject.onlinecounter.model.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Patgaonkar
 */
public class ProductDaoImpl implements ProductDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getProduct(Integer productId) {
       Session session = sessionFactory.getCurrentSession();
       Product product = (Product)session.load(Product.class, productId);
       return product;
    }

    @Override
    public Integer addProduct(Product product) {
       Session session = sessionFactory.getCurrentSession();
       Integer id = (Integer) session.save(product);
       return id;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).list();
    }

    @Override
    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }
    
}
