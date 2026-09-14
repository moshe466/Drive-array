package okhttp3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f12791a;

    /* renamed from: b, reason: collision with root package name */
    private final g f12792b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f12793c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f12794d;

    private p(d0 d0Var, g gVar, List<Certificate> list, List<Certificate> list2) {
        this.f12791a = d0Var;
        this.f12792b = gVar;
        this.f12793c = list;
        this.f12794d = list2;
    }

    public static p b(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        g a10 = g.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        d0 forJavaName = d0.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List u10 = certificateArr != null ? sb.c.u(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new p(forJavaName, a10, u10, localCertificates != null ? sb.c.u(localCertificates) : Collections.emptyList());
    }

    public g a() {
        return this.f12792b;
    }

    public List<Certificate> c() {
        return this.f12793c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f12791a.equals(pVar.f12791a) && this.f12792b.equals(pVar.f12792b) && this.f12793c.equals(pVar.f12793c) && this.f12794d.equals(pVar.f12794d);
    }

    public int hashCode() {
        return ((((((527 + this.f12791a.hashCode()) * 31) + this.f12792b.hashCode()) * 31) + this.f12793c.hashCode()) * 31) + this.f12794d.hashCode();
    }
}
