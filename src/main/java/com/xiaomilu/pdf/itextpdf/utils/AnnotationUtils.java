package com.xiaomilu.pdf.itextpdf.utils;

import com.xiaomilu.pdf.itextpdf.core.annotation.*;
import com.xiaomilu.pdf.itextpdf.core.metadata.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解工具类
 * @author Xiao迷路
 */
public abstract class AnnotationUtils {
    public static int getSort(Field field) {
        if (field.isAnnotationPresent(ImageContext.class)) {
            return field.getAnnotation(ImageContext.class).sort();
        }
        if (field.isAnnotationPresent(TextContext.class)) {
            return field.getAnnotation(TextContext.class).sort();
        }
        throw new IllegalArgumentException("not provide target annotation");
    }

    public static List<CellData> getHeaderCellData(List<Field> fieldList, GlobalProperties globalProperties) {
        List<CellData> cellDataList = new ArrayList<>();
        int colspan = 0;
        int globalColspan = globalProperties.getColspan();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            CellData data;
            int currColspan;
            int sort;
            CellProperties cellProperties;
            FontProperties fontProperties;
            if (field.isAnnotationPresent(ImageContext.class)) {
                ImageContext imageContext = field.getAnnotation(ImageContext.class);
                currColspan = imageContext.headerCell().colspan();
                sort = imageContext.sort();
                cellProperties = getCellProperties(imageContext.headerCell());
                fontProperties = getFontProperties(imageContext.headerFont());
                if (currColspan > globalColspan) {
                    throw new RuntimeException("field colspan is greater than global colspan");
                }
                colspan += currColspan;
                data = new CellData(globalProperties, imageContext.header(), true, false, i, null);
            } else if (field.isAnnotationPresent(TextContext.class)) {
                TextContext textContext = field.getAnnotation(TextContext.class);
                currColspan = textContext.headerCell().colspan();
                sort = textContext.sort();
                cellProperties = getCellProperties(textContext.headerCell());
                fontProperties = getFontProperties(textContext.headerFont());
                if (currColspan > globalColspan) {
                    throw new RuntimeException("field colspan is greater than global colspan");
                }
                colspan += currColspan;
                data = new CellData(globalProperties, textContext.header(), true, false, i, null);
            } else {
                throw new IllegalArgumentException("not provide target annotation");
            }
            if (colspan > globalColspan) {
                data.setFirst(true);
                colspan = currColspan;
            } else {
                data.setFirst(false);
            }
            if (i == 0) {
                data.setStart(true);
                data.setFirst(true);
            }
            data.setNumber(false);
            data.setNumberHeader(false);
            data.setSort(sort);
            data.setCellProperties(cellProperties);
            data.setFontProperties(fontProperties);
            cellDataList.add(data);
        }
        return cellDataList;
    }

    public static FontProperties getFontProperties(PropertiesFont propertiesFont) {
        return new FontProperties(propertiesFont.name(), propertiesFont.size(), propertiesFont.rgb(),
                propertiesFont.blob(), propertiesFont.italic());
    }

    public static CellProperties getCellProperties(PropertiesCell propertiesCell) {
        return new CellProperties(propertiesCell.height(), propertiesCell.colspan(), propertiesCell.rowspan(),
                propertiesCell.align(), propertiesCell.padding());
    }

    public static ImageProperties getImageProperties(PropertiesImage image) {
        return new ImageProperties(image.imageCache(), image.compressibility());
    }
}
