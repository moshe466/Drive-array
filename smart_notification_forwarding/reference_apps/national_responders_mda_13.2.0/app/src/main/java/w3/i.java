package w3;

import java.util.Objects;
import w3.v;

/* loaded from: classes.dex */
final class i extends v.d.c {

    /* renamed from: a, reason: collision with root package name */
    private final int f14992a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14993b;

    /* renamed from: c, reason: collision with root package name */
    private final int f14994c;

    /* renamed from: d, reason: collision with root package name */
    private final long f14995d;

    /* renamed from: e, reason: collision with root package name */
    private final long f14996e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f14997f;

    /* renamed from: g, reason: collision with root package name */
    private final int f14998g;

    /* renamed from: h, reason: collision with root package name */
    private final String f14999h;

    /* renamed from: i, reason: collision with root package name */
    private final String f15000i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends v.d.c.a {

        /* renamed from: a, reason: collision with root package name */
        private Integer f15001a;

        /* renamed from: b, reason: collision with root package name */
        private String f15002b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f15003c;

        /* renamed from: d, reason: collision with root package name */
        private Long f15004d;

        /* renamed from: e, reason: collision with root package name */
        private Long f15005e;

        /* renamed from: f, reason: collision with root package name */
        private Boolean f15006f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f15007g;

        /* renamed from: h, reason: collision with root package name */
        private String f15008h;

        /* renamed from: i, reason: collision with root package name */
        private String f15009i;

        @Override // w3.v.d.c.a
        public v.d.c a() {
            String str = "";
            if (this.f15001a == null) {
                str = " arch";
            }
            if (this.f15002b == null) {
                str = str + " model";
            }
            if (this.f15003c == null) {
                str = str + " cores";
            }
            if (this.f15004d == null) {
                str = str + " ram";
            }
            if (this.f15005e == null) {
                str = str + " diskSpace";
            }
            if (this.f15006f == null) {
                str = str + " simulator";
            }
            if (this.f15007g == null) {
                str = str + " state";
            }
            if (this.f15008h == null) {
                str = str + " manufacturer";
            }
            if (this.f15009i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new i(this.f15001a.intValue(), this.f15002b, this.f15003c.intValue(), this.f15004d.longValue(), this.f15005e.longValue(), this.f15006f.booleanValue(), this.f15007g.intValue(), this.f15008h, this.f15009i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // w3.v.d.c.a
        public v.d.c.a b(int i10) {
            this.f15001a = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a c(int i10) {
            this.f15003c = Integer.valueOf(i10);
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a d(long j10) {
            this.f15005e = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a e(String str) {
            Objects.requireNonNull(str, "Null manufacturer");
            this.f15008h = str;
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a f(String str) {
            Objects.requireNonNull(str, "Null model");
            this.f15002b = str;
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a g(String str) {
            Objects.requireNonNull(str, "Null modelClass");
            this.f15009i = str;
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a h(long j10) {
            this.f15004d = Long.valueOf(j10);
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a i(boolean z10) {
            this.f15006f = Boolean.valueOf(z10);
            return this;
        }

        @Override // w3.v.d.c.a
        public v.d.c.a j(int i10) {
            this.f15007g = Integer.valueOf(i10);
            return this;
        }
    }

    private i(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f14992a = i10;
        this.f14993b = str;
        this.f14994c = i11;
        this.f14995d = j10;
        this.f14996e = j11;
        this.f14997f = z10;
        this.f14998g = i12;
        this.f14999h = str2;
        this.f15000i = str3;
    }

    @Override // w3.v.d.c
    public int b() {
        return this.f14992a;
    }

    @Override // w3.v.d.c
    public int c() {
        return this.f14994c;
    }

    @Override // w3.v.d.c
    public long d() {
        return this.f14996e;
    }

    @Override // w3.v.d.c
    public String e() {
        return this.f14999h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.c)) {
            return false;
        }
        v.d.c cVar = (v.d.c) obj;
        return this.f14992a == cVar.b() && this.f14993b.equals(cVar.f()) && this.f14994c == cVar.c() && this.f14995d == cVar.h() && this.f14996e == cVar.d() && this.f14997f == cVar.j() && this.f14998g == cVar.i() && this.f14999h.equals(cVar.e()) && this.f15000i.equals(cVar.g());
    }

    @Override // w3.v.d.c
    public String f() {
        return this.f14993b;
    }

    @Override // w3.v.d.c
    public String g() {
        return this.f15000i;
    }

    @Override // w3.v.d.c
    public long h() {
        return this.f14995d;
    }

    public int hashCode() {
        int hashCode = (((((this.f14992a ^ 1000003) * 1000003) ^ this.f14993b.hashCode()) * 1000003) ^ this.f14994c) * 1000003;
        long j10 = this.f14995d;
        int i10 = (hashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f14996e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f14997f ? 1231 : 1237)) * 1000003) ^ this.f14998g) * 1000003) ^ this.f14999h.hashCode()) * 1000003) ^ this.f15000i.hashCode();
    }

    @Override // w3.v.d.c
    public int i() {
        return this.f14998g;
    }

    @Override // w3.v.d.c
    public boolean j() {
        return this.f14997f;
    }

    public String toString() {
        return "Device{arch=" + this.f14992a + ", model=" + this.f14993b + ", cores=" + this.f14994c + ", ram=" + this.f14995d + ", diskSpace=" + this.f14996e + ", simulator=" + this.f14997f + ", state=" + this.f14998g + ", manufacturer=" + this.f14999h + ", modelClass=" + this.f15000i + "}";
    }
}
