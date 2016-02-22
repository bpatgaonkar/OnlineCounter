/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.dao.impl;

import com.myproject.onlinecounter.dao.OrderDao;
import com.myproject.onlinecounter.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 160665
 */
public class OrderDaoImpl implements OrderDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public Integer createOrder(Orders order) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(order);
        return id;
    }

    @Override
    public void updateOrder(Orders order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(Orders order) {
       Session session = sessionFactory.getCurrentSession();
       session.delete(order);
    }
    
}
