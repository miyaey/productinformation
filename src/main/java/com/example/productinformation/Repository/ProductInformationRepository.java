package com.example.productinformation.Repository;

import com.example.productinformation.data.entity.ProductInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInformationRepository extends JpaRepository<ProductInformationEntity, Integer> {
    List<ProductInformationEntity> findByProductNameContaining(String keyword);
    List<ProductInformationEntity> findByPriceLessThan(int value);
    List<ProductInformationEntity> findByPriceGreaterThan(int value);
    List<ProductInformationEntity> findByPriceBetween(int value1, int value2);
}
