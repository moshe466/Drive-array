package com.google.android.recaptcha.internal;

import F2.p;
import P2.B;
import P2.E;
import P2.InterfaceC0157i0;
import a.AbstractC0228a;
import java.util.List;
import s2.C0684i;
import t2.AbstractC0707i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfq extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzgd zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzft zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfq(zzgd zzgdVar, List list, zzft zzftVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzgdVar;
        this.zzc = list;
        this.zzd = zzftVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        zzfq zzfqVar = new zzfq(this.zzb, this.zzc, this.zzd, interfaceC0763d);
        zzfqVar.zze = obj;
        return zzfqVar;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfq) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        boolean z3;
        Object zzh;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        C0684i c0684i = C0684i.f6340a;
        AbstractC0228a.C(obj);
        if (i != 0) {
            return c0684i;
        }
        E e4 = (E) this.zze;
        while (true) {
            zzgd zzgdVar = this.zzb;
            if (zzgdVar.zza() < 0) {
                break;
            }
            if (zzgdVar.zza() < this.zzc.size()) {
                InterfaceC0157i0 interfaceC0157i0 = (InterfaceC0157i0) e4.a().get(B.f1595b);
                if (interfaceC0157i0 != null) {
                    z3 = interfaceC0157i0.isActive();
                } else {
                    z3 = true;
                }
                if (!z3) {
                    break;
                }
                zzuf zzufVar = (zzuf) this.zzc.get(this.zzb.zza());
                try {
                    zzft.zzf(this.zzd, zzufVar, this.zzb);
                } catch (Exception e5) {
                    zzufVar.zzk();
                    new Integer(zzufVar.zzg());
                    AbstractC0707i.h0(zzufVar.zzj(), null, null, null, new zzfp(this.zzd), 31);
                    zzft zzftVar = this.zzd;
                    zzgd zzgdVar2 = this.zzb;
                    this.zza = 1;
                    zzh = zzftVar.zzh(e5, zzgdVar2, this);
                    if (zzh == enumC0779a) {
                        return enumC0779a;
                    }
                }
            } else {
                break;
            }
        }
        return c0684i;
    }
}
