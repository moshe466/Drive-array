package u1;

import T.k;

/* renamed from: u1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0735a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6585a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6586b;

    public C0735a(int i, long j2) {
        if (i != 0) {
            this.f6585a = i;
            this.f6586b = j2;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C0735a) {
                C0735a c0735a = (C0735a) obj;
                if (k.a(this.f6585a, c0735a.f6585a) && this.f6586b == c0735a.f6586b) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int b4 = (k.b(this.f6585a) ^ 1000003) * 1000003;
        long j2 = this.f6586b;
        return b4 ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.f6585a;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "null";
                    } else {
                        str = "INVALID_PAYLOAD";
                    }
                } else {
                    str = "FATAL_ERROR";
                }
            } else {
                str = "TRANSIENT_ERROR";
            }
        } else {
            str = "OK";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        return e0.a.g(sb, this.f6586b, "}");
    }
}
