package xa;

import bb.i0;

/* loaded from: classes.dex */
public interface q {

    /* loaded from: classes.dex */
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15626a = new a();

        private a() {
        }

        @Override // xa.q
        public bb.b0 a(ga.q qVar, String str, i0 i0Var, i0 i0Var2) {
            y8.k.e(qVar, "proto");
            y8.k.e(str, "flexibleId");
            y8.k.e(i0Var, "lowerBound");
            y8.k.e(i0Var2, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    bb.b0 a(ga.q qVar, String str, i0 i0Var, i0 i0Var2);
}
