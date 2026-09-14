package com.google.android.play.core.integrity;

/* loaded from: classes.dex */
final class ao extends IntegrityTokenRequest {

    /* renamed from: a, reason: collision with root package name */
    private final String f3928a;

    /* renamed from: b, reason: collision with root package name */
    private final Long f3929b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f3930c = null;

    public /* synthetic */ ao(String str, Long l3, Object obj, an anVar) {
        this.f3928a = str;
        this.f3929b = l3;
    }

    private static boolean a() {
        return true;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final Long cloudProjectNumber() {
        return this.f3929b;
    }

    public final boolean equals(Object obj) {
        boolean z3;
        Long l3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.f3928a.equals(integrityTokenRequest.nonce()) && ((l3 = this.f3929b) != null ? l3.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() == null)) {
                z3 = true;
                if (!(obj instanceof ao) && a()) {
                    ao aoVar = (ao) obj;
                    if (!z3) {
                        return false;
                    }
                    Object obj2 = aoVar.f3930c;
                    return true;
                }
                return z3;
            }
        }
        z3 = false;
        if (!(obj instanceof ao)) {
        }
        return z3;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f3928a.hashCode() ^ 1000003;
        Long l3 = this.f3929b;
        if (l3 == null) {
            hashCode = 0;
        } else {
            hashCode = l3.hashCode();
        }
        int i = (hashCode2 * 1000003) ^ hashCode;
        if (a()) {
            return i * 1000003;
        }
        return i;
    }

    @Override // com.google.android.play.core.integrity.IntegrityTokenRequest
    public final String nonce() {
        return this.f3928a;
    }

    public final String toString() {
        String str = "IntegrityTokenRequest{nonce=" + this.f3928a + ", cloudProjectNumber=" + this.f3929b;
        if (a()) {
            str = str.concat(", network=null");
        }
        return str.concat("}");
    }
}
