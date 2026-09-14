package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class zzazc implements ThreadFactory {
    private final /* synthetic */ String zzdwd;
    private final AtomicInteger zzye = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazc(String str) {
        this.zzdwd = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.zzdwd;
        int andIncrement = this.zzye.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
