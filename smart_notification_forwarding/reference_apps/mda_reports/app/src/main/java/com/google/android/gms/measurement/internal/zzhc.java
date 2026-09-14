package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzhc {
    final Context a;
    String b;
    String c;
    String d;
    Boolean e;
    long f;
    com.google.android.gms.internal.measurement.zzv g;
    boolean h;

    @VisibleForTesting
    public zzhc(Context context, com.google.android.gms.internal.measurement.zzv zzvVar) {
        this.h = true;
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.a = applicationContext;
        if (zzvVar != null) {
            this.g = zzvVar;
            this.b = zzvVar.zzf;
            this.c = zzvVar.zze;
            this.d = zzvVar.zzd;
            this.h = zzvVar.zzc;
            this.f = zzvVar.zzb;
            Bundle bundle = zzvVar.zzg;
            if (bundle != null) {
                this.e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
