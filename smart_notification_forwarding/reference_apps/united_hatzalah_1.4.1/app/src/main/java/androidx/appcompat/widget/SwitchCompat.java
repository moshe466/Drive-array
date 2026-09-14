package androidx.appcompat.widget;

import F0.b3;
import J.E;
import J.S;
import V.k;
import X.h;
import a.AbstractC0228a;
import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import g.AbstractC0424a;
import j.C0455a;
import java.util.WeakHashMap;
import m.AbstractC0565q0;
import m.C0573v;
import m.Z;
import m.g1;
import m.h1;
import m.i1;
import m.z1;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: U, reason: collision with root package name */
    public static final g1 f2920U = new g1("thumbPos", 0, Float.class);

    /* renamed from: V, reason: collision with root package name */
    public static final int[] f2921V = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    public final VelocityTracker f2922A;

    /* renamed from: B, reason: collision with root package name */
    public final int f2923B;

    /* renamed from: C, reason: collision with root package name */
    public float f2924C;

    /* renamed from: D, reason: collision with root package name */
    public int f2925D;

    /* renamed from: E, reason: collision with root package name */
    public int f2926E;

    /* renamed from: F, reason: collision with root package name */
    public int f2927F;

    /* renamed from: G, reason: collision with root package name */
    public int f2928G;

    /* renamed from: H, reason: collision with root package name */
    public int f2929H;

    /* renamed from: I, reason: collision with root package name */
    public int f2930I;

    /* renamed from: J, reason: collision with root package name */
    public int f2931J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f2932K;

    /* renamed from: L, reason: collision with root package name */
    public final TextPaint f2933L;

    /* renamed from: M, reason: collision with root package name */
    public final ColorStateList f2934M;

    /* renamed from: N, reason: collision with root package name */
    public StaticLayout f2935N;

    /* renamed from: O, reason: collision with root package name */
    public StaticLayout f2936O;

    /* renamed from: P, reason: collision with root package name */
    public final C0455a f2937P;

    /* renamed from: Q, reason: collision with root package name */
    public ObjectAnimator f2938Q;

    /* renamed from: R, reason: collision with root package name */
    public C0573v f2939R;

    /* renamed from: S, reason: collision with root package name */
    public h f2940S;

    /* renamed from: T, reason: collision with root package name */
    public final Rect f2941T;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f2942a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f2943b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2944c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2945d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2946e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2947f;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f2948j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f2949k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2950l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2951m;

    /* renamed from: n, reason: collision with root package name */
    public int f2952n;

    /* renamed from: o, reason: collision with root package name */
    public int f2953o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2954q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2955r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f2956s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f2957t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f2958u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2959v;

    /* renamed from: w, reason: collision with root package name */
    public int f2960w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2961x;
    public float y;

    /* renamed from: z, reason: collision with root package name */
    public float f2962z;

    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.Object, j.a] */
    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.uh.sf.R.attr.switchStyle);
        Typeface typeface;
        Typeface create;
        int i;
        int resourceId;
        this.f2943b = null;
        this.f2944c = null;
        this.f2945d = false;
        this.f2946e = false;
        this.f2948j = null;
        this.f2949k = null;
        this.f2950l = false;
        this.f2951m = false;
        this.f2922A = VelocityTracker.obtain();
        this.f2932K = true;
        this.f2941T = new Rect();
        i1.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f2933L = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = AbstractC0424a.f4647w;
        b3 t3 = b3.t(context, attributeSet, iArr, com.uh.sf.R.attr.switchStyle);
        TypedArray typedArray = (TypedArray) t3.f470c;
        S.h(this, context, iArr, attributeSet, typedArray, com.uh.sf.R.attr.switchStyle);
        Drawable o2 = t3.o(2);
        this.f2942a = o2;
        if (o2 != null) {
            o2.setCallback(this);
        }
        Drawable o4 = t3.o(11);
        this.f2947f = o4;
        if (o4 != null) {
            o4.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.f2959v = typedArray.getBoolean(3, true);
        this.f2952n = typedArray.getDimensionPixelSize(8, 0);
        this.f2953o = typedArray.getDimensionPixelSize(5, 0);
        this.p = typedArray.getDimensionPixelSize(6, 0);
        this.f2954q = typedArray.getBoolean(4, false);
        ColorStateList n4 = t3.n(9);
        if (n4 != null) {
            this.f2943b = n4;
            this.f2945d = true;
        }
        PorterDuff.Mode c4 = AbstractC0565q0.c(typedArray.getInt(10, -1), null);
        if (this.f2944c != c4) {
            this.f2944c = c4;
            this.f2946e = true;
        }
        if (this.f2945d || this.f2946e) {
            a();
        }
        ColorStateList n5 = t3.n(12);
        if (n5 != null) {
            this.f2948j = n5;
            this.f2950l = true;
        }
        PorterDuff.Mode c5 = AbstractC0565q0.c(typedArray.getInt(13, -1), null);
        if (this.f2949k != c5) {
            this.f2949k = c5;
            this.f2951m = true;
        }
        if (this.f2950l || this.f2951m) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, AbstractC0424a.f4648x);
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = AbstractC0228a.o(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.f2934M = colorStateList;
            } else {
                this.f2934M = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f4 = dimensionPixelSize;
                if (f4 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f4);
                    requestLayout();
                }
            }
            int i3 = obtainStyledAttributes.getInt(1, -1);
            int i4 = obtainStyledAttributes.getInt(2, -1);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        typeface = null;
                    } else {
                        typeface = Typeface.MONOSPACE;
                    }
                } else {
                    typeface = Typeface.SERIF;
                }
            } else {
                typeface = Typeface.SANS_SERIF;
            }
            if (i4 > 0) {
                if (typeface == null) {
                    create = Typeface.defaultFromStyle(i4);
                } else {
                    create = Typeface.create(typeface, i4);
                }
                setSwitchTypeface(create);
                if (create != null) {
                    i = create.getStyle();
                } else {
                    i = 0;
                }
                int i5 = (~i) & i4;
                textPaint.setFakeBoldText((i5 & 1) != 0);
                textPaint.setTextSkewX((2 & i5) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                ?? obj = new Object();
                obj.f5098a = context2.getResources().getConfiguration().locale;
                this.f2937P = obj;
            } else {
                this.f2937P = null;
            }
            setTextOnInternal(this.f2955r);
            setTextOffInternal(this.f2957t);
            obtainStyledAttributes.recycle();
        }
        new Z(this).f(attributeSet, com.uh.sf.R.attr.switchStyle);
        t3.v();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2961x = viewConfiguration.getScaledTouchSlop();
        this.f2923B = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, com.uh.sf.R.attr.switchStyle);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private C0573v getEmojiTextViewHelper() {
        if (this.f2939R == null) {
            this.f2939R = new C0573v(this);
        }
        return this.f2939R;
    }

    private boolean getTargetCheckedState() {
        if (this.f2924C > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f4;
        if (z1.a(this)) {
            f4 = 1.0f - this.f2924C;
        } else {
            f4 = this.f2924C;
        }
        return (int) ((f4 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f2947f;
        if (drawable != null) {
            Rect rect2 = this.f2941T;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.f2942a;
            if (drawable2 != null) {
                rect = AbstractC0565q0.b(drawable2);
            } else {
                rect = AbstractC0565q0.f5754c;
            }
            return ((((this.f2925D - this.f2927F) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2957t = charSequence;
        TransformationMethod V2 = ((m3.b) getEmojiTextViewHelper().f5798b.f546b).V(this.f2937P);
        if (V2 != null) {
            charSequence = V2.getTransformation(charSequence, this);
        }
        this.f2958u = charSequence;
        this.f2936O = null;
        if (this.f2959v) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2955r = charSequence;
        TransformationMethod V2 = ((m3.b) getEmojiTextViewHelper().f5798b.f546b).V(this.f2937P);
        if (V2 != null) {
            charSequence = V2.getTransformation(charSequence, this);
        }
        this.f2956s = charSequence;
        this.f2935N = null;
        if (this.f2959v) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f2942a;
        if (drawable != null) {
            if (this.f2945d || this.f2946e) {
                Drawable mutate = drawable.mutate();
                this.f2942a = mutate;
                if (this.f2945d) {
                    mutate.setTintList(this.f2943b);
                }
                if (this.f2946e) {
                    this.f2942a.setTintMode(this.f2944c);
                }
                if (this.f2942a.isStateful()) {
                    this.f2942a.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f2947f;
        if (drawable != null) {
            if (this.f2950l || this.f2951m) {
                Drawable mutate = drawable.mutate();
                this.f2947f = mutate;
                if (this.f2950l) {
                    mutate.setTintList(this.f2948j);
                }
                if (this.f2951m) {
                    this.f2947f.setTintMode(this.f2949k);
                }
                if (this.f2947f.isStateful()) {
                    this.f2947f.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f2955r);
        setTextOffInternal(this.f2957t);
        requestLayout();
    }

    public final void d() {
        if (this.f2940S == null && ((m3.b) this.f2939R.f5798b.f546b).B() && k.f2396j != null) {
            k a2 = k.a();
            int b4 = a2.b();
            if (b4 == 3 || b4 == 0) {
                h hVar = new h(this);
                this.f2940S = hVar;
                a2.f(hVar);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i3;
        int i4 = this.f2928G;
        int i5 = this.f2929H;
        int i6 = this.f2930I;
        int i7 = this.f2931J;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f2942a;
        if (drawable != null) {
            rect = AbstractC0565q0.b(drawable);
        } else {
            rect = AbstractC0565q0.f5754c;
        }
        Drawable drawable2 = this.f2947f;
        Rect rect2 = this.f2941T;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                if (i10 > i11) {
                    i = (i10 - i11) + i5;
                } else {
                    i = i5;
                }
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f2947f.setBounds(i4, i, i6, i3);
                }
            } else {
                i = i5;
            }
            i3 = i7;
            this.f2947f.setBounds(i4, i, i6, i3);
        }
        Drawable drawable3 = this.f2942a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.f2927F + rect2.right;
            this.f2942a.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                background.setHotspotBounds(i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.f2942a;
        if (drawable != null) {
            drawable.setHotspot(f4, f5);
        }
        Drawable drawable2 = this.f2947f;
        if (drawable2 != null) {
            drawable2.setHotspot(f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        boolean z3;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2942a;
        if (drawable != null && drawable.isStateful()) {
            z3 = drawable.setState(drawableState);
        } else {
            z3 = false;
        }
        Drawable drawable2 = this.f2947f;
        if (drawable2 != null && drawable2.isStateful()) {
            z3 |= drawable2.setState(drawableState);
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!z1.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2925D;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.p;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (z1.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2925D;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.p;
        }
        return compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return m3.b.S(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2959v;
    }

    public boolean getSplitTrack() {
        return this.f2954q;
    }

    public int getSwitchMinWidth() {
        return this.f2953o;
    }

    public int getSwitchPadding() {
        return this.p;
    }

    public CharSequence getTextOff() {
        return this.f2957t;
    }

    public CharSequence getTextOn() {
        return this.f2955r;
    }

    public Drawable getThumbDrawable() {
        return this.f2942a;
    }

    public final float getThumbPosition() {
        return this.f2924C;
    }

    public int getThumbTextPadding() {
        return this.f2952n;
    }

    public ColorStateList getThumbTintList() {
        return this.f2943b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2944c;
    }

    public Drawable getTrackDrawable() {
        return this.f2947f;
    }

    public ColorStateList getTrackTintList() {
        return this.f2948j;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2949k;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2942a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2947f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f2938Q;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f2938Q.end();
            this.f2938Q = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f2921V);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        StaticLayout staticLayout;
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f2947f;
        Rect rect = this.f2941T;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f2929H;
        int i3 = this.f2931J;
        int i4 = i + rect.top;
        int i5 = i3 - rect.bottom;
        Drawable drawable2 = this.f2942a;
        if (drawable != null) {
            if (this.f2954q && drawable2 != null) {
                Rect b4 = AbstractC0565q0.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b4.left;
                rect.right -= b4.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            staticLayout = this.f2935N;
        } else {
            staticLayout = this.f2936O;
        }
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.f2933L;
            ColorStateList colorStateList = this.f2934M;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i4 + i5) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.f2955r;
            } else {
                charSequence = this.f2957t;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        super.onLayout(z3, i, i3, i4, i5);
        int i10 = 0;
        if (this.f2942a != null) {
            Drawable drawable = this.f2947f;
            Rect rect = this.f2941T;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b4 = AbstractC0565q0.b(this.f2942a);
            i6 = Math.max(0, b4.left - rect.left);
            i10 = Math.max(0, b4.right - rect.right);
        } else {
            i6 = 0;
        }
        if (z1.a(this)) {
            i7 = getPaddingLeft() + i6;
            width = ((this.f2925D + i7) - i6) - i10;
        } else {
            width = (getWidth() - getPaddingRight()) - i10;
            i7 = (width - this.f2925D) + i6 + i10;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i9 = getPaddingTop();
                i8 = this.f2926E + i9;
            } else {
                i8 = getHeight() - getPaddingBottom();
                i9 = i8 - this.f2926E;
            }
        } else {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i11 = this.f2926E;
            int i12 = height - (i11 / 2);
            i8 = i11 + i12;
            i9 = i12;
        }
        this.f2928G = i7;
        this.f2929H = i9;
        this.f2931J = i8;
        this.f2930I = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (this.f2959v) {
            StaticLayout staticLayout = this.f2935N;
            TextPaint textPaint = this.f2933L;
            if (staticLayout == null) {
                CharSequence charSequence = this.f2956s;
                if (charSequence != null) {
                    i9 = (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint));
                } else {
                    i9 = 0;
                }
                this.f2935N = new StaticLayout(charSequence, textPaint, i9, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.f2936O == null) {
                CharSequence charSequence2 = this.f2958u;
                if (charSequence2 != null) {
                    i8 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
                } else {
                    i8 = 0;
                }
                this.f2936O = new StaticLayout(charSequence2, textPaint, i8, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f2942a;
        Rect rect = this.f2941T;
        if (drawable != null) {
            drawable.getPadding(rect);
            i4 = (this.f2942a.getIntrinsicWidth() - rect.left) - rect.right;
            i5 = this.f2942a.getIntrinsicHeight();
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (this.f2959v) {
            i6 = (this.f2952n * 2) + Math.max(this.f2935N.getWidth(), this.f2936O.getWidth());
        } else {
            i6 = 0;
        }
        this.f2927F = Math.max(i6, i4);
        Drawable drawable2 = this.f2947f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i10 = this.f2947f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i11 = rect.left;
        int i12 = rect.right;
        Drawable drawable3 = this.f2942a;
        if (drawable3 != null) {
            Rect b4 = AbstractC0565q0.b(drawable3);
            i11 = Math.max(i11, b4.left);
            i12 = Math.max(i12, b4.right);
        }
        if (this.f2932K) {
            i7 = Math.max(this.f2953o, (this.f2927F * 2) + i11 + i12);
        } else {
            i7 = this.f2953o;
        }
        int max = Math.max(i10, i5);
        this.f2925D = i7;
        this.f2926E = max;
        super.onMeasure(i, i3);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.f2955r;
        } else {
            charSequence = this.f2957t;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().c(z3);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        super.setChecked(z3);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f2955r;
                if (obj == null) {
                    obj = getResources().getString(com.uh.sf.R.string.abc_capital_on);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = S.f954a;
                new E(com.uh.sf.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.f2957t;
            if (obj3 == null) {
                obj3 = getResources().getString(com.uh.sf.R.string.abc_capital_off);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = S.f954a;
            new E(com.uh.sf.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj4);
        }
        float f4 = 0.0f;
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = S.f954a;
            if (isLaidOut()) {
                if (isChecked) {
                    f4 = 1.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f2920U, f4);
                this.f2938Q = ofFloat;
                ofFloat.setDuration(250L);
                h1.a(this.f2938Q, true);
                this.f2938Q.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.f2938Q;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (isChecked) {
            f4 = 1.0f;
        }
        setThumbPosition(f4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(m3.b.U(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().d(z3);
        setTextOnInternal(this.f2955r);
        setTextOffInternal(this.f2957t);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z3) {
        this.f2932K = z3;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z3) {
        if (this.f2959v != z3) {
            this.f2959v = z3;
            requestLayout();
            if (z3) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z3) {
        this.f2954q = z3;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f2953o = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.p = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.f2933L;
        if ((textPaint.getTypeface() != null && !textPaint.getTypeface().equals(typeface)) || (textPaint.getTypeface() == null && typeface != null)) {
            textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f2957t;
            if (obj == null) {
                obj = getResources().getString(com.uh.sf.R.string.abc_capital_off);
            }
            WeakHashMap weakHashMap = S.f954a;
            new E(com.uh.sf.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked() && Build.VERSION.SDK_INT >= 30) {
            Object obj = this.f2955r;
            if (obj == null) {
                obj = getResources().getString(com.uh.sf.R.string.abc_capital_on);
            }
            WeakHashMap weakHashMap = S.f954a;
            new E(com.uh.sf.R.id.tag_state_description, CharSequence.class, 64, 30, 2).d(this, obj);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2942a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2942a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.f2924C = f4;
        invalidate();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AbstractC0228a.q(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f2952n = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2943b = colorStateList;
        this.f2945d = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2944c = mode;
        this.f2946e = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2947f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2947f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AbstractC0228a.q(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2948j = colorStateList;
        this.f2950l = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2949k = mode;
        this.f2951m = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f2942a && drawable != this.f2947f) {
            return false;
        }
        return true;
    }
}
