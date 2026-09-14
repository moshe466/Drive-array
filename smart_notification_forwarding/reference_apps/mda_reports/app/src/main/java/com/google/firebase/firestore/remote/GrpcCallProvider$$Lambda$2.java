package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import io.grpc.MethodDescriptor;

/* loaded from: classes2.dex */
final /* synthetic */ class GrpcCallProvider$$Lambda$2 implements Continuation {
    private final GrpcCallProvider arg$1;
    private final MethodDescriptor arg$2;

    private GrpcCallProvider$$Lambda$2(GrpcCallProvider grpcCallProvider, MethodDescriptor methodDescriptor) {
        this.arg$1 = grpcCallProvider;
        this.arg$2 = methodDescriptor;
    }

    public static Continuation lambdaFactory$(GrpcCallProvider grpcCallProvider, MethodDescriptor methodDescriptor) {
        return new GrpcCallProvider$$Lambda$2(grpcCallProvider, methodDescriptor);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return GrpcCallProvider.a(this.arg$1, this.arg$2, task);
    }
}
