package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 全局配置
 * @author Xiao迷路
 */
public class GlobalProperties {
    protected final boolean showNumber;
    protected final boolean showNumberHeader;
    protected final String headerName;
    protected final float[] width;
    protected final PageProperties pageProperties;
    protected final CellProperties globalCellProperties;
    protected final FontProperties globalFontProperties;
    protected final ImageProperties globalImageProperties;

    public GlobalProperties(boolean showNumber, boolean showNumberHeader, String headerName, float[] width,
                            PageProperties pageProperties, CellProperties globalCellProperties,
                            FontProperties globalFontProperties, ImageProperties globalImageProperties) {
        this.showNumber = showNumber;
        this.showNumberHeader = showNumberHeader;
        this.headerName = headerName;
        this.width = width;
        this.pageProperties = pageProperties;
        this.globalCellProperties = globalCellProperties;
        this.globalFontProperties = globalFontProperties;
        this.globalImageProperties = globalImageProperties;
    }

    public int getColspan() {
        return width.length;
    }
}
