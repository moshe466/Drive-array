package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class f extends v.d {

    /* renamed from: a, reason: collision with root package name */
    private final String f14955a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14956b;

    /* renamed from: c, reason: collision with root package name */
    private final long f14957c;

    /* renamed from: d, reason: collision with root package name */
    private final Long f14958d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f14959e;

    /* renamed from: f, reason: collision with root package name */
    private final v.d.a f14960f;

    /* renamed from: g, reason: collision with root package name */
    private final v.d.f f14961g;

    /* renamed from: h, reason: collision with root package name */
    private final v.d.e f14962h;

    /* renamed from: i, reason: collision with root package name */
    private final v.d.c f14963i;

    /* renamed from: j, reason: collision with root package name */
    private final w<v.d.AbstractC0312d> f14964j;

    /* renamed from: k, reason: collision with root package name */
    private final int f14965k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.b {

        /* renamed from: a, reason: collision with root package name */
        private String f14966a;

        /* renamed from: b, reason: collision with root package name */
        private String f14967b;

        /* renamed from: c, reason: collision with root package name */
        private Long f14968c;

        /* renamed from: d, reason: collision with root package name */
        private Long f14969d;

        /* renamed from: e, reason: collision with root package name */
        private Boolean f14970e;

        /* renamed from: f, reason: collision with root package name */
        private v.d.a f14971f;

        /* renamed from: g, reason: collision with root package name */
        private v.d.f f14972g;

        /* renamed from: h, reason: collision with root package name */
        private v.d.e f14973h;

        /* renamed from: i, reason: collision with root package name */
        private v.d.c f14974i;

        /* renamed from: j, reason: collision with root package name */
        private w<v.d.AbstractC0312d> f14975j;

        /* renamed from: k, reason: collision with root package name */
        private Integer f14976k;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d dVar) {
            this.f14966a = dVar.f();
            this.f14967b = dVar.h();
            this.f14968c = Long.valueOf(dVar.k());
            this.f14969d = dVar.d();
            this.f14970e = Boolean.valueOf(dVar.m());
            this.f14971f = dVar.b();
            this.f14972g = dVar.l();
            this.f14973h = dVar.j();
            this.f14974i = dVar.c();
            this.f14975j = dVar.e();
            this.f14976k = Integer.valueOf(dVar.g());
        }

        @Override // w3.v.d.b
        public v.d a() {
            String str = "";
            if (this.f14966a == null) {
                str = " generator";
            }
            if (this.f14967b == null) {
                str = str + " identifier";
            }
            if (this.f14968c == null) {
                str = str + " startedAt";
            }
            if (this.f14970e == null) {
                str = str + " crashed";
            }
            if (this.f14971f == null) {
                str = str + " app";
            }
            if (this.f14976k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new f(this.f14966a, this.f14967b, this.f14968c.longValue(), this.f14969d, this.f14970e.booleanValue(), this.f14971f, this.f14972g, this.f14973h, this.f14974i, this.f14975j, this.f14976k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.b
        public v.d.b b(v.d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f14971f = aVar;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b c(boolean z10) {
            this.f14970e = Boolean.valueOf(z10);
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b d(v.d.c cVar) {
            this.f14974i = cVar;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b e(Long l10) {
            this.f14969d = l10;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b f(w<v.d.AbstractC0312d> wVar) {
            this.f14975j = wVar;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b g(String str) {
            Objects.requireNonNull(str, "Null generator");
            this.f14966a = str;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b h(int i10) {
            this.f14976k = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b i(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f14967b = str;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b k(v.d.e eVar) {
            this.f14973h = eVar;
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b l(long j10) {
            this.f14968c = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.b
        public v.d.b m(v.d.f fVar) {
            this.f14972g = fVar;
            return this;
        }
    }

    private f(String str, String str2, long j10, Long l10, boolean z10, v.d.a aVar, v.d.f fVar, v.d.e eVar, v.d.c cVar, w<v.d.AbstractC0312d> wVar, int i10) {
        this.f14955a = str;
        this.f14956b = str2;
        this.f14957c = j10;
        this.f14958d = l10;
        this.f14959e = z10;
        this.f14960f = aVar;
        this.f14961g = fVar;
        this.f14962h = eVar;
        this.f14963i = cVar;
        this.f14964j = wVar;
        this.f14965k = i10;
    }

    @Override // w3.v.d
    public v.d.a b() {
        return this.f14960f;
    }

    @Override // w3.v.d
    public v.d.c c() {
        return this.f14963i;
    }

    @Override // w3.v.d
    public Long d() {
        return this.f14958d;
    }

    @Override // w3.v.d
    public w<v.d.AbstractC0312d> e() {
        return this.f14964j;
    }

    public boolean equals(Object obj) {
        Long l10;
        v.d.f fVar;
        v.d.e eVar;
        v.d.c cVar;
        w<v.d.AbstractC0312d> wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d)) {
            return false;
        }
        v.d dVar = (v.d) obj;
        return this.f14955a.equals(dVar.f()) && this.f14956b.equals(dVar.h()) && this.f14957c == dVar.k() && ((l10 = this.f14958d) != null ? l10.equals(dVar.d()) : dVar.d() == null) && this.f14959e == dVar.m() && this.f14960f.equals(dVar.b()) && ((fVar = this.f14961g) != null ? fVar.equals(dVar.l()) : dVar.l() == null) && ((eVar = this.f14962h) != null ? eVar.equals(dVar.j()) : dVar.j() == null) && ((cVar = this.f14963i) != null ? cVar.equals(dVar.c()) : dVar.c() == null) && ((wVar = this.f14964j) != null ? wVar.equals(dVar.e()) : dVar.e() == null) && this.f14965k == dVar.g();
    }

    @Override // w3.v.d
    public String f() {
        return this.f14955a;
    }

    @Override // w3.v.d
    public int g() {
        return this.f14965k;
    }

    @Override // w3.v.d
    public String h() {
        return this.f14956b;
    }

    public int hashCode() {
        int hashCode = (((this.f14955a.hashCode() ^ 1000003) * 1000003) ^ this.f14956b.hashCode()) * 1000003;
        long j10 = this.f14957c;
        int i10 = (hashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.f14958d;
        int hashCode2 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f14959e ? 1231 : 1237)) * 1000003) ^ this.f14960f.hashCode()) * 1000003;
        v.d.f fVar = this.f14961g;
        int hashCode3 = (hashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        v.d.e eVar = this.f14962h;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        v.d.c cVar = this.f14963i;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        w<v.d.AbstractC0312d> wVar = this.f14964j;
        return ((hashCode5 ^ (wVar != null ? wVar.hashCode() : 0)) * 1000003) ^ this.f14965k;
    }

    @Override // w3.v.d
    public v.d.e j() {
        return this.f14962h;
    }

    @Override // w3.v.d
    public long k() {
        return this.f14957c;
    }

    @Override // w3.v.d
    public v.d.f l() {
        return this.f14961g;
    }

    @Override // w3.v.d
    public boolean m() {
        return this.f14959e;
    }

    @Override // w3.v.d
    public v.d.b n() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f14955a + ", identifier=" + this.f14956b + ", startedAt=" + this.f14957c + ", endedAt=" + this.f14958d + ", crashed=" + this.f14959e + ", app=" + this.f14960f + ", user=" + this.f14961g + ", os=" + this.f14962h + ", device=" + this.f14963i + ", events=" + this.f14964j + ", generatorType=" + this.f14965k + "}";
    }
}
