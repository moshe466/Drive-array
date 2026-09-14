package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public class RegistrationMethods<A extends Api.AnyClient, L> {
    public final RegisterListenerMethod<A, L> register;
    public final UnregisterListenerMethod zaa;
    public final Runnable zab;

    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, L> {
        private RemoteCall zaa;
        private RemoteCall zab;
        private ListenerHolder zad;
        private Feature[] zae;
        private int zag;
        private Runnable zac = zacf.zaa;
        private boolean zaf = true;

        private Builder() {
        }

        public RegistrationMethods<A, L> build() {
            boolean z3;
            boolean z4;
            boolean z5 = false;
            if (this.zaa != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Must set register function");
            if (this.zab != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Must set unregister function");
            if (this.zad != null) {
                z5 = true;
            }
            Preconditions.checkArgument(z5, "Must set holder");
            return new RegistrationMethods<>(new zacd(this, this.zad, this.zae, this.zaf, this.zag), new zace(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac, null);
        }

        public Builder<A, L> onConnectionSuspended(Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        public Builder<A, L> register(RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, L> setAutoResolveMissingFeatures(boolean z3) {
            this.zaf = z3;
            return this;
        }

        public Builder<A, L> setFeatures(Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        public Builder<A, L> setMethodKey(int i) {
            this.zag = i;
            return this;
        }

        public Builder<A, L> unregister(RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zab = remoteCall;
            return this;
        }

        public Builder<A, L> withHolder(ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }

        public final /* synthetic */ RemoteCall zaa() {
            return this.zaa;
        }

        public final /* synthetic */ RemoteCall zab() {
            return this.zab;
        }

        public /* synthetic */ Builder(byte[] bArr) {
        }
    }

    public /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, byte[] bArr) {
        this.register = registerListenerMethod;
        this.zaa = unregisterListenerMethod;
        this.zab = runnable;
    }

    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>(null);
    }
}
