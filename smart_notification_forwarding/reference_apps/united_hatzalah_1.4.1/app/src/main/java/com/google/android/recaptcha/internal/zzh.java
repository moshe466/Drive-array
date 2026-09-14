package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import P2.G;
import P2.J;
import a.AbstractC0228a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s2.C0680e;
import s2.C0681f;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(zzl zzlVar, String str, long j2, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzlVar;
        this.zzc = str;
        this.zzd = j2;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        zzh zzhVar = new zzh(this.zzb, this.zzc, this.zzd, interfaceC0763d);
        zzhVar.zze = obj;
        return zzhVar;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzh) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzek zzekVar;
        zzen zzenVar;
        zzen zzenVar2;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.zza != 0) {
            zzenVar2 = (zzen) this.zze;
            AbstractC0228a.C(obj);
        } else {
            AbstractC0228a.C(obj);
            E e4 = (E) this.zze;
            zzekVar = this.zzb.zzb;
            if (zzekVar != null) {
                zzekVar.zzc(this.zzc);
                zzenVar = zzekVar.zzf(31);
            } else {
                zzenVar = null;
            }
            ArrayList arrayList = new ArrayList();
            for (zze zzeVar : this.zzb.zzd()) {
                if (zzeVar.zzl()) {
                    arrayList.add(G.c(e4, new zzg(zzeVar, this.zzc, this.zzd, null)));
                }
            }
            J[] jArr = (J[]) arrayList.toArray(new J[0]);
            J[] jArr2 = (J[]) Arrays.copyOf(jArr, jArr.length);
            this.zze = zzenVar;
            this.zza = 1;
            obj = G.d(jArr2, this);
            if (obj != enumC0779a) {
                zzenVar2 = zzenVar;
            } else {
                return enumC0779a;
            }
        }
        String str = this.zzc;
        zzsh zzf = zzsi.zzf();
        zzf.zze(str);
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            Object obj2 = ((C0681f) it.next()).f6335a;
            if (!(obj2 instanceof C0680e)) {
                zzf.zzh((zzsi) obj2);
            }
        }
        zzsi zzsiVar = (zzsi) zzf.zzk();
        if (zzenVar2 != null) {
            zzenVar2.zza();
        }
        return zzsiVar;
    }
}
