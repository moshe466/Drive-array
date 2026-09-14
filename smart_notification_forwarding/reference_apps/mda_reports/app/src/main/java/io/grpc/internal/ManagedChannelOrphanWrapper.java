package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.ManagedChannel;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ManagedChannelOrphanWrapper extends ForwardingManagedChannel {
    private final ManagedChannelReference phantom;
    private static final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue = new ReferenceQueue<>();
    private static final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs = new ConcurrentHashMap();
    private static final Logger logger = Logger.getLogger(ManagedChannelOrphanWrapper.class.getName());

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static final class ManagedChannelReference extends WeakReference<ManagedChannelOrphanWrapper> {
        private static final String ALLOCATION_SITE_PROPERTY_NAME = "io.grpc.ManagedChannel.enableAllocationTracking";
        private static final boolean ENABLE_ALLOCATION_TRACKING = Boolean.parseBoolean(System.getProperty(ALLOCATION_SITE_PROPERTY_NAME, "true"));
        private static final RuntimeException missingCallSite = missingCallSite();
        private final Reference<RuntimeException> allocationSite;
        private final String channelStr;
        private final ReferenceQueue<ManagedChannelOrphanWrapper> refqueue;
        private final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> refs;
        private volatile boolean shutdown;

        ManagedChannelReference(ManagedChannelOrphanWrapper managedChannelOrphanWrapper, ManagedChannel managedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
            super(managedChannelOrphanWrapper, referenceQueue);
            this.allocationSite = new SoftReference(ENABLE_ALLOCATION_TRACKING ? new RuntimeException("ManagedChannel allocation site") : missingCallSite);
            this.channelStr = managedChannel.toString();
            this.refqueue = referenceQueue;
            this.refs = concurrentMap;
            this.refs.put(this, this);
            a(referenceQueue);
        }

        @VisibleForTesting
        static int a(ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue) {
            int i = 0;
            while (true) {
                ManagedChannelReference managedChannelReference = (ManagedChannelReference) referenceQueue.poll();
                if (managedChannelReference == null) {
                    return i;
                }
                RuntimeException runtimeException = managedChannelReference.allocationSite.get();
                managedChannelReference.clearInternal();
                if (!managedChannelReference.shutdown) {
                    i++;
                    Level level = Level.SEVERE;
                    if (ManagedChannelOrphanWrapper.logger.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Channel {0} was not shutdown properly!!! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow() and wait until awaitTermination() returns true.");
                        logRecord.setLoggerName(ManagedChannelOrphanWrapper.logger.getName());
                        logRecord.setParameters(new Object[]{managedChannelReference.channelStr});
                        logRecord.setThrown(runtimeException);
                        ManagedChannelOrphanWrapper.logger.log(logRecord);
                    }
                }
            }
        }

        private void clearInternal() {
            super.clear();
            this.refs.remove(this);
            this.allocationSite.clear();
        }

        private static RuntimeException missingCallSite() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            clearInternal();
            a(this.refqueue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagedChannelOrphanWrapper(ManagedChannel managedChannel) {
        this(managedChannel, refqueue, refs);
    }

    @VisibleForTesting
    ManagedChannelOrphanWrapper(ManagedChannel managedChannel, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
        super(managedChannel);
        this.phantom = new ManagedChannelReference(this, managedChannel, referenceQueue, concurrentMap);
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.phantom.shutdown = true;
        this.phantom.clear();
        return super.shutdown();
    }

    @Override // io.grpc.internal.ForwardingManagedChannel, io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.phantom.shutdown = true;
        this.phantom.clear();
        return super.shutdownNow();
    }
}
