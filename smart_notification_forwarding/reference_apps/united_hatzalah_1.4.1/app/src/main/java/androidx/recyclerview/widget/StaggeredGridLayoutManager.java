package androidx.recyclerview.widget;

import F0.AbstractC0083t;
import F0.G1;
import G.a;
import J.S;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.lifecycle.N;
import java.util.BitSet;
import java.util.WeakHashMap;
import k0.C0472C;
import k0.C0488l;
import k0.H;
import k0.J;
import k0.K;
import k0.t;
import k0.u;
import k0.z;
import p3.h;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends t {

    /* renamed from: h, reason: collision with root package name */
    public final int f3729h;
    public final K[] i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC0083t f3730j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0083t f3731k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3732l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3733m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3734n = false;

    /* renamed from: o, reason: collision with root package name */
    public final G1 f3735o;
    public final int p;

    /* renamed from: q, reason: collision with root package name */
    public J f3736q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f3737r;

    /* renamed from: s, reason: collision with root package name */
    public final a f3738s;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i3) {
        this.f3729h = -1;
        this.f3733m = false;
        G1 g12 = new G1(20);
        this.f3735o = g12;
        this.p = 2;
        new Rect();
        new N(this, 22);
        this.f3737r = true;
        this.f3738s = new a(this, 6);
        C0488l w3 = t.w(context, attributeSet, i, i3);
        int i4 = w3.f5256b;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i4 != this.f3732l) {
            this.f3732l = i4;
            AbstractC0083t abstractC0083t = this.f3730j;
            this.f3730j = this.f3731k;
            this.f3731k = abstractC0083t;
            H();
        }
        int i5 = w3.f5257c;
        a(null);
        if (i5 != this.f3729h) {
            g12.f218b = null;
            H();
            this.f3729h = i5;
            new BitSet(this.f3729h);
            this.i = new K[this.f3729h];
            for (int i6 = 0; i6 < this.f3729h; i6++) {
                this.i[i6] = new K(this, i6);
            }
            H();
        }
        boolean z3 = w3.f5258d;
        a(null);
        J j2 = this.f3736q;
        if (j2 != null && j2.f5189k != z3) {
            j2.f5189k = z3;
        }
        this.f3733m = z3;
        H();
        this.f3730j = AbstractC0083t.d(this, this.f3732l);
        this.f3731k = AbstractC0083t.d(this, 1 - this.f3732l);
    }

    @Override // k0.t
    public final void A(AccessibilityEvent accessibilityEvent) {
        super.A(accessibilityEvent);
        if (p() > 0) {
            View M3 = M(false);
            View L3 = L(false);
            if (M3 != null && L3 != null) {
                ((u) M3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    @Override // k0.t
    public final void B(Parcelable parcelable) {
        if (parcelable instanceof J) {
            this.f3736q = (J) parcelable;
            H();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [k0.J, android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [k0.J, android.os.Parcelable, java.lang.Object] */
    @Override // k0.t
    public final Parcelable C() {
        View M3;
        J j2 = this.f3736q;
        if (j2 != null) {
            ?? obj = new Object();
            obj.f5184c = j2.f5184c;
            obj.f5182a = j2.f5182a;
            obj.f5183b = j2.f5183b;
            obj.f5185d = j2.f5185d;
            obj.f5186e = j2.f5186e;
            obj.f5187f = j2.f5187f;
            obj.f5189k = j2.f5189k;
            obj.f5190l = j2.f5190l;
            obj.f5191m = j2.f5191m;
            obj.f5188j = j2.f5188j;
            return obj;
        }
        ?? obj2 = new Object();
        obj2.f5189k = this.f3733m;
        obj2.f5190l = false;
        obj2.f5191m = false;
        obj2.f5186e = 0;
        if (p() > 0) {
            N();
            obj2.f5182a = 0;
            if (this.f3734n) {
                M3 = L(true);
            } else {
                M3 = M(true);
            }
            if (M3 == null) {
                obj2.f5183b = -1;
                int i = this.f3729h;
                obj2.f5184c = i;
                obj2.f5185d = new int[i];
                for (int i3 = 0; i3 < this.f3729h; i3++) {
                    K k4 = this.i[i3];
                    int i4 = k4.f5193b;
                    if (i4 == Integer.MIN_VALUE) {
                        if (k4.f5192a.size() == 0) {
                            i4 = Integer.MIN_VALUE;
                        } else {
                            View view = (View) k4.f5192a.get(0);
                            H h2 = (H) view.getLayoutParams();
                            k4.f5193b = k4.f5196e.f3730j.i(view);
                            h2.getClass();
                            i4 = k4.f5193b;
                        }
                    }
                    if (i4 != Integer.MIN_VALUE) {
                        i4 -= this.f3730j.k();
                    }
                    obj2.f5185d[i3] = i4;
                }
                return obj2;
            }
            ((u) M3.getLayoutParams()).getClass();
            throw null;
        }
        obj2.f5182a = -1;
        obj2.f5183b = -1;
        obj2.f5184c = 0;
        return obj2;
    }

    @Override // k0.t
    public final void D(int i) {
        if (i == 0) {
            J();
        }
    }

    public final boolean J() {
        if (p() == 0 || this.p == 0 || !this.f5272e) {
            return false;
        }
        boolean z3 = this.f3734n;
        if (z3) {
            O();
            N();
        } else {
            N();
            O();
        }
        int p = p();
        int i = p - 1;
        int i3 = this.f3729h;
        new BitSet(i3).set(0, i3, true);
        if (this.f3732l == 1) {
            RecyclerView recyclerView = this.f5269b;
            WeakHashMap weakHashMap = S.f954a;
            if (recyclerView.getLayoutDirection() != 1) {
            }
        }
        if (z3) {
            p = -1;
        } else {
            i = 0;
        }
        if (i == p) {
            return false;
        }
        ((H) o(i).getLayoutParams()).getClass();
        throw null;
    }

    public final void K(C0472C c0472c) {
        if (p() != 0) {
            boolean z3 = !this.f3737r;
            View M3 = M(z3);
            View L3 = L(z3);
            if (p() != 0 && c0472c.a() != 0 && M3 != null && L3 != null) {
                ((u) M3.getLayoutParams()).getClass();
                throw null;
            }
        }
    }

    public final View L(boolean z3) {
        int k4 = this.f3730j.k();
        int j2 = this.f3730j.j();
        View view = null;
        for (int p = p() - 1; p >= 0; p--) {
            View o2 = o(p);
            int i = this.f3730j.i(o2);
            int h2 = this.f3730j.h(o2);
            if (h2 > k4 && i < j2) {
                if (h2 > j2 && z3) {
                    if (view == null) {
                        view = o2;
                    }
                } else {
                    return o2;
                }
            }
        }
        return view;
    }

    public final View M(boolean z3) {
        int k4 = this.f3730j.k();
        int j2 = this.f3730j.j();
        int p = p();
        View view = null;
        for (int i = 0; i < p; i++) {
            View o2 = o(i);
            int i3 = this.f3730j.i(o2);
            if (this.f3730j.h(o2) > k4 && i3 < j2) {
                if (i3 < k4 && z3) {
                    if (view == null) {
                        view = o2;
                    }
                } else {
                    return o2;
                }
            }
        }
        return view;
    }

    public final void N() {
        if (p() == 0) {
            return;
        }
        t.v(o(0));
        throw null;
    }

    public final void O() {
        int p = p();
        if (p == 0) {
            return;
        }
        t.v(o(p - 1));
        throw null;
    }

    @Override // k0.t
    public final void a(String str) {
        RecyclerView recyclerView;
        if (this.f3736q == null && (recyclerView = this.f5269b) != null) {
            recyclerView.b(str);
        }
    }

    @Override // k0.t
    public final boolean b() {
        if (this.f3732l == 0) {
            return true;
        }
        return false;
    }

    @Override // k0.t
    public final boolean c() {
        if (this.f3732l == 1) {
            return true;
        }
        return false;
    }

    @Override // k0.t
    public final boolean d(u uVar) {
        return uVar instanceof H;
    }

    @Override // k0.t
    public final int f(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        boolean z3 = !this.f3737r;
        return h.k(c0472c, this.f3730j, M(z3), L(z3), this, this.f3737r);
    }

    @Override // k0.t
    public final void g(C0472C c0472c) {
        K(c0472c);
    }

    @Override // k0.t
    public final int h(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        boolean z3 = !this.f3737r;
        return h.l(c0472c, this.f3730j, M(z3), L(z3), this, this.f3737r);
    }

    @Override // k0.t
    public final int i(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        boolean z3 = !this.f3737r;
        return h.k(c0472c, this.f3730j, M(z3), L(z3), this, this.f3737r);
    }

    @Override // k0.t
    public final void j(C0472C c0472c) {
        K(c0472c);
    }

    @Override // k0.t
    public final int k(C0472C c0472c) {
        if (p() == 0) {
            return 0;
        }
        boolean z3 = !this.f3737r;
        return h.l(c0472c, this.f3730j, M(z3), L(z3), this, this.f3737r);
    }

    @Override // k0.t
    public final u l() {
        if (this.f3732l == 0) {
            return new u(-2, -1);
        }
        return new u(-1, -2);
    }

    @Override // k0.t
    public final u m(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    @Override // k0.t
    public final u n(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new u((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new u(layoutParams);
    }

    @Override // k0.t
    public final int q(z zVar, C0472C c0472c) {
        if (this.f3732l == 1) {
            return this.f3729h;
        }
        super.q(zVar, c0472c);
        return 1;
    }

    @Override // k0.t
    public final int x(z zVar, C0472C c0472c) {
        if (this.f3732l == 0) {
            return this.f3729h;
        }
        super.x(zVar, c0472c);
        return 1;
    }

    @Override // k0.t
    public final boolean y() {
        if (this.p != 0) {
            return true;
        }
        return false;
    }

    @Override // k0.t
    public final void z(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f5269b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f3738s);
        }
        for (int i = 0; i < this.f3729h; i++) {
            K k4 = this.i[i];
            k4.f5192a.clear();
            k4.f5193b = Integer.MIN_VALUE;
            k4.f5194c = Integer.MIN_VALUE;
        }
        recyclerView.requestLayout();
    }
}
