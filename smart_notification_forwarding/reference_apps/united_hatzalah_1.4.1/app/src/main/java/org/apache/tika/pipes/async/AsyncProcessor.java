package org.apache.tika.pipes.async;

import F0.RunnableC0064o;
import com.google.firebase.crashlytics.internal.common.h;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import n3.b;
import n3.d;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.PipesClient;
import org.apache.tika.pipes.PipesReporter;
import org.apache.tika.pipes.PipesResult;
import org.apache.tika.pipes.emitter.EmitData;
import org.apache.tika.pipes.emitter.EmitterManager;
import org.apache.tika.pipes.pipesiterator.PipesIterator;
import org.apache.tika.pipes.pipesiterator.TotalCountResult;
import org.apache.tika.pipes.pipesiterator.TotalCounter;

/* loaded from: classes.dex */
public class AsyncProcessor implements Closeable {
    private static final b LOG = d.b(AsyncProcessor.class);
    private static long MAX_OFFER_WAIT_MS = 120000;
    static final int PARSER_FUTURE_CODE = 1;
    static final int WATCHER_FUTURE_CODE = 3;
    private boolean addedEmitterSemaphores;
    private final AsyncConfig asyncConfig;
    private final ArrayBlockingQueue<EmitData> emitData;
    private final ExecutorCompletionService<Integer> executorCompletionService;
    private final ExecutorService executorService;
    private final ArrayBlockingQueue<FetchEmitTuple> fetchEmitTuples;
    boolean isShuttingDown;
    private volatile int numEmitterThreadsFinished;
    private volatile int numParserThreadsFinished;
    private final AtomicLong totalProcessed;

    /* loaded from: classes.dex */
    public class FetchEmitWorker implements Callable<Integer> {
        private final AsyncConfig asyncConfig;
        private final ArrayBlockingQueue<EmitData> emitDataQueue;
        private final ArrayBlockingQueue<FetchEmitTuple> fetchEmitTuples;

        public /* synthetic */ FetchEmitWorker(AsyncProcessor asyncProcessor, AsyncConfig asyncConfig, ArrayBlockingQueue arrayBlockingQueue, ArrayBlockingQueue arrayBlockingQueue2, int i) {
            this(asyncConfig, arrayBlockingQueue, arrayBlockingQueue2);
        }

        private boolean shouldEmit(PipesResult pipesResult) {
            if (pipesResult.getStatus() == PipesResult.STATUS.PARSE_SUCCESS || pipesResult.getStatus() == PipesResult.STATUS.PARSE_SUCCESS_WITH_EXCEPTION) {
                return true;
            }
            if (pipesResult.isIntermediate() && this.asyncConfig.isEmitIntermediateResults()) {
                return true;
            }
            return false;
        }

        private FetchEmitWorker(AsyncConfig asyncConfig, ArrayBlockingQueue<FetchEmitTuple> arrayBlockingQueue, ArrayBlockingQueue<EmitData> arrayBlockingQueue2) {
            this.asyncConfig = asyncConfig;
            this.fetchEmitTuples = arrayBlockingQueue;
            this.emitDataQueue = arrayBlockingQueue2;
        }

        @Override // java.util.concurrent.Callable
        public Integer call() {
            PipesResult pipesResult;
            PipesClient pipesClient = new PipesClient(this.asyncConfig);
            while (true) {
                try {
                    FetchEmitTuple poll = this.fetchEmitTuples.poll(1L, TimeUnit.SECONDS);
                    if (poll == null) {
                        if (AsyncProcessor.LOG.k()) {
                            AsyncProcessor.LOG.v("null fetch emit tuple");
                        }
                    } else {
                        if (poll == PipesIterator.COMPLETED_SEMAPHORE) {
                            if (AsyncProcessor.LOG.k()) {
                                AsyncProcessor.LOG.v("hit completed semaphore");
                            }
                            pipesClient.close();
                            return 1;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            pipesResult = pipesClient.process(poll);
                        } catch (IOException e4) {
                            AsyncProcessor.LOG.p("pipesClient crash", e4);
                            pipesResult = PipesResult.UNSPECIFIED_CRASH;
                        }
                        if (AsyncProcessor.LOG.k()) {
                            AsyncProcessor.LOG.f(Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "timer -- pipes client process: {} ms");
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (shouldEmit(pipesResult)) {
                            AsyncProcessor.LOG.v("adding result to emitter queue: " + pipesResult.getEmitData());
                            if (!this.emitDataQueue.offer(pipesResult.getEmitData(), AsyncProcessor.MAX_OFFER_WAIT_MS, TimeUnit.MILLISECONDS)) {
                                throw new RuntimeException("Couldn't offer emit data to queue within " + AsyncProcessor.MAX_OFFER_WAIT_MS + " ms");
                            }
                        }
                        if (AsyncProcessor.LOG.k()) {
                            AsyncProcessor.LOG.f(Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), "timer -- offered: {} ms");
                        }
                        this.asyncConfig.getPipesReporter().report(poll, pipesResult, System.currentTimeMillis() - currentTimeMillis);
                        AsyncProcessor.this.totalProcessed.incrementAndGet();
                    }
                } catch (Throwable th) {
                    try {
                        pipesClient.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    public AsyncProcessor(Path path) {
        this(path, null);
    }

    public /* synthetic */ Integer lambda$new$0() {
        while (true) {
            try {
                Thread.sleep(500L);
                checkActive();
            } catch (InterruptedException unused) {
                return 3;
            }
        }
    }

    public /* synthetic */ void lambda$startCounter$1(TotalCounter totalCounter) {
        totalCounter.startTotalCount();
        PipesReporter pipesReporter = this.asyncConfig.getPipesReporter();
        TotalCountResult.STATUS status = totalCounter.getTotalCount().getStatus();
        while (status == TotalCountResult.STATUS.NOT_COMPLETED) {
            try {
                Thread.sleep(500L);
                TotalCountResult totalCount = totalCounter.getTotalCount();
                LOG.m("counter total  {} {} ", totalCount.getStatus(), Long.valueOf(totalCount.getTotalCount()));
                pipesReporter.report(totalCount);
                status = totalCount.getStatus();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    private void startCounter(TotalCounter totalCounter) {
        Thread thread = new Thread(new RunnableC0064o(19, this, totalCounter));
        thread.setDaemon(true);
        thread.start();
    }

    public synchronized boolean checkActive() {
        boolean z3;
        try {
            Future<Integer> poll = this.executorCompletionService.poll();
            z3 = true;
            if (poll != null) {
                try {
                    Integer num = poll.get();
                    int intValue = num.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue == 3) {
                                LOG.j("watcher thread finished");
                            } else {
                                throw new IllegalArgumentException("Don't recognize this future code: " + num);
                            }
                        } else {
                            this.numEmitterThreadsFinished++;
                            LOG.x(Integer.valueOf(this.numEmitterThreadsFinished), "emitter thread finished, total {}");
                        }
                    } else {
                        this.numParserThreadsFinished++;
                        LOG.x(Integer.valueOf(this.numParserThreadsFinished), "fetchEmitWorker finished, total {}");
                    }
                } catch (ExecutionException e4) {
                    LOG.e("execution exception", e4);
                    this.asyncConfig.getPipesReporter().error(e4);
                    throw new RuntimeException(e4);
                }
            }
            if (this.numParserThreadsFinished == this.asyncConfig.getNumClients() && !this.addedEmitterSemaphores) {
                for (int i = 0; i < this.asyncConfig.getNumEmitters(); i++) {
                    try {
                        if (!this.emitData.offer(AsyncEmitter.EMIT_DATA_STOP_SEMAPHORE, MAX_OFFER_WAIT_MS, TimeUnit.MILLISECONDS)) {
                            throw new RuntimeException("Couldn't offer emit data stop semaphore within " + MAX_OFFER_WAIT_MS + " ms");
                        }
                    } catch (InterruptedException e5) {
                        throw new RuntimeException(e5);
                    }
                }
                this.addedEmitterSemaphores = true;
            }
            if (this.numParserThreadsFinished == this.asyncConfig.getNumClients() && this.numEmitterThreadsFinished == this.asyncConfig.getNumEmitters()) {
                z3 = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return z3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.executorService.shutdownNow();
        this.asyncConfig.getPipesReporter().close();
    }

    public void finished() {
        for (int i = 0; i < this.asyncConfig.getNumClients(); i++) {
            if (!this.fetchEmitTuples.offer(PipesIterator.COMPLETED_SEMAPHORE, MAX_OFFER_WAIT_MS, TimeUnit.MILLISECONDS)) {
                throw new RuntimeException("Couldn't offer completed semaphore within " + MAX_OFFER_WAIT_MS + " ms");
            }
        }
    }

    public int getCapacity() {
        return this.fetchEmitTuples.remainingCapacity();
    }

    public long getTotalProcessed() {
        return this.totalProcessed.get();
    }

    public synchronized boolean offer(List<FetchEmitTuple> list, long j2) {
        if (!this.isShuttingDown) {
            if (list.size() <= this.asyncConfig.getQueueSize()) {
                long currentTimeMillis = System.currentTimeMillis();
                for (long currentTimeMillis2 = System.currentTimeMillis(); currentTimeMillis2 - currentTimeMillis < j2; currentTimeMillis2 = System.currentTimeMillis()) {
                    if (this.fetchEmitTuples.remainingCapacity() > list.size()) {
                        try {
                            this.fetchEmitTuples.addAll(list);
                            return true;
                        } catch (IllegalStateException e4) {
                            LOG.s("couldn't add full list", e4);
                        }
                    }
                    Thread.sleep(100L);
                }
                return false;
            }
            throw new OfferLargerThanQueueSize(list.size(), this.asyncConfig.getQueueSize());
        }
        throw new IllegalStateException("Can't call offer after calling close() or shutdownNow()");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncProcessor(Path path, PipesIterator pipesIterator) {
        AsyncProcessor asyncProcessor;
        Exception exc;
        Path absolutePath;
        Path absolutePath2;
        boolean equals;
        Path absolutePath3;
        Path absolutePath4;
        this.totalProcessed = new AtomicLong(0L);
        this.numParserThreadsFinished = 0;
        this.numEmitterThreadsFinished = 0;
        this.addedEmitterSemaphores = false;
        this.isShuttingDown = false;
        AsyncConfig load = AsyncConfig.load(path);
        this.asyncConfig = load;
        this.fetchEmitTuples = new ArrayBlockingQueue<>(load.getQueueSize());
        this.emitData = new ArrayBlockingQueue<>(100);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(load.getNumEmitters() + load.getNumClients() + 1);
        this.executorService = newFixedThreadPool;
        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(newFixedThreadPool);
        this.executorCompletionService = executorCompletionService;
        try {
            absolutePath = path.toAbsolutePath();
            absolutePath2 = load.getTikaConfig().toAbsolutePath();
            equals = absolutePath.equals(absolutePath2);
            if (!equals) {
                try {
                    b bVar = LOG;
                    absolutePath3 = path.toAbsolutePath();
                    absolutePath4 = load.getTikaConfig().toAbsolutePath();
                    bVar.r(absolutePath3, "TikaConfig for AsyncProcessor ({}) is different from TikaConfig for workers ({}). If this is intended, please ignore this warning.", absolutePath4);
                } catch (Exception e4) {
                    exc = e4;
                    asyncProcessor = this;
                    LOG.e("problem initializing AsyncProcessor", exc);
                    asyncProcessor.executorService.shutdownNow();
                    asyncProcessor.asyncConfig.getPipesReporter().error(exc);
                    throw exc;
                }
            }
            executorCompletionService.submit(new h(this, 4));
            if (pipesIterator != 0 && (pipesIterator instanceof TotalCounter)) {
                LOG.j("going to total counts");
                startCounter((TotalCounter) pipesIterator);
            }
            for (int i = 0; i < this.asyncConfig.getNumClients(); i++) {
                asyncProcessor = this;
                try {
                    this.executorCompletionService.submit(new FetchEmitWorker(asyncProcessor, this.asyncConfig, this.fetchEmitTuples, this.emitData, 0));
                } catch (Exception e5) {
                    e = e5;
                    exc = e;
                    LOG.e("problem initializing AsyncProcessor", exc);
                    asyncProcessor.executorService.shutdownNow();
                    asyncProcessor.asyncConfig.getPipesReporter().error(exc);
                    throw exc;
                }
            }
            asyncProcessor = this;
            EmitterManager load2 = EmitterManager.load(asyncProcessor.asyncConfig.getTikaConfig());
            for (int i3 = 0; i3 < asyncProcessor.asyncConfig.getNumEmitters(); i3++) {
                asyncProcessor.executorCompletionService.submit(new AsyncEmitter(asyncProcessor.asyncConfig, asyncProcessor.emitData, load2));
            }
        } catch (Exception e6) {
            e = e6;
            asyncProcessor = this;
        }
    }

    public synchronized boolean offer(FetchEmitTuple fetchEmitTuple, long j2) {
        if (this.fetchEmitTuples != null) {
            if (!this.isShuttingDown) {
                checkActive();
            } else {
                throw new IllegalStateException("Can't call offer after calling close() or shutdownNow()");
            }
        } else {
            throw new IllegalStateException("queue hasn't been initialized yet.");
        }
        return this.fetchEmitTuples.offer(fetchEmitTuple, j2, TimeUnit.MILLISECONDS);
    }
}
