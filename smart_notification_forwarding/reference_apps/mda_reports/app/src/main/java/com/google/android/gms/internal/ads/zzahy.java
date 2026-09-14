package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class zzahy {
    private final zzaib zzcyt;

    private zzahy(zzaib zzaibVar) {
        this.zzcyt = zzaibVar;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.zzcyt.zzdc(str);
    }
}
