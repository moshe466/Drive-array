package com.squareup.okhttp.internal.framed;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Settings {
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        int i2 = f(i) ? 2 : 0;
        return h(i) ? i2 | 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings a(int i, int i2, int i3) {
        if (i >= this.values.length) {
            return this;
        }
        int i4 = 1 << i;
        this.set |= i4;
        this.persistValue = (i2 & 1) != 0 ? this.persistValue | i4 : this.persistValue & (i4 ^ (-1));
        this.persisted = (i2 & 2) != 0 ? this.persisted | i4 : this.persisted & (i4 ^ (-1));
        this.values[i] = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.g(i)) {
                a(i, settings.a(i), settings.b(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.values[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return Integer.bitCount(this.set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.set & 128) != 0 ? this.values[7] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    boolean f(int i) {
        return ((1 << i) & this.persisted) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i) {
        return ((1 << i) & this.set) != 0;
    }

    boolean h(int i) {
        return ((1 << i) & this.persistValue) != 0;
    }
}
