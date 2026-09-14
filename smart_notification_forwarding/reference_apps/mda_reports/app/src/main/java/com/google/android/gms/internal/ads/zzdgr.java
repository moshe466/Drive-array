package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class zzdgr<V> extends zzdgo<V> implements zzdhe<V> {
    @Override // com.google.android.gms.internal.ads.zzdhe
    public void addListener(Runnable runnable, Executor executor) {
        a().addListener(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdgo
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public abstract zzdhe<? extends V> a();
}
