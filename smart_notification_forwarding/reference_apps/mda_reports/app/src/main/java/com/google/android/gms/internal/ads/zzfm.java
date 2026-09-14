package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;
import java.util.List;

/* loaded from: classes.dex */
public final class zzfm extends zzfw {
    private List<Long> zzzy;

    public zzfm(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 31);
        this.zzzy = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzax(-1L);
        this.b.zzay(-1L);
        if (this.zzzy == null) {
            this.zzzy = (List) this.c.invoke(null, this.a.getContext());
        }
        List<Long> list = this.zzzy;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.b) {
            this.b.zzax(this.zzzy.get(0).longValue());
            this.b.zzay(this.zzzy.get(1).longValue());
        }
    }
}
