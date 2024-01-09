package com.xiaomilu.pdf.itextpdf.core.metadata;

import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;

/**
 * 解析的单元格配置
 * @author Xiao迷路
 */
public class CellProperties {
    /**
     * 高度
     */
    protected float height;

    /**
     * 行合并
     */
    protected int colspan;

    /**
     * 列合并
     */
    protected int rowspan;

    /**
     * 对齐方式
     */
    protected AlignEnums align;

    /**
     * 内边距
     */
    protected float padding;

    public CellProperties(float height, int colspan, int rowspan, AlignEnums align, float padding) {
        this.height = height;
        this.colspan = colspan;
        this.rowspan = rowspan;
        this.align = align;
        this.padding = padding;
    }
}
