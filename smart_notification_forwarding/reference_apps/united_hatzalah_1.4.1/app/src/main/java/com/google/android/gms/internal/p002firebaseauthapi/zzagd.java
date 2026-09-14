package com.google.android.gms.internal.p002firebaseauthapi;

import F0.AbstractC0008a;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import e0.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.tika.metadata.TikaCoreProperties;
import t.C0694j;

/* loaded from: classes.dex */
public final class zzagd {
    private static final Map<String, zzagc> zza = new C0694j(0);
    private static final Map<String, List<WeakReference<zzagf>>> zzb = new C0694j(0);

    private static String zza(String str, int i, boolean z3) {
        if (z3) {
            return "http://[" + str + "]:" + i + RemoteSettings.FORWARD_SLASH_STRING;
        }
        return "http://" + str + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + i + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public static String zzb(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = a.d("", zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER)));
        } else {
            str2 = "https://";
        }
        return AbstractC0008a.n(str2, "www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    public static String zzc(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = a.d("", zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER)));
        } else {
            str2 = "https://";
        }
        return AbstractC0008a.n(str2, "identitytoolkit.googleapis.com/v2");
    }

    public static String zzd(String str) {
        zzagc zzagcVar;
        String str2;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            str2 = a.d("", zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER)));
        } else {
            str2 = "https://";
        }
        return AbstractC0008a.n(str2, "securetoken.googleapis.com/v1");
    }

    public static String zza(String str) {
        zzagc zzagcVar;
        Map<String, zzagc> map = zza;
        synchronized (map) {
            zzagcVar = map.get(str);
        }
        if (zzagcVar != null) {
            return AbstractC0008a.n(zza(zzagcVar.zzb(), zzagcVar.zza(), zzagcVar.zzb().contains(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER)), "emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static void zza(String str, zzagf zzagfVar) {
        Map<String, List<WeakReference<zzagf>>> map = zzb;
        synchronized (map) {
            try {
                if (map.containsKey(str)) {
                    map.get(str).add(new WeakReference<>(zzagfVar));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new WeakReference(zzagfVar));
                    map.put(str, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzagc> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzagc(str, i));
        }
        Map<String, List<WeakReference<zzagf>>> map2 = zzb;
        synchronized (map2) {
            try {
                if (map2.containsKey(apiKey)) {
                    Iterator<WeakReference<zzagf>> it = map2.get(apiKey).iterator();
                    boolean z3 = false;
                    while (it.hasNext()) {
                        zzagf zzagfVar = it.next().get();
                        if (zzagfVar != null) {
                            zzagfVar.zza();
                            z3 = true;
                        }
                    }
                    if (!z3) {
                        zza.remove(apiKey);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }
}
