package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
abstract class zzhv<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzdu zzduVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, zzis zzisVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(zzhe zzheVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b, zzhe zzheVar) {
        int zzb = zzheVar.zzb();
        int i = zzb >>> 3;
        int i2 = zzb & 7;
        if (i2 == 0) {
            a((zzhv<T, B>) b, i, zzheVar.zzg());
            return true;
        }
        if (i2 == 1) {
            b(b, i, zzheVar.zzi());
            return true;
        }
        if (i2 == 2) {
            a((zzhv<T, B>) b, i, zzheVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzfo.f();
            }
            a((zzhv<T, B>) b, i, zzheVar.zzj());
            return true;
        }
        B a = a();
        int i3 = 4 | (i << 3);
        while (zzheVar.zza() != Integer.MAX_VALUE && a((zzhv<T, B>) a, zzheVar)) {
        }
        if (i3 != zzheVar.zzb()) {
            throw zzfo.e();
        }
        a((zzhv<T, B>) b, i, (int) a((zzhv<T, B>) a));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, zzis zzisVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);
}
