package com.zx.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author:ZhengXing
 * datetime:2018-05-10 19:56
 * 不推荐使用
 *
 * 注解在类上
 * 只存在源码中，编译时忽略
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {

    String value() default "";
}
