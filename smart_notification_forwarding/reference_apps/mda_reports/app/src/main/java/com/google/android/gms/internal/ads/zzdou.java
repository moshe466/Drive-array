package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzdou {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b = new int[zzdox.values().length];

    static {
        try {
            b[zzdox.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzdox.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzdox.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = new int[zzdow.values().length];
        try {
            a[zzdow.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[zzdow.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[zzdow.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
