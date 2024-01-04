package com.xiaomilu.pdf.itextpdf.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注非图片类型字段
 * 支持Collection、数组类型、String、Date、DateTime类型
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface PdfContext {

    /**
     * 单元格对应的header
     */
    String header() default "image";

    /**
     * 单元格顺序
     * 当sort相同时，则按照字段出现的位置决定其顺序
     */
    int sort() default 0;

    /**
     * 是否自动裁切内容
     * 仅对String类型有效
     * @return true开启自动裁切内容;false则关闭自动裁切内容并将其看作普通字符串
     */
    boolean autoCut() default true;

    /**
     * 单元格样式
     */
    PdfStyleCell cellStyle() default @PdfStyleCell;

    /**
     * 内容文本样式
     */
    PdfStyleFont contextFontStyle() default @PdfStyleFont;

    /**
     * header文本样式
     */
    PdfStyleFont headerFontStyle() default @PdfStyleFont(fontSize = 14.0f, bold = true);
}
