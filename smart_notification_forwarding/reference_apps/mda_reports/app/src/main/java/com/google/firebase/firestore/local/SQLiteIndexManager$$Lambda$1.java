package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteIndexManager$$Lambda$1 implements Consumer {
    private final ArrayList arg$1;

    private SQLiteIndexManager$$Lambda$1(ArrayList arrayList) {
        this.arg$1 = arrayList;
    }

    public static Consumer lambdaFactory$(ArrayList arrayList) {
        return new SQLiteIndexManager$$Lambda$1(arrayList);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteIndexManager.a(this.arg$1, (Cursor) obj);
    }
}
