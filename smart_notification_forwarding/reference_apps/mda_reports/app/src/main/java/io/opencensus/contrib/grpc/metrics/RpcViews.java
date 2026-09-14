package io.opencensus.contrib.grpc.metrics;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewManager;

/* loaded from: classes2.dex */
public final class RpcViews {

    @VisibleForTesting
    static final ImmutableSet<View> a = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_CUMULATIVE_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_CUMULATIVE_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> b = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_COMPLETED_RPC_VIEW, RpcViewConstants.GRPC_CLIENT_STARTED_RPC_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> c = ImmutableSet.of(RpcViewConstants.GRPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_SERVER_SENT_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_BYTES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_SENT_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_RPC_VIEW, RpcViewConstants.GRPC_SERVER_COMPLETED_RPC_VIEW, RpcViewConstants.GRPC_SERVER_STARTED_RPC_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> d = ImmutableSet.of(RpcViewConstants.RPC_CLIENT_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_MINUTE_VIEW, RpcViewConstants.RPC_CLIENT_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_ROUNDTRIP_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_STARTED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_CLIENT_FINISHED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_ERROR_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_LATENCY_HOUR_VIEW, RpcViewConstants.RPC_SERVER_SERVER_ELAPSED_TIME_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_REQUEST_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_RESPONSE_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES_HOUR_VIEW, RpcViewConstants.RPC_SERVER_STARTED_COUNT_HOUR_VIEW, RpcViewConstants.RPC_SERVER_FINISHED_COUNT_HOUR_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> e = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_SENT_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_SENT_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_CLIENT_RECEIVED_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_SENT_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_BYTES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_SENT_MESSAGES_PER_METHOD_VIEW, RpcViewConstants.GRPC_SERVER_RECEIVED_MESSAGES_PER_METHOD_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> f = ImmutableSet.of(RpcViewConstants.GRPC_CLIENT_ROUNDTRIP_LATENCY_VIEW, RpcViewConstants.GRPC_CLIENT_STARTED_RPC_VIEW);

    @VisibleForTesting
    static final ImmutableSet<View> g = ImmutableSet.of(RpcViewConstants.GRPC_SERVER_SERVER_LATENCY_VIEW, RpcViewConstants.GRPC_SERVER_STARTED_RPC_VIEW);

    private RpcViews() {
    }

    @VisibleForTesting
    static void a(ViewManager viewManager) {
        UnmodifiableIterator<View> it = a.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void b(ViewManager viewManager) {
        f(viewManager);
        i(viewManager);
    }

    @VisibleForTesting
    static void c(ViewManager viewManager) {
        g(viewManager);
        j(viewManager);
    }

    @VisibleForTesting
    static void d(ViewManager viewManager) {
        UnmodifiableIterator<View> it = d.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void e(ViewManager viewManager) {
        a(viewManager);
        d(viewManager);
    }

    @VisibleForTesting
    static void f(ViewManager viewManager) {
        UnmodifiableIterator<View> it = f.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void g(ViewManager viewManager) {
        UnmodifiableIterator<View> it = b.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void h(ViewManager viewManager) {
        UnmodifiableIterator<View> it = e.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void i(ViewManager viewManager) {
        UnmodifiableIterator<View> it = g.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @VisibleForTesting
    static void j(ViewManager viewManager) {
        UnmodifiableIterator<View> it = c.iterator();
        while (it.hasNext()) {
            viewManager.registerView(it.next());
        }
    }

    @Deprecated
    public static void registerAllCumulativeViews() {
        a(Stats.getViewManager());
    }

    public static void registerAllGrpcBasicViews() {
        b(Stats.getViewManager());
    }

    public static void registerAllGrpcViews() {
        c(Stats.getViewManager());
    }

    @Deprecated
    public static void registerAllIntervalViews() {
        d(Stats.getViewManager());
    }

    @Deprecated
    public static void registerAllViews() {
        e(Stats.getViewManager());
    }

    public static void registerClientGrpcBasicViews() {
        f(Stats.getViewManager());
    }

    public static void registerClientGrpcViews() {
        g(Stats.getViewManager());
    }

    public static void registerRealTimeMetricsViews() {
        h(Stats.getViewManager());
    }

    public static void registerServerGrpcBasicViews() {
        i(Stats.getViewManager());
    }

    public static void registerServerGrpcViews() {
        j(Stats.getViewManager());
    }
}
