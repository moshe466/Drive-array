package w3;

import w3.v;

/* loaded from: classes.dex */
final class r extends v.d.AbstractC0312d.c {

    /* renamed from: a, reason: collision with root package name */
    private final Double f15076a;

    /* renamed from: b, reason: collision with root package name */
    private final int f15077b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f15078c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15079d;

    /* renamed from: e, reason: collision with root package name */
    private final long f15080e;

    /* renamed from: f, reason: collision with root package name */
    private final long f15081f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.c.a {

        /* renamed from: a, reason: collision with root package name */
        private Double f15082a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f15083b;

        /* renamed from: c, reason: collision with root package name */
        private Boolean f15084c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f15085d;

        /* renamed from: e, reason: collision with root package name */
        private Long f15086e;

        /* renamed from: f, reason: collision with root package name */
        private Long f15087f;

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c a() {
            String str = "";
            if (this.f15083b == null) {
                str = " batteryVelocity";
            }
            if (this.f15084c == null) {
                str = str + " proximityOn";
            }
            if (this.f15085d == null) {
                str = str + " orientation";
            }
            if (this.f15086e == null) {
                str = str + " ramUsed";
            }
            if (this.f15087f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new r(this.f15082a, this.f15083b.intValue(), this.f15084c.booleanValue(), this.f15085d.intValue(), this.f15086e.longValue(), this.f15087f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a b(Double d10) {
            this.f15082a = d10;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a c(int i10) {
            this.f15083b = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a d(long j10) {
            this.f15087f = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a e(int i10) {
            this.f15085d = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a f(boolean z10) {
            this.f15084c = Boolean.valueOf(z10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.c.a
        public v.d.AbstractC0312d.c.a g(long j10) {
            this.f15086e = Long.valueOf(j10);
            return this;
        }
    }

    private r(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.f15076a = d10;
        this.f15077b = i10;
        this.f15078c = z10;
        this.f15079d = i11;
        this.f15080e = j10;
        this.f15081f = j11;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public Double b() {
        return this.f15076a;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public int c() {
        return this.f15077b;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public long d() {
        return this.f15081f;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public int e() {
        return this.f15079d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.c)) {
            return false;
        }
        v.d.AbstractC0312d.c cVar = (v.d.AbstractC0312d.c) obj;
        Double d10 = this.f15076a;
        if (d10 != null ? d10.equals(cVar.b()) : cVar.b() == null) {
            if (this.f15077b == cVar.c() && this.f15078c == cVar.g() && this.f15079d == cVar.e() && this.f15080e == cVar.f() && this.f15081f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public long f() {
        return this.f15080e;
    }

    @Override // w3.v.d.AbstractC0312d.c
    public boolean g() {
        return this.f15078c;
    }

    public int hashCode() {
        Double d10 = this.f15076a;
        int hashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f15077b) * 1000003) ^ (this.f15078c ? 1231 : 1237)) * 1000003) ^ this.f15079d) * 1000003;
        long j10 = this.f15080e;
        long j11 = this.f15081f;
        return ((hashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f15076a + ", batteryVelocity=" + this.f15077b + ", proximityOn=" + this.f15078c + ", orientation=" + this.f15079d + ", ramUsed=" + this.f15080e + ", diskUsed=" + this.f15081f + "}";
    }
}
