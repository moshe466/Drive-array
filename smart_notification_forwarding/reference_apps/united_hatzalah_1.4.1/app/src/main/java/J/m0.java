package J;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public class m0 {

    /* renamed from: b, reason: collision with root package name */
    public static final p0 f1014b;

    /* renamed from: a, reason: collision with root package name */
    public final p0 f1015a;

    static {
        e0 z3;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            z3 = new d0();
        } else if (i >= 31) {
            z3 = new c0();
        } else if (i >= 30) {
            z3 = new b0();
        } else if (i >= 29) {
            z3 = new a0();
        } else {
            z3 = new Z();
        }
        f1014b = z3.b().f1022a.a().f1022a.b().f1022a.c();
    }

    public m0(p0 p0Var) {
        this.f1015a = p0Var;
    }

    public p0 a() {
        return this.f1015a;
    }

    public p0 b() {
        return this.f1015a;
    }

    public p0 c() {
        return this.f1015a;
    }

    public C0121i e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        if (m() == m0Var.m() && l() == m0Var.l() && Objects.equals(i(), m0Var.i()) && Objects.equals(g(), m0Var.g()) && Objects.equals(e(), m0Var.e())) {
            return true;
        }
        return false;
    }

    public A.c f() {
        return i();
    }

    public A.c g() {
        return A.c.f1e;
    }

    public A.c h() {
        return i();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(m()), Boolean.valueOf(l()), i(), g(), e());
    }

    public A.c i() {
        return A.c.f1e;
    }

    public A.c j() {
        return i();
    }

    public p0 k(int i, int i3, int i4, int i5) {
        return f1014b;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public boolean n(int i) {
        return true;
    }

    public void d(View view) {
    }

    public void o(A.c[] cVarArr) {
    }

    public void p(p0 p0Var) {
    }

    public void q(A.c cVar) {
    }

    public void r(int i) {
    }
}
