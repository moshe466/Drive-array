package com.google.android.material.snackbar;

import a3.f;
import a3.k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.a0;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private TextView f6935f;

    /* renamed from: g, reason: collision with root package name */
    private Button f6936g;

    /* renamed from: h, reason: collision with root package name */
    private int f6937h;

    /* renamed from: i, reason: collision with root package name */
    private int f6938i;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.H);
        this.f6937h = obtainStyledAttributes.getDimensionPixelSize(k.I, -1);
        this.f6938i = obtainStyledAttributes.getDimensionPixelSize(k.K, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i10, int i11) {
        if (a0.U(view)) {
            a0.x0(view, a0.E(view), i10, a0.D(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean b(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f6935f.getPaddingTop() == i11 && this.f6935f.getPaddingBottom() == i12) {
            return z10;
        }
        a(this.f6935f, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f6936g;
    }

    public TextView getMessageView() {
        return this.f6935f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f6935f = (TextView) findViewById(f.f124f);
        this.f6936g = (Button) findViewById(f.f123e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (b(1, r0, r0 - r1) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (b(0, r0, r0) != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f6937h
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f6937h
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = a3.d.f112f
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = a3.d.f111e
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f6935f
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = 1
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f6938i
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f6936g
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f6938i
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.b(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.b(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = 1
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }
}
