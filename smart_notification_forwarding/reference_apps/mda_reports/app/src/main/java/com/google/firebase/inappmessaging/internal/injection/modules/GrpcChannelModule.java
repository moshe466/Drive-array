package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
/* loaded from: classes2.dex */
public class GrpcChannelModule {
    @Provides
    @Singleton
    public Channel providesGrpcChannel(@Named("host") String str) {
        return ManagedChannelBuilder.forTarget(str).build();
    }

    @Provides
    @Singleton
    @Named("host")
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
