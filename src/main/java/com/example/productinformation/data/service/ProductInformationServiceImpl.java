package com.example.productinformation.data.service;

import com.example.productinformation.Repository.ProductInformationRepository;
import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.data.entity.ProductInformationEntity;
import com.example.productinformation.data.mapper.ProductInformationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProductInformationEntity> findByNameContaining(String keyword) {
        return productInformationRepository.findByProductNameContaining(keyword);
    }

    @Override
    public List<ProductInformationEntity> findByPriceLessThan(int value) {
        return productInformationRepository.findByPriceLessThan(value);
    }

    @Override
    public List<ProductInformationEntity> findByPriceGreaterThan(int value) {
        return productInformationRepository.findByPriceGreaterThan(value);
    }

    @Override
    public List<ProductInformationEntity> findByPriceBetween(int value1, int value2) {
        return productInformationRepository.findByPriceBetween(value1, value2);
    }

}
