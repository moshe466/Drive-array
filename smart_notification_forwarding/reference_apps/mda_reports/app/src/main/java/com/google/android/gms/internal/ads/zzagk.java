package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzagk implements zzdgf<zzagf, ParcelFileDescriptor> {
    private final /* synthetic */ zzafz zzcya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzagk(zzagh zzaghVar, zzafz zzafzVar) {
        this.zzcya = zzafzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgf
    public final /* synthetic */ zzdhe<ParcelFileDescriptor> zzf(zzagf zzagfVar) {
        zzazl zzazlVar = new zzazl();
        zzagfVar.zza(this.zzcya, new zzagj(this, zzazlVar));
        return zzazlVar;
    }
}
