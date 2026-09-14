package A;

import android.graphics.Color;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f0a = 0;

    static {
        new ThreadLocal();
    }

    public static int a(double d2, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        int min;
        int min2;
        double d9 = (((-0.4986d) * d5) + (((-1.5372d) * d4) + (3.2406d * d2))) / 100.0d;
        double d10 = ((0.0415d * d5) + ((1.8758d * d4) + ((-0.9689d) * d2))) / 100.0d;
        double d11 = ((1.057d * d5) + (((-0.204d) * d4) + (0.0557d * d2))) / 100.0d;
        if (d9 > 0.0031308d) {
            d6 = (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d6 = d9 * 12.92d;
        }
        if (d10 > 0.0031308d) {
            d7 = (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d7 = d10 * 12.92d;
        }
        if (d11 > 0.0031308d) {
            d8 = (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d8 = d11 * 12.92d;
        }
        int round = (int) Math.round(d6 * 255.0d);
        int i = 0;
        if (round < 0) {
            min = 0;
        } else {
            min = Math.min(round, 255);
        }
        int round2 = (int) Math.round(d7 * 255.0d);
        if (round2 < 0) {
            min2 = 0;
        } else {
            min2 = Math.min(round2, 255);
        }
        int round3 = (int) Math.round(d8 * 255.0d);
        if (round3 >= 0) {
            i = Math.min(round3, 255);
        }
        return Color.rgb(min, min2, i);
    }

    public static int b(int i, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i);
        int i4 = 255 - (((255 - alpha2) * (255 - alpha)) / 255);
        return Color.argb(i4, c(Color.red(i), alpha2, Color.red(i3), alpha, i4), c(Color.green(i), alpha2, Color.green(i3), alpha, i4), c(Color.blue(i), alpha2, Color.blue(i3), alpha, i4));
    }

    public static int c(int i, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((255 - i3) * (i4 * i5)) + ((i * 255) * i3)) / (i6 * 255);
    }
}
