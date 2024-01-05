package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 单元格，保存了单元格的数据信息
 * @author Xiao迷路
 */
public class Cell {
    protected boolean start;
    protected boolean first;
    protected boolean head;
    protected final AbstractCell sourceCell;
    protected final Cells cells;

    public Cell(boolean start, boolean first, boolean head, AbstractCell sourceCell, Cells cells) {
        this.start = start;
        this.first = first;
        this.head = head;
        this.sourceCell = sourceCell;
        this.cells = cells;
    }

    public Cells getCells() {
        return cells;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isHead() {
        return head;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public AbstractCell getSourceCell() {
        return sourceCell;
    }

    public Object getContext() {
        return sourceCell.context;
    }

    public int getColspan() {
        return sourceCell.cellStyle.getColspan();
    }

    public int getRowspan() {
        return sourceCell.cellStyle.getRowspan();
    }

    public void setColspan(int colspan) {
        sourceCell.cellStyle.setColspan(colspan);
    }
}
