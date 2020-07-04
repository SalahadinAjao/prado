package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.annotation.CurrentLoginUser;
import org.prado.common.BaseController;
import org.prado.entity.AddressEntity;
import org.prado.entity.UserVo;
import org.prado.service.AddressService;
import org.prado.tools.CharTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

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
    public Object saveAddress(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();

        AddressEntity addressEntity = new AddressEntity();
        if (jsonRequest != null) {
            addressEntity.setId(jsonRequest.getLong("id"));
            addressEntity.setUserId(loginUser.getUserId());

            System.out.println("userId = " + loginUser.getUserId());

            addressEntity.setUserName(jsonRequest.getString("userName"));
            addressEntity.setPostalCode(jsonRequest.getString("postalCode"));
            addressEntity.setProvinceName(jsonRequest.getString("provinceName"));
            addressEntity.setCityName(jsonRequest.getString("cityName"));
            addressEntity.setCountyName(jsonRequest.getString("countyName"));
            addressEntity.setDetailInfo(jsonRequest.getString("detailInfo"));
            addressEntity.setNationalCode(jsonRequest.getString("nationalCode"));
            addressEntity.setTelNumber(jsonRequest.getString("telNumber"));
            addressEntity.setIs_default(jsonRequest.getInteger("is_default"));
            System.out.println("运行到了这里 = " + "--------");
        }

        if (addressEntity.getId() == null || addressEntity.getId()==0){
            addressEntity.setId(null);
            addressService.save(addressEntity);
        }else {
            addressService.update(addressEntity);
        }
        return toResponsSuccess(addressEntity);
    }
    /**
     * 删除指定的收货地址
     */
    @PostMapping("delete")
    public Object delete(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();
        int id = jsonRequest.getIntValue("id");
        System.out.println("loginUser.userId = " + loginUser.getUserId());

        AddressEntity addressEntity = addressService.queryObject(id);

        if (!loginUser.getUserId().equals(addressEntity.getUserId())){
            return toResponsObject(401,"无法删除","");
        }
        addressService.delete(id);
        return toResponsSuccess("");
    }

    @PostMapping("/detail")
    public Object detail(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();
        int id = jsonRequest.getIntValue("id");
        AddressEntity addressEntity = addressService.queryObject(id);

        if (!addressEntity.getUserId().equals(loginUser.getUserId())){
            return toResponsObject(403,"不是您的数据，您无权查看","");
        }
        return toResponsSuccess(addressEntity);
    }

    /**
     * 获取此userId创建的所有收货地址
     */
    @PostMapping("list")
    public Object AddressList(@CurrentLoginUser UserVo loginUser){
        HashMap<String, Object> param = new HashMap<>();
        param.put("user_id",loginUser.getUserId());
        List<AddressEntity> list = addressService.queryList(param);

        return toResponsSuccess(list);
    }
}
