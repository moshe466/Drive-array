package okhttp3.internal.http2;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Settings {
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return this.values[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.values;
            if (i < iArr.length) {
                this.set = (1 << i) | this.set;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Settings settings) {
        for (int i = 0; i < 10; i++) {
            if (settings.d(i)) {
                a(i, settings.a(i));
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
        return (this.set & 16) != 0 ? this.values[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return Integer.bitCount(this.set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i) {
        return ((1 << i) & this.set) != 0;
    }
}
