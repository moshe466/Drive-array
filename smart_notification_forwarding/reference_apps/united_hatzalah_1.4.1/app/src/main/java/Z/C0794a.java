package z;

import android.graphics.Color;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: z.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0794a {

    /* renamed from: a, reason: collision with root package name */
    public final float f6765a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6766b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6767c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6768d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6769e;

    /* renamed from: f, reason: collision with root package name */
    public final float f6770f;

    public C0794a(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f6765a = f4;
        this.f6766b = f5;
        this.f6767c = f6;
        this.f6768d = f7;
        this.f6769e = f8;
        this.f6770f = f9;
    }

    public static C0794a a(int i) {
        float f4;
        l lVar = l.f6798k;
        float c4 = b.c(Color.red(i));
        float c5 = b.c(Color.green(i));
        float c6 = b.c(Color.blue(i));
        float[][] fArr = b.f6774d;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[2] * c6) + (fArr2[1] * c5) + (fArr2[0] * c4);
        float[] fArr3 = fArr[1];
        float f6 = (fArr3[2] * c6) + (fArr3[1] * c5) + (fArr3[0] * c4);
        float[] fArr4 = fArr[2];
        float f7 = (c6 * fArr4[2]) + (c5 * fArr4[1]) + (c4 * fArr4[0]);
        float[][] fArr5 = b.f6771a;
        float[] fArr6 = fArr5[0];
        float f8 = (fArr6[2] * f7) + (fArr6[1] * f6) + (fArr6[0] * f5);
        float[] fArr7 = fArr5[1];
        float f9 = (fArr7[2] * f7) + (fArr7[1] * f6) + (fArr7[0] * f5);
        float[] fArr8 = fArr5[2];
        float f10 = (f7 * fArr8[2]) + (f6 * fArr8[1]) + (f5 * fArr8[0]);
        float[] fArr9 = lVar.f6805g;
        float f11 = lVar.i;
        float f12 = lVar.f6802d;
        float f13 = lVar.f6799a;
        float f14 = fArr9[0] * f8;
        float f15 = fArr9[1] * f9;
        float f16 = fArr9[2] * f10;
        float f17 = lVar.f6806h;
        float pow = (float) Math.pow((Math.abs(f14) * f17) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f15) * f17) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f16) * f17) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d2 = signum3;
        float f18 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d2)) / 11.0f;
        float f19 = ((float) ((signum + signum2) - (d2 * 2.0d))) / 9.0f;
        float f20 = signum2 * 20.0f;
        float f21 = ((21.0f * signum3) + ((signum * 20.0f) + f20)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f19, f18)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f22 * lVar.f6800b) / f13, lVar.f6807j * f12)) * 100.0f;
        Math.sqrt(pow4 / 100.0f);
        float f24 = f13 + 4.0f;
        if (atan2 < 20.14d) {
            f4 = 360.0f + atan2;
        } else {
            f4 = atan2;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, lVar.f6804f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((f4 * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * lVar.f6803e) * lVar.f6801c) * ((float) Math.sqrt((f19 * f19) + (f18 * f18)))) / (f21 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow4 / 100.0d));
        Math.sqrt((r0 * f12) / f24);
        float f25 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((f11 * pow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d4 = f23;
        return new C0794a(atan2, pow5, pow4, f25, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    public static C0794a b(float f4, float f5, float f6) {
        l lVar = l.f6798k;
        float f7 = lVar.f6802d;
        Math.sqrt(f4 / 100.0d);
        float f8 = lVar.f6799a + 4.0f;
        float f9 = lVar.i * f5;
        Math.sqrt(((f5 / ((float) Math.sqrt(r1))) * lVar.f6802d) / f8);
        float f10 = (1.7f * f4) / ((0.007f * f4) + 1.0f);
        float log = ((float) Math.log((f9 * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f6) / 180.0f;
        return new C0794a(f6, f5, f4, f10, log * ((float) Math.cos(d2)), log * ((float) Math.sin(d2)));
    }

    public final int c(l lVar) {
        float f4;
        float f5 = this.f6766b;
        double d2 = f5;
        float f6 = this.f6767c;
        if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d4 = f6;
            if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                f4 = f5 / ((float) Math.sqrt(d4 / 100.0d));
                float f7 = lVar.f6804f;
                float f8 = lVar.f6806h;
                float pow = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, f7), 0.73d), 1.1111111111111112d);
                double d5 = (this.f6765a * 3.1415927f) / 180.0f;
                float cos = ((float) (Math.cos(2.0d + d5) + 3.8d)) * 0.25f;
                float pow2 = lVar.f6799a * ((float) Math.pow(f6 / 100.0d, (1.0d / lVar.f6802d) / lVar.f6807j));
                float f9 = cos * 3846.1538f * lVar.f6803e * lVar.f6801c;
                float f10 = pow2 / lVar.f6800b;
                float sin = (float) Math.sin(d5);
                float cos2 = (float) Math.cos(d5);
                float f11 = (((0.305f + f10) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (f9 * 23.0f)));
                float f12 = cos2 * f11;
                float f13 = f11 * sin;
                float f14 = f10 * 460.0f;
                float f15 = ((288.0f * f13) + ((451.0f * f12) + f14)) / 1403.0f;
                float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
                float f17 = ((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f;
                float f18 = 100.0f / f8;
                float signum = Math.signum(f15) * f18 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
                float signum2 = Math.signum(f16) * f18 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f16) * 27.13d) / (400.0d - Math.abs(f16))), 2.380952380952381d));
                float signum3 = Math.signum(f17) * f18 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f17) * 27.13d) / (400.0d - Math.abs(f17))), 2.380952380952381d));
                float[] fArr = lVar.f6805g;
                float f19 = signum / fArr[0];
                float f20 = signum2 / fArr[1];
                float f21 = signum3 / fArr[2];
                float[][] fArr2 = b.f6772b;
                float[] fArr3 = fArr2[0];
                float f22 = (fArr3[2] * f21) + (fArr3[1] * f20) + (fArr3[0] * f19);
                float[] fArr4 = fArr2[1];
                float f23 = (fArr4[2] * f21) + (fArr4[1] * f20) + (fArr4[0] * f19);
                float[] fArr5 = fArr2[2];
                return A.a.a(f22, f23, (f21 * fArr5[2]) + (f20 * fArr5[1]) + (f19 * fArr5[0]));
            }
        }
        f4 = 0.0f;
        float f72 = lVar.f6804f;
        float f82 = lVar.f6806h;
        float pow3 = (float) Math.pow(f4 / Math.pow(1.64d - Math.pow(0.29d, f72), 0.73d), 1.1111111111111112d);
        double d52 = (this.f6765a * 3.1415927f) / 180.0f;
        float cos3 = ((float) (Math.cos(2.0d + d52) + 3.8d)) * 0.25f;
        float pow22 = lVar.f6799a * ((float) Math.pow(f6 / 100.0d, (1.0d / lVar.f6802d) / lVar.f6807j));
        float f92 = cos3 * 3846.1538f * lVar.f6803e * lVar.f6801c;
        float f102 = pow22 / lVar.f6800b;
        float sin2 = (float) Math.sin(d52);
        float cos22 = (float) Math.cos(d52);
        float f112 = (((0.305f + f102) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (((11.0f * pow3) * cos22) + (f92 * 23.0f)));
        float f122 = cos22 * f112;
        float f132 = f112 * sin2;
        float f142 = f102 * 460.0f;
        float f152 = ((288.0f * f132) + ((451.0f * f122) + f142)) / 1403.0f;
        float f162 = ((f142 - (891.0f * f122)) - (261.0f * f132)) / 1403.0f;
        float f172 = ((f142 - (f122 * 220.0f)) - (f132 * 6300.0f)) / 1403.0f;
        float f182 = 100.0f / f82;
        float signum4 = Math.signum(f152) * f182 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f152) * 27.13d) / (400.0d - Math.abs(f152))), 2.380952380952381d));
        float signum22 = Math.signum(f162) * f182 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f162) * 27.13d) / (400.0d - Math.abs(f162))), 2.380952380952381d));
        float signum32 = Math.signum(f172) * f182 * ((float) Math.pow((float) Math.max(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f172) * 27.13d) / (400.0d - Math.abs(f172))), 2.380952380952381d));
        float[] fArr6 = lVar.f6805g;
        float f192 = signum4 / fArr6[0];
        float f202 = signum22 / fArr6[1];
        float f212 = signum32 / fArr6[2];
        float[][] fArr22 = b.f6772b;
        float[] fArr32 = fArr22[0];
        float f222 = (fArr32[2] * f212) + (fArr32[1] * f202) + (fArr32[0] * f192);
        float[] fArr42 = fArr22[1];
        float f232 = (fArr42[2] * f212) + (fArr42[1] * f202) + (fArr42[0] * f192);
        float[] fArr52 = fArr22[2];
        return A.a.a(f222, f232, (f212 * fArr52[2]) + (f202 * fArr52[1]) + (f192 * fArr52[0]));
    }
}
