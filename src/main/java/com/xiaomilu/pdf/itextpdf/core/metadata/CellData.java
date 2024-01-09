package com.xiaomilu.pdf.itextpdf.core.metadata;

import java.util.List;

/**
 * Cell数据
 * @author Xiao迷路
 */
public class CellData {
    /**
     * 全局配置
     */
    protected final GlobalProperties globalProperties;

    /**
     * 内容
     */
    protected final Object context;

    /**
     * 是否header
     */
    protected final boolean header;

    /**
     * 是否解析数据
     */
    protected final boolean resolveData;

    /**
     * header原始索引
     */
    private final int originHeaderIndex;

    /**
     * header cell
     */
    protected final List<CellData> headerCellList;

    public CellData(GlobalProperties globalProperties, Object context, boolean header, boolean resolveData,
                    int originHeaderIndex, List<CellData> headerCellList) {
        this.globalProperties = globalProperties;
        this.context = context;
        this.header = header;
        this.resolveData = resolveData;
        this.originHeaderIndex = originHeaderIndex;
        this.headerCellList = headerCellList;
    }

    /**
     * 获取实际header索引
     */
    public int getHeaderIndex() {
        return globalProperties.showNumber ? originHeaderIndex + 1 : originHeaderIndex;
    }

    /**
     * 是否数据第一个字段
     */
    protected boolean start;

    /**
     * 是否行第一列数据
     */
    protected boolean first;

    /**
     * 是否序号
     */
    protected boolean number;

    /**
     * 是否序号header
     */
    protected boolean numberHeader;

    /**
     * 排序
     */
    protected int sort;

    /**
     * 单元格配置
     */
    protected CellProperties cellProperties;

    /**
     * 字体配置
     */
    protected FontProperties fontProperties;

    /**
     * 图片配置
     */
    protected ImageProperties imageProperties;

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    public void setNumberHeader(boolean numberHeader) {
        this.numberHeader = numberHeader;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setCellProperties(CellProperties cellProperties) {
        this.cellProperties = cellProperties;
    }

    public void setFontProperties(FontProperties fontProperties) {
        this.fontProperties = fontProperties;
    }

    public void setImageProperties(ImageProperties imageProperties) {
        this.imageProperties = imageProperties;
    }

    @Override
    public String toString() {
        return "CellData{" +
                "globalProperties=" + globalProperties +
                ", context=" + context +
                ", header=" + header +
                ", resolveData=" + resolveData +
                ", originHeaderIndex=" + originHeaderIndex +
//                ", headerCellList=" + headerCellList +
                ", start=" + start +
                ", first=" + first +
                ", number=" + number +
                ", numberHeader=" + numberHeader +
                ", sort=" + sort +
                ", cellProperties=" + cellProperties +
                ", fontProperties=" + fontProperties +
                ", imageProperties=" + imageProperties +
                '}';
    }
}
