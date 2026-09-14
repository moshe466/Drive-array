package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class o extends v.d.AbstractC0312d.a.b.AbstractC0318d {

    /* renamed from: a, reason: collision with root package name */
    private final String f15054a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15055b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15056c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a {

        /* renamed from: a, reason: collision with root package name */
        private String f15057a;

        /* renamed from: b, reason: collision with root package name */
        private String f15058b;

        /* renamed from: c, reason: collision with root package name */
        private Long f15059c;

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a
        public v.d.AbstractC0312d.a.b.AbstractC0318d a() {
            String str = "";
            if (this.f15057a == null) {
                str = " name";
            }
            if (this.f15058b == null) {
                str = str + " code";
            }
            if (this.f15059c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new o(this.f15057a, this.f15058b, this.f15059c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a
        public v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a b(long j10) {
            this.f15059c = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a
        public v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a c(String str) {
            Objects.requireNonNull(str, "Null code");
            this.f15058b = str;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a
        public v.d.AbstractC0312d.a.b.AbstractC0318d.AbstractC0319a d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f15057a = str;
            return this;
        }
    }

    private o(String str, String str2, long j10) {
        this.f15054a = str;
        this.f15055b = str2;
        this.f15056c = j10;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d
    public long b() {
        return this.f15056c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d
    public String c() {
        return this.f15055b;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0318d
    public String d() {
        return this.f15054a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b.AbstractC0318d)) {
            return false;
        }
        v.d.AbstractC0312d.a.b.AbstractC0318d abstractC0318d = (v.d.AbstractC0312d.a.b.AbstractC0318d) obj;
        return this.f15054a.equals(abstractC0318d.d()) && this.f15055b.equals(abstractC0318d.c()) && this.f15056c == abstractC0318d.b();
    }

    public int hashCode() {
        int hashCode = (((this.f15054a.hashCode() ^ 1000003) * 1000003) ^ this.f15055b.hashCode()) * 1000003;
        long j10 = this.f15056c;
        return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f15054a + ", code=" + this.f15055b + ", address=" + this.f15056c + "}";
    }
}
