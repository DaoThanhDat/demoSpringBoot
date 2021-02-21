package com.example.demo.repository;

import com.example.demo.enity.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, ObjectId>,BlogRepositoryCustom {
}
