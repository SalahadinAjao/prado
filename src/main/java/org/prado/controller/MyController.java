package org.prado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: houlintao
 * @Date:2020/7/2 上午7:52
 * @email 437547058@qq.com
 * @Version 1.0
 */

@RestController
@RequestMapping("/my")
public class MyController {
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
