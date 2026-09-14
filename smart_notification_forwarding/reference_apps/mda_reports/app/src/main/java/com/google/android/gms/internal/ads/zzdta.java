package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdta implements zzdsx {
    @Override // com.google.android.gms.internal.ads.zzdsx
    public final Map<?, ?> zzaq(Object obj) {
        return (zzdsy) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final Map<?, ?> zzar(Object obj) {
        return (zzdsy) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final boolean zzas(Object obj) {
        return !((zzdsy) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final Object zzat(Object obj) {
        ((zzdsy) obj).zzaxq();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final Object zzau(Object obj) {
        return zzdsy.zzbba().zzbbb();
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final zzdsv<?, ?> zzav(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final int zzb(int i, Object obj, Object obj2) {
        zzdsy zzdsyVar = (zzdsy) obj;
        if (zzdsyVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzdsyVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzdsx
    public final Object zze(Object obj, Object obj2) {
        zzdsy zzdsyVar = (zzdsy) obj;
        zzdsy zzdsyVar2 = (zzdsy) obj2;
        if (!zzdsyVar2.isEmpty()) {
            if (!zzdsyVar.isMutable()) {
                zzdsyVar = zzdsyVar.zzbbb();
            }
            zzdsyVar.zza(zzdsyVar2);
        }
        return zzdsyVar;
    }
}
