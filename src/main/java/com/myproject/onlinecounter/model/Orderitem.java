package com.myproject.onlinecounter.model;
// Generated Feb 21, 2016 10:19:27 PM by Hibernate Tools 4.3.1



/**
 * Orderitem generated by hbm2java
 */
public class Orderitem  implements java.io.Serializable {


     private int itemid;
     private Integer orderid;
     private Integer productid;
     private Integer quantity;

    public Orderitem() {
    }

	
    public Orderitem(int itemid) {
        this.itemid = itemid;
    }
    public Orderitem(int itemid, Integer orderid, Integer productid, Integer quantity) {
       this.itemid = itemid;
       this.orderid = orderid;
       this.productid = productid;
       this.quantity = quantity;
    }
   
    public int getItemid() {
        return this.itemid;
    }
    
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    public Integer getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    public Integer getProductid() {
        return this.productid;
    }
    
    public void setProductid(Integer productid) {
        this.productid = productid;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}


