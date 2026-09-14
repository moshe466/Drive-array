package io.grpc;

import io.grpc.Metadata;

@Internal
/* loaded from: classes2.dex */
public final class InternalStatus {

    @Internal
    public static final Metadata.Key<String> MESSAGE_KEY = Status.b;

    @Internal
    public static final Metadata.Key<Status> CODE_KEY = Status.a;

    private InternalStatus() {
    }
}
