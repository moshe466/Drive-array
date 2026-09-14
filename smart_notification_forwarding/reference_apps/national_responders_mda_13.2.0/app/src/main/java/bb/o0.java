package bb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class o0 {

    /* loaded from: classes.dex */
    public static final class a extends u0 {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<t0> f4239c;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends t0> list) {
            this.f4239c = list;
        }

        @Override // bb.u0
        public v0 j(t0 t0Var) {
            y8.k.e(t0Var, "key");
            if (!this.f4239c.contains(t0Var)) {
                return null;
            }
            n9.h A = t0Var.A();
            Objects.requireNonNull(A, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return c1.s((n9.a1) A);
        }
    }

    public static final b0 a(n9.a1 a1Var) {
        int n10;
        y8.k.e(a1Var, "<this>");
        List<n9.a1> B = ((n9.i) a1Var.d()).o().B();
        y8.k.d(B, "classDescriptor.typeConstructor.parameters");
        n10 = m8.r.n(B, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = B.iterator();
        while (it.hasNext()) {
            arrayList.add(((n9.a1) it.next()).o());
        }
        a1 g10 = a1.g(new a(arrayList));
        List<b0> upperBounds = a1Var.getUpperBounds();
        y8.k.d(upperBounds, "this.upperBounds");
        b0 p10 = g10.p((b0) m8.o.H(upperBounds), h1.OUT_VARIANCE);
        if (p10 != null) {
            return p10;
        }
        i0 y10 = ra.a.g(a1Var).y();
        y8.k.d(y10, "builtIns.defaultBound");
        return y10;
    }
}
