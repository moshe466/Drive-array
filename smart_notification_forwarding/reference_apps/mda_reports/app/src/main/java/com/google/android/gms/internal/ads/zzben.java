package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
/* loaded from: classes.dex */
public class zzben extends zzbdl {
    public zzben(zzbdi zzbdiVar, zzsm zzsmVar, boolean z) {
        super(zzbdiVar, zzsmVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final WebResourceResponse a(WebView webView, String str, @Nullable Map<String, String> map) {
        if (!(webView instanceof zzbdi)) {
            zzayu.zzez("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbdi zzbdiVar = (zzbdi) webView;
        zzato zzatoVar = this.b;
        if (zzatoVar != null) {
            zzatoVar.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.a(str, map);
        }
        if (zzbdiVar.zzaaa() != null) {
            zzbdiVar.zzaaa().zztn();
        }
        String str2 = (String) zzve.zzoy().zzd(zzbdiVar.zzzy().zzabt() ? zzzn.zzchn : zzbdiVar.zzaaf() ? zzzn.zzchm : zzzn.zzchl);
        com.google.android.gms.ads.internal.zzq.zzkq();
        return zzawb.zzd(zzbdiVar.getContext(), zzbdiVar.zzyr().zzbma, str2);
    }
}
