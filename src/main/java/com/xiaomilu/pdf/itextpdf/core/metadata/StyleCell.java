package com.xiaomilu.pdf.itextpdf.core.metadata;

import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;

/**
 * 单元格样式
 */
public class StyleCell {
    /**
     * 对齐方式
     */
    private AlignEnums alignEnums;
    /**
     * 跨列合并单元格
     */
    private int colspan;
    /**
     * 跨行合并单元格
     */
    private int rowspan;
    /**
     * 内间距
     */
    private float padding;
}