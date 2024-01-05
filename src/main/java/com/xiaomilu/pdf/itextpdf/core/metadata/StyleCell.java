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
    /**
     * 行高
     */
    private float height;

    public StyleCell(AlignEnums alignEnums, int colspan, int rowspan, float padding, float height) {
        this.alignEnums = alignEnums;
        this.colspan = colspan;
        this.rowspan = rowspan;
        this.padding = padding;
        this.height = height;
    }

    public int getColspan() {
        return colspan;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }
}
