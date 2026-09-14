package com.google.android.recaptcha.internal;

import w2.InterfaceC0763d;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzag extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzan zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzag(zzan zzanVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzanVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzi;
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        zzi = this.zzb.zzi(this);
        return zzi;
    }
}
