package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.o f3636a;

    /* renamed from: b, reason: collision with root package name */
    private int f3637b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f3638c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends j {
        a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f3636a.T(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3636a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3636a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f3636a.Q(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f3636a.o0();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f3636a.o0() - this.f3636a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f3636a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f3636a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f3636a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f3636a.e0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f3636a.o0() - this.f3636a.e0()) - this.f3636a.f0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f3636a.n0(view, true, this.f3638c);
            return this.f3638c.right;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f3636a.n0(view, true, this.f3638c);
            return this.f3638c.left;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i10) {
            this.f3636a.C0(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends j {
        b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.j
        public int d(View view) {
            return this.f3636a.O(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3636a.R(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3636a.S(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int g(View view) {
            return this.f3636a.U(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.j
        public int h() {
            return this.f3636a.W();
        }

        @Override // androidx.recyclerview.widget.j
        public int i() {
            return this.f3636a.W() - this.f3636a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int j() {
            return this.f3636a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int k() {
            return this.f3636a.X();
        }

        @Override // androidx.recyclerview.widget.j
        public int l() {
            return this.f3636a.p0();
        }

        @Override // androidx.recyclerview.widget.j
        public int m() {
            return this.f3636a.g0();
        }

        @Override // androidx.recyclerview.widget.j
        public int n() {
            return (this.f3636a.W() - this.f3636a.g0()) - this.f3636a.d0();
        }

        @Override // androidx.recyclerview.widget.j
        public int p(View view) {
            this.f3636a.n0(view, true, this.f3638c);
            return this.f3638c.bottom;
        }

        @Override // androidx.recyclerview.widget.j
        public int q(View view) {
            this.f3636a.n0(view, true, this.f3638c);
            return this.f3638c.top;
        }

        @Override // androidx.recyclerview.widget.j
        public void r(int i10) {
            this.f3636a.D0(i10);
        }
    }

    private j(RecyclerView.o oVar) {
        this.f3637b = Integer.MIN_VALUE;
        this.f3638c = new Rect();
        this.f3636a = oVar;
    }

    /* synthetic */ j(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static j a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static j b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static j c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f3637b) {
            return 0;
        }
        return n() - this.f3637b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f3637b = n();
    }
}
