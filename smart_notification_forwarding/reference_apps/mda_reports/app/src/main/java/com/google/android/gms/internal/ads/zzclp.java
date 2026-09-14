package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzclp {
    private final Clock zzbmq;
    private final List<String> zzgad = Collections.synchronizedList(new ArrayList());

    public zzclp(Clock clock) {
        this.zzbmq = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, int i, long j) {
        List<String> list = this.zzgad;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        list.add(sb.toString());
    }

    public final <T> zzdhe<T> zza(zzczl zzczlVar, zzdhe<T> zzdheVar) {
        long elapsedRealtime = this.zzbmq.elapsedRealtime();
        String str = zzczlVar.zzdcm;
        if (str != null) {
            zzdgs.zza(zzdheVar, new zzcls(this, str, elapsedRealtime), zzazd.zzdwj);
        }
        return zzdheVar;
    }

    public final String zzamh() {
        return TextUtils.join(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR, this.zzgad);
    }
}
