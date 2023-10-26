package com.example.productinformation.mapper;

public interface EntityMapper <DTO, Entity>{
    Entity toEntity(DTO dto);
}
