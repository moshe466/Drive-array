package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.OkHostnameVerifier;
import io.grpc.okhttp.internal.Protocol;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
final class OkHttpTlsUpgrader {

    @VisibleForTesting
    static final List<Protocol> a = Collections.unmodifiableList(Arrays.asList(Protocol.GRPC_EXP, Protocol.HTTP_2));

    OkHttpTlsUpgrader() {
    }

    @VisibleForTesting
    static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }

    public static SSLSocket upgrade(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i, ConnectionSpec connectionSpec) {
        Preconditions.checkNotNull(sSLSocketFactory, "sslSocketFactory");
        Preconditions.checkNotNull(socket, "socket");
        Preconditions.checkNotNull(connectionSpec, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i, true);
        connectionSpec.apply(sSLSocket, false);
        String negotiate = OkHttpProtocolNegotiator.get().negotiate(sSLSocket, str, connectionSpec.supportsTlsExtensions() ? a : null);
        Preconditions.checkState(a.contains(Protocol.get(negotiate)), "Only " + a + " are supported, but negotiated protocol is %s", negotiate);
        if (hostnameVerifier == null) {
            hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
