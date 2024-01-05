package com.xiaomilu.pdf.itextpdf.core.annotation;

import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;

import java.lang.annotation.*;

/**
 * 用于标注类或字段的单元格样式
 * 包括对齐方式、padding、奇数行颜色、偶数行颜色、合并单元格个数
 *
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
public @interface PdfStyleCell {
    /**
     * 对齐方式
     */
    AlignEnums align() default AlignEnums.MIDDLE;

    /**
     * 跨列合并单元格数量
     */
    int colspan() default 1;

    /**
     * 跨行合并单元格数量
     */
    int rowspan() default 1;

    /**
     * 内间距
     */
    float padding() default 1.0f;

    /**
     * 行高
     */
    float height() default 24.0f;
}
