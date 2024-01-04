package com.xiaomilu.pdf.itextpdf.core.constant;

import java.util.Objects;

/**
 * 默认照片
 * @author Xiao迷路
 */
public final class ImageConstant {
    /**
     * "无图片"所处项目路径
     */
    private static final String NO_IMAGE_LOCATION = "/image/noImage.png";

    /**
     * "无图片"绝对路径
     */
    public static final String NO_IMAGE = Objects.requireNonNull(ImageConstant.class.getResource(NO_IMAGE_LOCATION)).getFile();
}
