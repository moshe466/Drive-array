package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class j extends v.d.AbstractC0312d {

    /* renamed from: a, reason: collision with root package name */
    private final long f15010a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15011b;

    /* renamed from: c, reason: collision with root package name */
    private final v.d.AbstractC0312d.a f15012c;

    /* renamed from: d, reason: collision with root package name */
    private final v.d.AbstractC0312d.c f15013d;

    /* renamed from: e, reason: collision with root package name */
    private final v.d.AbstractC0312d.AbstractC0323d f15014e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.b {

        /* renamed from: a, reason: collision with root package name */
        private Long f15015a;

        /* renamed from: b, reason: collision with root package name */
        private String f15016b;

        /* renamed from: c, reason: collision with root package name */
        private v.d.AbstractC0312d.a f15017c;

        /* renamed from: d, reason: collision with root package name */
        private v.d.AbstractC0312d.c f15018d;

        /* renamed from: e, reason: collision with root package name */
        private v.d.AbstractC0312d.AbstractC0323d f15019e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d.AbstractC0312d abstractC0312d) {
            this.f15015a = Long.valueOf(abstractC0312d.e());
            this.f15016b = abstractC0312d.f();
            this.f15017c = abstractC0312d.b();
            this.f15018d = abstractC0312d.c();
            this.f15019e = abstractC0312d.d();
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d a() {
            String str = "";
            if (this.f15015a == null) {
                str = " timestamp";
            }
            if (this.f15016b == null) {
                str = str + " type";
            }
            if (this.f15017c == null) {
                str = str + " app";
            }
            if (this.f15018d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new j(this.f15015a.longValue(), this.f15016b, this.f15017c, this.f15018d, this.f15019e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d.b b(v.d.AbstractC0312d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f15017c = aVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d.b c(v.d.AbstractC0312d.c cVar) {
            Objects.requireNonNull(cVar, "Null device");
            this.f15018d = cVar;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d.b d(v.d.AbstractC0312d.AbstractC0323d abstractC0323d) {
            this.f15019e = abstractC0323d;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d.b e(long j10) {
            this.f15015a = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.b
        public v.d.AbstractC0312d.b f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.f15016b = str;
            return this;
        }
    }

    private j(long j10, String str, v.d.AbstractC0312d.a aVar, v.d.AbstractC0312d.c cVar, v.d.AbstractC0312d.AbstractC0323d abstractC0323d) {
        this.f15010a = j10;
        this.f15011b = str;
        this.f15012c = aVar;
        this.f15013d = cVar;
        this.f15014e = abstractC0323d;
    }

    @Override // w3.v.d.AbstractC0312d
    public v.d.AbstractC0312d.a b() {
        return this.f15012c;
    }

    @Override // w3.v.d.AbstractC0312d
    public v.d.AbstractC0312d.c c() {
        return this.f15013d;
    }

    @Override // w3.v.d.AbstractC0312d
    public v.d.AbstractC0312d.AbstractC0323d d() {
        return this.f15014e;
    }

    @Override // w3.v.d.AbstractC0312d
    public long e() {
        return this.f15010a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d)) {
            return false;
        }
        v.d.AbstractC0312d abstractC0312d = (v.d.AbstractC0312d) obj;
        if (this.f15010a == abstractC0312d.e() && this.f15011b.equals(abstractC0312d.f()) && this.f15012c.equals(abstractC0312d.b()) && this.f15013d.equals(abstractC0312d.c())) {
            v.d.AbstractC0312d.AbstractC0323d abstractC0323d = this.f15014e;
            v.d.AbstractC0312d.AbstractC0323d d10 = abstractC0312d.d();
            if (abstractC0323d == null) {
                if (d10 == null) {
                    return true;
                }
            } else if (abstractC0323d.equals(d10)) {
                return true;
            }
        }
        return false;
    }

    @Override // w3.v.d.AbstractC0312d
    public String f() {
        return this.f15011b;
    }

    @Override // w3.v.d.AbstractC0312d
    public v.d.AbstractC0312d.b g() {
        return new b(this);
    }

    public int hashCode() {
        long j10 = this.f15010a;
        int hashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f15011b.hashCode()) * 1000003) ^ this.f15012c.hashCode()) * 1000003) ^ this.f15013d.hashCode()) * 1000003;
        v.d.AbstractC0312d.AbstractC0323d abstractC0323d = this.f15014e;
        return (abstractC0323d == null ? 0 : abstractC0323d.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "Event{timestamp=" + this.f15010a + ", type=" + this.f15011b + ", app=" + this.f15012c + ", device=" + this.f15013d + ", log=" + this.f15014e + "}";
    }
}
