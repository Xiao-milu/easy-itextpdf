package com.xiaomilu.pdf.itextpdf.core.render;

import com.xiaomilu.pdf.itextpdf.core.resolver.DataResolver;

/**
 * 抽象的cell 数据渲染器
 * @author Xiao迷路
 */
public abstract class AbstractCellDataRender implements CellDataRender{
    private DataResolver dataResolver;

    public AbstractCellDataRender(DataResolver dataResolver) {
        this.dataResolver = dataResolver;
    }
}
