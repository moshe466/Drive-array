package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzhx extends zzhv<zzhy, zzhy> {
    private static void zza(Object obj, zzhy zzhyVar) {
        ((zzfd) obj).zzb = zzhyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ zzhy a() {
        return zzhy.a();
    }

    @Override // com.google.android.gms.internal.measurement.zzhv
    final /* synthetic */ zzhy a(zzhy zzhyVar) {
        zzhy zzhyVar2 = zzhyVar;
        zzhyVar2.zzc();
        return zzhyVar2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhv
    final /* synthetic */ void a(zzhy zzhyVar, int i, int i2) {
        zzhyVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ void a(zzhy zzhyVar, int i, long j) {
        zzhyVar.a(i << 3, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ void a(zzhy zzhyVar, int i, zzdu zzduVar) {
        zzhyVar.a((i << 3) | 2, zzduVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhv
    final /* synthetic */ void a(zzhy zzhyVar, int i, zzhy zzhyVar2) {
        zzhyVar.a((i << 3) | 3, zzhyVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ void a(zzhy zzhyVar, zzis zzisVar) {
        zzhyVar.zzb(zzisVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* bridge */ /* synthetic */ void a(Object obj, zzhy zzhyVar) {
        zza(obj, zzhyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final boolean a(zzhe zzheVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ zzhy b(Object obj) {
        return ((zzfd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhv
    final /* synthetic */ void b(zzhy zzhyVar, int i, long j) {
        zzhyVar.a((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ void b(zzhy zzhyVar, zzis zzisVar) {
        zzhyVar.a(zzisVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ void b(Object obj, zzhy zzhyVar) {
        zza(obj, zzhyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ zzhy c(Object obj) {
        zzhy zzhyVar = ((zzfd) obj).zzb;
        if (zzhyVar != zzhy.zza()) {
            return zzhyVar;
        }
        zzhy a = zzhy.a();
        zza(obj, a);
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ zzhy c(zzhy zzhyVar, zzhy zzhyVar2) {
        zzhy zzhyVar3 = zzhyVar;
        zzhy zzhyVar4 = zzhyVar2;
        return zzhyVar4.equals(zzhy.zza()) ? zzhyVar3 : zzhy.a(zzhyVar3, zzhyVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final void d(Object obj) {
        ((zzfd) obj).zzb.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ int e(zzhy zzhyVar) {
        return zzhyVar.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhv
    public final /* synthetic */ int f(zzhy zzhyVar) {
        return zzhyVar.zze();
    }
}
