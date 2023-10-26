package com.example.productinformation.controller;

import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.entity.ProductInformationEntity;
import com.example.productinformation.service.ProductInformationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productinformation")
public class ProductInformationController {
    private final ProductInformationService productInformationService;
    @GetMapping
    @Operation(summary = "product 리스트", description = "product 리스트")
    public List<ProductInformationEntity> getAllProduct(){
        return productInformationService.getAllProduct();
    }

    @GetMapping("/{productId}")
    @Operation(summary = "product Id 검색", description = "product Id 검색")
    public ProductInformationEntity getProduct(@PathVariable int productId){
        return productInformationService.getProductById(productId);
    }

    @PostMapping
    @Operation(summary = "product 생성", description = "product 생성")
    public ProductInformationEntity createProduct(@RequestBody ProductInformationDto productInformationDto){
        return productInformationService.createProduct(productInformationDto);
    }

    @PutMapping("/{productId}")
    @Operation(summary = "product 수정", description = "product 수정")
    public ProductInformationEntity updateProduct(@PathVariable int productId, @RequestBody ProductInformationDto productInformationDto){
        return productInformationService.updateProduct(productId, productInformationDto);
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "product 삭제", description = "product 삭제")
    public void deleteProduct(@PathVariable int productId){
        productInformationService.deleteProduct(productId);
    }

    @GetMapping("/productName/{keyword}")
    @Operation(summary = "상품명 검색", description = "상품명 검색")
    public List<ProductInformationEntity> findByProductNameContaining(@PathVariable String keyword){
        return productInformationService.findByProductNameContaining(keyword);
    }


    @GetMapping("/lessThan/{value}")
    @Operation(summary = "검색조건 기준가 이하", description = "검색조건 기준가 이하")
    public List<ProductInformationEntity> findByProductPriceLessThan(@PathVariable int value){
        return productInformationService.findByProductPriceLessThan(value);
    }

    @GetMapping("/greaterThan/{value}")
    @Operation(summary = "검색조건 기준가 이상", description = "검색조건 기준가 이상")
    public List<ProductInformationEntity> findByProductPriceGreaterThan(@PathVariable int value){
        return productInformationService.findByProductPriceGreaterThan(value);
    }

    @GetMapping("/{value1}/{value2}")
    @Operation(summary = "검색조건 기준가1, 기준가2 사이", description = "검색조건 기준가1, 기준가2 사이")
    public List<ProductInformationEntity> findByProductPriceBetween(@PathVariable int value, int value2){
        return productInformationService.findByProductPriceBetween(value, value2);
    }
}
