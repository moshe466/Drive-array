package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import t.C0694j;

/* loaded from: classes.dex */
public class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new C0694j(0);

    /* loaded from: classes.dex */
    public interface GetTokenRequest {
        Task<String> start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [t.j, java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>>] */
    public RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    public /* synthetic */ Task lambda$getOrStartGetTokenRequest$0(String str, Task task) {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<String> getOrStartGetTokenRequest(String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.getTokenRequests.get(str);
        if (task != null) {
            Log.isLoggable(Constants.TAG, 3);
            return task;
        }
        Log.isLoggable(Constants.TAG, 3);
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.executor, new o(this, str));
        this.getTokenRequests.put(str, continueWithTask);
        return continueWithTask;
    }
}
