package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class m extends v.d.AbstractC0312d.a.b.AbstractC0314a {

    /* renamed from: a, reason: collision with root package name */
    private final long f15036a;

    /* renamed from: b, reason: collision with root package name */
    private final long f15037b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15038c;

    /* renamed from: d, reason: collision with root package name */
    private final String f15039d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a {

        /* renamed from: a, reason: collision with root package name */
        private Long f15040a;

        /* renamed from: b, reason: collision with root package name */
        private Long f15041b;

        /* renamed from: c, reason: collision with root package name */
        private String f15042c;

        /* renamed from: d, reason: collision with root package name */
        private String f15043d;

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a
        public v.d.AbstractC0312d.a.b.AbstractC0314a a() {
            String str = "";
            if (this.f15040a == null) {
                str = " baseAddress";
            }
            if (this.f15041b == null) {
                str = str + " size";
            }
            if (this.f15042c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new m(this.f15040a.longValue(), this.f15041b.longValue(), this.f15042c, this.f15043d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a
        public v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a b(long j10) {
            this.f15040a = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a
        public v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a c(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f15042c = str;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a
        public v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a d(long j10) {
            this.f15041b = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a
        public v.d.AbstractC0312d.a.b.AbstractC0314a.AbstractC0315a e(String str) {
            this.f15043d = str;
            return this;
        }
    }

    private m(long j10, long j11, String str, String str2) {
        this.f15036a = j10;
        this.f15037b = j11;
        this.f15038c = str;
        this.f15039d = str2;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a
    public long b() {
        return this.f15036a;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a
    public String c() {
        return this.f15038c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a
    public long d() {
        return this.f15037b;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.AbstractC0314a
    public String e() {
        return this.f15039d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b.AbstractC0314a)) {
            return false;
        }
        v.d.AbstractC0312d.a.b.AbstractC0314a abstractC0314a = (v.d.AbstractC0312d.a.b.AbstractC0314a) obj;
        if (this.f15036a == abstractC0314a.b() && this.f15037b == abstractC0314a.d() && this.f15038c.equals(abstractC0314a.c())) {
            String str = this.f15039d;
            String e10 = abstractC0314a.e();
            if (str == null) {
                if (e10 == null) {
                    return true;
                }
            } else if (str.equals(e10)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f15036a;
        long j11 = this.f15037b;
        int hashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f15038c.hashCode()) * 1000003;
        String str = this.f15039d;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f15036a + ", size=" + this.f15037b + ", name=" + this.f15038c + ", uuid=" + this.f15039d + "}";
    }
}
