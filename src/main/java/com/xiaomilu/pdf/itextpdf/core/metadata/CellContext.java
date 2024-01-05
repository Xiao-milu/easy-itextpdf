package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 单元格文本数据内容
 * @author Xiao迷路
 */
public class CellContext extends AbstractCell{
    private StyleFont contextFontStyle;

    public CellContext(String header, int sort, boolean autoCut, int cellSize, StyleCell cellStyle,
                       StyleFont contextFontStyle, StyleCell headerCellStyle, StyleFont headerFontStyle, Object context) {
        super(header, sort, autoCut, cellSize, cellStyle, headerCellStyle, headerFontStyle, context);
        this.contextFontStyle = contextFontStyle;
    }
}
