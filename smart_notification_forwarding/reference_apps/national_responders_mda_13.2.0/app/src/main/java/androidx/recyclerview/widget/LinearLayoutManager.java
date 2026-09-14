package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;

    /* renamed from: s, reason: collision with root package name */
    int f3269s;

    /* renamed from: t, reason: collision with root package name */
    private c f3270t;

    /* renamed from: u, reason: collision with root package name */
    j f3271u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f3272v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f3273w;

    /* renamed from: x, reason: collision with root package name */
    boolean f3274x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3275y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3276z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        j f3277a;

        /* renamed from: b, reason: collision with root package name */
        int f3278b;

        /* renamed from: c, reason: collision with root package name */
        int f3279c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3280d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3281e;

        a() {
            e();
        }

        void a() {
            this.f3279c = this.f3280d ? this.f3277a.i() : this.f3277a.m();
        }

        public void b(View view, int i10) {
            this.f3279c = this.f3280d ? this.f3277a.d(view) + this.f3277a.o() : this.f3277a.g(view);
            this.f3278b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f3277a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f3278b = i10;
            if (this.f3280d) {
                int i11 = (this.f3277a.i() - o10) - this.f3277a.d(view);
                this.f3279c = this.f3277a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f3279c - this.f3277a.e(view);
                    int m10 = this.f3277a.m();
                    int min = e10 - (m10 + Math.min(this.f3277a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f3279c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f3277a.g(view);
            int m11 = g10 - this.f3277a.m();
            this.f3279c = g10;
            if (m11 > 0) {
                int i12 = (this.f3277a.i() - Math.min(0, (this.f3277a.i() - o10) - this.f3277a.d(view))) - (g10 + this.f3277a.e(view));
                if (i12 < 0) {
                    this.f3279c -= Math.min(m11, -i12);
                }
            }
        }

        boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        void e() {
            this.f3278b = -1;
            this.f3279c = Integer.MIN_VALUE;
            this.f3280d = false;
            this.f3281e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3278b + ", mCoordinate=" + this.f3279c + ", mLayoutFromEnd=" + this.f3280d + ", mValid=" + this.f3281e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3282a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3283b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3284c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3285d;

        protected b() {
        }

        void a() {
            this.f3282a = 0;
            this.f3283b = false;
            this.f3284c = false;
            this.f3285d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f3287b;

        /* renamed from: c, reason: collision with root package name */
        int f3288c;

        /* renamed from: d, reason: collision with root package name */
        int f3289d;

        /* renamed from: e, reason: collision with root package name */
        int f3290e;

        /* renamed from: f, reason: collision with root package name */
        int f3291f;

        /* renamed from: g, reason: collision with root package name */
        int f3292g;

        /* renamed from: i, reason: collision with root package name */
        boolean f3294i;

        /* renamed from: j, reason: collision with root package name */
        int f3295j;

        /* renamed from: l, reason: collision with root package name */
        boolean f3297l;

        /* renamed from: a, reason: collision with root package name */
        boolean f3286a = true;

        /* renamed from: h, reason: collision with root package name */
        int f3293h = 0;

        /* renamed from: k, reason: collision with root package name */
        List<RecyclerView.d0> f3296k = null;

        c() {
        }

        private View e() {
            int size = this.f3296k.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f3296k.get(i10).f3375a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f3289d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f10 = f(view);
            this.f3289d = f10 == null ? -1 : ((RecyclerView.p) f10.getLayoutParams()).a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.a0 a0Var) {
            int i10 = this.f3289d;
            return i10 >= 0 && i10 < a0Var.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.f3296k != null) {
                return e();
            }
            View o10 = vVar.o(this.f3289d);
            this.f3289d += this.f3290e;
            return o10;
        }

        public View f(View view) {
            int a10;
            int size = this.f3296k.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f3296k.get(i11).f3375a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a10 = (pVar.a() - this.f3289d) * this.f3290e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        int f3298f;

        /* renamed from: g, reason: collision with root package name */
        int f3299g;

        /* renamed from: h, reason: collision with root package name */
        boolean f3300h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f3298f = parcel.readInt();
            this.f3299g = parcel.readInt();
            this.f3300h = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f3298f = dVar.f3298f;
            this.f3299g = dVar.f3299g;
            this.f3300h = dVar.f3300h;
        }

        boolean a() {
            return this.f3298f >= 0;
        }

        void b() {
            this.f3298f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3298f);
            parcel.writeInt(this.f3299g);
            parcel.writeInt(this.f3300h ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f3269s = 1;
        this.f3273w = false;
        this.f3274x = false;
        this.f3275y = false;
        this.f3276z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        z2(i10);
        A2(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3269s = 1;
        this.f3273w = false;
        this.f3274x = false;
        this.f3275y = false;
        this.f3276z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i10, i11);
        z2(i02.f3426a);
        A2(i02.f3428c);
        B2(i02.f3429d);
    }

    private boolean C2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (J() == 0) {
            return false;
        }
        View V = V();
        if (V != null && aVar.d(V, a0Var)) {
            aVar.c(V, h0(V));
            return true;
        }
        if (this.f3272v != this.f3275y) {
            return false;
        }
        View g22 = aVar.f3280d ? g2(vVar, a0Var) : h2(vVar, a0Var);
        if (g22 == null) {
            return false;
        }
        aVar.b(g22, h0(g22));
        if (!a0Var.e() && K1()) {
            if (this.f3271u.g(g22) >= this.f3271u.i() || this.f3271u.d(g22) < this.f3271u.m()) {
                aVar.f3279c = aVar.f3280d ? this.f3271u.i() : this.f3271u.m();
            }
        }
        return true;
    }

    private boolean D2(RecyclerView.a0 a0Var, a aVar) {
        int i10;
        if (!a0Var.e() && (i10 = this.A) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                aVar.f3278b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    boolean z10 = this.D.f3300h;
                    aVar.f3280d = z10;
                    aVar.f3279c = z10 ? this.f3271u.i() - this.D.f3299g : this.f3271u.m() + this.D.f3299g;
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z11 = this.f3274x;
                    aVar.f3280d = z11;
                    aVar.f3279c = z11 ? this.f3271u.i() - this.B : this.f3271u.m() + this.B;
                    return true;
                }
                View C = C(this.A);
                if (C == null) {
                    if (J() > 0) {
                        aVar.f3280d = (this.A < h0(I(0))) == this.f3274x;
                    }
                    aVar.a();
                } else {
                    if (this.f3271u.e(C) > this.f3271u.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f3271u.g(C) - this.f3271u.m() < 0) {
                        aVar.f3279c = this.f3271u.m();
                        aVar.f3280d = false;
                        return true;
                    }
                    if (this.f3271u.i() - this.f3271u.d(C) < 0) {
                        aVar.f3279c = this.f3271u.i();
                        aVar.f3280d = true;
                        return true;
                    }
                    aVar.f3279c = aVar.f3280d ? this.f3271u.d(C) + this.f3271u.o() : this.f3271u.g(C);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    private void E2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (D2(a0Var, aVar) || C2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f3278b = this.f3275y ? a0Var.b() - 1 : 0;
    }

    private void F2(int i10, int i11, boolean z10, RecyclerView.a0 a0Var) {
        int m10;
        this.f3270t.f3297l = w2();
        this.f3270t.f3293h = m2(a0Var);
        c cVar = this.f3270t;
        cVar.f3291f = i10;
        if (i10 == 1) {
            cVar.f3293h += this.f3271u.j();
            View k22 = k2();
            c cVar2 = this.f3270t;
            cVar2.f3290e = this.f3274x ? -1 : 1;
            int h02 = h0(k22);
            c cVar3 = this.f3270t;
            cVar2.f3289d = h02 + cVar3.f3290e;
            cVar3.f3287b = this.f3271u.d(k22);
            m10 = this.f3271u.d(k22) - this.f3271u.i();
        } else {
            View l22 = l2();
            this.f3270t.f3293h += this.f3271u.m();
            c cVar4 = this.f3270t;
            cVar4.f3290e = this.f3274x ? 1 : -1;
            int h03 = h0(l22);
            c cVar5 = this.f3270t;
            cVar4.f3289d = h03 + cVar5.f3290e;
            cVar5.f3287b = this.f3271u.g(l22);
            m10 = (-this.f3271u.g(l22)) + this.f3271u.m();
        }
        c cVar6 = this.f3270t;
        cVar6.f3288c = i11;
        if (z10) {
            cVar6.f3288c = i11 - m10;
        }
        cVar6.f3292g = m10;
    }

    private void G2(int i10, int i11) {
        this.f3270t.f3288c = this.f3271u.i() - i11;
        c cVar = this.f3270t;
        cVar.f3290e = this.f3274x ? -1 : 1;
        cVar.f3289d = i10;
        cVar.f3291f = 1;
        cVar.f3287b = i11;
        cVar.f3292g = Integer.MIN_VALUE;
    }

    private void H2(a aVar) {
        G2(aVar.f3278b, aVar.f3279c);
    }

    private void I2(int i10, int i11) {
        this.f3270t.f3288c = i11 - this.f3271u.m();
        c cVar = this.f3270t;
        cVar.f3289d = i10;
        cVar.f3290e = this.f3274x ? 1 : -1;
        cVar.f3291f = -1;
        cVar.f3287b = i11;
        cVar.f3292g = Integer.MIN_VALUE;
    }

    private void J2(a aVar) {
        I2(aVar.f3278b, aVar.f3279c);
    }

    private int M1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        R1();
        return l.a(a0Var, this.f3271u, W1(!this.f3276z, true), V1(!this.f3276z, true), this, this.f3276z);
    }

    private int N1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        R1();
        return l.b(a0Var, this.f3271u, W1(!this.f3276z, true), V1(!this.f3276z, true), this, this.f3276z, this.f3274x);
    }

    private int O1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        R1();
        return l.c(a0Var, this.f3271u, W1(!this.f3276z, true), V1(!this.f3276z, true), this, this.f3276z);
    }

    private View T1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return b2(0, J());
    }

    private View U1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return f2(vVar, a0Var, 0, J(), a0Var.b());
    }

    private View V1(boolean z10, boolean z11) {
        int J;
        int i10;
        if (this.f3274x) {
            J = 0;
            i10 = J();
        } else {
            J = J() - 1;
            i10 = -1;
        }
        return c2(J, i10, z10, z11);
    }

    private View W1(boolean z10, boolean z11) {
        int i10;
        int J;
        if (this.f3274x) {
            i10 = J() - 1;
            J = -1;
        } else {
            i10 = 0;
            J = J();
        }
        return c2(i10, J, z10, z11);
    }

    private View Y1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return b2(J() - 1, -1);
    }

    private View Z1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return f2(vVar, a0Var, J() - 1, -1, a0Var.b());
    }

    private View d2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3274x ? T1(vVar, a0Var) : Y1(vVar, a0Var);
    }

    private View e2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3274x ? Y1(vVar, a0Var) : T1(vVar, a0Var);
    }

    private View g2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3274x ? U1(vVar, a0Var) : Z1(vVar, a0Var);
    }

    private View h2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3274x ? Z1(vVar, a0Var) : U1(vVar, a0Var);
    }

    private int i2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i11;
        int i12 = this.f3271u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -y2(-i12, vVar, a0Var);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f3271u.i() - i14) <= 0) {
            return i13;
        }
        this.f3271u.r(i11);
        return i11 + i13;
    }

    private int j2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int m11 = i10 - this.f3271u.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -y2(m11, vVar, a0Var);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.f3271u.m()) <= 0) {
            return i11;
        }
        this.f3271u.r(-m10);
        return i11 - m10;
    }

    private View k2() {
        return I(this.f3274x ? 0 : J() - 1);
    }

    private View l2() {
        return I(this.f3274x ? J() - 1 : 0);
    }

    private void q2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11) {
        if (!a0Var.g() || J() == 0 || a0Var.e() || !K1()) {
            return;
        }
        List<RecyclerView.d0> k10 = vVar.k();
        int size = k10.size();
        int h02 = h0(I(0));
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView.d0 d0Var = k10.get(i14);
            if (!d0Var.u()) {
                char c10 = (d0Var.m() < h02) != this.f3274x ? (char) 65535 : (char) 1;
                int e10 = this.f3271u.e(d0Var.f3375a);
                if (c10 == 65535) {
                    i12 += e10;
                } else {
                    i13 += e10;
                }
            }
        }
        this.f3270t.f3296k = k10;
        if (i12 > 0) {
            I2(h0(l2()), i10);
            c cVar = this.f3270t;
            cVar.f3293h = i12;
            cVar.f3288c = 0;
            cVar.a();
            S1(vVar, this.f3270t, a0Var, false);
        }
        if (i13 > 0) {
            G2(h0(k2()), i11);
            c cVar2 = this.f3270t;
            cVar2.f3293h = i13;
            cVar2.f3288c = 0;
            cVar2.a();
            S1(vVar, this.f3270t, a0Var, false);
        }
        this.f3270t.f3296k = null;
    }

    private void s2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f3286a || cVar.f3297l) {
            return;
        }
        int i10 = cVar.f3291f;
        int i11 = cVar.f3292g;
        if (i10 == -1) {
            u2(vVar, i11);
        } else {
            v2(vVar, i11);
        }
    }

    private void t2(RecyclerView.v vVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                n1(i10, vVar);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                n1(i12, vVar);
            }
        }
    }

    private void u2(RecyclerView.v vVar, int i10) {
        int J = J();
        if (i10 < 0) {
            return;
        }
        int h10 = this.f3271u.h() - i10;
        if (this.f3274x) {
            for (int i11 = 0; i11 < J; i11++) {
                View I = I(i11);
                if (this.f3271u.g(I) < h10 || this.f3271u.q(I) < h10) {
                    t2(vVar, 0, i11);
                    return;
                }
            }
            return;
        }
        int i12 = J - 1;
        for (int i13 = i12; i13 >= 0; i13--) {
            View I2 = I(i13);
            if (this.f3271u.g(I2) < h10 || this.f3271u.q(I2) < h10) {
                t2(vVar, i12, i13);
                return;
            }
        }
    }

    private void v2(RecyclerView.v vVar, int i10) {
        if (i10 < 0) {
            return;
        }
        int J = J();
        if (!this.f3274x) {
            for (int i11 = 0; i11 < J; i11++) {
                View I = I(i11);
                if (this.f3271u.d(I) > i10 || this.f3271u.p(I) > i10) {
                    t2(vVar, 0, i11);
                    return;
                }
            }
            return;
        }
        int i12 = J - 1;
        for (int i13 = i12; i13 >= 0; i13--) {
            View I2 = I(i13);
            if (this.f3271u.d(I2) > i10 || this.f3271u.p(I2) > i10) {
                t2(vVar, i12, i13);
                return;
            }
        }
    }

    private void x2() {
        this.f3274x = (this.f3269s == 1 || !o2()) ? this.f3273w : !this.f3273w;
    }

    public void A2(boolean z10) {
        g(null);
        if (z10 == this.f3273w) {
            return;
        }
        this.f3273w = z10;
        t1();
    }

    public void B2(boolean z10) {
        g(null);
        if (this.f3275y == z10) {
            return;
        }
        this.f3275y = z10;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View C(int i10) {
        int J = J();
        if (J == 0) {
            return null;
        }
        int h02 = i10 - h0(I(0));
        if (h02 >= 0 && h02 < J) {
            View I = I(h02);
            if (h0(I) == i10) {
                return I;
            }
        }
        return super.C(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean G1() {
        return (X() == 1073741824 || p0() == 1073741824 || !q0()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        if (this.C) {
            k1(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int P1;
        x2();
        if (J() == 0 || (P1 = P1(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        R1();
        R1();
        F2(P1, (int) (this.f3271u.n() * 0.33333334f), false, a0Var);
        c cVar = this.f3270t;
        cVar.f3292g = Integer.MIN_VALUE;
        cVar.f3286a = false;
        S1(vVar, cVar, a0Var, true);
        View e22 = P1 == -1 ? e2(vVar, a0Var) : d2(vVar, a0Var);
        View l22 = P1 == -1 ? l2() : k2();
        if (!l22.hasFocusable()) {
            return e22;
        }
        if (e22 == null) {
            return null;
        }
        return l22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            accessibilityEvent.setFromIndex(X1());
            accessibilityEvent.setToIndex(a2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean K1() {
        return this.D == null && this.f3272v == this.f3275y;
    }

    void L1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f3289d;
        if (i10 < 0 || i10 >= a0Var.b()) {
            return;
        }
        cVar2.a(i10, Math.max(0, cVar.f3292g));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int P1(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3269s == 1) ? 1 : Integer.MIN_VALUE : this.f3269s == 0 ? 1 : Integer.MIN_VALUE : this.f3269s == 1 ? -1 : Integer.MIN_VALUE : this.f3269s == 0 ? -1 : Integer.MIN_VALUE : (this.f3269s != 1 && o2()) ? -1 : 1 : (this.f3269s != 1 && o2()) ? 1 : -1;
    }

    c Q1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R1() {
        if (this.f3270t == null) {
            this.f3270t = Q1();
        }
    }

    int S1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10 = cVar.f3288c;
        int i11 = cVar.f3292g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f3292g = i11 + i10;
            }
            s2(vVar, cVar);
        }
        int i12 = cVar.f3288c + cVar.f3293h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.f3297l && i12 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            p2(vVar, a0Var, cVar, bVar);
            if (!bVar.f3283b) {
                cVar.f3287b += bVar.f3282a * cVar.f3291f;
                if (!bVar.f3284c || this.f3270t.f3296k != null || !a0Var.e()) {
                    int i13 = cVar.f3288c;
                    int i14 = bVar.f3282a;
                    cVar.f3288c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f3292g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f3282a;
                    cVar.f3292g = i16;
                    int i17 = cVar.f3288c;
                    if (i17 < 0) {
                        cVar.f3292g = i16 + i17;
                    }
                    s2(vVar, cVar);
                }
                if (z10 && bVar.f3285d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f3288c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i22;
        int i15;
        View C;
        int g10;
        int i16;
        int i17 = -1;
        if (!(this.D == null && this.A == -1) && a0Var.b() == 0) {
            k1(vVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.f3298f;
        }
        R1();
        this.f3270t.f3286a = false;
        x2();
        View V = V();
        a aVar = this.E;
        if (!aVar.f3281e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.E;
            aVar2.f3280d = this.f3274x ^ this.f3275y;
            E2(vVar, a0Var, aVar2);
            this.E.f3281e = true;
        } else if (V != null && (this.f3271u.g(V) >= this.f3271u.i() || this.f3271u.d(V) <= this.f3271u.m())) {
            this.E.c(V, h0(V));
        }
        int m22 = m2(a0Var);
        if (this.f3270t.f3295j >= 0) {
            i10 = m22;
            m22 = 0;
        } else {
            i10 = 0;
        }
        int m10 = m22 + this.f3271u.m();
        int j10 = i10 + this.f3271u.j();
        if (a0Var.e() && (i15 = this.A) != -1 && this.B != Integer.MIN_VALUE && (C = C(i15)) != null) {
            if (this.f3274x) {
                i16 = this.f3271u.i() - this.f3271u.d(C);
                g10 = this.B;
            } else {
                g10 = this.f3271u.g(C) - this.f3271u.m();
                i16 = this.B;
            }
            int i18 = i16 - g10;
            if (i18 > 0) {
                m10 += i18;
            } else {
                j10 -= i18;
            }
        }
        a aVar3 = this.E;
        if (!aVar3.f3280d ? !this.f3274x : this.f3274x) {
            i17 = 1;
        }
        r2(vVar, a0Var, aVar3, i17);
        w(vVar);
        this.f3270t.f3297l = w2();
        this.f3270t.f3294i = a0Var.e();
        a aVar4 = this.E;
        if (aVar4.f3280d) {
            J2(aVar4);
            c cVar = this.f3270t;
            cVar.f3293h = m10;
            S1(vVar, cVar, a0Var, false);
            c cVar2 = this.f3270t;
            i12 = cVar2.f3287b;
            int i19 = cVar2.f3289d;
            int i20 = cVar2.f3288c;
            if (i20 > 0) {
                j10 += i20;
            }
            H2(this.E);
            c cVar3 = this.f3270t;
            cVar3.f3293h = j10;
            cVar3.f3289d += cVar3.f3290e;
            S1(vVar, cVar3, a0Var, false);
            c cVar4 = this.f3270t;
            i11 = cVar4.f3287b;
            int i21 = cVar4.f3288c;
            if (i21 > 0) {
                I2(i19, i12);
                c cVar5 = this.f3270t;
                cVar5.f3293h = i21;
                S1(vVar, cVar5, a0Var, false);
                i12 = this.f3270t.f3287b;
            }
        } else {
            H2(aVar4);
            c cVar6 = this.f3270t;
            cVar6.f3293h = j10;
            S1(vVar, cVar6, a0Var, false);
            c cVar7 = this.f3270t;
            i11 = cVar7.f3287b;
            int i23 = cVar7.f3289d;
            int i24 = cVar7.f3288c;
            if (i24 > 0) {
                m10 += i24;
            }
            J2(this.E);
            c cVar8 = this.f3270t;
            cVar8.f3293h = m10;
            cVar8.f3289d += cVar8.f3290e;
            S1(vVar, cVar8, a0Var, false);
            c cVar9 = this.f3270t;
            i12 = cVar9.f3287b;
            int i25 = cVar9.f3288c;
            if (i25 > 0) {
                G2(i23, i11);
                c cVar10 = this.f3270t;
                cVar10.f3293h = i25;
                S1(vVar, cVar10, a0Var, false);
                i11 = this.f3270t.f3287b;
            }
        }
        if (J() > 0) {
            if (this.f3274x ^ this.f3275y) {
                int i26 = i2(i11, vVar, a0Var, true);
                i13 = i12 + i26;
                i14 = i11 + i26;
                i22 = j2(i13, vVar, a0Var, false);
            } else {
                int j22 = j2(i12, vVar, a0Var, true);
                i13 = i12 + j22;
                i14 = i11 + j22;
                i22 = i2(i14, vVar, a0Var, false);
            }
            i12 = i13 + i22;
            i11 = i14 + i22;
        }
        q2(vVar, a0Var, i12, i11);
        if (a0Var.e()) {
            this.E.e();
        } else {
            this.f3271u.s();
        }
        this.f3272v = this.f3275y;
    }

    public int X1() {
        View c22 = c2(0, J(), false, true);
        if (c22 == null) {
            return -1;
        }
        return h0(c22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i10) {
        if (J() == 0) {
            return null;
        }
        int i11 = (i10 < h0(I(0))) != this.f3274x ? -1 : 1;
        return this.f3269s == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    public int a2() {
        View c22 = c2(J() - 1, -1, false, true);
        if (c22 == null) {
            return -1;
        }
        return h0(c22);
    }

    View b2(int i10, int i11) {
        int i12;
        int i13;
        R1();
        if ((i11 > i10 ? (char) 1 : i11 < i10 ? (char) 65535 : (char) 0) == 0) {
            return I(i10);
        }
        if (this.f3271u.g(I(i10)) < this.f3271u.m()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return (this.f3269s == 0 ? this.f3410e : this.f3411f).a(i10, i11, i12, i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            t1();
        }
    }

    View c2(int i10, int i11, boolean z10, boolean z11) {
        R1();
        return (this.f3269s == 0 ? this.f3410e : this.f3411f).a(i10, i11, z10 ? 24579 : 320, z11 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        if (this.D != null) {
            return new d(this.D);
        }
        d dVar = new d();
        if (J() > 0) {
            R1();
            boolean z10 = this.f3272v ^ this.f3274x;
            dVar.f3300h = z10;
            if (z10) {
                View k22 = k2();
                dVar.f3299g = this.f3271u.i() - this.f3271u.d(k22);
                dVar.f3298f = h0(k22);
            } else {
                View l22 = l2();
                dVar.f3298f = h0(l22);
                dVar.f3299g = this.f3271u.g(l22) - this.f3271u.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    View f2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11, int i12) {
        R1();
        int m10 = this.f3271u.m();
        int i13 = this.f3271u.i();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View I = I(i10);
            int h02 = h0(I);
            if (h02 >= 0 && h02 < i12) {
                if (((RecyclerView.p) I.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = I;
                    }
                } else {
                    if (this.f3271u.g(I) < i13 && this.f3271u.d(I) >= m10) {
                        return I;
                    }
                    if (view == null) {
                        view = I;
                    }
                }
            }
            i10 += i14;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.D == null) {
            super.g(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f3269s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f3269s == 1;
    }

    protected int m2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.f3271u.n();
        }
        return 0;
    }

    public int n2() {
        return this.f3269s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.f3269s != 0) {
            i10 = i11;
        }
        if (J() == 0 || i10 == 0) {
            return;
        }
        R1();
        F2(i10 > 0 ? 1 : -1, Math.abs(i10), true, a0Var);
        L1(a0Var, this.f3270t, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        d dVar = this.D;
        if (dVar == null || !dVar.a()) {
            x2();
            z10 = this.f3274x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z10 = dVar2.f3300h;
            i11 = dVar2.f3298f;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.G && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    void p2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int f10;
        View d10 = cVar.d(vVar);
        if (d10 == null) {
            bVar.f3283b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d10.getLayoutParams();
        if (cVar.f3296k == null) {
            if (this.f3274x == (cVar.f3291f == -1)) {
                d(d10);
            } else {
                e(d10, 0);
            }
        } else {
            if (this.f3274x == (cVar.f3291f == -1)) {
                b(d10);
            } else {
                c(d10, 0);
            }
        }
        A0(d10, 0, 0);
        bVar.f3282a = this.f3271u.e(d10);
        if (this.f3269s == 1) {
            if (o2()) {
                f10 = o0() - f0();
                i13 = f10 - this.f3271u.f(d10);
            } else {
                i13 = e0();
                f10 = this.f3271u.f(d10) + i13;
            }
            int i14 = cVar.f3291f;
            int i15 = cVar.f3287b;
            if (i14 == -1) {
                i12 = i15;
                i11 = f10;
                i10 = i15 - bVar.f3282a;
            } else {
                i10 = i15;
                i11 = f10;
                i12 = bVar.f3282a + i15;
            }
        } else {
            int g02 = g0();
            int f11 = this.f3271u.f(d10) + g02;
            int i16 = cVar.f3291f;
            int i17 = cVar.f3287b;
            if (i16 == -1) {
                i11 = i17;
                i10 = g02;
                i12 = f11;
                i13 = i17 - bVar.f3282a;
            } else {
                i10 = g02;
                i11 = bVar.f3282a + i17;
                i12 = f11;
                i13 = i17;
            }
        }
        z0(d10, i13, i10, i11, i12);
        if (pVar.c() || pVar.b()) {
            bVar.f3284c = true;
        }
        bVar.f3285d = d10.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return M1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return N1(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return M1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return N1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return O1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f3269s == 1) {
            return 0;
        }
        return y2(i10, vVar, a0Var);
    }

    boolean w2() {
        return this.f3271u.k() == 0 && this.f3271u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        d dVar = this.D;
        if (dVar != null) {
            dVar.b();
        }
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f3269s == 0) {
            return 0;
        }
        return y2(i10, vVar, a0Var);
    }

    int y2(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i10 == 0) {
            return 0;
        }
        this.f3270t.f3286a = true;
        R1();
        int i11 = i10 > 0 ? 1 : -1;
        int abs = Math.abs(i10);
        F2(i11, abs, true, a0Var);
        c cVar = this.f3270t;
        int S1 = cVar.f3292g + S1(vVar, cVar, a0Var, false);
        if (S1 < 0) {
            return 0;
        }
        if (abs > S1) {
            i10 = i11 * S1;
        }
        this.f3271u.r(-i10);
        this.f3270t.f3295j = i10;
        return i10;
    }

    public void z2(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        g(null);
        if (i10 != this.f3269s || this.f3271u == null) {
            j b10 = j.b(this, i10);
            this.f3271u = b10;
            this.E.f3277a = b10;
            this.f3269s = i10;
            t1();
        }
    }
}
