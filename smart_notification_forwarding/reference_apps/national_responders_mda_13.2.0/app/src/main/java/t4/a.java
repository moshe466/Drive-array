package t4;

import java.util.Objects;
import t4.c;
import t4.d;

/* loaded from: classes.dex */
final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private final String f14269a;

    /* renamed from: b, reason: collision with root package name */
    private final c.a f14270b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14271c;

    /* renamed from: d, reason: collision with root package name */
    private final String f14272d;

    /* renamed from: e, reason: collision with root package name */
    private final long f14273e;

    /* renamed from: f, reason: collision with root package name */
    private final long f14274f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14275g;

    /* loaded from: classes.dex */
    static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14276a;

        /* renamed from: b, reason: collision with root package name */
        private c.a f14277b;

        /* renamed from: c, reason: collision with root package name */
        private String f14278c;

        /* renamed from: d, reason: collision with root package name */
        private String f14279d;

        /* renamed from: e, reason: collision with root package name */
        private Long f14280e;

        /* renamed from: f, reason: collision with root package name */
        private Long f14281f;

        /* renamed from: g, reason: collision with root package name */
        private String f14282g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(d dVar) {
            this.f14276a = dVar.d();
            this.f14277b = dVar.g();
            this.f14278c = dVar.b();
            this.f14279d = dVar.f();
            this.f14280e = Long.valueOf(dVar.c());
            this.f14281f = Long.valueOf(dVar.h());
            this.f14282g = dVar.e();
        }

        @Override // t4.d.a
        public d a() {
            String str = "";
            if (this.f14277b == null) {
                str = " registrationStatus";
            }
            if (this.f14280e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f14281f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f14276a, this.f14277b, this.f14278c, this.f14279d, this.f14280e.longValue(), this.f14281f.longValue(), this.f14282g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // t4.d.a
        public d.a b(String str) {
            this.f14278c = str;
            return this;
        }

        @Override // t4.d.a
        public d.a c(long j10) {
            this.f14280e = Long.valueOf(j10);
            return this;
        }

        @Override // t4.d.a
        public d.a d(String str) {
            this.f14276a = str;
            return this;
        }

        @Override // t4.d.a
        public d.a e(String str) {
            this.f14282g = str;
            return this;
        }

        @Override // t4.d.a
        public d.a f(String str) {
            this.f14279d = str;
            return this;
        }

        @Override // t4.d.a
        public d.a g(c.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f14277b = aVar;
            return this;
        }

        @Override // t4.d.a
        public d.a h(long j10) {
            this.f14281f = Long.valueOf(j10);
            return this;
        }
    }

    private a(String str, c.a aVar, String str2, String str3, long j10, long j11, String str4) {
        this.f14269a = str;
        this.f14270b = aVar;
        this.f14271c = str2;
        this.f14272d = str3;
        this.f14273e = j10;
        this.f14274f = j11;
        this.f14275g = str4;
    }

    @Override // t4.d
    public String b() {
        return this.f14271c;
    }

    @Override // t4.d
    public long c() {
        return this.f14273e;
    }

    @Override // t4.d
    public String d() {
        return this.f14269a;
    }

    @Override // t4.d
    public String e() {
        return this.f14275g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str3 = this.f14269a;
        if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
            if (this.f14270b.equals(dVar.g()) && ((str = this.f14271c) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f14272d) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f14273e == dVar.c() && this.f14274f == dVar.h()) {
                String str4 = this.f14275g;
                String e10 = dVar.e();
                if (str4 == null) {
                    if (e10 == null) {
                        return true;
                    }
                } else if (str4.equals(e10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // t4.d
    public String f() {
        return this.f14272d;
    }

    @Override // t4.d
    public c.a g() {
        return this.f14270b;
    }

    @Override // t4.d
    public long h() {
        return this.f14274f;
    }

    public int hashCode() {
        String str = this.f14269a;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f14270b.hashCode()) * 1000003;
        String str2 = this.f14271c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14272d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f14273e;
        int i10 = (hashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f14274f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f14275g;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // t4.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f14269a + ", registrationStatus=" + this.f14270b + ", authToken=" + this.f14271c + ", refreshToken=" + this.f14272d + ", expiresInSecs=" + this.f14273e + ", tokenCreationEpochInSecs=" + this.f14274f + ", fisError=" + this.f14275g + "}";
    }
}
