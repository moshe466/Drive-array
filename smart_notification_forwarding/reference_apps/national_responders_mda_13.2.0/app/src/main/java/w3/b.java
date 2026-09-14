package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class b extends v {

    /* renamed from: b, reason: collision with root package name */
    private final String f14927b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14928c;

    /* renamed from: d, reason: collision with root package name */
    private final int f14929d;

    /* renamed from: e, reason: collision with root package name */
    private final String f14930e;

    /* renamed from: f, reason: collision with root package name */
    private final String f14931f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14932g;

    /* renamed from: h, reason: collision with root package name */
    private final v.d f14933h;

    /* renamed from: i, reason: collision with root package name */
    private final v.c f14934i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0310b extends v.a {

        /* renamed from: a, reason: collision with root package name */
        private String f14935a;

        /* renamed from: b, reason: collision with root package name */
        private String f14936b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f14937c;

        /* renamed from: d, reason: collision with root package name */
        private String f14938d;

        /* renamed from: e, reason: collision with root package name */
        private String f14939e;

        /* renamed from: f, reason: collision with root package name */
        private String f14940f;

        /* renamed from: g, reason: collision with root package name */
        private v.d f14941g;

        /* renamed from: h, reason: collision with root package name */
        private v.c f14942h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0310b() {
        }

        private C0310b(v vVar) {
            this.f14935a = vVar.i();
            this.f14936b = vVar.e();
            this.f14937c = Integer.valueOf(vVar.h());
            this.f14938d = vVar.f();
            this.f14939e = vVar.c();
            this.f14940f = vVar.d();
            this.f14941g = vVar.j();
            this.f14942h = vVar.g();
        }

        @Override // w3.v.a
        public v a() {
            String str = "";
            if (this.f14935a == null) {
                str = " sdkVersion";
            }
            if (this.f14936b == null) {
                str = str + " gmpAppId";
            }
            if (this.f14937c == null) {
                str = str + " platform";
            }
            if (this.f14938d == null) {
                str = str + " installationUuid";
            }
            if (this.f14939e == null) {
                str = str + " buildVersion";
            }
            if (this.f14940f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.f14935a, this.f14936b, this.f14937c.intValue(), this.f14938d, this.f14939e, this.f14940f, this.f14941g, this.f14942h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.a
        public v.a b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f14939e = str;
            return this;
        }

        @Override // w3.v.a
        public v.a c(String str) {
            Objects.requireNonNull(str, "Null displayVersion");
            this.f14940f = str;
            return this;
        }

        @Override // w3.v.a
        public v.a d(String str) {
            Objects.requireNonNull(str, "Null gmpAppId");
            this.f14936b = str;
            return this;
        }

        @Override // w3.v.a
        public v.a e(String str) {
            Objects.requireNonNull(str, "Null installationUuid");
            this.f14938d = str;
            return this;
        }

        @Override // w3.v.a
        public v.a f(v.c cVar) {
            this.f14942h = cVar;
            return this;
        }

        @Override // w3.v.a
        public v.a g(int i10) {
            this.f14937c = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.a
        public v.a h(String str) {
            Objects.requireNonNull(str, "Null sdkVersion");
            this.f14935a = str;
            return this;
        }

        @Override // w3.v.a
        public v.a i(v.d dVar) {
            this.f14941g = dVar;
            return this;
        }
    }

    private b(String str, String str2, int i10, String str3, String str4, String str5, v.d dVar, v.c cVar) {
        this.f14927b = str;
        this.f14928c = str2;
        this.f14929d = i10;
        this.f14930e = str3;
        this.f14931f = str4;
        this.f14932g = str5;
        this.f14933h = dVar;
        this.f14934i = cVar;
    }

    @Override // w3.v
    public String c() {
        return this.f14931f;
    }

    @Override // w3.v
    public String d() {
        return this.f14932g;
    }

    @Override // w3.v
    public String e() {
        return this.f14928c;
    }

    public boolean equals(Object obj) {
        v.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f14927b.equals(vVar.i()) && this.f14928c.equals(vVar.e()) && this.f14929d == vVar.h() && this.f14930e.equals(vVar.f()) && this.f14931f.equals(vVar.c()) && this.f14932g.equals(vVar.d()) && ((dVar = this.f14933h) != null ? dVar.equals(vVar.j()) : vVar.j() == null)) {
            v.c cVar = this.f14934i;
            v.c g10 = vVar.g();
            if (cVar == null) {
                if (g10 == null) {
                    return true;
                }
            } else if (cVar.equals(g10)) {
                return true;
            }
        }
        return false;
    }

    @Override // w3.v
    public String f() {
        return this.f14930e;
    }

    @Override // w3.v
    public v.c g() {
        return this.f14934i;
    }

    @Override // w3.v
    public int h() {
        return this.f14929d;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f14927b.hashCode() ^ 1000003) * 1000003) ^ this.f14928c.hashCode()) * 1000003) ^ this.f14929d) * 1000003) ^ this.f14930e.hashCode()) * 1000003) ^ this.f14931f.hashCode()) * 1000003) ^ this.f14932g.hashCode()) * 1000003;
        v.d dVar = this.f14933h;
        int hashCode2 = (hashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        v.c cVar = this.f14934i;
        return hashCode2 ^ (cVar != null ? cVar.hashCode() : 0);
    }

    @Override // w3.v
    public String i() {
        return this.f14927b;
    }

    @Override // w3.v
    public v.d j() {
        return this.f14933h;
    }

    @Override // w3.v
    protected v.a l() {
        return new C0310b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f14927b + ", gmpAppId=" + this.f14928c + ", platform=" + this.f14929d + ", installationUuid=" + this.f14930e + ", buildVersion=" + this.f14931f + ", displayVersion=" + this.f14932g + ", session=" + this.f14933h + ", ndkPayload=" + this.f14934i + "}";
    }
}
