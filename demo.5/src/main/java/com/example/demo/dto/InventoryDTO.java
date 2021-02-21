package com.example.demo.dto;

import com.example.demo.enity.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    @Id
    private String id;
    @JsonProperty("item")
    private String item;
    @JsonProperty("qty")
    private int qty;
    @JsonProperty("size")
    private Size size;
    @JsonProperty("status")
    private char status;
}
