package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.enity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper implements BaseMapper<UserDTO, User> {
    @Override
    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID"),
            @Mapping(source = "name", target = "name")
    })
    @InheritConfiguration
    @Named("userToEntity")
    public abstract User toEntity(UserDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING"),
            @Mapping(source = "name", target = "name")
    })
    @InheritConfiguration
    @Named("userToDTO")
    public abstract UserDTO toDTO(User entity);

    @Override
    @IterableMapping(qualifiedByName = "userToDTO")
    public abstract List<UserDTO> toListDTO(List<User> entityList);

    @Override
    @IterableMapping(qualifiedByName = "userToEntity")
    public abstract List<User> toListEntity(List<UserDTO> dtoList);

}
