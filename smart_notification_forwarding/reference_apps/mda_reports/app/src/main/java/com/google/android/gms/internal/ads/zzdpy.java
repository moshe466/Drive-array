package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes.dex */
final class zzdpy extends zzdps {
    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }

    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zza(Throwable th, Throwable th2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdps
    public final void zzl(Throwable th) {
        th.printStackTrace();
    }
}
