package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class g extends v.d.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f14977a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14978b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14979c;

    /* renamed from: d, reason: collision with root package name */
    private final v.d.a.b f14980d;

    /* renamed from: e, reason: collision with root package name */
    private final String f14981e;

    /* renamed from: f, reason: collision with root package name */
    private final String f14982f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14983g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.a.AbstractC0311a {

        /* renamed from: a, reason: collision with root package name */
        private String f14984a;

        /* renamed from: b, reason: collision with root package name */
        private String f14985b;

        /* renamed from: c, reason: collision with root package name */
        private String f14986c;

        /* renamed from: d, reason: collision with root package name */
        private v.d.a.b f14987d;

        /* renamed from: e, reason: collision with root package name */
        private String f14988e;

        /* renamed from: f, reason: collision with root package name */
        private String f14989f;

        /* renamed from: g, reason: collision with root package name */
        private String f14990g;

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a a() {
            String str = "";
            if (this.f14984a == null) {
                str = " identifier";
            }
            if (this.f14985b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new g(this.f14984a, this.f14985b, this.f14986c, this.f14987d, this.f14988e, this.f14989f, this.f14990g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a b(String str) {
            this.f14989f = str;
            return this;
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a c(String str) {
            this.f14990g = str;
            return this;
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a d(String str) {
            this.f14986c = str;
            return this;
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a e(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f14984a = str;
            return this;
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a f(String str) {
            this.f14988e = str;
            return this;
        }

        @Override // w3.v.d.a.AbstractC0311a
        public v.d.a.AbstractC0311a g(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f14985b = str;
            return this;
        }
    }

    private g(String str, String str2, String str3, v.d.a.b bVar, String str4, String str5, String str6) {
        this.f14977a = str;
        this.f14978b = str2;
        this.f14979c = str3;
        this.f14980d = bVar;
        this.f14981e = str4;
        this.f14982f = str5;
        this.f14983g = str6;
    }

    @Override // w3.v.d.a
    public String b() {
        return this.f14982f;
    }

    @Override // w3.v.d.a
    public String c() {
        return this.f14983g;
    }

    @Override // w3.v.d.a
    public String d() {
        return this.f14979c;
    }

    @Override // w3.v.d.a
    public String e() {
        return this.f14977a;
    }

    public boolean equals(Object obj) {
        String str;
        v.d.a.b bVar;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.a)) {
            return false;
        }
        v.d.a aVar = (v.d.a) obj;
        if (this.f14977a.equals(aVar.e()) && this.f14978b.equals(aVar.h()) && ((str = this.f14979c) != null ? str.equals(aVar.d()) : aVar.d() == null) && ((bVar = this.f14980d) != null ? bVar.equals(aVar.g()) : aVar.g() == null) && ((str2 = this.f14981e) != null ? str2.equals(aVar.f()) : aVar.f() == null) && ((str3 = this.f14982f) != null ? str3.equals(aVar.b()) : aVar.b() == null)) {
            String str4 = this.f14983g;
            String c10 = aVar.c();
            if (str4 == null) {
                if (c10 == null) {
                    return true;
                }
            } else if (str4.equals(c10)) {
                return true;
            }
        }
        return false;
    }

    @Override // w3.v.d.a
    public String f() {
        return this.f14981e;
    }

    @Override // w3.v.d.a
    public v.d.a.b g() {
        return this.f14980d;
    }

    @Override // w3.v.d.a
    public String h() {
        return this.f14978b;
    }

    public int hashCode() {
        int hashCode = (((this.f14977a.hashCode() ^ 1000003) * 1000003) ^ this.f14978b.hashCode()) * 1000003;
        String str = this.f14979c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        v.d.a.b bVar = this.f14980d;
        int hashCode3 = (hashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f14981e;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f14982f;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f14983g;
        return hashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f14977a + ", version=" + this.f14978b + ", displayVersion=" + this.f14979c + ", organization=" + this.f14980d + ", installationUuid=" + this.f14981e + ", developmentPlatform=" + this.f14982f + ", developmentPlatformVersion=" + this.f14983g + "}";
    }
}
