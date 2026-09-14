package com.google.firebase.installations;

import com.google.firebase.installations.l;
import java.util.Objects;

/* loaded from: classes.dex */
final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    private final String f7347a;

    /* renamed from: b, reason: collision with root package name */
    private final long f7348b;

    /* renamed from: c, reason: collision with root package name */
    private final long f7349c;

    /* loaded from: classes.dex */
    static final class b extends l.a {

        /* renamed from: a, reason: collision with root package name */
        private String f7350a;

        /* renamed from: b, reason: collision with root package name */
        private Long f7351b;

        /* renamed from: c, reason: collision with root package name */
        private Long f7352c;

        @Override // com.google.firebase.installations.l.a
        public l a() {
            String str = "";
            if (this.f7350a == null) {
                str = " token";
            }
            if (this.f7351b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f7352c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.f7350a, this.f7351b.longValue(), this.f7352c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.l.a
        public l.a b(String str) {
            Objects.requireNonNull(str, "Null token");
            this.f7350a = str;
            return this;
        }

        @Override // com.google.firebase.installations.l.a
        public l.a c(long j10) {
            this.f7352c = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.firebase.installations.l.a
        public l.a d(long j10) {
            this.f7351b = Long.valueOf(j10);
            return this;
        }
    }

    private a(String str, long j10, long j11) {
        this.f7347a = str;
        this.f7348b = j10;
        this.f7349c = j11;
    }

    @Override // com.google.firebase.installations.l
    public String b() {
        return this.f7347a;
    }

    @Override // com.google.firebase.installations.l
    public long c() {
        return this.f7349c;
    }

    @Override // com.google.firebase.installations.l
    public long d() {
        return this.f7348b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f7347a.equals(lVar.b()) && this.f7348b == lVar.d() && this.f7349c == lVar.c();
    }

    public int hashCode() {
        int hashCode = (this.f7347a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f7348b;
        long j11 = this.f7349c;
        return ((hashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f7347a + ", tokenExpirationTimestamp=" + this.f7348b + ", tokenCreationTimestamp=" + this.f7349c + "}";
    }
}
