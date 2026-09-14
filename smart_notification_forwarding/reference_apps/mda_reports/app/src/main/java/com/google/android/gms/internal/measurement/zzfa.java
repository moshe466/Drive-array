package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final /* synthetic */ class zzfa {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[zzfq.values().length];

    static {
        try {
            b[zzfq.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzfq.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzfq.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = new int[zzez.values().length];
        try {
            a[zzez.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[zzez.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[zzez.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
