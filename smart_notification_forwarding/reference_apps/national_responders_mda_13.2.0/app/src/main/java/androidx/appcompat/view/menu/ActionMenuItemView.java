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
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.j0;

/* loaded from: classes.dex */
public class ActionMenuItemView extends b0 implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: l, reason: collision with root package name */
    i f815l;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f816m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f817n;

    /* renamed from: o, reason: collision with root package name */
    g.b f818o;

    /* renamed from: p, reason: collision with root package name */
    private j0 f819p;

    /* renamed from: q, reason: collision with root package name */
    b f820q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f821r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f822s;

    /* renamed from: t, reason: collision with root package name */
    private int f823t;

    /* renamed from: u, reason: collision with root package name */
    private int f824u;

    /* renamed from: v, reason: collision with root package name */
    private int f825v;

    /* loaded from: classes.dex */
    private class a extends j0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.j0
        public p b() {
            b bVar = ActionMenuItemView.this.f820q;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.j0
        protected boolean c() {
            p b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f818o;
            return bVar != null && bVar.a(actionMenuItemView.f815l) && (b10 = b()) != null && b10.c();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f821r = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f9097v, i10, 0);
        this.f823t = obtainStyledAttributes.getDimensionPixelSize(e.j.f9102w, 0);
        obtainStyledAttributes.recycle();
        this.f825v = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f824u = -1;
        setSaveEnabled(false);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f816m);
        if (this.f817n != null && (!this.f815l.B() || (!this.f821r && !this.f822s))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f816m : null);
        CharSequence contentDescription = this.f815l.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z12 ? null : this.f815l.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f815l.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            b1.a(this, z12 ? null : this.f815l.getTitle());
        } else {
            b1.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f815l.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i10) {
        this.f815l = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f819p == null) {
            this.f819p = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f815l;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f818o;
        if (bVar != null) {
            bVar.a(this.f815l);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f821r = g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.b0, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean f10 = f();
        if (f10 && (i12 = this.f824u) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f823t) : this.f823t;
        if (mode != 1073741824 && this.f823t > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i11);
        }
        if (f10 || this.f817n == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f817n.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j0 j0Var;
        if (this.f815l.hasSubMenu() && (j0Var = this.f819p) != null && j0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f822s != z10) {
            this.f822s = z10;
            i iVar = this.f815l;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f817n = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f825v;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(g.b bVar) {
        this.f818o = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f824u = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f820q = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f816m = charSequence;
        h();
    }
}
