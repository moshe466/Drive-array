package com.google.firebase.installations.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance();
        j.d(firebaseInstallations, "getInstance()");
        return firebaseInstallations;
    }

    public static final FirebaseInstallations installations(Firebase firebase, FirebaseApp app2) {
        j.e(firebase, "<this>");
        j.e(app2, "app");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance(app2);
        j.d(firebaseInstallations, "getInstance(app)");
        return firebaseInstallations;
    }
}
