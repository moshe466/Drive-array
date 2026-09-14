package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
final class zzw {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzw(String str, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, byte[] bArr) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = z6;
    }

    public final boolean zza() {
        return this.zzc;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public final zzp zzb(Context context) {
        return new zzp(this.zza, this.zzb, false, ObjectWrapper.wrap(context), false, true, false);
    }
}
