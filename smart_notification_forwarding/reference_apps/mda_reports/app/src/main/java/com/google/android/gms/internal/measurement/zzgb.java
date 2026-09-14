package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgb implements zzhg {
    private static final zzgl zzb = new zzge();
    private final zzgl zza;

    public zzgb() {
        this(new zzgd(zzfe.zza(), zza()));
    }

    private zzgb(zzgl zzglVar) {
        zzff.a(zzglVar, "messageInfoFactory");
        this.zza = zzglVar;
    }

    private static zzgl zza() {
        try {
            return (zzgl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }

    private static boolean zza(zzgm zzgmVar) {
        return zzgmVar.zza() == zzfd.zze.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final <T> zzhd<T> zza(Class<T> cls) {
        zzhf.zza((Class<?>) cls);
        zzgm zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            return zzfd.class.isAssignableFrom(cls) ? zzgu.a(zzhf.zzc(), zzet.a(), zzb2.zzc()) : zzgu.a(zzhf.zza(), zzet.b(), zzb2.zzc());
        }
        if (!zzfd.class.isAssignableFrom(cls)) {
            boolean zza = zza(zzb2);
            zzgw a = zzgy.a();
            zzfy a2 = zzfy.a();
            return zza ? zzgs.a(cls, zzb2, a, a2, zzhf.zza(), zzet.b(), zzgj.a()) : zzgs.a(cls, zzb2, a, a2, zzhf.zzb(), null, zzgj.a());
        }
        boolean zza2 = zza(zzb2);
        zzgw b = zzgy.b();
        zzfy b2 = zzfy.b();
        zzhv<?, ?> zzc = zzhf.zzc();
        return zza2 ? zzgs.a(cls, zzb2, b, b2, zzc, zzet.a(), zzgj.b()) : zzgs.a(cls, zzb2, b, b2, zzc, null, zzgj.b());
    }
}
