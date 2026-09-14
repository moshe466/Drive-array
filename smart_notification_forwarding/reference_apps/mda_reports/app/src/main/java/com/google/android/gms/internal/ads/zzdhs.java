package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class zzdhs<V> extends zzdgm<V> implements RunnableFuture<V> {
    private volatile zzdha<?> zzgxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhs(zzdgd<V> zzdgdVar) {
        this.zzgxp = new zzdhr(this, zzdgdVar);
    }

    private zzdhs(Callable<V> callable) {
        this.zzgxp = new zzdhu(this, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzdhs<V> a(Runnable runnable, @NullableDecl V v) {
        return new zzdhs<>(Executors.callable(runnable, v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzdhs<V> a(Callable<V> callable) {
        return new zzdhs<>(callable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final void b() {
        zzdha<?> zzdhaVar;
        super.b();
        if (e() && (zzdhaVar = this.zzgxp) != null) {
            zzdhaVar.a();
        }
        this.zzgxp = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdfs
    public final String d() {
        zzdha<?> zzdhaVar = this.zzgxp;
        if (zzdhaVar == null) {
            return super.d();
        }
        String valueOf = String.valueOf(zzdhaVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzdha<?> zzdhaVar = this.zzgxp;
        if (zzdhaVar != null) {
            zzdhaVar.run();
        }
        this.zzgxp = null;
    }
}
