package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzdrq {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[zzdsg.values().length];

    static {
        try {
            b[zzdsg.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzdsg.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzdsg.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = new int[zzdrp.values().length];
        try {
            a[zzdrp.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[zzdrp.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[zzdrp.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
