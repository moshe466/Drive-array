package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt extends zzu {
    private zzbj.zze zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzn zznVar, String str, int i, zzbj.zze zzeVar) {
        super(str, i);
        this.zzh = zznVar;
        this.zzg = zzeVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final int a() {
        return this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Long l, zzbr.zzk zzkVar, boolean z) {
        zzey zzi;
        String zzc;
        String str;
        Boolean a;
        boolean zzd = this.zzh.zzt().zzd(this.a, zzap.zzbl);
        boolean zzd2 = this.zzh.zzt().zzd(this.a, zzap.zzbr);
        boolean zze = this.zzg.zze();
        boolean zzf = this.zzg.zzf();
        boolean z2 = zzd && this.zzg.zzh();
        boolean z3 = zze || zzf || z2;
        Boolean bool = null;
        bool = null;
        if (z && !z3) {
            this.zzh.zzr().zzx().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        zzbj.zzc zzd3 = this.zzg.zzd();
        boolean zzf2 = zzd3.zzf();
        if (zzkVar.zzf()) {
            if (zzd3.zzc()) {
                a = zzu.a(zzkVar.zzg(), zzd3.zzd());
                bool = zzu.a(a, zzf2);
            } else {
                zzi = this.zzh.zzr().zzi();
                zzc = this.zzh.zzo().zzc(zzkVar.zzc());
                str = "No number filter for long property. property";
                zzi.zza(str, zzc);
            }
        } else if (!zzkVar.zzh()) {
            if (zzkVar.zzd()) {
                if (zzd3.zza()) {
                    a = zzu.a(zzkVar.zze(), zzd3.zzb(), this.zzh.zzr());
                } else if (!zzd3.zzc()) {
                    zzi = this.zzh.zzr().zzi();
                    zzc = this.zzh.zzo().zzc(zzkVar.zzc());
                    str = "No string or number filter defined. property";
                } else if (zzki.zza(zzkVar.zze())) {
                    a = zzu.a(zzkVar.zze(), zzd3.zzd());
                } else {
                    this.zzh.zzr().zzi().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzo().zzc(zzkVar.zzc()), zzkVar.zze());
                }
                bool = zzu.a(a, zzf2);
            } else {
                zzi = this.zzh.zzr().zzi();
                zzc = this.zzh.zzo().zzc(zzkVar.zzc());
                str = "User property has no value, property";
            }
            zzi.zza(str, zzc);
        } else if (zzd3.zzc()) {
            a = zzu.a(zzkVar.zzi(), zzd3.zzd());
            bool = zzu.a(a, zzf2);
        } else {
            zzi = this.zzh.zzr().zzi();
            zzc = this.zzh.zzo().zzc(zzkVar.zzc());
            str = "No number filter for double property. property";
            zzi.zza(str, zzc);
        }
        this.zzh.zzr().zzx().zza("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.c = true;
        if (zzd && z2 && !bool.booleanValue()) {
            return true;
        }
        if (!z || this.zzg.zze()) {
            this.d = bool;
        }
        if (bool.booleanValue() && z3 && zzkVar.zza()) {
            long zzb = zzkVar.zzb();
            if (zzd2 && l != null) {
                zzb = l.longValue();
            }
            Long valueOf = Long.valueOf(zzb);
            if (zzf) {
                this.f = valueOf;
            } else {
                this.e = valueOf;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final boolean b() {
        return true;
    }
}
