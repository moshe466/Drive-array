package com.google.firebase.functions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class HttpsCallableReference {
    HttpsCallOptions a = new HttpsCallOptions();
    private final FirebaseFunctions functionsClient;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpsCallableReference(FirebaseFunctions firebaseFunctions, String str) {
        this.functionsClient = firebaseFunctions;
        this.name = str;
    }

    @NonNull
    public Task<HttpsCallableResult> call() {
        return this.functionsClient.a(this.name, null, this.a);
    }

    @NonNull
    public Task<HttpsCallableResult> call(@Nullable Object obj) {
        return this.functionsClient.a(this.name, obj, this.a);
    }

    public long getTimeout() {
        return this.a.getTimeout();
    }

    public void setTimeout(long j, @NonNull TimeUnit timeUnit) {
        this.a.a(j, timeUnit);
    }

    @NonNull
    public HttpsCallableReference withTimeout(long j, @NonNull TimeUnit timeUnit) {
        HttpsCallableReference httpsCallableReference = new HttpsCallableReference(this.functionsClient, this.name);
        httpsCallableReference.setTimeout(j, timeUnit);
        return httpsCallableReference;
    }
}
