package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbis implements zzbil {
    private final Context zzup;

    public zzbis(Context context) {
        this.zzup = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbil
    public final void zzk(Map<String, String> map) {
        CookieManager zzbd;
        String str = map.get("cookie");
        if (TextUtils.isEmpty(str) || (zzbd = com.google.android.gms.ads.internal.zzq.zzks().zzbd(this.zzup)) == null) {
            return;
        }
        zzbd.setCookie("googleads.g.doubleclick.net", str);
    }
}
