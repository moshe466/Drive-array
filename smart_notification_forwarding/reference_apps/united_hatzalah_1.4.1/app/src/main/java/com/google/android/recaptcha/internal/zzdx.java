package com.google.android.recaptcha.internal;

import F2.p;
import P2.C0169t;
import P2.E;
import P2.InterfaceC0168s;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdx extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzec zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdx(zzec zzecVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzecVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzdx(this.zzb, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdx) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        InterfaceC0168s interfaceC0168s;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i == 0) {
            interfaceC0168s = this.zzb.zzc;
            this.zza = 1;
            if (((C0169t) interfaceC0168s).j(this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
