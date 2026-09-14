package R0;

import N0.t;
import W0.e;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e f1974a;

    /* renamed from: b, reason: collision with root package name */
    public final t f1975b;

    /* renamed from: c, reason: collision with root package name */
    public final t f1976c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f1977d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1978e;

    public b(e eVar, t tVar, t tVar2, byte[] bArr, int i) {
        this.f1974a = eVar;
        this.f1975b = tVar;
        this.f1976c = tVar2;
        this.f1977d = bArr;
        this.f1978e = i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (!this.f1974a.equals(bVar.f1974a) || this.f1975b != bVar.f1975b || this.f1976c != bVar.f1976c || !Arrays.equals(this.f1977d, bVar.f1977d) || this.f1978e != bVar.f1978e) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1977d) + (Objects.hash(this.f1974a, this.f1975b, this.f1976c, Integer.valueOf(this.f1978e)) * 31);
    }
}
