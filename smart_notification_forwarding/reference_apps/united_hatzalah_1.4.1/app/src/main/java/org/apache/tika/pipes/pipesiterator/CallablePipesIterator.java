package org.apache.tika.pipes.pipesiterator;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.tika.pipes.FetchEmitTuple;

/* loaded from: classes.dex */
public class CallablePipesIterator implements Callable<Long> {
    private final int numConsumers;
    private final PipesIterator pipesIterator;
    private final ArrayBlockingQueue<FetchEmitTuple> queue;
    private final long timeoutMillis;

    public CallablePipesIterator(PipesIterator pipesIterator, ArrayBlockingQueue<FetchEmitTuple> arrayBlockingQueue) {
        this(pipesIterator, arrayBlockingQueue, -1L);
    }

    public CallablePipesIterator(PipesIterator pipesIterator, ArrayBlockingQueue<FetchEmitTuple> arrayBlockingQueue, long j2) {
        this(pipesIterator, arrayBlockingQueue, j2, 1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Long call() {
        long j2 = 0;
        int i = 0;
        if (this.timeoutMillis > 0) {
            Iterator<FetchEmitTuple> it = this.pipesIterator.iterator();
            while (it.hasNext()) {
                if (!this.queue.offer(it.next(), this.timeoutMillis, TimeUnit.MILLISECONDS)) {
                    throw new TimeoutException("timed out trying to offer tuple");
                }
                j2++;
            }
            while (i < this.numConsumers) {
                if (!this.queue.offer(PipesIterator.COMPLETED_SEMAPHORE, this.timeoutMillis, TimeUnit.MILLISECONDS)) {
                    throw new TimeoutException("timed out trying to offer the completed semaphore");
                }
                i++;
            }
        } else {
            Iterator<FetchEmitTuple> it2 = this.pipesIterator.iterator();
            while (it2.hasNext()) {
                this.queue.put(it2.next());
                j2++;
            }
            while (i < this.numConsumers) {
                this.queue.put(PipesIterator.COMPLETED_SEMAPHORE);
                i++;
            }
        }
        return Long.valueOf(j2);
    }

    public CallablePipesIterator(PipesIterator pipesIterator, ArrayBlockingQueue<FetchEmitTuple> arrayBlockingQueue, long j2, int i) {
        this.pipesIterator = pipesIterator;
        this.queue = arrayBlockingQueue;
        this.timeoutMillis = j2;
        this.numConsumers = i;
    }
}
