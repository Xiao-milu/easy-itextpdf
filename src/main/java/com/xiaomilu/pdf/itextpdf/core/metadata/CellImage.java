package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 单元格图片数据内容
 * @author Xiao迷路
 */
public class CellImage extends AbstractCell {
    public CellImage(String header, int sort, boolean autoCut, int cellSize, StyleCell cellStyle,
                     StyleCell headerCellStyle, StyleFont headerFontStyle, Object context) {
        super(header, sort, autoCut, cellSize, cellStyle, headerCellStyle, headerFontStyle, context);
    }
}
