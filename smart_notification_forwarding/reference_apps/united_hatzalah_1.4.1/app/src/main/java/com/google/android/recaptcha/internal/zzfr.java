package com.google.android.recaptcha.internal;

import F2.p;
import P2.B;
import P2.E;
import P2.InterfaceC0157i0;
import a.AbstractC0228a;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfr extends AbstractC0793i implements p {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zzgd zzb;
    final /* synthetic */ zzft zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfr(Exception exc, zzgd zzgdVar, zzft zzftVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zza = exc;
        this.zzb = zzgdVar;
        this.zzc = zzftVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        zzfr zzfrVar = new zzfr(this.zza, this.zzb, this.zzc, interfaceC0763d);
        zzfrVar.zzd = obj;
        return zzfrVar;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfr) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zztd zztdVar;
        boolean z3;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        AbstractC0228a.C(obj);
        E e4 = (E) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzce) {
            zztdVar = ((zzce) exc).zza();
            zztdVar.zze(this.zzb.zza());
        } else {
            zzgd zzgdVar = this.zzb;
            zztd zzf = zzte.zzf();
            zzf.zze(zzgdVar.zza());
            zzf.zzr(2);
            zzf.zzq(2);
            zztdVar = zzf;
        }
        zzte zzteVar = (zzte) zztdVar.zzk();
        zzteVar.zzl();
        zzteVar.zzk();
        s.a(this.zza.getClass()).c();
        this.zza.getMessage();
        zzgd zzgdVar2 = this.zzb;
        zzbn zzb = zzgdVar2.zzb();
        zzbn zzbnVar = zzgdVar2.zza;
        if (zzbnVar == null) {
            zzbnVar = null;
        }
        zzrl zza = zzev.zza(zzb, zzbnVar);
        String zzd = this.zzb.zzd();
        if (zzd.length() == 0) {
            zzd = "recaptcha.m.Main.rge";
        }
        InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) e4.a().get(B.f1595b);
        if (interfaceC0157i0 != null) {
            z3 = interfaceC0157i0.isActive();
        } else {
            z3 = true;
        }
        if (z3) {
            zzft zzftVar = this.zzc;
            zzkh zzh = zzkh.zzh();
            byte[] zzd2 = zzteVar.zzd();
            String zzi = zzh.zzi(zzd2, 0, zzd2.length);
            zzkh zzh2 = zzkh.zzh();
            byte[] zzd3 = zza.zzd();
            zzftVar.zzb.zzd().zzb(zzd, (String[]) Arrays.copyOf(new String[]{zzi, zzh2.zzi(zzd3, 0, zzd3.length)}, 2));
        }
        return C0684i.f6340a;
    }
}
