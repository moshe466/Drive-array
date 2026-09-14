package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzec {
    private final zzen zza;
    private final byte[] zzb;

    private zzec(int i) {
        this.zzb = new byte[i];
        this.zza = zzen.zza(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzec(int i, zzdx zzdxVar) {
        this(i);
    }

    public final zzdu zza() {
        this.zza.zzb();
        return new zzee(this.zzb);
    }

    public final zzen zzb() {
        return this.zza;
    }
}
