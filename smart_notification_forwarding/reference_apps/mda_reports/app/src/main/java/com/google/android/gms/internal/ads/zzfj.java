package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class zzfj extends zzfw {
    public zzfj(zzei zzeiVar, String str, String str2, zzbs.zza.zzb zzbVar, int i, int i2) {
        super(zzeiVar, str, str2, zzbVar, i, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzfw
    protected final void a() {
        try {
            this.b.zzh(((Boolean) this.c.invoke(null, this.a.getContext())).booleanValue() ? zzcd.ENUM_TRUE : zzcd.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.b.zzh(zzcd.ENUM_FAILURE);
        }
    }
}
