package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaw extends zzx.zza {
    private final /* synthetic */ com.google.android.gms.measurement.internal.zzgz zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaw(zzx zzxVar, com.google.android.gms.measurement.internal.zzgz zzgzVar) {
        super(zzxVar);
        this.zzd = zzxVar;
        this.zzc = zzgzVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    @Override // com.google.android.gms.internal.measurement.zzx.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void zza() {
        /*
            r4 = this;
            r0 = 0
        L1:
            com.google.android.gms.internal.measurement.zzx r1 = r4.zzd
            java.util.List r1 = com.google.android.gms.internal.measurement.zzx.d(r1)
            int r1 = r1.size()
            if (r0 >= r1) goto L32
            com.google.android.gms.measurement.internal.zzgz r1 = r4.zzc
            com.google.android.gms.internal.measurement.zzx r2 = r4.zzd
            java.util.List r2 = com.google.android.gms.internal.measurement.zzx.d(r2)
            java.lang.Object r2 = r2.get(r0)
            android.util.Pair r2 = (android.util.Pair) r2
            java.lang.Object r2 = r2.first
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L2f
            com.google.android.gms.internal.measurement.zzx r0 = r4.zzd
            java.lang.String r0 = com.google.android.gms.internal.measurement.zzx.b(r0)
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r0, r1)
            return
        L2f:
            int r0 = r0 + 1
            goto L1
        L32:
            com.google.android.gms.internal.measurement.zzx$zzb r0 = new com.google.android.gms.internal.measurement.zzx$zzb
            com.google.android.gms.measurement.internal.zzgz r1 = r4.zzc
            r0.<init>(r1)
            com.google.android.gms.internal.measurement.zzx r1 = r4.zzd
            java.util.List r1 = com.google.android.gms.internal.measurement.zzx.d(r1)
            android.util.Pair r2 = new android.util.Pair
            com.google.android.gms.measurement.internal.zzgz r3 = r4.zzc
            r2.<init>(r3, r0)
            r1.add(r2)
            com.google.android.gms.internal.measurement.zzx r1 = r4.zzd
            com.google.android.gms.internal.measurement.zzm r1 = com.google.android.gms.internal.measurement.zzx.c(r1)
            r1.registerOnMeasurementEventListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaw.zza():void");
    }
}
