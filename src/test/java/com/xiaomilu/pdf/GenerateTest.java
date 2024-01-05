package com.xiaomilu.pdf;

import com.xiaomilu.pdf.itextpdf.core.annotation.PdfContext;
import com.xiaomilu.pdf.itextpdf.generate.PdfGenerateStep;
import org.junit.Test;

public class GenerateTest {
    @Test
    public void generateTest() {
        PdfGenerateStep.startStep()
                .defaultTitle()
                .defaultSubTitle();
    }
}
