package com.google.android.recaptcha.internal;

import com.google.firebase.remoteconfig.internal.Code;
import java.util.Map;

/* loaded from: classes.dex */
final class zzmq extends zzmp {
    @Override // com.google.android.recaptcha.internal.zzmp
    public final void zza(Object obj) {
        ((zzna) obj).zzb.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zzmp
    public final void zzb(zzpy zzpyVar, Map.Entry entry) {
        zznb zznbVar = (zznb) entry.getKey();
        zzpw zzpwVar = zzpw.zza;
        switch (zznbVar.zzb.ordinal()) {
            case 0:
                zzpyVar.zzf(zznbVar.zza, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zzpyVar.zzo(zznbVar.zza, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zzpyVar.zzt(zznbVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zzpyVar.zzK(zznbVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zzpyVar.zzr(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zzpyVar.zzm(zznbVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zzpyVar.zzk(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zzpyVar.zzb(zznbVar.zza, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zzpyVar.zzG(zznbVar.zza, (String) entry.getValue());
                return;
            case 9:
                zzpyVar.zzq(zznbVar.zza, entry.getValue(), zzos.zza().zzb(entry.getValue().getClass()));
                return;
            case 10:
                zzpyVar.zzv(zznbVar.zza, entry.getValue(), zzos.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zzpyVar.zzd(zznbVar.zza, (zzle) entry.getValue());
                return;
            case Code.UNIMPLEMENTED /* 12 */:
                zzpyVar.zzI(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zzpyVar.zzr(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zzpyVar.zzx(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zzpyVar.zzz(zznbVar.zza, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zzpyVar.zzB(zznbVar.zza, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                zzpyVar.zzD(zznbVar.zza, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
