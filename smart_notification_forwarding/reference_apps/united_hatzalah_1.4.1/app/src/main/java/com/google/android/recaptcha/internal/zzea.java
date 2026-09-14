package com.google.android.recaptcha.internal;

import F2.l;
import P2.C0169t;
import P2.InterfaceC0168s;
import a.AbstractC0228a;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* loaded from: classes.dex */
final class zzea extends AbstractC0793i implements l {
    Object zza;
    int zzb;
    final /* synthetic */ zzec zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ InterfaceC0168s zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzea(zzec zzecVar, long j2, InterfaceC0168s interfaceC0168s, InterfaceC0763d interfaceC0763d) {
        super(1, interfaceC0763d);
        this.zzc = zzecVar;
        this.zzd = j2;
        this.zze = interfaceC0168s;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(InterfaceC0763d interfaceC0763d) {
        return new zzea(this.zzc, this.zzd, this.zze, interfaceC0763d);
    }

    @Override // F2.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzea) create((InterfaceC0763d) obj)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzek zzekVar;
        zzen zzenVar;
        zzbd e4;
        zzdt zzdtVar;
        zzen zzenVar2;
        zzdt zzdtVar2;
        zzcj zzcjVar;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zzb;
        if (i != 0) {
            if (i != 1) {
                zzenVar = (zzen) this.zza;
                try {
                    AbstractC0228a.C(obj);
                    zzenVar.zza();
                    zzec zzecVar = this.zzc;
                    zzcjVar = zzcm.zzb;
                    zzecVar.zzf = zzcjVar;
                    return Boolean.valueOf(((C0169t) this.zze).D(C0684i.f6340a));
                } catch (zzbd e5) {
                    e4 = e5;
                    this.zzc.zzd = e4;
                    zzenVar.zzb(e4);
                    throw e4;
                }
            }
            zzenVar2 = (zzen) this.zza;
            try {
                AbstractC0228a.C(obj);
            } catch (zzbd e6) {
                e4 = e6;
                zzenVar = zzenVar2;
                this.zzc.zzd = e4;
                zzenVar.zzb(e4);
                throw e4;
            }
        } else {
            AbstractC0228a.C(obj);
            zzekVar = this.zzc.zzb;
            zzen zzf = zzekVar.zzf(41);
            try {
                zzdtVar = this.zzc.zza;
                long j2 = this.zzd;
                this.zza = zzf;
                this.zzb = 1;
                Object zzo = zzdtVar.zzo(j2, this);
                if (zzo != enumC0779a) {
                    zzenVar2 = zzf;
                    obj = zzo;
                }
                return enumC0779a;
            } catch (zzbd e7) {
                zzenVar = zzf;
                e4 = e7;
                this.zzc.zzd = e4;
                zzenVar.zzb(e4);
                throw e4;
            }
        }
        zzsc zzscVar = (zzsc) obj;
        this.zzc.zze = zzscVar;
        zzdtVar2 = this.zzc.zza;
        long j3 = this.zzd;
        this.zza = zzenVar2;
        this.zzb = 2;
        if (zzdtVar2.zzn(zzscVar, j3, this) != enumC0779a) {
            zzenVar = zzenVar2;
            zzenVar.zza();
            zzec zzecVar2 = this.zzc;
            zzcjVar = zzcm.zzb;
            zzecVar2.zzf = zzcjVar;
            return Boolean.valueOf(((C0169t) this.zze).D(C0684i.f6340a));
        }
        return enumC0779a;
    }
}
