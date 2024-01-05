package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.metadata.Cell;

import java.util.List;

/**
 * 单元格解析器
 * @author Xiao迷路
 */
public interface CellResolver {
    List<Cell> resolve(List<Cell> source);
}
