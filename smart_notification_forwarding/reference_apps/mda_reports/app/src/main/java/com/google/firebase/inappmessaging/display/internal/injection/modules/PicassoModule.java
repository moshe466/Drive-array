package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

@Module
/* loaded from: classes2.dex */
public class PicassoModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @FirebaseAppScope
    public Picasso a(Application application, PicassoErrorListener picassoErrorListener) {
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(new Interceptor(this) { // from class: com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) {
                return chain.proceed(chain.request().newBuilder().addHeader("Accept", "image/*").build());
            }
        }).build();
        Picasso.Builder builder = new Picasso.Builder(application);
        builder.listener(picassoErrorListener).downloader(new OkHttp3Downloader(build));
        return builder.build();
    }
}
