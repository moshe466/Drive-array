package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: f, reason: collision with root package name */
    protected final C0021a f1199f;

    /* renamed from: g, reason: collision with root package name */
    protected final Context f1200g;

    /* renamed from: h, reason: collision with root package name */
    protected ActionMenuView f1201h;

    /* renamed from: i, reason: collision with root package name */
    protected c f1202i;

    /* renamed from: j, reason: collision with root package name */
    protected int f1203j;

    /* renamed from: k, reason: collision with root package name */
    protected androidx.core.view.g0 f1204k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1205l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1206m;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0021a implements androidx.core.view.h0 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1207a = false;

        /* renamed from: b, reason: collision with root package name */
        int f1208b;

        protected C0021a() {
        }

        @Override // androidx.core.view.h0
        public void a(View view) {
            this.f1207a = true;
        }

        @Override // androidx.core.view.h0
        public void b(View view) {
            if (this.f1207a) {
                return;
            }
            a aVar = a.this;
            aVar.f1204k = null;
            a.super.setVisibility(this.f1208b);
        }

        @Override // androidx.core.view.h0
        public void c(View view) {
            a.super.setVisibility(0);
            this.f1207a = false;
        }

        public C0021a d(androidx.core.view.g0 g0Var, int i10) {
            a.this.f1204k = g0Var;
            this.f1208b = i10;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1199f = new C0021a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(e.a.f8854a, typedValue, true) || typedValue.resourceId == 0) {
            this.f1200g = context;
        } else {
            this.f1200g = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public androidx.core.view.g0 f(int i10, long j10) {
        androidx.core.view.g0 b10;
        androidx.core.view.g0 g0Var = this.f1204k;
        if (g0Var != null) {
            g0Var.c();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            b10 = androidx.core.view.a0.c(this).b(1.0f);
        } else {
            b10 = androidx.core.view.a0.c(this).b(0.0f);
        }
        b10.f(j10);
        b10.h(this.f1199f.d(b10, i10));
        return b10;
    }

    public int getAnimatedVisibility() {
        return this.f1204k != null ? this.f1199f.f1208b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1203j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.j.f8992a, e.a.f8856c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(e.j.f9037j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f1202i;
        if (cVar != null) {
            cVar.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1206m = false;
        }
        if (!this.f1206m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1206m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1206m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1205l = false;
        }
        if (!this.f1205l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1205l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1205l = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            androidx.core.view.g0 g0Var = this.f1204k;
            if (g0Var != null) {
                g0Var.c();
            }
            super.setVisibility(i10);
        }
    }
}
