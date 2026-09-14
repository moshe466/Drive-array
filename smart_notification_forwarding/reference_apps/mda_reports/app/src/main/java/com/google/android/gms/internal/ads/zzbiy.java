package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzbiy {
    private final Executor executor;
    private final String zzblz;
    private final zzakh zzfbx;
    private zzbjd zzfby;
    private final zzafn<Object> zzfbz = new zzbix(this);
    private final zzafn<Object> zzfca = new zzbiz(this);

    public zzbiy(String str, zzakh zzakhVar, Executor executor) {
        this.zzblz = str;
        this.zzfbx = zzakhVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzl(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzblz);
    }

    public final void zza(zzbjd zzbjdVar) {
        this.zzfbx.zzc("/updateActiveView", this.zzfbz);
        this.zzfbx.zzc("/untrackActiveViewUnit", this.zzfca);
        this.zzfby = zzbjdVar;
    }

    public final void zzafm() {
        this.zzfbx.zzd("/updateActiveView", this.zzfbz);
        this.zzfbx.zzd("/untrackActiveViewUnit", this.zzfca);
    }

    public final void zzd(zzbdi zzbdiVar) {
        zzbdiVar.zza("/updateActiveView", this.zzfbz);
        zzbdiVar.zza("/untrackActiveViewUnit", this.zzfca);
    }

    public final void zze(zzbdi zzbdiVar) {
        zzbdiVar.zzb("/updateActiveView", this.zzfbz);
        zzbdiVar.zzb("/untrackActiveViewUnit", this.zzfca);
    }
}
