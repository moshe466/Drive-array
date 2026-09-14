package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzac extends zzkb {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzad zzj;
    private final zzjx zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzke zzkeVar) {
        super(zzkeVar);
        this.zzk = new zzjx(zzm());
        this.zzj = new zzad(this, zzn(), "google_app_measurement.db");
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = a().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put(str, (Double) obj);
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbj.zzb zzbVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzr().zzi().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzew.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] zzbi = zzbVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        if (zzt().zze(str, zzap.zzbl)) {
            contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        }
        contentValues.put("data", zzbi);
        try {
            if (a().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzew.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzew.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbj.zze zzeVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzr().zzi().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzew.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] zzbi = zzeVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        if (zzt().zze(str, zzap.zzbl)) {
            contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        }
        contentValues.put("data", zzbi);
        try {
            if (a().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzew.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzew.zza(str), e);
            return false;
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = a().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean zzc(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase a = a();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzap.zzaf)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return a.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzew.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase a() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbr.zzi> a(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.a()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r4[r9] = r12     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteException -> L84
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            if (r1 != 0) goto L36
            if (r0 == 0) goto L35
            r0.close()
        L35:
            return r8
        L36:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
        L3b:
            int r2 = r0.getInt(r9)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            byte[] r3 = r0.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r4 = com.google.android.gms.internal.measurement.zzbr.zzi.zzi()     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzgn r3 = com.google.android.gms.measurement.internal.zzki.a(r4, r3)     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zzi.zza) r3     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzgo r3 = r3.zzu()     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.internal.measurement.zzbr$zzi r3 = (com.google.android.gms.internal.measurement.zzbr.zzi) r3     // Catch: java.io.IOException -> L5d android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            goto L73
        L5d:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzew r4 = r11.zzr()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzf()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzew.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            r4.zza(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
        L73:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7f java.lang.Throwable -> L9d
            if (r2 != 0) goto L3b
            if (r0 == 0) goto L7e
            r0.close()
        L7e:
            return r1
        L7f:
            r1 = move-exception
            goto L86
        L81:
            r12 = move-exception
            r0 = r8
            goto L9e
        L84:
            r1 = move-exception
            r0 = r8
        L86:
            com.google.android.gms.measurement.internal.zzew r2 = r11.zzr()     // Catch: java.lang.Throwable -> L9d
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzf()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzew.zza(r12)     // Catch: java.lang.Throwable -> L9d
            r2.zza(r3, r12, r1)     // Catch: java.lang.Throwable -> L9d
            if (r0 == 0) goto L9c
            r0.close()
        L9c:
            return r8
        L9d:
            r12 = move-exception
        L9e:
            if (r0 == 0) goto La3
            r0.close()
        La3:
            goto La5
        La4:
            throw r12
        La5:
            goto La4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.a(java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbj.zzb>> a(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.a()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r6[r10] = r13     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r6[r11] = r14     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbj.zzb.zzl()     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzgn r1 = com.google.android.gms.measurement.internal.zzki.a(r2, r1)     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbj.zzb.zza) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzgo r1 = r1.zzu()     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zzb r1 = (com.google.android.gms.internal.measurement.zzbj.zzb) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r3 != 0) goto L7a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
        L7a:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            goto L90
        L7e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzew r2 = r12.zzr()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzf()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzew.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
        L90:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r1 != 0) goto L48
            if (r14 == 0) goto L9b
            r14.close()
        L9b:
            return r0
        L9c:
            r0 = move-exception
            goto La3
        L9e:
            r13 = move-exception
            r14 = r9
            goto Lbb
        La1:
            r0 = move-exception
            r14 = r9
        La3:
            com.google.android.gms.measurement.internal.zzew r1 = r12.zzr()     // Catch: java.lang.Throwable -> Lba
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzf()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzew.zza(r13)     // Catch: java.lang.Throwable -> Lba
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lba
            if (r14 == 0) goto Lb9
            r14.close()
        Lb9:
            return r9
        Lba:
            r13 = move-exception
        Lbb:
            if (r14 == 0) goto Lc0
            r14.close()
        Lc0:
            goto Lc2
        Lc1:
            throw r13
        Lc2:
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.a(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> a(java.lang.String r14, java.util.List<java.lang.String> r15) {
        /*
            r13 = this;
            r13.zzak()
            r13.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            boolean r1 = r15.isEmpty()
            if (r1 == 0) goto L18
            return r0
        L18:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "app_id=? AND property_name in ("
            r1.append(r2)
            r2 = 0
            r3 = 0
        L24:
            int r4 = r15.size()
            if (r3 >= r4) goto L39
            if (r3 <= 0) goto L31
            java.lang.String r4 = ","
            r1.append(r4)
        L31:
            java.lang.String r4 = "?"
            r1.append(r4)
            int r3 = r3 + 1
            goto L24
        L39:
            java.lang.String r3 = ")"
            r1.append(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r15)
            r3.add(r2, r14)
            android.database.sqlite.SQLiteDatabase r4 = r13.a()
            r15 = 0
            java.lang.String r5 = "property_filters"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            java.lang.String r7 = "audience_id"
            r6[r2] = r7     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            java.lang.String r7 = "filter_id"
            r12 = 1
            r6[r12] = r7     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            java.lang.Object[] r1 = r3.toArray(r1)     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            r8 = r1
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lae android.database.sqlite.SQLiteException -> Lb1
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            if (r3 != 0) goto L79
            if (r1 == 0) goto L78
            r1.close()
        L78:
            return r0
        L79:
            int r3 = r1.getInt(r2)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            if (r4 != 0) goto L95
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
        L95:
            int r3 = r1.getInt(r12)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> Lac java.lang.Throwable -> Lca
            if (r3 != 0) goto L79
            if (r1 == 0) goto Lab
            r1.close()
        Lab:
            return r0
        Lac:
            r0 = move-exception
            goto Lb3
        Lae:
            r14 = move-exception
            r1 = r15
            goto Lcb
        Lb1:
            r0 = move-exception
            r1 = r15
        Lb3:
            com.google.android.gms.measurement.internal.zzew r2 = r13.zzr()     // Catch: java.lang.Throwable -> Lca
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzf()     // Catch: java.lang.Throwable -> Lca
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzew.zza(r14)     // Catch: java.lang.Throwable -> Lca
            r2.zza(r3, r14, r0)     // Catch: java.lang.Throwable -> Lca
            if (r1 == 0) goto Lc9
            r1.close()
        Lc9:
            return r15
        Lca:
            r14 = move-exception
        Lcb:
            if (r1 == 0) goto Ld0
            r1.close()
        Ld0:
            goto Ld2
        Ld1:
            throw r14
        Ld2:
            goto Ld1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.a(java.lang.String, java.util.List):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbj.zze>> b(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.a()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r6[r10] = r13     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r6[r11] = r14     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L9e android.database.sqlite.SQLiteException -> La1
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zze$zza r2 = com.google.android.gms.internal.measurement.zzbj.zze.zzi()     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzgn r1 = com.google.android.gms.measurement.internal.zzki.a(r2, r1)     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbj.zze.zza) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzgo r1 = r1.zzu()     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.internal.measurement.zzbj$zze r1 = (com.google.android.gms.internal.measurement.zzbj.zze) r1     // Catch: java.io.IOException -> L7e android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r3 != 0) goto L7a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
        L7a:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            goto L90
        L7e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzew r2 = r12.zzr()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzf()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzew.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
        L90:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L9c java.lang.Throwable -> Lba
            if (r1 != 0) goto L48
            if (r14 == 0) goto L9b
            r14.close()
        L9b:
            return r0
        L9c:
            r0 = move-exception
            goto La3
        L9e:
            r13 = move-exception
            r14 = r9
            goto Lbb
        La1:
            r0 = move-exception
            r14 = r9
        La3:
            com.google.android.gms.measurement.internal.zzew r1 = r12.zzr()     // Catch: java.lang.Throwable -> Lba
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzf()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzew.zza(r13)     // Catch: java.lang.Throwable -> Lba
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lba
            if (r14 == 0) goto Lb9
            r14.close()
        Lb9:
            return r9
        Lba:
            r13 = move-exception
        Lbb:
            if (r14 == 0) goto Lc0
            r14.close()
        Lc0:
            goto Lc2
        Lc1:
            throw r13
        Lc2:
            goto Lc1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.b(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x015f, code lost:
    
        r8.zza(r10, r11, r9);
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r18, java.util.List<com.google.android.gms.internal.measurement.zzbj.zza> r19) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.b(java.lang.String, java.util.List):void");
    }

    @WorkerThread
    public final void b_() {
        zzak();
        a().setTransactionSuccessful();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final long c(String str, String str2) {
        long j;
        ContentValues contentValues;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase a = a();
        a.beginTransaction();
        try {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
                sb.append("select ");
                sb.append(str2);
                sb.append(" from app2 where app_id=?");
                try {
                    j = zza(sb.toString(), new String[]{str}, -1L);
                    if (j == -1) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put("first_open_count", (Integer) 0);
                        contentValues2.put("previous_install_count", (Integer) 0);
                        if (a.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                            zzr().zzf().zza("Failed to insert column (got -1). appId", zzew.zza(str), str2);
                            a.endTransaction();
                            return -1L;
                        }
                        j = 0;
                    }
                    try {
                        contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put(str2, Long.valueOf(1 + j));
                    } catch (SQLiteException e) {
                        e = e;
                        zzr().zzf().zza("Error inserting column. appId", zzew.zza(str), str2, e);
                        a.endTransaction();
                        return j;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    j = 0;
                    zzr().zzf().zza("Error inserting column. appId", zzew.zza(str), str2, e);
                    a.endTransaction();
                    return j;
                }
            } catch (Throwable th) {
                th = th;
                a.endTransaction();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            a.endTransaction();
            throw th;
        }
        if (a.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
            zzr().zzf().zza("Failed to update column (got 0). appId", zzew.zza(str), str2);
            a.endTransaction();
            return -1L;
        }
        a.setTransactionSuccessful();
        a.endTransaction();
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.a()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzew r3 = r6.zzr()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzf()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.d_():java.lang.String");
    }

    public final long zza(zzbr.zzg zzgVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] zzbi = zzgVar.zzbi();
        long a = zzg().a(zzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(a));
        contentValues.put("metadata", zzbi);
        try {
            a().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return a;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzew.zza(zzgVar.zzx()), e);
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbr.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.a()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7c
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzew r8 = r7.zzr()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzx()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r4 = com.google.android.gms.internal.measurement.zzbr.zzc.zzj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzgn r2 = com.google.android.gms.measurement.internal.zzki.a(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzgo r2 = r2.zzu()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.internal.measurement.zzbr$zzc r2 = (com.google.android.gms.internal.measurement.zzbr.zzc) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzew r3 = r7.zzr()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzew.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L91
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7e
        L79:
            r8 = move-exception
            r1 = r0
            goto L92
        L7c:
            r8 = move-exception
            r1 = r0
        L7e:
            com.google.android.gms.measurement.internal.zzew r9 = r7.zzr()     // Catch: java.lang.Throwable -> L91
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzf()     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L90
            r1.close()
        L90:
            return r0
        L91:
            r8 = move-exception
        L92:
            if (r1 == 0) goto L97
            r1.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x012a  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzab zza(long r22, java.lang.String r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzab");
    }

    @WorkerThread
    public final zzaj zza(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Cursor query;
        Boolean bool;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        boolean zze2 = zzt().zze(str, zzap.zzbm);
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (zze2) {
            arrayList.add("current_session_count");
        }
        try {
            try {
                query = a().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                long j = query.getLong(0);
                long j2 = query.getLong(1);
                long j3 = query.getLong(2);
                long j4 = query.isNull(3) ? 0L : query.getLong(3);
                Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                Long valueOf3 = query.isNull(6) ? null : Long.valueOf(query.getLong(6));
                if (query.isNull(7)) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(query.getLong(7) == 1);
                }
                cursor2 = query;
                try {
                    zzaj zzajVar = new zzaj(str, str2, j, j2, (!zze2 || query.isNull(8)) ? 0L : query.getLong(8), j3, j4, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for event aggregates, expected one. appId", zzew.zza(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzajVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying events. appId", zzew.zza(str), zzo().zza(str2), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = query;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.a()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzew r6 = r4.zzr()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzx()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L45
        L40:
            r6 = move-exception
            r5 = r0
            goto L59
        L43:
            r6 = move-exception
            r5 = r0
        L45:
            com.google.android.gms.measurement.internal.zzew r1 = r4.zzr()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzf()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L57
            r5.close()
        L57:
            return r0
        L58:
            r6 = move-exception
        L59:
            if (r5 == 0) goto L5e
            r5.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(long):java.lang.String");
    }

    @WorkerThread
    public final List<zzkn> zza(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = a().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        try {
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                String str2 = string2;
                long j = cursor.getLong(2);
                try {
                    Object zza = zza(cursor, 3);
                    if (zza == null) {
                        zzr().zzf().zza("Read invalid user property value, ignoring it. appId", zzew.zza(str));
                    } else {
                        arrayList.add(new zzkn(str, str2, string, j, zza));
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzr().zzf().zza("Error querying user properties. appId", zzew.zza(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce A[EDGE_INSN: B:40:0x00ce->B:26:0x00ce BREAK  A[LOOP:0: B:17:0x005c->B:39:?], SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzbr.zzg, java.lang.Long>> zza(java.lang.String r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x009a, code lost:
    
        zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkn> zza(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzv> zza(java.lang.String r40, java.lang.String[] r41) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    @WorkerThread
    public final void zza(zzaj zzajVar) {
        Preconditions.checkNotNull(zzajVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzajVar.a);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzajVar.b);
        contentValues.put("lifetime_count", Long.valueOf(zzajVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(zzajVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzajVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzajVar.g));
        contentValues.put("last_bundled_day", zzajVar.h);
        contentValues.put("last_sampled_complex_event_id", zzajVar.i);
        contentValues.put("last_sampling_rate", zzajVar.j);
        if (zzt().zze(zzajVar.a, zzap.zzbm)) {
            contentValues.put("current_session_count", Long.valueOf(zzajVar.e));
        }
        Boolean bool = zzajVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (a().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzew.zza(zzajVar.a));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzew.zza(zzajVar.a), e);
        }
    }

    @WorkerThread
    public final void zza(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzc());
        contentValues.put("app_instance_id", zzgVar.zzd());
        contentValues.put("gmp_app_id", zzgVar.zze());
        contentValues.put("resettable_device_id_hash", zzgVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzk()));
        contentValues.put("app_version", zzgVar.zzl());
        contentValues.put("app_store", zzgVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzr()));
        contentValues.put("day", Long.valueOf(zzgVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzm()));
        contentValues.put("firebase_instance_id", zzgVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzaa()));
        contentValues.put("health_monitor_sample", zzgVar.zzac());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzgVar.zzag()));
        contentValues.put("admob_app_id", zzgVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzq()));
        if (zzgVar.zzai() != null) {
            if (zzgVar.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzgVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzgVar.zzai()));
            }
        }
        if (zzle.zzb() && zzt().zze(zzgVar.zzc(), zzap.zzcc)) {
            contentValues.put("ga_app_id", zzgVar.zzg());
        }
        try {
            SQLiteDatabase a = a();
            if (a.update("apps", contentValues, "app_id = ?", new String[]{zzgVar.zzc()}) == 0 && a.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzew.zza(zzgVar.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzew.zza(zzgVar.zzc()), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase a = a();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                a.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    public final boolean zza(zzbr.zzg zzgVar, boolean z) {
        zzey zzf2;
        Object zza;
        String str;
        ContentValues contentValues;
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzgVar.zzl() < currentTimeMillis - zzx.zzj() || zzgVar.zzl() > zzx.zzj() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzew.zza(zzgVar.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] c = zzg().c(zzgVar.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(c.length));
            contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", c);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
        } catch (IOException e) {
            e = e;
            zzf2 = zzr().zzf();
            zza = zzew.zza(zzgVar.zzx());
            str = "Data loss. Failed to serialize bundle. appId";
        }
        try {
            if (a().insert("queue", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzew.zza(zzgVar.zzx()));
            return false;
        } catch (SQLiteException e2) {
            e = e2;
            zzf2 = zzr().zzf();
            zza = zzew.zza(zzgVar.zzx());
            str = "Error storing bundle. appId";
            zzf2.zza(str, zza, e);
            return false;
        }
    }

    public final boolean zza(zzak zzakVar, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzakVar);
        Preconditions.checkNotEmpty(zzakVar.a);
        zzbr.zzc.zza zzb2 = zzbr.zzc.zzj().zzb(zzakVar.d);
        Iterator<String> it = zzakVar.e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbr.zze.zza zza = zzbr.zze.zzh().zza(next);
            zzg().a(zza, zzakVar.e.zza(next));
            zzb2.zza(zza);
        }
        byte[] zzbi = ((zzbr.zzc) zzb2.zzu()).zzbi();
        zzr().zzx().zza("Saving event, name, data size", zzo().zza(zzakVar.b), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzakVar.a);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzakVar.b);
        contentValues.put("timestamp", Long.valueOf(zzakVar.c));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (a().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzew.zza(zzakVar.a));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzew.zza(zzakVar.a), e);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzkn zzknVar) {
        Preconditions.checkNotNull(zzknVar);
        zzd();
        zzak();
        if (zzc(zzknVar.a, zzknVar.c) == null) {
            if (zzkm.zza(zzknVar.c)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzknVar.a}) >= 25) {
                    return false;
                }
            } else if (zzt().zze(zzknVar.a, zzap.zzba)) {
                if (!"_npa".equals(zzknVar.c) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzknVar.a, zzknVar.b}) >= 25) {
                    return false;
                }
            } else if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzknVar.a, zzknVar.b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzknVar.a);
        contentValues.put("origin", zzknVar.b);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzknVar.c);
        contentValues.put("set_timestamp", Long.valueOf(zzknVar.d));
        zza(contentValues, "value", zzknVar.e);
        try {
            if (a().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzew.zza(zzknVar.a));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzew.zza(zzknVar.a), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzv zzvVar) {
        Preconditions.checkNotNull(zzvVar);
        zzd();
        zzak();
        if (zzc(zzvVar.zza, zzvVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzvVar.zza}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzvVar.zza);
        contentValues.put("origin", zzvVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzvVar.zzc.zza);
        zza(contentValues, "value", zzvVar.zzc.zza());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzvVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzvVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzvVar.zzh));
        zzp();
        contentValues.put("timed_out_event", zzkm.a((Parcelable) zzvVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzvVar.zzd));
        zzp();
        contentValues.put("triggered_event", zzkm.a((Parcelable) zzvVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzvVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzvVar.zzj));
        zzp();
        contentValues.put("expired_event", zzkm.a((Parcelable) zzvVar.zzk));
        try {
            if (a().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzew.zza(zzvVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzew.zza(zzvVar.zza), e);
        }
        return true;
    }

    public final boolean zza(String str, Long l, long j, zzbr.zzc zzcVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbi = zzcVar.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbi);
        try {
            if (a().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzew.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzew.zza(str), e);
            return false;
        }
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            try {
                cursor = a().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error querying raw events", e);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f2 A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x021f A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0237 A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0255 A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TRY_LEAVE, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0210 A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ce A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0197 A[Catch: SQLiteException -> 0x026c, all -> 0x0296, TryCatch #0 {all -> 0x0296, blocks: (B:15:0x00eb, B:17:0x0148, B:21:0x0152, B:24:0x019c, B:27:0x01d2, B:29:0x01dd, B:33:0x01e7, B:35:0x01f2, B:37:0x01f9, B:40:0x0214, B:42:0x021f, B:43:0x0231, B:45:0x0237, B:47:0x0243, B:48:0x024c, B:50:0x0255, B:55:0x0210, B:58:0x01ce, B:59:0x0197, B:62:0x027f), top: B:2:0x000c }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzg zzb(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 669
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    @WorkerThread
    public final List<zzv> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @WorkerThread
    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            zzr().zzx().zza("Deleted user attribute rows", Integer.valueOf(a().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user attribute. appId", zzew.zza(str), zzo().zzc(str2), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return a().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzap.zzp))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzew.zza(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzkn zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.a()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r1] = r19     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r2] = r8     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            if (r0 != 0) goto L44
            if (r10 == 0) goto L43
            r10.close()
        L43:
            return r9
        L44:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzkn r0 = new com.google.android.gms.measurement.internal.zzkn     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            if (r1 == 0) goto L73
            com.google.android.gms.measurement.internal.zzew r1 = r18.zzr()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzf()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzew.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
        L73:
            if (r10 == 0) goto L78
            r10.close()
        L78:
            return r0
        L79:
            r0 = move-exception
            goto L8c
        L7b:
            r0 = move-exception
            r11 = r18
            goto Lac
        L7f:
            r0 = move-exception
            r11 = r18
            goto L8c
        L83:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto Lac
        L88:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8c:
            com.google.android.gms.measurement.internal.zzew r1 = r18.zzr()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzf()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzew.zza(r19)     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzeu r4 = r18.zzo()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> Lab
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lab
            if (r10 == 0) goto Laa
            r10.close()
        Laa:
            return r9
        Lab:
            r0 = move-exception
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkn");
    }

    @WorkerThread
    public final zzv zzd(String str, String str2) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            try {
                cursor = a().query("conditional_properties", new String[]{"origin", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object zza = zza(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    zzv zzvVar = new zzv(str, string, new zzkl(str2, cursor.getLong(8), zza, string), cursor.getLong(6), z, cursor.getString(3), (zzan) zzg().a(cursor.getBlob(5), zzan.CREATOR), cursor.getLong(4), (zzan) zzg().a(cursor.getBlob(7), zzan.CREATOR), cursor.getLong(9), (zzan) zzg().a(cursor.getBlob(10), zzan.CREATOR));
                    if (cursor.moveToNext()) {
                        zzr().zzf().zza("Got multiple records for conditional property, expected one", zzew.zza(str), zzo().zzc(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzvVar;
                } catch (SQLiteException e) {
                    e = e;
                    zzr().zzf().zza("Error querying conditional property", zzew.zza(str), zzo().zzc(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] zzd(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzd()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.a()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r6[r9] = r12     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r2 != 0) goto L37
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r3 == 0) goto L52
            com.google.android.gms.measurement.internal.zzew r3 = r11.zzr()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzew.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            return r2
        L58:
            r2 = move-exception
            goto L5f
        L5a:
            r12 = move-exception
            r1 = r0
            goto L77
        L5d:
            r2 = move-exception
            r1 = r0
        L5f:
            com.google.android.gms.measurement.internal.zzew r3 = r11.zzr()     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzf()     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzew.zza(r12)     // Catch: java.lang.Throwable -> L76
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L75
            r1.close()
        L75:
            return r0
        L76:
            r12 = move-exception
        L77:
            if (r1 == 0) goto L7c
            r1.close()
        L7c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zzd(java.lang.String):byte[]");
    }

    @WorkerThread
    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return a().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzew.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zze(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.a()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6c
        L67:
            r8 = move-exception
            r1 = r2
            goto L84
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            com.google.android.gms.measurement.internal.zzew r3 = r7.zzr()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzf()     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzew.zza(r8)     // Catch: java.lang.Throwable -> L83
            r3.zza(r4, r8, r0)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r2
        L83:
            r8 = move-exception
        L84:
            if (r1 == 0) goto L89
            r1.close()
        L89:
            goto L8b
        L8a:
            throw r8
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zze(java.lang.String):java.util.Map");
    }

    @Override // com.google.android.gms.measurement.internal.zzkb
    protected final boolean zze() {
        return false;
    }

    @WorkerThread
    public final void zzf() {
        zzak();
        a().beginTransaction();
    }

    public final long zzg(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    @WorkerThread
    public final void zzh() {
        zzak();
        a().endTransaction();
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzap.zzy.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (!zzam() || (delete = a().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzx.zzj())})) <= 0) {
                    return;
                }
                zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    @WorkerThread
    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    @WorkerThread
    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }
}
