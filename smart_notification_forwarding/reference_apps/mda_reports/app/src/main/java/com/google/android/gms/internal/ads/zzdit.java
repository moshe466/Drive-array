package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnk;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class zzdit {
    private static final Logger logger = Logger.getLogger(zzdit.class.getName());
    private static final ConcurrentMap<String, zza> zzgyi = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzgyj = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzdia<?>> zzgyk = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzdis<?>> zzgyl = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface zza {
        Set<Class<?>> zzase();

        zzdid<?> zzasn();

        Class<?> zzaso();

        Class<?> zzasp();

        <P> zzdid<P> zzb(Class<P> cls);
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    private static <P> zzdid<P> zza(String str, Class<P> cls) {
        zza zzgx = zzgx(str);
        if (cls == null) {
            return (zzdid<P>) zzgx.zzasn();
        }
        if (zzgx.zzase().contains(cls)) {
            return zzgx.zzb(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzgx.zzaso());
        Set<Class<?>> zzase = zzgx.zzase();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzase) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdiq<P> zza(zzdij zzdijVar, zzdid<P> zzdidVar, Class<P> cls) {
        Class cls2 = (Class) checkNotNull(cls);
        zzdiz.zzc(zzdijVar.a());
        zzdiq<P> zzdiqVar = (zzdiq<P>) zzdiq.zza(cls2);
        for (zzdnk.zza zzaVar : zzdijVar.a().zzavw()) {
            if (zzaVar.zzasj() == zzdne.ENABLED) {
                zzdip zza2 = zzdiqVar.zza(zza(zzaVar.zzawa().zzavi(), zzaVar.zzawa().zzavj(), cls2), zzaVar);
                if (zzaVar.zzawb() == zzdijVar.a().zzavv()) {
                    zzdiqVar.zza(zza2);
                }
            }
        }
        return zzdiqVar;
    }

    private static <KeyProtoT extends zzdte> zza zza(zzdii<KeyProtoT> zzdiiVar) {
        return new zzdiv(zzdiiVar);
    }

    public static synchronized zzdna zza(zzdng zzdngVar) {
        zzdna zzo;
        synchronized (zzdit.class) {
            zzdid<?> zzgz = zzgz(zzdngVar.zzavi());
            if (!zzgyj.get(zzdngVar.zzavi()).booleanValue()) {
                String valueOf = String.valueOf(zzdngVar.zzavi());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
            zzo = zzgz.zzo(zzdngVar.zzavj());
        }
        return zzo;
    }

    public static <P> P zza(zzdiq<P> zzdiqVar) {
        zzdis<?> zzdisVar = zzgyl.get(zzdiqVar.zzarz());
        if (zzdisVar != null) {
            return (P) zzdisVar.zza(zzdiqVar);
        }
        String valueOf = String.valueOf(zzdiqVar.zzarz().getName());
        throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
    }

    private static <P> P zza(String str, zzdqk zzdqkVar, Class<P> cls) {
        return (P) zza(str, cls).zzm(zzdqkVar);
    }

    public static <P> P zza(String str, zzdte zzdteVar, Class<P> cls) {
        return (P) zza(str, (Class) checkNotNull(cls)).zza(zzdteVar);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) {
        return (P) zza(str, zzdqk.zzu(bArr), (Class) checkNotNull(cls));
    }

    public static synchronized <P> void zza(zzdid<P> zzdidVar, boolean z) {
        synchronized (zzdit.class) {
            if (zzdidVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String keyType = zzdidVar.getKeyType();
            zza(keyType, zzdidVar.getClass(), z);
            if (!zzgyi.containsKey(keyType)) {
                zzgyi.put(keyType, new zzdiw(zzdidVar));
            }
            zzgyj.put(keyType, Boolean.valueOf(z));
        }
    }

    public static synchronized <KeyProtoT extends zzdte> void zza(zzdii<KeyProtoT> zzdiiVar, boolean z) {
        synchronized (zzdit.class) {
            String keyType = zzdiiVar.getKeyType();
            zza(keyType, zzdiiVar.getClass(), true);
            if (!zzgyi.containsKey(keyType)) {
                zzgyi.put(keyType, zza(zzdiiVar));
            }
            zzgyj.put(keyType, true);
        }
    }

    public static synchronized <P> void zza(zzdis<P> zzdisVar) {
        synchronized (zzdit.class) {
            if (zzdisVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> zzarz = zzdisVar.zzarz();
            if (zzgyl.containsKey(zzarz)) {
                zzdis<?> zzdisVar2 = zzgyl.get(zzarz);
                if (!zzdisVar.getClass().equals(zzdisVar2.getClass())) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(zzarz.toString());
                    logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzarz.getName(), zzdisVar2.getClass().getName(), zzdisVar.getClass().getName()));
                }
            }
            zzgyl.put(zzarz, zzdisVar);
        }
    }

    public static synchronized <KeyProtoT extends zzdte, PublicKeyProtoT extends zzdte> void zza(zzdiu<KeyProtoT, PublicKeyProtoT> zzdiuVar, zzdii<PublicKeyProtoT> zzdiiVar, boolean z) {
        Class<?> zzasp;
        synchronized (zzdit.class) {
            String keyType = zzdiuVar.getKeyType();
            String keyType2 = zzdiiVar.getKeyType();
            zza(keyType, zzdiuVar.getClass(), true);
            zza(keyType2, zzdiiVar.getClass(), false);
            if (keyType.equals(keyType2)) {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
            if (zzgyi.containsKey(keyType) && (zzasp = zzgyi.get(keyType).zzasp()) != null && !zzasp.equals(zzdiiVar.getClass())) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append(keyType);
                sb.append(" with inconsistent public key type ");
                sb.append(keyType2);
                logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzdiuVar.getClass().getName(), zzasp.getName(), zzdiiVar.getClass().getName()));
            }
            if (!zzgyi.containsKey(keyType) || zzgyi.get(keyType).zzasp() == null) {
                zzgyi.put(keyType, new zzdix(zzdiuVar, zzdiiVar));
            }
            zzgyj.put(keyType, true);
            if (!zzgyi.containsKey(keyType2)) {
                zzgyi.put(keyType2, zza(zzdiiVar));
            }
            zzgyj.put(keyType2, false);
        }
    }

    private static synchronized <P> void zza(String str, Class<?> cls, boolean z) {
        synchronized (zzdit.class) {
            if (zzgyi.containsKey(str)) {
                zza zzaVar = zzgyi.get(str);
                if (zzaVar.zzaso().equals(cls)) {
                    if (!z || zzgyj.get(str).booleanValue()) {
                        return;
                    }
                    String valueOf = String.valueOf(str);
                    throw new GeneralSecurityException(valueOf.length() != 0 ? "New keys are already disallowed for key type ".concat(valueOf) : new String("New keys are already disallowed for key type "));
                }
                Logger logger2 = logger;
                Level level = Level.WARNING;
                String valueOf2 = String.valueOf(str);
                logger2.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", valueOf2.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf2) : new String("Attempted overwrite of a registered key manager for key type "));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzaVar.zzaso().getName(), cls.getName()));
            }
        }
    }

    public static synchronized zzdte zzb(zzdng zzdngVar) {
        zzdte zzn;
        synchronized (zzdit.class) {
            zzdid<?> zzgz = zzgz(zzdngVar.zzavi());
            if (!zzgyj.get(zzdngVar.zzavi()).booleanValue()) {
                String valueOf = String.valueOf(zzdngVar.zzavi());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
            zzn = zzgz.zzn(zzdngVar.zzavj());
        }
        return zzn;
    }

    private static synchronized zza zzgx(String str) {
        zza zzaVar;
        synchronized (zzdit.class) {
            if (!zzgyi.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzaVar = zzgyi.get(str);
        }
        return zzaVar;
    }

    @Deprecated
    public static zzdia<?> zzgy(String str) {
        String valueOf;
        String str2;
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzdia<?> zzdiaVar = zzgyk.get(str.toLowerCase());
        if (zzdiaVar != null) {
            return zzdiaVar;
        }
        String format = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase().startsWith("tinkaead")) {
            format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call DeterministicAeadConfig.register().";
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call StreamingAeadConfig.register().";
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call HybridConfig.register().";
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            valueOf = String.valueOf(format);
            str2 = "Maybe call MacConfig.register().";
        } else {
            if (!str.toLowerCase().startsWith("tinkpublickeysign") && !str.toLowerCase().startsWith("tinkpublickeyverify")) {
                if (str.toLowerCase().startsWith("tink")) {
                    valueOf = String.valueOf(format);
                    str2 = "Maybe call TinkConfig.register().";
                }
                throw new GeneralSecurityException(format);
            }
            valueOf = String.valueOf(format);
            str2 = "Maybe call SignatureConfig.register().";
        }
        format = valueOf.concat(str2);
        throw new GeneralSecurityException(format);
    }

    private static zzdid<?> zzgz(String str) {
        return zzgx(str).zzasn();
    }
}
