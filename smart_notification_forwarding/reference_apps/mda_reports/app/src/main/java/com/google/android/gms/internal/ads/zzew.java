package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbs;

/* loaded from: classes.dex */
public final class zzew extends zzfw {
    private final Activity zzzk;
    private final View zzzl;

    public zzew(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2, View view, Activity activity) {
        super(zzeiVar, str, str2, zzbVar, i, 62);
        this.zzzl = view;
        this.zzzk = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        if (this.zzzl == null) {
            return;
        }
        boolean booleanValue = ((Boolean) zzve.zzoy().zzd(zzzn.zzclb)).booleanValue();
        Object[] objArr = (Object[]) this.c.invoke(null, this.zzzl, this.zzzk, Boolean.valueOf(booleanValue));
        synchronized (this.b) {
            this.b.zzbp(((Long) objArr[0]).longValue());
            this.b.zzbq(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.b.zzam((String) objArr[2]);
            }
        }
    }
}
