package com.google.firebase.ktx;

import P2.A;
import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.components.Component;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class FirebaseKt {
    public static final FirebaseApp app(Firebase firebase, String name) {
        j.e(firebase, "<this>");
        j.e(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        j.d(firebaseApp, "getInstance(name)");
        return firebaseApp;
    }

    private static final <T extends Annotation> Component<A> coroutineDispatcher() {
        j.h();
        throw null;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        j.d(firebaseApp, "getInstance()");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        j.d(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        j.e(firebase, "<this>");
        j.e(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options) {
        j.e(firebase, "<this>");
        j.e(context, "context");
        j.e(options, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options);
        j.d(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options, String name) {
        j.e(firebase, "<this>");
        j.e(context, "context");
        j.e(options, "options");
        j.e(name, "name");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, options, name);
        j.d(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
