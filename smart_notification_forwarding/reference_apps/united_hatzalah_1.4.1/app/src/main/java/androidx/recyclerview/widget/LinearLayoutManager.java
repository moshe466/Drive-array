package androidx.recyclerview.widget;

import F0.AbstractC0083t;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.lifecycle.N;
import e0.a;
import k0.C0472C;
import k0.C0488l;
import k0.C0489m;
import k0.t;
import k0.u;
import p3.h;

/* loaded from: classes.dex */
public class LinearLayoutManager extends t {

    /* renamed from: h, reason: collision with root package name */
    public final int f3664h;
    public N i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC0083t f3665j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3666k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3667l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3668m = false;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3669n = true;

    /* renamed from: o, reason: collision with root package name */
    public C0489m f3670o = null;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i3) {
        this.f3664h = 1;
        this.f3666k = false;
        C0488l c0488l = new C0488l(0);
        c0488l.f5256b = -1;
        c0488l.f5257c = Integer.MIN_VALUE;
        c0488l.f5258d = false;
        c0488l.f5259e = false;
        C0488l w3 = t.w(context, attributeSet, i, i3);
        int i4 = w3.f5256b;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException(a.c(i4, "invalid orientation:"));
        }
        a(null);
        if (i4 != this.f3664h || this.f3665j == null) {
            this.f3665j = AbstractC0083t.d(this, i4);
            this.f3664h = i4;
            H();
        }
        boolean z3 = w3.f5258d;
        a(null);
        if (z3 != this.f3666k) {
            this.f3666k = z3;
            H();
        }
        Q(w3.f5259e);
    }

    @Override // k0.t
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View P3 = P(0, p(), false);
            if (P3 == null) {
                accessibilityEvent.setFromIndex(-1);
                View P4 = P(p() - 1, -1, false);
                if (P4 == null) {
                    accessibilityEvent.setToIndex(-1);
                    return;
                } else {
                    ((u) P4.getLayoutParams()).getClass();
                    throw null;
                }
            }
            ((u) P3.getLayoutParams()).getClass();
            throw null;
        }
    }

    @Override // k0.t
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof C0489m) {
            this.f3670o = (C0489m) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.Parcelable, k0.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.os.Parcelable, k0.m, java.lang.Object] */
    @Override // k0.t
    public final Parcelable C() {
        C0489m c0489m = this.f3670o;
        if (c0489m != null) {
            ?? obj = new Object();
            obj.f5260a = c0489m.f5260a;
            obj.f5261b = c0489m.f5261b;
            obj.f5262c = c0489m.f5262c;
            return obj;
        }
        ?? obj2 = new Object();
        if (p() > 0) {
            M();
            boolean z3 = this.f3667l;
            obj2.f5262c = z3;
            int i = 0;
            if (z3) {
                if (!z3) {
                    i = p() - 1;
                }
                View o2 = o(i);
                obj2.f5261b = this.f3665j.j() - this.f3665j.h(o2);
                t.v(o2);
                throw null;
            }
            if (z3) {
                i = p() - 1;
            }
            t.v(o(i));
            throw null;
        }
        obj2.f5260a = -1;
        return obj2;
    }

    public final int J(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z3 = !this.f3669n;
        return h.k(c0472c, this.f3665j, O(z3), N(z3), this, this.f3669n);
    }

    public final void K(C0472C c0472c) {
        if (p() != 0) {
            M();
            boolean z3 = !this.f3669n;
            View O3 = O(z3);
            View N3 = N(z3);
            if (p() != 0 && c0472c.a() != 0 && O3 != null && N3 != null) {
                ((u) O3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final int L(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        M();
        boolean z3 = !this.f3669n;
        return h.l(c0472c, this.f3665j, O(z3), N(z3), this, this.f3669n);
    }

    public final void M() {
        if (this.i == null) {
            this.i = new N(18);
        }
    }

    public final View N(boolean z3) {
        if (this.f3667l) {
            return P(0, p(), z3);
        }
        return P(p() - 1, -1, z3);
    }

    public final View O(boolean z3) {
        if (this.f3667l) {
            return P(p() - 1, -1, z3);
        }
        return P(0, p(), z3);
    }

    public final View P(int i, int i3, boolean z3) {
        int i4;
        M();
        if (z3) {
            i4 = 24579;
        } else {
            i4 = 320;
        }
        if (this.f3664h == 0) {
            return this.f5270c.h(i, i3, i4, 320);
        }
        return this.f5271d.h(i, i3, i4, 320);
    }

    public void Q(boolean z3) {
        a(null);
        if (this.f3668m == z3) {
            return;
        }
        this.f3668m = z3;
        H();
    }

    @Override // k0.t
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.f3670o == null && (recyclerView = this.f5269b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // k0.t
    public final boolean b() {
        if (this.f3664h == 0) {
            return true;
        }
        return false;
    }

    @Override // k0.t
    public final boolean c() {
        if (this.f3664h == 1) {
            return true;
        }
        return false;
    }

    @Override // k0.t
    public final int f(C0472C c0472c) {
        return J(c0472c);
    }

    @Override // k0.t
    public final void g(C0472C c0472c) {
        K(c0472c);
    }

    @Override // k0.t
    public final int h(C0472C c0472c) {
        return L(c0472c);
    }

    @Override // k0.t
    public final int i(C0472C c0472c) {
        return J(c0472c);
    }

    @Override // k0.t
    public final void j(C0472C c0472c) {
        K(c0472c);
    }

    @Override // k0.t
    public final int k(C0472C c0472c) {
        return L(c0472c);
    }

    @Override // k0.t
    public u l() {
        return new u(-2, -2);
    }

    @Override // k0.t
    public final boolean y() {
        return true;
    }

    @Override // k0.t
    public final void z(RecyclerView recyclerView) {
    }
}
