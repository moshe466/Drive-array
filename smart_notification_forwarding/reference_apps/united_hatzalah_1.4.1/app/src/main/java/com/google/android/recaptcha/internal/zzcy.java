package com.google.android.recaptcha.internal;

import s2.C0681f;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcy extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdc zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzdc zzdcVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzdcVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzf;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzf = this.zzb.zzf(null, 0L, this);
        if (zzf == EnumC0779a.f6740a) {
            return zzf;
        }
        return new C0681f(zzf);
    }
}
