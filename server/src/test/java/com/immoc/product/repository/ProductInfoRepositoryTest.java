package com.immoc.product.repository;

import com.immoc.product.ProductApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.immoc.product.dataobject.ProductInfo;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductInfoRepositoryTest extends ProductApplicationTests {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList= productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void findByProductIdIn(){
        List<ProductInfo> productInfoList=productInfoRepository.findByProductIdIn(Arrays.asList("1","2"));
        Assert.assertTrue(productInfoList.size()>0);
    }
}