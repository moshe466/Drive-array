package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcr {
    final Uri a;
    final String b;
    final String c;

    public zzcr(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private zzcr(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcv<Context, Boolean> zzcvVar) {
        this.a = uri;
        this.b = str2;
        this.c = str3;
    }

    public final zzcl<Double> zza(String str, double d) {
        zzcl<Double> zzb;
        zzb = zzcl.zzb(this, str, -3.0d);
        return zzb;
    }

    public final zzcl<Long> zza(String str, long j) {
        zzcl<Long> zzb;
        zzb = zzcl.zzb(this, str, j);
        return zzb;
    }

    public final zzcl<String> zza(String str, String str2) {
        zzcl<String> zzb;
        zzb = zzcl.zzb(this, str, str2);
        return zzb;
    }

    public final zzcl<Boolean> zza(String str, boolean z) {
        zzcl<Boolean> zzb;
        zzb = zzcl.zzb(this, str, z);
        return zzb;
    }
}
