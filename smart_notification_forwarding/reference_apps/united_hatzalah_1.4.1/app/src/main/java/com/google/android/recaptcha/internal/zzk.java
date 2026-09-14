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
public final class zzk extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzl zzb;
    final /* synthetic */ zzek zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzsc zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzk(zzl zzlVar, zzek zzekVar, long j2, zzsc zzscVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzlVar;
        this.zzc = zzekVar;
        this.zzd = j2;
        this.zze = zzscVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        zzk zzkVar = new zzk(this.zzb, this.zzc, this.zzd, this.zze, interfaceC0763d);
        zzkVar.zzf = obj;
        return zzkVar;
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzk) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        zzen zzenVar;
        Object obj2;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        if (this.zza != 0) {
            zzenVar = (zzen) this.zzf;
            AbstractC0228a.C(obj);
        } else {
            AbstractC0228a.C(obj);
            E e4 = (E) this.zzf;
            this.zzb.zzb = this.zzc;
            zzek zzekVar = this.zzc;
            zzekVar.zzc(zzekVar.zzd());
            zzen zzf = zzekVar.zzf(30);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzb.zzd().iterator();
            while (it.hasNext()) {
                arrayList.add(G.c(e4, new zzj((zze) it.next(), this.zzd, this.zze, null)));
            }
            J[] jArr = (J[]) arrayList.toArray(new J[0]);
            J[] jArr2 = (J[]) Arrays.copyOf(jArr, jArr.length);
            this.zzf = zzf;
            this.zza = 1;
            obj = G.d(jArr2, this);
            if (obj != enumC0779a) {
                zzenVar = zzf;
            } else {
                return enumC0779a;
            }
        }
        List list = (List) obj;
        if (list == null || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (!(((C0681f) it2.next()).f6335a instanceof C0680e)) {
                    zzenVar.zza();
                    obj2 = C0684i.f6340a;
                    break;
                }
            }
        }
        zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzY, null);
        zzenVar.zzb(zzbdVar);
        obj2 = AbstractC0228a.g(zzbdVar);
        return new C0681f(obj2);
    }
}
