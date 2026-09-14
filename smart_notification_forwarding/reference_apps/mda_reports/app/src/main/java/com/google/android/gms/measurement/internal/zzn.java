package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzn extends zzkb {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzp> zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(zzke zzkeVar) {
        super(zzkeVar);
    }

    private final zzp zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzp zzpVar = new zzp(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzpVar);
        return zzpVar;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return zzp.a(this.zzd.get(Integer.valueOf(i))).get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x05f4, code lost:
    
        r8 = zzr().zzi();
        r11 = com.google.android.gms.measurement.internal.zzew.zza(r48.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0608, code lost:
    
        if (r9.zza() == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x060a, code lost:
    
        r14 = java.lang.Integer.valueOf(r9.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0614, code lost:
    
        r8.zza("Invalid property filter ID. appId, id", r11, java.lang.String.valueOf(r14));
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0613, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Long, long, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r6v23, types: [java.lang.Long, long, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r8v17, types: [long, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v22, types: [long, java.lang.String] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbr.zza> a(java.lang.String r49, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzc> r50, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzk> r51, java.lang.Long r52) {
        /*
            Method dump skipped, instructions count: 1791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzn.a(java.lang.String, java.util.List, java.util.List, java.lang.Long):java.util.List");
    }

    @Override // com.google.android.gms.measurement.internal.zzkb
    protected final boolean zze() {
        return false;
    }
}
