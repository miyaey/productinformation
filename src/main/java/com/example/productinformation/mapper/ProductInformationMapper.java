package com.example.productinformation.mapper;

import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.entity.ProductInformationEntity;
import org.springframework.stereotype.Component;

@Component
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
