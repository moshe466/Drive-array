package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdfy implements Runnable {
    private final /* synthetic */ zzdhe zzgvy;
    private final /* synthetic */ int zzgvz;
    private final /* synthetic */ zzdfz zzgwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfy(zzdfz zzdfzVar, zzdhe zzdheVar, int i) {
        this.zzgwa = zzdfzVar;
        this.zzgvy = zzdheVar;
        this.zzgvz = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzgvy.isCancelled()) {
                zzdfz.a(this.zzgwa, (zzdet) null);
                this.zzgwa.cancel(false);
            } else {
                this.zzgwa.zza(this.zzgvz, this.zzgvy);
            }
        } finally {
            this.zzgwa.zza((zzdet) null);
        }
    }
}
