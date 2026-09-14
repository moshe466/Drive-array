package j1;

import j1.l;
import java.util.Arrays;

/* loaded from: classes.dex */
final class f extends l {

    /* renamed from: a, reason: collision with root package name */
    private final long f10931a;

    /* renamed from: b, reason: collision with root package name */
    private final Integer f10932b;

    /* renamed from: c, reason: collision with root package name */
    private final long f10933c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f10934d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10935e;

    /* renamed from: f, reason: collision with root package name */
    private final long f10936f;

    /* renamed from: g, reason: collision with root package name */
    private final o f10937g;

    /* loaded from: classes.dex */
    static final class b extends l.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f10938a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f10939b;

        /* renamed from: c, reason: collision with root package name */
        private Long f10940c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f10941d;

        /* renamed from: e, reason: collision with root package name */
        private String f10942e;

        /* renamed from: f, reason: collision with root package name */
        private Long f10943f;

        /* renamed from: g, reason: collision with root package name */
        private o f10944g;

        @Override // j1.l.a
        public l a() {
            String str = "";
            if (this.f10938a == null) {
                str = " eventTimeMs";
            }
            if (this.f10940c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f10943f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f10938a.longValue(), this.f10939b, this.f10940c.longValue(), this.f10941d, this.f10942e, this.f10943f.longValue(), this.f10944g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // j1.l.a
        public l.a b(Integer num) {
            this.f10939b = num;
            return this;
        }

        @Override // j1.l.a
        public l.a c(long j10) {
            this.f10938a = Long.valueOf(j10);
            return this;
        }

        @Override // j1.l.a
        public l.a d(long j10) {
            this.f10940c = Long.valueOf(j10);
            return this;
        }

        @Override // j1.l.a
        public l.a e(o oVar) {
            this.f10944g = oVar;
            return this;
        }

        @Override // j1.l.a
        l.a f(byte[] bArr) {
            this.f10941d = bArr;
            return this;
        }

        @Override // j1.l.a
        l.a g(String str) {
            this.f10942e = str;
            return this;
        }

        @Override // j1.l.a
        public l.a h(long j10) {
            this.f10943f = Long.valueOf(j10);
            return this;
        }
    }

    private f(long j10, Integer num, long j11, byte[] bArr, String str, long j12, o oVar) {
        this.f10931a = j10;
        this.f10932b = num;
        this.f10933c = j11;
        this.f10934d = bArr;
        this.f10935e = str;
        this.f10936f = j12;
        this.f10937g = oVar;
    }

    @Override // j1.l
    public Integer b() {
        return this.f10932b;
    }

    @Override // j1.l
    public long c() {
        return this.f10931a;
    }

    @Override // j1.l
    public long d() {
        return this.f10933c;
    }

    @Override // j1.l
    public o e() {
        return this.f10937g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f10931a == lVar.c() && ((num = this.f10932b) != null ? num.equals(lVar.b()) : lVar.b() == null) && this.f10933c == lVar.d()) {
            if (Arrays.equals(this.f10934d, lVar instanceof f ? ((f) lVar).f10934d : lVar.f()) && ((str = this.f10935e) != null ? str.equals(lVar.g()) : lVar.g() == null) && this.f10936f == lVar.h()) {
                o oVar = this.f10937g;
                o e10 = lVar.e();
                if (oVar == null) {
                    if (e10 == null) {
                        return true;
                    }
                } else if (oVar.equals(e10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // j1.l
    public byte[] f() {
        return this.f10934d;
    }

    @Override // j1.l
    public String g() {
        return this.f10935e;
    }

    @Override // j1.l
    public long h() {
        return this.f10936f;
    }

    public int hashCode() {
        long j10 = this.f10931a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f10932b;
        int hashCode = num == null ? 0 : num.hashCode();
        long j11 = this.f10933c;
        int hashCode2 = (((((i10 ^ hashCode) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f10934d)) * 1000003;
        String str = this.f10935e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j12 = this.f10936f;
        int i11 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        o oVar = this.f10937g;
        return i11 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f10931a + ", eventCode=" + this.f10932b + ", eventUptimeMs=" + this.f10933c + ", sourceExtension=" + Arrays.toString(this.f10934d) + ", sourceExtensionJsonProto3=" + this.f10935e + ", timezoneOffsetSeconds=" + this.f10936f + ", networkConnectionInfo=" + this.f10937g + "}";
    }
}
