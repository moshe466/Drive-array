package com.google.android.gms.internal.fido;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzbf extends zzbb {
    final /* synthetic */ zzbg zza;

    public zzbf(zzbg zzbgVar) {
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav
    /* renamed from: zzd */
    public final zzcb iterator() {
        return zzi().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbb
    public final zzba zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.fido.zzbc
    public final zzaz zzj() {
        return new zzbe(this);
    }
}
