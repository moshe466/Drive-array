package com.google.android.material.snackbar;

import a3.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.core.view.a0;
import androidx.core.view.accessibility.c;

/* loaded from: classes.dex */
public class d extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f6940f;

    /* renamed from: g, reason: collision with root package name */
    private final c.b f6941g;

    /* renamed from: h, reason: collision with root package name */
    private c f6942h;

    /* renamed from: i, reason: collision with root package name */
    private b f6943i;

    /* loaded from: classes.dex */
    class a implements c.b {
        a() {
        }

        @Override // androidx.core.view.accessibility.c.b
        public void onTouchExplorationStateChanged(boolean z10) {
            d.this.setClickableOrFocusableBasedOnAccessibility(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.H);
        if (obtainStyledAttributes.hasValue(k.J)) {
            a0.r0(this, obtainStyledAttributes.getDimensionPixelSize(r0, 0));
        }
        obtainStyledAttributes.recycle();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.f6940f = accessibilityManager;
        a aVar = new a();
        this.f6941g = aVar;
        androidx.core.view.accessibility.c.a(accessibilityManager, aVar);
        setClickableOrFocusableBasedOnAccessibility(accessibilityManager.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickableOrFocusableBasedOnAccessibility(boolean z10) {
        setClickable(!z10);
        setFocusable(z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f6943i;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        a0.g0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f6943i;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
        androidx.core.view.accessibility.c.b(this.f6940f, this.f6941g);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        c cVar = this.f6942h;
        if (cVar != null) {
            cVar.a(this, i10, i11, i12, i13);
        }
    }

    void setOnAttachStateChangeListener(b bVar) {
        this.f6943i = bVar;
    }

    void setOnLayoutChangeListener(c cVar) {
        this.f6942h = cVar;
    }
}
