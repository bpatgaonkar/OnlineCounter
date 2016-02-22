/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.onlinecounter.dao;

import com.myproject.onlinecounter.model.Orders;

/**
 *
 * @author 160665
 */
public interface OrderDao {
    public Integer createOrder(Orders order);
    public void updateOrder(Orders order);
    public void deleteOrder(Orders order);
}
