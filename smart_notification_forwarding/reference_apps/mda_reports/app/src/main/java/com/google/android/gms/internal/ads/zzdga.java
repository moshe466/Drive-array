package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdga implements Runnable {
    private final /* synthetic */ zzdfz zzgwa;
    private final /* synthetic */ zzdet zzgwh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdga(zzdfz zzdfzVar, zzdet zzdetVar) {
        this.zzgwa = zzdfzVar;
        this.zzgwh = zzdetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgwa.zza(this.zzgwh);
    }
}
