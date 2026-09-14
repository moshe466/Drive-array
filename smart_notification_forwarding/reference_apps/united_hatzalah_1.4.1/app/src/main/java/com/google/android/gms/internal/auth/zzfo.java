package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzfo implements zzgi {
    private static final zzfu zza = new zzfm();
    private final zzfu zzb;

    public zzfo() {
        zzfu zzfuVar;
        zzer zza2 = zzer.zza();
        try {
            zzfuVar = (zzfu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfuVar = zza;
        }
        zzfn zzfnVar = new zzfn(zza2, zzfuVar);
        zzez.zzf(zzfnVar, "messageInfoFactory");
        this.zzb = zzfnVar;
    }

    private static boolean zzb(zzft zzftVar) {
        if (zzftVar.zzc() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final zzgh zza(Class cls) {
        zzgj.zzg(cls);
        zzft zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzeu.class.isAssignableFrom(cls)) {
                return zzga.zzb(zzgj.zzc(), zzen.zzb(), zzb.zza());
            }
            return zzga.zzb(zzgj.zza(), zzen.zza(), zzb.zza());
        }
        if (zzeu.class.isAssignableFrom(cls)) {
            if (zzb(zzb)) {
                return zzfz.zzj(cls, zzb, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), zzen.zzb(), zzfs.zzb());
            }
            return zzfz.zzj(cls, zzb, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), null, zzfs.zzb());
        }
        if (zzb(zzb)) {
            return zzfz.zzj(cls, zzb, zzgc.zza(), zzfk.zzc(), zzgj.zza(), zzen.zza(), zzfs.zza());
        }
        return zzfz.zzj(cls, zzb, zzgc.zza(), zzfk.zzc(), zzgj.zzb(), null, zzfs.zza());
    }
}
