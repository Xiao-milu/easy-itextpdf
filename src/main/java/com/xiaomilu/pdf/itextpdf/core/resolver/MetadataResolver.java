package com.xiaomilu.pdf.itextpdf.core.resolver;

import com.xiaomilu.pdf.itextpdf.core.annotation.PdfContext;
import com.xiaomilu.pdf.itextpdf.core.annotation.PdfImage;
import com.xiaomilu.pdf.itextpdf.core.annotation.PdfStyleCell;
import com.xiaomilu.pdf.itextpdf.core.annotation.PdfStyleFont;
import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;
import com.xiaomilu.pdf.itextpdf.core.metadata.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 单元格元数据解析器
 * @author Xiao迷路
 */
public class MetadataResolver<T> {
    private Class<T> clazz;
    private List<Field> fieldList;

    public MetadataResolver(Class clazz) {
        if (clazz == null) {
            throw new RuntimeException("class must not be null");
        }
        this.clazz = clazz;
    }

    /**
     * 解析数据的单元格元数据
     * @param dataList 提供的数据源
     * @return 从数据源中解析出来的单元格元数据
     */
    public Cells resolve(List<T> dataList) {
        if (dataList == null || dataList.isEmpty()) {
            throw new RuntimeException("empty data");
        }
        if (this.fieldList == null) {
            List<Field> fieldList = Arrays.stream(this.clazz.getDeclaredFields())
                    .filter(this::isAnnotationPresent)
                    .sorted((f1, f2) -> getSort(f1) - getSort(f2))
                    .collect(Collectors.toList());
            if (fieldList.isEmpty()) {
                throw new RuntimeException("annotation is not provide");
            }
            this.fieldList = fieldList;
        }
        List<AbstractCell> sourceCellList = new ArrayList<>();
        Field field;
        for (T data : dataList) {
            for (int i = 0; i < this.fieldList.size(); i++) {
                field = this.fieldList.get(i);
                sourceCellList.add(generateSourceCell(this.fieldList.size(), data, field));
            }
        }
        return new Cells(sourceCellList, this.fieldList.size());
    }

    private AbstractCell generateSourceCell(int size, T data, Field field) {
        if (isPdfContextPresent(field)) {
            PdfContext pdfContext = field.getAnnotation(PdfContext.class);
            String header = pdfContext.header();
            int sort = pdfContext.sort();
            boolean autoCut = pdfContext.autoCut();
            StyleCell cellStyle = generateStyleCell(pdfContext.cellStyle());
            StyleFont contextFontStyle = generateFontStyle(pdfContext.contextFontStyle());
            StyleFont headerFontStyle = generateFontStyle(pdfContext.headerFontStyle());
            Object context = getContext(data, field);
            StyleCell headerCellStyle = generateStyleCell(pdfContext.headerCellStyle());
            return new CellContext(header, sort, autoCut, size, cellStyle, contextFontStyle,
                    headerCellStyle, headerFontStyle, context);
        }
        if (isPdfImagePresent(field)) {
            PdfImage pdfImage = field.getAnnotation(PdfImage.class);
            String header = pdfImage.header();
            int sort = pdfImage.sort();
            boolean autoCut = pdfImage.autoCut();
            StyleCell cellStyle = generateStyleCell(pdfImage.cellStyle());
            Object context = getContext(data, field);
            StyleFont headerFontStyle = generateFontStyle(pdfImage.headerFontStyle());
            StyleCell headerCellStyle = generateStyleCell(pdfImage.headercellStyle());
            return new CellImage(header, sort, autoCut, size, cellStyle, headerCellStyle, headerFontStyle, context);
        }
        throw new RuntimeException("annotation is not provide");
    }

    private Object getContext(Object data, Field field) {
        field.setAccessible(true);
        try {
            return field.get(data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("resolve context error");
        } finally {
            field.setAccessible(false);
        }
    }

    private StyleFont generateFontStyle(PdfStyleFont pdfStyleFont) {
        String font = pdfStyleFont.font();
        boolean bold = pdfStyleFont.bold();
        float fontSize = pdfStyleFont.fontSize();
        int[] rgb = pdfStyleFont.rgb();
        boolean italic = pdfStyleFont.italic();
        return new StyleFont(font, fontSize, bold, italic, rgb);
    }

    private StyleCell generateStyleCell(PdfStyleCell pdfStyleCell) {
        AlignEnums align = pdfStyleCell.align();
        int colspan = pdfStyleCell.colspan();
        int rowspan = pdfStyleCell.rowspan();
        float padding = pdfStyleCell.padding();
        float height = pdfStyleCell.height();
        return new StyleCell(align, colspan, rowspan, padding, height);
    }

    private int getSort(Field field) {
        if (field.isAnnotationPresent(PdfContext.class)) {
            return field.getAnnotation(PdfImage.class).sort();
        }
        if (field.isAnnotationPresent(PdfImage.class)) {
            return field.getAnnotation(PdfImage.class).sort();
        }
        throw new RuntimeException("annotation is not provide");
    }

    private boolean isAnnotationPresent(Field field) {
        return isPdfContextPresent(field) || isPdfImagePresent(field);
    }

    private boolean isPdfContextPresent(Field field) {
        return field.isAnnotationPresent(PdfContext.class);
    }

    private boolean isPdfImagePresent(Field field) {
        return field.isAnnotationPresent(PdfImage.class);
    }
}
