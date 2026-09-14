package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdfz;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdgg<V> extends zzdfz<Object, V> {
    private zzdgi<?> zzgwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdgg(zzdet<? extends zzdhe<?>> zzdetVar, boolean z, Executor executor, Callable<V> callable) {
        super(zzdetVar, z, false);
        this.zzgwm = new zzdgj(this, callable, executor);
        k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdgi a(zzdgg zzdggVar, zzdgi zzdgiVar) {
        zzdggVar.zzgwm = null;
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    final void a(int i, @NullableDecl Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdfz
    public final void a(zzdfz.zza zzaVar) {
        super.a(zzaVar);
        if (zzaVar == zzdfz.zza.OUTPUT_FUTURE_DONE) {
            this.zzgwm = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfs
    protected final void c() {
        zzdgi<?> zzdgiVar = this.zzgwm;
        if (zzdgiVar != null) {
            zzdgiVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfz
    final void l() {
        zzdgi<?> zzdgiVar = this.zzgwm;
        if (zzdgiVar != null) {
            zzdgiVar.e();
        }
    }
}
