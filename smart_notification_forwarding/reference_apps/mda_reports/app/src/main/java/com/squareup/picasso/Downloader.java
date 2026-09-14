package com.squareup.picasso;

import androidx.annotation.NonNull;
import okhttp3.Response;

/* loaded from: classes2.dex */
public interface Downloader {
    @NonNull
    Response load(@NonNull okhttp3.Request request);

    void shutdown();
}
