package com.google.android.recaptcha.internal;

import s2.C0681f;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzc extends AbstractC0787c {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zze zzc;
    int zzd;
    zzen zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzc(zze zzeVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzc = zzeVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zze = this.zzc.zze(0L, null, this);
        if (zze == EnumC0779a.f6740a) {
            return zze;
        }
        return new C0681f(zze);
    }
}
