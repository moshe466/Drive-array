package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class ja extends ha<ga, ga> {
    private static void m(Object obj, ga gaVar) {
        ((l7) obj).zzb = gaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ ga a() {
        return ga.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ void b(ga gaVar, int i10, long j10) {
        gaVar.c(i10 << 3, Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ void c(ga gaVar, int i10, d6 d6Var) {
        gaVar.c((i10 << 3) | 2, d6Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ void d(ga gaVar, bb bbVar) {
        gaVar.h(bbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* bridge */ /* synthetic */ void e(Object obj, ga gaVar) {
        m(obj, gaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ ga f(Object obj) {
        return ((l7) obj).zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ void g(ga gaVar, bb bbVar) {
        gaVar.e(bbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ void h(Object obj, ga gaVar) {
        m(obj, gaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ ga i(ga gaVar, ga gaVar2) {
        ga gaVar3 = gaVar;
        ga gaVar4 = gaVar2;
        return gaVar4.equals(ga.a()) ? gaVar3 : ga.b(gaVar3, gaVar4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final void j(Object obj) {
        ((l7) obj).zzb.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ int k(ga gaVar) {
        return gaVar.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.ha
    public final /* synthetic */ int l(ga gaVar) {
        return gaVar.k();
    }
}
