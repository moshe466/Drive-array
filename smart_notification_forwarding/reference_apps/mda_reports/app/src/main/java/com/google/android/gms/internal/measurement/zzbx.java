package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzbx implements zzcb {

    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzbx> zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private volatile Map<String, String> zzf;
    private final ContentObserver zzd = new zzbz(this, null);
    private final Object zze = new Object();

    @GuardedBy("this")
    private final List<zzcc> zzg = new ArrayList();

    private zzbx(ContentResolver contentResolver, Uri uri) {
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        synchronized (zzbx.class) {
            for (zzbx zzbxVar : zza.values()) {
                zzbxVar.zzb.unregisterContentObserver(zzbxVar.zzd);
            }
            zza.clear();
        }
    }

    public static zzbx zza(ContentResolver contentResolver, Uri uri) {
        zzbx zzbxVar;
        synchronized (zzbx.class) {
            zzbxVar = zza.get(uri);
            if (zzbxVar == null) {
                try {
                    zzbx zzbxVar2 = new zzbx(contentResolver, uri);
                    try {
                        zza.put(uri, zzbxVar2);
                    } catch (SecurityException unused) {
                    }
                    zzbxVar = zzbxVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzbxVar;
    }

    private final Map<String, String> zze() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzce.zza(new zzcd(this) { // from class: com.google.android.gms.internal.measurement.zzca
                    private final zzbx zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzcd
                    public final Object zza() {
                        return this.zza.a();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map a() {
        Cursor query = this.zzb.query(this.zzc, zzh, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                arrayMap.put(query.getString(0), query.getString(1));
            }
            return arrayMap;
        } finally {
            query.close();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcb
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    public final Map<String, String> zza() {
        Map<String, String> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    map = zze();
                    this.zzf = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcl.a();
        }
        synchronized (this) {
            Iterator<zzcc> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
