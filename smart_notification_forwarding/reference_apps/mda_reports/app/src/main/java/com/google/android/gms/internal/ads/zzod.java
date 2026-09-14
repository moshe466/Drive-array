package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzod {
    private int size;
    private long[] zzbgd;

    public zzod() {
        this(32);
    }

    private zzod(int i) {
        this.zzbgd = new long[32];
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbgd;
        if (i == jArr.length) {
            this.zzbgd = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbgd;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbgd[i];
        }
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }
}
