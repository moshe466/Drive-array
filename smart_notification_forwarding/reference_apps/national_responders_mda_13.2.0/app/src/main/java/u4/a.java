package u4;

import u4.d;

/* loaded from: classes.dex */
final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final String f14356a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14357b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14358c;

    /* renamed from: d, reason: collision with root package name */
    private final f f14359d;

    /* renamed from: e, reason: collision with root package name */
    private final d.b f14360e;

    /* loaded from: classes.dex */
    static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14361a;

        /* renamed from: b, reason: collision with root package name */
        private String f14362b;

        /* renamed from: c, reason: collision with root package name */
        private String f14363c;

        /* renamed from: d, reason: collision with root package name */
        private f f14364d;

        /* renamed from: e, reason: collision with root package name */
        private d.b f14365e;

        @Override // u4.d.a
        public d a() {
            return new a(this.f14361a, this.f14362b, this.f14363c, this.f14364d, this.f14365e);
        }

        @Override // u4.d.a
        public d.a b(f fVar) {
            this.f14364d = fVar;
            return this;
        }

        @Override // u4.d.a
        public d.a c(String str) {
            this.f14362b = str;
            return this;
        }

        @Override // u4.d.a
        public d.a d(String str) {
            this.f14363c = str;
            return this;
        }

        @Override // u4.d.a
        public d.a e(d.b bVar) {
            this.f14365e = bVar;
            return this;
        }

        @Override // u4.d.a
        public d.a f(String str) {
            this.f14361a = str;
            return this;
        }
    }

    private a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f14356a = str;
        this.f14357b = str2;
        this.f14358c = str3;
        this.f14359d = fVar;
        this.f14360e = bVar;
    }

    @Override // u4.d
    public f b() {
        return this.f14359d;
    }

    @Override // u4.d
    public String c() {
        return this.f14357b;
    }

    @Override // u4.d
    public String d() {
        return this.f14358c;
    }

    @Override // u4.d
    public d.b e() {
        return this.f14360e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f14356a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f14357b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f14358c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f14359d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f14360e;
                        d.b e10 = dVar.e();
                        if (bVar == null) {
                            if (e10 == null) {
                                return true;
                            }
                        } else if (bVar.equals(e10)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // u4.d
    public String f() {
        return this.f14356a;
    }

    public int hashCode() {
        String str = this.f14356a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f14357b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14358c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f14359d;
        int hashCode4 = (hashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f14360e;
        return hashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f14356a + ", fid=" + this.f14357b + ", refreshToken=" + this.f14358c + ", authToken=" + this.f14359d + ", responseCode=" + this.f14360e + "}";
    }
}
