package com.xiaomilu.pdf.itextpdf.core.annotation;

import com.xiaomilu.pdf.itextpdf.core.image.ImageCache;

import java.lang.annotation.*;

/**
 * 图片配置
 * 图片获取器、图片压缩比率
 * @author Xiao迷路
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Inherited
public @interface PropertiesImage {
    /**
     * 图片获取器
     */
    Class<? extends ImageCache> imageCache();

    /**
     * 图片压缩率
     */
    int compressibility();
}
