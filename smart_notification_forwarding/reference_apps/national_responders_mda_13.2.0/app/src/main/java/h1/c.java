package h1;

/* loaded from: classes.dex */
public class c {
    public static int a(float f10) {
        return ((int) (f10 + 16384.999999999996d)) - 16384;
    }

    public static int b(float f10) {
        return ((int) (f10 + 16384.0d)) - 16384;
    }

    public static float c(float f10, float f11, float f12) {
        return f10 <= f11 ? f11 : f10 >= f12 ? f12 : f10;
    }

    public static float d(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    public static float e(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }
}
