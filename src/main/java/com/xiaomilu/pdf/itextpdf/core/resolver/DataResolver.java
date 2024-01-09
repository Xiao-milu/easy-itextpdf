package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.annotation.ImageContext;
import com.xiaomilu.pdf.itextpdf.core.annotation.TextContext;
import com.xiaomilu.pdf.itextpdf.core.metadata.*;
import com.xiaomilu.pdf.itextpdf.utils.AnnotationUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * data解析器
 * @author Xiao迷路
 */
public class DataResolver {
    /**
     * 类解析器
     */
    private Map<Class, Resolver> resolverRegistry = new HashMap<>();

    public <T> List<CellData> resolve(List<T> dataList, GlobalProperties globalProperties) {
        return resolve(null, dataList, globalProperties);
    }

    public <T> List<CellData> resolveHeader(Class<T> clazz, GlobalProperties globalProperties) {
        return resolverRegistry.computeIfAbsent(clazz, cl -> new Resolver(cl, globalProperties)).resolveHeader(clazz);
    }

    private <T> List<CellData> resolve(Class<T> clazz, List<T> dataList, GlobalProperties globalProperties) {
        if (dataList == null || dataList.isEmpty()) {
            throw new IllegalArgumentException("dataList can not be empty");
        }
        if (clazz == null) {
            clazz = (Class<T>) dataList.get(0).getClass();
        }
        return resolverRegistry.computeIfAbsent(clazz, cl -> new Resolver(cl, globalProperties)).resolve(dataList);
    }

    private class Resolver {
        private Class clazz;
        private GlobalProperties globalProperties;
        private List<Field> fieldList;
        private List<CellData> headerCellList;

        public Resolver(Class clazz, GlobalProperties globalProperties) {
            this.clazz = clazz;
            if (globalProperties != null) {
                this.globalProperties = globalProperties;
            }
            resolveField();
            resolveHeaderCell();
        }

        public <T> List<CellData> resolve(List<T> dataList) {
            List<CellData> resultList = new ArrayList<>();
            dataList.forEach(data -> {
                int colspan = 0;
                int globalColspan = globalProperties.getColspan();
                for (int i = 0; i < fieldList.size(); i++) {
                    Field field = fieldList.get(i);
                    if (!field.isAnnotationPresent(TextContext.class) && !field.isAnnotationPresent(ImageContext.class)) {
                        throw new RuntimeException("error resolve cell data, not provide target annotation");
                    }
                    boolean accessible = field.isAccessible();
                    Object context;
                    CellData cellData;
                    int currColspan = 0;
                    int sort = 0;
                    CellProperties cellProperties = null;
                    FontProperties fontProperties = null;
                    ImageProperties imageProperties = null;
                    field.setAccessible(true);
                    try {
                        context = field.get(data);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("resolve field exception");
                    } finally {
                        field.setAccessible(accessible);
                    }
                    cellData = new CellData(globalProperties, context, false, true, i, headerCellList);
                    if (field.isAnnotationPresent(TextContext.class)) {
                        TextContext textContext = field.getAnnotation(TextContext.class);
                        currColspan = textContext.cell().colspan();
                        sort = textContext.sort();
                        cellProperties = AnnotationUtils.getCellProperties(textContext.cell());
                        fontProperties = AnnotationUtils.getFontProperties(textContext.font());
                    } else if (field.isAnnotationPresent(ImageContext.class)) {
                        ImageContext imageContext = field.getAnnotation(ImageContext.class);
                        currColspan = imageContext.cell().colspan();
                        cellProperties = AnnotationUtils.getCellProperties(imageContext.cell());
                        imageProperties = AnnotationUtils.getImageProperties(imageContext.image());
                        sort = imageContext.sort();
                    }
                    colspan += currColspan;
                    if (colspan > globalColspan) {
                        cellData.setFirst(true);
                        colspan = currColspan;
                    } else {
                        cellData.setFirst(false);
                    }
                    if (i == 0) {
                        cellData.setStart(true);
                        cellData.setFirst(true);
                    }
                    cellData.setNumber(false);
                    cellData.setNumberHeader(false);
                    cellData.setSort(sort);
                    cellData.setCellProperties(cellProperties);
                    cellData.setFontProperties(fontProperties);
                    cellData.setImageProperties(imageProperties);
                    resultList.add(cellData);
                }
            });
            return resultList;
        }

        private void resolveHeaderCell() {
            if (headerCellList == null) {
                headerCellList = AnnotationUtils.getHeaderCellData(fieldList, globalProperties);
            }
        }

        private void resolveField() {
            fieldList = Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(TextContext.class) || f.isAnnotationPresent(ImageContext.class))
                    .sorted(Comparator.comparingInt(AnnotationUtils::getSort))
                    .collect(Collectors.toList());
        }

        public <T> List<CellData> resolveHeader(Class<T> clazz) {
            resolveHeaderCell();
            return headerCellList;
        }
    }
}
