package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzcu implements zzcb {

    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzcu> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private volatile Map<String, ?> zze;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.zzct
        private final zzcu zza;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.zza = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.zza.a(sharedPreferences, str);
        }
    };
    private final Object zzd = new Object();

    @GuardedBy("this")
    private final List<zzcc> zzf = new ArrayList();

    private zzcu(SharedPreferences sharedPreferences) {
        this.zzb = sharedPreferences;
        this.zzb.registerOnSharedPreferenceChangeListener(this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcu a(Context context, String str) {
        zzcu zzcuVar;
        SharedPreferences sharedPreferences;
        if (!((!zzby.zza() || str.startsWith("direct_boot:")) ? true : zzby.zza(context))) {
            return null;
        }
        synchronized (zzcu.class) {
            zzcuVar = zza.get(str);
            if (zzcuVar == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzby.zza()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzcuVar = new zzcu(sharedPreferences);
                zza.put(str, zzcuVar);
            }
        }
        return zzcuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a() {
        synchronized (zzcu.class) {
            for (zzcu zzcuVar : zza.values()) {
                zzcuVar.zzb.unregisterOnSharedPreferenceChangeListener(zzcuVar.zzc);
            }
            zza.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzd) {
            this.zze = null;
            zzcl.a();
        }
        synchronized (this) {
            Iterator<zzcc> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final Object zza(String str) {
        Map<String, ?> map = this.zze;
        if (map == null) {
            synchronized (this.zzd) {
                map = this.zze;
                if (map == null) {
                    map = this.zzb.getAll();
                    this.zze = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
