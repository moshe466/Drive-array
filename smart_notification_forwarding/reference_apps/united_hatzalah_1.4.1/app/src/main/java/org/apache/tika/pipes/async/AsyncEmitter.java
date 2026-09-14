package org.apache.tika.pipes.async;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import n3.b;
import n3.d;
import org.apache.tika.pipes.emitter.EmitData;
import org.apache.tika.pipes.emitter.Emitter;
import org.apache.tika.pipes.emitter.EmitterManager;
import org.apache.tika.pipes.emitter.TikaEmitterException;
import org.apache.tika.utils.ExceptionUtils;

/* loaded from: classes.dex */
public class AsyncEmitter implements Callable<Integer> {
    static final int EMITTER_FUTURE_CODE = 2;
    static final EmitData EMIT_DATA_STOP_SEMAPHORE = new EmitData(null, null, null);
    private static final b LOG = d.b(AsyncEmitter.class);
    private final AsyncConfig asyncConfig;
    private final ArrayBlockingQueue<EmitData> emitDataQueue;
    private final EmitterManager emitterManager;
    Instant lastEmitted;

    /* loaded from: classes.dex */
    public class EmitDataCache {
        private final long maxBytes;
        long estimatedSize = 0;
        int size = 0;
        Map<String, List<EmitData>> map = new HashMap();

        public EmitDataCache(long j2) {
            this.maxBytes = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void emitAll() {
            Instant now;
            AsyncEmitter.LOG.y(Integer.valueOf(this.size), "about to emit {} files, {} estimated bytes", Long.valueOf(this.estimatedSize));
            int i = 0;
            for (Map.Entry<String, List<EmitData>> entry : this.map.entrySet()) {
                tryToEmit(AsyncEmitter.this.emitterManager.getEmitter(entry.getKey()), entry.getValue());
                i += entry.getValue().size();
            }
            AsyncEmitter.LOG.x(Integer.valueOf(i), "emitted: {} files");
            this.estimatedSize = 0L;
            this.size = 0;
            this.map.clear();
            AsyncEmitter asyncEmitter = AsyncEmitter.this;
            now = Instant.now();
            asyncEmitter.lastEmitted = now;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$add$0(String str) {
            return new ArrayList();
        }

        private void tryToEmit(Emitter emitter, List<EmitData> list) {
            try {
                emitter.emit(list);
            } catch (IOException | TikaEmitterException e4) {
                AsyncEmitter.LOG.r(emitter.getClass(), "emitter class ({}): {}", ExceptionUtils.getStackTrace(e4));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void add(EmitData emitData) {
            this.size++;
            long estimatedSizeBytes = emitData.getEstimatedSizeBytes();
            if (this.estimatedSize + estimatedSizeBytes > this.maxBytes) {
                AsyncEmitter.LOG.y(Long.valueOf(this.estimatedSize + estimatedSizeBytes), "estimated size ({}) > maxBytes({}), going to emitAll", Long.valueOf(this.maxBytes));
                emitAll();
            }
            List list = (List) this.map.computeIfAbsent(emitData.getEmitKey().getEmitterName(), new Object());
            updateEstimatedSize(estimatedSizeBytes);
            list.add(emitData);
        }

        public void updateEstimatedSize(long j2) {
            this.estimatedSize += j2;
        }
    }

    public AsyncEmitter(AsyncConfig asyncConfig, ArrayBlockingQueue<EmitData> arrayBlockingQueue, EmitterManager emitterManager) {
        Instant now;
        now = Instant.now();
        this.lastEmitted = now;
        this.asyncConfig = asyncConfig;
        this.emitDataQueue = arrayBlockingQueue;
        this.emitterManager = emitterManager;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        Instant now;
        long between;
        ChronoUnit unused;
        EmitDataCache emitDataCache = new EmitDataCache(this.asyncConfig.getEmitMaxEstimatedBytes());
        while (true) {
            EmitData poll = this.emitDataQueue.poll(500L, TimeUnit.MILLISECONDS);
            if (poll == EMIT_DATA_STOP_SEMAPHORE) {
                emitDataCache.emitAll();
                return 2;
            }
            if (poll != null) {
                emitDataCache.add(poll);
            } else {
                LOG.v("Nothing on the async queue");
            }
            b bVar = LOG;
            bVar.y(Long.valueOf(emitDataCache.estimatedSize), "cache size: ({}) bytes and extract count: {}", Integer.valueOf(emitDataCache.size));
            unused = ChronoUnit.MILLIS;
            Instant instant = this.lastEmitted;
            now = Instant.now();
            between = ChronoUnit.MILLIS.between(instant, now);
            if (between > this.asyncConfig.getEmitWithinMillis()) {
                bVar.y(Long.valueOf(between), "{} elapsed > {}, going to emitAll", Long.valueOf(this.asyncConfig.getEmitWithinMillis()));
                emitDataCache.emitAll();
            }
        }
    }
}
