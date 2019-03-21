package com.immoc.product.repository;

import com.immoc.product.ProductApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.immoc.product.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductCategoryRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList= productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(productCategoryList.size()>0);
    }
}