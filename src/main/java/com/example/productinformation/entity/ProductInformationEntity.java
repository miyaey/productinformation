package com.example.productinformation.entity;

import com.example.productinformation.data.category.Category;
import com.example.productinformation.data.dto.ProductInformationDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "productinformation")
public class ProductInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productPrice;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "category")
    private Category category;

    public ProductInformationDto toDto(){
        return ProductInformationDto.builder()
                .productName(productName)
                .productPrice(productPrice)
                .category(category)
                .build();
    }
}
