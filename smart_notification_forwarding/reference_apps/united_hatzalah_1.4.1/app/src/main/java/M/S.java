package m;

import a.AbstractC0228a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import l.ViewTreeObserverOnGlobalLayoutListenerC0506d;

/* loaded from: classes.dex */
public final class S extends Spinner {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f5584l = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final C0558n f5585a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5586b;

    /* renamed from: c, reason: collision with root package name */
    public final C0528G f5587c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f5588d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5589e;

    /* renamed from: f, reason: collision with root package name */
    public final Q f5590f;

    /* renamed from: j, reason: collision with root package name */
    public int f5591j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f5592k;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
    
        if (r7 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public S(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130968880(0x7f040130, float:1.7546426E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f5592k = r1
            android.content.Context r1 = r12.getContext()
            m.i1.a(r12, r1)
            int[] r1 = g.AbstractC0424a.f4646v
            F0.b3 r2 = F0.b3.t(r13, r14, r1, r0)
            java.lang.Object r3 = r2.f470c
            android.content.res.TypedArray r3 = (android.content.res.TypedArray) r3
            m.n r4 = new m.n
            r4.<init>(r12)
            r12.f5585a = r4
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L35
            k.e r6 = new k.e
            r6.<init>(r13, r4)
            r12.f5586b = r6
            goto L37
        L35:
            r12.f5586b = r13
        L37:
            r4 = -1
            r6 = 0
            int[] r7 = m.S.f5584l     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5b
            if (r8 == 0) goto L4d
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L5b
            goto L4d
        L4a:
            r13 = move-exception
            r6 = r7
            goto L55
        L4d:
            r7.recycle()
            goto L5e
        L51:
            r13 = move-exception
            goto L55
        L53:
            r7 = r6
            goto L5b
        L55:
            if (r6 == 0) goto L5a
            r6.recycle()
        L5a:
            throw r13
        L5b:
            if (r7 == 0) goto L5e
            goto L4d
        L5e:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L98
            if (r4 == r8) goto L65
            goto La5
        L65:
            m.O r4 = new m.O
            android.content.Context r9 = r12.f5586b
            r4.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f5586b
            F0.b3 r1 = F0.b3.t(r9, r14, r1, r0)
            java.lang.Object r9 = r1.f470c
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r10 = 3
            r11 = -2
            int r9 = r9.getLayoutDimension(r10, r11)
            r12.f5591j = r9
            android.graphics.drawable.Drawable r9 = r1.o(r8)
            r4.i(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.f5568E = r7
            r1.v()
            r12.f5590f = r4
            m.G r1 = new m.G
            r1.<init>(r12, r12, r4)
            r12.f5587c = r1
            goto La5
        L98:
            m.K r1 = new m.K
            r1.<init>(r12)
            r12.f5590f = r1
            java.lang.String r4 = r3.getString(r7)
            r1.f5557c = r4
        La5:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lbc
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131492932(0x7f0c0044, float:1.860933E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lbc:
            r2.v()
            r12.f5589e = r8
            android.widget.SpinnerAdapter r13 = r12.f5588d
            if (r13 == 0) goto Lca
            r12.setAdapter(r13)
            r12.f5588d = r6
        Lca:
            m.n r13 = r12.f5585a
            r13.d(r14, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.S.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            Rect rect = this.f5592k;
            drawable.getPadding(rect);
            return rect.left + rect.right + i3;
        }
        return i3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            c0558n.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        Q q3 = this.f5590f;
        if (q3 != null) {
            return q3.b();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        Q q3 = this.f5590f;
        if (q3 != null) {
            return q3.n();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f5590f != null) {
            return this.f5591j;
        }
        return super.getDropDownWidth();
    }

    public final Q getInternalPopup() {
        return this.f5590f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        Q q3 = this.f5590f;
        if (q3 != null) {
            return q3.f();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f5586b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        Q q3 = this.f5590f;
        if (q3 != null) {
            return q3.d();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            return c0558n.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            return c0558n.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q q3 = this.f5590f;
        if (q3 != null && q3.a()) {
            q3.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (this.f5590f != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        P p = (P) parcelable;
        super.onRestoreInstanceState(p.getSuperState());
        if (p.f5575a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0506d(this, 2));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, m.P] */
    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z3;
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        Q q3 = this.f5590f;
        if (q3 != null && q3.a()) {
            z3 = true;
        } else {
            z3 = false;
        }
        baseSavedState.f5575a = z3;
        return baseSavedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0528G c0528g = this.f5587c;
        if (c0528g != null && c0528g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        Q q3 = this.f5590f;
        if (q3 != null) {
            if (!q3.a()) {
                this.f5590f.l(AbstractC0530I.b(this), AbstractC0530I.a(this));
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            c0558n.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            c0558n.f(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        Q q3 = this.f5590f;
        if (q3 != null) {
            q3.k(i);
            q3.c(i);
        } else {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        Q q3 = this.f5590f;
        if (q3 != null) {
            q3.j(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f5590f != null) {
            this.f5591j = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        Q q3 = this.f5590f;
        if (q3 != null) {
            q3.i(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(AbstractC0228a.q(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        Q q3 = this.f5590f;
        if (q3 != null) {
            q3.h(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            c0558n.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0558n c0558n = this.f5585a;
        if (c0558n != null) {
            c0558n.i(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.ListAdapter, java.lang.Object, m.L] */
    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f5589e) {
            this.f5588d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        Q q3 = this.f5590f;
        if (q3 != 0) {
            Context context = this.f5586b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            ?? obj = new Object();
            obj.f5559a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                obj.f5560b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                AbstractC0531J.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            q3.o(obj);
        }
    }
}
