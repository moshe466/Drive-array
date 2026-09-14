package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f12710c = new a().b();

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f12711a;

    /* renamed from: b, reason: collision with root package name */
    private final ac.c f12712b;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f12713a = new ArrayList();

        public a a(String str, String... strArr) {
            Objects.requireNonNull(str, "pattern == null");
            for (String str2 : strArr) {
                this.f12713a.add(new b(str, str2));
            }
            return this;
        }

        public f b() {
            return new f(new LinkedHashSet(this.f12713a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f12714a;

        /* renamed from: b, reason: collision with root package name */
        final String f12715b;

        /* renamed from: c, reason: collision with root package name */
        final String f12716c;

        /* renamed from: d, reason: collision with root package name */
        final bc.f f12717d;

        b(String str, String str2) {
            StringBuilder sb2;
            int i10;
            this.f12714a = str;
            if (str.startsWith("*.")) {
                sb2 = new StringBuilder();
                sb2.append("http://");
                str = str.substring(2);
            } else {
                sb2 = new StringBuilder();
                sb2.append("http://");
            }
            sb2.append(str);
            this.f12715b = r.k(sb2.toString()).l();
            if (str2.startsWith("sha1/")) {
                this.f12716c = "sha1/";
                i10 = 5;
            } else {
                if (!str2.startsWith("sha256/")) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
                }
                this.f12716c = "sha256/";
                i10 = 7;
            }
            this.f12717d = bc.f.n(str2.substring(i10));
            if (this.f12717d != null) {
                return;
            }
            throw new IllegalArgumentException("pins must be base64: " + str2);
        }

        boolean a(String str) {
            if (!this.f12714a.startsWith("*.")) {
                return str.equals(this.f12715b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f12715b.length()) {
                String str2 = this.f12715b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f12714a.equals(bVar.f12714a) && this.f12716c.equals(bVar.f12716c) && this.f12717d.equals(bVar.f12717d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f12714a.hashCode()) * 31) + this.f12716c.hashCode()) * 31) + this.f12717d.hashCode();
        }

        public String toString() {
            return this.f12716c + this.f12717d.j();
        }
    }

    f(Set<b> set, ac.c cVar) {
        this.f12711a = set;
        this.f12712b = cVar;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + e((X509Certificate) certificate).j();
    }

    static bc.f d(X509Certificate x509Certificate) {
        return bc.f.w(x509Certificate.getPublicKey().getEncoded()).z();
    }

    static bc.f e(X509Certificate x509Certificate) {
        return bc.f.w(x509Certificate.getPublicKey().getEncoded()).A();
    }

    public void a(String str, List<Certificate> list) {
        List<b> b10 = b(str);
        if (b10.isEmpty()) {
            return;
        }
        ac.c cVar = this.f12712b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i10);
            int size2 = b10.size();
            bc.f fVar = null;
            bc.f fVar2 = null;
            for (int i11 = 0; i11 < size2; i11++) {
                b bVar = b10.get(i11);
                if (bVar.f12716c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = e(x509Certificate);
                    }
                    if (bVar.f12717d.equals(fVar)) {
                        return;
                    }
                } else {
                    if (!bVar.f12716c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f12716c);
                    }
                    if (fVar2 == null) {
                        fVar2 = d(x509Certificate);
                    }
                    if (bVar.f12717d.equals(fVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate pinning failure!");
        sb2.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i12 = 0; i12 < size3; i12++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i12);
            sb2.append("\n    ");
            sb2.append(c(x509Certificate2));
            sb2.append(": ");
            sb2.append(x509Certificate2.getSubjectDN().getName());
        }
        sb2.append("\n  Pinned certificates for ");
        sb2.append(str);
        sb2.append(":");
        int size4 = b10.size();
        for (int i13 = 0; i13 < size4; i13++) {
            b bVar2 = b10.get(i13);
            sb2.append("\n    ");
            sb2.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    List<b> b(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f12711a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (sb.c.q(this.f12712b, fVar.f12712b) && this.f12711a.equals(fVar.f12711a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f f(ac.c cVar) {
        return sb.c.q(this.f12712b, cVar) ? this : new f(this.f12711a, cVar);
    }

    public int hashCode() {
        ac.c cVar = this.f12712b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f12711a.hashCode();
    }
}
