package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean H;
    int I;
    int[] J;
    View[] K;
    final SparseIntArray L;
    final SparseIntArray M;
    c N;
    final Rect O;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int c(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int d(int i10) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        int f3265e;

        /* renamed from: f, reason: collision with root package name */
        int f3266f;

        public b(int i10, int i11) {
            super(i10, i11);
            this.f3265e = -1;
            this.f3266f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3265e = -1;
            this.f3266f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3265e = -1;
            this.f3266f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3265e = -1;
            this.f3266f = 0;
        }

        public int e() {
            return this.f3265e;
        }

        public int f() {
            return this.f3266f;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f3267a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f3268b = false;

        int a(int i10, int i11) {
            if (!this.f3268b) {
                return c(i10, i11);
            }
            int i12 = this.f3267a.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int c10 = c(i10, i11);
            this.f3267a.put(i10, c10);
            return c10;
        }

        public int b(int i10, int i11) {
            int d10 = d(i10);
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                int d11 = d(i14);
                i12 += d11;
                if (i12 == i11) {
                    i13++;
                    i12 = 0;
                } else if (i12 > i11) {
                    i13++;
                    i12 = d11;
                }
            }
            return i12 + d10 > i11 ? i13 + 1 : i13;
        }

        public abstract int c(int i10, int i11);

        public abstract int d(int i10);

        public void e() {
            this.f3267a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.H = false;
        this.I = -1;
        this.L = new SparseIntArray();
        this.M = new SparseIntArray();
        this.N = new a();
        this.O = new Rect();
        Y2(RecyclerView.o.i0(context, attributeSet, i10, i11).f3427b);
    }

    private void K2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        int i14 = 0;
        int i15 = -1;
        if (z10) {
            i15 = i10;
            i12 = 0;
            i13 = 1;
        } else {
            i12 = i10 - 1;
            i13 = -1;
        }
        while (i12 != i15) {
            View view = this.K[i12];
            b bVar = (b) view.getLayoutParams();
            int U2 = U2(vVar, a0Var, h0(view));
            bVar.f3266f = U2;
            bVar.f3265e = i14;
            i14 += U2;
            i12 += i13;
        }
    }

    private void L2() {
        int J = J();
        for (int i10 = 0; i10 < J; i10++) {
            b bVar = (b) I(i10).getLayoutParams();
            int a10 = bVar.a();
            this.L.put(a10, bVar.f());
            this.M.put(a10, bVar.e());
        }
    }

    private void M2(int i10) {
        this.J = N2(this.J, this.I, i10);
    }

    static int[] N2(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    private void O2() {
        this.L.clear();
        this.M.clear();
    }

    private void P2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int T2 = T2(vVar, a0Var, aVar.f3278b);
        if (z10) {
            while (T2 > 0) {
                int i11 = aVar.f3278b;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                aVar.f3278b = i12;
                T2 = T2(vVar, a0Var, i12);
            }
            return;
        }
        int b10 = a0Var.b() - 1;
        int i13 = aVar.f3278b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int T22 = T2(vVar, a0Var, i14);
            if (T22 <= T2) {
                break;
            }
            i13 = i14;
            T2 = T22;
        }
        aVar.f3278b = i13;
    }

    private void Q2() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private int S2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.N.b(i10, this.I);
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.N.b(f10, this.I);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. ");
        sb2.append(i10);
        return 0;
    }

    private int T2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.N.a(i10, this.I);
        }
        int i11 = this.M.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.N.a(f10, this.I);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 0;
    }

    private int U2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.N.d(i10);
        }
        int i11 = this.L.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.N.d(f10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 1;
    }

    private void V2(float f10, int i10) {
        M2(Math.max(Math.round(f10 * this.I), i10));
    }

    private void W2(View view, int i10, boolean z10) {
        int i11;
        int i12;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f3431b;
        int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int R2 = R2(bVar.f3265e, bVar.f3266f);
        if (this.f3269s == 1) {
            i12 = RecyclerView.o.K(R2, i10, i14, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i11 = RecyclerView.o.K(this.f3271u.n(), X(), i13, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int K = RecyclerView.o.K(R2, i10, i13, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int K2 = RecyclerView.o.K(this.f3271u.n(), p0(), i14, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i11 = K;
            i12 = K2;
        }
        X2(view, i12, i11, z10);
    }

    private void X2(View view, int i10, int i11, boolean z10) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10 ? H1(view, i10, i11, pVar) : F1(view, i10, i11, pVar)) {
            view.measure(i10, i11);
        }
    }

    private void Z2() {
        int W;
        int g02;
        if (n2() == 1) {
            W = o0() - f0();
            g02 = e0();
        } else {
            W = W() - d0();
            g02 = g0();
        }
        M2(W - g02);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void B2(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.B2(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i10, int i11) {
        int n10;
        int n11;
        if (this.J == null) {
            super.C1(rect, i10, i11);
        }
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f3269s == 1) {
            n11 = RecyclerView.o.n(i11, rect.height() + g02, b0());
            int[] iArr = this.J;
            n10 = RecyclerView.o.n(i10, iArr[iArr.length - 1] + e02, c0());
        } else {
            n10 = RecyclerView.o.n(i10, rect.width() + e02, c0());
            int[] iArr2 = this.J;
            n11 = RecyclerView.o.n(i11, iArr2[iArr2.length - 1] + g02, b0());
        }
        B1(n10, n11);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f3269s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f6, code lost:
    
        if (r13 == (r2 > r7)) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View J0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.J0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean K1() {
        return this.D == null && !this.H;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void L1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i10 = this.I;
        for (int i11 = 0; i11 < this.I && cVar.c(a0Var) && i10 > 0; i11++) {
            int i12 = cVar.f3289d;
            cVar2.a(i12, Math.max(0, cVar.f3292g));
            i10 -= this.N.d(i12);
            cVar.f3289d += cVar.f3290e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f3269s == 1) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, androidx.core.view.accessibility.d dVar) {
        int i10;
        int e10;
        int f10;
        boolean z10;
        boolean z11;
        int i11;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.O0(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int S2 = S2(vVar, a0Var, bVar.a());
        if (this.f3269s == 0) {
            int e11 = bVar.e();
            i10 = bVar.f();
            f10 = 1;
            z10 = this.I > 1 && bVar.f() == this.I;
            z11 = false;
            i11 = e11;
            e10 = S2;
        } else {
            i10 = 1;
            e10 = bVar.e();
            f10 = bVar.f();
            z10 = this.I > 1 && bVar.f() == this.I;
            z11 = false;
            i11 = S2;
        }
        dVar.Y(d.c.a(i11, i10, e10, f10, z10, z11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i10, int i11) {
        this.N.e();
    }

    int R2(int i10, int i11) {
        if (this.f3269s != 1 || !o2()) {
            int[] iArr = this.J;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.J;
        int i12 = this.I;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.N.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.N.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i10, int i11) {
        this.N.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.N.e();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            L2();
        }
        super.X0(vVar, a0Var);
        O2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.H = false;
    }

    public void Y2(int i10) {
        if (i10 == this.I) {
            return;
        }
        this.H = true;
        if (i10 >= 1) {
            this.I = i10;
            this.N.e();
            t1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (h02 >= 0 && h02 < i12 && T2(vVar, a0Var, h02) == 0) {
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
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f3269s == 0) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S2(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        r22.f3283b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void p2(androidx.recyclerview.widget.RecyclerView.v r19, androidx.recyclerview.widget.RecyclerView.a0 r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.p2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void r2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        super.r2(vVar, a0Var, aVar, i10);
        Z2();
        if (a0Var.b() > 0 && !a0Var.e()) {
            P2(vVar, a0Var, aVar, i10);
        }
        Q2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Z2();
        Q2();
        return super.w1(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Z2();
        Q2();
        return super.y1(i10, vVar, a0Var);
    }
}
