package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: e, reason: collision with root package name */
    private static final g[] f12755e;

    /* renamed from: f, reason: collision with root package name */
    private static final g[] f12756f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f12757g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f12758h;

    /* renamed from: a, reason: collision with root package name */
    final boolean f12759a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f12760b;

    /* renamed from: c, reason: collision with root package name */
    final String[] f12761c;

    /* renamed from: d, reason: collision with root package name */
    final String[] f12762d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f12763a;

        /* renamed from: b, reason: collision with root package name */
        String[] f12764b;

        /* renamed from: c, reason: collision with root package name */
        String[] f12765c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12766d;

        public a(j jVar) {
            this.f12763a = jVar.f12759a;
            this.f12764b = jVar.f12761c;
            this.f12765c = jVar.f12762d;
            this.f12766d = jVar.f12760b;
        }

        a(boolean z10) {
            this.f12763a = z10;
        }

        public j a() {
            return new j(this);
        }

        public a b(String... strArr) {
            if (!this.f12763a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f12764b = (String[]) strArr.clone();
            return this;
        }

        public a c(g... gVarArr) {
            if (!this.f12763a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[gVarArr.length];
            for (int i10 = 0; i10 < gVarArr.length; i10++) {
                strArr[i10] = gVarArr[i10].f12738a;
            }
            return b(strArr);
        }

        public a d(boolean z10) {
            if (!this.f12763a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f12766d = z10;
            return this;
        }

        public a e(String... strArr) {
            if (!this.f12763a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f12765c = (String[]) strArr.clone();
            return this;
        }

        public a f(d0... d0VarArr) {
            if (!this.f12763a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[d0VarArr.length];
            for (int i10 = 0; i10 < d0VarArr.length; i10++) {
                strArr[i10] = d0VarArr[i10].javaName;
            }
            return e(strArr);
        }
    }

    static {
        g gVar = g.f12733q;
        g gVar2 = g.f12734r;
        g gVar3 = g.f12735s;
        g gVar4 = g.f12736t;
        g gVar5 = g.f12737u;
        g gVar6 = g.f12727k;
        g gVar7 = g.f12729m;
        g gVar8 = g.f12728l;
        g gVar9 = g.f12730n;
        g gVar10 = g.f12732p;
        g gVar11 = g.f12731o;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11};
        f12755e = gVarArr;
        g[] gVarArr2 = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7, gVar8, gVar9, gVar10, gVar11, g.f12725i, g.f12726j, g.f12723g, g.f12724h, g.f12721e, g.f12722f, g.f12720d};
        f12756f = gVarArr2;
        a c10 = new a(true).c(gVarArr);
        d0 d0Var = d0.TLS_1_3;
        d0 d0Var2 = d0.TLS_1_2;
        c10.f(d0Var, d0Var2).d(true).a();
        a c11 = new a(true).c(gVarArr2);
        d0 d0Var3 = d0.TLS_1_0;
        f12757g = c11.f(d0Var, d0Var2, d0.TLS_1_1, d0Var3).d(true).a();
        new a(true).c(gVarArr2).f(d0Var3).d(true).a();
        f12758h = new a(false).a();
    }

    j(a aVar) {
        this.f12759a = aVar.f12763a;
        this.f12761c = aVar.f12764b;
        this.f12762d = aVar.f12765c;
        this.f12760b = aVar.f12766d;
    }

    private j e(SSLSocket sSLSocket, boolean z10) {
        String[] z11 = this.f12761c != null ? sb.c.z(g.f12718b, sSLSocket.getEnabledCipherSuites(), this.f12761c) : sSLSocket.getEnabledCipherSuites();
        String[] z12 = this.f12762d != null ? sb.c.z(sb.c.f14210o, sSLSocket.getEnabledProtocols(), this.f12762d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int w10 = sb.c.w(g.f12718b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z10 && w10 != -1) {
            z11 = sb.c.i(z11, supportedCipherSuites[w10]);
        }
        return new a(this).b(z11).e(z12).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z10) {
        j e10 = e(sSLSocket, z10);
        String[] strArr = e10.f12762d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e10.f12761c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List<g> b() {
        String[] strArr = this.f12761c;
        if (strArr != null) {
            return g.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f12759a) {
            return false;
        }
        String[] strArr = this.f12762d;
        if (strArr != null && !sb.c.B(sb.c.f14210o, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f12761c;
        return strArr2 == null || sb.c.B(g.f12718b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.f12759a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        j jVar = (j) obj;
        boolean z10 = this.f12759a;
        if (z10 != jVar.f12759a) {
            return false;
        }
        return !z10 || (Arrays.equals(this.f12761c, jVar.f12761c) && Arrays.equals(this.f12762d, jVar.f12762d) && this.f12760b == jVar.f12760b);
    }

    public boolean f() {
        return this.f12760b;
    }

    public List<d0> g() {
        String[] strArr = this.f12762d;
        if (strArr != null) {
            return d0.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f12759a) {
            return ((((527 + Arrays.hashCode(this.f12761c)) * 31) + Arrays.hashCode(this.f12762d)) * 31) + (!this.f12760b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f12759a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f12761c != null ? b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f12762d != null ? g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f12760b + ")";
    }
}
