package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zaaa {
    private final Map zaa = Collections.synchronizedMap(new WeakHashMap());
    private final Map zab = Collections.synchronizedMap(new WeakHashMap());

    private final void zah(boolean z3, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        Map map = this.zaa;
        synchronized (map) {
            hashMap = new HashMap(map);
        }
        Map map2 = this.zab;
        synchronized (map2) {
            hashMap2 = new HashMap(map2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z3 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z3 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    public final void zaa(BasePendingResult basePendingResult, boolean z3) {
        this.zaa.put(basePendingResult, Boolean.valueOf(z3));
        basePendingResult.addStatusListener(new zay(this, basePendingResult));
    }

    public final void zab(TaskCompletionSource taskCompletionSource, boolean z3) {
        this.zab.put(taskCompletionSource, Boolean.valueOf(z3));
        taskCompletionSource.getTask().addOnCompleteListener(new zaz(this, taskCompletionSource));
    }

    public final boolean zac() {
        if (this.zaa.isEmpty() && this.zab.isEmpty()) {
            return false;
        }
        return true;
    }

    public final void zad() {
        zah(false, GoogleApiManager.zaa);
    }

    public final void zae(int i, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        zah(true, new Status(20, sb.toString()));
    }

    public final /* synthetic */ Map zaf() {
        return this.zaa;
    }

    public final /* synthetic */ Map zag() {
        return this.zab;
    }
}
