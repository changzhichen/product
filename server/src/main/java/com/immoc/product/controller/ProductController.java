package com.immoc.product.controller;

import com.immoc.product.VO.ProductInfoVo;
import com.immoc.product.VO.ProductVo;
import com.immoc.product.VO.ResultVo;
import com.immoc.product.common.DecreaseStockInput;
import com.immoc.product.common.ProductInfoOutput;
import com.immoc.product.dataobject.ProductCategory;
import com.immoc.product.dataobject.ProductInfo;
import com.immoc.product.dto.CartDTO;
import com.immoc.product.service.CategoryService;
import com.immoc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ProductController
 * @Description
 * @Author changzhichen
 * @Date 2019-02-13 11:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * @Author changzhichen
     * @Description 1、查询在架商品
     * 2、获取类目type列表
     * 3、查询类目
     * 4、构造数据
     * @Date 11:14 2019-02-13
     * @Param []
     * @Return void
     **/
    @RequestMapping("/list")
    public ResultVo<ProductVo> list() {
        // 查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 获取所有类目
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        // 从数据库中查询条目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        // 构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        ResultVo resultVo = new ResultVo();
        resultVo.setCode("0");
        resultVo.setMsg("成功");
        resultVo.setData(productVoList);
        return resultVo;
    }

    /**
     * @Author changzhichen
     * @Description 获取商品列表（供订单服务用）
     * @Date 16:11 2019-02-14
     * @Param [productIdList]
     * @Return java.util.List<ProductInfo>
     **/
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findByProductIdIn(productIdList);
    }

    /**
     * @Author changzhichen
     * @Description 扣库存
     * @Date 09:58 2019-02-15
     * @Param [cartDTOList]
     * @Return int
     **/
    @PostMapping("/decreaseStock")
    public int decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        return productService.decreaseStock(decreaseStockInputList);
    }
}

