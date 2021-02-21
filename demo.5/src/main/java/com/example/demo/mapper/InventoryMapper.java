package com.example.demo.mapper;

import com.example.demo.dto.InventoryDTO;
import com.example.demo.enity.Inventory;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class InventoryMapper implements BaseMapper<InventoryDTO, Inventory> {
    @Mappings({
            @Mapping(source = "id",target = "id",qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID"),
            @Mapping(source = "item",target = "item")
    })
    @InheritConfiguration
    @Named("inventoryToEntity")
    public abstract Inventory toEntity(InventoryDTO dto);


    @Mappings({
            @Mapping(source = "id",target = "id",qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING"),
            @Mapping(source = "item",target = "item")
    })
    @InheritConfiguration
    @Named("inventoryToDTO")
    public abstract InventoryDTO toDTO(Inventory entity);

    @IterableMapping(qualifiedByName = "inventoryDTO")
    public abstract List<InventoryDTO> toListDTO(List<Inventory> entityList);

        @IterableMapping(qualifiedByName = "inventoryToEntity")
    public abstract List<Inventory> toListEntity(List<InventoryDTO> dtoList);
}