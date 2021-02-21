package com.example.demo.repository.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> customMethod() {
        Query query = new Query();
        return mongoTemplate.find(query, User.class);

    }

    @Override
    public UserDTO getUserById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        User user = mongoTemplate.findOne(query, User.class);
        return userMapper.toDTO(user);
    }

    @Override
    public void update(String id, User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        
        update.set("name", user.getName());
        update.set("email", user.getEmail());
        update.set("password", user.getPassword());
        mongoTemplate.updateFirst(query, update, User.class);
    }

    @Override
    public List<User> findByLanguage(String lang, int level) {
        Query query = new Query();
        query.addCriteria(Criteria.where("skill").elemMatch(Criteria.where("language").is(lang).and("level").is(level)));
        return mongoTemplate.find(query,User.class);
    }
}
