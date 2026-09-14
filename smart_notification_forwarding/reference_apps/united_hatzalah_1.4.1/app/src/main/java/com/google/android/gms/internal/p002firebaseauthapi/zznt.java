package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class zznt {
    private static final Logger zza = Logger.getLogger(zznt.class.getName());
    private static final zznt zzb = new zznt();
    private ConcurrentMap<String, zzbl<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    private final synchronized zzbl<?> zzc(String str) {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return this.zzc.get(str);
    }

    public final <P> zzbl<P> zza(String str, Class<P> cls) {
        zzbl<P> zzblVar = (zzbl<P>) zzc(str);
        if (zzblVar.zza().equals(cls)) {
            return zzblVar;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzblVar.getClass());
        String valueOf2 = String.valueOf(zzblVar.zza());
        StringBuilder y = AbstractC0008a.y("Primitive type ", name, " not supported by key manager of type ", valueOf, ", which only supports: ");
        y.append(valueOf2);
        throw new GeneralSecurityException(y.toString());
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }

    public final zzbl<?> zza(String str) {
        return zzc(str);
    }

    public static zznt zza() {
        return zzb;
    }

    private final synchronized void zza(zzbl<?> zzblVar, boolean z3, boolean z4) {
        try {
            String zzb2 = zzblVar.zzb();
            if (z4 && this.zzd.containsKey(zzb2) && !this.zzd.get(zzb2).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + zzb2);
            }
            zzbl<?> zzblVar2 = this.zzc.get(zzb2);
            if (zzblVar2 != null && !zzblVar2.getClass().equals(zzblVar.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + zzb2);
                throw new GeneralSecurityException("typeUrl (" + zzb2 + ") is already registered with " + zzblVar2.getClass().getName() + ", cannot be re-registered with " + zzblVar.getClass().getName());
            }
            this.zzc.putIfAbsent(zzb2, zzblVar);
            this.zzd.put(zzb2, Boolean.valueOf(z4));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized <P> void zza(zzbl<P> zzblVar, boolean z3) {
        zza(zzblVar, zzix.zza.zza, z3);
    }

    public final synchronized <P> void zza(zzbl<P> zzblVar, zzix.zza zzaVar, boolean z3) {
        if (zzaVar.zza()) {
            zza((zzbl<?>) zzblVar, false, z3);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
