package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a, reason: collision with root package name */
    private int f7019a;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f7020f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7021g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ e3.a f7022h;

        a(View view, int i10, e3.a aVar) {
            this.f7020f = view;
            this.f7021g = i10;
            this.f7022h = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f7020f.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f7019a == this.f7021g) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                e3.a aVar = this.f7022h;
                expandableBehavior.G((View) aVar, this.f7020f, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f7019a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7019a = 0;
    }

    private boolean E(boolean z10) {
        if (!z10) {
            return this.f7019a == 1;
        }
        int i10 = this.f7019a;
        return i10 == 0 || i10 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected e3.a F(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r10 = coordinatorLayout.r(view);
        int size = r10.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = r10.get(i10);
            if (e(coordinatorLayout, view, view2)) {
                return (e3.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean G(View view, View view2, boolean z10, boolean z11);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        e3.a aVar = (e3.a) view2;
        if (!E(aVar.a())) {
            return false;
        }
        this.f7019a = aVar.a() ? 1 : 2;
        return G((View) aVar, view, aVar.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i10) {
        e3.a F;
        if (a0.S(view) || (F = F(coordinatorLayout, view)) == null || !E(F.a())) {
            return false;
        }
        int i11 = F.a() ? 1 : 2;
        this.f7019a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, F));
        return false;
    }
}
