package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbs;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class zzev extends zzfw {
    public zzev(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        this.b.zzf(zzcd.ENUM_FAILURE);
        try {
            this.b.zzf(((Boolean) this.c.invoke(null, this.a.getContext())).booleanValue() ? zzcd.ENUM_TRUE : zzcd.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
