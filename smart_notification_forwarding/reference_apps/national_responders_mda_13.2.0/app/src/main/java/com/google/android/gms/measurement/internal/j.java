package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class j {
    private static Set<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb2.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(r3 r3Var, SQLiteDatabase sQLiteDatabase) {
        if (r3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            r3Var.I().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            r3Var.I().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            r3Var.I().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        r3Var.I().a("Failed to turn on database write permission for owner");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(r3 r3Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (r3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!d(r3Var, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> a10 = a(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!a10.remove(str4)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                    sb2.append("Table ");
                    sb2.append(str);
                    sb2.append(" is missing required column: ");
                    sb2.append(str4);
                    throw new SQLiteException(sb2.toString());
                }
            }
            if (strArr != null) {
                for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                    if (!a10.remove(strArr[i10])) {
                        sQLiteDatabase.execSQL(strArr[i10 + 1]);
                    }
                }
            }
            if (a10.isEmpty()) {
                return;
            }
            r3Var.I().c("Table has extra columns. table, columns", str, TextUtils.join(", ", a10));
        } catch (SQLiteException e10) {
            r3Var.F().b("Failed to verify columns on table that was just created", str);
            throw e10;
        }
    }

    private static boolean d(r3 r3Var, SQLiteDatabase sQLiteDatabase, String str) {
        if (r3Var == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean moveToFirst = cursor.moveToFirst();
                cursor.close();
                return moveToFirst;
            } catch (SQLiteException e10) {
                r3Var.I().c("Error querying for table", str, e10);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
