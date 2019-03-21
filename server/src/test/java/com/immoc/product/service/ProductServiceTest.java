package com.immoc.product.service;

import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import com.immoc.product.ProductApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.immoc.product.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfoOutput> productInfoList = productService.findByProductIdIn(Arrays.asList("1", "2"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception {
        int result = productService.decreaseStock(Arrays.asList(new DecreaseStockInput("1", 1), new DecreaseStockInput("2", 1)));
        Assert.assertTrue(result > 0);
    }
}