package com.google.android.recaptcha;

import s2.C0681f;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0787c;

/* loaded from: classes.dex */
public final class Recaptcha$getClient$1 extends AbstractC0787c {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, InterfaceC0763d interfaceC0763d) {
        super(interfaceC0763d);
        this.zzb = recaptcha;
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object m2getClientBWLJW6A = this.zzb.m2getClientBWLJW6A(null, null, 0L, this);
        if (m2getClientBWLJW6A == EnumC0779a.f6740a) {
            return m2getClientBWLJW6A;
        }
        return new C0681f(m2getClientBWLJW6A);
    }
}
