package com.google.firebase.sessions;

import F2.l;
import U.h;
import androidx.datastore.core.CorruptionException;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1 extends k implements l {
    public static final FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1 INSTANCE = new FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1();

    public FirebaseSessionsComponent$MainModule$Companion$sessionConfigsDataStore$1() {
        super(1);
    }

    @Override // F2.l
    public final h invoke(CorruptionException ex) {
        j.e(ex, "ex");
        ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions();
        return new U.b(true);
    }
}
