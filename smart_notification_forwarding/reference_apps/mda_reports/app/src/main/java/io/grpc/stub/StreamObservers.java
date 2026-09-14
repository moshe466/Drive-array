package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.ExperimentalApi;
import java.util.Iterator;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4694")
/* loaded from: classes2.dex */
public final class StreamObservers {
    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(iterable, FirebaseAnalytics.Param.SOURCE);
        copyWithFlowControl(iterable.iterator(), callStreamObserver);
    }

    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        Preconditions.checkNotNull(it, FirebaseAnalytics.Param.SOURCE);
        Preconditions.checkNotNull(callStreamObserver, "target");
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (CallStreamObserver.this.isReady() && it.hasNext()) {
                    CallStreamObserver.this.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                this.completed = true;
                CallStreamObserver.this.onCompleted();
            }
        });
    }
}
