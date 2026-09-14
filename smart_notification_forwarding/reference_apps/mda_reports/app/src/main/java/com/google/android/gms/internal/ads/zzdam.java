package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzdam {
    private final zzazb zzbli;
    private final zzave zzbmm;
    private final Map<String, zzdao> zzgnd = new HashMap();
    private final Context zzyv;

    public zzdam(Context context, zzazb zzazbVar, zzave zzaveVar) {
        this.zzyv = context;
        this.zzbli = zzazbVar;
        this.zzbmm = zzaveVar;
    }

    private final zzdao zzaow() {
        return new zzdao(this.zzyv, this.zzbmm.zzvf(), this.zzbmm.zzvh());
    }

    private final zzdao zzgm(String str) {
        zzarf zzz = zzarf.zzz(this.zzyv);
        try {
            zzz.setAppPackageName(str);
            zzavx zzavxVar = new zzavx();
            zzavxVar.zza(this.zzyv, str, false);
            zzavy zzavyVar = new zzavy(this.zzbmm.zzvf(), zzavxVar);
            return new zzdao(zzz, zzavyVar, new zzavp(zzayk.zzxf(), zzavyVar));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzaow();
        }
    }

    public final zzdao zzgl(@Nullable String str) {
        if (str == null) {
            return zzaow();
        }
        if (this.zzgnd.containsKey(str)) {
            return this.zzgnd.get(str);
        }
        zzdao zzgm = zzgm(str);
        this.zzgnd.put(str, zzgm);
        return zzgm;
    }
}
