package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzafp implements zzafn<Object> {
    private final Context zzup;

    public zzafp(Context context) {
        this.zzup = context;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        if (com.google.android.gms.ads.internal.zzq.zzlo().zzab(this.zzup)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                com.google.android.gms.ads.internal.zzq.zzlo().zzh(this.zzup, str2);
                return;
            }
            if (c == 1) {
                com.google.android.gms.ads.internal.zzq.zzlo().zzi(this.zzup, str2);
            } else if (c != 2) {
                zzayu.zzex("logScionEvent gmsg contained unsupported eventName");
            } else {
                com.google.android.gms.ads.internal.zzq.zzlo().zzk(this.zzup, str2);
            }
        }
    }
}
