package com.example.demo.mapper;

import com.example.demo.dto.BlogDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.enity.Blog;
import com.example.demo.enity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class BlogMapper implements BaseMapper<BlogDTO, Blog> {
    @Override
    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_STRING_TO_OBJECT_ID"),
            @Mapping(source = "title", target = "title")
    })
    @InheritConfiguration
    @Named("blogToEntity")
    public abstract Blog toEntity(BlogDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "id", qualifiedByName = "CONVERT_OBJECT_ID_TO_STRING"),
            @Mapping(source = "title", target = "title")
    })
    @InheritConfiguration
    @Named("blogToDTO")
    public abstract BlogDTO toDTO(Blog entity);

    @Override
    @IterableMapping(qualifiedByName = "blogToDTO")
    public abstract List<BlogDTO> toListDTO(List<Blog> entityList);

    @Override
    @IterableMapping(qualifiedByName = "blogToEntity")
    public abstract List<Blog> toListEntity(List<BlogDTO> dtoList);
}
