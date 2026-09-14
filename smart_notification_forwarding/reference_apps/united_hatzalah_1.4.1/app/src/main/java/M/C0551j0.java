package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: m.j0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0551j0 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f5696l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f5697m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f5698a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5699b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f5700c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f5701d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f5702e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f5703f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f5704g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f5705h;
    public final TextView i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f5706j;

    /* renamed from: k, reason: collision with root package name */
    public final C0545g0 f5707k;

    static {
        new ConcurrentHashMap();
    }

    public C0551j0(TextView textView) {
        this.i = textView;
        this.f5706j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f5707k = new C0547h0();
        } else {
            this.f5707k = new C0545g0();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f5697m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a() {
        int measuredWidth;
        if (e()) {
            if (this.f5699b) {
                if (this.i.getMeasuredHeight() > 0 && this.i.getMeasuredWidth() > 0) {
                    if (this.f5707k.b(this.i)) {
                        measuredWidth = 1048576;
                    } else {
                        measuredWidth = (this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft()) - this.i.getTotalPaddingRight();
                    }
                    int height = (this.i.getHeight() - this.i.getCompoundPaddingBottom()) - this.i.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f5696l;
                        synchronized (rectF) {
                            try {
                                rectF.setEmpty();
                                rectF.right = measuredWidth;
                                rectF.bottom = height;
                                float c4 = c(rectF);
                                if (c4 != this.i.getTextSize()) {
                                    f(0, c4);
                                }
                            } finally {
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f5699b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence charSequence;
        CharSequence transformation;
        int length = this.f5703f.length;
        if (length != 0) {
            int i = length - 1;
            int i3 = 0;
            int i4 = 1;
            while (i4 <= i) {
                int i5 = (i4 + i) / 2;
                int i6 = this.f5703f[i5];
                TextView textView = this.i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    charSequence = transformation;
                } else {
                    charSequence = text;
                }
                int b4 = AbstractC0539d0.b(textView);
                TextPaint textPaint = this.f5705h;
                if (textPaint == null) {
                    this.f5705h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f5705h.set(textView.getPaint());
                this.f5705h.setTextSize(i6);
                Object obj = Layout.Alignment.ALIGN_NORMAL;
                try {
                    obj = d("getLayoutAlignment").invoke(textView, null);
                } catch (Exception unused) {
                }
                StaticLayout a2 = AbstractC0543f0.a(charSequence, (Layout.Alignment) obj, Math.round(rectF.right), b4, this.i, this.f5705h, this.f5707k);
                if ((b4 != -1 && (a2.getLineCount() > b4 || a2.getLineEnd(a2.getLineCount() - 1) != charSequence.length())) || a2.getHeight() > rectF.bottom) {
                    i3 = i5 - 1;
                    i = i3;
                } else {
                    int i7 = i5 + 1;
                    i3 = i4;
                    i4 = i7;
                }
            }
            return this.f5703f[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final boolean e() {
        if (i() && this.f5698a != 0) {
            return true;
        }
        return false;
    }

    public final void f(int i, float f4) {
        Resources resources;
        Context context = this.f5706j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f4, resources.getDisplayMetrics());
        TextView textView = this.i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a2 = AbstractC0541e0.a(textView);
            if (textView.getLayout() != null) {
                this.f5699b = false;
                try {
                    Method d2 = d("nullLayouts");
                    if (d2 != null) {
                        d2.invoke(textView, null);
                    }
                } catch (Exception unused) {
                }
                if (!a2) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (i() && this.f5698a == 1) {
            if (!this.f5704g || this.f5703f.length == 0) {
                int floor = ((int) Math.floor((this.f5702e - this.f5701d) / this.f5700c)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((i * this.f5700c) + this.f5701d);
                }
                this.f5703f = b(iArr);
            }
            this.f5699b = true;
        } else {
            this.f5699b = false;
        }
        return this.f5699b;
    }

    public final boolean h() {
        boolean z3;
        if (this.f5703f.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f5704g = z3;
        if (z3) {
            this.f5698a = 1;
            this.f5701d = r0[0];
            this.f5702e = r0[r1 - 1];
            this.f5700c = -1.0f;
        }
        return z3;
    }

    public final boolean i() {
        return !(this.i instanceof C0571u);
    }

    public final void j(float f4, float f5, float f6) {
        if (f4 > 0.0f) {
            if (f5 > f4) {
                if (f6 > 0.0f) {
                    this.f5698a = 1;
                    this.f5701d = f4;
                    this.f5702e = f5;
                    this.f5700c = f6;
                    this.f5704g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
    }
}
