package s1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class q extends AbstractC0652C {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f6307a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6308b;

    public q(byte[] bArr, byte[] bArr2) {
        this.f6307a = bArr;
        this.f6308b = bArr2;
    }

    public final boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0652C) {
            AbstractC0652C abstractC0652C = (AbstractC0652C) obj;
            boolean z3 = abstractC0652C instanceof q;
            if (z3) {
                bArr = ((q) abstractC0652C).f6307a;
            } else {
                bArr = ((q) abstractC0652C).f6307a;
            }
            if (Arrays.equals(this.f6307a, bArr)) {
                if (z3) {
                    bArr2 = ((q) abstractC0652C).f6308b;
                } else {
                    bArr2 = ((q) abstractC0652C).f6308b;
                }
                if (Arrays.equals(this.f6308b, bArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f6307a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6308b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f6307a) + ", encryptedBlob=" + Arrays.toString(this.f6308b) + "}";
    }
}
