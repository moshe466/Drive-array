package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzih implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzif zzb;
    private final /* synthetic */ zzif zzc;
    private final /* synthetic */ zzii zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzih(zzii zziiVar, boolean z, zzif zzifVar, zzif zzifVar2) {
        this.zzd = zziiVar;
        this.zza = z;
        this.zzb = zzifVar;
        this.zzc = zzifVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (com.google.android.gms.measurement.internal.zzkm.zzc(r10.zzb.zza, r10.zzc.zza) != false) goto L27;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzx r0 = r0.zzt()
            com.google.android.gms.measurement.internal.zzel<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzap.zzay
            boolean r0 = r0.zza(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L27
            boolean r0 = r10.zza
            if (r0 == 0) goto L1c
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzif r0 = r0.b
            if (r0 == 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L35
            com.google.android.gms.measurement.internal.zzii r3 = r10.zzd
            com.google.android.gms.measurement.internal.zzif r4 = r3.b
            com.google.android.gms.measurement.internal.zzii.a(r3, r4, r2)
            goto L35
        L27:
            boolean r0 = r10.zza
            if (r0 == 0) goto L34
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzif r3 = r0.b
            if (r3 == 0) goto L34
            com.google.android.gms.measurement.internal.zzii.a(r0, r3, r2)
        L34:
            r0 = 0
        L35:
            com.google.android.gms.measurement.internal.zzif r3 = r10.zzb
            if (r3 == 0) goto L5b
            long r4 = r3.zzc
            com.google.android.gms.measurement.internal.zzif r6 = r10.zzc
            long r7 = r6.zzc
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L5b
            java.lang.String r3 = r3.zzb
            java.lang.String r4 = r6.zzb
            boolean r3 = com.google.android.gms.measurement.internal.zzkm.zzc(r3, r4)
            if (r3 == 0) goto L5b
            com.google.android.gms.measurement.internal.zzif r3 = r10.zzb
            java.lang.String r3 = r3.zza
            com.google.android.gms.measurement.internal.zzif r4 = r10.zzc
            java.lang.String r4 = r4.zza
            boolean r3 = com.google.android.gms.measurement.internal.zzkm.zzc(r3, r4)
            if (r3 != 0) goto L5c
        L5b:
            r1 = 1
        L5c:
            if (r1 == 0) goto Lbf
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            com.google.android.gms.measurement.internal.zzif r3 = r10.zzc
            com.google.android.gms.measurement.internal.zzii.zza(r3, r1, r2)
            com.google.android.gms.measurement.internal.zzif r2 = r10.zzb
            if (r2 == 0) goto L87
            java.lang.String r2 = r2.zza
            if (r2 == 0) goto L75
            java.lang.String r3 = "_pn"
            r1.putString(r3, r2)
        L75:
            com.google.android.gms.measurement.internal.zzif r2 = r10.zzb
            java.lang.String r2 = r2.zzb
            java.lang.String r3 = "_pc"
            r1.putString(r3, r2)
            com.google.android.gms.measurement.internal.zzif r2 = r10.zzb
            long r2 = r2.zzc
            java.lang.String r4 = "_pi"
            r1.putLong(r4, r2)
        L87:
            com.google.android.gms.measurement.internal.zzii r2 = r10.zzd
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzt()
            com.google.android.gms.measurement.internal.zzel<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzap.zzay
            boolean r2 = r2.zza(r3)
            if (r2 == 0) goto Lb2
            if (r0 == 0) goto Lb2
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzjo r0 = r0.zzk()
            com.google.android.gms.measurement.internal.zzjw r0 = r0.c
            long r2 = r0.b()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Lb2
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzkm r0 = r0.zzp()
            r0.zza(r1, r2)
        Lb2:
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzhb r0 = r0.zzf()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_vs"
            r0.a(r2, r3, r1)
        Lbf:
            com.google.android.gms.measurement.internal.zzii r0 = r10.zzd
            com.google.android.gms.measurement.internal.zzif r1 = r10.zzc
            r0.b = r1
            com.google.android.gms.measurement.internal.zzij r0 = r0.zzh()
            com.google.android.gms.measurement.internal.zzif r1 = r10.zzc
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzih.run():void");
    }
}
