package com.google.android.recaptcha.internal;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzio extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzja zzb;
    int zzc;
    zzja zzd;
    String zze;
    String zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzio(zzja zzjaVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzjaVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzF;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzF = this.zzb.zzF(null, this);
        return zzF;
    }
}
