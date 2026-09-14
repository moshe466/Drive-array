package com.google.android.gms.measurement.internal;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
final class q9 extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f6361a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q9() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private q9(SSLSocketFactory sSLSocketFactory) {
        this.f6361a = sSLSocketFactory;
    }

    private final SSLSocket a(SSLSocket sSLSocket) {
        return new s9(this, sSLSocket);
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        return a((SSLSocket) this.f6361a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10) {
        return a((SSLSocket) this.f6361a.createSocket(str, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return a((SSLSocket) this.f6361a.createSocket(str, i10, inetAddress, i11));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10) {
        return a((SSLSocket) this.f6361a.createSocket(inetAddress, i10));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return a((SSLSocket) this.f6361a.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        return a((SSLSocket) this.f6361a.createSocket(socket, str, i10, z10));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f6361a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f6361a.getSupportedCipherSuites();
    }
}
