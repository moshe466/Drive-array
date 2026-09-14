package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class i8 extends h8 {
    private i8() {
        super();
    }

    private static <E> u7<E> e(Object obj, long j10) {
        return (u7) na.F(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h8
    public final <E> void b(Object obj, Object obj2, long j10) {
        u7 e10 = e(obj, j10);
        u7 e11 = e(obj2, j10);
        int size = e10.size();
        int size2 = e11.size();
        if (size > 0 && size2 > 0) {
            if (!e10.zza()) {
                e10 = e10.b(size2 + size);
            }
            e10.addAll(e11);
        }
        if (size > 0) {
            e11 = e10;
        }
        na.j(obj, j10, e11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.h8
    public final void d(Object obj, long j10) {
        e(obj, j10).n();
    }
}
