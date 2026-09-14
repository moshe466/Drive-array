package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    /* loaded from: classes.dex */
    public static class Builder<A extends Api.AnyClient, ResultT> {
        private RemoteCall zaa;
        private Feature[] zad;
        private boolean zab = false;
        private boolean zac = false;
        private int zae = 0;

        private Builder() {
        }

        public TaskApiCall<A, ResultT> build() {
            boolean z3;
            boolean z4 = true;
            if (this.zaa != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "execute parameter required");
            if (!this.zac) {
                Feature[] featureArr = this.zad;
                if (featureArr != null && (featureArr.length) != 0) {
                    for (Feature feature : featureArr) {
                        if (feature.getIsFullyRolledOut()) {
                        }
                    }
                    this.zab = z4;
                }
                z4 = false;
                this.zab = z4;
            }
            return new zacm(this, this.zad, this.zab, this.zae);
        }

        @Deprecated
        public Builder<A, ResultT> execute(final BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.zaa = new RemoteCall() { // from class: com.google.android.gms.common.api.internal.zacn
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    BiConsumer.this.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
                }
            };
            return this;
        }

        public Builder<A, ResultT> run(RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        public Builder<A, ResultT> setAutoResolveMissingFeatures(boolean z3) {
            this.zac = true;
            this.zab = z3;
            return this;
        }

        public Builder<A, ResultT> setFeatures(Feature... featureArr) {
            this.zad = featureArr;
            return this;
        }

        public Builder<A, ResultT> setMethodKey(int i) {
            this.zae = i;
            return this;
        }

        public final /* synthetic */ RemoteCall zaa() {
            return this.zaa;
        }

        public /* synthetic */ Builder(byte[] bArr) {
        }
    }

    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> builder() {
        return new Builder<>(null);
    }

    public abstract void doExecute(A a2, TaskCompletionSource<ResultT> taskCompletionSource);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final Feature[] zaa() {
        return this.zaa;
    }

    public final int zab() {
        return this.zac;
    }

    public TaskApiCall(Feature[] featureArr, boolean z3, int i) {
        this.zaa = featureArr;
        boolean z4 = false;
        if (featureArr != null && z3) {
            z4 = true;
        }
        this.zab = z4;
        this.zac = i;
    }
}
