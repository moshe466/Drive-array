package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import g.AbstractC0424a;
import l.AbstractC0505c;
import l.C0504b;
import l.InterfaceC0497A;
import l.l;
import l.m;
import l.o;
import m.C0537c0;
import m.InterfaceC0550j;
import p3.h;

/* loaded from: classes.dex */
public class ActionMenuItemView extends C0537c0 implements InterfaceC0497A, View.OnClickListener, InterfaceC0550j {

    /* renamed from: k, reason: collision with root package name */
    public o f2771k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2772l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f2773m;

    /* renamed from: n, reason: collision with root package name */
    public l f2774n;

    /* renamed from: o, reason: collision with root package name */
    public C0504b f2775o;
    public AbstractC0505c p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2776q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2777r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2778s;

    /* renamed from: t, reason: collision with root package name */
    public int f2779t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2780u;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f2776q = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0424a.f4629c, 0, 0);
        this.f2778s = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.f2780u = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2779t = -1;
        setSaveEnabled(false);
    }

    @Override // m.InterfaceC0550j
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // l.InterfaceC0497A
    public final void b(o oVar) {
        int i;
        this.f2771k = oVar;
        setIcon(oVar.getIcon());
        setTitle(oVar.getTitleCondensed());
        setId(oVar.f5428a);
        if (oVar.isVisible()) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
        setEnabled(oVar.isEnabled());
        if (oVar.hasSubMenu() && this.f2775o == null) {
            this.f2775o = new C0504b(this);
        }
    }

    @Override // m.InterfaceC0550j
    public final boolean c() {
        if (!TextUtils.isEmpty(getText()) && this.f2771k.getIcon() == null) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (i < 480) {
            if ((i < 640 || i3 < 480) && configuration.orientation != 2) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final void g() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(this.f2772l);
        if (this.f2773m != null && ((this.f2771k.y & 4) != 4 || (!this.f2776q && !this.f2777r))) {
            z3 = false;
        }
        boolean z5 = z4 & z3;
        CharSequence charSequence3 = null;
        if (z5) {
            charSequence = this.f2772l;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence4 = this.f2771k.f5442q;
        if (TextUtils.isEmpty(charSequence4)) {
            if (z5) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f2771k.f5432e;
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(charSequence4);
        }
        CharSequence charSequence5 = this.f2771k.f5443r;
        if (TextUtils.isEmpty(charSequence5)) {
            if (!z5) {
                charSequence3 = this.f2771k.f5432e;
            }
            h.D(this, charSequence3);
            return;
        }
        h.D(this, charSequence5);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // l.InterfaceC0497A
    public o getItemData() {
        return this.f2771k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l lVar = this.f2774n;
        if (lVar != null) {
            lVar.a(this.f2771k);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2776q = f();
        g();
    }

    @Override // m.C0537c0, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        int i5;
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (!isEmpty && (i5 = this.f2779t) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i3);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i6 = this.f2778s;
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, i6);
        } else {
            i4 = i6;
        }
        if (mode != 1073741824 && i6 > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }
        if (isEmpty && this.f2773m != null) {
            super.setPadding((getMeasuredWidth() - this.f2773m.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0504b c0504b;
        if (this.f2771k.hasSubMenu() && (c0504b = this.f2775o) != null && c0504b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z3) {
    }

    public void setChecked(boolean z3) {
    }

    public void setExpandedFormat(boolean z3) {
        if (this.f2777r != z3) {
            this.f2777r = z3;
            o oVar = this.f2771k;
            if (oVar != null) {
                m mVar = oVar.f5440n;
                mVar.f5409k = true;
                mVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2773m = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f2780u;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(l lVar) {
        this.f2774n = lVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i3, int i4, int i5) {
        this.f2779t = i;
        super.setPadding(i, i3, i4, i5);
    }

    public void setPopupCallback(AbstractC0505c abstractC0505c) {
        this.p = abstractC0505c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2772l = charSequence;
        g();
    }
}
