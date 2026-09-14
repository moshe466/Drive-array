package com.google.firebase.auth.ktx;

import F2.l;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AuthKt {
    public static final ActionCodeSettings actionCodeSettings(l init) {
        j.e(init, "init");
        ActionCodeSettings.Builder newBuilder = ActionCodeSettings.newBuilder();
        j.d(newBuilder, "newBuilder(...)");
        init.invoke(newBuilder);
        ActionCodeSettings build = newBuilder.build();
        j.d(build, "build(...)");
        return build;
    }

    public static final FirebaseAuth auth(Firebase firebase, FirebaseApp app2) {
        j.e(firebase, "<this>");
        j.e(app2, "app");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(app2);
        j.d(firebaseAuth, "getInstance(...)");
        return firebaseAuth;
    }

    public static final FirebaseAuth getAuth(Firebase firebase) {
        j.e(firebase, "<this>");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        j.d(firebaseAuth, "getInstance(...)");
        return firebaseAuth;
    }

    public static final AuthCredential oAuthCredential(String providerId, l init) {
        j.e(providerId, "providerId");
        j.e(init, "init");
        OAuthProvider.CredentialBuilder newCredentialBuilder = OAuthProvider.newCredentialBuilder(providerId);
        j.d(newCredentialBuilder, "newCredentialBuilder(...)");
        init.invoke(newCredentialBuilder);
        AuthCredential build = newCredentialBuilder.build();
        j.d(build, "build(...)");
        return build;
    }

    public static final OAuthProvider oAuthProvider(String providerId, l init) {
        j.e(providerId, "providerId");
        j.e(init, "init");
        OAuthProvider.Builder newBuilder = OAuthProvider.newBuilder(providerId);
        j.d(newBuilder, "newBuilder(...)");
        init.invoke(newBuilder);
        OAuthProvider build = newBuilder.build();
        j.d(build, "build(...)");
        return build;
    }

    public static final UserProfileChangeRequest userProfileChangeRequest(l init) {
        j.e(init, "init");
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        init.invoke(builder);
        UserProfileChangeRequest build = builder.build();
        j.d(build, "build(...)");
        return build;
    }

    public static final OAuthProvider oAuthProvider(String providerId, FirebaseAuth firebaseAuth, l init) {
        j.e(providerId, "providerId");
        j.e(firebaseAuth, "firebaseAuth");
        j.e(init, "init");
        OAuthProvider.Builder newBuilder = OAuthProvider.newBuilder(providerId, firebaseAuth);
        j.d(newBuilder, "newBuilder(...)");
        init.invoke(newBuilder);
        OAuthProvider build = newBuilder.build();
        j.d(build, "build(...)");
        return build;
    }
}
