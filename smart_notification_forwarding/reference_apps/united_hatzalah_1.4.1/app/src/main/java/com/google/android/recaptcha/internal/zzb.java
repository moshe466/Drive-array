package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzb extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zze zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(zze zzeVar, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzeVar;
        this.zzc = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzb(this.zzb, this.zzc, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Object zzf;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i != 0) {
            zzf = ((C0681f) obj).f6335a;
        } else {
            zze zzeVar = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            zzf = zzeVar.zzf(str, this);
            if (zzf == enumC0779a) {
                return enumC0779a;
            }
        }
        return new C0681f(zzf);
    }
}
