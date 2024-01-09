package com.xiaomilu.pdf;

import com.xiaomilu.pdf.itextpdf.core.annotation.TextContext;
import com.xiaomilu.pdf.itextpdf.core.constant.AlignEnums;
import com.xiaomilu.pdf.itextpdf.core.constant.FontConstant;
import com.xiaomilu.pdf.itextpdf.core.image.ImageCache;
import com.xiaomilu.pdf.itextpdf.core.metadata.*;
import com.xiaomilu.pdf.itextpdf.core.resolver.DataResolver;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateTest {
    @Test
    public void generateTest() {
        List<Demo> demoList = new ArrayList<>();
        demoList.add(new Demo("张三1", new Date()));
        demoList.add(new Demo("张三2", new Date()));
        demoList.add(new Demo("张三3", new Date()));
        demoList.add(new Demo("张三4", new Date()));
        demoList.add(new Demo("张三5", new Date()));
        GlobalProperties globalProperties = new GlobalProperties(true, true, "序号",
                new float[]{1.0f, 2.0f}, new PageProperties(),
                new CellProperties(24.0f, 1, 1, AlignEnums.CENTER_TOP, 0.5f),
                new FontProperties(FontConstant.SIM_SUN, 14.0f, new int[]{71, 71, 71}, true, true),
                new ImageProperties(ImageCache.class, 1));
        DataResolver dataResolver = new DataResolver();
        List<CellData> cellDataList = dataResolver.resolveHeader(Demo.class, globalProperties);
        cellDataList.forEach(System.out::println);
        List<CellData> resolve = dataResolver.resolve(demoList, globalProperties);
        resolve.forEach(System.out::println);
    }

    public static class Demo {
        @TextContext(header = "名称", sort = 1)
        private String name;
        @TextContext(header = "日期", sort = 2)
        private Date date;
        @TextContext(header = "年龄", sort = 3)
        private Integer age;

        public Demo(String name, Date date) {
            this.name = name;
            this.date = date;
        }
    }
}
