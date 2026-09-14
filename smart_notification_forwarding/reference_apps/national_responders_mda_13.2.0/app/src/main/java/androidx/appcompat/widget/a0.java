package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.h;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes.dex */
class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f1210a;

    /* renamed from: b, reason: collision with root package name */
    private w0 f1211b;

    /* renamed from: c, reason: collision with root package name */
    private w0 f1212c;

    /* renamed from: d, reason: collision with root package name */
    private w0 f1213d;

    /* renamed from: e, reason: collision with root package name */
    private w0 f1214e;

    /* renamed from: f, reason: collision with root package name */
    private w0 f1215f;

    /* renamed from: g, reason: collision with root package name */
    private w0 f1216g;

    /* renamed from: h, reason: collision with root package name */
    private w0 f1217h;

    /* renamed from: i, reason: collision with root package name */
    private final c0 f1218i;

    /* renamed from: j, reason: collision with root package name */
    private int f1219j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f1220k = -1;

    /* renamed from: l, reason: collision with root package name */
    private Typeface f1221l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1222m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends h.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1224b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f1225c;

        a(int i10, int i11, WeakReference weakReference) {
            this.f1223a = i10;
            this.f1224b = i11;
            this.f1225c = weakReference;
        }

        @Override // androidx.core.content.res.h.f
        /* renamed from: h */
        public void f(int i10) {
        }

        @Override // androidx.core.content.res.h.f
        /* renamed from: i */
        public void g(Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1223a) != -1) {
                typeface = g.a(typeface, i10, (this.f1224b & 2) != 0);
            }
            a0.this.n(this.f1225c, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f1227f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Typeface f1228g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f1229h;

        b(a0 a0Var, TextView textView, Typeface typeface, int i10) {
            this.f1227f = textView;
            this.f1228g = typeface;
            this.f1229h = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1227f.setTypeface(this.f1228g, this.f1229h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* loaded from: classes.dex */
    static class d {
        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* loaded from: classes.dex */
    static class e {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* loaded from: classes.dex */
    static class f {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(TextView textView) {
        this.f1210a = textView;
        this.f1218i = new c0(textView);
    }

    private void B(int i10, float f10) {
        this.f1218i.w(i10, f10);
    }

    private void C(Context context, y0 y0Var) {
        String o10;
        Typeface create;
        Typeface typeface;
        this.f1219j = y0Var.k(e.j.A2, this.f1219j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int k10 = y0Var.k(e.j.J2, -1);
            this.f1220k = k10;
            if (k10 != -1) {
                this.f1219j = (this.f1219j & 2) | 0;
            }
        }
        int i11 = e.j.I2;
        if (!y0Var.s(i11) && !y0Var.s(e.j.K2)) {
            int i12 = e.j.f9120z2;
            if (y0Var.s(i12)) {
                this.f1222m = false;
                int k11 = y0Var.k(i12, 1);
                if (k11 == 1) {
                    typeface = Typeface.SANS_SERIF;
                } else if (k11 == 2) {
                    typeface = Typeface.SERIF;
                } else if (k11 != 3) {
                    return;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
                this.f1221l = typeface;
                return;
            }
            return;
        }
        this.f1221l = null;
        int i13 = e.j.K2;
        if (y0Var.s(i13)) {
            i11 = i13;
        }
        int i14 = this.f1220k;
        int i15 = this.f1219j;
        if (!context.isRestricted()) {
            try {
                Typeface j10 = y0Var.j(i11, this.f1219j, new a(i14, i15, new WeakReference(this.f1210a)));
                if (j10 != null) {
                    if (i10 >= 28 && this.f1220k != -1) {
                        j10 = g.a(Typeface.create(j10, 0), this.f1220k, (this.f1219j & 2) != 0);
                    }
                    this.f1221l = j10;
                }
                this.f1222m = this.f1221l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1221l != null || (o10 = y0Var.o(i11)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1220k == -1) {
            create = Typeface.create(o10, this.f1219j);
        } else {
            create = g.a(Typeface.create(o10, 0), this.f1220k, (this.f1219j & 2) != 0);
        }
        this.f1221l = create;
    }

    private void a(Drawable drawable, w0 w0Var) {
        if (drawable == null || w0Var == null) {
            return;
        }
        k.i(drawable, w0Var, this.f1210a.getDrawableState());
    }

    private static w0 d(Context context, k kVar, int i10) {
        ColorStateList f10 = kVar.f(context, i10);
        if (f10 == null) {
            return null;
        }
        w0 w0Var = new w0();
        w0Var.f1537d = true;
        w0Var.f1534a = f10;
        return w0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] a10 = c.a(this.f1210a);
            TextView textView = this.f1210a;
            if (drawable5 == null) {
                drawable5 = a10[0];
            }
            if (drawable2 == null) {
                drawable2 = a10[1];
            }
            if (drawable6 == null) {
                drawable6 = a10[2];
            }
            if (drawable4 == null) {
                drawable4 = a10[3];
            }
            c.b(textView, drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i10 >= 17) {
            Drawable[] a11 = c.a(this.f1210a);
            if (a11[0] != null || a11[2] != null) {
                TextView textView2 = this.f1210a;
                Drawable drawable7 = a11[0];
                if (drawable2 == null) {
                    drawable2 = a11[1];
                }
                Drawable drawable8 = a11[2];
                if (drawable4 == null) {
                    drawable4 = a11[3];
                }
                c.b(textView2, drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f1210a.getCompoundDrawables();
        TextView textView3 = this.f1210a;
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
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        w0 w0Var = this.f1217h;
        this.f1211b = w0Var;
        this.f1212c = w0Var;
        this.f1213d = w0Var;
        this.f1214e = w0Var;
        this.f1215f = w0Var;
        this.f1216g = w0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10, float f10) {
        if (androidx.core.widget.b.f2683a || l()) {
            return;
        }
        B(i10, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1211b != null || this.f1212c != null || this.f1213d != null || this.f1214e != null) {
            Drawable[] compoundDrawables = this.f1210a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1211b);
            a(compoundDrawables[1], this.f1212c);
            a(compoundDrawables[2], this.f1213d);
            a(compoundDrawables[3], this.f1214e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f1215f == null && this.f1216g == null) {
                return;
            }
            Drawable[] a10 = c.a(this.f1210a);
            a(a10[0], this.f1215f);
            a(a10[2], this.f1216g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1218i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1218i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1218i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1218i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1218i.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1218i.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        w0 w0Var = this.f1217h;
        if (w0Var != null) {
            return w0Var.f1534a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        w0 w0Var = this.f1217h;
        if (w0Var != null) {
            return w0Var.f1535b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1218i.q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e9  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.a0.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1222m) {
            this.f1221l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (androidx.core.view.a0.R(textView)) {
                    textView.post(new b(this, textView, typeface, this.f1219j));
                } else {
                    textView.setTypeface(typeface, this.f1219j);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z10, int i10, int i11, int i12, int i13) {
        if (androidx.core.widget.b.f2683a) {
            return;
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i10) {
        String o10;
        ColorStateList c10;
        ColorStateList c11;
        ColorStateList c12;
        y0 t10 = y0.t(context, i10, e.j.f9110x2);
        int i11 = e.j.M2;
        if (t10.s(i11)) {
            s(t10.a(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = e.j.B2;
            if (t10.s(i13) && (c12 = t10.c(i13)) != null) {
                this.f1210a.setTextColor(c12);
            }
            int i14 = e.j.D2;
            if (t10.s(i14) && (c11 = t10.c(i14)) != null) {
                this.f1210a.setLinkTextColor(c11);
            }
            int i15 = e.j.C2;
            if (t10.s(i15) && (c10 = t10.c(i15)) != null) {
                this.f1210a.setHintTextColor(c10);
            }
        }
        int i16 = e.j.f9115y2;
        if (t10.s(i16) && t10.f(i16, -1) == 0) {
            this.f1210a.setTextSize(0, 0.0f);
        }
        C(context, t10);
        if (i12 >= 26) {
            int i17 = e.j.L2;
            if (t10.s(i17) && (o10 = t10.o(i17)) != null) {
                f.d(this.f1210a, o10);
            }
        }
        t10.w();
        Typeface typeface = this.f1221l;
        if (typeface != null) {
            this.f1210a.setTypeface(typeface, this.f1219j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        w.a.f(editorInfo, textView.getText());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        this.f1210a.setAllCaps(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10, int i11, int i12, int i13) {
        this.f1218i.s(i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int[] iArr, int i10) {
        this.f1218i.t(iArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i10) {
        this.f1218i.u(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        if (this.f1217h == null) {
            this.f1217h = new w0();
        }
        w0 w0Var = this.f1217h;
        w0Var.f1534a = colorStateList;
        w0Var.f1537d = colorStateList != null;
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        if (this.f1217h == null) {
            this.f1217h = new w0();
        }
        w0 w0Var = this.f1217h;
        w0Var.f1535b = mode;
        w0Var.f1536c = mode != null;
        z();
    }
}
