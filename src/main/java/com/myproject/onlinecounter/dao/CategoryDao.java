/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.dao;

import com.myproject.onlinecounter.model.Category;
import java.util.List;

/**
 *
 * @author 160665
 */
public interface CategoryDao {
    public Integer addCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategory(Integer categoryId);
    public void updateCategory(Category category);
    public void deleteCategory(Category category); 
}
