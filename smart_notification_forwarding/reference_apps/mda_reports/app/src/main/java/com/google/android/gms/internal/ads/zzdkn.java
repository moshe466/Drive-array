package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final /* synthetic */ class zzdkn {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;
    static final /* synthetic */ int[] c = new int[zzdmd.values().length];

    static {
        try {
            c[zzdmd.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[zzdmd.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            c[zzdmd.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        b = new int[zzdmr.values().length];
        try {
            b[zzdmr.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[zzdmr.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[zzdmr.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        a = new int[zzdmt.values().length];
        try {
            a[zzdmt.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[zzdmt.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[zzdmt.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
