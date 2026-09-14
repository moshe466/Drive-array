package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzbhq {
    private zza zzfah;

    /* loaded from: classes.dex */
    public static abstract class zza {
        public abstract zzbcv zzacw();

        public abstract zzbaj zzacx();

        public abstract zzsr zzacy();

        public abstract zzatq zzacz();
    }

    public zzbhq(zza zzaVar) {
        this.zzfah = zzaVar;
    }

    public final zzatq zzacz() {
        return this.zzfah.zzacz();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzatr, com.google.android.gms.internal.ads.zzatl] */
    public final com.google.android.gms.ads.internal.zza zzaex() {
        zza zzaVar = this.zzfah;
        return new com.google.android.gms.ads.internal.zza(zzaVar.zzacw(), zzaVar.zzacx(), new zzatl(zzaVar.zzacz()), zzaVar.zzacy());
    }
}
