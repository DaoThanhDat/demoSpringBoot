package com.example.demo.repository.impl;

import com.example.demo.repository.BlogRepositoryCustom;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.Map;

@Repository
public class BlogRepositoryImpl implements BlogRepositoryCustom {
    @Override
    public void collectPageFilter(Map<String, String> restApiQueries, Map<String, String> filters) {
        if (filters.containsKey("page")) {
            restApiQueries.put("page", filters.get("page"));
        }
    }

    @Override
    public void applyRestApi(Query query, Map<String, String> restApi) {
        applyPageQueryParam(query, restApi);
        applySelectQueryParam(query,restApi);
        applyPageSizeQueryParam(query,restApi);
        applySortQueryParam(query,restApi);
        applyPageQueryParam(query,restApi);

    }

    @Override
    public void applyPageSizeQueryParam(Query query, Map<String, String> restApi) {
        try {
            if (restApi.get("pageSize") != null) {
                String pageSizeQueryParam = restApi.get("pageSize");
                int limit = Integer.parseInt(pageSizeQueryParam);
                if (limit < 0) {
                    throw new NumberFormatException();
                }
                query.limit(limit);
            }
        } catch (NumberFormatException pageParamExc) {
            System.out.println("nan");
        }
    }

    @Override
    public void applySortQueryParam(Query query, Map<String, String> restApi) {
//        try {
//            if (restApi.get("sort") != null) {
//                String sortQueryParam = restApi.get("sort");
//                Direction sortDir =
//                        sortQueryParam.substring(0, 1).equals("-") ? Direction.DESC : Direction.ASC;
//                String sortBy = sortDir.equals(Direction.DESC) ? sortQueryParam.substring(1)
//                        : sortQueryParam;
//                query.with(new Sort(sortDir, sortBy));
//            }
//        } catch (IndexOutOfBoundsException subStringException) {
//            throw new WrongQueryParam();
//        }
    }

    @Override
    public void applySelectQueryParam(Query query, Map<String, String> restApi) {
        if (restApi.get("select") != null) {
            String[] selectedFields = restApi.get("select").split(",");
            for (String selectedField : selectedFields) {
                query.fields().include(selectedField);
            }
        }
    }

    @Override
    public void applySearchQueryParam(Query query, Map<String, String> restApi) {
//        try {
//            if (restApi.get("q") != null) {
//                JSONObject jsonCriteria = new JSONObject(restApi.get("q"));
//                JSONArray keys = jsonCriteria.names();
//                for (int i = 0; i < keys.length(); ++i) {
//                    String field = keys.getString(i);
//                    String value = jsonCriteria.getString(field);
//                    query.addCriteria(Criteria.where(field).is(value));
//                }
//            }
//        } catch (JSONException e) {
//            throw new WrongQueryParam("Your JSON format is wrong");
//        }
    }

    public void applyPageQueryParam(Query query, Map<String, String> restApi) {
        try {
            if (restApi.get("page") != null) {
                String pageQueryParam = restApi.get("page");
                long skip = Long.parseLong(pageQueryParam);
                if (skip < 0) {
                    throw new NumberFormatException();
                }
                query.skip(skip);
            }
        } catch (NumberFormatException pageParamExc) {
            System.out.println("nan");
        }
    }
}
