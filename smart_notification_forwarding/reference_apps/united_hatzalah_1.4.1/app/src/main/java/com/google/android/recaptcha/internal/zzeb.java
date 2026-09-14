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
public final class zzeb extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzec zzb;
    final /* synthetic */ InterfaceC0168s zzc;
    final /* synthetic */ long zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzec zzecVar, InterfaceC0168s interfaceC0168s, long j2, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzecVar;
        this.zzc = interfaceC0168s;
        this.zzd = j2;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzeb(this.zzb, this.zzc, this.zzd, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeb) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzbd zzbdVar;
        zzeb zzebVar;
        zzci zzciVar;
        zzbd e4;
        zzbq zzbqVar;
        zzdz zzdzVar;
        zzea zzeaVar;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.zza != 0) {
            try {
                AbstractC0228a.C(obj);
                zzebVar = this;
            } catch (zzbd e5) {
                zzbdVar = e5;
                zzebVar = this;
                zzec zzecVar = zzebVar.zzb;
                zzciVar = zzcm.zzd;
                zzecVar.zzf = zzciVar;
                ((C0169t) zzebVar.zzc).P(zzbdVar);
                return C0684i.f6340a;
            }
        } else {
            AbstractC0228a.C(obj);
            try {
                zzbqVar = zzbq.zza;
                zzdzVar = new zzdz(this.zzb);
                zzeaVar = new zzea(this.zzb, this.zzd, this.zzc, null);
                this.zza = 1;
                zzebVar = this;
            } catch (zzbd e6) {
                e4 = e6;
                zzebVar = this;
                zzbdVar = e4;
                zzec zzecVar2 = zzebVar.zzb;
                zzciVar = zzcm.zzd;
                zzecVar2.zzf = zzciVar;
                ((C0169t) zzebVar.zzc).P(zzbdVar);
                return C0684i.f6340a;
            }
            try {
                obj = zzbqVar.zza(zzdzVar, 100L, 1000L, 2.0d, zzeaVar, zzebVar);
                if (obj == enumC0779a) {
                    return enumC0779a;
                }
            } catch (zzbd e7) {
                e4 = e7;
                zzbdVar = e4;
                zzec zzecVar22 = zzebVar.zzb;
                zzciVar = zzcm.zzd;
                zzecVar22.zzf = zzciVar;
                ((C0169t) zzebVar.zzc).P(zzbdVar);
                return C0684i.f6340a;
            }
        }
        ((Boolean) obj).getClass();
        return C0684i.f6340a;
    }
}
