package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.y0;
import androidx.core.view.a0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: f, reason: collision with root package name */
    private i f830f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f831g;

    /* renamed from: h, reason: collision with root package name */
    private RadioButton f832h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f833i;

    /* renamed from: j, reason: collision with root package name */
    private CheckBox f834j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f835k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f836l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f837m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f838n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f839o;

    /* renamed from: p, reason: collision with root package name */
    private int f840p;

    /* renamed from: q, reason: collision with root package name */
    private Context f841q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f842r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f843s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f844t;

    /* renamed from: u, reason: collision with root package name */
    private LayoutInflater f845u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f846v;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.a.D);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        y0 v10 = y0.v(getContext(), attributeSet, e.j.O1, i10, 0);
        this.f839o = v10.g(e.j.Q1);
        this.f840p = v10.n(e.j.P1, -1);
        this.f842r = v10.a(e.j.R1, false);
        this.f841q = context;
        this.f843s = v10.g(e.j.S1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, e.a.A, 0);
        this.f844t = obtainStyledAttributes.hasValue(0);
        v10.w();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i10) {
        LinearLayout linearLayout = this.f838n;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(e.g.f8963h, (ViewGroup) this, false);
        this.f834j = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(e.g.f8964i, (ViewGroup) this, false);
        this.f831g = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(e.g.f8966k, (ViewGroup) this, false);
        this.f832h = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f845u == null) {
            this.f845u = LayoutInflater.from(getContext());
        }
        return this.f845u;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f836l;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f837m;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f837m.getLayoutParams();
        rect.top += this.f837m.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void e(i iVar, int i10) {
        this.f830f = iVar;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        h(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f830f;
    }

    public void h(boolean z10, char c10) {
        int i10 = (z10 && this.f830f.A()) ? 0 : 8;
        if (i10 == 0) {
            this.f835k.setText(this.f830f.h());
        }
        if (this.f835k.getVisibility() != i10) {
            this.f835k.setVisibility(i10);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a0.n0(this, this.f839o);
        TextView textView = (TextView) findViewById(e.f.M);
        this.f833i = textView;
        int i10 = this.f840p;
        if (i10 != -1) {
            textView.setTextAppearance(this.f841q, i10);
        }
        this.f835k = (TextView) findViewById(e.f.F);
        ImageView imageView = (ImageView) findViewById(e.f.I);
        this.f836l = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f843s);
        }
        this.f837m = (ImageView) findViewById(e.f.f8947r);
        this.f838n = (LinearLayout) findViewById(e.f.f8941l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f831g != null && this.f842r) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f831g.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z10 && this.f832h == null && this.f834j == null) {
            return;
        }
        if (this.f830f.m()) {
            if (this.f832h == null) {
                g();
            }
            compoundButton = this.f832h;
            compoundButton2 = this.f834j;
        } else {
            if (this.f834j == null) {
                c();
            }
            compoundButton = this.f834j;
            compoundButton2 = this.f832h;
        }
        if (z10) {
            compoundButton.setChecked(this.f830f.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f834j;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f832h;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f830f.m()) {
            if (this.f832h == null) {
                g();
            }
            compoundButton = this.f832h;
        } else {
            if (this.f834j == null) {
                c();
            }
            compoundButton = this.f834j;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f846v = z10;
        this.f842r = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f837m;
        if (imageView != null) {
            imageView.setVisibility((this.f844t || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f830f.z() || this.f846v;
        if (z10 || this.f842r) {
            ImageView imageView = this.f831g;
            if (imageView == null && drawable == null && !this.f842r) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f842r) {
                this.f831g.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f831g;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f831g.getVisibility() != 0) {
                this.f831g.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i10;
        TextView textView;
        if (charSequence != null) {
            this.f833i.setText(charSequence);
            if (this.f833i.getVisibility() == 0) {
                return;
            }
            textView = this.f833i;
            i10 = 0;
        } else {
            i10 = 8;
            if (this.f833i.getVisibility() == 8) {
                return;
            } else {
                textView = this.f833i;
            }
        }
        textView.setVisibility(i10);
    }
}
