package io.grpc.internal;

import io.grpc.NameResolver;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class ServiceConfigState {

    @Nullable
    private NameResolver.ConfigOrError currentServiceConfigOrError;

    @Nullable
    private final NameResolver.ConfigOrError defaultServiceConfig;
    private final boolean lookUpServiceConfig;
    private boolean updated;
}
