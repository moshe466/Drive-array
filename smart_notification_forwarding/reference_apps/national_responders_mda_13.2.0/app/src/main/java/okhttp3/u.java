package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes.dex */
public final class u extends z {

    /* renamed from: e, reason: collision with root package name */
    public static final t f12820e = t.c("multipart/mixed");

    /* renamed from: f, reason: collision with root package name */
    public static final t f12821f;

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f12822g;

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f12823h;

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f12824i;

    /* renamed from: a, reason: collision with root package name */
    private final bc.f f12825a;

    /* renamed from: b, reason: collision with root package name */
    private final t f12826b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f12827c;

    /* renamed from: d, reason: collision with root package name */
    private long f12828d = -1;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final bc.f f12829a;

        /* renamed from: b, reason: collision with root package name */
        private t f12830b;

        /* renamed from: c, reason: collision with root package name */
        private final List<b> f12831c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f12830b = u.f12820e;
            this.f12831c = new ArrayList();
            this.f12829a = bc.f.t(str);
        }

        public a a(String str, String str2) {
            return c(b.b(str, str2));
        }

        public a b(String str, String str2, z zVar) {
            return c(b.c(str, str2, zVar));
        }

        public a c(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.f12831c.add(bVar);
            return this;
        }

        public u d() {
            if (this.f12831c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new u(this.f12829a, this.f12830b, this.f12831c);
        }

        public a e(t tVar) {
            Objects.requireNonNull(tVar, "type == null");
            if (tVar.e().equals("multipart")) {
                this.f12830b = tVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + tVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final q f12832a;

        /* renamed from: b, reason: collision with root package name */
        final z f12833b;

        private b(q qVar, z zVar) {
            this.f12832a = qVar;
            this.f12833b = zVar;
        }

        public static b a(q qVar, z zVar) {
            Objects.requireNonNull(zVar, "body == null");
            if (qVar != null && qVar.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (qVar == null || qVar.c("Content-Length") == null) {
                return new b(qVar, zVar);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static b b(String str, String str2) {
            return c(str, null, z.d(null, str2));
        }

        public static b c(String str, String str2, z zVar) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb2 = new StringBuilder("form-data; name=");
            u.h(sb2, str);
            if (str2 != null) {
                sb2.append("; filename=");
                u.h(sb2, str2);
            }
            return a(q.g("Content-Disposition", sb2.toString()), zVar);
        }
    }

    static {
        t.c("multipart/alternative");
        t.c("multipart/digest");
        t.c("multipart/parallel");
        f12821f = t.c("multipart/form-data");
        f12822g = new byte[]{58, 32};
        f12823h = new byte[]{13, 10};
        f12824i = new byte[]{45, 45};
    }

    u(bc.f fVar, t tVar, List<b> list) {
        this.f12825a = fVar;
        this.f12826b = t.c(tVar + "; boundary=" + fVar.G());
        this.f12827c = sb.c.t(list);
    }

    static StringBuilder h(StringBuilder sb2, String str) {
        String str2;
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\n') {
                str2 = "%0A";
            } else if (charAt == '\r') {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb2.append(charAt);
            } else {
                str2 = "%22";
            }
            sb2.append(str2);
        }
        sb2.append('\"');
        return sb2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long i(bc.d dVar, boolean z10) {
        bc.c cVar;
        if (z10) {
            dVar = new bc.c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.f12827c.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f12827c.get(i10);
            q qVar = bVar.f12832a;
            z zVar = bVar.f12833b;
            dVar.h(f12824i);
            dVar.K(this.f12825a);
            dVar.h(f12823h);
            if (qVar != null) {
                int h10 = qVar.h();
                for (int i11 = 0; i11 < h10; i11++) {
                    dVar.S(qVar.e(i11)).h(f12822g).S(qVar.i(i11)).h(f12823h);
                }
            }
            t b10 = zVar.b();
            if (b10 != null) {
                dVar.S("Content-Type: ").S(b10.toString()).h(f12823h);
            }
            long a10 = zVar.a();
            if (a10 != -1) {
                dVar.S("Content-Length: ").U(a10).h(f12823h);
            } else if (z10) {
                cVar.d();
                return -1L;
            }
            byte[] bArr = f12823h;
            dVar.h(bArr);
            if (z10) {
                j10 += a10;
            } else {
                zVar.g(dVar);
            }
            dVar.h(bArr);
        }
        byte[] bArr2 = f12824i;
        dVar.h(bArr2);
        dVar.K(this.f12825a);
        dVar.h(bArr2);
        dVar.h(f12823h);
        if (!z10) {
            return j10;
        }
        long n02 = j10 + cVar.n0();
        cVar.d();
        return n02;
    }

    @Override // okhttp3.z
    public long a() {
        long j10 = this.f12828d;
        if (j10 != -1) {
            return j10;
        }
        long i10 = i(null, true);
        this.f12828d = i10;
        return i10;
    }

    @Override // okhttp3.z
    public t b() {
        return this.f12826b;
    }

    @Override // okhttp3.z
    public void g(bc.d dVar) {
        i(dVar, false);
    }
}
