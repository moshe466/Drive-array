package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdew<E> extends zzdep<E> {
    private final zzdeu<E> zzguj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdew(zzdeu<E> zzdeuVar, int i) {
        super(zzdeuVar.size(), i);
        this.zzguj = zzdeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    protected final E a(int i) {
        return this.zzguj.get(i);
    }
}
