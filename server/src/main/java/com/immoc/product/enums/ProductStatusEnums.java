package com.immoc.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnums {
    UP(0,"上架"),
    DOWN(1,"下架"),
    PRODUCT_NOT_EXISTED(2,"商品不存在"),
    PRODUCT_LOW_STOCK(3,"商品库存不足"),
    ;
    private Integer code;
    private String msg;

    ProductStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
