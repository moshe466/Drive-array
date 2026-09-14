package com.google.firebase.database;

import S2.d;
import S2.z;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class DatabaseKt {
    public static final FirebaseDatabase database(Firebase firebase, String url) {
        j.e(firebase, "<this>");
        j.e(url, "url");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(url);
        j.d(firebaseDatabase, "getInstance(url)");
        return firebaseDatabase;
    }

    public static final d getChildEvents(Query query) {
        j.e(query, "<this>");
        return z.b(new DatabaseKt$childEvents$1(query, null));
    }

    public static final FirebaseDatabase getDatabase(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        j.d(firebaseDatabase, "getInstance()");
        return firebaseDatabase;
    }

    public static final d getSnapshots(Query query) {
        j.e(query, "<this>");
        return z.b(new DatabaseKt$snapshots$1(query, null));
    }

    public static final <T> T getValue(DataSnapshot dataSnapshot) {
        j.e(dataSnapshot, "<this>");
        j.h();
        throw null;
    }

    public static final <T> d values(Query query) {
        j.e(query, "<this>");
        getSnapshots(query);
        j.h();
        throw null;
    }

    public static final FirebaseDatabase database(Firebase firebase, FirebaseApp app2) {
        j.e(firebase, "<this>");
        j.e(app2, "app");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(app2);
        j.d(firebaseDatabase, "getInstance(app)");
        return firebaseDatabase;
    }

    public static final <T> T getValue(MutableData mutableData) {
        j.e(mutableData, "<this>");
        j.h();
        throw null;
    }

    public static final FirebaseDatabase database(Firebase firebase, FirebaseApp app2, String url) {
        j.e(firebase, "<this>");
        j.e(app2, "app");
        j.e(url, "url");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(app2, url);
        j.d(firebaseDatabase, "getInstance(app, url)");
        return firebaseDatabase;
    }
}
