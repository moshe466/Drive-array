package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a, reason: collision with root package name */
    private d f6719a;

    /* renamed from: b, reason: collision with root package name */
    private int f6720b;

    /* renamed from: c, reason: collision with root package name */
    private int f6721c;

    public c() {
        this.f6720b = 0;
        this.f6721c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6720b = 0;
        this.f6721c = 0;
    }

    public int D() {
        d dVar = this.f6719a;
        if (dVar != null) {
            return dVar.a();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        coordinatorLayout.I(v10, i10);
    }

    public boolean F(int i10) {
        d dVar = this.f6719a;
        if (dVar != null) {
            return dVar.d(i10);
        }
        this.f6720b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        E(coordinatorLayout, v10, i10);
        if (this.f6719a == null) {
            this.f6719a = new d(v10);
        }
        this.f6719a.b();
        int i11 = this.f6720b;
        if (i11 != 0) {
            this.f6719a.d(i11);
            this.f6720b = 0;
        }
        int i12 = this.f6721c;
        if (i12 == 0) {
            return true;
        }
        this.f6719a.c(i12);
        this.f6721c = 0;
        return true;
    }
}
