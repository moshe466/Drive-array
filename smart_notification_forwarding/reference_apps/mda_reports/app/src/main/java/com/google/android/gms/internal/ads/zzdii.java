package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdna;
import com.google.android.gms.internal.ads.zzdte;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzdii<KeyProtoT extends zzdte> {
    private final Class<KeyProtoT> zzgxv;
    private final Map<Class<?>, zzdik<?, KeyProtoT>> zzgxw;
    private final Class<?> zzgxx;

    /* JADX INFO: Access modifiers changed from: protected */
    @SafeVarargs
    public zzdii(Class<KeyProtoT> cls, zzdik<?, KeyProtoT>... zzdikVarArr) {
        this.zzgxv = cls;
        HashMap hashMap = new HashMap();
        for (zzdik<?, KeyProtoT> zzdikVar : zzdikVarArr) {
            if (hashMap.containsKey(zzdikVar.a())) {
                String valueOf = String.valueOf(zzdikVar.a().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
            hashMap.put(zzdikVar.a(), zzdikVar);
        }
        this.zzgxx = zzdikVarArr.length > 0 ? zzdikVarArr[0].a() : Void.class;
        this.zzgxw = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<?> a() {
        return this.zzgxx;
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) {
        zzdik<?, KeyProtoT> zzdikVar = this.zzgxw.get(cls);
        if (zzdikVar != null) {
            return (P) zzdikVar.zzak(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Class<KeyProtoT> zzasc() {
        return this.zzgxv;
    }

    public abstract zzdna.zzb zzasd();

    public final Set<Class<?>> zzase() {
        return this.zzgxw.keySet();
    }

    public zzdih<?, KeyProtoT> zzasg() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zze(KeyProtoT keyprotot);

    public abstract KeyProtoT zzr(zzdqk zzdqkVar);
}
