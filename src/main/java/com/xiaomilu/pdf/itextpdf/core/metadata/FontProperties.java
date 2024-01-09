package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 字体配置
 * 名称/大小/颜色/加粗/倾斜
 * @author Xiao迷路
 */
public class FontProperties {
    /**
     * 名称
     */
    protected String name;

    /**
     * 大小
     */
    protected float size;

    /**
     * 颜色
     */
    protected int[] rgb;

    /**
     * 加粗
     */
    protected boolean bold;

    /**
     * 倾斜
     */
    protected boolean italic;

    public FontProperties(String name, float size, int[] rgb, boolean bold, boolean italic) {
        this.name = name;
        this.size = size;
        this.rgb = rgb;
        this.bold = bold;
        this.italic = italic;
    }
}
