package com.example.demo.dto.nested;

import com.example.demo.dto.InventoryDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryNestedDTO extends InventoryDTO {
    @JsonProperty("h")
    private int h;
    @JsonProperty("w")
    private int w;
    @JsonProperty("uom")
    private String uom;
}
