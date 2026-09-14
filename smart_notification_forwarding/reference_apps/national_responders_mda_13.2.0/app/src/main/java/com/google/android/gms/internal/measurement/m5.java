package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class m5 extends l5 {
    public static int a(int i10, int i11, int i12) {
        if (i11 <= 1073741823) {
            return Math.min(Math.max(i10, i11), 1073741823);
        }
        throw new IllegalArgumentException(p3.b("min (%s) must be less than or equal to max (%s)", Integer.valueOf(i11), 1073741823));
    }
}
