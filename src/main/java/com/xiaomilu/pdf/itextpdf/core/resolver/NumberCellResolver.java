package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.metadata.AbstractCell;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cell;
import com.xiaomilu.pdf.itextpdf.core.metadata.CellContext;
import com.xiaomilu.pdf.itextpdf.core.metadata.GlobalTableProperties;
import com.xiaomilu.pdf.itextpdf.utils.CellUtils;

import java.util.List;

/**
 * number cell解析器
 * @author Xiao迷路
 */
public class NumberCellResolver implements CellResolver {
    @Override
    public List<Cell> resolve(List<Cell> source) {
        GlobalTableProperties properties = CellUtils.getGlobalProperties(source);
        if (!properties.isShowNumber()) {
            return source;
        }
        int addCount = 0;
        int number = 0;
        CellContext context;
        for (int i = 0; i < source.size(); i++) {
            Cell cell = source.get(i);
            if (!cell.isFirst()) {
                continue;
            }
            if (!cell.isStart()) {
                cell.setColspan(cell.getColspan() + 1);
                continue;
            }
            if (cell.isHead()) {
                CellContext sourceCell = ((CellContext) cell.getSourceCell());
                context = new CellContext(properties.getNumberHeaderName(), -1, false,
                        sourceCell.getCellSize(), sourceCell.getCellStyle(), sourceCell.getContextFontStyle(),
                        sourceCell.getHeaderCellStyle(), sourceCell.getContextFontStyle(),
                        properties.getNumberHeaderName());
                cell.setStart(false);
                cell.setFirst(false);
            } else {
                number++;
                AbstractCell sourceCell = cell.getSourceCell();
                context = new CellContext(properties.getNumberHeaderName(), -1, false,
                        sourceCell.getCellSize(), sourceCell.getHeaderCellStyle(), sourceCell.getHeaderFontStyle(),
                        sourceCell.getHeaderCellStyle(), sourceCell.getHeaderFontStyle(), number + "");
            }
            source.add(i + addCount,
                    new Cell(cell.isStart(), cell.isFirst(), cell.isHead(), context, CellUtils.getCells(source)));
            addCount++;
        }
        return source;
    }
}
