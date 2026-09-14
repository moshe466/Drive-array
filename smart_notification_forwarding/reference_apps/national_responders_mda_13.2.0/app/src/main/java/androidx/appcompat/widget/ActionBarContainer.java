package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private boolean f1029f;

    /* renamed from: g, reason: collision with root package name */
    private View f1030g;

    /* renamed from: h, reason: collision with root package name */
    private View f1031h;

    /* renamed from: i, reason: collision with root package name */
    private View f1032i;

    /* renamed from: j, reason: collision with root package name */
    Drawable f1033j;

    /* renamed from: k, reason: collision with root package name */
    Drawable f1034k;

    /* renamed from: l, reason: collision with root package name */
    Drawable f1035l;

    /* renamed from: m, reason: collision with root package name */
    boolean f1036m;

    /* renamed from: n, reason: collision with root package name */
    boolean f1037n;

    /* renamed from: o, reason: collision with root package name */
    private int f1038o;

    /* loaded from: classes.dex */
    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        androidx.core.view.a0.n0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f8992a);
        this.f1033j = obtainStyledAttributes.getDrawable(e.j.f8997b);
        this.f1034k = obtainStyledAttributes.getDrawable(e.j.f9007d);
        this.f1038o = obtainStyledAttributes.getDimensionPixelSize(e.j.f9037j, -1);
        boolean z10 = true;
        if (getId() == e.f.H) {
            this.f1036m = true;
            this.f1035l = obtainStyledAttributes.getDrawable(e.j.f9002c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1036m ? this.f1033j != null || this.f1034k != null : this.f1035l != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1033j;
        if (drawable != null && drawable.isStateful()) {
            this.f1033j.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1034k;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1034k.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1035l;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1035l.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1030g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1033j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1034k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1035l;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1031h = findViewById(e.f.f8930a);
        this.f1032i = findViewById(e.f.f8935f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1029f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        Drawable drawable2;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z10, i10, i11, i12, i13);
        View view2 = this.f1030g;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            int measuredHeight2 = measuredHeight - view2.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view2.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f1036m) {
            Drawable drawable3 = this.f1035l;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f1033j != null) {
                if (this.f1031h.getVisibility() == 0) {
                    drawable2 = this.f1033j;
                    left = this.f1031h.getLeft();
                    top = this.f1031h.getTop();
                    right = this.f1031h.getRight();
                    view = this.f1031h;
                } else {
                    View view3 = this.f1032i;
                    if (view3 == null || view3.getVisibility() != 0) {
                        this.f1033j.setBounds(0, 0, 0, 0);
                        z12 = true;
                    } else {
                        drawable2 = this.f1033j;
                        left = this.f1032i.getLeft();
                        top = this.f1032i.getTop();
                        right = this.f1032i.getRight();
                        view = this.f1032i;
                    }
                }
                drawable2.setBounds(left, top, right, view.getBottom());
                z12 = true;
            }
            this.f1037n = z13;
            if (!z13 || (drawable = this.f1034k) == null) {
                z11 = z12;
            } else {
                drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        }
        if (z11) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            android.view.View r0 = r3.f1031h
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != 0) goto L1c
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            if (r0 != r1) goto L1c
            int r0 = r3.f1038o
            if (r0 < 0) goto L1c
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            int r5 = java.lang.Math.min(r0, r5)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
        L1c:
            super.onMeasure(r4, r5)
            android.view.View r4 = r3.f1031h
            if (r4 != 0) goto L24
            return
        L24:
            int r4 = android.view.View.MeasureSpec.getMode(r5)
            android.view.View r0 = r3.f1030g
            if (r0 == 0) goto L6f
            int r0 = r0.getVisibility()
            r2 = 8
            if (r0 == r2) goto L6f
            r0 = 1073741824(0x40000000, float:2.0)
            if (r4 == r0) goto L6f
            android.view.View r0 = r3.f1031h
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L47
            android.view.View r0 = r3.f1031h
        L42:
            int r0 = r3.a(r0)
            goto L53
        L47:
            android.view.View r0 = r3.f1032i
            boolean r0 = r3.b(r0)
            if (r0 != 0) goto L52
            android.view.View r0 = r3.f1032i
            goto L42
        L52:
            r0 = 0
        L53:
            if (r4 != r1) goto L5a
            int r4 = android.view.View.MeasureSpec.getSize(r5)
            goto L5d
        L5a:
            r4 = 2147483647(0x7fffffff, float:NaN)
        L5d:
            int r5 = r3.getMeasuredWidth()
            android.view.View r1 = r3.f1030g
            int r1 = r3.a(r1)
            int r0 = r0 + r1
            int r4 = java.lang.Math.min(r0, r4)
            r3.setMeasuredDimension(r5, r4)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContainer.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1033j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1033j);
        }
        this.f1033j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1031h;
            if (view != null) {
                this.f1033j.setBounds(view.getLeft(), this.f1031h.getTop(), this.f1031h.getRight(), this.f1031h.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1036m ? this.f1033j != null || this.f1034k != null : this.f1035l != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1035l;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1035l);
        }
        this.f1035l = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1036m && (drawable2 = this.f1035l) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1036m ? !(this.f1033j != null || this.f1034k != null) : this.f1035l == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1034k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1034k);
        }
        this.f1034k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1037n && (drawable2 = this.f1034k) != null) {
                drawable2.setBounds(this.f1030g.getLeft(), this.f1030g.getTop(), this.f1030g.getRight(), this.f1030g.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1036m ? this.f1033j != null || this.f1034k != null : this.f1035l != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            a.a(this);
        }
    }

    public void setTabContainer(r0 r0Var) {
        View view = this.f1030g;
        if (view != null) {
            removeView(view);
        }
        this.f1030g = r0Var;
        if (r0Var != null) {
            addView(r0Var);
            ViewGroup.LayoutParams layoutParams = r0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            r0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        this.f1029f = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1033j;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1034k;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1035l;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1033j && !this.f1036m) || (drawable == this.f1034k && this.f1037n) || ((drawable == this.f1035l && this.f1036m) || super.verifyDrawable(drawable));
    }
}
