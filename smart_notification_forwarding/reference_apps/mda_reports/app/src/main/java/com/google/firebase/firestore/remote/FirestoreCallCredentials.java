package com.google.firebase.firestore.remote;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class FirestoreCallCredentials extends CallCredentials {
    private static final Metadata.Key<String> AUTHORIZATION_HEADER = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
    private static final String LOG_TAG = "FirestoreCallCredentials";
    private final CredentialsProvider credentialsProvider;

    public FirestoreCallCredentials(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
    }

    public static /* synthetic */ void a(CallCredentials.MetadataApplier metadataApplier, Exception exc) {
        Metadata metadata;
        if (exc instanceof FirebaseApiNotAvailableException) {
            Logger.debug(LOG_TAG, "Firebase Auth API not available, not using authentication.", new Object[0]);
            metadata = new Metadata();
        } else if (!(exc instanceof FirebaseNoSignedInUserException)) {
            Logger.warn(LOG_TAG, "Failed to get token: %s.", exc);
            metadataApplier.fail(Status.UNAUTHENTICATED.withCause(exc));
            return;
        } else {
            Logger.debug(LOG_TAG, "No user signed in, not using authentication.", new Object[0]);
            metadata = new Metadata();
        }
        metadataApplier.apply(metadata);
    }

    public static /* synthetic */ void a(CallCredentials.MetadataApplier metadataApplier, String str) {
        Logger.debug(LOG_TAG, "Successfully fetched token.", new Object[0]);
        Metadata metadata = new Metadata();
        if (str != null) {
            metadata.put(AUTHORIZATION_HEADER, "Bearer " + str);
        }
        metadataApplier.apply(metadata);
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier) {
        this.credentialsProvider.getToken().addOnSuccessListener(executor, FirestoreCallCredentials$$Lambda$1.lambdaFactory$(metadataApplier)).addOnFailureListener(executor, FirestoreCallCredentials$$Lambda$2.lambdaFactory$(metadataApplier));
    }

    @Override // io.grpc.CallCredentials
    public void thisUsesUnstableApi() {
    }
}
