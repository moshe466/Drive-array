package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzev implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzew zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzew zzewVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzewVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j;
        char c2;
        long j2;
        zzew zzewVar;
        char c3;
        zzff zzc = this.zzf.a.zzc();
        if (!zzc.zzz()) {
            this.zzf.a(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c = this.zzf.zza;
        if (c == 0) {
            if (this.zzf.zzt().zzf()) {
                zzewVar = this.zzf;
                zzewVar.zzu();
                c3 = 'C';
            } else {
                zzewVar = this.zzf;
                zzewVar.zzu();
                c3 = 'c';
            }
            zzewVar.zza = c3;
        }
        j = this.zzf.zzb;
        if (j < 0) {
            zzew zzewVar2 = this.zzf;
            zzewVar2.zzb = zzewVar2.zzt().zze();
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        c2 = this.zzf.zza;
        j2 = this.zzf.zzb;
        String a = zzew.a(true, this.zzb, this.zzc, this.zzd, this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 24);
        sb.append(ExifInterface.GPS_MEASUREMENT_2D);
        sb.append(charAt);
        sb.append(c2);
        sb.append(j2);
        sb.append(":");
        sb.append(a);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzb.substring(0, 1024);
        }
        zzc.zzb.zza(sb2, 1L);
    }
}
