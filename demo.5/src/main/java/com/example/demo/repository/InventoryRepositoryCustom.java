package com.example.demo.repository;

import com.example.demo.enity.Inventory;

import java.util.List;

public interface InventoryRepositoryCustom {
    List<Inventory> findByHeight(String uom);
}
