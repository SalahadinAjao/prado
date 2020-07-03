package org.prado.annotation;

import java.lang.annotation.*;

/**
 * @Author: houlintao
 * @Date:2020/7/3 下午2:05
 * @email 437547058@qq.com
 * @Version 1.0
 * 注解，用在方法上表示此方法跳过token的验证授权
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SkipAuth {
}
