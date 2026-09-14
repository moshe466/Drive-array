package db;

import bb.h1;

/* loaded from: classes.dex */
public final class o {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8852a;

        static {
            int[] iArr = new int[h1.valuesCustom().length];
            iArr[h1.INVARIANT.ordinal()] = 1;
            iArr[h1.IN_VARIANCE.ordinal()] = 2;
            iArr[h1.OUT_VARIANCE.ordinal()] = 3;
            f8852a = iArr;
        }
    }

    public static final r a(h1 h1Var) {
        y8.k.e(h1Var, "<this>");
        int i10 = a.f8852a[h1Var.ordinal()];
        if (i10 == 1) {
            return r.INV;
        }
        if (i10 == 2) {
            return r.IN;
        }
        if (i10 == 3) {
            return r.OUT;
        }
        throw new l8.l();
    }
}
