package com.xiaomilu.pdf.itextpdf.core.annotation;

import java.lang.annotation.*;

/**
 * 文本内容
 *
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface TextContext {
    /**
     * 排序
     */
    int sort() default 0;

    /**
     * header 名称
     */
    String header() default "";

    /**
     * header cell 样式
     */
    PropertiesCell headerCell() default @PropertiesCell;

    /**
     * header 字体
     */
    PropertiesFont headerFont() default @PropertiesFont(size = 22.0f, blob = true);

    /**
     * cell 样式
     */
    PropertiesCell cell() default @PropertiesCell;

    /**
     * cell 字体
     */
    PropertiesFont font() default @PropertiesFont;
}
