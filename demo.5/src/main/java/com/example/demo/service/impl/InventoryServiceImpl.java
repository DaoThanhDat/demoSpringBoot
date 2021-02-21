package com.example.demo.service.impl;

import com.example.demo.dto.InventoryDTO;
import com.example.demo.enity.Inventory;
import com.example.demo.mapper.InventoryMapper;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public List<InventoryDTO> getListInventory() {
        List<Inventory> list = inventoryRepository.findAll();
        return inventoryMapper.toListDTO(list);
    }

    @Override
    public List<InventoryDTO> getByHeight(String uom) {
        List<Inventory> list = inventoryRepository.findByHeight(uom);
        return inventoryMapper.toListDTO(list);
    }

}
