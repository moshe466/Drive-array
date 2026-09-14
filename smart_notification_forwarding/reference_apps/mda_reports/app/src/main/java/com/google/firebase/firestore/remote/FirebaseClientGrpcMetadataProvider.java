package com.google.firebase.firestore.remote;

import androidx.annotation.NonNull;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import io.grpc.Metadata;

/* loaded from: classes2.dex */
public class FirebaseClientGrpcMetadataProvider implements GrpcMetadataProvider {
    private static final Metadata.Key<String> HEART_BEAT_HEADER = Metadata.Key.of("x-firebase-client-log-type", Metadata.ASCII_STRING_MARSHALLER);
    private static final Metadata.Key<String> USER_AGENT_HEADER = Metadata.Key.of("x-firebase-client", Metadata.ASCII_STRING_MARSHALLER);
    private final String firebaseFirestoreHeartBeatTag = "fire-fst";
    private final Provider<HeartBeatInfo> heartBeatInfoProvider;
    private final Provider<UserAgentPublisher> userAgentPublisherProvider;

    public FirebaseClientGrpcMetadataProvider(@NonNull Provider<UserAgentPublisher> provider, @NonNull Provider<HeartBeatInfo> provider2) {
        this.userAgentPublisherProvider = provider;
        this.heartBeatInfoProvider = provider2;
    }

    @Override // com.google.firebase.firestore.remote.GrpcMetadataProvider
    public void updateMetadata(@NonNull Metadata metadata) {
        int code;
        if (this.heartBeatInfoProvider.get() == null || this.userAgentPublisherProvider.get() == null || (code = this.heartBeatInfoProvider.get().getHeartBeatCode("fire-fst").getCode()) == 0) {
            return;
        }
        metadata.put(HEART_BEAT_HEADER, Integer.toString(code));
        metadata.put(USER_AGENT_HEADER, this.userAgentPublisherProvider.get().getUserAgent());
    }
}
