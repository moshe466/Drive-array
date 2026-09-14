package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.m0;
import com.google.android.gms.internal.measurement.md;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends b9 {

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f6031f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f6032g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f6033h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f6034i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f6035j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f6036k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l, reason: collision with root package name */
    private static final String[] f6037l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f6038m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d, reason: collision with root package name */
    private final g f6039d;

    /* renamed from: e, reason: collision with root package name */
    private final x8 f6040e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e9 e9Var) {
        super(e9Var);
        this.f6040e = new x8(f());
        this.f6039d = new g(this, i(), "google_app_measurement.db");
    }

    private final long C(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            try {
                cursor = y().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return j10;
                }
                long j11 = cursor.getLong(0);
                cursor.close();
                return j11;
            } catch (SQLiteException e10) {
                h().F().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Object I(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            h().F().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            h().F().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        h().F().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    private final String K(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = y().rawQuery(str, strArr);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return str2;
                }
                String string = cursor.getString(0);
                cursor.close();
                return string;
            } catch (SQLiteException e10) {
                h().F().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static void P(ContentValues contentValues, String str, Object obj) {
        b2.p.g(str);
        b2.p.k(obj);
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

    private final boolean Y(String str, int i10, com.google.android.gms.internal.measurement.m0 m0Var) {
        u();
        c();
        b2.p.g(str);
        b2.p.k(m0Var);
        if (TextUtils.isEmpty(m0Var.I())) {
            h().I().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r3.x(str), Integer.valueOf(i10), String.valueOf(m0Var.F() ? Integer.valueOf(m0Var.G()) : null));
            return false;
        }
        byte[] f10 = m0Var.f();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", m0Var.F() ? Integer.valueOf(m0Var.G()) : null);
        contentValues.put("event_name", m0Var.I());
        contentValues.put("session_scoped", m0Var.R() ? Boolean.valueOf(m0Var.S()) : null);
        contentValues.put("data", f10);
        try {
            if (y().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().F().b("Failed to insert event filter (got -1). appId", r3.x(str));
            return true;
        } catch (SQLiteException e10) {
            h().F().c("Error storing event filter. appId", r3.x(str), e10);
            return false;
        }
    }

    private final boolean Z(String str, int i10, com.google.android.gms.internal.measurement.p0 p0Var) {
        u();
        c();
        b2.p.g(str);
        b2.p.k(p0Var);
        if (TextUtils.isEmpty(p0Var.E())) {
            h().I().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r3.x(str), Integer.valueOf(i10), String.valueOf(p0Var.C() ? Integer.valueOf(p0Var.D()) : null));
            return false;
        }
        byte[] f10 = p0Var.f();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", p0Var.C() ? Integer.valueOf(p0Var.D()) : null);
        contentValues.put("property_name", p0Var.E());
        contentValues.put("session_scoped", p0Var.J() ? Boolean.valueOf(p0Var.K()) : null);
        contentValues.put("data", f10);
        try {
            if (y().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().F().b("Failed to insert property filter (got -1). appId", r3.x(str));
            return false;
        } catch (SQLiteException e10) {
            h().F().c("Error storing property filter. appId", r3.x(str), e10);
            return false;
        }
    }

    private final boolean k0() {
        return i().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long l0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = y().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j10 = rawQuery.getLong(0);
                rawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                h().F().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean p0(String str, List<Integer> list) {
        b2.p.g(str);
        u();
        c();
        SQLiteDatabase y10 = y();
        try {
            long l02 = l0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, m().v(str, s.F)));
            if (l02 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Integer num = list.get(i10);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb2 = new StringBuilder(String.valueOf(join).length() + 2);
            sb2.append("(");
            sb2.append(join);
            sb2.append(")");
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 140);
            sb4.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb4.append(sb3);
            sb4.append(" order by rowid desc limit -1 offset ?)");
            return y10.delete("audience_filter_values", sb4.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e10) {
            h().F().c("Database error querying filters. appId", r3.x(str), e10);
            return false;
        }
    }

    public final boolean A() {
        return l0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.p0>> A0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.u()
            r12.c()
            b2.p.g(r13)
            b2.p.g(r14)
            l.a r0 = new l.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.y()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 != 0) goto L40
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r14.close()
            return r13
        L40:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.p0$a r2 = com.google.android.gms.internal.measurement.p0.L()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.x8 r1 = com.google.android.gms.measurement.internal.k9.C(r2, r1)     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.p0$a r1 = (com.google.android.gms.internal.measurement.p0.a) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.y8 r1 = r1.g()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.l7 r1 = (com.google.android.gms.internal.measurement.l7) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.p0 r1 = (com.google.android.gms.internal.measurement.p0) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r3 != 0) goto L72
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L72:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            goto L88
        L76:
            r1 = move-exception
            com.google.android.gms.measurement.internal.r3 r2 = r12.h()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r2 = r2.F()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r2.c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L88:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 != 0) goto L40
            r14.close()
            return r0
        L92:
            r0 = move-exception
            goto L98
        L94:
            r13 = move-exception
            goto Lcd
        L96:
            r0 = move-exception
            r14 = r9
        L98:
            com.google.android.gms.measurement.internal.r3 r1 = r12.h()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r1 = r1.F()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: java.lang.Throwable -> Lcb
            r1.c(r2, r3, r0)     // Catch: java.lang.Throwable -> Lcb
            boolean r0 = com.google.android.gms.internal.measurement.uc.a()     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lc5
            com.google.android.gms.measurement.internal.c r0 = r12.m()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.s.F0     // Catch: java.lang.Throwable -> Lcb
            boolean r13 = r0.D(r13, r1)     // Catch: java.lang.Throwable -> Lcb
            if (r13 == 0) goto Lc5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Lcb
            if (r14 == 0) goto Lc4
            r14.close()
        Lc4:
            return r13
        Lc5:
            if (r14 == 0) goto Lca
            r14.close()
        Lca:
            return r9
        Lcb:
            r13 = move-exception
            r9 = r14
        Lcd:
            if (r9 == 0) goto Ld2
            r9.close()
        Ld2:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.A0(java.lang.String, java.lang.String):java.util.Map");
    }

    public final long B(com.google.android.gms.internal.measurement.h1 h1Var) {
        c();
        u();
        b2.p.k(h1Var);
        b2.p.g(h1Var.X2());
        byte[] f10 = h1Var.f();
        long y10 = o().y(f10);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", h1Var.X2());
        contentValues.put("metadata_fingerprint", Long.valueOf(y10));
        contentValues.put("metadata", f10);
        try {
            y().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return y10;
        } catch (SQLiteException e10) {
            h().F().c("Error storing raw event metadata. appId", r3.x(h1Var.X2()), e10);
            throw e10;
        }
    }

    public final void B0() {
        u();
        y().endTransaction();
    }

    public final long C0(String str) {
        b2.p.g(str);
        return C("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.d1, java.lang.Long> D(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.c()
            r7.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.y()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.r3 r8 = r7.h()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.t3 r8 = r8.N()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r9 = "Main event not found"
            r8.a(r9)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L35:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.d1$a r4 = com.google.android.gms.internal.measurement.d1.c0()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.x8 r2 = com.google.android.gms.measurement.internal.k9.C(r4, r2)     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.d1$a r2 = (com.google.android.gms.internal.measurement.d1.a) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.y8 r2 = r2.g()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.l7 r2 = (com.google.android.gms.internal.measurement.l7) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.d1 r2 = (com.google.android.gms.internal.measurement.d1) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r8
        L5b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.r3 r3 = r7.h()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.r3.x(r8)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r3.d(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L71:
            r8 = move-exception
            goto L77
        L73:
            r8 = move-exception
            goto L8c
        L75:
            r8 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.r3 r9 = r7.h()     // Catch: java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.t3 r9 = r9.F()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = "Error selecting main event"
            r9.b(r2, r8)     // Catch: java.lang.Throwable -> L8a
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            r8 = move-exception
            r0 = r1
        L8c:
            if (r0 == 0) goto L91
            r0.close()
        L91:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.D(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long D0(String str, String str2) {
        long C;
        b2.p.g(str);
        b2.p.g(str2);
        c();
        u();
        SQLiteDatabase y10 = y();
        y10.beginTransaction();
        long j10 = 0;
        try {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 32);
            sb2.append("select ");
            sb2.append(str2);
            sb2.append(" from app2 where app_id=?");
            try {
                try {
                    C = C(sb2.toString(), new String[]{str}, -1L);
                    if (C == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (y10.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            h().F().c("Failed to insert column (got -1). appId", r3.x(str), str2);
                            y10.endTransaction();
                            return -1L;
                        }
                        C = 0;
                    }
                } catch (SQLiteException e10) {
                    e = e10;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + C));
                    if (y10.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        h().F().c("Failed to update column (got 0). appId", r3.x(str), str2);
                        y10.endTransaction();
                        return -1L;
                    }
                    y10.setTransactionSuccessful();
                    y10.endTransaction();
                    return C;
                } catch (SQLiteException e11) {
                    e = e11;
                    j10 = C;
                    h().F().d("Error inserting column. appId", r3.x(str), str2, e);
                    y10.endTransaction();
                    return j10;
                }
            } catch (Throwable th) {
                th = th;
                y10.endTransaction();
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final e E(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        b2.p.g(str);
        c();
        u();
        String[] strArr = {str};
        e eVar = new e();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase y10 = y();
                Cursor query = y10.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    h().I().b("Not updating daily counts, app is not known. appId", r3.x(str));
                    query.close();
                    return eVar;
                }
                if (query.getLong(0) == j10) {
                    eVar.f5948b = query.getLong(1);
                    eVar.f5947a = query.getLong(2);
                    eVar.f5949c = query.getLong(3);
                    eVar.f5950d = query.getLong(4);
                    eVar.f5951e = query.getLong(5);
                }
                if (z10) {
                    eVar.f5948b += j11;
                }
                if (z11) {
                    eVar.f5947a += j11;
                }
                if (z12) {
                    eVar.f5949c += j11;
                }
                if (z13) {
                    eVar.f5950d += j11;
                }
                if (z14) {
                    eVar.f5951e += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(eVar.f5947a));
                contentValues.put("daily_events_count", Long.valueOf(eVar.f5948b));
                contentValues.put("daily_conversions_count", Long.valueOf(eVar.f5949c));
                contentValues.put("daily_error_events_count", Long.valueOf(eVar.f5950d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(eVar.f5951e));
                y10.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return eVar;
            } catch (SQLiteException e10) {
                h().F().c("Error updating daily counts. appId", r3.x(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return eVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d0: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:57:0x00d0 */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle E0(java.lang.String r8) {
        /*
            r7 = this;
            r7.c()
            r7.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.y()     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lba
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r2 != 0) goto L2e
            com.google.android.gms.measurement.internal.r3 r8 = r7.h()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.t3 r8 = r8.N()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            java.lang.String r2 = "Default event parameters not found"
            r8.a(r2)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r1.close()
            return r0
        L2e:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.d1$a r3 = com.google.android.gms.internal.measurement.d1.c0()     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.x8 r2 = com.google.android.gms.measurement.internal.k9.C(r3, r2)     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.d1$a r2 = (com.google.android.gms.internal.measurement.d1.a) r2     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.y8 r2 = r2.g()     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.l7 r2 = (com.google.android.gms.internal.measurement.l7) r2     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.d1 r2 = (com.google.android.gms.internal.measurement.d1) r2     // Catch: java.io.IOException -> La0 android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r7.o()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            java.util.List r8 = r2.B()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            android.os.Bundle r2 = new android.os.Bundle     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            java.util.Iterator r8 = r8.iterator()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
        L54:
            boolean r3 = r8.hasNext()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r3 == 0) goto L9c
            java.lang.Object r3 = r8.next()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.f1 r3 = (com.google.android.gms.internal.measurement.f1) r3     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            java.lang.String r4 = r3.O()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            boolean r5 = r3.b0()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r5 == 0) goto L72
            double r5 = r3.c0()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r2.putDouble(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            goto L54
        L72:
            boolean r5 = r3.Z()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r5 == 0) goto L80
            float r3 = r3.a0()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r2.putFloat(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            goto L54
        L80:
            boolean r5 = r3.T()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r5 == 0) goto L8e
            java.lang.String r3 = r3.U()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r2.putString(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            goto L54
        L8e:
            boolean r5 = r3.X()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            if (r5 == 0) goto L54
            long r5 = r3.Y()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r2.putLong(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            goto L54
        L9c:
            r1.close()
            return r2
        La0:
            r2 = move-exception
            com.google.android.gms.measurement.internal.r3 r3 = r7.h()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.r3.x(r8)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r3.c(r4, r8, r2)     // Catch: android.database.sqlite.SQLiteException -> Lb6 java.lang.Throwable -> Lcf
            r1.close()
            return r0
        Lb6:
            r8 = move-exception
            goto Lbc
        Lb8:
            r8 = move-exception
            goto Ld1
        Lba:
            r8 = move-exception
            r1 = r0
        Lbc:
            com.google.android.gms.measurement.internal.r3 r2 = r7.h()     // Catch: java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.t3 r2 = r2.F()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "Error selecting default event parameters"
            r2.b(r3, r8)     // Catch: java.lang.Throwable -> Lcf
            if (r1 == 0) goto Lce
            r1.close()
        Lce:
            return r0
        Lcf:
            r8 = move-exception
            r0 = r1
        Ld1:
            if (r0 == 0) goto Ld6
            r0.close()
        Ld6:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.E0(java.lang.String):android.os.Bundle");
    }

    public final e F(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return E(j10, str, 1L, false, false, z12, false, z14);
    }

    public final v2.a F0(String str) {
        b2.p.k(str);
        c();
        u();
        return v2.a.f(K("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:69:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.m G(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.G(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.m");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G0() {
        int delete;
        c();
        u();
        if (k0()) {
            long a10 = l().f5961h.a();
            long b10 = f().b();
            if (Math.abs(b10 - a10) > s.f6440y.a(null).longValue()) {
                l().f5961h.b(b10);
                c();
                u();
                if (!k0() || (delete = y().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(f().a()), String.valueOf(c.P())})) <= 0) {
                    return;
                }
                h().N().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final long H0() {
        return C("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long I0() {
        return C("select max(timestamp) from raw_events", null, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String J(long r5) {
        /*
            r4 = this;
            r4.c()
            r4.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.y()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            if (r1 != 0) goto L32
            com.google.android.gms.measurement.internal.r3 r6 = r4.h()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.t3 r6 = r6.N()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r0
        L32:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r6
        L3a:
            r6 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L55
        L3e:
            r6 = move-exception
            r5 = r0
        L40:
            com.google.android.gms.measurement.internal.r3 r1 = r4.h()     // Catch: java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.t3 r1 = r1.F()     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "Error selecting expired configs"
            r1.b(r2, r6)     // Catch: java.lang.Throwable -> L53
            if (r5 == 0) goto L52
            r5.close()
        L52:
            return r0
        L53:
            r6 = move-exception
            r0 = r5
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.J(long):java.lang.String");
    }

    public final boolean J0() {
        return l0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean K0() {
        return l0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b6: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x00b6 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.p9> L(java.lang.String r14) {
        /*
            r13 = this;
            b2.p.g(r14)
            r13.c()
            r13.u()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.y()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            if (r3 != 0) goto L3d
            r2.close()
            return r0
        L3d:
            java.lang.String r7 = r2.getString(r12)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            if (r3 != 0) goto L49
            java.lang.String r3 = ""
        L49:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            r3 = 3
            java.lang.Object r10 = r13.I(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            if (r10 != 0) goto L68
            com.google.android.gms.measurement.internal.r3 r3 = r13.h()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.r3.x(r14)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            r3.b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            goto L72
        L68:
            com.google.android.gms.measurement.internal.p9 r3 = new com.google.android.gms.measurement.internal.p9     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
        L72:
            boolean r3 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> Lb5
            if (r3 != 0) goto L3d
            r2.close()
            return r0
        L7c:
            r0 = move-exception
            goto L82
        L7e:
            r14 = move-exception
            goto Lb7
        L80:
            r0 = move-exception
            r2 = r1
        L82:
            com.google.android.gms.measurement.internal.r3 r3 = r13.h()     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.r3.x(r14)     // Catch: java.lang.Throwable -> Lb5
            r3.c(r4, r5, r0)     // Catch: java.lang.Throwable -> Lb5
            boolean r0 = com.google.android.gms.internal.measurement.uc.a()     // Catch: java.lang.Throwable -> Lb5
            if (r0 == 0) goto Laf
            com.google.android.gms.measurement.internal.c r0 = r13.m()     // Catch: java.lang.Throwable -> Lb5
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.s.F0     // Catch: java.lang.Throwable -> Lb5
            boolean r14 = r0.D(r14, r3)     // Catch: java.lang.Throwable -> Lb5
            if (r14 == 0) goto Laf
            java.util.List r14 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lb5
            if (r2 == 0) goto Lae
            r2.close()
        Lae:
            return r14
        Laf:
            if (r2 == 0) goto Lb4
            r2.close()
        Lb4:
            return r1
        Lb5:
            r14 = move-exception
            r1 = r2
        Lb7:
            if (r1 == 0) goto Lbc
            r1.close()
        Lbc:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.L(java.lang.String):java.util.List");
    }

    public final long L0() {
        Cursor cursor = null;
        try {
            try {
                cursor = y().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            } catch (SQLiteException e10) {
                h().F().b("Error querying raw events", e10);
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5 A[EDGE_INSN: B:39:0x00c5->B:25:0x00c5 BREAK  A[LOOP:0: B:16:0x0052->B:38:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.h1, java.lang.Long>> M(java.lang.String r13, int r14, int r15) {
        /*
            r12 = this;
            r12.c()
            r12.u()
            r0 = 1
            r1 = 0
            if (r14 <= 0) goto Lc
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            b2.p.a(r2)
            if (r15 <= 0) goto L14
            r2 = 1
            goto L15
        L14:
            r2 = 0
        L15:
            b2.p.a(r2)
            b2.p.g(r13)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.y()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            java.lang.String r4 = "queue"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "data"
            java.lang.String r7 = "retry_count"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7}     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r7[r1] = r13     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r8 = 0
            r9 = 0
            java.lang.String r10 = "rowid"
            java.lang.String r11 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            boolean r14 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            if (r14 != 0) goto L4c
            java.util.List r13 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r2.close()
            return r13
        L4c:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r14.<init>()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r3 = 0
        L52:
            long r4 = r2.getLong(r1)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            byte[] r6 = r2.getBlob(r0)     // Catch: java.io.IOException -> Lad java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.measurement.internal.k9 r7 = r12.o()     // Catch: java.io.IOException -> Lad java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            byte[] r6 = r7.Y(r6)     // Catch: java.io.IOException -> Lad java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            boolean r7 = r14.isEmpty()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            if (r7 != 0) goto L6c
            int r7 = r6.length     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            int r7 = r7 + r3
            if (r7 > r15) goto Lc5
        L6c:
            com.google.android.gms.internal.measurement.h1$a r7 = com.google.android.gms.internal.measurement.h1.S0()     // Catch: java.io.IOException -> L9a java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.internal.measurement.x8 r7 = com.google.android.gms.measurement.internal.k9.C(r7, r6)     // Catch: java.io.IOException -> L9a java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.internal.measurement.h1$a r7 = (com.google.android.gms.internal.measurement.h1.a) r7     // Catch: java.io.IOException -> L9a java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r8 = 2
            boolean r9 = r2.isNull(r8)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            if (r9 != 0) goto L84
            int r8 = r2.getInt(r8)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r7.s0(r8)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
        L84:
            int r6 = r6.length     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            int r3 = r3 + r6
            com.google.android.gms.internal.measurement.y8 r6 = r7.g()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.internal.measurement.l7 r6 = (com.google.android.gms.internal.measurement.l7) r6     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.internal.measurement.h1 r6 = (com.google.android.gms.internal.measurement.h1) r6     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            android.util.Pair r4 = android.util.Pair.create(r6, r4)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            r14.add(r4)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            goto Lbd
        L9a:
            r4 = move-exception
            com.google.android.gms.measurement.internal.r3 r5 = r12.h()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.measurement.internal.t3 r5 = r5.F()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            java.lang.String r6 = "Failed to merge queued bundle. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
        La9:
            r5.c(r6, r7, r4)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            goto Lbd
        Lad:
            r4 = move-exception
            com.google.android.gms.measurement.internal.r3 r5 = r12.h()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            com.google.android.gms.measurement.internal.t3 r5 = r5.F()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            java.lang.String r6 = "Failed to unzip queued bundle. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            goto La9
        Lbd:
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lc9 android.database.sqlite.SQLiteException -> Lcb
            if (r4 == 0) goto Lc5
            if (r3 <= r15) goto L52
        Lc5:
            r2.close()
            return r14
        Lc9:
            r13 = move-exception
            goto Le7
        Lcb:
            r14 = move-exception
            com.google.android.gms.measurement.internal.r3 r15 = r12.h()     // Catch: java.lang.Throwable -> Lc9
            com.google.android.gms.measurement.internal.t3 r15 = r15.F()     // Catch: java.lang.Throwable -> Lc9
            java.lang.String r0 = "Error querying bundles. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: java.lang.Throwable -> Lc9
            r15.c(r0, r13, r14)     // Catch: java.lang.Throwable -> Lc9
            java.util.List r13 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lc9
            if (r2 == 0) goto Le6
            r2.close()
        Le6:
            return r13
        Le7:
            if (r2 == 0) goto Lec
            r2.close()
        Lec:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.M(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x008d, code lost:
    
        h().F().b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.p9> N(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.N(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        h().F().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.ha> O(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.O(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void Q(m mVar) {
        b2.p.k(mVar);
        c();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", mVar.f6207a);
        contentValues.put("name", mVar.f6208b);
        contentValues.put("lifetime_count", Long.valueOf(mVar.f6209c));
        contentValues.put("current_bundle_count", Long.valueOf(mVar.f6210d));
        contentValues.put("last_fire_timestamp", Long.valueOf(mVar.f6212f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(mVar.f6213g));
        contentValues.put("last_bundled_day", mVar.f6214h);
        contentValues.put("last_sampled_complex_event_id", mVar.f6215i);
        contentValues.put("last_sampling_rate", mVar.f6216j);
        contentValues.put("current_session_count", Long.valueOf(mVar.f6211e));
        Boolean bool = mVar.f6217k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (y().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                h().F().b("Failed to insert/update event aggregates (got -1). appId", r3.x(mVar.f6207a));
            }
        } catch (SQLiteException e10) {
            h().F().c("Error storing event aggregates. appId", r3.x(mVar.f6207a), e10);
        }
    }

    public final void R(b4 b4Var) {
        b2.p.k(b4Var);
        c();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", b4Var.t());
        contentValues.put("app_instance_id", b4Var.x());
        contentValues.put("gmp_app_id", b4Var.A());
        contentValues.put("resettable_device_id_hash", b4Var.J());
        contentValues.put("last_bundle_index", Long.valueOf(b4Var.f0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(b4Var.P()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(b4Var.R()));
        contentValues.put("app_version", b4Var.T());
        contentValues.put("app_store", b4Var.X());
        contentValues.put("gmp_version", Long.valueOf(b4Var.Z()));
        contentValues.put("dev_cert_hash", Long.valueOf(b4Var.b0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(b4Var.e0()));
        contentValues.put("day", Long.valueOf(b4Var.j0()));
        contentValues.put("daily_public_events_count", Long.valueOf(b4Var.k0()));
        contentValues.put("daily_events_count", Long.valueOf(b4Var.l0()));
        contentValues.put("daily_conversions_count", Long.valueOf(b4Var.m0()));
        contentValues.put("config_fetched_time", Long.valueOf(b4Var.g0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(b4Var.h0()));
        contentValues.put("app_version_int", Long.valueOf(b4Var.V()));
        contentValues.put("firebase_instance_id", b4Var.M());
        contentValues.put("daily_error_events_count", Long.valueOf(b4Var.h()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(b4Var.g()));
        contentValues.put("health_monitor_sample", b4Var.i());
        contentValues.put("android_id", Long.valueOf(b4Var.k()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(b4Var.l()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(b4Var.m()));
        contentValues.put("admob_app_id", b4Var.D());
        contentValues.put("dynamite_version", Long.valueOf(b4Var.d0()));
        if (b4Var.o() != null) {
            if (b4Var.o().size() == 0) {
                h().I().b("Safelisted events should not be an empty list. appId", b4Var.t());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", b4Var.o()));
            }
        }
        if (md.a() && m().D(b4Var.t(), s.f6411j0)) {
            contentValues.put("ga_app_id", b4Var.G());
        }
        try {
            SQLiteDatabase y10 = y();
            if (y10.update("apps", contentValues, "app_id = ?", new String[]{b4Var.t()}) == 0 && y10.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                h().F().b("Failed to insert/update app (got -1). appId", r3.x(b4Var.t()));
            }
        } catch (SQLiteException e10) {
            h().F().c("Error storing app. appId", r3.x(b4Var.t()), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0164, code lost:
    
        r8.c(r10, r11, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(java.lang.String r18, java.util.List<com.google.android.gms.internal.measurement.l0> r19) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.S(java.lang.String, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(List<Long> list) {
        c();
        u();
        b2.p.k(list);
        b2.p.m(list.size());
        if (k0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb2 = new StringBuilder(String.valueOf(join).length() + 2);
            sb2.append("(");
            sb2.append(join);
            sb2.append(")");
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 80);
            sb4.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb4.append(sb3);
            sb4.append(" AND retry_count =  2147483647 LIMIT 1");
            if (l0(sb4.toString(), null) > 0) {
                h().I().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase y10 = y();
                StringBuilder sb5 = new StringBuilder(String.valueOf(sb3).length() + 127);
                sb5.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb5.append(sb3);
                sb5.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                y10.execSQL(sb5.toString());
            } catch (SQLiteException e10) {
                h().F().b("Error incrementing retry count. error", e10);
            }
        }
    }

    public final boolean U(com.google.android.gms.internal.measurement.h1 h1Var, boolean z10) {
        t3 F;
        Object x10;
        String str;
        ContentValues contentValues;
        c();
        u();
        b2.p.k(h1Var);
        b2.p.g(h1Var.X2());
        b2.p.n(h1Var.w2());
        G0();
        long a10 = f().a();
        if (h1Var.x2() < a10 - c.P() || h1Var.x2() > c.P() + a10) {
            h().I().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", r3.x(h1Var.X2()), Long.valueOf(a10), Long.valueOf(h1Var.x2()));
        }
        try {
            byte[] Z = o().Z(h1Var.f());
            h().N().b("Saving bundle, size", Integer.valueOf(Z.length));
            contentValues = new ContentValues();
            contentValues.put("app_id", h1Var.X2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(h1Var.x2()));
            contentValues.put("data", Z);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (h1Var.y0()) {
                contentValues.put("retry_count", Integer.valueOf(h1Var.L0()));
            }
        } catch (IOException e10) {
            e = e10;
            F = h().F();
            x10 = r3.x(h1Var.X2());
            str = "Data loss. Failed to serialize bundle. appId";
        }
        try {
            if (y().insert("queue", null, contentValues) != -1) {
                return true;
            }
            h().F().b("Failed to insert bundle (got -1). appId", r3.x(h1Var.X2()));
            return false;
        } catch (SQLiteException e11) {
            e = e11;
            F = h().F();
            x10 = r3.x(h1Var.X2());
            str = "Error storing bundle. appId";
            F.c(str, x10, e);
            return false;
        }
    }

    public final boolean V(n nVar, long j10, boolean z10) {
        c();
        u();
        b2.p.k(nVar);
        b2.p.g(nVar.f6237a);
        byte[] f10 = o().A(nVar).f();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", nVar.f6237a);
        contentValues.put("name", nVar.f6238b);
        contentValues.put("timestamp", Long.valueOf(nVar.f6240d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j10));
        contentValues.put("data", f10);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (y().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            h().F().b("Failed to insert raw event (got -1). appId", r3.x(nVar.f6237a));
            return false;
        } catch (SQLiteException e10) {
            h().F().c("Error storing raw event. appId", r3.x(nVar.f6237a), e10);
            return false;
        }
    }

    public final boolean W(p9 p9Var) {
        b2.p.k(p9Var);
        c();
        u();
        if (r0(p9Var.f6328a, p9Var.f6330c) == null) {
            if (o9.e0(p9Var.f6330c)) {
                if (l0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{p9Var.f6328a}) >= m().z(p9Var.f6328a)) {
                    return false;
                }
            } else if (!"_npa".equals(p9Var.f6330c) && l0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{p9Var.f6328a, p9Var.f6329b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", p9Var.f6328a);
        contentValues.put("origin", p9Var.f6329b);
        contentValues.put("name", p9Var.f6330c);
        contentValues.put("set_timestamp", Long.valueOf(p9Var.f6331d));
        P(contentValues, "value", p9Var.f6332e);
        try {
            if (y().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                h().F().b("Failed to insert/update user property (got -1). appId", r3.x(p9Var.f6328a));
            }
        } catch (SQLiteException e10) {
            h().F().c("Error storing user property. appId", r3.x(p9Var.f6328a), e10);
        }
        return true;
    }

    public final boolean X(ha haVar) {
        b2.p.k(haVar);
        c();
        u();
        if (r0(haVar.f6091f, haVar.f6093h.f6259g) == null && l0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{haVar.f6091f}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", haVar.f6091f);
        contentValues.put("origin", haVar.f6092g);
        contentValues.put("name", haVar.f6093h.f6259g);
        P(contentValues, "value", haVar.f6093h.g());
        contentValues.put("active", Boolean.valueOf(haVar.f6095j));
        contentValues.put("trigger_event_name", haVar.f6096k);
        contentValues.put("trigger_timeout", Long.valueOf(haVar.f6098m));
        k();
        contentValues.put("timed_out_event", o9.p0(haVar.f6097l));
        contentValues.put("creation_timestamp", Long.valueOf(haVar.f6094i));
        k();
        contentValues.put("triggered_event", o9.p0(haVar.f6099n));
        contentValues.put("triggered_timestamp", Long.valueOf(haVar.f6093h.f6260h));
        contentValues.put("time_to_live", Long.valueOf(haVar.f6100o));
        k();
        contentValues.put("expired_event", o9.p0(haVar.f6101p));
        try {
            if (y().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                h().F().b("Failed to insert/update conditional user property (got -1)", r3.x(haVar.f6091f));
            }
        } catch (SQLiteException e10) {
            h().F().c("Error storing conditional user property", r3.x(haVar.f6091f), e10);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a0(String str, Bundle bundle) {
        c();
        u();
        byte[] f10 = o().A(new n(this.f6381a, "", str, "dep", 0L, 0L, bundle)).f();
        h().N().c("Saving default event parameters, appId, data size", j().w(str), Integer.valueOf(f10.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", f10);
        try {
            if (y().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            h().F().b("Failed to insert default event parameters (got -1). appId", r3.x(str));
            return false;
        } catch (SQLiteException e10) {
            h().F().c("Error storing default event parameters. appId", r3.x(str), e10);
            return false;
        }
    }

    public final boolean b0(String str, Long l10, long j10, com.google.android.gms.internal.measurement.d1 d1Var) {
        c();
        u();
        b2.p.k(d1Var);
        b2.p.g(str);
        b2.p.k(l10);
        byte[] f10 = d1Var.f();
        h().N().c("Saving complex main event, appId, data size", j().w(str), Integer.valueOf(f10.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", f10);
        try {
            if (y().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            h().F().b("Failed to insert complex main event (got -1). appId", r3.x(str));
            return false;
        } catch (SQLiteException e10) {
            h().F().c("Error storing complex main event. appId", r3.x(str), e10);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0157 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0185 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b1 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c9 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e7 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TRY_LEAVE, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a2 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011d A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:14:0x006d, B:16:0x00ce, B:20:0x00d8, B:23:0x0122, B:25:0x0157, B:28:0x0165, B:29:0x0161, B:30:0x0168, B:32:0x0170, B:36:0x017a, B:38:0x0185, B:42:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:59:0x01a2, B:61:0x011d, B:64:0x020e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.b4 m0(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.m0(java.lang.String):com.google.android.gms.measurement.internal.b4");
    }

    public final List<ha> n0(String str, String str2, String str3) {
        b2.p.g(str);
        c();
        u();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb2.append(" and name glob ?");
        }
        return O(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void o0(String str, String str2) {
        b2.p.g(str);
        b2.p.g(str2);
        c();
        u();
        try {
            y().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            h().F().d("Error deleting user property. appId", r3.x(str), j().A(str2), e10);
        }
    }

    public final long q0(String str) {
        b2.p.g(str);
        c();
        u();
        try {
            return y().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, m().v(str, s.f6422p))))});
        } catch (SQLiteException e10) {
            h().F().c("Error deleting over the limit events. appId", r3.x(str), e10);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.p9 r0(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            b2.p.g(r19)
            b2.p.g(r20)
            r18.c()
            r18.u()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.y()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L76
            if (r3 != 0) goto L3d
            r10.close()
            return r9
        L3d:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L76
            r11 = r18
            java.lang.Object r7 = r11.I(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.p9 r0 = new com.google.android.gms.measurement.internal.p9     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            if (r1 == 0) goto L6c
            com.google.android.gms.measurement.internal.r3 r1 = r18.h()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.t3 r1 = r1.F()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.r3.x(r19)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            r1.b(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
        L6c:
            r10.close()
            return r0
        L70:
            r0 = move-exception
            goto L82
        L72:
            r0 = move-exception
            r11 = r18
            goto La2
        L76:
            r0 = move-exception
            r11 = r18
            goto L82
        L7a:
            r0 = move-exception
            r11 = r18
            goto La3
        L7e:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L82:
            com.google.android.gms.measurement.internal.r3 r1 = r18.h()     // Catch: java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.t3 r1 = r1.F()     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.r3.x(r19)     // Catch: java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.p3 r4 = r18.j()     // Catch: java.lang.Throwable -> La1
            java.lang.String r4 = r4.A(r8)     // Catch: java.lang.Throwable -> La1
            r1.d(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La1
            if (r10 == 0) goto La0
            r10.close()
        La0:
            return r9
        La1:
            r0 = move-exception
        La2:
            r9 = r10
        La3:
            if (r9 == 0) goto La8
            r9.close()
        La8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.r0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.p9");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.ha s0(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.s0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.ha");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] t0(java.lang.String r11) {
        /*
            r10 = this;
            b2.p.g(r11)
            r10.c()
            r10.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.y()     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            if (r2 != 0) goto L2f
            r1.close()
            return r0
        L2f:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            if (r3 == 0) goto L4a
            com.google.android.gms.measurement.internal.r3 r3 = r10.h()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.r3.x(r11)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            r3.b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
        L4a:
            r1.close()
            return r2
        L4e:
            r2 = move-exception
            goto L54
        L50:
            r11 = move-exception
            goto L6d
        L52:
            r2 = move-exception
            r1 = r0
        L54:
            com.google.android.gms.measurement.internal.r3 r3 = r10.h()     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.r3.x(r11)     // Catch: java.lang.Throwable -> L6b
            r3.c(r4, r11, r2)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L6a
            r1.close()
        L6a:
            return r0
        L6b:
            r11 = move-exception
            r0 = r1
        L6d:
            if (r0 == 0) goto L72
            r0.close()
        L72:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.t0(java.lang.String):byte[]");
    }

    public final int u0(String str, String str2) {
        b2.p.g(str);
        b2.p.g(str2);
        c();
        u();
        try {
            return y().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            h().F().d("Error deleting conditional property", r3.x(str), j().A(str2), e10);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<com.google.android.gms.internal.measurement.m0>> v0(String str) {
        b2.p.g(str);
        l.a aVar = new l.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = y().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.m0>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.m0 m0Var = (com.google.android.gms.internal.measurement.m0) ((com.google.android.gms.internal.measurement.l7) ((m0.a) k9.C(com.google.android.gms.internal.measurement.m0.T(), query.getBlob(1))).g());
                        if (m0Var.L()) {
                            int i10 = query.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i10));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i10), list);
                            }
                            list.add(m0Var);
                        }
                    } catch (IOException e10) {
                        h().F().c("Failed to merge filter. appId", r3.x(str), e10);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (SQLiteException e11) {
                h().F().c("Database error querying filters. appId", r3.x(str), e11);
                Map<Integer, List<com.google.android.gms.internal.measurement.m0>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        return false;
    }

    public final void w0() {
        u();
        y().beginTransaction();
    }

    public final void x() {
        u();
        y().setTransactionSuccessful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> x0(java.lang.String r8) {
        /*
            r7 = this;
            r7.u()
            r7.c()
            b2.p.g(r8)
            l.a r0 = new l.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.y()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            if (r3 != 0) goto L30
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            r1.close()
            return r8
        L30:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            if (r4 != 0) goto L4c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
        L4c:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L9a
            if (r3 != 0) goto L30
            r1.close()
            return r0
        L61:
            r0 = move-exception
            goto L67
        L63:
            r8 = move-exception
            goto L9c
        L65:
            r0 = move-exception
            r1 = r2
        L67:
            com.google.android.gms.measurement.internal.r3 r3 = r7.h()     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.r3.x(r8)     // Catch: java.lang.Throwable -> L9a
            r3.c(r4, r5, r0)     // Catch: java.lang.Throwable -> L9a
            boolean r0 = com.google.android.gms.internal.measurement.uc.a()     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L94
            com.google.android.gms.measurement.internal.c r0 = r7.m()     // Catch: java.lang.Throwable -> L9a
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.s.F0     // Catch: java.lang.Throwable -> L9a
            boolean r8 = r0.D(r8, r3)     // Catch: java.lang.Throwable -> L9a
            if (r8 == 0) goto L94
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L93
            r1.close()
        L93:
            return r8
        L94:
            if (r1 == 0) goto L99
            r1.close()
        L99:
            return r2
        L9a:
            r8 = move-exception
            r2 = r1
        L9c:
            if (r2 == 0) goto La1
            r2.close()
        La1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.x0(java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase y() {
        c();
        try {
            return this.f6039d.getWritableDatabase();
        } catch (SQLiteException e10) {
            h().I().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.m0>> y0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.u()
            r12.c()
            b2.p.g(r13)
            b2.p.g(r14)
            l.a r0 = new l.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.y()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 != 0) goto L40
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r14.close()
            return r13
        L40:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.m0$a r2 = com.google.android.gms.internal.measurement.m0.T()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.x8 r1 = com.google.android.gms.measurement.internal.k9.C(r2, r1)     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.m0$a r1 = (com.google.android.gms.internal.measurement.m0.a) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.y8 r1 = r1.g()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.l7 r1 = (com.google.android.gms.internal.measurement.l7) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.m0 r1 = (com.google.android.gms.internal.measurement.m0) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r3 != 0) goto L72
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L72:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            goto L88
        L76:
            r1 = move-exception
            com.google.android.gms.measurement.internal.r3 r2 = r12.h()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r2 = r2.F()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r2.c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L88:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 != 0) goto L40
            r14.close()
            return r0
        L92:
            r0 = move-exception
            goto L98
        L94:
            r13 = move-exception
            goto Lcd
        L96:
            r0 = move-exception
            r14 = r9
        L98:
            com.google.android.gms.measurement.internal.r3 r1 = r12.h()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r1 = r1.F()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.r3.x(r13)     // Catch: java.lang.Throwable -> Lcb
            r1.c(r2, r3, r0)     // Catch: java.lang.Throwable -> Lcb
            boolean r0 = com.google.android.gms.internal.measurement.uc.a()     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lc5
            com.google.android.gms.measurement.internal.c r0 = r12.m()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.s.F0     // Catch: java.lang.Throwable -> Lcb
            boolean r13 = r0.D(r13, r1)     // Catch: java.lang.Throwable -> Lcb
            if (r13 == 0) goto Lc5
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Lcb
            if (r14 == 0) goto Lc4
            r14.close()
        Lc4:
            return r13
        Lc5:
            if (r14 == 0) goto Lca
            r14.close()
        Lca:
            return r9
        Lcb:
            r13 = move-exception
            r9 = r14
        Lcd:
            if (r9 == 0) goto Ld2
            r9.close()
        Ld2:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.y0(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.y()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L25
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L27
        L20:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L25:
            r2 = move-exception
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.r3 r3 = r6.h()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.t3 r3 = r3.F()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.z():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.j1> z0(java.lang.String r12) {
        /*
            r11 = this;
            r11.u()
            r11.c()
            b2.p.g(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.y()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 != 0) goto L4b
            boolean r1 = com.google.android.gms.internal.measurement.uc.a()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 == 0) goto L47
            com.google.android.gms.measurement.internal.c r1 = r11.m()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.s.F0     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            boolean r1 = r1.D(r12, r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r1 == 0) goto L47
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r0.close()
            return r12
        L47:
            r0.close()
            return r8
        L4b:
            l.a r1 = new l.a     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L50:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.j1$a r4 = com.google.android.gms.internal.measurement.j1.b0()     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.x8 r3 = com.google.android.gms.measurement.internal.k9.C(r4, r3)     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.j1$a r3 = (com.google.android.gms.internal.measurement.j1.a) r3     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.y8 r3 = r3.g()     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.l7 r3 = (com.google.android.gms.internal.measurement.l7) r3     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.internal.measurement.j1 r3 = (com.google.android.gms.internal.measurement.j1) r3     // Catch: java.io.IOException -> L72 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            goto L88
        L72:
            r3 = move-exception
            com.google.android.gms.measurement.internal.r3 r4 = r11.h()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r4 = r4.F()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.r3.x(r12)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            r4.d(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
        L88:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lcb
            if (r2 != 0) goto L50
            r0.close()
            return r1
        L92:
            r1 = move-exception
            goto L98
        L94:
            r12 = move-exception
            goto Lcd
        L96:
            r1 = move-exception
            r0 = r8
        L98:
            com.google.android.gms.measurement.internal.r3 r2 = r11.h()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.t3 r2 = r2.F()     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.r3.x(r12)     // Catch: java.lang.Throwable -> Lcb
            r2.c(r3, r4, r1)     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.google.android.gms.internal.measurement.uc.a()     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc5
            com.google.android.gms.measurement.internal.c r1 = r11.m()     // Catch: java.lang.Throwable -> Lcb
            com.google.android.gms.measurement.internal.l3<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.s.F0     // Catch: java.lang.Throwable -> Lcb
            boolean r12 = r1.D(r12, r2)     // Catch: java.lang.Throwable -> Lcb
            if (r12 == 0) goto Lc5
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Lcb
            if (r0 == 0) goto Lc4
            r0.close()
        Lc4:
            return r12
        Lc5:
            if (r0 == 0) goto Lca
            r0.close()
        Lca:
            return r8
        Lcb:
            r12 = move-exception
            r8 = r0
        Lcd:
            if (r8 == 0) goto Ld2
            r8.close()
        Ld2:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.f.z0(java.lang.String):java.util.Map");
    }
}
