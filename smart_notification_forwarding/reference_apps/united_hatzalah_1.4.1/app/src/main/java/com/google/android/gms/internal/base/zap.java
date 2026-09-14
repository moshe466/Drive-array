package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class zap implements zao {
    private zap() {
        throw null;
    }

    @Override // com.google.android.gms.internal.base.zao
    public final ExecutorService zaa(int i, int i3) {
        return zab(4, Executors.defaultThreadFactory(), 2);
    }

    @Override // com.google.android.gms.internal.base.zao
    public final ExecutorService zab(int i, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.base.zao
    public final ExecutorService zac(ThreadFactory threadFactory, int i) {
        return zab(1, threadFactory, 1);
    }

    public /* synthetic */ zap(byte[] bArr) {
    }
}
