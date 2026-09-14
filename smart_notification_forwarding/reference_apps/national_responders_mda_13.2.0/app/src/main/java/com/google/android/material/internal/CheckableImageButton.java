package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.o;
import androidx.core.view.a0;

/* loaded from: classes.dex */
public class CheckableImageButton extends o implements Checkable {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f6884j = {R.attr.state_checked};

    /* renamed from: i, reason: collision with root package name */
    private boolean f6885i;

    /* loaded from: classes.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            dVar.T(true);
            dVar.U(CheckableImageButton.this.isChecked());
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.C);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a0.j0(this, new a());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f6885i;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (!this.f6885i) {
            return super.onCreateDrawableState(i10);
        }
        int[] iArr = f6884j;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i10 + iArr.length), iArr);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f6885i != z10) {
            this.f6885i = z10;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f6885i);
    }
}
