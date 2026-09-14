package k1;

import java.util.Map;
import java.util.Objects;
import k1.h;

/* loaded from: classes.dex */
final class a extends h {

    /* renamed from: a, reason: collision with root package name */
    private final String f11128a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f11129b;

    /* renamed from: c, reason: collision with root package name */
    private final g f11130c;

    /* renamed from: d, reason: collision with root package name */
    private final long f11131d;

    /* renamed from: e, reason: collision with root package name */
    private final long f11132e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, String> f11133f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends h.a {

        /* renamed from: a, reason: collision with root package name */
        private String f11134a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f11135b;

        /* renamed from: c, reason: collision with root package name */
        private g f11136c;

        /* renamed from: d, reason: collision with root package name */
        private Long f11137d;

        /* renamed from: e, reason: collision with root package name */
        private Long f11138e;

        /* renamed from: f, reason: collision with root package name */
        private Map<String, String> f11139f;

        @Override // k1.h.a
        public h d() {
            String str = "";
            if (this.f11134a == null) {
                str = " transportName";
            }
            if (this.f11136c == null) {
                str = str + " encodedPayload";
            }
            if (this.f11137d == null) {
                str = str + " eventMillis";
            }
            if (this.f11138e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f11139f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f11134a, this.f11135b, this.f11136c, this.f11137d.longValue(), this.f11138e.longValue(), this.f11139f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k1.h.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f11139f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // k1.h.a
        public h.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f11139f = map;
            return this;
        }

        @Override // k1.h.a
        public h.a g(Integer num) {
            this.f11135b = num;
            return this;
        }

        @Override // k1.h.a
        public h.a h(g gVar) {
            Objects.requireNonNull(gVar, "Null encodedPayload");
            this.f11136c = gVar;
            return this;
        }

        @Override // k1.h.a
        public h.a i(long j10) {
            this.f11137d = Long.valueOf(j10);
            return this;
        }

        @Override // k1.h.a
        public h.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f11134a = str;
            return this;
        }

        @Override // k1.h.a
        public h.a k(long j10) {
            this.f11138e = Long.valueOf(j10);
            return this;
        }
    }

    private a(String str, Integer num, g gVar, long j10, long j11, Map<String, String> map) {
        this.f11128a = str;
        this.f11129b = num;
        this.f11130c = gVar;
        this.f11131d = j10;
        this.f11132e = j11;
        this.f11133f = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // k1.h
    public Map<String, String> c() {
        return this.f11133f;
    }

    @Override // k1.h
    public Integer d() {
        return this.f11129b;
    }

    @Override // k1.h
    public g e() {
        return this.f11130c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f11128a.equals(hVar.j()) && ((num = this.f11129b) != null ? num.equals(hVar.d()) : hVar.d() == null) && this.f11130c.equals(hVar.e()) && this.f11131d == hVar.f() && this.f11132e == hVar.k() && this.f11133f.equals(hVar.c());
    }

    @Override // k1.h
    public long f() {
        return this.f11131d;
    }

    public int hashCode() {
        int hashCode = (this.f11128a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f11129b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f11130c.hashCode()) * 1000003;
        long j10 = this.f11131d;
        int i10 = (hashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f11132e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f11133f.hashCode();
    }

    @Override // k1.h
    public String j() {
        return this.f11128a;
    }

    @Override // k1.h
    public long k() {
        return this.f11132e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f11128a + ", code=" + this.f11129b + ", encodedPayload=" + this.f11130c + ", eventMillis=" + this.f11131d + ", uptimeMillis=" + this.f11132e + ", autoMetadata=" + this.f11133f + "}";
    }
}
