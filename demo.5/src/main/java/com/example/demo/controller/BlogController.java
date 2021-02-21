package com.example.demo.controller;

import com.example.demo.dto.BlogDTO;
import com.example.demo.enity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public List<BlogDTO> getAllBlog(@RequestParam Map<String, String> filters) {
        Map<String, String> restApi = blogService.collectRestApiParam(filters);
        return blogService.getAllBlogs(restApi);
    }
}
