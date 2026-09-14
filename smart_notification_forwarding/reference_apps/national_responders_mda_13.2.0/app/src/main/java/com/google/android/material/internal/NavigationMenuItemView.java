package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.b1;
import androidx.appcompat.widget.k0;
import androidx.core.view.a0;
import androidx.core.widget.j;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements n.a {
    private static final int[] K = {R.attr.state_checked};
    private final int A;
    private boolean B;
    boolean C;
    private final CheckedTextView D;
    private FrameLayout E;
    private i F;
    private ColorStateList G;
    private boolean H;
    private Drawable I;
    private final androidx.core.view.a J;

    /* loaded from: classes.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            dVar.T(NavigationMenuItemView.this.C);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a aVar = new a();
        this.J = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(a3.h.f129a, (ViewGroup) this, true);
        this.A = context.getResources().getDimensionPixelSize(a3.d.f110d);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(a3.f.f120b);
        this.D = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        a0.j0(checkedTextView, aVar);
    }

    private void B() {
        k0.a aVar;
        int i10;
        if (D()) {
            this.D.setVisibility(8);
            FrameLayout frameLayout = this.E;
            if (frameLayout == null) {
                return;
            }
            aVar = (k0.a) frameLayout.getLayoutParams();
            i10 = -1;
        } else {
            this.D.setVisibility(0);
            FrameLayout frameLayout2 = this.E;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (k0.a) frameLayout2.getLayoutParams();
            i10 = -2;
        }
        ((LinearLayout.LayoutParams) aVar).width = i10;
        this.E.setLayoutParams(aVar);
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(e.a.f8876w, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(K, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.F.getTitle() == null && this.F.getIcon() == null && this.F.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.E == null) {
                this.E = (FrameLayout) ((ViewStub) findViewById(a3.f.f119a)).inflate();
            }
            this.E.removeAllViews();
            this.E.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i10) {
        this.F = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            a0.n0(this, C());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        b1.a(this, iVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        i iVar = this.F;
        if (iVar != null && iVar.isCheckable() && this.F.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, K);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.C != z10) {
            this.C = z10;
            this.J.l(this.D, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.D.setChecked(z10);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, 0, i10, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.H) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.q(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.G);
            }
            int i10 = this.A;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.B) {
            if (this.I == null) {
                Drawable d10 = androidx.core.content.res.h.d(getResources(), a3.e.f118a, getContext().getTheme());
                this.I = d10;
                if (d10 != null) {
                    int i11 = this.A;
                    d10.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.I;
        }
        j.i(this.D, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.D.setCompoundDrawablePadding(i10);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.G = colorStateList;
        this.H = colorStateList != null;
        i iVar = this.F;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.B = z10;
    }

    public void setTextAppearance(int i10) {
        j.n(this.D, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.D.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.D.setText(charSequence);
    }
}
