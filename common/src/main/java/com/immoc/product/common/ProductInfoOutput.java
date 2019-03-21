package com.immoc.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName ProductInfo
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 11:21
 * @Version 1.0
 */
@Data
//@Table(name="t_xx")
public class ProductInfoOutput {
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private Integer categoryType;
    private Integer productStatus;
}
