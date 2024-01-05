package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 字体样式
 * @author Xiao迷路
 */
public class StyleFont {
    /**
     * 字体名称
     */
    private String fontName;
    /**
     * 字体大小
     */
    private float fontSize;
    /**
     * 是否加粗
     */
    private boolean bold;
    /**
     * 是否斜体
     */
    private boolean italic;
    /**
     * 字体颜色
     */
    private int[] rgb;

    public StyleFont(String fontName, float fontSize, boolean bold, boolean italic, int[] rgb) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.bold = bold;
        this.italic = italic;
        this.rgb = rgb;
    }
}
