package com.example.demo.repository;


import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;

public interface BlogRepositoryCustom {
    void collectPageFilter(Map<String, String> restApiQueries, Map<String, String> filters);

    void applyPageQueryParam(Query query, Map<String, String> restApi);

    void applyPageSizeQueryParam(Query query, Map<String, String> restApi);

    void applySortQueryParam(Query query, Map<String, String> restApi);

    void applySelectQueryParam(Query query, Map<String, String> restApi);

    void applySearchQueryParam(Query query, Map<String, String> restApi);

    void applyRestApi(Query query, Map<String, String> restApi);
}
