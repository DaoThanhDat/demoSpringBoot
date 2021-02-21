package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    @Field("h")
    private int h;
    @Field("w")
    private int w;
    @Field("uom")
    private String uom;

}
