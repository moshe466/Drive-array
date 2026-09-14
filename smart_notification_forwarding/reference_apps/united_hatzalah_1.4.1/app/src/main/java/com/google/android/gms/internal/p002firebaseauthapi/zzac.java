package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
abstract class zzac extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    public zzac(zzv zzvVar, CharSequence charSequence) {
        zzf zzfVar;
        int i;
        zzfVar = zzvVar.zza;
        this.zzb = zzfVar;
        this.zzc = false;
        i = zzvVar.zzc;
        this.zze = i;
        this.zza = charSequence;
    }

    public abstract int zza(int i);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    public final /* synthetic */ String zza() {
        int i = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzb = zzb(i3);
                if (zzb == -1) {
                    zzb = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zza(zzb);
                }
                int i4 = this.zzd;
                if (i4 == i) {
                    int i5 = i4 + 1;
                    this.zzd = i5;
                    if (i5 > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i < zzb && this.zzb.zza(this.zza.charAt(i))) {
                        i++;
                    }
                    while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                        zzb--;
                    }
                    int i6 = this.zze;
                    if (i6 == 1) {
                        zzb = this.zza.length();
                        this.zzd = -1;
                        while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                            zzb--;
                        }
                    } else {
                        this.zze = i6 - 1;
                    }
                    return this.zza.subSequence(i, zzb).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    public abstract int zzb(int i);
}
