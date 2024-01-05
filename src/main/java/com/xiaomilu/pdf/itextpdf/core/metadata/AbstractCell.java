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
    /**
     * 每条数据cell数量
     */
    protected int cellSize;

    /**
     * 数据内容
     */
    protected Object context;

    /**
     * 表头样式
     */
    protected StyleCell headerCellStyle;
    /**
     * 表头字体样式
     */
    private StyleFont headerFontStyle;

    public AbstractCell(String header, int sort, boolean autoCut, int cellSize, StyleCell cellStyle,
                        StyleCell headerCellStyle, StyleFont headerFontStyle, Object context) {
        this.header = header;
        this.sort = sort;
        this.autoCut = autoCut;
        this.cellSize = cellSize;
        this.cellStyle = cellStyle;
        this.context = context;
        this.headerCellStyle = headerCellStyle;
        this.headerFontStyle = headerFontStyle;
    }

    public StyleCell getHeaderCellStyle() {
        return headerCellStyle;
    }

    public StyleFont getHeaderFontStyle() {
        return headerFontStyle;
    }

    public String getHeader() {
        return header;
    }

    public int getSort() {
        return sort;
    }

    public boolean isAutoCut() {
        return autoCut;
    }

    public StyleCell getCellStyle() {
        return cellStyle;
    }

    public int getCellSize() {
        return cellSize;
    }

    public Object getContext() {
        return context;
    }
}
