package com.example.productinformation.service;

import com.example.productinformation.Repository.ProductInformationRepository;
import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.entity.ProductInformationEntity;
import com.example.productinformation.mapper.ProductInformationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductInformationServiceImpl implements ProductInformationService{
    private final ProductInformationRepository productInformationRepository;
    private final ProductInformationMapper productInformationMapper;
    @Autowired
    public ProductInformationServiceImpl(ProductInformationRepository productInformationRepository, ProductInformationMapper productInformationMapper){
        this.productInformationRepository = productInformationRepository;
        this.productInformationMapper = productInformationMapper;
    }
    @Override
    public ProductInformationEntity createProduct(ProductInformationDto productInformationDto){
        ProductInformationEntity productInformationEntity = productInformationMapper.toEntity(productInformationDto);
        log.info("productDto : {}", productInformationDto);
        return productInformationRepository.save(productInformationEntity);
    }

    @Override
    public List<ProductInformationEntity> getAllProduct(){
        return productInformationRepository.findAll();
    }

    @Override
    public ProductInformationEntity getProductById(int productId){
        return productInformationRepository.findById(productId).orElse(null);
    }

    @Override
    public ProductInformationEntity updateProduct(int productId, ProductInformationDto productInformationDto){
        ProductInformationEntity existProduct = productInformationRepository.findById(productId).orElse(null);
        if (existProduct !=null){
            ProductInformationEntity updateProduct = productInformationMapper.toEntity(productInformationDto);
            updateProduct.setProductId(productId);
            return productInformationRepository.save(updateProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(int productId){
        productInformationRepository.deleteById(productId);
    }

    @Override
    public List<ProductInformationEntity> findByProductNameContaining(String keyword) {
        return productInformationRepository.findByProductNameContaining(keyword);
    }

    @Override
    public List<ProductInformationEntity> findByProductPriceLessThan(int value) {
        return productInformationRepository.findByProductPriceLessThan(value);
    }

    @Override
    public List<ProductInformationEntity> findByProductPriceGreaterThan(int value) {
        return productInformationRepository.findByProductPriceGreaterThan(value);
    }

    @Override
    public List<ProductInformationEntity> findByProductPriceBetween(int value1, int value2) {
        return productInformationRepository.findByProductPriceBetween(value1, value2);
    }

}
