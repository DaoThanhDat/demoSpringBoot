package com.example.demo.mapper;

import com.example.demo.dto.nested.InventoryNestedDTO;
import com.example.demo.enity.nested.InventoryNested;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = { CommonMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class InventoryNestedMapper implements BaseMapper<InventoryNestedDTO, InventoryNested> {
    @Mappings({
            @Mapping(source = "id",target = "id",qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID"),
            @Mapping(source = "item",target = "item")
    })
    @InheritConfiguration
    @Named("inventoryNestedToEntity")
    public abstract InventoryNested toEntity(InventoryNestedDTO dto);


    @Mappings({
            @Mapping(source = "id",target = "id",qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING"),
            @Mapping(source = "item",target = "item")
    })
    @InheritConfiguration
    @Named("inventoryNestedToDTO")
    public abstract InventoryNestedDTO toDTO(InventoryNested entity);

    @IterableMapping(qualifiedByName = "inventoryNestedDTO")
    public abstract List<InventoryNestedDTO> toListDTO(List<InventoryNested> entityList);

    @IterableMapping(qualifiedByName = "inventoryNestedToEntity")
    public abstract List<InventoryNested> toListEntity(List<InventoryNestedDTO> dtoList);
}
