package com.immoc.product.service;

import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import com.immoc.product.dataobject.ProductInfo;
import com.immoc.product.dto.CartDTO;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();
    List<ProductInfoOutput> findByProductIdIn(List<String> productIdList);
    /**
    * @Author changzhichen
    * @Description 扣库存
    * @Date 09:26 2019-02-15
    * @Param [cartDTOList]
    * @Return int
    **/
    int decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
