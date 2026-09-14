package com.google.firebase.functions;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class HttpsCallableResult {
    private final Object data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableResult(Object obj) {
        this.data = obj;
    }

    @Nullable
    public Object getData() {
        return this.data;
    }
}
