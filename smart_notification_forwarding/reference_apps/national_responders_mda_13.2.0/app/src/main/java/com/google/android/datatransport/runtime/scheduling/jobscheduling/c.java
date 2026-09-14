package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
final class c extends e.b {

    /* renamed from: a, reason: collision with root package name */
    private final long f4716a;

    /* renamed from: b, reason: collision with root package name */
    private final long f4717b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<e.c> f4718c;

    /* loaded from: classes.dex */
    static final class b extends e.b.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f4719a;

        /* renamed from: b, reason: collision with root package name */
        private Long f4720b;

        /* renamed from: c, reason: collision with root package name */
        private Set<e.c> f4721c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b.a
        public e.b a() {
            String str = "";
            if (this.f4719a == null) {
                str = " delta";
            }
            if (this.f4720b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f4721c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new c(this.f4719a.longValue(), this.f4720b.longValue(), this.f4721c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b.a
        public e.b.a b(long j10) {
            this.f4719a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b.a
        public e.b.a c(Set<e.c> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f4721c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b.a
        public e.b.a d(long j10) {
            this.f4720b = Long.valueOf(j10);
            return this;
        }
    }

    private c(long j10, long j11, Set<e.c> set) {
        this.f4716a = j10;
        this.f4717b = j11;
        this.f4718c = set;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b
    long b() {
        return this.f4716a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b
    Set<e.c> c() {
        return this.f4718c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.e.b
    long d() {
        return this.f4717b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e.b)) {
            return false;
        }
        e.b bVar = (e.b) obj;
        return this.f4716a == bVar.b() && this.f4717b == bVar.d() && this.f4718c.equals(bVar.c());
    }

    public int hashCode() {
        long j10 = this.f4716a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f4717b;
        return this.f4718c.hashCode() ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f4716a + ", maxAllowedDelay=" + this.f4717b + ", flags=" + this.f4718c + "}";
    }
}
