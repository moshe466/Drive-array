package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import P2.G;
import P2.InterfaceC0157i0;
import a.AbstractC0228a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzs extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzv zzb;
    final /* synthetic */ String zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzv zzvVar, String str, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzvVar;
        this.zzc = str;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        zzs zzsVar = new zzs(this.zzb, this.zzc, interfaceC0763d);
        zzsVar.zzd = obj;
        return zzsVar;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzsi zzq;
        List list;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i == 0) {
            E e4 = (E) this.zzd;
            ArrayList arrayList = new ArrayList();
            this.zzb.zzo().put(this.zzc, arrayList);
            ArrayList arrayList2 = new ArrayList();
            list = this.zzb.zzb;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                if (((zzy) obj2).zzf()) {
                    arrayList3.add(obj2);
                }
            }
            int size = arrayList3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj3 = arrayList3.get(i3);
                i3++;
                arrayList2.add(G.r(e4, null, new zzr((zzy) obj3, this.zzc, arrayList, null), 3));
            }
            InterfaceC0157i0[] interfaceC0157i0Arr = (InterfaceC0157i0[]) arrayList2.toArray(new InterfaceC0157i0[0]);
            InterfaceC0157i0[] interfaceC0157i0Arr2 = (InterfaceC0157i0[]) Arrays.copyOf(interfaceC0157i0Arr, interfaceC0157i0Arr.length);
            this.zza = 1;
            if (G.q(interfaceC0157i0Arr2, this) == enumC0779a) {
                return enumC0779a;
            }
        }
        zzq = this.zzb.zzq(this.zzc);
        return new C0681f(zzq);
    }
}
