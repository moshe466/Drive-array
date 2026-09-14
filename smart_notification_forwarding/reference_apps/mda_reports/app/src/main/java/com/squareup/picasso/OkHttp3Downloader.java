package com.squareup.picasso;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: classes2.dex */
public final class OkHttp3Downloader implements Downloader {

    @VisibleForTesting
    final Call.Factory a;
    private final okhttp3.Cache cache;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.b(context));
    }

    public OkHttp3Downloader(Context context, long j) {
        this(Utils.b(context), j);
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.a(file));
    }

    public OkHttp3Downloader(File file, long j) {
        this(new OkHttpClient.Builder().cache(new okhttp3.Cache(file, j)).build());
        this.sharedClient = false;
    }

    public OkHttp3Downloader(Call.Factory factory) {
        this.sharedClient = true;
        this.a = factory;
        this.cache = null;
    }

    public OkHttp3Downloader(OkHttpClient okHttpClient) {
        this.sharedClient = true;
        this.a = okHttpClient;
        this.cache = okHttpClient.cache();
    }

    @Override // com.squareup.picasso.Downloader
    @NonNull
    public Response load(@NonNull okhttp3.Request request) {
        return this.a.newCall(request).execute();
    }

    @Override // com.squareup.picasso.Downloader
    public void shutdown() {
        okhttp3.Cache cache;
        if (this.sharedClient || (cache = this.cache) == null) {
            return;
        }
        try {
            cache.close();
        } catch (IOException unused) {
        }
    }
}
