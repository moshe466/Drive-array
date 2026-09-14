package com.google.android.gms.measurement.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s9 extends SSLSocket {

    /* renamed from: f, reason: collision with root package name */
    private final SSLSocket f6458f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s9(q9 q9Var, SSLSocket sSLSocket) {
        this.f6458f = sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocket
    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f6458f.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void bind(SocketAddress socketAddress) {
        this.f6458f.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f6458f.close();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) {
        this.f6458f.connect(socketAddress);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i10) {
        this.f6458f.connect(socketAddress, i10);
    }

    public final boolean equals(Object obj) {
        return this.f6458f.equals(obj);
    }

    @Override // java.net.Socket
    public final SocketChannel getChannel() {
        return this.f6458f.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.f6458f.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.f6458f.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.f6458f.getEnabledProtocols();
    }

    @Override // java.net.Socket
    public final InetAddress getInetAddress() {
        return this.f6458f.getInetAddress();
    }

    @Override // java.net.Socket
    public final InputStream getInputStream() {
        return this.f6458f.getInputStream();
    }

    @Override // java.net.Socket
    public final boolean getKeepAlive() {
        return this.f6458f.getKeepAlive();
    }

    @Override // java.net.Socket
    public final InetAddress getLocalAddress() {
        return this.f6458f.getLocalAddress();
    }

    @Override // java.net.Socket
    public final int getLocalPort() {
        return this.f6458f.getLocalPort();
    }

    @Override // java.net.Socket
    public final SocketAddress getLocalSocketAddress() {
        return this.f6458f.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.f6458f.getNeedClientAuth();
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() {
        return this.f6458f.getOOBInline();
    }

    @Override // java.net.Socket
    public final OutputStream getOutputStream() {
        return this.f6458f.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        return this.f6458f.getPort();
    }

    @Override // java.net.Socket
    public final synchronized int getReceiveBufferSize() {
        return this.f6458f.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public final SocketAddress getRemoteSocketAddress() {
        return this.f6458f.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public final boolean getReuseAddress() {
        return this.f6458f.getReuseAddress();
    }

    @Override // java.net.Socket
    public final synchronized int getSendBufferSize() {
        return this.f6458f.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        return this.f6458f.getSession();
    }

    @Override // java.net.Socket
    public final int getSoLinger() {
        return this.f6458f.getSoLinger();
    }

    @Override // java.net.Socket
    public final synchronized int getSoTimeout() {
        return this.f6458f.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return this.f6458f.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return this.f6458f.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public final boolean getTcpNoDelay() {
        return this.f6458f.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public final int getTrafficClass() {
        return this.f6458f.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.f6458f.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.f6458f.getWantClientAuth();
    }

    @Override // java.net.Socket
    public final boolean isBound() {
        return this.f6458f.isBound();
    }

    @Override // java.net.Socket
    public final boolean isClosed() {
        return this.f6458f.isClosed();
    }

    @Override // java.net.Socket
    public final boolean isConnected() {
        return this.f6458f.isConnected();
    }

    @Override // java.net.Socket
    public final boolean isInputShutdown() {
        return this.f6458f.isInputShutdown();
    }

    @Override // java.net.Socket
    public final boolean isOutputShutdown() {
        return this.f6458f.isOutputShutdown();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f6458f.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i10) {
        this.f6458f.sendUrgentData(i10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z10) {
        this.f6458f.setEnableSessionCreation(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.f6458f.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f6458f.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f6458f.setEnabledProtocols(strArr);
    }

    @Override // java.net.Socket
    public final void setKeepAlive(boolean z10) {
        this.f6458f.setKeepAlive(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z10) {
        this.f6458f.setNeedClientAuth(z10);
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z10) {
        this.f6458f.setOOBInline(z10);
    }

    @Override // java.net.Socket
    public final void setPerformancePreferences(int i10, int i11, int i12) {
        this.f6458f.setPerformancePreferences(i10, i11, i12);
    }

    @Override // java.net.Socket
    public final synchronized void setReceiveBufferSize(int i10) {
        this.f6458f.setReceiveBufferSize(i10);
    }

    @Override // java.net.Socket
    public final void setReuseAddress(boolean z10) {
        this.f6458f.setReuseAddress(z10);
    }

    @Override // java.net.Socket
    public final synchronized void setSendBufferSize(int i10) {
        this.f6458f.setSendBufferSize(i10);
    }

    @Override // java.net.Socket
    public final void setSoLinger(boolean z10, int i10) {
        this.f6458f.setSoLinger(z10, i10);
    }

    @Override // java.net.Socket
    public final synchronized void setSoTimeout(int i10) {
        this.f6458f.setSoTimeout(i10);
    }

    @Override // java.net.Socket
    public final void setTcpNoDelay(boolean z10) {
        this.f6458f.setTcpNoDelay(z10);
    }

    @Override // java.net.Socket
    public final void setTrafficClass(int i10) {
        this.f6458f.setTrafficClass(i10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z10) {
        this.f6458f.setUseClientMode(z10);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z10) {
        this.f6458f.setWantClientAuth(z10);
    }

    @Override // java.net.Socket
    public final void shutdownInput() {
        this.f6458f.shutdownInput();
    }

    @Override // java.net.Socket
    public final void shutdownOutput() {
        this.f6458f.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() {
        this.f6458f.startHandshake();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public final String toString() {
        return this.f6458f.toString();
    }
}
