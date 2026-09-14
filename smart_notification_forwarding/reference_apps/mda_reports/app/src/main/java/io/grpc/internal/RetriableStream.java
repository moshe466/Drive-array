package io.grpc.internal;

import androidx.core.app.NotificationManagerCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.HedgingPolicy;
import io.grpc.internal.RetryPolicy;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class RetriableStream<ReqT> implements ClientStream {
    private final Executor callExecutor;
    private final long channelBufferLimit;
    private final ChannelBufferMeter channelBufferUsed;
    private final Metadata headers;
    private HedgingPolicy hedgingPolicy;
    private final HedgingPolicy.Provider hedgingPolicyProvider;
    private boolean isHedging;
    private ClientStreamListener masterListener;
    private final MethodDescriptor<ReqT, ?> method;
    private long nextBackoffIntervalNanos;
    private final long perRpcBufferLimit;

    @GuardedBy("lock")
    private long perRpcBufferUsed;
    private RetryPolicy retryPolicy;
    private final RetryPolicy.Provider retryPolicyProvider;
    private final ScheduledExecutorService scheduledExecutorService;

    @GuardedBy("lock")
    private FutureCanceller scheduledHedging;

    @GuardedBy("lock")
    private FutureCanceller scheduledRetry;

    @Nullable
    private final Throttle throttle;

    @VisibleForTesting
    static final Metadata.Key<String> a = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);

    @VisibleForTesting
    static final Metadata.Key<String> b = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
    private static final Status CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    private static Random random = new Random();
    private final Object lock = new Object();
    private volatile State state = new State(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface BufferEntry {
        void runWith(Substream substream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class BufferSizeTracer extends ClientStreamTracer {

        @GuardedBy("lock")
        long a;
        private final Substream substream;

        BufferSizeTracer(Substream substream) {
            this.substream = substream;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0076 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:8:0x0013, B:10:0x001d, B:13:0x0024, B:15:0x0035, B:17:0x0037, B:19:0x0044, B:20:0x0046, B:21:0x0070, B:23:0x0076, B:24:0x007e, B:29:0x0049, B:31:0x006d, B:32:0x0085), top: B:7:0x0013 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        @Override // io.grpc.StreamTracer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void outboundWireSize(long r8) {
            /*
                r7 = this;
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = io.grpc.internal.RetriableStream.a(r0)
                io.grpc.internal.RetriableStream$Substream r0 = r0.f
                if (r0 == 0) goto Lb
                return
            Lb:
                r0 = 0
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.lang.Object r1 = io.grpc.internal.RetriableStream.o(r1)
                monitor-enter(r1)
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream$State r2 = io.grpc.internal.RetriableStream.a(r2)     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream$Substream r2 = r2.f     // Catch: java.lang.Throwable -> L87
                if (r2 != 0) goto L85
                io.grpc.internal.RetriableStream$Substream r2 = r7.substream     // Catch: java.lang.Throwable -> L87
                boolean r2 = r2.b     // Catch: java.lang.Throwable -> L87
                if (r2 == 0) goto L24
                goto L85
            L24:
                long r2 = r7.a     // Catch: java.lang.Throwable -> L87
                long r2 = r2 + r8
                r7.a = r2     // Catch: java.lang.Throwable -> L87
                long r8 = r7.a     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                long r2 = io.grpc.internal.RetriableStream.k(r2)     // Catch: java.lang.Throwable -> L87
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 > 0) goto L37
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L87
                return
            L37:
                long r8 = r7.a     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                long r2 = io.grpc.internal.RetriableStream.l(r2)     // Catch: java.lang.Throwable -> L87
                r4 = 1
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 <= 0) goto L49
                io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch: java.lang.Throwable -> L87
            L46:
                r8.c = r4     // Catch: java.lang.Throwable -> L87
                goto L70
            L49:
                io.grpc.internal.RetriableStream r8 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream$ChannelBufferMeter r8 = io.grpc.internal.RetriableStream.m(r8)     // Catch: java.lang.Throwable -> L87
                long r2 = r7.a     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream r9 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                long r5 = io.grpc.internal.RetriableStream.k(r9)     // Catch: java.lang.Throwable -> L87
                long r2 = r2 - r5
                long r8 = r8.a(r2)     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                long r5 = r7.a     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream.b(r2, r5)     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                long r2 = io.grpc.internal.RetriableStream.n(r2)     // Catch: java.lang.Throwable -> L87
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 <= 0) goto L70
                io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch: java.lang.Throwable -> L87
                goto L46
            L70:
                io.grpc.internal.RetriableStream$Substream r8 = r7.substream     // Catch: java.lang.Throwable -> L87
                boolean r8 = r8.c     // Catch: java.lang.Throwable -> L87
                if (r8 == 0) goto L7e
                io.grpc.internal.RetriableStream r8 = io.grpc.internal.RetriableStream.this     // Catch: java.lang.Throwable -> L87
                io.grpc.internal.RetriableStream$Substream r9 = r7.substream     // Catch: java.lang.Throwable -> L87
                java.lang.Runnable r0 = io.grpc.internal.RetriableStream.b(r8, r9)     // Catch: java.lang.Throwable -> L87
            L7e:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L87
                if (r0 == 0) goto L84
                r0.run()
            L84:
                return
            L85:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L87
                return
            L87:
                r8 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L87
                goto L8b
            L8a:
                throw r8
            L8b:
                goto L8a
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.BufferSizeTracer.outboundWireSize(long):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        @VisibleForTesting
        long a(long j) {
            return this.bufferUsed.addAndGet(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class FutureCanceller {
        final Object a;

        @GuardedBy("lock")
        Future<?> b;

        @GuardedBy("lock")
        boolean c;

        FutureCanceller(Object obj) {
            this.a = obj;
        }

        void a(Future<?> future) {
            synchronized (this.a) {
                if (!this.c) {
                    this.b = future;
                }
            }
        }

        @GuardedBy("lock")
        boolean a() {
            return this.c;
        }

        @CheckForNull
        @GuardedBy("lock")
        Future<?> b() {
            this.c = true;
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class HedgingRunnable implements Runnable {
        final FutureCanceller a;

        HedgingRunnable(FutureCanceller futureCanceller) {
            this.a = futureCanceller;
        }

        @Override // java.lang.Runnable
        public void run() {
            RetriableStream.this.callExecutor.execute(new Runnable() { // from class: io.grpc.internal.RetriableStream.HedgingRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    FutureCanceller futureCanceller;
                    boolean z;
                    RetriableStream retriableStream;
                    RetriableStream retriableStream2 = RetriableStream.this;
                    Substream createSubstream = retriableStream2.createSubstream(retriableStream2.state.e);
                    synchronized (RetriableStream.this.lock) {
                        futureCanceller = null;
                        z = false;
                        if (HedgingRunnable.this.a.a()) {
                            z = true;
                        } else {
                            RetriableStream.this.state = RetriableStream.this.state.a(createSubstream);
                            if (RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) && (RetriableStream.this.throttle == null || RetriableStream.this.throttle.a())) {
                                retriableStream = RetriableStream.this;
                                futureCanceller = new FutureCanceller(RetriableStream.this.lock);
                            } else {
                                RetriableStream.this.state = RetriableStream.this.state.b();
                                retriableStream = RetriableStream.this;
                            }
                            retriableStream.scheduledHedging = futureCanceller;
                        }
                    }
                    if (z) {
                        createSubstream.a.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                        return;
                    }
                    if (futureCanceller != null) {
                        futureCanceller.a(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), RetriableStream.this.hedgingPolicy.b, TimeUnit.NANOSECONDS));
                    }
                    RetriableStream.this.drain(createSubstream);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class RetryPlan {
        final boolean a;
        final boolean b;
        final long c;

        @Nullable
        final Integer d;

        RetryPlan(boolean z, boolean z2, long j, @Nullable Integer num) {
            this.a = z;
            this.b = z2;
            this.c = j;
            this.d = num;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class State {
        final boolean a;

        @Nullable
        final List<BufferEntry> b;
        final Collection<Substream> c;
        final Collection<Substream> d;
        final int e;

        @Nullable
        final Substream f;
        final boolean g;
        final boolean h;

        State(@Nullable List<BufferEntry> list, Collection<Substream> collection, Collection<Substream> collection2, @Nullable Substream substream, boolean z, boolean z2, boolean z3, int i) {
            this.b = list;
            this.c = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.f = substream;
            this.d = collection2;
            this.g = z;
            this.a = z2;
            this.h = z3;
            this.e = i;
            Preconditions.checkState(!z2 || list == null, "passThrough should imply buffer is null");
            Preconditions.checkState((z2 && substream == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!z2 || (collection.size() == 1 && collection.contains(substream)) || (collection.size() == 0 && substream.b), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((z && substream == null) ? false : true, "cancelled should imply committed");
        }

        @CheckReturnValue
        State a() {
            return new State(this.b, this.c, this.d, this.f, true, this.a, this.h, this.e);
        }

        @CheckReturnValue
        State a(Substream substream) {
            Collection unmodifiableCollection;
            Preconditions.checkState(!this.h, "hedging frozen");
            Preconditions.checkState(this.f == null, "already committed");
            Collection<Substream> collection = this.d;
            if (collection == null) {
                unmodifiableCollection = Collections.singleton(substream);
            } else {
                ArrayList arrayList = new ArrayList(collection);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new State(this.b, this.c, unmodifiableCollection, this.f, this.g, this.a, this.h, this.e + 1);
        }

        @CheckReturnValue
        State a(Substream substream, Substream substream2) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(substream);
            arrayList.add(substream2);
            return new State(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
        }

        @CheckReturnValue
        State b() {
            return this.h ? this : new State(this.b, this.c, this.d, this.f, this.g, this.a, true, this.e);
        }

        @CheckReturnValue
        State b(Substream substream) {
            List<BufferEntry> list;
            Collection emptyList;
            boolean z;
            Preconditions.checkState(this.f == null, "Already committed");
            List<BufferEntry> list2 = this.b;
            if (this.c.contains(substream)) {
                list = null;
                emptyList = Collections.singleton(substream);
                z = true;
            } else {
                list = list2;
                emptyList = Collections.emptyList();
                z = false;
            }
            return new State(list, emptyList, this.d, substream, this.g, z, this.h, this.e);
        }

        @CheckReturnValue
        State c(Substream substream) {
            ArrayList arrayList = new ArrayList(this.d);
            arrayList.remove(substream);
            return new State(this.b, this.c, Collections.unmodifiableCollection(arrayList), this.f, this.g, this.a, this.h, this.e);
        }

        @CheckReturnValue
        State d(Substream substream) {
            substream.b = true;
            if (!this.c.contains(substream)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.c);
            arrayList.remove(substream);
            return new State(this.b, Collections.unmodifiableCollection(arrayList), this.d, this.f, this.g, this.a, this.h, this.e);
        }

        @CheckReturnValue
        State e(Substream substream) {
            Collection unmodifiableCollection;
            List<BufferEntry> list;
            Preconditions.checkState(!this.a, "Already passThrough");
            if (substream.b) {
                unmodifiableCollection = this.c;
            } else if (this.c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.c);
                arrayList.add(substream);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            boolean z = this.f != null;
            List<BufferEntry> list2 = this.b;
            if (z) {
                Preconditions.checkState(this.f == substream, "Another RPC attempt has already committed");
                list = null;
            } else {
                list = list2;
            }
            return new State(list, collection, this.d, this.f, this.g, z, this.h, this.e);
        }
    }

    /* loaded from: classes2.dex */
    private final class Sublistener implements ClientStreamListener {
        final Substream a;

        Sublistener(Substream substream) {
            this.a = substream;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private io.grpc.internal.RetriableStream.RetryPlan makeRetryDecision(io.grpc.Status r13, io.grpc.Metadata r14) {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.Sublistener.makeRetryDecision(io.grpc.Status, io.grpc.Metadata):io.grpc.internal.RetriableStream$RetryPlan");
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(Status status, Metadata metadata) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
        
            if (r4.b.retryPolicy.a == 1) goto L38;
         */
        @Override // io.grpc.internal.ClientStreamListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void closed(io.grpc.Status r5, io.grpc.internal.ClientStreamListener.RpcProgress r6, io.grpc.Metadata r7) {
            /*
                Method dump skipped, instructions count: 442
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.Sublistener.closed(io.grpc.Status, io.grpc.internal.ClientStreamListener$RpcProgress, io.grpc.Metadata):void");
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(Metadata metadata) {
            RetriableStream.this.commitAndRun(this.a);
            if (RetriableStream.this.state.f == this.a) {
                RetriableStream.this.masterListener.headersRead(metadata);
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.c();
                }
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            State state = RetriableStream.this.state;
            Preconditions.checkState(state.f != null, "Headers should be received prior to messages.");
            if (state.f != this.a) {
                return;
            }
            RetriableStream.this.masterListener.messagesAvailable(messageProducer);
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (RetriableStream.this.state.c.contains(this.a)) {
                RetriableStream.this.masterListener.onReady();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Substream {
        ClientStream a;
        boolean b;
        boolean c;
        final int d;

        Substream(int i) {
            this.d = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        final int a;
        final int b;
        final int c;
        final AtomicInteger d = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Throttle(float f, float f2) {
            this.c = (int) (f2 * 1000.0f);
            this.a = (int) (f * 1000.0f);
            int i = this.a;
            this.b = i / 2;
            this.d.set(i);
        }

        @VisibleForTesting
        boolean a() {
            return this.d.get() > this.b;
        }

        @VisibleForTesting
        boolean b() {
            int i;
            int i2;
            do {
                i = this.d.get();
                if (i == 0) {
                    return false;
                }
                i2 = i + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } while (!this.d.compareAndSet(i, Math.max(i2, 0)));
            return i2 > this.b;
        }

        @VisibleForTesting
        void c() {
            int i;
            int i2;
            do {
                i = this.d.get();
                i2 = this.a;
                if (i == i2) {
                    return;
                }
            } while (!this.d.compareAndSet(i, Math.min(this.c + i, i2)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Throttle)) {
                return false;
            }
            Throttle throttle = (Throttle) obj;
            return this.a == throttle.a && this.c == throttle.c;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.a), Integer.valueOf(this.c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, Metadata metadata, ChannelBufferMeter channelBufferMeter, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, RetryPolicy.Provider provider, HedgingPolicy.Provider provider2, @Nullable Throttle throttle) {
        this.method = methodDescriptor;
        this.channelBufferUsed = channelBufferMeter;
        this.perRpcBufferLimit = j;
        this.channelBufferLimit = j2;
        this.callExecutor = executor;
        this.scheduledExecutorService = scheduledExecutorService;
        this.headers = metadata;
        this.retryPolicyProvider = (RetryPolicy.Provider) Preconditions.checkNotNull(provider, "retryPolicyProvider");
        this.hedgingPolicyProvider = (HedgingPolicy.Provider) Preconditions.checkNotNull(provider2, "hedgingPolicyProvider");
        this.throttle = throttle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(final Substream substream) {
        final Future<?> future;
        final Future<?> future2;
        synchronized (this.lock) {
            if (this.state.f != null) {
                return null;
            }
            final Collection<Substream> collection = this.state.c;
            this.state = this.state.b(substream);
            this.channelBufferUsed.a(-this.perRpcBufferUsed);
            if (this.scheduledRetry != null) {
                Future<?> b2 = this.scheduledRetry.b();
                this.scheduledRetry = null;
                future = b2;
            } else {
                future = null;
            }
            if (this.scheduledHedging != null) {
                Future<?> b3 = this.scheduledHedging.b();
                this.scheduledHedging = null;
                future2 = b3;
            } else {
                future2 = null;
            }
            return new Runnable() { // from class: io.grpc.internal.RetriableStream.1CommitTask
                @Override // java.lang.Runnable
                public void run() {
                    for (Substream substream2 : collection) {
                        if (substream2 != substream) {
                            substream2.a.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    Future future3 = future;
                    if (future3 != null) {
                        future3.cancel(false);
                    }
                    Future future4 = future2;
                    if (future4 != null) {
                        future4.cancel(false);
                    }
                    RetriableStream.this.a();
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitAndRun(Substream substream) {
        Runnable commit = commit(substream);
        if (commit != null) {
            commit.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Substream createSubstream(int i) {
        Substream substream = new Substream(i);
        final BufferSizeTracer bufferSizeTracer = new BufferSizeTracer(substream);
        substream.a = a(new ClientStreamTracer.Factory(this) { // from class: io.grpc.internal.RetriableStream.1
            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return bufferSizeTracer;
            }
        }, a(this.headers, i));
        return substream;
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> collection;
        synchronized (this.lock) {
            if (!this.state.a) {
                this.state.b.add(bufferEntry);
            }
            collection = this.state.c;
        }
        Iterator<Substream> it = collection.iterator();
        while (it.hasNext()) {
            bufferEntry.runWith(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drain(Substream substream) {
        ArrayList<BufferEntry> arrayList = null;
        int i = 0;
        while (true) {
            synchronized (this.lock) {
                State state = this.state;
                if (state.f != null && state.f != substream) {
                    substream.a.cancel(CANCELLED_BECAUSE_COMMITTED);
                    return;
                }
                if (i == state.b.size()) {
                    this.state = state.e(substream);
                    return;
                }
                if (substream.b) {
                    return;
                }
                int min = Math.min(i + 128, state.b.size());
                if (arrayList == null) {
                    arrayList = new ArrayList(state.b.subList(i, min));
                } else {
                    arrayList.clear();
                    arrayList.addAll(state.b.subList(i, min));
                }
                for (BufferEntry bufferEntry : arrayList) {
                    State state2 = this.state;
                    Substream substream2 = state2.f;
                    if (substream2 == null || substream2 == substream) {
                        if (state2.g) {
                            Preconditions.checkState(state2.f == substream, "substream should be CANCELLED_BECAUSE_COMMITTED already");
                            return;
                        }
                        bufferEntry.runWith(substream);
                    }
                }
                i = min;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> future;
        synchronized (this.lock) {
            if (this.scheduledHedging != null) {
                future = this.scheduledHedging.b();
                this.scheduledHedging = null;
            } else {
                future = null;
            }
            this.state = this.state.b();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean hasPotentialHedging(State state) {
        return state.f == null && state.e < this.hedgingPolicy.a && !state.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushbackHedging(@Nullable Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            freezeHedging();
            return;
        }
        synchronized (this.lock) {
            if (this.scheduledHedging == null) {
                return;
            }
            Future<?> b2 = this.scheduledHedging.b();
            FutureCanceller futureCanceller = new FutureCanceller(this.lock);
            this.scheduledHedging = futureCanceller;
            if (b2 != null) {
                b2.cancel(false);
            }
            futureCanceller.a(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    @VisibleForTesting
    final Metadata a(Metadata metadata, int i) {
        Metadata metadata2 = new Metadata();
        metadata2.merge(metadata);
        if (i > 0) {
            metadata2.put(a, String.valueOf(i));
        }
        return metadata2;
    }

    abstract ClientStream a(ClientStreamTracer.Factory factory, Metadata metadata);

    abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(final ReqT reqt) {
        State state = this.state;
        if (state.a) {
            state.f.a.writeMessage(this.method.streamRequest(reqt));
        } else {
            delayOrExecute(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1SendMessageEntry
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.a.writeMessage(RetriableStream.this.method.streamRequest(reqt));
                }
            });
        }
    }

    @CheckReturnValue
    @Nullable
    abstract Status b();

    @Override // io.grpc.internal.ClientStream
    public final void cancel(Status status) {
        Substream substream = new Substream(0);
        substream.a = new NoopClientStream();
        Runnable commit = commit(substream);
        if (commit != null) {
            this.masterListener.closed(status, new Metadata());
            commit.run();
        } else {
            this.state.f.a.cancel(status);
            synchronized (this.lock) {
                this.state = this.state.a();
            }
        }
    }

    @Override // io.grpc.internal.Stream
    public final void flush() {
        State state = this.state;
        if (state.a) {
            state.f.a.flush();
        } else {
            delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1FlushEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.a.flush();
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final Attributes getAttributes() {
        return this.state.f != null ? this.state.f.a.getAttributes() : Attributes.EMPTY;
    }

    @Override // io.grpc.internal.ClientStream
    public final void halfClose() {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1HalfCloseEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final boolean isReady() {
        Iterator<Substream> it = this.state.c.iterator();
        while (it.hasNext()) {
            if (it.next().a.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public final void request(final int i) {
        State state = this.state;
        if (state.a) {
            state.f.a.request(i);
        } else {
            delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1RequestEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.a.request(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public final void setAuthority(final String str) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1AuthorityEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1CompressorEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1DeadlineEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setDeadline(deadline);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1DecompressorRegistryEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setFullStreamDecompression(final boolean z) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1FullStreamDecompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setFullStreamDecompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxInboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1MaxInboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setMaxInboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void setMaxOutboundMessageSize(final int i) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1MaxOutboundMessageSizeEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setMaxOutboundMessageSize(i);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public final void setMessageCompression(final boolean z) {
        delayOrExecute(new BufferEntry(this) { // from class: io.grpc.internal.RetriableStream.1MessageCompressionEntry
            @Override // io.grpc.internal.RetriableStream.BufferEntry
            public void runWith(Substream substream) {
                substream.a.setMessageCompression(z);
            }
        });
    }

    @Override // io.grpc.internal.ClientStream
    public final void start(ClientStreamListener clientStreamListener) {
        this.masterListener = clientStreamListener;
        Status b2 = b();
        if (b2 != null) {
            cancel(b2);
            return;
        }
        synchronized (this.lock) {
            this.state.b.add(new BufferEntry() { // from class: io.grpc.internal.RetriableStream.1StartEntry
                @Override // io.grpc.internal.RetriableStream.BufferEntry
                public void runWith(Substream substream) {
                    substream.a.start(new Sublistener(substream));
                }
            });
        }
        Substream createSubstream = createSubstream(0);
        Preconditions.checkState(this.hedgingPolicy == null, "hedgingPolicy has been initialized unexpectedly");
        this.hedgingPolicy = this.hedgingPolicyProvider.get();
        if (!HedgingPolicy.d.equals(this.hedgingPolicy)) {
            this.isHedging = true;
            this.retryPolicy = RetryPolicy.f;
            FutureCanceller futureCanceller = null;
            synchronized (this.lock) {
                this.state = this.state.a(createSubstream);
                if (hasPotentialHedging(this.state) && (this.throttle == null || this.throttle.a())) {
                    futureCanceller = new FutureCanceller(this.lock);
                    this.scheduledHedging = futureCanceller;
                }
            }
            if (futureCanceller != null) {
                futureCanceller.a(this.scheduledExecutorService.schedule(new HedgingRunnable(futureCanceller), this.hedgingPolicy.b, TimeUnit.NANOSECONDS));
            }
        }
        drain(createSubstream);
    }

    @Override // io.grpc.internal.Stream
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
