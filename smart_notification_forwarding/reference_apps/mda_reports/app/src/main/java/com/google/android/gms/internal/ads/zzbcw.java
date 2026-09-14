package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbcw {
    private final ArrayList<zzns> zzedp = new ArrayList<>();
    private long zzedq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        Iterator<zzns> it = this.zzedp.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.zzedq = Math.max(this.zzedq, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzedq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzns zznsVar) {
        this.zzedp.add(zznsVar);
    }
}
