package com.groboot.mdaemergency.models;

import y8.k;

/* loaded from: classes.dex */
public final class JSFunction {
    public String data;
    public String function;

    public final String getData() {
        String str = this.data;
        if (str != null) {
            return str;
        }
        k.o("data");
        return null;
    }

    public final String getFunction() {
        String str = this.function;
        if (str != null) {
            return str;
        }
        k.o("function");
        return null;
    }

    public final void setData(String str) {
        k.e(str, "<set-?>");
        this.data = str;
    }

    public final void setFunction(String str) {
        k.e(str, "<set-?>");
        this.function = str;
    }
}
