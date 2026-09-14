package u4;

import u4.f;

/* loaded from: classes.dex */
final class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private final String f14366a;

    /* renamed from: b, reason: collision with root package name */
    private final long f14367b;

    /* renamed from: c, reason: collision with root package name */
    private final f.b f14368c;

    /* renamed from: u4.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0296b extends f.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14369a;

        /* renamed from: b, reason: collision with root package name */
        private Long f14370b;

        /* renamed from: c, reason: collision with root package name */
        private f.b f14371c;

        @Override // u4.f.a
        public f a() {
            String str = "";
            if (this.f14370b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f14369a, this.f14370b.longValue(), this.f14371c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u4.f.a
        public f.a b(f.b bVar) {
            this.f14371c = bVar;
            return this;
        }

        @Override // u4.f.a
        public f.a c(String str) {
            this.f14369a = str;
            return this;
        }

        @Override // u4.f.a
        public f.a d(long j10) {
            this.f14370b = Long.valueOf(j10);
            return this;
        }
    }

    private b(String str, long j10, f.b bVar) {
        this.f14366a = str;
        this.f14367b = j10;
        this.f14368c = bVar;
    }

    @Override // u4.f
    public f.b b() {
        return this.f14368c;
    }

    @Override // u4.f
    public String c() {
        return this.f14366a;
    }

    @Override // u4.f
    public long d() {
        return this.f14367b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f14366a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f14367b == fVar.d()) {
                f.b bVar = this.f14368c;
                f.b b10 = fVar.b();
                if (bVar == null) {
                    if (b10 == null) {
                        return true;
                    }
                } else if (bVar.equals(b10)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f14366a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f14367b;
        int i10 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        f.b bVar = this.f14368c;
        return i10 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f14366a + ", tokenExpirationTimestamp=" + this.f14367b + ", responseCode=" + this.f14368c + "}";
    }
}
