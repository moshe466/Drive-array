package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnSuccessListener;
import io.grpc.CallCredentials;

/* loaded from: classes2.dex */
final /* synthetic */ class FirestoreCallCredentials$$Lambda$1 implements OnSuccessListener {
    private final CallCredentials.MetadataApplier arg$1;

    private FirestoreCallCredentials$$Lambda$1(CallCredentials.MetadataApplier metadataApplier) {
        this.arg$1 = metadataApplier;
    }

    public static OnSuccessListener lambdaFactory$(CallCredentials.MetadataApplier metadataApplier) {
        return new FirestoreCallCredentials$$Lambda$1(metadataApplier);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        FirestoreCallCredentials.a(this.arg$1, (String) obj);
    }
}
