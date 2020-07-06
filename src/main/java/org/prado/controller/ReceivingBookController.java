package org.prado.controller;

import com.alibaba.fastjson.JSONObject;
import org.prado.annotation.CurrentLoginUser;
import org.prado.common.BaseController;
import org.prado.common.Constants;
import org.prado.entity.ReceivingBookEntity;
import org.prado.entity.UserVo;
import org.prado.service.ReceivingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: houlintao
 * @Date:2020/7/4 下午4:17
 * @email 437547058@qq.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/receivingbook")
public class ReceivingBookController extends BaseController {
    @Autowired
    private ReceivingBookService receivingBookService;

    @PostMapping("/create")
    public Object createBook(@CurrentLoginUser UserVo loginUser){
        JSONObject jsonRequest = getJsonRequest();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        String createDate = dateFormat.format(date);
        Long userId = loginUser.getUserId();
        int type = jsonRequest.getIntValue("type");
        String title = jsonRequest.getString("title");
        String recorder = loginUser.getUsername();

        //判断此entity是不是新的，为保证唯一性使用日期查询
        ReceivingBookEntity receivingBookEntity = receivingBookService.queryByDate(createDate);
        //返回为null，说明数据库没有记录，新建一个
        if (receivingBookEntity == null){
            receivingBookEntity = new ReceivingBookEntity();
            receivingBookEntity.setUserId(userId);
            receivingBookEntity.setType(type);
            receivingBookEntity.setTitle(title);
            receivingBookEntity.setCreateDate(createDate);
            receivingBookEntity.setRecorder(recorder);

            receivingBookService.save(receivingBookEntity);
        }else {
            //数据库有记录，更新相关记录
            receivingBookEntity.setUpdateDate(createDate);
            receivingBookEntity.setRecorder(recorder);
            receivingBookEntity.setTitle(title);
            receivingBookEntity.setType(type);

            receivingBookService.update(receivingBookEntity);
        }
            return toResponsSuccess("新建账本成功!");
    }
}
