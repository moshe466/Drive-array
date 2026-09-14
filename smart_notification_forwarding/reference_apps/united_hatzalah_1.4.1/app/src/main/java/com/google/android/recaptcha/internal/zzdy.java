package com.google.android.recaptcha.internal;

import F2.l;
import P2.G;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
final class zzdy extends AbstractC0793i implements l {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzec zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(long j2, zzec zzecVar, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.zzb = j2;
        this.zzc = zzecVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new zzdy(this.zzb, this.zzc, interfaceC0763d);
    }

    @Override // F2.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzdy) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i == 0) {
            long j2 = this.zzb;
            zzdx zzdxVar = new zzdx(this.zzc, null);
            this.zza = 1;
            if (G.A(j2, zzdxVar, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
