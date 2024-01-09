package com.xiaomilu.pdf.itextpdf.core.metadata;

/**
 * 全局配置包装器
 * @author Xiao迷路
 */
public class GlobalPropertiesWrapper {
    public GlobalPropertiesWrapper() {
    }

    public GlobalPropertiesWrapper(GlobalProperties globalProperties) {
        this.globalProperties = globalProperties;
    }

    private GlobalProperties globalProperties;

    public void setGlobalProperties(GlobalProperties globalProperties) {
        this.globalProperties = globalProperties;
    }

    public GlobalProperties getGlobalProperties() {
        return globalProperties;
    }
}
