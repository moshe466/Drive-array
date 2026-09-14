package com.google.firebase.firestore.remote;

import android.content.Context;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import io.grpc.CallCredentials;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final /* synthetic */ class GrpcCallProvider$$Lambda$1 implements Callable {
    private final GrpcCallProvider arg$1;
    private final Context arg$2;
    private final DatabaseInfo arg$3;
    private final CallCredentials arg$4;
    private final AsyncQueue arg$5;

    private GrpcCallProvider$$Lambda$1(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials, AsyncQueue asyncQueue) {
        this.arg$1 = grpcCallProvider;
        this.arg$2 = context;
        this.arg$3 = databaseInfo;
        this.arg$4 = callCredentials;
        this.arg$5 = asyncQueue;
    }

    public static Callable lambdaFactory$(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials, AsyncQueue asyncQueue) {
        return new GrpcCallProvider$$Lambda$1(grpcCallProvider, context, databaseInfo, callCredentials, asyncQueue);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return GrpcCallProvider.a(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
    }
}
