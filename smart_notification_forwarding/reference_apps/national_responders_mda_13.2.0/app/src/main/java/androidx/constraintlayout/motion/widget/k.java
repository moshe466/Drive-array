package androidx.constraintlayout.motion.widget;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Comparable<k> {

    /* renamed from: v, reason: collision with root package name */
    static String[] f1681v = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: f, reason: collision with root package name */
    n.b f1682f;

    /* renamed from: h, reason: collision with root package name */
    float f1684h;

    /* renamed from: i, reason: collision with root package name */
    float f1685i;

    /* renamed from: j, reason: collision with root package name */
    float f1686j;

    /* renamed from: k, reason: collision with root package name */
    float f1687k;

    /* renamed from: l, reason: collision with root package name */
    float f1688l;

    /* renamed from: m, reason: collision with root package name */
    float f1689m;

    /* renamed from: o, reason: collision with root package name */
    int f1691o;

    /* renamed from: p, reason: collision with root package name */
    int f1692p;

    /* renamed from: q, reason: collision with root package name */
    g f1693q;

    /* renamed from: r, reason: collision with root package name */
    LinkedHashMap<String, androidx.constraintlayout.widget.b> f1694r;

    /* renamed from: s, reason: collision with root package name */
    int f1695s;

    /* renamed from: t, reason: collision with root package name */
    double[] f1696t;

    /* renamed from: u, reason: collision with root package name */
    double[] f1697u;

    /* renamed from: g, reason: collision with root package name */
    int f1683g = 0;

    /* renamed from: n, reason: collision with root package name */
    float f1690n = Float.NaN;

    public k() {
        int i10 = d.f1618a;
        this.f1691o = i10;
        this.f1692p = i10;
        this.f1693q = null;
        this.f1694r = new LinkedHashMap<>();
        this.f1695s = 0;
        this.f1696t = new double[18];
        this.f1697u = new double[18];
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(k kVar) {
        return Float.compare(this.f1685i, kVar.f1685i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f1686j;
        float f12 = this.f1687k;
        float f13 = this.f1688l;
        float f14 = this.f1689m;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float f23 = (f18 / 2.0f) + f17;
        g gVar = this.f1693q;
        if (gVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            gVar.b(d10, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            float f27 = fArr4[1];
            double d11 = f11;
            double d12 = f12;
            f10 = f13;
            float sin = (float) ((f24 + (Math.sin(d12) * d11)) - (f13 / 2.0f));
            float cos = (float) ((f25 - (d11 * Math.cos(d12))) - (f14 / 2.0f));
            double d13 = f15;
            double d14 = f17;
            float sin2 = (float) (f26 + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            f23 = (float) ((f27 - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f22 = sin2;
            f11 = sin;
            f12 = cos;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + 0.0f;
        fArr[1] = f12 + (f14 / f21) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = f23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void l(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        boolean z11;
        float f12;
        float f13 = this.f1686j;
        float f14 = this.f1687k;
        float f15 = this.f1688l;
        float f16 = this.f1689m;
        if (iArr.length != 0 && this.f1696t.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f1696t = new double[i10];
            this.f1697u = new double[i10];
        }
        Arrays.fill(this.f1696t, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f1696t[iArr[i11]] = dArr[i11];
            this.f1697u[iArr[i11]] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i12 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr4 = this.f1696t;
            if (i12 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i12]) && (dArr3 == null || dArr3[i12] == 0.0d)) {
                f12 = f17;
            } else {
                double d10 = dArr3 != null ? dArr3[i12] : 0.0d;
                if (!Double.isNaN(this.f1696t[i12])) {
                    d10 = this.f1696t[i12] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f1697u[i12];
                if (i12 == 1) {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                } else if (i12 == 2) {
                    f17 = f12;
                    f19 = f23;
                    f14 = f22;
                } else if (i12 == 3) {
                    f17 = f12;
                    f20 = f23;
                    f15 = f22;
                } else if (i12 == 4) {
                    f17 = f12;
                    f21 = f23;
                    f16 = f22;
                } else if (i12 == 5) {
                    f17 = f22;
                }
                i12++;
            }
            f17 = f12;
            i12++;
        }
        float f24 = f17;
        g gVar = this.f1693q;
        if (gVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            gVar.b(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float sin = (float) ((f25 + (Math.sin(d12) * d11)) - (f15 / 2.0f));
            f11 = f16;
            float cos = (float) ((f26 - (Math.cos(d12) * d11)) - (f16 / 2.0f));
            double d13 = f18;
            double d14 = f19;
            float sin2 = (float) (f27 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float cos2 = (float) ((f28 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                z11 = false;
                dArr2[0] = sin2;
                dArr2[1] = cos2;
            } else {
                z11 = false;
            }
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (f24 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f13 = sin;
            f14 = cos;
        } else {
            f11 = f16;
            z11 = false;
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (0.0f + f24 + Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))));
            }
        }
        if (view instanceof c) {
            ((c) view).a(f13, f14, f15 + f13, f14 + f11);
            return;
        }
        float f29 = f13 + 0.5f;
        int i13 = (int) f29;
        float f30 = f14 + 0.5f;
        int i14 = (int) f30;
        int i15 = (int) (f29 + f15);
        int i16 = (int) (f30 + f11);
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        if (i17 != view.getMeasuredWidth() || i18 != view.getMeasuredHeight()) {
            z11 = true;
        }
        if (z11 || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        view.layout(i13, i14, i15, i16);
    }
}
