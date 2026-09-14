package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzat {
    private final SharedPreferences zza;
    private final Context zzb;
    private final zzq zzc;

    @GuardedBy("this")
    private final Map<String, zzs> zzd;

    public zzat(Context context) {
        this(context, new zzq());
    }

    private zzat(Context context, zzq zzqVar) {
        this.zzd = new ArrayMap();
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzc = zzqVar;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || zzc()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            zzb();
            FirebaseInstanceId.getInstance().d();
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean zzc() {
        return this.zza.getAll().isEmpty();
    }

    public final synchronized zzas zza(String str, String str2, String str3) {
        return zzas.b(this.zza.getString(zzc(str, str2, str3), null));
    }

    public final synchronized String zza() {
        return this.zza.getString("topic_operation_queue", "");
    }

    public final synchronized void zza(String str) {
        this.zza.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String a = zzas.a(str4, str5, System.currentTimeMillis());
        if (a == null) {
            return;
        }
        SharedPreferences.Editor edit = this.zza.edit();
        edit.putString(zzc(str, str2, str3), a);
        edit.commit();
    }

    public final synchronized zzs zzb(String str) {
        zzs b;
        zzs zzsVar = this.zzd.get(str);
        if (zzsVar != null) {
            return zzsVar;
        }
        try {
            b = this.zzc.a(this.zzb, str);
        } catch (zzt unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().d();
            b = this.zzc.b(this.zzb, str);
        }
        this.zzd.put(str, b);
        return b;
    }

    public final synchronized void zzb() {
        this.zzd.clear();
        zzq.a(this.zzb);
        this.zza.edit().clear().commit();
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc = zzc(str, str2, str3);
        SharedPreferences.Editor edit = this.zza.edit();
        edit.remove(zzc);
        edit.commit();
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zza.edit();
        for (String str2 : this.zza.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
