package com.example.demo.service;

import com.example.demo.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getListInventory();

    List<InventoryDTO> getByHeight(String uom);
}