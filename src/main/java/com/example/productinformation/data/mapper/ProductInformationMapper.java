package com.example.productinformation.data.mapper;

import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.data.entity.ProductInformationEntity;

public class ProductInformationMapper implements EntityMapper<ProductInformationDto, ProductInformationEntity>{
    @Override
    public ProductInformationEntity toEntity(ProductInformationDto productInformationDto){
        ProductInformationEntity productInformationEntity = new ProductInformationEntity();
        productInformationEntity.setProductName(productInformationDto.getProductName());
        productInformationEntity.setProductPrice(productInformationDto.getProductPrice());
        productInformationEntity.setCategory(productInformationDto.getCategory());
        return productInformationEntity;
    }
}
