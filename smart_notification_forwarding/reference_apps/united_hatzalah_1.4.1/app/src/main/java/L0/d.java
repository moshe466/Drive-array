package L0;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1135a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1136b;

    public d(byte[] bArr) {
        this.f1135a = bArr;
        this.f1136b = Arrays.hashCode(bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f1136b == dVar.f1136b && Arrays.equals(this.f1135a, dVar.f1135a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1136b;
    }
}
