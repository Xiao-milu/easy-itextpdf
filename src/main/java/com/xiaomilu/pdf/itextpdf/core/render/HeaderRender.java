package com.xiaomilu.pdf.itextpdf.core.render;

import com.xiaomilu.pdf.itextpdf.core.metadata.CellData;
import com.xiaomilu.pdf.itextpdf.core.resolver.DataResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认的header渲染器,用来渲染header
 * @author Xiao迷路
 */
public class HeaderRender implements CellDataRender {
    private DataResolver dataResolver;

    public HeaderRender(DataResolver dataResolver) {
        this.dataResolver = dataResolver;
    }

    @Override
    public <T> List<CellData> rendering(Class<T> clazz, List<CellData> cellDataList) {
        boolean enjambment = dataResolver.isEnjambment(clazz);
        if (enjambment) {
            return showHeaderEachLine(cellDataList);
        }
        return showHeaderFirstLine(clazz, cellDataList);
    }

    private List<CellData> showHeaderEachLine(List<CellData> cellDataList) {
        List<CellData> crrHeaderCellDataList = null;
        List<CellData> crrCellDataList = null;
        CellData crrData;
        List<CellData> result = new ArrayList<>();
        for (int i = 0; i < cellDataList.size(); i++) {
            crrData = cellDataList.get(i);
            if (i == 0 && !crrData.isFirst()) {
                throw new IllegalArgumentException("index 1 cell data must be first cell");
            }
            if (crrData.isFirst()) {
                if (crrHeaderCellDataList != null) {
                    result.addAll(crrHeaderCellDataList);
                    result.addAll(crrCellDataList);
                }
                crrHeaderCellDataList = new ArrayList<>();
                crrCellDataList = new ArrayList<>();
            }
            crrHeaderCellDataList.add(crrData.getHeaderCell());
            crrCellDataList.add(crrData);
        }
        return result;
    }

    private List<CellData> showHeaderFirstLine(Class clazz, List<CellData> cellDataList) {
        List<CellData> list = new ArrayList<>();
        List<CellData> headerCellList = dataResolver.resolveHeader(clazz);
        list.addAll(headerCellList);
        list.addAll(cellDataList);
        return list;
    }
}
