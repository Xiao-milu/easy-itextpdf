package com.xiaomilu.pdf.itextpdf.core.render;

import com.xiaomilu.pdf.itextpdf.core.metadata.CellData;
import com.xiaomilu.pdf.itextpdf.core.resolver.DataResolver;

import java.util.List;

/**
 * cell数据渲染器
 * @author Xiao迷路
 */
public class DefaultCellDataRender extends AbstractCellDataRender {
    private HeaderRender headerRender;
    private NumberRender numberRender;
    public DefaultCellDataRender(DataResolver dataResolver) {
        super(dataResolver);
        dataResolver = new DataResolver();
        headerRender = new HeaderRender(dataResolver);
        numberRender = new NumberRender();
    }

    public void registryHeaderRender(HeaderRender headerRender) {
        this.headerRender = headerRender;
    }

    public void registryNumberRender(NumberRender numberRender) {
        this.numberRender = numberRender;
    }

    @Override
    public <T> List<CellData> rendering(Class<T> clazz, List<CellData> cellDataList) {
        cellDataList = headerRender.rendering(clazz, cellDataList);
        cellDataList = numberRender.rendering(clazz, cellDataList);
        return cellDataList;
    }
}
