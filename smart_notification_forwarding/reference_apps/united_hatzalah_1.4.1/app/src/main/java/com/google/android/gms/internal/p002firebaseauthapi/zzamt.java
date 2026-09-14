package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzamt implements zzama {
    private final zzamc zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzamt(zzamc zzamcVar, String str, Object[] objArr) {
        this.zza = zzamcVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            } else {
                this.zzd = i | (charAt2 << i3);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final zzamc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final zzamo zzb() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return zzamo.PROTO2;
        }
        if ((i & 4) == 4) {
            return zzamo.EDITIONS;
        }
        return zzamo.PROTO3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzama
    public final boolean zzc() {
        if ((this.zzd & 2) == 2) {
            return true;
        }
        return false;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
