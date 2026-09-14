package com.google.firebase.firestore.remote;

import androidx.annotation.NonNull;
import io.grpc.Metadata;

/* loaded from: classes2.dex */
public interface GrpcMetadataProvider {
    void updateMetadata(@NonNull Metadata metadata);
}
