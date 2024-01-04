package com.xiaomilu.pdf.itextpdf.core.metadata;

import java.util.List;

/**
 * 单元格元数据包装器
 * @author Xiao迷路
 */
public class Cells {
    private List<AbstractCell> cellList;

    public Cells(List<AbstractCell> cellList) {
        this.cellList = cellList;
    }

    public List<AbstractCell> getCellList() {
        return cellList;
    }
}
