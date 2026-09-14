package com.google.android.recaptcha.internal;

import F2.p;
import P2.E;
import a.AbstractC0228a;
import android.app.Application;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import s2.C0684i;
import w2.InterfaceC0763d;
import x2.EnumC0779a;
import y2.AbstractC0793i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdh extends AbstractC0793i implements p {
    int zza;
    final /* synthetic */ zzdt zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdh(zzdt zzdtVar, InterfaceC0763d interfaceC0763d) {
        super(2, interfaceC0763d);
        this.zzb = zzdtVar;
    }

    @Override // y2.AbstractC0785a
    public final InterfaceC0763d create(Object obj, InterfaceC0763d interfaceC0763d) {
        return new zzdh(this.zzb, interfaceC0763d);
    }

    @Override // F2.p
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdh) create((E) obj, (InterfaceC0763d) obj2)).invokeSuspend(C0684i.f6340a);
    }

    @Override // y2.AbstractC0785a
    public final Object invokeSuspend(Object obj) {
        Application zzr;
        String str;
        Application zzr2;
        zzek zzekVar;
        zzbf zzt;
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        int i = this.zza;
        AbstractC0228a.C(obj);
        if (i != 0) {
            return obj;
        }
        zzbs zzbsVar = new zzbs(GoogleApiAvailabilityLight.getInstance());
        zzr = this.zzb.zzr();
        int zza = zzbsVar.zza(zzr);
        zzdt zzdtVar = this.zzb;
        str = zzdtVar.zza;
        zzr2 = zzdtVar.zzr();
        String packageName = zzr2.getPackageName();
        zzekVar = this.zzb.zzb;
        String zzd = zzekVar.zzd();
        zzt = this.zzb.zzt();
        int i3 = Build.VERSION.SDK_INT;
        String zza2 = zzt.zza();
        zztn zzf = zzto.zzf();
        zzf.zzt(str);
        zzf.zzq(packageName);
        zzf.zzu(zza);
        zzf.zzr("18.6.1");
        zzf.zzs(zzd);
        zzf.zzf(String.valueOf(i3));
        zzf.zze(zza2);
        zzto zztoVar = (zzto) zzf.zzk();
        zzdt zzdtVar2 = this.zzb;
        zzff zzg = zzdt.zzg(zzdtVar2);
        String zzb = zzdt.zzd(zzdtVar2).zzb();
        this.zza = 1;
        Object zzc = zzg.zzc(zzb, zztoVar, this);
        if (zzc == enumC0779a) {
            return enumC0779a;
        }
        return zzc;
    }
}
