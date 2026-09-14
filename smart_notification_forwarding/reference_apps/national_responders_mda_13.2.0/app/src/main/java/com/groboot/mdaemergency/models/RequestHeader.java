package com.groboot.mdaemergency.models;

import y8.k;

/* loaded from: classes.dex */
public final class RequestHeader {
    private String AppVersion;
    private int Application = 1;
    private String Module = "";
    private String Function = "";

    public final String getAppVersion() {
        return this.AppVersion;
    }

    public final int getApplication() {
        return this.Application;
    }

    public final String getFunction() {
        return this.Function;
    }

    public final String getModule() {
        return this.Module;
    }

    public final void setAppVersion(String str) {
        this.AppVersion = str;
    }

    public final void setApplication(int i10) {
        this.Application = i10;
    }

    public final void setFunction(String str) {
        k.e(str, "<set-?>");
        this.Function = str;
    }

    public final void setModule(String str) {
        k.e(str, "<set-?>");
        this.Module = str;
    }
}
