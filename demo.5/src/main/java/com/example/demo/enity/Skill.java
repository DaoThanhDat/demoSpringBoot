package com.example.demo.enity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Skill {
    @Field("language")
    private String language;

    @Field("level")
    private int level;

    @Field("exp")
    private int exp;
}
