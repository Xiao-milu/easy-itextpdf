package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.metadata.Cell;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cells;
import com.xiaomilu.pdf.itextpdf.utils.CellUtils;

import java.util.List;

/**
 * 默认的header cell解析器
 * @author Xiao迷路
 */
public class DefaultHeaderCellResolver implements HeaderCellResolver {

    @Override
    public List<Cell> resolve(List<Cell> sources) {
        Cells cells = CellUtils.getCells(sources);
        int tableColSize = cells.getTableColSize();
        Integer dataColSize = cells.getDataColSize();
        if (tableColSize == dataColSize) {
            return resolveSingleLine(sources);
        }
        return resolveMultiLine(sources);
    }

    private List<Cell> resolveMultiLine(List<Cell> sources) {
        List<Cell> headerCellList = CellUtils.getHeaderCell(sources);
        int currCellIndex = 0;
        int currHeaderIndex = 0;
        for (Cell source : sources) {
            if (source.isFirst()) {
                if (source.isStart()) {
                    currCellIndex += currHeaderIndex;
                    currHeaderIndex = 0;
                }
                sources.add(currCellIndex, headerCellList.get(currHeaderIndex));
                currCellIndex ++;
                currHeaderIndex ++;
                continue;
            }
            sources.add(currCellIndex, headerCellList.get(currHeaderIndex));
            currCellIndex++;
            currHeaderIndex++;
        }
        return sources;
    }

    private List<Cell> resolveSingleLine(List<Cell> sources) {
        List<Cell> headerCellList = CellUtils.getHeaderCell(sources);
        sources.addAll(0, headerCellList);
        return sources;
    }
}
