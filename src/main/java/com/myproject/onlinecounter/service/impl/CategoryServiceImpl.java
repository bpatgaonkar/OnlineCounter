/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.service.impl;

import com.myproject.onlinecounter.dao.CategoryDao;
import com.myproject.onlinecounter.model.Category;
import com.myproject.onlinecounter.service.CategoryService;
import java.util.List;

/**
 *
 * @author 160665
 */
public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao;

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    
    @Override
    public Integer addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Category getCategory(Integer categoryId) {
        return categoryDao.getCategory(categoryId);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }
    
}
