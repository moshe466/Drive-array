package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzaly implements zzalz {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final int zza(int i, Object obj, Object obj2) {
        zzalw zzalwVar = (zzalw) obj;
        if (zzalwVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzalwVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final Object zzb(Object obj) {
        return zzalw.zza().zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final Object zzc(Object obj) {
        ((zzalw) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final Map<?, ?> zzd(Object obj) {
        return (zzalw) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final Map<?, ?> zze(Object obj) {
        return (zzalw) obj;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final boolean zzf(Object obj) {
        if (!((zzalw) obj).zzd()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final zzalx<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalz
    public final Object zza(Object obj, Object obj2) {
        zzalw zzalwVar = (zzalw) obj;
        zzalw zzalwVar2 = (zzalw) obj2;
        if (!zzalwVar2.isEmpty()) {
            if (!zzalwVar.zzd()) {
                zzalwVar = zzalwVar.zzb();
            }
            zzalwVar.zza(zzalwVar2);
        }
        return zzalwVar;
    }
}
