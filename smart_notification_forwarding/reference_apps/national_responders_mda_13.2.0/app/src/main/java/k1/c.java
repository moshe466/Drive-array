package k1;

import java.util.Arrays;
import java.util.Objects;
import k1.m;

/* loaded from: classes.dex */
final class c extends m {

    /* renamed from: a, reason: collision with root package name */
    private final String f11150a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f11151b;

    /* renamed from: c, reason: collision with root package name */
    private final i1.d f11152c;

    /* loaded from: classes.dex */
    static final class b extends m.a {

        /* renamed from: a, reason: collision with root package name */
        private String f11153a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f11154b;

        /* renamed from: c, reason: collision with root package name */
        private i1.d f11155c;

        @Override // k1.m.a
        public m a() {
            String str = "";
            if (this.f11153a == null) {
                str = " backendName";
            }
            if (this.f11155c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.f11153a, this.f11154b, this.f11155c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k1.m.a
        public m.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f11153a = str;
            return this;
        }

        @Override // k1.m.a
        public m.a c(byte[] bArr) {
            this.f11154b = bArr;
            return this;
        }

        @Override // k1.m.a
        public m.a d(i1.d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.f11155c = dVar;
            return this;
        }
    }

    private c(String str, byte[] bArr, i1.d dVar) {
        this.f11150a = str;
        this.f11151b = bArr;
        this.f11152c = dVar;
    }

    @Override // k1.m
    public String b() {
        return this.f11150a;
    }

    @Override // k1.m
    public byte[] c() {
        return this.f11151b;
    }

    @Override // k1.m
    public i1.d d() {
        return this.f11152c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f11150a.equals(mVar.b())) {
            if (Arrays.equals(this.f11151b, mVar instanceof c ? ((c) mVar).f11151b : mVar.c()) && this.f11152c.equals(mVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f11150a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f11151b)) * 1000003) ^ this.f11152c.hashCode();
    }
}
