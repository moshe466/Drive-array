package com.google.firebase.functions;

import android.content.Context;
import androidx.annotation.GuardedBy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FunctionsMultiResourceComponent {
    private final Context applicationContext;
    private final ContextProvider contextProvider;

    @GuardedBy("this")
    private final Map<String, FirebaseFunctions> instances = new HashMap();
    private final String projectId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FunctionsMultiResourceComponent(Context context, ContextProvider contextProvider, String str) {
        this.applicationContext = context;
        this.contextProvider = contextProvider;
        this.projectId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized FirebaseFunctions a(String str) {
        FirebaseFunctions firebaseFunctions;
        firebaseFunctions = this.instances.get(str);
        if (firebaseFunctions == null) {
            firebaseFunctions = new FirebaseFunctions(this.applicationContext, this.projectId, str, this.contextProvider);
            this.instances.put(str, firebaseFunctions);
        }
        return firebaseFunctions;
    }
}
