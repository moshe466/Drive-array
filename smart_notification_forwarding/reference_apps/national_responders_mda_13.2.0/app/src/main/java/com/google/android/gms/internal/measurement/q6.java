package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public abstract class q6 {
    private q6() {
    }

    public static long a(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q6 b(byte[] bArr, int i10, int i11, boolean z10) {
        s6 s6Var = new s6(bArr, i11);
        try {
            s6Var.c(i11);
            return s6Var;
        } catch (x7 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int d(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public abstract int c(int i10);

    public abstract int e();
}
