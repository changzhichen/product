package com.immoc.product.VO;

import lombok.Data;

/**
 * @ClassName ResultVo
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 14:18
 * @Version 1.0
 */
@Data
public class ResultVo<T> {
    private String code;
    private String msg;
    private T data;
}
