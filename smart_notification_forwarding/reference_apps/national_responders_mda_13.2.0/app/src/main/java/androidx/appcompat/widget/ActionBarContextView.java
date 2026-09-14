package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f1039n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f1040o;

    /* renamed from: p, reason: collision with root package name */
    private View f1041p;

    /* renamed from: q, reason: collision with root package name */
    private View f1042q;

    /* renamed from: r, reason: collision with root package name */
    private View f1043r;

    /* renamed from: s, reason: collision with root package name */
    private LinearLayout f1044s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f1045t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f1046u;

    /* renamed from: v, reason: collision with root package name */
    private int f1047v;

    /* renamed from: w, reason: collision with root package name */
    private int f1048w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1049x;

    /* renamed from: y, reason: collision with root package name */
    private int f1050y;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f1051f;

        a(ActionBarContextView actionBarContextView, androidx.appcompat.view.b bVar) {
            this.f1051f = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1051f.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.f8863j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        y0 v10 = y0.v(context, attributeSet, e.j.f9107x, i10, 0);
        androidx.core.view.a0.n0(this, v10.g(e.j.f9112y));
        this.f1047v = v10.n(e.j.C, 0);
        this.f1048w = v10.n(e.j.B, 0);
        this.f1203j = v10.m(e.j.A, 0);
        this.f1050y = v10.n(e.j.f9117z, e.g.f8959d);
        v10.w();
    }

    private void i() {
        if (this.f1044s == null) {
            LayoutInflater.from(getContext()).inflate(e.g.f8956a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1044s = linearLayout;
            this.f1045t = (TextView) linearLayout.findViewById(e.f.f8934e);
            this.f1046u = (TextView) this.f1044s.findViewById(e.f.f8933d);
            if (this.f1047v != 0) {
                this.f1045t.setTextAppearance(getContext(), this.f1047v);
            }
            if (this.f1048w != 0) {
                this.f1046u.setTextAppearance(getContext(), this.f1048w);
            }
        }
        this.f1045t.setText(this.f1039n);
        this.f1046u.setText(this.f1040o);
        boolean z10 = !TextUtils.isEmpty(this.f1039n);
        boolean z11 = !TextUtils.isEmpty(this.f1040o);
        int i10 = 0;
        this.f1046u.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f1044s;
        if (!z10 && !z11) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        if (this.f1044s.getParent() == null) {
            addView(this.f1044s);
        }
    }

    public void g() {
        if (this.f1041p == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1040o;
    }

    public CharSequence getTitle() {
        return this.f1039n;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(androidx.appcompat.view.b r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.f1041p
            if (r0 != 0) goto L19
            android.content.Context r0 = r3.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = r3.f1050y
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r3, r2)
            r3.f1041p = r0
        L15:
            r3.addView(r0)
            goto L22
        L19:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L22
            android.view.View r0 = r3.f1041p
            goto L15
        L22:
            android.view.View r0 = r3.f1041p
            int r1 = e.f.f8938i
            android.view.View r0 = r0.findViewById(r1)
            r3.f1042q = r0
            androidx.appcompat.widget.ActionBarContextView$a r1 = new androidx.appcompat.widget.ActionBarContextView$a
            r1.<init>(r3, r4)
            r0.setOnClickListener(r1)
            android.view.Menu r4 = r4.e()
            androidx.appcompat.view.menu.g r4 = (androidx.appcompat.view.menu.g) r4
            androidx.appcompat.widget.c r0 = r3.f1202i
            if (r0 == 0) goto L41
            r0.y()
        L41:
            androidx.appcompat.widget.c r0 = new androidx.appcompat.widget.c
            android.content.Context r1 = r3.getContext()
            r0.<init>(r1)
            r3.f1202i = r0
            r1 = 1
            r0.J(r1)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -2
            r2 = -1
            r0.<init>(r1, r2)
            androidx.appcompat.widget.c r1 = r3.f1202i
            android.content.Context r2 = r3.f1200g
            r4.c(r1, r2)
            androidx.appcompat.widget.c r4 = r3.f1202i
            androidx.appcompat.view.menu.n r4 = r4.o(r3)
            androidx.appcompat.widget.ActionMenuView r4 = (androidx.appcompat.widget.ActionMenuView) r4
            r3.f1201h = r4
            r1 = 0
            androidx.core.view.a0.n0(r4, r1)
            androidx.appcompat.widget.ActionMenuView r4 = r3.f1201h
            r3.addView(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.h(androidx.appcompat.view.b):void");
    }

    public boolean j() {
        return this.f1049x;
    }

    public void k() {
        removeAllViews();
        this.f1043r = null;
        this.f1201h = null;
        this.f1202i = null;
        View view = this.f1042q;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        c cVar = this.f1202i;
        if (cVar != null) {
            return cVar.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1202i;
        if (cVar != null) {
            cVar.B();
            this.f1202i.C();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean b10 = h1.b(this);
        int paddingRight = b10 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1041p;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1041p.getLayoutParams();
            int i14 = b10 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = b10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d10 = androidx.appcompat.widget.a.d(paddingRight, i14, b10);
            paddingRight = androidx.appcompat.widget.a.d(d10 + e(this.f1041p, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingRight;
        LinearLayout linearLayout = this.f1044s;
        if (linearLayout != null && this.f1043r == null && linearLayout.getVisibility() != 8) {
            i16 += e(this.f1044s, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f1043r;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        int paddingLeft = b10 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1201h;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b10);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.f1203j;
        if (i12 <= 0) {
            i12 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i13 = i12 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE);
        View view = this.f1041p;
        if (view != null) {
            int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1041p.getLayoutParams();
            paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1201h;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f1201h, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1044s;
        if (linearLayout != null && this.f1043r == null) {
            if (this.f1049x) {
                this.f1044s.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f1044s.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1044s.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.f1043r;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i14 = layoutParams.width;
            int i15 = i14 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i14 >= 0) {
                paddingLeft = Math.min(i14, paddingLeft);
            }
            int i16 = layoutParams.height;
            int i17 = i16 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i16 >= 0) {
                i13 = Math.min(i16, i13);
            }
            this.f1043r.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i15), View.MeasureSpec.makeMeasureSpec(i13, i17));
        }
        if (this.f1203j > 0) {
            setMeasuredDimension(size, i12);
            return;
        }
        int childCount = getChildCount();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            int measuredHeight = getChildAt(i19).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i18) {
                i18 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i18);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f1203j = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1043r;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1043r = view;
        if (view != null && (linearLayout = this.f1044s) != null) {
            removeView(linearLayout);
            this.f1044s = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1040o = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1039n = charSequence;
        i();
        androidx.core.view.a0.m0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1049x) {
            requestLayout();
        }
        this.f1049x = z10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
