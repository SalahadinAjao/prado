package org.prado.controller;

import com.google.code.kaptcha.Producer;
import org.apache.log4j.Logger;
import org.prado.common.BaseController;
import org.prado.common.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: houlintao
 * @Date:2020/7/3 上午6:07
 * @email 437547058@qq.com
 * @Version 1.0
 * 验证码控制器类，仅用于测试，实际使用是通过向小程序发送短信发送验证码
 */

@RestController
@RequestMapping("/kaptcha")
public class KaptchaController extends BaseController {
    @Resource
    private Producer producer;

    @RequestMapping("/getkaptcha")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response){
        ServletOutputStream out = null;

        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");

        //生成验证码文字
        String text = producer.createText();
        //将验证码编码成图片
        BufferedImage image = producer.createImage(text);
        //输出验证码PNG格式图片
        response.setHeader("content-type", "image/png");
        try {
            out = response.getOutputStream();
            ImageIO.write(image,"png",out);
            out.flush();
            System.out.println("客户端"+getClientIp()+"的验证码是:"+text);
            //获取session，将验证码编码写入session中
            HttpSession session = request.getSession();
            session.setAttribute(Constants.DEFAULT_KAPTCHA_SESSION_KEY,text);
            //System.out.println("session中保存的验证码 = " + session.getAttribute(Constants.DEFAULT_KAPTCHA_SESSION_KEY));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
