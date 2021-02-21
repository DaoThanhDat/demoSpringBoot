package com.example.demo.collestor;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Collestor {
    public void collectPageFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("page")) {
            restApiQueries.put("page", filters.get("page"));
        }
    }

    public void collectPageSizeFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("pageSize")) {
            restApiQueries.put("pageSize", filters.get("pageSize"));
        }
    }

    public void collectSortFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("sort")) {
            restApiQueries.put("sort", filters.get("sort"));
        }
    }

    public void collectQFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("query")) {
            restApiQueries.put("query", filters.get("query"));
        }
    }

    public void collectSelectFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("select")) {
            restApiQueries.put("select", filters.get("select"));
        }
    }
}
