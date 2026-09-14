package k1;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final i1.b f11169a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f11170b;

    public g(i1.b bVar, byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f11169a = bVar;
        this.f11170b = bArr;
    }

    public byte[] a() {
        return this.f11170b;
    }

    public i1.b b() {
        return this.f11169a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f11169a.equals(gVar.f11169a)) {
            return Arrays.equals(this.f11170b, gVar.f11170b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f11169a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11170b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f11169a + ", bytes=[...]}";
    }
}
