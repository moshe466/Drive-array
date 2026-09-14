package com.google.android.material.textfield;

import a3.d;
import a3.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.core.view.a0;
import androidx.core.widget.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6995a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f6996b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f6997c;

    /* renamed from: d, reason: collision with root package name */
    private int f6998d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f6999e;

    /* renamed from: f, reason: collision with root package name */
    private int f7000f;

    /* renamed from: g, reason: collision with root package name */
    private Animator f7001g;

    /* renamed from: h, reason: collision with root package name */
    private final float f7002h;

    /* renamed from: i, reason: collision with root package name */
    private int f7003i;

    /* renamed from: j, reason: collision with root package name */
    private int f7004j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f7005k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f7006l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f7007m;

    /* renamed from: n, reason: collision with root package name */
    private int f7008n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f7009o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7010p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f7011q;

    /* renamed from: r, reason: collision with root package name */
    private int f7012r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f7013s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f7015b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7016c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f7017d;

        a(int i10, TextView textView, int i11, TextView textView2) {
            this.f7014a = i10;
            this.f7015b = textView;
            this.f7016c = i11;
            this.f7017d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f7003i = this.f7014a;
            b.this.f7001g = null;
            TextView textView = this.f7015b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f7016c != 1 || b.this.f7007m == null) {
                    return;
                }
                b.this.f7007m.setText((CharSequence) null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f7017d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public b(TextInputLayout textInputLayout) {
        this.f6995a = textInputLayout.getContext();
        this.f6996b = textInputLayout;
        this.f7002h = r0.getResources().getDimensionPixelSize(d.f113g);
    }

    private void F(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void H(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean I(TextView textView, CharSequence charSequence) {
        return a0.S(this.f6996b) && this.f6996b.isEnabled() && !(this.f7004j == this.f7003i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void L(int i10, int i11, boolean z10) {
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f7001g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f7010p, this.f7011q, 2, i10, i11);
            h(arrayList, this.f7006l, this.f7007m, 1, i10, i11);
            b3.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, l(i10), i10, l(i11)));
            animatorSet.start();
        } else {
            y(i10, i11);
        }
        this.f6996b.z();
        this.f6996b.C(z10);
        this.f6996b.G();
    }

    private boolean f() {
        return (this.f6997c == null || this.f6996b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            list.add(i(textView, i12 == i10));
            if (i12 == i10) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(b3.a.f4089a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f7002h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(b3.a.f4092d);
        return ofFloat;
    }

    private TextView l(int i10) {
        if (i10 == 1) {
            return this.f7007m;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f7011q;
    }

    private boolean t(int i10) {
        return (i10 != 1 || this.f7007m == null || TextUtils.isEmpty(this.f7005k)) ? false : true;
    }

    private void y(int i10, int i11) {
        TextView l10;
        TextView l11;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (l11 = l(i11)) != null) {
            l11.setVisibility(0);
            l11.setAlpha(1.0f);
        }
        if (i10 != 0 && (l10 = l(i10)) != null) {
            l10.setVisibility(4);
            if (i10 == 1) {
                l10.setText((CharSequence) null);
            }
        }
        this.f7003i = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10) {
        this.f7008n = i10;
        TextView textView = this.f7007m;
        if (textView != null) {
            this.f6996b.w(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        TextView textView = this.f7007m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i10) {
        this.f7012r = i10;
        TextView textView = this.f7011q;
        if (textView != null) {
            j.n(textView, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z10) {
        if (this.f7010p == z10) {
            return;
        }
        g();
        if (z10) {
            b0 b0Var = new b0(this.f6995a);
            this.f7011q = b0Var;
            b0Var.setId(f.f127i);
            Typeface typeface = this.f7013s;
            if (typeface != null) {
                this.f7011q.setTypeface(typeface);
            }
            this.f7011q.setVisibility(4);
            a0.l0(this.f7011q, 1);
            C(this.f7012r);
            d(this.f7011q, 1);
        } else {
            s();
            x(this.f7011q, 1);
            this.f7011q = null;
            this.f6996b.z();
            this.f6996b.G();
        }
        this.f7010p = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        TextView textView = this.f7011q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(Typeface typeface) {
        if (typeface != this.f7013s) {
            this.f7013s = typeface;
            F(this.f7007m, typeface);
            F(this.f7011q, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(CharSequence charSequence) {
        g();
        this.f7005k = charSequence;
        this.f7007m.setText(charSequence);
        int i10 = this.f7003i;
        if (i10 != 1) {
            this.f7004j = 1;
        }
        L(i10, this.f7004j, I(this.f7007m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(CharSequence charSequence) {
        g();
        this.f7009o = charSequence;
        this.f7011q.setText(charSequence);
        int i10 = this.f7003i;
        if (i10 != 2) {
            this.f7004j = 2;
        }
        L(i10, this.f7004j, I(this.f7011q, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i10) {
        if (this.f6997c == null && this.f6999e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f6995a);
            this.f6997c = linearLayout;
            linearLayout.setOrientation(0);
            this.f6996b.addView(this.f6997c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.f6995a);
            this.f6999e = frameLayout;
            this.f6997c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f6997c.addView(new i0.a(this.f6995a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f6996b.getEditText() != null) {
                e();
            }
        }
        if (u(i10)) {
            this.f6999e.setVisibility(0);
            this.f6999e.addView(textView);
            this.f7000f++;
        } else {
            this.f6997c.addView(textView, i10);
        }
        this.f6997c.setVisibility(0);
        this.f6998d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            a0.x0(this.f6997c, a0.E(this.f6996b.getEditText()), 0, a0.D(this.f6996b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.f7001g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return t(this.f7004j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f7005k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        TextView textView = this.f7007m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList o() {
        TextView textView = this.f7007m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f7009o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f7011q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f7005k = null;
        g();
        if (this.f7003i == 1) {
            this.f7004j = (!this.f7010p || TextUtils.isEmpty(this.f7009o)) ? 0 : 2;
        }
        L(this.f7003i, this.f7004j, I(this.f7007m, null));
    }

    void s() {
        g();
        int i10 = this.f7003i;
        if (i10 == 2) {
            this.f7004j = 0;
        }
        L(i10, this.f7004j, I(this.f7011q, null));
    }

    boolean u(int i10) {
        return i10 == 0 || i10 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        return this.f7006l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f7010p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f6997c == null) {
            return;
        }
        if (!u(i10) || (frameLayout = this.f6999e) == null) {
            this.f6997c.removeView(textView);
        } else {
            int i11 = this.f7000f - 1;
            this.f7000f = i11;
            H(frameLayout, i11);
            this.f6999e.removeView(textView);
        }
        int i12 = this.f6998d - 1;
        this.f6998d = i12;
        H(this.f6997c, i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(boolean z10) {
        if (this.f7006l == z10) {
            return;
        }
        g();
        if (z10) {
            b0 b0Var = new b0(this.f6995a);
            this.f7007m = b0Var;
            b0Var.setId(f.f126h);
            Typeface typeface = this.f7013s;
            if (typeface != null) {
                this.f7007m.setTypeface(typeface);
            }
            A(this.f7008n);
            this.f7007m.setVisibility(4);
            a0.l0(this.f7007m, 1);
            d(this.f7007m, 0);
        } else {
            r();
            x(this.f7007m, 0);
            this.f7007m = null;
            this.f6996b.z();
            this.f6996b.G();
        }
        this.f7006l = z10;
    }
}
