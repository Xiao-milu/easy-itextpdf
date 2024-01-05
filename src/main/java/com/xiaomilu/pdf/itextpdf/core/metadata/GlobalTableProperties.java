package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 全局table配置
 * @author Xiao迷路
 */
public class GlobalTableProperties {
    /**
     * 标题
     */
    private String title;
    /**
     * 标题样式
     */
    private StyleCell titleCellStyle;
    /**
     * 标题字体
     */
    private StyleFont titleFont;
    /**
     * 标题边框
     */
    private float titleBorder;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 副标题样式
     */
    private StyleCell subTitleCellStyle;
    /**
     * 副标题字体
     */
    private StyleFont subTitleFont;
    /**
     * 副标题边框
     */
    private float subTitleBorder;
    /**
     * 是否展示序号
     */
    private boolean showNumber;
    /**
     * 序号header名称
     */
    private String numberHeaderName;
    /**
     * 全局单元格样式
     */
    private StyleCell globalStyleCell;
    /**
     * 全局单元格字体
     */
    private StyleFont globalStyleFont;
    public boolean isShowNumber() {
        return showNumber;
    }

    public String getNumberHeaderName() {
        return numberHeaderName;
    }
}
