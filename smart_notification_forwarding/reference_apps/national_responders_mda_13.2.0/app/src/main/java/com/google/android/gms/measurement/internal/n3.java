package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class n3 extends z4 {

    /* renamed from: c, reason: collision with root package name */
    private final q3 f6246c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6247d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n3(t4 t4Var) {
        super(t4Var);
        this.f6246c = new q3(this, i(), "google_app_measurement_local.db");
    }

    private static long B(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (!cursor.moveToFirst()) {
                cursor.close();
                return -1L;
            }
            long j10 = cursor.getLong(0);
            cursor.close();
            return j10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0121  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean D(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n3.D(int, byte[]):boolean");
    }

    private final SQLiteDatabase K() {
        if (this.f6247d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f6246c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f6247d = true;
        return null;
    }

    private final boolean L() {
        return i().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<c2.a> C(int r22) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n3.C(int):java.util.List");
    }

    public final boolean E(q qVar) {
        Parcel obtain = Parcel.obtain();
        qVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return D(0, marshall);
        }
        h().G().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean F(n9 n9Var) {
        Parcel obtain = Parcel.obtain();
        n9Var.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return D(1, marshall);
        }
        h().G().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean G(ha haVar) {
        k();
        byte[] p02 = o9.p0(haVar);
        if (p02.length <= 131072) {
            return D(2, p02);
        }
        h().G().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final void H() {
        c();
        try {
            int delete = K().delete("messages", null, null) + 0;
            if (delete > 0) {
                h().N().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            h().F().b("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean I() {
        return D(3, new byte[0]);
    }

    public final boolean J() {
        int i10;
        c();
        if (this.f6247d || !L()) {
            return false;
        }
        int i11 = 5;
        while (i10 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase K = K();
                    if (K == null) {
                        this.f6247d = true;
                        if (K != null) {
                            K.close();
                        }
                        return false;
                    }
                    K.beginTransaction();
                    K.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    K.setTransactionSuccessful();
                    K.endTransaction();
                    K.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i11);
                    i11 += 20;
                    i10 = 0 == 0 ? i10 + 1 : 0;
                    sQLiteDatabase.close();
                }
            } catch (SQLiteFullException e10) {
                h().F().b("Error deleting app launch break from local database", e10);
                this.f6247d = true;
                if (0 == 0) {
                }
                sQLiteDatabase.close();
            } catch (SQLiteException e11) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                h().F().b("Error deleting app launch break from local database", e11);
                this.f6247d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        h().I().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.z4
    protected final boolean z() {
        return false;
    }
}
