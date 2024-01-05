package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.metadata.AbstractCell;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cell;
import com.xiaomilu.pdf.itextpdf.core.metadata.Cells;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 解析单元格元数据为单元格数据
 * @author Xiao迷路
 */
public class MetadataCellResolver {
    private final Map<Class, MetadataResolver> metadataResolverCache = new ConcurrentHashMap<>();

    /**
     * 解析单元格元数据为单元格数据
     */
    public <T> List<Cell> resolve(Class<T> clazz, List<T> dataList) {
        MetadataResolver resolver = metadataResolverCache.computeIfAbsent(clazz, MetadataResolver::new);
        Cells cells = resolver.resolve(dataList);
        final int dataSize = cells.getFieldSize();
        final List<AbstractCell> sourceCellList = cells.getCellList();
        final List<Cell> targetCellList = new ArrayList<>();
        boolean start;
        boolean first;
        AbstractCell sourceCell;
        Cell cell;
        for (int i = 0; i < sourceCellList.size(); i++) {
            sourceCell = sourceCellList.get(i);
            start = i == 0;
            first = i % dataSize == 0;
            cell = new Cell(start, first, false, sourceCell, cells);
            targetCellList.add(cell);
        }
        return targetCellList;
    }
}
