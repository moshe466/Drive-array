package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbeb implements zzafn<zzbdi> {
    private final /* synthetic */ zzbdz zzehd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeb(zzbdz zzbdzVar) {
        this.zzehd = zzbdzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzbdi zzbdiVar, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get(SettingsJsonConstants.ICON_HEIGHT_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.zzehd) {
                    i = this.zzehd.zzegu;
                    if (i != parseInt) {
                        this.zzehd.zzegu = parseInt;
                        this.zzehd.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzayu.zzd("Exception occurred while getting webview content height", e);
            }
        }
    }
}
