package com.example.productinformation.data.dto;

import com.example.productinformation.data.category.Category;
import com.example.productinformation.entity.ProductInformationEntity;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductInformationDto {
    @NotNull(message = "이름은 필수 항목입니다")
    private String productName;

    @Min(value = 1000, message = "가격은 1000원 이상 이어야 합니다")
    @Max(value = 1000000, message = "가격은 100만원 이하 이어야 합니다")
    private String productPrice;

    private Category category;

    public ProductInformationEntity toEntity(){
        return ProductInformationEntity.builder()
                .productName(productName)
                .productPrice(productPrice)
                .category(category)
                .build();
    }
}
