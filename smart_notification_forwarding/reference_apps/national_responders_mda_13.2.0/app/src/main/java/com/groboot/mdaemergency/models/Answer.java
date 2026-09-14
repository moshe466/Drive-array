package com.groboot.mdaemergency.models;

import y8.k;

/* loaded from: classes.dex */
public final class Answer {
    private String Message = "";
    private String Result = "";
    private boolean Success;

    public final String getMessage() {
        return this.Message;
    }

    public final String getResult() {
        return this.Result;
    }

    public final boolean getSuccess() {
        return this.Success;
    }

    public final void setMessage(String str) {
        k.e(str, "<set-?>");
        this.Message = str;
    }

    public final void setResult(String str) {
        k.e(str, "<set-?>");
        this.Result = str;
    }

    public final void setSuccess(boolean z10) {
        this.Success = z10;
    }
}
