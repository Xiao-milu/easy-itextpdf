package com.xiaomilu.pdf.itextpdf.core.render;

import com.xiaomilu.pdf.itextpdf.core.metadata.CellData;

import java.util.List;

/**
 * 序号渲染器
 * @author Xiao迷路
 */
public class NumberRender implements CellDataRender {


    @Override
    public <T> List<CellData> rendering(Class<T> clazz, List<CellData> cellDataList) {
        return cellDataList;
    }
}
