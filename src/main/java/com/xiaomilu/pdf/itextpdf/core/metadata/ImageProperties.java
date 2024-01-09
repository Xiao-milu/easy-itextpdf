package com.xiaomilu.pdf.itextpdf.core.metadata;

import com.xiaomilu.pdf.itextpdf.core.image.ImageCache;

/**
 * 图片配置
 * 图片获取器、图片压缩比率
 * @author Xiao迷路
 */
public class ImageProperties {
    /**
     * 图片获取器
     */
    protected Class<? extends ImageCache> imageCache;

    /**
     * 图片压缩率
     */
    protected int compressibility;

    public ImageProperties(Class<? extends ImageCache> imageCache, int compressibility) {
        this.imageCache = imageCache;
        this.compressibility = compressibility;
    }
}
