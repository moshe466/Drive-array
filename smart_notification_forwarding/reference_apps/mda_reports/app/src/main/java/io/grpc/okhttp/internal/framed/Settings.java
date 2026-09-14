package io.grpc.okhttp.internal.framed;

/* loaded from: classes2.dex */
public final class Settings {
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return (this.set & 32) != 0 ? this.values[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.set);
    }

    public int get(int i) {
        return this.values[i];
    }

    public boolean isSet(int i) {
        return ((1 << i) & this.set) != 0;
    }

    public Settings set(int i, int i2, int i3) {
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
}
