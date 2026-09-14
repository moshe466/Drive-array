package androidx.recyclerview.widget;

import F0.AbstractC0008a;
import F0.C0047j2;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import e0.a;
import k0.C0472C;
import k0.C0486j;
import k0.t;
import k0.u;
import k0.z;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public final int p;

    /* renamed from: q, reason: collision with root package name */
    public final C0047j2 f3663q;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i3) {
        super(context, attributeSet, i, i3);
        this.p = -1;
        new SparseIntArray();
        new SparseIntArray();
        C0047j2 c0047j2 = new C0047j2(16);
        this.f3663q = c0047j2;
        new Rect();
        int i4 = t.w(context, attributeSet, i, i3).f5257c;
        if (i4 == this.p) {
            return;
        }
        if (i4 >= 1) {
            this.p = i4;
            ((SparseIntArray) c0047j2.f546b).clear();
            H();
            return;
        }
        throw new IllegalArgumentException(a.c(i4, "Span count should be at least 1. Provided "));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Q(boolean z3) {
        if (!z3) {
            super.Q(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // k0.t
    public final boolean d(u uVar) {
        return uVar instanceof C0486j;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, k0.t
    public final u l() {
        if (this.f3664h == 0) {
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
        if (this.f3664h == 1) {
            return this.p;
        }
        int i = 0;
        if (c0472c.a() < 1) {
            return 0;
        }
        int a2 = c0472c.a() - 1;
        boolean z3 = c0472c.f5166c;
        C0047j2 c0047j2 = this.f3663q;
        if (!z3) {
            c0047j2.getClass();
            i = C0047j2.q(a2, this.p);
        } else {
            RecyclerView recyclerView = zVar.f5285g;
            C0472C c0472c2 = recyclerView.f3699a0;
            if (a2 >= 0 && a2 < c0472c2.a()) {
                if (c0472c2.f5166c) {
                    a2 = recyclerView.f3702c.k(a2, 0);
                }
                if (a2 != -1) {
                    c0047j2.getClass();
                    i = C0047j2.q(a2, this.p);
                }
            } else {
                StringBuilder w3 = AbstractC0008a.w(a2, "invalid position ", ". State item count is ");
                w3.append(c0472c2.a());
                w3.append(recyclerView.h());
                throw new IndexOutOfBoundsException(w3.toString());
            }
        }
        return i + 1;
    }

    @Override // k0.t
    public final int x(z zVar, C0472C c0472c) {
        if (this.f3664h == 0) {
            return this.p;
        }
        int i = 0;
        if (c0472c.a() < 1) {
            return 0;
        }
        int a2 = c0472c.a() - 1;
        boolean z3 = c0472c.f5166c;
        C0047j2 c0047j2 = this.f3663q;
        if (!z3) {
            c0047j2.getClass();
            i = C0047j2.q(a2, this.p);
        } else {
            RecyclerView recyclerView = zVar.f5285g;
            C0472C c0472c2 = recyclerView.f3699a0;
            if (a2 >= 0 && a2 < c0472c2.a()) {
                if (c0472c2.f5166c) {
                    a2 = recyclerView.f3702c.k(a2, 0);
                }
                if (a2 != -1) {
                    c0047j2.getClass();
                    i = C0047j2.q(a2, this.p);
                }
            } else {
                StringBuilder w3 = AbstractC0008a.w(a2, "invalid position ", ". State item count is ");
                w3.append(c0472c2.a());
                w3.append(recyclerView.h());
                throw new IndexOutOfBoundsException(w3.toString());
            }
        }
        return i + 1;
    }
}
