package com.google.firebase.firestore.local;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class LruGarbageCollector {
    private static final long INITIAL_GC_DELAY_MS = TimeUnit.MINUTES.toMillis(1);
    private static final long REGULAR_GC_DELAY_MS = TimeUnit.MINUTES.toMillis(5);
    private final LruDelegate delegate;
    private final Params params;

    /* loaded from: classes2.dex */
    public static class Params {
        private static final long COLLECTION_DISABLED = -1;
        private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600;
        private static final int DEFAULT_COLLECTION_PERCENTILE = 10;
        private static final int DEFAULT_MAX_SEQUENCE_NUMBERS_TO_COLLECT = 1000;
        final long a;
        final int b;
        final int c;

        Params(long j, int i, int i2) {
            this.a = j;
            this.b = i;
            this.c = i2;
        }

        public static Params Default() {
            return new Params(DEFAULT_CACHE_SIZE_BYTES, 10, 1000);
        }

        public static Params Disabled() {
            return new Params(-1L, 0, 0);
        }

        public static Params WithCacheSizeBytes(long j) {
            return new Params(j, 10, 1000);
        }
    }

    /* loaded from: classes2.dex */
    public static class Results {
        private final int documentsRemoved;
        private final boolean hasRun;
        private final int sequenceNumbersCollected;
        private final int targetsRemoved;

        Results(boolean z, int i, int i2, int i3) {
            this.hasRun = z;
            this.sequenceNumbersCollected = i;
            this.targetsRemoved = i2;
            this.documentsRemoved = i3;
        }

        static Results a() {
            return new Results(false, 0, 0, 0);
        }

        public int getDocumentsRemoved() {
            return this.documentsRemoved;
        }

        public int getSequenceNumbersCollected() {
            return this.sequenceNumbersCollected;
        }

        public int getTargetsRemoved() {
            return this.targetsRemoved;
        }

        public boolean hasRun() {
            return this.hasRun;
        }
    }

    /* loaded from: classes2.dex */
    public static class RollingSequenceNumberBuffer {
        private static final Comparator<Long> COMPARATOR;
        private final int maxElements;
        private final PriorityQueue<Long> queue;

        static {
            Comparator<Long> comparator;
            comparator = LruGarbageCollector$RollingSequenceNumberBuffer$$Lambda$1.instance;
            COMPARATOR = comparator;
        }

        RollingSequenceNumberBuffer(int i) {
            this.maxElements = i;
            this.queue = new PriorityQueue<>(i, COMPARATOR);
        }

        long a() {
            return this.queue.peek().longValue();
        }

        public void a(Long l) {
            if (this.queue.size() >= this.maxElements) {
                if (l.longValue() >= this.queue.peek().longValue()) {
                    return;
                } else {
                    this.queue.poll();
                }
            }
            this.queue.add(l);
        }
    }

    /* loaded from: classes2.dex */
    public class Scheduler {
        private final AsyncQueue asyncQueue;

        @Nullable
        private AsyncQueue.DelayedTask gcTask;
        private boolean hasRun = false;
        private final LocalStore localStore;

        public Scheduler(AsyncQueue asyncQueue, LocalStore localStore) {
            this.asyncQueue = asyncQueue;
            this.localStore = localStore;
        }

        public static /* synthetic */ void a(Scheduler scheduler) {
            scheduler.localStore.collectGarbage(LruGarbageCollector.this);
            scheduler.hasRun = true;
            scheduler.scheduleGC();
        }

        private void scheduleGC() {
            this.gcTask = this.asyncQueue.enqueueAfterDelay(AsyncQueue.TimerId.GARBAGE_COLLECTION, this.hasRun ? LruGarbageCollector.REGULAR_GC_DELAY_MS : LruGarbageCollector.INITIAL_GC_DELAY_MS, LruGarbageCollector$Scheduler$$Lambda$1.lambdaFactory$(this));
        }

        public void start() {
            if (LruGarbageCollector.this.params.a != -1) {
                scheduleGC();
            }
        }

        public void stop() {
            AsyncQueue.DelayedTask delayedTask = this.gcTask;
            if (delayedTask != null) {
                delayedTask.cancel();
            }
        }
    }

    public LruGarbageCollector(LruDelegate lruDelegate, Params params) {
        this.delegate = lruDelegate;
        this.params = params;
    }

    private Results runGarbageCollection(SparseArray<?> sparseArray) {
        long currentTimeMillis = System.currentTimeMillis();
        int a = a(this.params.b);
        if (a > this.params.c) {
            Logger.debug("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.params.c + " from " + a, new Object[0]);
            a = this.params.c;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        long b = b(a);
        long currentTimeMillis3 = System.currentTimeMillis();
        int a2 = a(b, sparseArray);
        long currentTimeMillis4 = System.currentTimeMillis();
        int a3 = a(b);
        long currentTimeMillis5 = System.currentTimeMillis();
        if (Logger.isDebugEnabled()) {
            Logger.debug("LruGarbageCollector", (((("LRU Garbage Collection:\n\tCounted targets in " + (currentTimeMillis2 - currentTimeMillis) + "ms\n") + String.format(Locale.ROOT, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(a), Long.valueOf(currentTimeMillis3 - currentTimeMillis2))) + String.format(Locale.ROOT, "\tRemoved %d targets in %dms\n", Integer.valueOf(a2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3))) + String.format(Locale.ROOT, "\tRemoved %d documents in %dms\n", Integer.valueOf(a3), Long.valueOf(currentTimeMillis5 - currentTimeMillis4))) + String.format(Locale.ROOT, "Total Duration: %dms", Long.valueOf(currentTimeMillis5 - currentTimeMillis)), new Object[0]);
        }
        return new Results(true, a, a2, a3);
    }

    int a(int i) {
        return (int) ((i / 100.0f) * ((float) this.delegate.getSequenceNumberCount()));
    }

    int a(long j) {
        return this.delegate.removeOrphanedDocuments(j);
    }

    int a(long j, SparseArray<?> sparseArray) {
        return this.delegate.removeTargets(j, sparseArray);
    }

    long a() {
        return this.delegate.getByteSize();
    }

    public Results a(SparseArray<?> sparseArray) {
        if (this.params.a == -1) {
            Logger.debug("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
        } else {
            long a = a();
            if (a >= this.params.a) {
                return runGarbageCollection(sparseArray);
            }
            Logger.debug("LruGarbageCollector", "Garbage collection skipped; Cache size " + a + " is lower than threshold " + this.params.a, new Object[0]);
        }
        return Results.a();
    }

    long b(int i) {
        if (i == 0) {
            return -1L;
        }
        RollingSequenceNumberBuffer rollingSequenceNumberBuffer = new RollingSequenceNumberBuffer(i);
        this.delegate.forEachTarget(LruGarbageCollector$$Lambda$1.lambdaFactory$(rollingSequenceNumberBuffer));
        this.delegate.forEachOrphanedDocumentSequenceNumber(LruGarbageCollector$$Lambda$2.lambdaFactory$(rollingSequenceNumberBuffer));
        return rollingSequenceNumberBuffer.a();
    }

    public Scheduler newScheduler(AsyncQueue asyncQueue, LocalStore localStore) {
        return new Scheduler(asyncQueue, localStore);
    }
}
