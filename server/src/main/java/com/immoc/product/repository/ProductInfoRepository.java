package com.immoc.product.repository;

import com.immoc.product.common.ProductInfoOutput;
import com.immoc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 11:40
 * @Version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

     List<ProductInfo> findByProductStatus(Integer productStatus);

     List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
