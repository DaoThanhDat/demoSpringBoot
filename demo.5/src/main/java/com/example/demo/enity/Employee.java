package com.example.demo.enity;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Employee {
    private ObjectId id;
    private String name;
    private String age;
    private String userName;
    private String password;
}
