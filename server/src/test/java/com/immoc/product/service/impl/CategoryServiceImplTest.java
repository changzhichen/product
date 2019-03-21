package com.immoc.product.service.impl;

import com.immoc.product.ProductApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.immoc.product.dataobject.ProductCategory;
import com.immoc.product.service.CategoryService;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(productCategoryList.size()>0);
    }
}