package com.google.firebase.firestore.remote;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.core.DatabaseInfo;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firestore.v1.FirestoreGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.android.AndroidChannelBuilder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GrpcCallProvider {
    private static final String LOG_TAG = "GrpcCallProvider";
    private static Supplier<ManagedChannelBuilder<?>> overrideChannelBuilderSupplier;
    private final AsyncQueue asyncQueue;
    private CallOptions callOptions;
    private final Task<ManagedChannel> channelTask;

    public GrpcCallProvider(AsyncQueue asyncQueue, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials) {
        this.asyncQueue = asyncQueue;
        this.channelTask = Tasks.call(Executors.BACKGROUND_EXECUTOR, GrpcCallProvider$$Lambda$1.lambdaFactory$(this, context, databaseInfo, callCredentials, asyncQueue));
    }

    public static /* synthetic */ ManagedChannel a(GrpcCallProvider grpcCallProvider, Context context, DatabaseInfo databaseInfo, CallCredentials callCredentials, AsyncQueue asyncQueue) {
        ManagedChannel initChannel = grpcCallProvider.initChannel(context, databaseInfo);
        grpcCallProvider.callOptions = FirestoreGrpc.newStub(initChannel).withCallCredentials(callCredentials).withExecutor(asyncQueue.getExecutor()).getCallOptions();
        return initChannel;
    }

    private ManagedChannel initChannel(Context context, DatabaseInfo databaseInfo) {
        ManagedChannelBuilder<?> managedChannelBuilder;
        try {
            ProviderInstaller.installIfNeeded(context);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IllegalStateException e) {
            Logger.warn(LOG_TAG, "Failed to update ssl context: %s", e);
        }
        Supplier<ManagedChannelBuilder<?>> supplier = overrideChannelBuilderSupplier;
        if (supplier != null) {
            managedChannelBuilder = supplier.get();
        } else {
            ManagedChannelBuilder<?> forTarget = ManagedChannelBuilder.forTarget(databaseInfo.getHost());
            if (!databaseInfo.isSslEnabled()) {
                forTarget.usePlaintext();
            }
            managedChannelBuilder = forTarget;
        }
        managedChannelBuilder.keepAliveTime(30L, TimeUnit.SECONDS);
        return AndroidChannelBuilder.fromBuilder(managedChannelBuilder).context(context).build();
    }

    @VisibleForTesting
    public static void overrideChannelBuilder(Supplier<ManagedChannelBuilder<?>> supplier) {
        overrideChannelBuilderSupplier = supplier;
    }

    public <ReqT, RespT> Task<ClientCall<ReqT, RespT>> a(MethodDescriptor<ReqT, RespT> methodDescriptor) {
        return (Task<ClientCall<ReqT, RespT>>) this.channelTask.continueWithTask(this.asyncQueue.getExecutor(), GrpcCallProvider$$Lambda$2.lambdaFactory$(this, methodDescriptor));
    }

    public void a() {
        try {
            ManagedChannel managedChannel = (ManagedChannel) Tasks.await(this.channelTask);
            managedChannel.shutdown();
            try {
                if (managedChannel.awaitTermination(1L, TimeUnit.SECONDS)) {
                    return;
                }
                Logger.debug(FirestoreChannel.class.getSimpleName(), "Unable to gracefully shutdown the gRPC ManagedChannel. Will attempt an immediate shutdown.", new Object[0]);
                managedChannel.shutdownNow();
                if (managedChannel.awaitTermination(60L, TimeUnit.SECONDS)) {
                    return;
                }
                Logger.warn(FirestoreChannel.class.getSimpleName(), "Unable to forcefully shutdown the gRPC ManagedChannel.", new Object[0]);
            } catch (InterruptedException unused) {
                managedChannel.shutdownNow();
                Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while shutting down the gRPC Managed Channel", new Object[0]);
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused2) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Interrupted while retrieving the gRPC Managed Channel", new Object[0]);
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            Logger.warn(FirestoreChannel.class.getSimpleName(), "Channel is not initialized, shutdown will just do nothing. Channel initializing run into exception: %s", e);
        }
    }
}
