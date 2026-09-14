package com.google.android.material.textfield;

import a3.h;
import a3.i;
import a3.j;
import a3.k;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.y0;
import androidx.core.view.a0;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private float A;
    private int B;
    private final int C;
    private final int D;
    private int E;
    private int F;
    private Drawable G;
    private final Rect H;
    private final RectF I;
    private Typeface J;
    private boolean K;
    private Drawable L;
    private CharSequence M;
    private CheckableImageButton N;
    private boolean O;
    private Drawable P;
    private Drawable Q;
    private ColorStateList R;
    private boolean S;
    private PorterDuff.Mode T;
    private boolean U;
    private ColorStateList V;
    private ColorStateList W;

    /* renamed from: a0, reason: collision with root package name */
    private final int f6954a0;

    /* renamed from: b0, reason: collision with root package name */
    private final int f6955b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f6956c0;

    /* renamed from: d0, reason: collision with root package name */
    private final int f6957d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f6958e0;

    /* renamed from: f, reason: collision with root package name */
    private final FrameLayout f6959f;

    /* renamed from: f0, reason: collision with root package name */
    final com.google.android.material.internal.a f6960f0;

    /* renamed from: g, reason: collision with root package name */
    EditText f6961g;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f6962g0;

    /* renamed from: h, reason: collision with root package name */
    private CharSequence f6963h;

    /* renamed from: h0, reason: collision with root package name */
    private ValueAnimator f6964h0;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.material.textfield.b f6965i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f6966i0;

    /* renamed from: j, reason: collision with root package name */
    boolean f6967j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f6968j0;

    /* renamed from: k, reason: collision with root package name */
    private int f6969k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f6970k0;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6971l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f6972m;

    /* renamed from: n, reason: collision with root package name */
    private final int f6973n;

    /* renamed from: o, reason: collision with root package name */
    private final int f6974o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6975p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f6976q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f6977r;

    /* renamed from: s, reason: collision with root package name */
    private GradientDrawable f6978s;

    /* renamed from: t, reason: collision with root package name */
    private final int f6979t;

    /* renamed from: u, reason: collision with root package name */
    private final int f6980u;

    /* renamed from: v, reason: collision with root package name */
    private int f6981v;

    /* renamed from: w, reason: collision with root package name */
    private final int f6982w;

    /* renamed from: x, reason: collision with root package name */
    private float f6983x;

    /* renamed from: y, reason: collision with root package name */
    private float f6984y;

    /* renamed from: z, reason: collision with root package name */
    private float f6985z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.C(!r0.f6970k0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f6967j) {
                textInputLayout.y(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextInputLayout.this.t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f6960f0.H(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class d extends androidx.core.view.a {

        /* renamed from: d, reason: collision with root package name */
        private final TextInputLayout f6989d;

        public d(TextInputLayout textInputLayout) {
            this.f6989d = textInputLayout;
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.accessibility.d dVar) {
            super.g(view, dVar);
            EditText editText = this.f6989d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f6989d.getHint();
            CharSequence error = this.f6989d.getError();
            CharSequence counterOverflowDescription = this.f6989d.getCounterOverflowDescription();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = !TextUtils.isEmpty(hint);
            boolean z12 = !TextUtils.isEmpty(error);
            boolean z13 = false;
            boolean z14 = z12 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z10) {
                dVar.r0(text);
            } else if (z11) {
                dVar.r0(hint);
            }
            if (z11) {
                dVar.g0(hint);
                if (!z10 && z11) {
                    z13 = true;
                }
                dVar.o0(z13);
            }
            if (z14) {
                if (!z12) {
                    error = counterOverflowDescription;
                }
                dVar.c0(error);
                dVar.a0(true);
            }
        }

        @Override // androidx.core.view.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            EditText editText = this.f6989d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f6989d.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e extends y.a {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        CharSequence f6990h;

        /* renamed from: i, reason: collision with root package name */
        boolean f6991i;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6990h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6991i = parcel.readInt() == 1;
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f6990h) + "}";
        }

        @Override // y.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.f6990h, parcel, i10);
            parcel.writeInt(this.f6991i ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a3.b.f102i);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6965i = new com.google.android.material.textfield.b(this);
        this.H = new Rect();
        this.I = new RectF();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f6960f0 = aVar;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f6959f = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        TimeInterpolator timeInterpolator = b3.a.f4089a;
        aVar.M(timeInterpolator);
        aVar.J(timeInterpolator);
        aVar.C(8388659);
        y0 i11 = f.i(context, attributeSet, k.L, i10, j.f134b, new int[0]);
        this.f6975p = i11.a(k.f149g0, true);
        setHint(i11.p(k.N));
        this.f6962g0 = i11.a(k.f147f0, true);
        this.f6979t = context.getResources().getDimensionPixelOffset(a3.d.f114h);
        this.f6980u = context.getResources().getDimensionPixelOffset(a3.d.f115i);
        this.f6982w = i11.e(k.Q, 0);
        this.f6983x = i11.d(k.U, 0.0f);
        this.f6984y = i11.d(k.T, 0.0f);
        this.f6985z = i11.d(k.R, 0.0f);
        this.A = i11.d(k.S, 0.0f);
        this.F = i11.b(k.O, 0);
        this.f6956c0 = i11.b(k.V, 0);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(a3.d.f116j);
        this.C = dimensionPixelSize;
        this.D = context.getResources().getDimensionPixelSize(a3.d.f117k);
        this.B = dimensionPixelSize;
        setBoxBackgroundMode(i11.k(k.P, 0));
        int i12 = k.M;
        if (i11.s(i12)) {
            ColorStateList c10 = i11.c(i12);
            this.W = c10;
            this.V = c10;
        }
        this.f6954a0 = androidx.core.content.a.d(context, a3.c.f104b);
        this.f6957d0 = androidx.core.content.a.d(context, a3.c.f105c);
        this.f6955b0 = androidx.core.content.a.d(context, a3.c.f106d);
        int i13 = k.f151h0;
        if (i11.n(i13, -1) != -1) {
            setHintTextAppearance(i11.n(i13, 0));
        }
        int n10 = i11.n(k.f139b0, 0);
        boolean a10 = i11.a(k.f137a0, false);
        int n11 = i11.n(k.f145e0, 0);
        boolean a11 = i11.a(k.f143d0, false);
        CharSequence p10 = i11.p(k.f141c0);
        boolean a12 = i11.a(k.W, false);
        setCounterMaxLength(i11.k(k.X, -1));
        this.f6974o = i11.n(k.Z, 0);
        this.f6973n = i11.n(k.Y, 0);
        this.K = i11.a(k.f157k0, false);
        this.L = i11.g(k.f155j0);
        this.M = i11.p(k.f153i0);
        int i14 = k.f159l0;
        if (i11.s(i14)) {
            this.S = true;
            this.R = i11.c(i14);
        }
        int i15 = k.f161m0;
        if (i11.s(i15)) {
            this.U = true;
            this.T = g.b(i11.k(i15, -1), null);
        }
        i11.w();
        setHelperTextEnabled(a11);
        setHelperText(p10);
        setHelperTextTextAppearance(n11);
        setErrorEnabled(a10);
        setErrorTextAppearance(n10);
        setCounterEnabled(a12);
        e();
        a0.u0(this, 2);
    }

    private void A() {
        Drawable background;
        EditText editText = this.f6961g;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (g0.a(background)) {
            background = background.mutate();
        }
        com.google.android.material.internal.b.a(this, this.f6961g, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f6961g.getBottom());
        }
    }

    private void B() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6959f.getLayoutParams();
        int i10 = i();
        if (i10 != layoutParams.topMargin) {
            layoutParams.topMargin = i10;
            this.f6959f.requestLayout();
        }
    }

    private void D(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f6961g;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f6961g;
        boolean z13 = editText2 != null && editText2.hasFocus();
        boolean k10 = this.f6965i.k();
        ColorStateList colorStateList2 = this.V;
        if (colorStateList2 != null) {
            this.f6960f0.B(colorStateList2);
            this.f6960f0.E(this.V);
        }
        if (!isEnabled) {
            this.f6960f0.B(ColorStateList.valueOf(this.f6957d0));
            this.f6960f0.E(ColorStateList.valueOf(this.f6957d0));
        } else if (k10) {
            this.f6960f0.B(this.f6965i.o());
        } else {
            if (this.f6971l && (textView = this.f6972m) != null) {
                aVar = this.f6960f0;
                colorStateList = textView.getTextColors();
            } else if (z13 && (colorStateList = this.W) != null) {
                aVar = this.f6960f0;
            }
            aVar.B(colorStateList);
        }
        if (z12 || (isEnabled() && (z13 || k10))) {
            if (z11 || this.f6958e0) {
                k(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f6958e0) {
            n(z10);
        }
    }

    private void E() {
        if (this.f6961g == null) {
            return;
        }
        if (!x()) {
            CheckableImageButton checkableImageButton = this.N;
            if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
                this.N.setVisibility(8);
            }
            if (this.P != null) {
                Drawable[] a10 = androidx.core.widget.j.a(this.f6961g);
                if (a10[2] == this.P) {
                    androidx.core.widget.j.i(this.f6961g, a10[0], a10[1], this.Q, a10[3]);
                    this.P = null;
                    return;
                }
                return;
            }
            return;
        }
        if (this.N == null) {
            CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(h.f130b, (ViewGroup) this.f6959f, false);
            this.N = checkableImageButton2;
            checkableImageButton2.setImageDrawable(this.L);
            this.N.setContentDescription(this.M);
            this.f6959f.addView(this.N);
            this.N.setOnClickListener(new b());
        }
        EditText editText = this.f6961g;
        if (editText != null && a0.A(editText) <= 0) {
            this.f6961g.setMinimumHeight(a0.A(this.N));
        }
        this.N.setVisibility(0);
        this.N.setChecked(this.O);
        if (this.P == null) {
            this.P = new ColorDrawable();
        }
        this.P.setBounds(0, 0, this.N.getMeasuredWidth(), 1);
        Drawable[] a11 = androidx.core.widget.j.a(this.f6961g);
        Drawable drawable = a11[2];
        Drawable drawable2 = this.P;
        if (drawable != drawable2) {
            this.Q = a11[2];
        }
        androidx.core.widget.j.i(this.f6961g, a11[0], a11[1], drawable2, a11[3]);
        this.N.setPadding(this.f6961g.getPaddingLeft(), this.f6961g.getPaddingTop(), this.f6961g.getPaddingRight(), this.f6961g.getPaddingBottom());
    }

    private void F() {
        if (this.f6981v == 0 || this.f6978s == null || this.f6961g == null || getRight() == 0) {
            return;
        }
        int left = this.f6961g.getLeft();
        int g10 = g();
        int right = this.f6961g.getRight();
        int bottom = this.f6961g.getBottom() + this.f6979t;
        if (this.f6981v == 2) {
            int i10 = this.D;
            left += i10 / 2;
            g10 -= i10 / 2;
            right -= i10 / 2;
            bottom += i10 / 2;
        }
        this.f6978s.setBounds(left, g10, right, bottom);
        c();
        A();
    }

    private void c() {
        int i10;
        Drawable drawable;
        if (this.f6978s == null) {
            return;
        }
        v();
        EditText editText = this.f6961g;
        if (editText != null && this.f6981v == 2) {
            if (editText.getBackground() != null) {
                this.G = this.f6961g.getBackground();
            }
            a0.n0(this.f6961g, null);
        }
        EditText editText2 = this.f6961g;
        if (editText2 != null && this.f6981v == 1 && (drawable = this.G) != null) {
            a0.n0(editText2, drawable);
        }
        int i11 = this.B;
        if (i11 > -1 && (i10 = this.E) != 0) {
            this.f6978s.setStroke(i11, i10);
        }
        this.f6978s.setCornerRadii(getCornerRadiiAsArray());
        this.f6978s.setColor(this.F);
        invalidate();
    }

    private void d(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.f6980u;
        rectF.left = f10 - i10;
        rectF.top -= i10;
        rectF.right += i10;
        rectF.bottom += i10;
    }

    private void e() {
        Drawable drawable = this.L;
        if (drawable != null) {
            if (this.S || this.U) {
                Drawable mutate = androidx.core.graphics.drawable.a.q(drawable).mutate();
                this.L = mutate;
                if (this.S) {
                    androidx.core.graphics.drawable.a.o(mutate, this.R);
                }
                if (this.U) {
                    androidx.core.graphics.drawable.a.p(this.L, this.T);
                }
                CheckableImageButton checkableImageButton = this.N;
                if (checkableImageButton != null) {
                    Drawable drawable2 = checkableImageButton.getDrawable();
                    Drawable drawable3 = this.L;
                    if (drawable2 != drawable3) {
                        this.N.setImageDrawable(drawable3);
                    }
                }
            }
        }
    }

    private void f() {
        GradientDrawable gradientDrawable;
        int i10 = this.f6981v;
        if (i10 == 0) {
            gradientDrawable = null;
        } else if (i10 == 2 && this.f6975p && !(this.f6978s instanceof com.google.android.material.textfield.a)) {
            gradientDrawable = new com.google.android.material.textfield.a();
        } else if (this.f6978s instanceof GradientDrawable) {
            return;
        } else {
            gradientDrawable = new GradientDrawable();
        }
        this.f6978s = gradientDrawable;
    }

    private int g() {
        EditText editText = this.f6961g;
        if (editText == null) {
            return 0;
        }
        int i10 = this.f6981v;
        if (i10 == 1) {
            return editText.getTop();
        }
        if (i10 != 2) {
            return 0;
        }
        return editText.getTop() + i();
    }

    private Drawable getBoxBackground() {
        int i10 = this.f6981v;
        if (i10 == 1 || i10 == 2) {
            return this.f6978s;
        }
        throw new IllegalStateException();
    }

    private float[] getCornerRadiiAsArray() {
        if (g.a(this)) {
            float f10 = this.f6984y;
            float f11 = this.f6983x;
            float f12 = this.A;
            float f13 = this.f6985z;
            return new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
        }
        float f14 = this.f6983x;
        float f15 = this.f6984y;
        float f16 = this.f6985z;
        float f17 = this.A;
        return new float[]{f14, f14, f15, f15, f16, f16, f17, f17};
    }

    private int h() {
        int i10 = this.f6981v;
        return i10 != 1 ? i10 != 2 ? getPaddingTop() : getBoxBackground().getBounds().top - i() : getBoxBackground().getBounds().top + this.f6982w;
    }

    private int i() {
        float m10;
        if (!this.f6975p) {
            return 0;
        }
        int i10 = this.f6981v;
        if (i10 == 0 || i10 == 1) {
            m10 = this.f6960f0.m();
        } else {
            if (i10 != 2) {
                return 0;
            }
            m10 = this.f6960f0.m() / 2.0f;
        }
        return (int) m10;
    }

    private void j() {
        if (l()) {
            ((com.google.android.material.textfield.a) this.f6978s).d();
        }
    }

    private void k(boolean z10) {
        ValueAnimator valueAnimator = this.f6964h0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f6964h0.cancel();
        }
        if (z10 && this.f6962g0) {
            b(1.0f);
        } else {
            this.f6960f0.H(1.0f);
        }
        this.f6958e0 = false;
        if (l()) {
            s();
        }
    }

    private boolean l() {
        return this.f6975p && !TextUtils.isEmpty(this.f6976q) && (this.f6978s instanceof com.google.android.material.textfield.a);
    }

    private void m() {
        Drawable background;
        int i10 = Build.VERSION.SDK_INT;
        if ((i10 != 21 && i10 != 22) || (background = this.f6961g.getBackground()) == null || this.f6966i0) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.f6966i0 = com.google.android.material.internal.c.a((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.f6966i0) {
            return;
        }
        a0.n0(this.f6961g, newDrawable);
        this.f6966i0 = true;
        r();
    }

    private void n(boolean z10) {
        ValueAnimator valueAnimator = this.f6964h0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f6964h0.cancel();
        }
        if (z10 && this.f6962g0) {
            b(0.0f);
        } else {
            this.f6960f0.H(0.0f);
        }
        if (l() && ((com.google.android.material.textfield.a) this.f6978s).a()) {
            j();
        }
        this.f6958e0 = true;
    }

    private boolean o() {
        EditText editText = this.f6961g;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void r() {
        f();
        if (this.f6981v != 0) {
            B();
        }
        F();
    }

    private void s() {
        if (l()) {
            RectF rectF = this.I;
            this.f6960f0.k(rectF);
            d(rectF);
            ((com.google.android.material.textfield.a) this.f6978s).g(rectF);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f6961g != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        boolean z10 = editText instanceof TextInputEditText;
        this.f6961g = editText;
        r();
        setTextInputAccessibilityDelegate(new d(this));
        if (!o()) {
            this.f6960f0.N(this.f6961g.getTypeface());
        }
        this.f6960f0.G(this.f6961g.getTextSize());
        int gravity = this.f6961g.getGravity();
        this.f6960f0.C((gravity & (-113)) | 48);
        this.f6960f0.F(gravity);
        this.f6961g.addTextChangedListener(new a());
        if (this.V == null) {
            this.V = this.f6961g.getHintTextColors();
        }
        if (this.f6975p) {
            if (TextUtils.isEmpty(this.f6976q)) {
                CharSequence hint = this.f6961g.getHint();
                this.f6963h = hint;
                setHint(hint);
                this.f6961g.setHint((CharSequence) null);
            }
            this.f6977r = true;
        }
        if (this.f6972m != null) {
            y(this.f6961g.getText().length());
        }
        this.f6965i.e();
        E();
        D(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f6976q)) {
            return;
        }
        this.f6976q = charSequence;
        this.f6960f0.L(charSequence);
        if (this.f6958e0) {
            return;
        }
        s();
    }

    private static void u(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                u((ViewGroup) childAt, z10);
            }
        }
    }

    private void v() {
        int i10 = this.f6981v;
        if (i10 == 1) {
            this.B = 0;
        } else if (i10 == 2 && this.f6956c0 == 0) {
            this.f6956c0 = this.W.getColorForState(getDrawableState(), this.W.getDefaultColor());
        }
    }

    private boolean x() {
        return this.K && (o() || this.O);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(boolean z10) {
        D(z10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        TextView textView;
        if (this.f6978s == null || this.f6981v == 0) {
            return;
        }
        EditText editText = this.f6961g;
        boolean z10 = editText != null && editText.hasFocus();
        EditText editText2 = this.f6961g;
        boolean z11 = editText2 != null && editText2.isHovered();
        if (this.f6981v == 2) {
            this.E = !isEnabled() ? this.f6957d0 : this.f6965i.k() ? this.f6965i.n() : (!this.f6971l || (textView = this.f6972m) == null) ? z10 ? this.f6956c0 : z11 ? this.f6955b0 : this.f6954a0 : textView.getCurrentTextColor();
            this.B = ((z11 || z10) && isEnabled()) ? this.D : this.C;
            c();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f6959f.addView(view, layoutParams2);
        this.f6959f.setLayoutParams(layoutParams);
        B();
        setEditText((EditText) view);
    }

    void b(float f10) {
        if (this.f6960f0.p() == f10) {
            return;
        }
        if (this.f6964h0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f6964h0 = valueAnimator;
            valueAnimator.setInterpolator(b3.a.f4090b);
            this.f6964h0.setDuration(167L);
            this.f6964h0.addUpdateListener(new c());
        }
        this.f6964h0.setFloatValues(this.f6960f0.p(), f10);
        this.f6964h0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText;
        if (this.f6963h == null || (editText = this.f6961g) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        boolean z10 = this.f6977r;
        this.f6977r = false;
        CharSequence hint = editText.getHint();
        this.f6961g.setHint(this.f6963h);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
        } finally {
            this.f6961g.setHint(hint);
            this.f6977r = z10;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f6970k0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f6970k0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.f6978s;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.f6975p) {
            this.f6960f0.i(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f6968j0) {
            return;
        }
        this.f6968j0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        C(a0.S(this) && isEnabled());
        z();
        F();
        G();
        com.google.android.material.internal.a aVar = this.f6960f0;
        if (aVar != null ? aVar.K(drawableState) | false : false) {
            invalidate();
        }
        this.f6968j0 = false;
    }

    public int getBoxBackgroundColor() {
        return this.F;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f6985z;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.A;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f6984y;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f6983x;
    }

    public int getBoxStrokeColor() {
        return this.f6956c0;
    }

    public int getCounterMaxLength() {
        return this.f6969k;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f6967j && this.f6971l && (textView = this.f6972m) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.V;
    }

    public EditText getEditText() {
        return this.f6961g;
    }

    public CharSequence getError() {
        if (this.f6965i.v()) {
            return this.f6965i.m();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f6965i.n();
    }

    final int getErrorTextCurrentColor() {
        return this.f6965i.n();
    }

    public CharSequence getHelperText() {
        if (this.f6965i.w()) {
            return this.f6965i.p();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f6965i.q();
    }

    public CharSequence getHint() {
        if (this.f6975p) {
            return this.f6976q;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f6960f0.m();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f6960f0.n();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.M;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.L;
    }

    public Typeface getTypeface() {
        return this.J;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        EditText editText;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f6978s != null) {
            F();
        }
        if (!this.f6975p || (editText = this.f6961g) == null) {
            return;
        }
        Rect rect = this.H;
        com.google.android.material.internal.b.a(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.f6961g.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f6961g.getCompoundPaddingRight();
        int h10 = h();
        this.f6960f0.D(compoundPaddingLeft, rect.top + this.f6961g.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f6961g.getCompoundPaddingBottom());
        this.f6960f0.z(compoundPaddingLeft, h10, compoundPaddingRight, (i13 - i11) - getPaddingBottom());
        this.f6960f0.x();
        if (!l() || this.f6958e0) {
            return;
        }
        s();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        E();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        setError(eVar.f6990h);
        if (eVar.f6991i) {
            t(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        if (this.f6965i.k()) {
            eVar.f6990h = getError();
        }
        eVar.f6991i = this.O;
        return eVar;
    }

    public boolean p() {
        return this.f6965i.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f6977r;
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.F != i10) {
            this.F = i10;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.a.d(getContext(), i10));
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f6981v) {
            return;
        }
        this.f6981v = i10;
        r();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f6956c0 != i10) {
            this.f6956c0 = i10;
            G();
        }
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f6967j != z10) {
            if (z10) {
                b0 b0Var = new b0(getContext());
                this.f6972m = b0Var;
                b0Var.setId(a3.f.f125g);
                Typeface typeface = this.J;
                if (typeface != null) {
                    this.f6972m.setTypeface(typeface);
                }
                this.f6972m.setMaxLines(1);
                w(this.f6972m, this.f6974o);
                this.f6965i.d(this.f6972m, 2);
                EditText editText = this.f6961g;
                y(editText == null ? 0 : editText.getText().length());
            } else {
                this.f6965i.x(this.f6972m, 2);
                this.f6972m = null;
            }
            this.f6967j = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f6969k != i10) {
            if (i10 <= 0) {
                i10 = -1;
            }
            this.f6969k = i10;
            if (this.f6967j) {
                EditText editText = this.f6961g;
                y(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.V = colorStateList;
        this.W = colorStateList;
        if (this.f6961g != null) {
            C(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        u(this, z10);
        super.setEnabled(z10);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f6965i.v()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f6965i.r();
        } else {
            this.f6965i.J(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        this.f6965i.z(z10);
    }

    public void setErrorTextAppearance(int i10) {
        this.f6965i.A(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f6965i.B(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (p()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!p()) {
                setHelperTextEnabled(true);
            }
            this.f6965i.K(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f6965i.E(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f6965i.D(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f6965i.C(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f6975p) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f6962g0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f6975p) {
            this.f6975p = z10;
            if (z10) {
                CharSequence hint = this.f6961g.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f6976q)) {
                        setHint(hint);
                    }
                    this.f6961g.setHint((CharSequence) null);
                }
                this.f6977r = true;
            } else {
                this.f6977r = false;
                if (!TextUtils.isEmpty(this.f6976q) && TextUtils.isEmpty(this.f6961g.getHint())) {
                    this.f6961g.setHint(this.f6976q);
                }
                setHintInternal(null);
            }
            if (this.f6961g != null) {
                B();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        this.f6960f0.A(i10);
        this.W = this.f6960f0.l();
        if (this.f6961g != null) {
            C(false);
            B();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i10) {
        setPasswordVisibilityToggleContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.M = charSequence;
        CheckableImageButton checkableImageButton = this.N;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i10) {
        setPasswordVisibilityToggleDrawable(i10 != 0 ? f.a.b(getContext(), i10) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.L = drawable;
        CheckableImageButton checkableImageButton = this.N;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        EditText editText;
        if (this.K != z10) {
            this.K = z10;
            if (!z10 && this.O && (editText = this.f6961g) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.O = false;
            E();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.R = colorStateList;
        this.S = true;
        e();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.T = mode;
        this.U = true;
        e();
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.f6961g;
        if (editText != null) {
            a0.j0(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.J) {
            this.J = typeface;
            this.f6960f0.N(typeface);
            this.f6965i.G(typeface);
            TextView textView = this.f6972m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public void t(boolean z10) {
        boolean z11;
        if (this.K) {
            int selectionEnd = this.f6961g.getSelectionEnd();
            if (o()) {
                this.f6961g.setTransformationMethod(null);
                z11 = true;
            } else {
                this.f6961g.setTransformationMethod(PasswordTransformationMethod.getInstance());
                z11 = false;
            }
            this.O = z11;
            this.N.setChecked(this.O);
            if (z10) {
                this.N.jumpDrawablesToCurrentState();
            }
            this.f6961g.setSelection(selectionEnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.j.n(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = a3.j.f133a
            androidx.core.widget.j.n(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = a3.c.f103a
            int r4 = androidx.core.content.a.d(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.w(android.widget.TextView, int):void");
    }

    void y(int i10) {
        boolean z10 = this.f6971l;
        if (this.f6969k == -1) {
            this.f6972m.setText(String.valueOf(i10));
            this.f6972m.setContentDescription(null);
            this.f6971l = false;
        } else {
            if (a0.n(this.f6972m) == 1) {
                a0.l0(this.f6972m, 0);
            }
            boolean z11 = i10 > this.f6969k;
            this.f6971l = z11;
            if (z10 != z11) {
                w(this.f6972m, z11 ? this.f6973n : this.f6974o);
                if (this.f6971l) {
                    a0.l0(this.f6972m, 1);
                }
            }
            this.f6972m.setText(getContext().getString(i.f132b, Integer.valueOf(i10), Integer.valueOf(this.f6969k)));
            this.f6972m.setContentDescription(getContext().getString(i.f131a, Integer.valueOf(i10), Integer.valueOf(this.f6969k)));
        }
        if (this.f6961g == null || z10 == this.f6971l) {
            return;
        }
        C(false);
        G();
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f6961g;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        m();
        if (g0.a(background)) {
            background = background.mutate();
        }
        if (this.f6965i.k()) {
            currentTextColor = this.f6965i.n();
        } else {
            if (!this.f6971l || (textView = this.f6972m) == null) {
                androidx.core.graphics.drawable.a.c(background);
                this.f6961g.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(androidx.appcompat.widget.k.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }
}
