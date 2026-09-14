package com.google.firebase.auth.internal;

import com.google.android.gms.internal.p002firebaseauthapi.zzahx;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

/* loaded from: classes.dex */
public final class zzu implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final ActionCodeInfo zzd;

    public zzu(zzahx zzahxVar) {
        String zzb;
        if (zzahxVar.zzg()) {
            zzb = zzahxVar.zzc();
        } else {
            zzb = zzahxVar.zzb();
        }
        this.zzb = zzb;
        this.zzc = zzahxVar.zzb();
        ActionCodeInfo actionCodeInfo = null;
        if (!zzahxVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String zzd = zzahxVar.zzd();
        zzd.getClass();
        int i = 5;
        char c4 = 65535;
        switch (zzd.hashCode()) {
            case -1874510116:
                if (zzd.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1452371317:
                if (zzd.equals("PASSWORD_RESET")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1341836234:
                if (zzd.equals("VERIFY_EMAIL")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1099157829:
                if (zzd.equals("VERIFY_AND_CHANGE_EMAIL")) {
                    c4 = 3;
                    break;
                }
                break;
            case 870738373:
                if (zzd.equals("EMAIL_SIGNIN")) {
                    c4 = 4;
                    break;
                }
                break;
            case 970484929:
                if (zzd.equals("RECOVER_EMAIL")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                i = 6;
                break;
            case 1:
                i = 0;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i != 4 && i != 3) {
            if (zzahxVar.zzf()) {
                actionCodeInfo = new zzv(zzahxVar.zzb(), zzbk.zza(zzahxVar.zza()));
            } else if (zzahxVar.zzg()) {
                actionCodeInfo = new zzt(zzahxVar.zzc(), zzahxVar.zzb());
            } else if (zzahxVar.zze()) {
                actionCodeInfo = new zzs(zzahxVar.zzb());
            }
            this.zzd = actionCodeInfo;
            return;
        }
        this.zzd = null;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.zzc;
        }
        return this.zzb;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final ActionCodeInfo getInfo() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }
}
