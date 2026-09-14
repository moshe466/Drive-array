package com.squareup.okhttp;

import java.net.Proxy;

/* loaded from: classes2.dex */
public interface Authenticator {
    Request authenticate(Proxy proxy, Response response);

    Request authenticateProxy(Proxy proxy, Response response);
}
