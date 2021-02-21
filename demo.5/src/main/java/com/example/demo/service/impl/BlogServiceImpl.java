package com.example.demo.service.impl;

import com.example.demo.collestor.Collestor;
import com.example.demo.dto.BlogDTO;
import com.example.demo.enity.Blog;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    Collestor collestor;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BlogMapper blogMapper;

    @Override
    public Map<String, String> collectRestApiParam(Map<String, String> filters) {
        Map<String, String> restApiQueries = new HashMap<>();
        collestor.collectPageFilter(restApiQueries,filters);
        collestor.collectPageSizeFilter(restApiQueries, filters);
        collestor.collectSortFilter(restApiQueries,filters);
        collestor.collectQFilter(restApiQueries, filters);
        collestor.collectSelectFilter(restApiQueries, filters);

        return restApiQueries;
    }

    @Override
    public List<BlogDTO> getAllBlogs(Map<String, String> restApi) {
        Query query = new Query();
        blogRepository.applyRestApi(query,restApi);
        List<Blog> blogList = mongoTemplate.find(query,Blog.class);
        return blogMapper.toListDTO(blogList);
    }
}
