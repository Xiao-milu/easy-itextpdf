package com.xiaomilu.pdf.itextpdf.generate;

import com.xiaomilu.pdf.itextpdf.core.annotation.PdfContext;

public class PdfGenerateStep {
    private PdfGenerateStep() {
    }
    public static PdfGenerateStep startStep() {
        return new PdfGenerateStep();
    }
    public Step1 setTitle(String context) {
        return new Step1();
    }

    public class Step1 {
        private Step1() {
        }

        public Step2 setSubTitle() {
            return new Step2();
        }
    }

    public class Step2 {
        private Step2() {
        }

    }
}
