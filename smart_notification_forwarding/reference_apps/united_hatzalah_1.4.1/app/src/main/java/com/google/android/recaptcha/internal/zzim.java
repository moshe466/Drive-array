package com.google.android.recaptcha.internal;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzim extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzja zzb;
    int zzc;
    zzja zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzim(zzja zzjaVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzjaVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzE;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzE = this.zzb.zzE(null, this);
        return zzE;
    }
}
