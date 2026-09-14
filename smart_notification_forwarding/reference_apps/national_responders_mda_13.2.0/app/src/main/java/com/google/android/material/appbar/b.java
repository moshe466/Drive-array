package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import androidx.core.view.k0;
import java.util.List;

/* loaded from: classes.dex */
abstract class b extends c<View> {

    /* renamed from: d, reason: collision with root package name */
    final Rect f6715d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f6716e;

    /* renamed from: f, reason: collision with root package name */
    private int f6717f;

    /* renamed from: g, reason: collision with root package name */
    private int f6718g;

    public b() {
        this.f6715d = new Rect();
        this.f6716e = new Rect();
        this.f6717f = 0;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6715d = new Rect();
        this.f6716e = new Rect();
        this.f6717f = 0;
    }

    private static int M(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void E(CoordinatorLayout coordinatorLayout, View view, int i10) {
        int i11;
        View G = G(coordinatorLayout.r(view));
        if (G != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f6715d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, G.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + G.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            k0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && a0.w(coordinatorLayout) && !a0.w(view)) {
                rect.left += lastWindowInsets.i();
                rect.right -= lastWindowInsets.j();
            }
            Rect rect2 = this.f6716e;
            androidx.core.view.e.a(M(fVar.f2148c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            int H = H(G);
            view.layout(rect2.left, rect2.top - H, rect2.right, rect2.bottom - H);
            i11 = rect2.top - G.getBottom();
        } else {
            super.E(coordinatorLayout, view, i10);
            i11 = 0;
        }
        this.f6717f = i11;
    }

    abstract View G(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int H(View view) {
        if (this.f6718g == 0) {
            return 0;
        }
        float I = I(view);
        int i10 = this.f6718g;
        return v.a.b((int) (I * i10), 0, i10);
    }

    abstract float I(View view);

    public final int J() {
        return this.f6718g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int L() {
        return this.f6717f;
    }

    public final void N(int i10) {
        this.f6718g = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        View G;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (G = G(coordinatorLayout.r(view))) == null) {
            return false;
        }
        if (a0.w(G) && !a0.w(view)) {
            a0.s0(view, true);
            if (a0.w(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.J(view, i10, i11, View.MeasureSpec.makeMeasureSpec((size - G.getMeasuredHeight()) + K(G), i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }
}
