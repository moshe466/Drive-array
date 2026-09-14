package r1;

import r1.d;

/* loaded from: classes.dex */
final class a extends d {

    /* renamed from: b, reason: collision with root package name */
    private final long f13644b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13645c;

    /* renamed from: d, reason: collision with root package name */
    private final int f13646d;

    /* renamed from: e, reason: collision with root package name */
    private final long f13647e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13648f;

    /* loaded from: classes.dex */
    static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f13649a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f13650b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f13651c;

        /* renamed from: d, reason: collision with root package name */
        private Long f13652d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f13653e;

        @Override // r1.d.a
        d a() {
            String str = "";
            if (this.f13649a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f13650b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f13651c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f13652d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f13653e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f13649a.longValue(), this.f13650b.intValue(), this.f13651c.intValue(), this.f13652d.longValue(), this.f13653e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // r1.d.a
        d.a b(int i10) {
            this.f13651c = Integer.valueOf(i10);
            return this;
        }

        @Override // r1.d.a
        d.a c(long j10) {
            this.f13652d = Long.valueOf(j10);
            return this;
        }

        @Override // r1.d.a
        d.a d(int i10) {
            this.f13650b = Integer.valueOf(i10);
            return this;
        }

        @Override // r1.d.a
        d.a e(int i10) {
            this.f13653e = Integer.valueOf(i10);
            return this;
        }

        @Override // r1.d.a
        d.a f(long j10) {
            this.f13649a = Long.valueOf(j10);
            return this;
        }
    }

    private a(long j10, int i10, int i11, long j11, int i12) {
        this.f13644b = j10;
        this.f13645c = i10;
        this.f13646d = i11;
        this.f13647e = j11;
        this.f13648f = i12;
    }

    @Override // r1.d
    int b() {
        return this.f13646d;
    }

    @Override // r1.d
    long c() {
        return this.f13647e;
    }

    @Override // r1.d
    int d() {
        return this.f13645c;
    }

    @Override // r1.d
    int e() {
        return this.f13648f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f13644b == dVar.f() && this.f13645c == dVar.d() && this.f13646d == dVar.b() && this.f13647e == dVar.c() && this.f13648f == dVar.e();
    }

    @Override // r1.d
    long f() {
        return this.f13644b;
    }

    public int hashCode() {
        long j10 = this.f13644b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13645c) * 1000003) ^ this.f13646d) * 1000003;
        long j11 = this.f13647e;
        return this.f13648f ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f13644b + ", loadBatchSize=" + this.f13645c + ", criticalSectionEnterTimeoutMs=" + this.f13646d + ", eventCleanUpAge=" + this.f13647e + ", maxBlobByteSizePerRow=" + this.f13648f + "}";
    }
}
