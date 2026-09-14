package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class q extends v.d.AbstractC0312d.a.b.e.AbstractC0321b {

    /* renamed from: a, reason: collision with root package name */
    private final long f15066a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15067b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15068c;

    /* renamed from: d, reason: collision with root package name */
    private final long f15069d;

    /* renamed from: e, reason: collision with root package name */
    private final int f15070e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a {

        /* renamed from: a, reason: collision with root package name */
        private Long f15071a;

        /* renamed from: b, reason: collision with root package name */
        private String f15072b;

        /* renamed from: c, reason: collision with root package name */
        private String f15073c;

        /* renamed from: d, reason: collision with root package name */
        private Long f15074d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f15075e;

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b a() {
            String str = "";
            if (this.f15071a == null) {
                str = " pc";
            }
            if (this.f15072b == null) {
                str = str + " symbol";
            }
            if (this.f15074d == null) {
                str = str + " offset";
            }
            if (this.f15075e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new q(this.f15071a.longValue(), this.f15072b, this.f15073c, this.f15074d.longValue(), this.f15075e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a b(String str) {
            this.f15073c = str;
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a c(int i10) {
            this.f15075e = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a d(long j10) {
            this.f15074d = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a e(long j10) {
            this.f15071a = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a
        public v.d.AbstractC0312d.a.b.e.AbstractC0321b.AbstractC0322a f(String str) {
            Objects.requireNonNull(str, "Null symbol");
            this.f15072b = str;
            return this;
        }
    }

    private q(long j10, String str, String str2, long j11, int i10) {
        this.f15066a = j10;
        this.f15067b = str;
        this.f15068c = str2;
        this.f15069d = j11;
        this.f15070e = i10;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b
    public String b() {
        return this.f15068c;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b
    public int c() {
        return this.f15070e;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b
    public long d() {
        return this.f15069d;
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b
    public long e() {
        return this.f15066a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0312d.a.b.e.AbstractC0321b)) {
            return false;
        }
        v.d.AbstractC0312d.a.b.e.AbstractC0321b abstractC0321b = (v.d.AbstractC0312d.a.b.e.AbstractC0321b) obj;
        return this.f15066a == abstractC0321b.e() && this.f15067b.equals(abstractC0321b.f()) && ((str = this.f15068c) != null ? str.equals(abstractC0321b.b()) : abstractC0321b.b() == null) && this.f15069d == abstractC0321b.d() && this.f15070e == abstractC0321b.c();
    }

    @Override // w3.v.d.AbstractC0312d.a.b.e.AbstractC0321b
    public String f() {
        return this.f15067b;
    }

    public int hashCode() {
        long j10 = this.f15066a;
        int hashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f15067b.hashCode()) * 1000003;
        String str = this.f15068c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f15069d;
        return this.f15070e ^ ((hashCode2 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f15066a + ", symbol=" + this.f15067b + ", file=" + this.f15068c + ", offset=" + this.f15069d + ", importance=" + this.f15070e + "}";
    }
}
