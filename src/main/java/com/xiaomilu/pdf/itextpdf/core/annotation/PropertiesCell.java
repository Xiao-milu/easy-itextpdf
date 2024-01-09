package com.xiaomilu.pdf.itextpdf.core.annotation;

import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;

import java.lang.annotation.*;

/**
 * 单元格配置
 * 高度\行合并\列合并\对齐方式\内边距
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Inherited
public @interface PropertiesCell {
    /**
     * 高度
     */
    float height() default 24.0f;

    /**
     * 行合并
     */
    int colspan() default 1;

    /**
     * 列合并
     */
    int rowspan() default 1;

    /**
     * 对齐方式
     */
    AlignEnums align() default AlignEnums.MIDDLE;

    /**
     * 内边距
     */
    float padding() default 0.5f;
}
