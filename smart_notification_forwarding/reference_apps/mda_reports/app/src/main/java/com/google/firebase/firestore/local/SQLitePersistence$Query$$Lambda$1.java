package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import com.google.firebase.firestore.local.SQLitePersistence;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLitePersistence$Query$$Lambda$1 implements SQLiteDatabase.CursorFactory {
    private final Object[] arg$1;

    private SQLitePersistence$Query$$Lambda$1(Object[] objArr) {
        this.arg$1 = objArr;
    }

    public static SQLiteDatabase.CursorFactory lambdaFactory$(Object[] objArr) {
        return new SQLitePersistence$Query$$Lambda$1(objArr);
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        return SQLitePersistence.Query.a(this.arg$1, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }
}
