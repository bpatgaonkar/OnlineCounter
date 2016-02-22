package com.myproject.onlinecounter.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate3.Hibernate3Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
    @Autowired
    SessionFactory sessionFactory;
	
    public HibernateAwareObjectMapper() {
        Hibernate3Module hm = new Hibernate3Module();
        //disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        registerModule(hm);
    }
    
}