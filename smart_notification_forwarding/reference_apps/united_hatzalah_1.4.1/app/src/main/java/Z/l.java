package z;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: k, reason: collision with root package name */
    public static final l f6798k;

    /* renamed from: a, reason: collision with root package name */
    public final float f6799a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6800b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6801c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6802d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6803e;

    /* renamed from: f, reason: collision with root package name */
    public final float f6804f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f6805g;

    /* renamed from: h, reason: collision with root package name */
    public final float f6806h;
    public final float i;

    /* renamed from: j, reason: collision with root package name */
    public final float f6807j;

    static {
        float f4;
        float[] fArr = b.f6773c;
        float g3 = (float) ((b.g() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f6771a;
        float f5 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f6 = fArr3[0] * f5;
        float f7 = fArr[1];
        float f8 = (fArr3[1] * f7) + f6;
        float f9 = fArr[2];
        float f10 = (fArr3[2] * f9) + f8;
        float[] fArr4 = fArr2[1];
        float f11 = (fArr4[2] * f9) + (fArr4[1] * f7) + (fArr4[0] * f5);
        float[] fArr5 = fArr2[2];
        float f12 = (f9 * fArr5[2]) + (f7 * fArr5[1]) + (f5 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f4 = 0.69f;
        } else {
            f4 = 0.655f;
        }
        float f13 = f4;
        float exp = (1.0f - (((float) Math.exp(((-g3) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d2 = exp;
        if (d2 > 1.0d) {
            exp = 1.0f;
        } else if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            exp = 0.0f;
        }
        float f14 = 1.0f / ((5.0f * g3) + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = 1.0f - f15;
        float cbrt = (0.1f * f16 * f16 * ((float) Math.cbrt(g3 * 5.0d))) + (f15 * g3);
        float g4 = b.g() / fArr[1];
        double d4 = g4;
        float sqrt = ((float) Math.sqrt(d4)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d4, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r2[0] * cbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((r2[1] * cbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((r2[2] * cbrt) * f12) / 100.0d, 0.42d)};
        float f17 = fArr6[0];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr6[1];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr6[2];
        float[] fArr7 = {f18, f20, (400.0f * f21) / (f21 + 27.13f)};
        f6798k = new l(g4, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * pow, pow, pow, f13, 1.0f, new float[]{(((100.0f / f10) * exp) + 1.0f) - exp, (((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp}, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public l(float f4, float f5, float f6, float f7, float f8, float f9, float[] fArr, float f10, float f11, float f12) {
        this.f6804f = f4;
        this.f6799a = f5;
        this.f6800b = f6;
        this.f6801c = f7;
        this.f6802d = f8;
        this.f6803e = f9;
        this.f6805g = fArr;
        this.f6806h = f10;
        this.i = f11;
        this.f6807j = f12;
    }
}
