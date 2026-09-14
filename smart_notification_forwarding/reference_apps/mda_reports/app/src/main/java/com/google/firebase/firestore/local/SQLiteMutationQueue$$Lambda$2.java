package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteMutationQueue$$Lambda$2 implements Consumer {
    private final List arg$1;

    private SQLiteMutationQueue$$Lambda$2(List list) {
        this.arg$1 = list;
    }

    public static Consumer lambdaFactory$(List list) {
        return new SQLiteMutationQueue$$Lambda$2(list);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteMutationQueue.a(this.arg$1, (Cursor) obj);
    }
}
