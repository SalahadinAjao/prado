package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.common.BaseController;
import org.prado.entity.AddressEntity;
import org.prado.service.AddressService;
import org.prado.tools.CharTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houlintao
 * @Date:2020/7/2 下午1:33
 * @email 437547058@qq.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    public Object saveAddress(String username,String password){
        JSONObject jsonRequest = getJsonRequest();
        String userName = jsonRequest.getString("userName");
        String teleNumber = jsonRequest.getString("teleNumber");
        String postalCode = jsonRequest.getString("postalCode");
        String nationalCode = jsonRequest.getString("nationalCode");
        String provinceName = jsonRequest.getString("provinceName");
        String cityName = jsonRequest.getString("cityName");
        String countyName = jsonRequest.getString("countyName");
        String detailInfo = jsonRequest.getString("detailInfo");

        //使用随机字符串模拟用户id
        String randomNumStr = CharTool.getRandomNumStr(4);

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUserId(Long.parseLong(randomNumStr));
        addressEntity.setUserName(userName);
        addressEntity.setTelNumber(teleNumber);
        addressEntity.setPostalCode(postalCode);
        addressEntity.setNationalCode(nationalCode);
        addressEntity.setProvinceName(provinceName);
        addressEntity.setCityName(cityName);
        addressEntity.setCountyName(countyName);
        addressEntity.setDetailInfo(detailInfo);

        addressService.save(addressEntity);

        return toResponsSuccess("Sucess");
    }

   /* *//**
     * 获取用户的收货地址
     *//*
    @PostMapping("/addresslist")
    public Object getUserAddressList(){

    }*/
}
