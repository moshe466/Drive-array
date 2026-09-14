package j1;

import j1.m;
import java.util.List;

/* loaded from: classes.dex */
final class g extends m {

    /* renamed from: a, reason: collision with root package name */
    private final long f10945a;

    /* renamed from: b, reason: collision with root package name */
    private final long f10946b;

    /* renamed from: c, reason: collision with root package name */
    private final k f10947c;

    /* renamed from: d, reason: collision with root package name */
    private final Integer f10948d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10949e;

    /* renamed from: f, reason: collision with root package name */
    private final List<l> f10950f;

    /* renamed from: g, reason: collision with root package name */
    private final p f10951g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends m.a {

        /* renamed from: a, reason: collision with root package name */
        private Long f10952a;

        /* renamed from: b, reason: collision with root package name */
        private Long f10953b;

        /* renamed from: c, reason: collision with root package name */
        private k f10954c;

        /* renamed from: d, reason: collision with root package name */
        private Integer f10955d;

        /* renamed from: e, reason: collision with root package name */
        private String f10956e;

        /* renamed from: f, reason: collision with root package name */
        private List<l> f10957f;

        /* renamed from: g, reason: collision with root package name */
        private p f10958g;

        @Override // j1.m.a
        public m a() {
            String str = "";
            if (this.f10952a == null) {
                str = " requestTimeMs";
            }
            if (this.f10953b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f10952a.longValue(), this.f10953b.longValue(), this.f10954c, this.f10955d, this.f10956e, this.f10957f, this.f10958g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // j1.m.a
        public m.a b(k kVar) {
            this.f10954c = kVar;
            return this;
        }

        @Override // j1.m.a
        public m.a c(List<l> list) {
            this.f10957f = list;
            return this;
        }

        @Override // j1.m.a
        m.a d(Integer num) {
            this.f10955d = num;
            return this;
        }

        @Override // j1.m.a
        m.a e(String str) {
            this.f10956e = str;
            return this;
        }

        @Override // j1.m.a
        public m.a f(p pVar) {
            this.f10958g = pVar;
            return this;
        }

        @Override // j1.m.a
        public m.a g(long j10) {
            this.f10952a = Long.valueOf(j10);
            return this;
        }

        @Override // j1.m.a
        public m.a h(long j10) {
            this.f10953b = Long.valueOf(j10);
            return this;
        }
    }

    private g(long j10, long j11, k kVar, Integer num, String str, List<l> list, p pVar) {
        this.f10945a = j10;
        this.f10946b = j11;
        this.f10947c = kVar;
        this.f10948d = num;
        this.f10949e = str;
        this.f10950f = list;
        this.f10951g = pVar;
    }

    @Override // j1.m
    public k b() {
        return this.f10947c;
    }

    @Override // j1.m
    public List<l> c() {
        return this.f10950f;
    }

    @Override // j1.m
    public Integer d() {
        return this.f10948d;
    }

    @Override // j1.m
    public String e() {
        return this.f10949e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f10945a == mVar.g() && this.f10946b == mVar.h() && ((kVar = this.f10947c) != null ? kVar.equals(mVar.b()) : mVar.b() == null) && ((num = this.f10948d) != null ? num.equals(mVar.d()) : mVar.d() == null) && ((str = this.f10949e) != null ? str.equals(mVar.e()) : mVar.e() == null) && ((list = this.f10950f) != null ? list.equals(mVar.c()) : mVar.c() == null)) {
            p pVar = this.f10951g;
            p f10 = mVar.f();
            if (pVar == null) {
                if (f10 == null) {
                    return true;
                }
            } else if (pVar.equals(f10)) {
                return true;
            }
        }
        return false;
    }

    @Override // j1.m
    public p f() {
        return this.f10951g;
    }

    @Override // j1.m
    public long g() {
        return this.f10945a;
    }

    @Override // j1.m
    public long h() {
        return this.f10946b;
    }

    public int hashCode() {
        long j10 = this.f10945a;
        long j11 = this.f10946b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        k kVar = this.f10947c;
        int hashCode = (i10 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f10948d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f10949e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f10950f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f10951g;
        return hashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f10945a + ", requestUptimeMs=" + this.f10946b + ", clientInfo=" + this.f10947c + ", logSource=" + this.f10948d + ", logSourceName=" + this.f10949e + ", logEvents=" + this.f10950f + ", qosTier=" + this.f10951g + "}";
    }
}
