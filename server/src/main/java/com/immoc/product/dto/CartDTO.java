package com.immoc.product.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description
 * @Author changzhichen
 * @Date 2019-02-15 09:20
 * @Version 1.0
 */
@Data
public class CartDTO {
    // 商品id
    private String productId;
    // 购买数量
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }


}
