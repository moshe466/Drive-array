package ub;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.j;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<j> f14557a;

    /* renamed from: b, reason: collision with root package name */
    private int f14558b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f14559c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14560d;

    public b(List<j> list) {
        this.f14557a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i10 = this.f14558b; i10 < this.f14557a.size(); i10++) {
            if (this.f14557a.get(i10).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public j a(SSLSocket sSLSocket) {
        j jVar;
        int i10 = this.f14558b;
        int size = this.f14557a.size();
        while (true) {
            if (i10 >= size) {
                jVar = null;
                break;
            }
            jVar = this.f14557a.get(i10);
            i10++;
            if (jVar.c(sSLSocket)) {
                this.f14558b = i10;
                break;
            }
        }
        if (jVar != null) {
            this.f14559c = c(sSLSocket);
            sb.a.f14194a.c(jVar, sSLSocket, this.f14560d);
            return jVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f14560d + ", modes=" + this.f14557a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f14560d = true;
        if (!this.f14559c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z10 = iOException instanceof SSLHandshakeException;
        if ((z10 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z10 || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
