package com.immoc.product.service.impl;

import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import com.immoc.product.dataobject.ProductInfo;
import com.immoc.product.enums.ProductStatusEnums;
import com.immoc.product.exception.ProductException;
import com.immoc.product.repository.ProductInfoRepository;
import com.immoc.product.service.ProductService;
import com.immoc.product.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 13:45
 * @Version 1.0
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public List<ProductInfoOutput> findByProductIdIn(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e->{
                    ProductInfoOutput productInfoOutput=new ProductInfoOutput();
                    BeanUtils.copyProperties(e,productInfoOutput);
                    return productInfoOutput;
                }).collect(Collectors.toList());
    }

    /**
     * @Author changzhichen
     * @Description 扣库存
     * @Date 09:34 2019-02-15
     * @Param [cartDTOList]
     * @Return int
     **/
    @Override
    @Transactional
    public int decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            if (!productInfoOptional.isPresent()) {
                log.info("【商品不存在】，productId={}", decreaseStockInput.getProductId());
                throw new ProductException(ProductStatusEnums.PRODUCT_NOT_EXISTED);
            }
            ProductInfo productInfo = productInfoOptional.get();
            // 判断库存是否足够
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                log.info("【商品库存不足】，productId={}", decreaseStockInput.getProductId());
                throw new ProductException(ProductStatusEnums.PRODUCT_LOW_STOCK);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
        return 1;
    }
}
