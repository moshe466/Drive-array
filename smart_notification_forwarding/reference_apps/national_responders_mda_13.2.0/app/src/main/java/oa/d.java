package oa;

import ab.f;
import ab.n;
import bb.b0;
import bb.e0;
import bb.h1;
import bb.v0;
import bb.x0;
import bb.y0;
import bb.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import m8.r;
import n9.a1;
import n9.h;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends l implements x8.a<b0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ v0 f12640f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(v0 v0Var) {
            super(0);
            this.f12640f = v0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 b() {
            b0 b10 = this.f12640f.b();
            k.d(b10, "this@createCapturedIfNeeded.type");
            return b10;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends bb.l {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f12641c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z10, y0 y0Var) {
            super(y0Var);
            this.f12641c = z10;
        }

        @Override // bb.y0
        public boolean b() {
            return this.f12641c;
        }

        @Override // bb.l, bb.y0
        public v0 e(b0 b0Var) {
            k.e(b0Var, "key");
            v0 e10 = super.e(b0Var);
            if (e10 == null) {
                return null;
            }
            h o10 = b0Var.W0().o();
            return d.b(e10, o10 instanceof a1 ? (a1) o10 : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v0 b(v0 v0Var, a1 a1Var) {
        if (a1Var == null || v0Var.c() == h1.INVARIANT) {
            return v0Var;
        }
        if (a1Var.v() != v0Var.c()) {
            return new x0(c(v0Var));
        }
        if (!v0Var.d()) {
            return new x0(v0Var.b());
        }
        n nVar = f.f359e;
        k.d(nVar, "NO_LOCKS");
        return new x0(new e0(nVar, new a(v0Var)));
    }

    public static final b0 c(v0 v0Var) {
        k.e(v0Var, "typeProjection");
        return new oa.a(v0Var, null, false, null, 14, null);
    }

    public static final boolean d(b0 b0Var) {
        k.e(b0Var, "<this>");
        return b0Var.W0() instanceof oa.b;
    }

    public static final y0 e(y0 y0Var, boolean z10) {
        List<l8.n> c02;
        int n10;
        k.e(y0Var, "<this>");
        if (!(y0Var instanceof z)) {
            return new b(z10, y0Var);
        }
        z zVar = (z) y0Var;
        a1[] i10 = zVar.i();
        c02 = m8.k.c0(zVar.h(), zVar.i());
        n10 = r.n(c02, 10);
        ArrayList arrayList = new ArrayList(n10);
        for (l8.n nVar : c02) {
            arrayList.add(b((v0) nVar.c(), (a1) nVar.d()));
        }
        Object[] array = arrayList.toArray(new v0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new z(i10, (v0[]) array, z10);
    }

    public static /* synthetic */ y0 f(y0 y0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return e(y0Var, z10);
    }
}
