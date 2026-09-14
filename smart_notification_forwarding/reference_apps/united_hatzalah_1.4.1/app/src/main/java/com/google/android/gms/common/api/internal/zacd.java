package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* loaded from: classes.dex */
final class zacd extends RegisterListenerMethod {
    final /* synthetic */ RegistrationMethods.Builder zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacd(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z3, int i) {
        super(listenerHolder, featureArr, z3, i);
        Objects.requireNonNull(builder);
        this.zaa = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final void registerListener(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) {
        this.zaa.zaa().accept(anyClient, taskCompletionSource);
    }
}
