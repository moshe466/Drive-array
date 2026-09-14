package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
abstract class zzdus<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj);

    abstract void a(B b, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b, int i, zzdqk zzdqkVar);

    abstract void a(B b, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, zzdvl zzdvlVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(zzdtu zzdtuVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b, zzdtu zzdtuVar) {
        int tag = zzdtuVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            a((zzdus<T, B>) b, i, zzdtuVar.zzaye());
            return true;
        }
        if (i2 == 1) {
            b(b, i, zzdtuVar.zzayg());
            return true;
        }
        if (i2 == 2) {
            a((zzdus<T, B>) b, i, zzdtuVar.zzayk());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzdse.f();
            }
            a((zzdus<T, B>) b, i, zzdtuVar.zzayh());
            return true;
        }
        B a = a();
        int i3 = 4 | (i << 3);
        while (zzdtuVar.zzaza() != Integer.MAX_VALUE && a((zzdus<T, B>) a, zzdtuVar)) {
        }
        if (i3 != zzdtuVar.getTag()) {
            throw zzdse.e();
        }
        a((zzdus<T, B>) b, i, (int) b(a));
        return true;
    }

    abstract T b(B b);

    abstract void b(B b, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, zzdvl zzdvlVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B e(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);
}
