package ea;

import bb.b0;
import bb.c0;
import bb.i0;

/* loaded from: classes.dex */
public final class g implements xa.q {

    /* renamed from: a, reason: collision with root package name */
    public static final g f9305a = new g();

    private g() {
    }

    @Override // xa.q
    public b0 a(ga.q qVar, String str, i0 i0Var, i0 i0Var2) {
        y8.k.e(qVar, "proto");
        y8.k.e(str, "flexibleId");
        y8.k.e(i0Var, "lowerBound");
        y8.k.e(i0Var2, "upperBound");
        if (y8.k.a(str, "kotlin.jvm.PlatformType")) {
            if (qVar.y(ja.a.f10979g)) {
                return new aa.f(i0Var, i0Var2);
            }
            c0 c0Var = c0.f4165a;
            return c0.d(i0Var, i0Var2);
        }
        i0 j10 = bb.t.j("Error java flexible type with id: " + str + ". (" + i0Var + ".." + i0Var2 + ')');
        y8.k.d(j10, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return j10;
    }
}
