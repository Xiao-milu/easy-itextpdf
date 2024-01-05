package com.xiaomilu.pdf.itextpdf.core.metadata;

import java.util.Collections;
import java.util.List;

/**
 * 单元格元数据包装器
 * @author Xiao迷路
 */
public class Cells {
    private final List<AbstractCell> cellList;
    private final int fieldSize;
    private Integer tableColSize;
    private Integer dataColSize;
    private GlobalTableProperties properties;

    public GlobalTableProperties getProperties() {
        return properties;
    }

    public Cells(List<AbstractCell> cellList, int fieldSize) {
        this.cellList = Collections.unmodifiableList(cellList);
        this.fieldSize = fieldSize;
    }

    public List<AbstractCell> getCellList() {
        return cellList;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setTableColSize(int tableColSize) {
        this.tableColSize = tableColSize;
    }

    public int getTableColSize() {
        if (this.tableColSize == null) {
            throw new RuntimeException("table col size is not initialized");
        }
        return tableColSize;
    }

    public Integer getDataColSize() {
        if (this.dataColSize == null) {
            throw new RuntimeException("data col size is not initialized");
        }
        return dataColSize;
    }

    public void setDataColSize(Integer dataColSize) {
        this.dataColSize = dataColSize;
    }
}
