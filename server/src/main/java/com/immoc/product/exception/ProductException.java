package com.immoc.product.exception;

import com.immoc.product.enums.ProductStatusEnums;
import lombok.Data;

/**
 * @ClassName ProductException
 * @Description
 * @Author changzhichen
 * @Date 2019-02-15 09:32
 * @Version 1.0
 */
@Data
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException() {
    }

    public ProductException(ProductStatusEnums productStatusEnums) {
        super(productStatusEnums.getMsg());
        this.code = productStatusEnums.getCode();
    }
}
