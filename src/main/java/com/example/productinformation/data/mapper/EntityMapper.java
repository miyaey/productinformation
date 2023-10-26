package com.example.productinformation.data.mapper;

public interface EntityMapper <DTO, Entity>{
    Entity toEntity(DTO dto);
}
