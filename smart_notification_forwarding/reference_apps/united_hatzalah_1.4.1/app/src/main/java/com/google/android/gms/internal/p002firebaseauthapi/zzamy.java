package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzamy implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzamw zzc;

    private final Iterator zza() {
        Map map;
        if (this.zzb == null) {
            map = this.zzc.zzf;
            this.zzb = map.entrySet().iterator();
        }
        return this.zzb;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i3 = this.zza;
        if (i3 > 0) {
            i = this.zzc.zzb;
            if (i3 <= i) {
                return true;
            }
        }
        if (zza().hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Object[] objArr;
        if (!zza().hasNext()) {
            objArr = this.zzc.zza;
            int i = this.zza - 1;
            this.zza = i;
            return (zzana) objArr[i];
        }
        return (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzamy(zzamw zzamwVar) {
        int i;
        this.zzc = zzamwVar;
        i = zzamwVar.zzb;
        this.zza = i;
    }
}
