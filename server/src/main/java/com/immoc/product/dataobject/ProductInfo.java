package com.immoc.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ClassName ProductInfo
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 11:21
 * @Version 1.0
 */
@Data
@Entity
//@Table(name="t_xx")
public class ProductInfo {
    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private Integer categoryType;
    private Integer productStatus;
}
