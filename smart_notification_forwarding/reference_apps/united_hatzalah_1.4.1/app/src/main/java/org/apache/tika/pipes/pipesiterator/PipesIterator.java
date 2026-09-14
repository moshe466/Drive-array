package org.apache.tika.pipes.pipesiterator;

import e0.a;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import n3.b;
import n3.d;
import org.apache.tika.config.ConfigBase;
import org.apache.tika.config.Field;
import org.apache.tika.config.Initializable;
import org.apache.tika.config.InitializableProblemHandler;
import org.apache.tika.config.Param;
import org.apache.tika.exception.TikaConfigException;
import org.apache.tika.exception.TikaTimeoutException;
import org.apache.tika.pipes.FetchEmitTuple;
import org.apache.tika.pipes.HandlerConfig;
import org.apache.tika.sax.BasicContentHandlerFactory;

/* loaded from: classes.dex */
public abstract class PipesIterator extends ConfigBase implements Callable<Integer>, Iterable<FetchEmitTuple>, Initializable {
    public static final long DEFAULT_MAX_WAIT_MS = 300000;
    public static final int DEFAULT_QUEUE_SIZE = 1000;
    private String emitterName;
    private String fetcherName;
    private FutureTask<Integer> futureTask;
    public static final FetchEmitTuple COMPLETED_SEMAPHORE = new FetchEmitTuple(null, null, null, null, null, null);
    private static final b LOGGER = d.b(PipesIterator.class);
    private long maxWaitMs = 300000;
    private ArrayBlockingQueue<FetchEmitTuple> queue = null;
    private int queueSize = 1000;
    private FetchEmitTuple.ON_PARSE_EXCEPTION onParseException = FetchEmitTuple.ON_PARSE_EXCEPTION.EMIT;
    private BasicContentHandlerFactory.HANDLER_TYPE handlerType = BasicContentHandlerFactory.HANDLER_TYPE.TEXT;
    private HandlerConfig.PARSE_MODE parseMode = HandlerConfig.PARSE_MODE.RMETA;
    private boolean throwOnWriteLimitReached = false;
    private int writeLimit = -1;
    private int maxEmbeddedResources = -1;
    private int added = 0;

    /* loaded from: classes.dex */
    public class TupleIterator implements Iterator<FetchEmitTuple> {
        FetchEmitTuple next;

        public /* synthetic */ TupleIterator(PipesIterator pipesIterator, int i) {
            this();
        }

        private void checkThreadOk() {
            if (PipesIterator.this.futureTask.isDone()) {
                try {
                    PipesIterator.this.futureTask.get();
                } catch (ExecutionException e4) {
                    throw new RuntimeException(e4.getCause());
                }
            }
        }

        private FetchEmitTuple pollNext() {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                FetchEmitTuple fetchEmitTuple = null;
                while (fetchEmitTuple == null) {
                    if (currentTimeMillis2 >= PipesIterator.this.maxWaitMs) {
                        break;
                    }
                    checkThreadOk();
                    fetchEmitTuple = (FetchEmitTuple) PipesIterator.this.queue.poll(100L, TimeUnit.MILLISECONDS);
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                }
                if (fetchEmitTuple == null) {
                    throw new TikaTimeoutException("waited longer than " + PipesIterator.this.maxWaitMs + "ms for the next tuple");
                }
                return fetchEmitTuple;
            } catch (InterruptedException unused) {
                PipesIterator.LOGGER.u("interrupted");
                return PipesIterator.COMPLETED_SEMAPHORE;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next == null) {
                this.next = pollNext();
            }
            if (this.next != PipesIterator.COMPLETED_SEMAPHORE) {
                return true;
            }
            return false;
        }

        private TupleIterator() {
            this.next = null;
        }

        @Override // java.util.Iterator
        public FetchEmitTuple next() {
            FetchEmitTuple fetchEmitTuple = this.next;
            if (fetchEmitTuple != PipesIterator.COMPLETED_SEMAPHORE) {
                this.next = pollNext();
                return fetchEmitTuple;
            }
            throw new IllegalStateException("don't call next() after hasNext() has returned false!");
        }
    }

    public static PipesIterator build(Path path) {
        InputStream newInputStream;
        newInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            PipesIterator pipesIterator = (PipesIterator) ConfigBase.buildSingle("pipesIterator", PipesIterator.class, newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return pipesIterator;
        } catch (Throwable th) {
            if (newInputStream != null) {
                try {
                    newInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.apache.tika.config.Initializable
    public void checkInitialization(InitializableProblemHandler initializableProblemHandler) {
    }

    public abstract void enqueue();

    public String getEmitterName() {
        return this.emitterName;
    }

    public String getFetcherName() {
        return this.fetcherName;
    }

    public HandlerConfig getHandlerConfig() {
        return new HandlerConfig(this.handlerType, this.parseMode, this.writeLimit, this.maxEmbeddedResources, this.throwOnWriteLimitReached);
    }

    public FetchEmitTuple.ON_PARSE_EXCEPTION getOnParseException() {
        return this.onParseException;
    }

    @Override // org.apache.tika.config.Initializable
    public void initialize(Map<String, Param> map) {
    }

    @Override // java.lang.Iterable
    public Iterator<FetchEmitTuple> iterator() {
        if (this.futureTask == null) {
            this.futureTask = new FutureTask<>(this);
            this.queue = new ArrayBlockingQueue<>(this.queueSize);
            new Thread(this.futureTask).start();
            return new TupleIterator(this, 0);
        }
        throw new IllegalStateException("Can't call iterator more than once!");
    }

    @Field
    public void setEmitterName(String str) {
        this.emitterName = str;
    }

    @Field
    public void setFetcherName(String str) {
        this.fetcherName = str;
    }

    @Field
    public void setHandlerType(String str) {
        this.handlerType = BasicContentHandlerFactory.parseHandlerType(str, BasicContentHandlerFactory.HANDLER_TYPE.TEXT);
    }

    @Field
    public void setMaxEmbeddedResources(int i) {
        this.maxEmbeddedResources = i;
    }

    @Field
    public void setMaxWaitMs(long j2) {
        this.maxWaitMs = j2;
    }

    @Field
    public void setOnParseException(String str) {
        if ("skip".equalsIgnoreCase(str)) {
            setOnParseException(FetchEmitTuple.ON_PARSE_EXCEPTION.SKIP);
        } else {
            if ("emit".equalsIgnoreCase(str)) {
                setOnParseException(FetchEmitTuple.ON_PARSE_EXCEPTION.EMIT);
                return;
            }
            throw new TikaConfigException(a.d("must be either 'skip' or 'emit': ", str));
        }
    }

    @Field
    public void setParseMode(String str) {
        setParseMode(HandlerConfig.PARSE_MODE.parseMode(str));
    }

    @Field
    public void setQueueSize(int i) {
        this.queueSize = i;
    }

    @Field
    public void setThrowOnWriteLimitReached(boolean z3) {
        this.throwOnWriteLimitReached = z3;
    }

    @Field
    public void setWriteLimit(int i) {
        this.writeLimit = i;
    }

    public void tryToAdd(FetchEmitTuple fetchEmitTuple) {
        this.added++;
        if (this.queue.offer(fetchEmitTuple, this.maxWaitMs, TimeUnit.MILLISECONDS)) {
        } else {
            throw new TimeoutException("timed out while offering");
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        enqueue();
        tryToAdd(COMPLETED_SEMAPHORE);
        return Integer.valueOf(this.added);
    }

    public void setParseMode(HandlerConfig.PARSE_MODE parse_mode) {
        this.parseMode = parse_mode;
    }

    public void setOnParseException(FetchEmitTuple.ON_PARSE_EXCEPTION on_parse_exception) {
        this.onParseException = on_parse_exception;
    }
}
