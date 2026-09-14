package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkg implements zzfc {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzke zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(zzke zzkeVar, String str) {
        this.zzb = zzkeVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzfc
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.a(i, th, bArr, this.zza);
    }
}
