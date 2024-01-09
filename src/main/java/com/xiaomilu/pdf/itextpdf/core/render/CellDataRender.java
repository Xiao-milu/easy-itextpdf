package com.xiaomilu.pdf.itextpdf.core.render;

import com.xiaomilu.pdf.itextpdf.core.metadata.CellData;

import java.util.List;

/**
 * cell数据渲染器
 * @author Xiao迷路
 */
public interface CellDataRender {
    /**
     * 将当前cell数据渲染成有序的cell数据
     */
    <T> List<CellData> rendering(Class<T> clazz, List<CellData> cellDataList);
}
