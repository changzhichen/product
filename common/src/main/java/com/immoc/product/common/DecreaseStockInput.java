package com.immoc.product.common;

import lombok.Data;

/**
 * @ClassName DecreaseStockInput
 * @Description
 * @Author changzhichen
 * @Date 2019-02-15 15:25
 * @Version 1.0
 */
@Data
public class DecreaseStockInput {
    // 商品id
    private String productId;
    // 购买数量
    private Integer productQuantity;

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public DecreaseStockInput() {
    }
}
