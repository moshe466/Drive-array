package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdl extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzdt zzb;
    final /* synthetic */ zzsc zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdl(zzdt zzdtVar, zzsc zzscVar, long j2, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzdtVar;
        this.zzc = zzscVar;
        this.zzd = j2;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzdl(this.zzb, this.zzc, this.zzd, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdl) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzv;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i == 0) {
            zzdt zzdtVar = this.zzb;
            zzsc zzscVar = this.zzc;
            long j2 = this.zzd;
            this.zza = 1;
            zzv = zzdtVar.zzv(zzscVar, j2, this);
            if (zzv == enumC0779a) {
                return enumC0779a;
            }
        }
        return C0684i.f6340a;
    }
}
