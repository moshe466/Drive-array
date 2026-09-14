package com.google.android.recaptcha.internal;

import s2.C0681f;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzir extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ zzja zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzir(zzja zzjaVar, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = zzjaVar;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzh = this.zzb.zzh(null, this);
        if (zzh == EnumC0779a.f6740a) {
            return zzh;
        }
        return new C0681f(zzh);
    }
}
