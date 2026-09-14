package com.google.firebase.functions;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class HttpsCallableContext {

    @Nullable
    private final String authToken;

    @Nullable
    private final String instanceIdToken;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableContext(@Nullable String str, @Nullable String str2) {
        this.authToken = str;
        this.instanceIdToken = str2;
    }

    @Nullable
    public String getAuthToken() {
        return this.authToken;
    }

    @Nullable
    public String getInstanceIdToken() {
        return this.instanceIdToken;
    }
}
