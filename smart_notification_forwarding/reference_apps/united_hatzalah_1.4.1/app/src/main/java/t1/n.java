package t1;

import java.util.Arrays;
import q1.C0622c;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final C0622c f6441a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f6442b;

    public n(C0622c c0622c, byte[] bArr) {
        if (c0622c != null) {
            if (bArr != null) {
                this.f6441a = c0622c;
                this.f6442b = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f6441a.equals(nVar.f6441a)) {
            return false;
        }
        return Arrays.equals(this.f6442b, nVar.f6442b);
    }

    public final int hashCode() {
        return ((this.f6441a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6442b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f6441a + ", bytes=[...]}";
    }
}
