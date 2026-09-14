package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import java.util.Iterator;
import java.util.List;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzu extends AbstractC0793i implements p {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zzsc zzd;
    final /* synthetic */ zzv zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzu(zzsc zzscVar, zzv zzvVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzd = zzscVar;
        this.zze = zzvVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzu(this.zzd, this.zze, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzu) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzse zzj;
        List list;
        Iterator it;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.zzc != 0) {
            it = (Iterator) this.zzb;
            zzj = (zzse) this.zza;
            AbstractC0228a.C(obj);
        } else {
            AbstractC0228a.C(obj);
            if (!this.zzd.zzS()) {
                return new C0681f(AbstractC0228a.g(new zzbd(zzbb.zzb, zzba.zzab, null)));
            }
            zzj = this.zzd.zzj();
            if (zzj.zzi().zzd() != 0) {
                this.zze.zzc = zzj.zzi();
                list = this.zze.zzb;
                it = list.iterator();
            } else {
                return new C0681f(AbstractC0228a.g(new zzbd(zzbb.zzb, zzba.zzab, null)));
            }
        }
        while (it.hasNext()) {
            zzy zzyVar = (zzy) it.next();
            this.zza = zzj;
            this.zzb = it;
            this.zzc = 1;
            if (zzyVar.zzd(zzj, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        return new C0681f(C0684i.f6340a);
    }
}
