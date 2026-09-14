package m;

import F0.b3;
import a.AbstractC0228a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import g.AbstractC0424a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5611a;

    /* renamed from: b, reason: collision with root package name */
    public F.c f5612b;

    /* renamed from: c, reason: collision with root package name */
    public F.c f5613c;

    /* renamed from: d, reason: collision with root package name */
    public F.c f5614d;

    /* renamed from: e, reason: collision with root package name */
    public F.c f5615e;

    /* renamed from: f, reason: collision with root package name */
    public F.c f5616f;

    /* renamed from: g, reason: collision with root package name */
    public F.c f5617g;

    /* renamed from: h, reason: collision with root package name */
    public F.c f5618h;
    public final C0551j0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f5619j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f5620k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f5621l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5622m;

    public Z(TextView textView) {
        this.f5611a = textView;
        this.i = new C0551j0(textView);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, F.c] */
    public static F.c c(Context context, C0567s c0567s, int i) {
        ColorStateList f4;
        synchronized (c0567s) {
            f4 = c0567s.f5767a.f(context, i);
        }
        if (f4 != null) {
            ?? obj = new Object();
            obj.f155b = true;
            obj.f156c = f4;
            return obj;
        }
        return null;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i;
        int i3;
        CharSequence subSequence;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i4 >= 30) {
                L.b.a(editorInfo, text);
                return;
            }
            text.getClass();
            if (i4 >= 30) {
                L.b.a(editorInfo, text);
                return;
            }
            int i5 = editorInfo.initialSelStart;
            int i6 = editorInfo.initialSelEnd;
            if (i5 > i6) {
                i = i6;
            } else {
                i = i5;
            }
            if (i5 <= i6) {
                i5 = i6;
            }
            int length = text.length();
            if (i >= 0 && i5 <= length) {
                int i7 = editorInfo.inputType & 4095;
                if (i7 != 129 && i7 != 225 && i7 != 18) {
                    if (length <= 2048) {
                        L.d.b(editorInfo, text, i, i5);
                        return;
                    }
                    int i8 = i5 - i;
                    if (i8 > 1024) {
                        i3 = 0;
                    } else {
                        i3 = i8;
                    }
                    int i9 = 2048 - i3;
                    int min = Math.min(text.length() - i5, i9 - Math.min(i, (int) (i9 * 0.8d)));
                    int min2 = Math.min(i, i9 - min);
                    int i10 = i - min2;
                    if (Character.isLowSurrogate(text.charAt(i10))) {
                        i10++;
                        min2--;
                    }
                    if (Character.isHighSurrogate(text.charAt((i5 + min) - 1))) {
                        min--;
                    }
                    int i11 = min2 + i3;
                    int i12 = i11 + min;
                    if (i3 != i8) {
                        subSequence = TextUtils.concat(text.subSequence(i10, i10 + min2), text.subSequence(i5, min + i5));
                    } else {
                        subSequence = text.subSequence(i10, i12 + i10);
                    }
                    L.d.b(editorInfo, subSequence, min2, i11);
                    return;
                }
                L.d.b(editorInfo, null, 0, 0);
                return;
            }
            L.d.b(editorInfo, null, 0, 0);
        }
    }

    public final void a(Drawable drawable, F.c cVar) {
        if (drawable != null && cVar != null) {
            C0567s.d(drawable, cVar, this.f5611a.getDrawableState());
        }
    }

    public final void b() {
        F.c cVar = this.f5612b;
        TextView textView = this.f5611a;
        if (cVar != null || this.f5613c != null || this.f5614d != null || this.f5615e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f5612b);
            a(compoundDrawables[1], this.f5613c);
            a(compoundDrawables[2], this.f5614d);
            a(compoundDrawables[3], this.f5615e);
        }
        if (this.f5616f == null && this.f5617g == null) {
            return;
        }
        Drawable[] a2 = V.a(textView);
        a(a2[0], this.f5616f);
        a(a2[2], this.f5617g);
    }

    public final ColorStateList d() {
        F.c cVar = this.f5618h;
        if (cVar != null) {
            return (ColorStateList) cVar.f156c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        F.c cVar = this.f5618h;
        if (cVar != null) {
            return (PorterDuff.Mode) cVar.f157d;
        }
        return null;
    }

    public final void f(AttributeSet attributeSet, int i) {
        boolean z3;
        boolean z4;
        String str;
        String str2;
        float f4;
        float f5;
        float f6;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        ColorStateList colorStateList;
        int resourceId;
        int i3;
        int resourceId2;
        TextView textView = this.f5611a;
        Context context = textView.getContext();
        C0567s a2 = C0567s.a();
        int[] iArr = AbstractC0424a.f4634h;
        b3 t3 = b3.t(context, attributeSet, iArr, i);
        J.S.h(textView, textView.getContext(), iArr, attributeSet, (TypedArray) t3.f470c, i);
        TypedArray typedArray = (TypedArray) t3.f470c;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.f5612b = c(context, a2, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.f5613c = c(context, a2, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.f5614d = c(context, a2, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.f5615e = c(context, a2, typedArray.getResourceId(2, 0));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (typedArray.hasValue(5)) {
            this.f5616f = c(context, a2, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.f5617g = c(context, a2, typedArray.getResourceId(6, 0));
        }
        t3.v();
        boolean z5 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = AbstractC0424a.f4648x;
        if (resourceId3 != -1) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            b3 b3Var = new b3(context, obtainStyledAttributes);
            if (!z5 && obtainStyledAttributes.hasValue(14)) {
                z4 = obtainStyledAttributes.getBoolean(14, false);
                z3 = true;
            } else {
                z3 = false;
                z4 = false;
            }
            n(context, b3Var);
            if (obtainStyledAttributes.hasValue(15)) {
                str2 = obtainStyledAttributes.getString(15);
            } else {
                str2 = null;
            }
            if (i4 >= 26 && obtainStyledAttributes.hasValue(13)) {
                str = obtainStyledAttributes.getString(13);
            } else {
                str = null;
            }
            b3Var.v();
        } else {
            z3 = false;
            z4 = false;
            str = null;
            str2 = null;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        b3 b3Var2 = new b3(context, obtainStyledAttributes2);
        if (!z5 && obtainStyledAttributes2.hasValue(14)) {
            z4 = obtainStyledAttributes2.getBoolean(14, false);
            z3 = true;
        }
        boolean z6 = z4;
        if (obtainStyledAttributes2.hasValue(15)) {
            str2 = obtainStyledAttributes2.getString(15);
        }
        if (i4 >= 26 && obtainStyledAttributes2.hasValue(13)) {
            str = obtainStyledAttributes2.getString(13);
        }
        if (i4 >= 28 && obtainStyledAttributes2.hasValue(0) && obtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, b3Var2);
        b3Var2.v();
        if (!z5 && z3) {
            textView.setAllCaps(z6);
        }
        Typeface typeface = this.f5621l;
        if (typeface != null) {
            if (this.f5620k == -1) {
                textView.setTypeface(typeface, this.f5619j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (str != null) {
            X.d(textView, str);
        }
        if (str2 != null) {
            W.b(textView, W.a(str2));
        }
        C0551j0 c0551j0 = this.i;
        Context context2 = c0551j0.f5706j;
        int[] iArr3 = AbstractC0424a.i;
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = c0551j0.i;
        J.S.h(textView2, textView2.getContext(), iArr3, attributeSet, obtainStyledAttributes3, i);
        if (obtainStyledAttributes3.hasValue(5)) {
            c0551j0.f5698a = obtainStyledAttributes3.getInt(5, 0);
        }
        if (obtainStyledAttributes3.hasValue(4)) {
            f4 = obtainStyledAttributes3.getDimension(4, -1.0f);
        } else {
            f4 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(2)) {
            f5 = obtainStyledAttributes3.getDimension(2, -1.0f);
        } else {
            f5 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(1)) {
            f6 = obtainStyledAttributes3.getDimension(1, -1.0f);
        } else {
            f6 = -1.0f;
        }
        if (obtainStyledAttributes3.hasValue(3) && (resourceId2 = obtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i5 = 0; i5 < length; i5++) {
                    iArr4[i5] = obtainTypedArray.getDimensionPixelSize(i5, -1);
                }
                c0551j0.f5703f = C0551j0.b(iArr4);
                c0551j0.h();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes3.recycle();
        if (c0551j0.i()) {
            if (c0551j0.f5698a == 1) {
                if (!c0551j0.f5704g) {
                    DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                    if (f5 == -1.0f) {
                        i3 = 2;
                        f5 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    } else {
                        i3 = 2;
                    }
                    if (f6 == -1.0f) {
                        f6 = TypedValue.applyDimension(i3, 112.0f, displayMetrics);
                    }
                    float f7 = f6;
                    if (f4 == -1.0f) {
                        f4 = 1.0f;
                    }
                    c0551j0.j(f5, f7, f4);
                }
                c0551j0.g();
            }
        } else {
            c0551j0.f5698a = 0;
        }
        if (z1.f5854b && c0551j0.f5698a != 0) {
            int[] iArr5 = c0551j0.f5703f;
            if (iArr5.length > 0) {
                if (X.a(textView) != -1.0f) {
                    X.b(textView, Math.round(c0551j0.f5701d), Math.round(c0551j0.f5702e), Math.round(c0551j0.f5700c), 0);
                } else {
                    X.c(textView, iArr5, 0);
                }
            }
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = obtainStyledAttributes4.getResourceId(8, -1);
        if (resourceId4 != -1) {
            drawable = a2.b(context, resourceId4);
        } else {
            drawable = null;
        }
        int resourceId5 = obtainStyledAttributes4.getResourceId(13, -1);
        if (resourceId5 != -1) {
            drawable2 = a2.b(context, resourceId5);
        } else {
            drawable2 = null;
        }
        int resourceId6 = obtainStyledAttributes4.getResourceId(9, -1);
        if (resourceId6 != -1) {
            drawable3 = a2.b(context, resourceId6);
        } else {
            drawable3 = null;
        }
        int resourceId7 = obtainStyledAttributes4.getResourceId(6, -1);
        if (resourceId7 != -1) {
            drawable4 = a2.b(context, resourceId7);
        } else {
            drawable4 = null;
        }
        int resourceId8 = obtainStyledAttributes4.getResourceId(10, -1);
        if (resourceId8 != -1) {
            drawable5 = a2.b(context, resourceId8);
        } else {
            drawable5 = null;
        }
        int resourceId9 = obtainStyledAttributes4.getResourceId(7, -1);
        if (resourceId9 != -1) {
            drawable6 = a2.b(context, resourceId9);
        } else {
            drawable6 = null;
        }
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] a4 = V.a(textView);
                Drawable drawable7 = a4[0];
                if (drawable7 == null && a4[2] == null) {
                    Drawable[] compoundDrawables = textView.getCompoundDrawables();
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                } else {
                    if (drawable2 == null) {
                        drawable2 = a4[1];
                    }
                    Drawable drawable8 = a4[2];
                    if (drawable4 == null) {
                        drawable4 = a4[3];
                    }
                    V.b(textView, drawable7, drawable2, drawable8, drawable4);
                }
            }
        } else {
            Drawable[] a5 = V.a(textView);
            if (drawable5 == null) {
                drawable5 = a5[0];
            }
            if (drawable2 == null) {
                drawable2 = a5[1];
            }
            if (drawable6 == null) {
                drawable6 = a5[2];
            }
            if (drawable4 == null) {
                drawable4 = a5[3];
            }
            V.b(textView, drawable5, drawable2, drawable6, drawable4);
        }
        if (obtainStyledAttributes4.hasValue(11)) {
            if (!obtainStyledAttributes4.hasValue(11) || (resourceId = obtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = AbstractC0228a.o(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (obtainStyledAttributes4.hasValue(12)) {
            textView.setCompoundDrawableTintMode(AbstractC0565q0.c(obtainStyledAttributes4.getInt(12, -1), null));
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(18, -1);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(19, -1);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != -1) {
            m3.b.K(textView, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            m3.b.L(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            if (dimensionPixelSize3 >= 0) {
                if (dimensionPixelSize3 != textView.getPaint().getFontMetricsInt(null)) {
                    textView.setLineSpacing(dimensionPixelSize3 - r1, 1.0f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void g(Context context, int i) {
        String string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, AbstractC0424a.f4648x);
        b3 b3Var = new b3(context, obtainStyledAttributes);
        boolean hasValue = obtainStyledAttributes.hasValue(14);
        TextView textView = this.f5611a;
        if (hasValue) {
            textView.setAllCaps(obtainStyledAttributes.getBoolean(14, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, b3Var);
        if (i3 >= 26 && obtainStyledAttributes.hasValue(13) && (string = obtainStyledAttributes.getString(13)) != null) {
            X.d(textView, string);
        }
        b3Var.v();
        Typeface typeface = this.f5621l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f5619j);
        }
    }

    public final void i(int i, int i3, int i4, int i5) {
        C0551j0 c0551j0 = this.i;
        if (c0551j0.i()) {
            DisplayMetrics displayMetrics = c0551j0.f5706j.getResources().getDisplayMetrics();
            c0551j0.j(TypedValue.applyDimension(i5, i, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (c0551j0.g()) {
                c0551j0.a();
            }
        }
    }

    public final void j(int[] iArr, int i) {
        C0551j0 c0551j0 = this.i;
        if (c0551j0.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0551j0.f5706j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i, iArr[i3], displayMetrics));
                    }
                }
                c0551j0.f5703f = C0551j0.b(iArr2);
                if (!c0551j0.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                c0551j0.f5704g = false;
            }
            if (c0551j0.g()) {
                c0551j0.a();
            }
        }
    }

    public final void k(int i) {
        C0551j0 c0551j0 = this.i;
        if (c0551j0.i()) {
            if (i != 0) {
                if (i == 1) {
                    DisplayMetrics displayMetrics = c0551j0.f5706j.getResources().getDisplayMetrics();
                    c0551j0.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (c0551j0.g()) {
                        c0551j0.a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(e0.a.c(i, "Unknown auto-size text type: "));
            }
            c0551j0.f5698a = 0;
            c0551j0.f5701d = -1.0f;
            c0551j0.f5702e = -1.0f;
            c0551j0.f5700c = -1.0f;
            c0551j0.f5703f = new int[0];
            c0551j0.f5699b = false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F.c] */
    public final void l(ColorStateList colorStateList) {
        boolean z3;
        if (this.f5618h == null) {
            this.f5618h = new Object();
        }
        F.c cVar = this.f5618h;
        cVar.f156c = colorStateList;
        if (colorStateList != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        cVar.f155b = z3;
        this.f5612b = cVar;
        this.f5613c = cVar;
        this.f5614d = cVar;
        this.f5615e = cVar;
        this.f5616f = cVar;
        this.f5617g = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, F.c] */
    public final void m(PorterDuff.Mode mode) {
        boolean z3;
        if (this.f5618h == null) {
            this.f5618h = new Object();
        }
        F.c cVar = this.f5618h;
        cVar.f157d = mode;
        if (mode != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        cVar.f154a = z3;
        this.f5612b = cVar;
        this.f5613c = cVar;
        this.f5614d = cVar;
        this.f5615e = cVar;
        this.f5616f = cVar;
        this.f5617g = cVar;
    }

    public final void n(Context context, b3 b3Var) {
        String string;
        boolean z3;
        boolean z4;
        int i = this.f5619j;
        TypedArray typedArray = (TypedArray) b3Var.f470c;
        this.f5619j = typedArray.getInt(2, i);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            int i4 = typedArray.getInt(11, -1);
            this.f5620k = i4;
            if (i4 != -1) {
                this.f5619j &= 2;
            }
        }
        int i5 = 10;
        boolean z5 = false;
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f5622m = false;
                int i6 = typedArray.getInt(1, 1);
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            this.f5621l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f5621l = Typeface.SERIF;
                    return;
                }
                this.f5621l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f5621l = null;
        if (typedArray.hasValue(12)) {
            i5 = 12;
        }
        int i7 = this.f5620k;
        int i8 = this.f5619j;
        if (!context.isRestricted()) {
            try {
                Typeface q3 = b3Var.q(i5, this.f5619j, new T0.a(this, i7, i8, new WeakReference(this.f5611a)));
                if (q3 != null) {
                    if (i3 >= 28 && this.f5620k != -1) {
                        Typeface create = Typeface.create(q3, 0);
                        int i9 = this.f5620k;
                        if ((this.f5619j & 2) != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        this.f5621l = Y.a(create, i9, z4);
                    } else {
                        this.f5621l = q3;
                    }
                }
                if (this.f5621l == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f5622m = z3;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f5621l == null && (string = typedArray.getString(i5)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f5620k != -1) {
                Typeface create2 = Typeface.create(string, 0);
                int i10 = this.f5620k;
                if ((this.f5619j & 2) != 0) {
                    z5 = true;
                }
                this.f5621l = Y.a(create2, i10, z5);
                return;
            }
            this.f5621l = Typeface.create(string, this.f5619j);
        }
    }
}
