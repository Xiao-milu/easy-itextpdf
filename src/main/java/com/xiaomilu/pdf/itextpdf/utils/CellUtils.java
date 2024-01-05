package com.xiaomilu.pdf.itextpdf.utils;

import com.xiaomilu.pdf.itextpdf.core.metadata.AbstractCell;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cell;
import com.xiaomilu.pdf.itextpdf.core.metadata.CellContext;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cells;

import java.util.ArrayList;
import java.util.List;

/**
 * 单元格数据工具类，获取单元格数据
 * @author Xiao迷路
 */
public abstract class CellUtils {

    /**
     * 获取Cells
     */
    public static Cells getCells(List<Cell> source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException("source should not empty");
        }
        return source.get(0).getCells();
    }

    /**
     * 获取header cell
     * @throws IllegalArgumentException 当cell sources中已经解析完成header cell并加入cell sources后，
     *  header cell不再有用，将抛出此异常
     */
    public static List<Cell> getHeaderCell(List<Cell> sources) throws IllegalArgumentException {
        List<Cell> headerCellList = new ArrayList<>();
        int startCount = 0;
        Cell headerCell;
        AbstractCell source;
        CellContext context;
        for (Cell cell : sources) {
            if (cell.isHead()) {
                throw new IllegalArgumentException("can not get headerCell when headerCell had already join this cell sources");
            }
            if (cell.isStart()) {
                startCount++;
            }
            if (startCount > 1) {
                break;
            }
            source = cell.getSourceCell();
            context = new CellContext(source.getHeader(), source.getSort(), source.isAutoCut(), source.getCellSize(),
                    source.getHeaderCellStyle(), source.getHeaderFontStyle(), source.getHeaderCellStyle(),
                    source.getHeaderFontStyle(), source.getHeader());
            headerCell = new Cell(cell.isStart(), cell.isFirst(), true, context, CellUtils.getCells(sources));
            headerCellList.add(headerCell);
        }
        return headerCellList;
    }
}
