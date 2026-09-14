package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m extends RecyclerView.l {

    /* renamed from: g, reason: collision with root package name */
    boolean f3642g = true;

    public final void A(RecyclerView.d0 d0Var) {
        I(d0Var);
        h(d0Var);
    }

    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
    }

    public final void C(RecyclerView.d0 d0Var, boolean z10) {
        K(d0Var, z10);
        h(d0Var);
    }

    public final void D(RecyclerView.d0 d0Var, boolean z10) {
        L(d0Var, z10);
    }

    public final void E(RecyclerView.d0 d0Var) {
        M(d0Var);
        h(d0Var);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
        h(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
    }

    public void I(RecyclerView.d0 d0Var) {
    }

    public void J(RecyclerView.d0 d0Var) {
    }

    public void K(RecyclerView.d0 d0Var, boolean z10) {
    }

    public void L(RecyclerView.d0 d0Var, boolean z10) {
    }

    public void M(RecyclerView.d0 d0Var) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var) {
    }

    public void P(RecyclerView.d0 d0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        return (cVar == null || ((i10 = cVar.f3403a) == (i11 = cVar2.f3403a) && cVar.f3404b == cVar2.f3404b)) ? w(d0Var) : y(d0Var, i10, cVar.f3404b, i11, cVar2.f3404b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10;
        int i11;
        int i12 = cVar.f3403a;
        int i13 = cVar.f3404b;
        if (d0Var2.I()) {
            int i14 = cVar.f3403a;
            i11 = cVar.f3404b;
            i10 = i14;
        } else {
            i10 = cVar2.f3403a;
            i11 = cVar2.f3404b;
        }
        return x(d0Var, d0Var2, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f3403a;
        int i11 = cVar.f3404b;
        View view = d0Var.f3375a;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3403a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3404b;
        if (d0Var.u() || (i10 == left && i11 == top)) {
            return z(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return y(d0Var, i10, i11, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2) {
        int i10 = cVar.f3403a;
        int i11 = cVar2.f3403a;
        if (i10 != i11 || cVar.f3404b != cVar2.f3404b) {
            return y(d0Var, i10, cVar.f3404b, i11, cVar2.f3404b);
        }
        E(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.d0 d0Var) {
        return !this.f3642g || d0Var.s();
    }

    public abstract boolean w(RecyclerView.d0 d0Var);

    public abstract boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean y(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13);

    public abstract boolean z(RecyclerView.d0 d0Var);
}
