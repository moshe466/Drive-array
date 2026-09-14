package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzchx implements zzbow, zzbqb {
    private static final Object zzfwy = new Object();
    private static int zzfwz;
    private final zzcid zzfxa;

    public zzchx(zzcid zzcidVar) {
        this.zzfxa = zzcidVar;
    }

    private static void zzalw() {
        synchronized (zzfwy) {
            zzfwz++;
        }
    }

    private static boolean zzalx() {
        boolean z;
        synchronized (zzfwy) {
            z = zzfwz < ((Integer) zzve.zzoy().zzd(zzzn.zzcqg)).intValue();
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue() && zzalx()) {
            this.zzfxa.zzbj(false);
            zzalw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue() && zzalx()) {
            this.zzfxa.zzbj(true);
            zzalw();
        }
    }
}
