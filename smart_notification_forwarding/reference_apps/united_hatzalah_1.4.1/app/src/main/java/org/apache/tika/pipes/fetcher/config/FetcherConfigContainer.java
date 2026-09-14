package org.apache.tika.pipes.fetcher.config;

/* loaded from: classes.dex */
public class FetcherConfigContainer {
    private String configClassName;
    private String json;

    public String getConfigClassName() {
        return this.configClassName;
    }

    public String getJson() {
        return this.json;
    }

    public FetcherConfigContainer setConfigClassName(String str) {
        this.configClassName = str;
        return this;
    }

    public FetcherConfigContainer setJson(String str) {
        this.json = str;
        return this;
    }
}
