/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.onlinecounter.test;

import com.myproject.onlinecounter.controller.ProductController;
import com.myproject.onlinecounter.dao.CategoryDao;
import com.myproject.onlinecounter.dao.OrderDao;
import com.myproject.onlinecounter.dao.ProductDao;
import com.myproject.onlinecounter.model.Category;
import com.myproject.onlinecounter.model.Orderitem;
import com.myproject.onlinecounter.model.Orders;
import com.myproject.onlinecounter.model.Product;
import com.myproject.onlinecounter.service.ProductService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations ={"classpath:/applicationContext.xml"})
@Transactional
/**
 *
 * @author Patgaonkar
 */
public class OnlineCounterTest {
    @Autowired
    ProductController productController;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    OrderDao orderDao;
    private MockMvc mockMvc;
    
    Logger log = Logger.getLogger(OnlineCounterTest.class);
    
    public OnlineCounterTest() {
    }
  
    //@Before
    public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }    
    
   // @Test
    public void testGetProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/1")).andExpect(MockMvcResultMatchers.status().isOk())
                ;//.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    //@Test
    public void testCategory(){
        Assert.assertNotNull(categoryDao);
        Category catA = new Category();
        catA.setCategoryid(1);
        catA.setDescription("Category A");
        catA.setTax(10);
        
        Integer catId = categoryDao.addCategory(catA);
        Assert.assertEquals(new Integer(1), catId);
        
        Assert.assertNotNull(productService);
        Product product=new Product();
        product.setProductid(new Integer(1));
        product.setCategory(catA);
        product.setPrice(100);
        product.setDescription("Toys");
        Integer prodId = productService.addProduct(product);
        
        Assert.assertEquals(new Integer(1), prodId);
        
        Assert.assertNotNull(orderDao);
        
        Orders order = new Orders();
        order.setOrderid(new Integer(1));
        
        Orderitem item1 = new Orderitem();
        item1.setItemid(new Integer(1));
        item1.setOrderid(order.getOrderid());
        item1.setProductid(prodId);
        item1.setQuantity(1);
        
        Integer orderId = orderDao.createOrder(order);
        Assert.assertEquals(new Integer(1), orderId);
        
    }    
    //@Test
    public void testConfiguration(){
        Assert.assertNotNull(productService);
        Product product = productService.getProduct(new Integer(1));
        Assert.assertNotNull(product);
        log.debug(product.getCategory().getDescription());
    }
}
