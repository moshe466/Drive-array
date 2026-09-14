package com.google.android.gms.internal.ads;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzbbo extends SSLSocketFactory {
    private SSLSocketFactory zzebo = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final /* synthetic */ zzbbp zzebp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbo(zzbbp zzbbpVar) {
        this.zzebp = zzbbpVar;
    }

    private final Socket zza(Socket socket) {
        int i;
        int i2;
        i = this.zzebp.zzebr;
        if (i > 0) {
            i2 = this.zzebp.zzebr;
            socket.setReceiveBufferSize(i2);
        }
        this.zzebp.zzb(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        return zza(this.zzebo.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return zza(this.zzebo.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return zza(this.zzebo.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return zza(this.zzebo.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return zza(this.zzebo.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zzebo.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zzebo.getSupportedCipherSuites();
    }
}
