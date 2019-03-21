package com.immoc.product.client;

import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @ClassName ProductClient
 * @Description
 * @Author changzhichen
 * @Date 2019-02-14 16:28
 * @Version 1.0
 */
// 应用名称区分大小写
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/getMsg")
    String msg();

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> findByProductIdIn(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    int decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);
}
