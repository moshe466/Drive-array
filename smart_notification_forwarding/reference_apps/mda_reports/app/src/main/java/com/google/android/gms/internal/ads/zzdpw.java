package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
final class zzdpw extends zzdps {
    private final zzdpv zzhhg = new zzdpv();

    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> zza = this.zzhhg.zza(th, false);
        if (zza == null) {
            return;
        }
        synchronized (zza) {
            for (Throwable th2 : zza) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.zzhhg.zza(th, true).add(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zzl(Throwable th) {
        th.printStackTrace();
        List<Throwable> zza = this.zzhhg.zza(th, false);
        if (zza == null) {
            return;
        }
        synchronized (zza) {
            for (Throwable th2 : zza) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }
}
