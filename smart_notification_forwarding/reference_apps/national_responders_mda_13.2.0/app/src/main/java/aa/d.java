package aa;

import bb.b0;
import bb.i0;
import bb.n0;
import bb.o0;
import bb.t;
import bb.v0;
import bb.x0;
import java.util.List;
import java.util.Objects;
import m8.o;
import n9.a1;
import n9.h;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final la.b f343a = new la.b("java.lang.Class");

    /* loaded from: classes.dex */
    public static final class a extends l implements x8.a<i0> {

        /* renamed from: f */
        final /* synthetic */ a1 f344f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(a1 a1Var) {
            super(0);
            this.f344f = a1Var;
        }

        @Override // x8.a
        /* renamed from: a */
        public final i0 b() {
            i0 j10 = t.j("Can't compute erased upper bound of type parameter `" + this.f344f + '`');
            k.d(j10, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
            return j10;
        }
    }

    public static final /* synthetic */ la.b a() {
        return f343a;
    }

    public static final b0 b(a1 a1Var, a1 a1Var2, x8.a<? extends b0> aVar) {
        k.e(a1Var, "<this>");
        k.e(aVar, "defaultValue");
        if (a1Var == a1Var2) {
            return aVar.b();
        }
        List<b0> upperBounds = a1Var.getUpperBounds();
        k.d(upperBounds, "upperBounds");
        b0 b0Var = (b0) o.H(upperBounds);
        if (b0Var.W0().o() instanceof n9.e) {
            k.d(b0Var, "firstUpperBound");
            return eb.a.m(b0Var);
        }
        if (a1Var2 != null) {
            a1Var = a1Var2;
        }
        h o10 = b0Var.W0().o();
        while (true) {
            Objects.requireNonNull(o10, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            a1 a1Var3 = (a1) o10;
            if (k.a(a1Var3, a1Var)) {
                return aVar.b();
            }
            List<b0> upperBounds2 = a1Var3.getUpperBounds();
            k.d(upperBounds2, "current.upperBounds");
            b0 b0Var2 = (b0) o.H(upperBounds2);
            if (b0Var2.W0().o() instanceof n9.e) {
                k.d(b0Var2, "nextUpperBound");
                return eb.a.m(b0Var2);
            }
            o10 = b0Var2.W0().o();
        }
    }

    public static /* synthetic */ b0 c(a1 a1Var, a1 a1Var2, x8.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            a1Var2 = null;
        }
        if ((i10 & 2) != 0) {
            aVar = new a(a1Var);
        }
        return b(a1Var, a1Var2, aVar);
    }

    public static final v0 d(a1 a1Var, aa.a aVar) {
        k.e(a1Var, "typeParameter");
        k.e(aVar, "attr");
        return aVar.d() == w9.k.SUPERTYPE ? new x0(o0.a(a1Var)) : new n0(a1Var);
    }

    public static final aa.a e(w9.k kVar, boolean z10, a1 a1Var) {
        k.e(kVar, "<this>");
        return new aa.a(kVar, null, z10, a1Var, 2, null);
    }

    public static /* synthetic */ aa.a f(w9.k kVar, boolean z10, a1 a1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            a1Var = null;
        }
        return e(kVar, z10, a1Var);
    }
}
