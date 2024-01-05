package com.xiaomilu.pdf.itextpdf.generate;

import com.xiaomilu.pdf.itextpdf.core.metadata.StyleCell;
import com.xiaomilu.pdf.itextpdf.core.metadata.StyleFont;

public class PdfGenerateStep {
    private PdfGenerateStep() {
    }
    public static PdfGenerateStep startStep() {
        return new PdfGenerateStep();
    }
    public Step1 setTitle(String title, StyleCell titleCellStyle, StyleFont titleFont, boolean showBorder) {
        return new Step1();
    }

    public Step1 defaultTitle() {
        return new Step1();
    }

    public class Step1 {
        private Step1() {
        }


        public Step2 setSubTitle(String subTitle, StyleCell subTitleCellStyle, StyleFont subTitleFont, boolean showBorder) {
            return new Step2();
        }

        public Step2 defaultSubTitle() {
            return new Step2();
        }
    }

    public class Step2 {
        private Step2() {
        }

        public Step3 setGlobal(StyleCell globalCellStyle, StyleFont globalFontStyle) {
            return new Step3();
        }

        public Step3 defaultGlobal() {
            return new Step3();
        }
    }

    public class Step3 {
        private Step3() {
        }
    }
}
