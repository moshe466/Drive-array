package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzayh implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzdvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayh(zzayf zzayfVar, Context context, Context context2) {
        this.zzdvc = context;
        this.val$context = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzdvc != null) {
            zzavs.zzed("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.zzdvc.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzavs.zzed("Attempting to read user agent from local cache.");
            sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzavs.zzed("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzavs.zzed("Persisting user agent.");
            }
        }
        return string;
    }
}
