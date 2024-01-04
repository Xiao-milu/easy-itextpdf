package com.xiaomilu.pdf.itextpdf.core.annotation;

import com.xiaomilu.pdf.itextpdf.core.constant.FontConstant;

import java.lang.annotation.*;

/**
 * 用于标注类或字段的字体样式
 * 包括使用字体、字体大小、是否斜体、是否加粗、字体RGB
 *
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
public @interface PdfStyleFont {
    /**
     * 字体名称
     */
    String fontName() default FontConstant.SIM_SUN;

    /**
     * 字体大小
     */
    float fontSize() default 12.0f;

    /**
     * 是否加粗
     */
    boolean bold() default false;

    /**
     * 是否斜体
     */
    boolean italic() default false;

    /**
     * 字体rgb颜色
     */
    int[] rgb() default {71, 71, 71};
}
