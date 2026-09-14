package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f1280l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> f1281m = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> f1282n = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private int f1283a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1284b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f1285c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f1286d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f1287e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f1288f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f1289g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f1290h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f1291i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f1292j;

    /* renamed from: k, reason: collision with root package name */
    private final f f1293k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        static boolean a(View view) {
            return view.isInLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.a(obtain, textView);
            } catch (ClassCastException unused) {
            }
            return obtain.build();
        }
    }

    /* loaded from: classes.dex */
    private static class d extends f {
        d() {
        }

        @Override // androidx.appcompat.widget.c0.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) c0.p(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.c0.d, androidx.appcompat.widget.c0.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.c0.f
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {
        f() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) c0.p(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(TextView textView) {
        this.f1291i = textView;
        this.f1292j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        this.f1293k = i10 >= 29 ? new e() : i10 >= 23 ? new d() : new f();
    }

    private boolean A(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1291i.getText();
        TransformationMethod transformationMethod = this.f1291i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1291i)) != null) {
            text = transformation;
        }
        int b10 = Build.VERSION.SDK_INT >= 16 ? a.b(this.f1291i) : -1;
        o(i10);
        StaticLayout e10 = e(text, (Layout.Alignment) p(this.f1291i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b10);
        return (b10 == -1 || (e10.getLineCount() <= b10 && e10.getLineEnd(e10.getLineCount() - 1) == text.length())) && ((float) e10.getHeight()) <= rectF.bottom;
    }

    private boolean B() {
        return !(this.f1291i instanceof AppCompatEditText);
    }

    private void C(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f1283a = 1;
        this.f1286d = f10;
        this.f1287e = f11;
        this.f1285c = f12;
        this.f1289g = false;
    }

    private static <T> T a(Object obj, String str, T t10) {
        try {
            Field m10 = m(str);
            return m10 == null ? t10 : (T) m10.get(obj);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to access TextView#");
            sb2.append(str);
            sb2.append(" member");
            return t10;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f1283a = 0;
        this.f1286d = -1.0f;
        this.f1287e = -1.0f;
        this.f1285c = -1.0f;
        this.f1288f = new int[0];
        this.f1284b = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f1290h, i10, alignment, ((Float) a(this.f1291i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f1291i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f1291i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private int g(RectF rectF) {
        int length = this.f1288f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = length - 1;
        int i11 = 1;
        int i12 = 0;
        while (i11 <= i10) {
            int i13 = (i11 + i10) / 2;
            if (A(this.f1288f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i11;
                i11 = i14;
            } else {
                i12 = i13 - 1;
                i10 = i12;
            }
        }
        return this.f1288f[i12];
    }

    private static Field m(String str) {
        try {
            Field field = f1282n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1282n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to access TextView#");
            sb2.append(str);
            sb2.append(" member");
            return null;
        }
    }

    private static Method n(String str) {
        try {
            Method method = f1281m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1281m.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to retrieve TextView#");
            sb2.append(str);
            sb2.append("() method");
            return null;
        }
    }

    static <T> T p(Object obj, String str, T t10) {
        try {
            return (T) n(str).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to invoke TextView#");
            sb2.append(str);
            sb2.append("() method");
            return t10;
        }
    }

    private void v(float f10) {
        if (f10 != this.f1291i.getPaint().getTextSize()) {
            this.f1291i.getPaint().setTextSize(f10);
            boolean a10 = Build.VERSION.SDK_INT >= 18 ? b.a(this.f1291i) : false;
            if (this.f1291i.getLayout() != null) {
                this.f1284b = false;
                try {
                    Method n10 = n("nullLayouts");
                    if (n10 != null) {
                        n10.invoke(this.f1291i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (a10) {
                    this.f1291i.forceLayout();
                } else {
                    this.f1291i.requestLayout();
                }
                this.f1291i.invalidate();
            }
        }
    }

    private boolean x() {
        if (B() && this.f1283a == 1) {
            if (!this.f1289g || this.f1288f.length == 0) {
                int floor = ((int) Math.floor((this.f1287e - this.f1286d) / this.f1285c)) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f1286d + (i10 * this.f1285c));
                }
                this.f1288f = c(iArr);
            }
            this.f1284b = true;
        } else {
            this.f1284b = false;
        }
        return this.f1284b;
    }

    private void y(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f1288f = c(iArr);
            z();
        }
    }

    private boolean z() {
        boolean z10 = this.f1288f.length > 0;
        this.f1289g = z10;
        if (z10) {
            this.f1283a = 1;
            this.f1286d = r0[0];
            this.f1287e = r0[r1 - 1];
            this.f1285c = -1.0f;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (q()) {
            if (this.f1284b) {
                if (this.f1291i.getMeasuredHeight() <= 0 || this.f1291i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1293k.b(this.f1291i) ? 1048576 : (this.f1291i.getMeasuredWidth() - this.f1291i.getTotalPaddingLeft()) - this.f1291i.getTotalPaddingRight();
                int height = (this.f1291i.getHeight() - this.f1291i.getCompoundPaddingBottom()) - this.f1291i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1280l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float g10 = g(rectF);
                    if (g10 != this.f1291i.getTextSize()) {
                        w(0, g10);
                    }
                }
            }
            this.f1284b = true;
        }
    }

    StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        return i12 >= 23 ? c.a(charSequence, alignment, i10, i11, this.f1291i, this.f1290h, this.f1293k) : i12 >= 16 ? a.a(charSequence, alignment, i10, this.f1291i, this.f1290h) : f(charSequence, alignment, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1287e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return Math.round(this.f1286d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return Math.round(this.f1285c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] k() {
        return this.f1288f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f1283a;
    }

    void o(int i10) {
        TextPaint textPaint = this.f1290h;
        if (textPaint == null) {
            this.f1290h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1290h.set(this.f1291i.getPaint());
        this.f1290h.setTextSize(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return B() && this.f1283a != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.f1292j;
        int[] iArr = e.j.f9008d0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f1291i;
        androidx.core.view.a0.h0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i10, 0);
        int i11 = e.j.f9033i0;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f1283a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = e.j.f9028h0;
        float dimension = obtainStyledAttributes.hasValue(i12) ? obtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = e.j.f9018f0;
        float dimension2 = obtainStyledAttributes.hasValue(i13) ? obtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = e.j.f9013e0;
        float dimension3 = obtainStyledAttributes.hasValue(i14) ? obtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = e.j.f9023g0;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            y(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!B()) {
            this.f1283a = 0;
            return;
        }
        if (this.f1283a == 1) {
            if (!this.f1289g) {
                DisplayMetrics displayMetrics = this.f1292j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                C(dimension2, dimension3, dimension);
            }
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i10, int i11, int i12, int i13) {
        if (B()) {
            DisplayMetrics displayMetrics = this.f1292j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (x()) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int[] iArr, int i10) {
        if (B()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1292j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f1288f = c(iArr2);
                if (!z()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1289g = false;
            }
            if (x()) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i10) {
        if (B()) {
            if (i10 == 0) {
                d();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f1292j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (x()) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i10, float f10) {
        Context context = this.f1292j;
        v(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
