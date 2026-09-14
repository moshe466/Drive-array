package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class f extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    e f1913f;

    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.b {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;

        /* renamed from: s0, reason: collision with root package name */
        public float f1914s0;

        /* renamed from: t0, reason: collision with root package name */
        public boolean f1915t0;

        /* renamed from: u0, reason: collision with root package name */
        public float f1916u0;

        /* renamed from: v0, reason: collision with root package name */
        public float f1917v0;

        /* renamed from: w0, reason: collision with root package name */
        public float f1918w0;

        /* renamed from: x0, reason: collision with root package name */
        public float f1919x0;

        /* renamed from: y0, reason: collision with root package name */
        public float f1920y0;

        /* renamed from: z0, reason: collision with root package name */
        public float f1921z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f1914s0 = 1.0f;
            this.f1915t0 = false;
            this.f1916u0 = 0.0f;
            this.f1917v0 = 0.0f;
            this.f1918w0 = 0.0f;
            this.f1919x0 = 0.0f;
            this.f1920y0 = 1.0f;
            this.f1921z0 = 1.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            this.E0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1914s0 = 1.0f;
            this.f1915t0 = false;
            this.f1916u0 = 0.0f;
            this.f1917v0 = 0.0f;
            this.f1918w0 = 0.0f;
            this.f1919x0 = 0.0f;
            this.f1920y0 = 1.0f;
            this.f1921z0 = 1.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            this.E0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.Q3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == j.R3) {
                    this.f1914s0 = obtainStyledAttributes.getFloat(index, this.f1914s0);
                } else if (index == j.f1946c4) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f1916u0 = obtainStyledAttributes.getFloat(index, this.f1916u0);
                        this.f1915t0 = true;
                    }
                } else if (index == j.Z3) {
                    this.f1918w0 = obtainStyledAttributes.getFloat(index, this.f1918w0);
                } else if (index == j.f1930a4) {
                    this.f1919x0 = obtainStyledAttributes.getFloat(index, this.f1919x0);
                } else if (index == j.Y3) {
                    this.f1917v0 = obtainStyledAttributes.getFloat(index, this.f1917v0);
                } else if (index == j.W3) {
                    this.f1920y0 = obtainStyledAttributes.getFloat(index, this.f1920y0);
                } else if (index == j.X3) {
                    this.f1921z0 = obtainStyledAttributes.getFloat(index, this.f1921z0);
                } else if (index == j.S3) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == j.T3) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == j.U3) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == j.V3) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == j.f1938b4 && Build.VERSION.SDK_INT >= 21) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    public e getConstraintSet() {
        if (this.f1913f == null) {
            this.f1913f = new e();
        }
        this.f1913f.g(this);
        return this.f1913f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
