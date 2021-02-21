package com.example.demo.controller;

import com.example.demo.dto.InventoryDTO;
import com.example.demo.dto.nested.InventoryNestedDTO;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventory")
    public ResponseEntity<?> getListInventory() {
        List<InventoryDTO> list = inventoryService.getListInventory();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/inventory/{uom}")
    public ResponseEntity<?> getByHeight(@PathVariable("uom") String uom) {
        List<InventoryDTO> list= inventoryService.getByHeight(uom);
        return ResponseEntity.ok(list);
    }

}
