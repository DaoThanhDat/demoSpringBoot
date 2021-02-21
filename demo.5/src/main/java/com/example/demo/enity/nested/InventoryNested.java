package com.example.demo.enity.nested;

import com.example.demo.enity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryNested extends Inventory {
    @Field("h")
    private int h;
    @Field("w")
    private int w;
    @Field("uom")
    private String uom;
}
