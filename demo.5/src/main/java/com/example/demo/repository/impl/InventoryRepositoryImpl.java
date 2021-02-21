package com.example.demo.repository.impl;

import com.example.demo.enity.Inventory;
import com.example.demo.repository.InventoryRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class InventoryRepositoryImpl implements InventoryRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Inventory> findByHeight(String uom) {
        Query query = new Query();
        query.addCriteria(Criteria.where("size.uom").is(uom));
        return mongoTemplate.find(query, Inventory.class);
    }
}
