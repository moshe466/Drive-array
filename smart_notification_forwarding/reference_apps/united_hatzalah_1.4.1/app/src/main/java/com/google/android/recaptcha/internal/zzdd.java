package com.google.android.recaptcha.internal;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdd extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdt zzb;
    int zzc;
    zzen zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdd(zzdt zzdtVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzdtVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzl(null, 0L, this);
    }
}
