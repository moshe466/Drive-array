package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$12 implements Consumer {
    private final List arg$1;

    private SQLiteMutationQueue$$Lambda$12(List list) {
        this.arg$1 = list;
    }

    public static Consumer lambdaFactory$(List list) {
        return new SQLiteMutationQueue$$Lambda$12(list);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteMutationQueue.b(this.arg$1, (Cursor) obj);
    }
}
