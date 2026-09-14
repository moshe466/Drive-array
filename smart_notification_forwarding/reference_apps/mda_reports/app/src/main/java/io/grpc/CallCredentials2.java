package io.grpc;

import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4901")
@Deprecated
/* loaded from: classes2.dex */
public abstract class CallCredentials2 extends CallCredentials {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    /* loaded from: classes2.dex */
    public static abstract class MetadataApplier extends CallCredentials.MetadataApplier {
    }

    @Override // io.grpc.CallCredentials
    public final void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, final CallCredentials.MetadataApplier metadataApplier) {
        applyRequestMetadata(requestInfo, executor, new MetadataApplier(this) { // from class: io.grpc.CallCredentials2.1
            @Override // io.grpc.CallCredentials.MetadataApplier
            public void apply(Metadata metadata) {
                metadataApplier.apply(metadata);
            }

            @Override // io.grpc.CallCredentials.MetadataApplier
            public void fail(Status status) {
                metadataApplier.fail(status);
            }
        });
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
    public abstract void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);
}
