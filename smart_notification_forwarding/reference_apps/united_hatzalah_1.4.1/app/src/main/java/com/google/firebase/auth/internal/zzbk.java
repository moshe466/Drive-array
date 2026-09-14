package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahq;
import com.google.android.gms.internal.p002firebaseauthapi.zzair;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbk {
    public static MultiFactorInfo zza(zzahq zzahqVar) {
        if (zzahqVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzahqVar.zze())) {
            return new PhoneMultiFactorInfo(zzahqVar.zzd(), zzahqVar.zzc(), zzahqVar.zza(), Preconditions.checkNotEmpty(zzahqVar.zze()));
        }
        if (zzahqVar.zzb() != null) {
            return new TotpMultiFactorInfo(zzahqVar.zzd(), zzahqVar.zzc(), zzahqVar.zza(), (zzair) Preconditions.checkNotNull(zzahqVar.zzb(), "totpInfo cannot be null."));
        }
        return null;
    }

    public static List<MultiFactorInfo> zza(List<zzahq> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<zzahq> it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo zza = zza(it.next());
                if (zza != null) {
                    arrayList.add(zza);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
