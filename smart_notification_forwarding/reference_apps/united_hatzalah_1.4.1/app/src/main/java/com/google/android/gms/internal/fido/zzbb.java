package com.google.android.gms.internal.fido;

import java.util.Map;

/* loaded from: classes.dex */
abstract class zzbb extends zzbc {
    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = zzf().get(entry.getKey());
            if (obj2 != null && obj2.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzbc, java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzbx.zza(zzf().entrySet());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zzf().size();
    }

    public abstract zzba zzf();

    @Override // com.google.android.gms.internal.fido.zzbc
    public final boolean zzg() {
        return false;
    }
}
