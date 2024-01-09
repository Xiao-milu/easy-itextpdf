package com.xiaomilu.pdf.itextpdf.core.annotation;

import com.xiaomilu.pdf.itextpdf.core.constant.FontConstant;

import java.lang.annotation.*;

/**
 * 字体配置
 * 名称/大小/颜色/加粗/倾斜
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Inherited
public @interface PropertiesFont {
    /**
     * 名称
     */
    String name() default FontConstant.SIM_SUN;

    /**
     * 大小
     */
    float size() default 14.0f;

    /**
     * 颜色
     */
    int[] rgb() default {71, 71, 71};

    /**
     * 加粗
     */
    boolean blob() default false;

    /**
     * 倾斜
     */
    boolean italic() default false;
}
