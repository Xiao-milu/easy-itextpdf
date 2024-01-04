package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 抽象单元格数据(拥有通用的单元格数据)
 * @author Xiao迷路
 */
public abstract class AbstractCell {
    /**
     * header
     */
    protected String header;
    /**
     * 单元格顺序
     */
    protected int sort;
    /**
     * 是否自动裁切内容
     * 仅对String类型有效
     */
    protected boolean autoCut;
    /**
     * 单元格样式
     */
    protected StyleCell cellStyle;
}
