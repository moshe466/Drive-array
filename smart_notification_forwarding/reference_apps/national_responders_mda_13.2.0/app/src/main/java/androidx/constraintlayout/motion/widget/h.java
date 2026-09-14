package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.j;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class h extends androidx.constraintlayout.widget.c implements j.d {

    /* renamed from: o, reason: collision with root package name */
    private boolean f1646o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f1647p;

    /* renamed from: q, reason: collision with root package name */
    private float f1648q;

    /* renamed from: r, reason: collision with root package name */
    protected View[] f1649r;

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void a(j jVar, int i10, int i11, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void b(j jVar, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void c(j jVar, int i10) {
    }

    public float getProgress() {
        return this.f1648q;
    }

    @Override // androidx.constraintlayout.widget.c
    protected void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.j.K5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == androidx.constraintlayout.widget.j.M5) {
                    this.f1646o = obtainStyledAttributes.getBoolean(index, this.f1646o);
                } else if (index == androidx.constraintlayout.widget.j.L5) {
                    this.f1647p = obtainStyledAttributes.getBoolean(index, this.f1647p);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f1648q = f10;
        int i10 = 0;
        if (this.f1786g > 0) {
            this.f1649r = l((ConstraintLayout) getParent());
            while (i10 < this.f1786g) {
                x(this.f1649r[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof h)) {
                x(childAt, f10);
            }
            i10++;
        }
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return this.f1647p;
    }

    public boolean v() {
        return this.f1646o;
    }

    public void w(Canvas canvas) {
    }

    public void x(View view, float f10) {
    }
}
