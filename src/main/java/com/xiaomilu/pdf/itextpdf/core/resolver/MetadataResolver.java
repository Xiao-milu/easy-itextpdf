package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.metadata.CellDecorator;

import java.util.Collection;
import java.util.List;

/**
 * 单元格元数据解析器
 * @author Xiao迷路
 */
public class MetadataResolver {
    /**
     * 解析数据的单元格元数据
     * @param dataList 提供的数据源
     * @return 从数据源中解析出来的单元格元数据
     */
    <T> List<CellDecorator> resolver(Collection<T> dataList) {
        return null;
    }
}
