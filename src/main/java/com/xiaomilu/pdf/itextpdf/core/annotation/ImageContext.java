package com.xiaomilu.pdf.itextpdf.core.annotation;

import java.lang.annotation.*;

/**
 * 图片内容
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ImageContext {
    /**
     * 排序
     */
    int sort() default 0;

    /**
     * header名称
     */
    String header() default "";

    /**
     * header cell样式
     */
    PropertiesCell headerCell();

    /**
     * header 字体
     */
    PropertiesFont headerFont() default @PropertiesFont(size = 22.0f, blob = true);

    /**
     * cell样式
     */
    PropertiesCell cell();

    /**
     * 图片配置
     */
    PropertiesImage image();
}
