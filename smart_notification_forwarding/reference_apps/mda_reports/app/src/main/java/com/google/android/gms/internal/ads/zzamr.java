package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class zzamr {
    public static int zza(AdRequest.ErrorCode errorCode) {
        int i = zzamu.a[errorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static MediationAdRequest zza(zzug zzugVar, boolean z) {
        List<String> list = zzugVar.zzcca;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzugVar.zzcby);
        int i = zzugVar.zzcbz;
        return new MediationAdRequest(date, i != 1 ? i != 2 ? AdRequest.Gender.UNKNOWN : AdRequest.Gender.FEMALE : AdRequest.Gender.MALE, hashSet, z, zzugVar.zzmi);
    }
}
