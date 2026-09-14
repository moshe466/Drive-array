package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* loaded from: classes.dex */
public final class zzdhr<V> extends zzdha<zzdhe<V>> {
    private final zzdgd<V> zzgxn;
    private final /* synthetic */ zzdhs zzgxo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdhr(zzdhs zzdhsVar, zzdgd<V> zzdgdVar) {
        this.zzgxo = zzdhsVar;
        this.zzgxn = (zzdgd) zzdei.checkNotNull(zzdgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final /* synthetic */ void a(Object obj, Throwable th) {
        zzdhe<? extends V> zzdheVar = (zzdhe) obj;
        if (th == null) {
            this.zzgxo.a((zzdhe) zzdheVar);
        } else {
            this.zzgxo.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final boolean b() {
        return this.zzgxo.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final /* synthetic */ Object c() {
        return (zzdhe) zzdei.zza(this.zzgxn.zzanm(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzgxn);
    }

    @Override // com.google.android.gms.internal.ads.zzdha
    final String d() {
        return this.zzgxn.toString();
    }
}
