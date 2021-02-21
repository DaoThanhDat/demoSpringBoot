package com.example.demo.service;

import com.example.demo.dto.BlogDTO;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Map<String, String> collectRestApiParam(Map<String, String> filters);

    List<BlogDTO> getAllBlogs(Map<String, String> restApi);
}
