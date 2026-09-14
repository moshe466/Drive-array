package i3;

import g.c;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: g, reason: collision with root package name */
    static final double f10727g = Math.cos(Math.toRadians(45.0d));

    public static float c(float f10, float f11, boolean z10) {
        return z10 ? (float) (f10 + ((1.0d - f10727g) * f11)) : f10;
    }

    public static float d(float f10, float f11, boolean z10) {
        float f12 = f10 * 1.5f;
        return z10 ? (float) (f12 + ((1.0d - f10727g) * f11)) : f12;
    }
}
