package com.squareup.okhttp;

/* loaded from: classes2.dex */
public interface Interceptor {

    /* loaded from: classes2.dex */
    public interface Chain {
        Connection connection();

        Response proceed(Request request);

        Request request();
    }

    Response intercept(Chain chain);
}
