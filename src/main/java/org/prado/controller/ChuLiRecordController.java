package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.annotation.CurrentLoginUser;
import org.prado.common.BaseController;
import org.prado.common.Constants;
import org.prado.entity.ChuLiRecordEntity;
import org.prado.entity.UserVo;
import org.prado.service.ChuLiRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/6 下午1:01
 * @email 437547058@qq.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/chuli")
public class ChuLiRecordController extends BaseController {
    @Autowired
    private ChuLiRecordService chuLiRecordService;

    @PostMapping("/totalmoney")
    public Object checkTotalMoney(@CurrentLoginUser UserVo loginUser){
        BigDecimal totalMoney = chuLiRecordService.sumMoney(4);
        return toResponsSuccess(totalMoney);
    }

    @PostMapping("/save")
    public Object save(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();
        String chuliName = jsonRequest.getString("chuliName");
        String gift = jsonRequest.getString("gift");
        BigDecimal money = jsonRequest.getBigDecimal("chuliMoney");
        Long bookId = jsonRequest.getLong("bookId");

        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        String chuliDate = dateFormat.format(new Date());

        ChuLiRecordEntity chuLiRecordEntity = new ChuLiRecordEntity();
        chuLiRecordEntity.setReceivingbookentityId(bookId);
        chuLiRecordEntity.setChuliName(chuliName);
        chuLiRecordEntity.setChuliMoney(money);
        chuLiRecordEntity.setGift(gift);
        chuLiRecordEntity.setChuliDate(chuliDate);

        chuLiRecordService.save(chuLiRecordEntity);

        return toResponsObject(200,"出礼成功",chuLiRecordEntity);
    }

    @PostMapping("/querybyname")
    public Object queryByName(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();
        String name = jsonRequest.getString("name");

        ChuLiRecordEntity chuLiRecordEntity = chuLiRecordService.queryByName(name);

        if (chuLiRecordEntity == null){
            return toResponsSuccess("没有找到此人的出礼记录");
        }
        return toResponsSuccess(chuLiRecordEntity);
    }
}
