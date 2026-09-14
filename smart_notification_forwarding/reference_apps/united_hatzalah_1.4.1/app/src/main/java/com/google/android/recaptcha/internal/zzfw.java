package com.google.android.recaptcha.internal;

import P2.E;
import P2.G;
import android.webkit.WebView;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzfw {
    private final WebView zza;
    private final E zzb;

    public zzfw(WebView webView, E e4) {
        this.zza = webView;
        this.zzb = e4;
    }

    public final void zzb(String str, String... strArr) {
        G.r(this.zzb, null, new zzfv((String[]) Arrays.copyOf(strArr, strArr.length), this, str, null), 3);
    }
}
