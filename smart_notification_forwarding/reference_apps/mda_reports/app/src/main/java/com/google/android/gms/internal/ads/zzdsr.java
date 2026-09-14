package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdsr implements zzdtz {
    private static final zzdtb zzhom = new zzdsu();
    private final zzdtb zzhol;

    public zzdsr() {
        this(new zzdst(zzdru.zzbaa(), zzbaz()));
    }

    private zzdsr(zzdtb zzdtbVar) {
        zzdrv.a(zzdtbVar, "messageInfoFactory");
        this.zzhol = zzdtbVar;
    }

    private static boolean zza(zzdtc zzdtcVar) {
        return zzdtcVar.zzbbg() == zzdrt.zze.zzhna;
    }

    private static zzdtb zzbaz() {
        try {
            return (zzdtb) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzhom;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtz
    public final <T> zzdua<T> zzg(Class<T> cls) {
        zzduc.zzi(cls);
        zzdtc zzf = this.zzhol.zzf(cls);
        if (zzf.zzbbh()) {
            return zzdrt.class.isAssignableFrom(cls) ? zzdtk.a(zzduc.zzbbz(), zzdrj.a(), zzf.zzbbi()) : zzdtk.a(zzduc.zzbbx(), zzdrj.b(), zzf.zzbbi());
        }
        if (!zzdrt.class.isAssignableFrom(cls)) {
            boolean zza = zza(zzf);
            zzdtm a = zzdto.a();
            zzdso a2 = zzdso.a();
            return zza ? zzdti.a(cls, zzf, a, a2, zzduc.zzbbx(), zzdrj.b(), zzdsz.a()) : zzdti.a(cls, zzf, a, a2, zzduc.zzbby(), null, zzdsz.a());
        }
        boolean zza2 = zza(zzf);
        zzdtm b = zzdto.b();
        zzdso b2 = zzdso.b();
        zzdus<?, ?> zzbbz = zzduc.zzbbz();
        return zza2 ? zzdti.a(cls, zzf, b, b2, zzbbz, zzdrj.a(), zzdsz.b()) : zzdti.a(cls, zzf, b, b2, zzbbz, null, zzdsz.b());
    }
}
