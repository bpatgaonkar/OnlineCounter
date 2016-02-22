/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.dao.impl;

import com.myproject.onlinecounter.dao.CategoryDao;
import com.myproject.onlinecounter.model.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 160665
 */
public class CategoryDaoImpl implements CategoryDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Integer addCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(category);
        return id;
    }

    @Override
    public List<Category> getAllCategories() {
       Session session = sessionFactory.getCurrentSession();
       return session.createCriteria(Category.class).list();
    }

    @Override
    public Category getCategory(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        return (Category) session.createCriteria(Category.class)
                .add(Restrictions.eq("categoryid", categoryId)).uniqueResult();
    }

    @Override
    public void updateCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public void deleteCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }
    
}
