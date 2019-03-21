package com.immoc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MsgController
 * @Description
 * @Author changzhichen
 * @Date 2019-03-03 21:11
 * @Version 1.0
 */
@RestController
public class MsgController {


    @GetMapping("/getMsg")
    public String msg(){
        return "this is product's msg";
    }
}
