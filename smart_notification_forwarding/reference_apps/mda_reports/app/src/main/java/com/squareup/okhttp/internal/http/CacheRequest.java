package com.squareup.okhttp.internal.http;

import okio.Sink;

/* loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    Sink body();
}
