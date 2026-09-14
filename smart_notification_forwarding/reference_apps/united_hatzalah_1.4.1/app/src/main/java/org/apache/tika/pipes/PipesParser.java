package org.apache.tika.pipes;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes.dex */
public class PipesParser implements Closeable {
    private final ArrayBlockingQueue<PipesClient> clientQueue;
    private final List<PipesClient> clients = new ArrayList();
    private final PipesConfig pipesConfig;

    public PipesParser(PipesConfig pipesConfig) {
        this.pipesConfig = pipesConfig;
        this.clientQueue = new ArrayBlockingQueue<>(pipesConfig.getNumClients());
        for (int i = 0; i < pipesConfig.getNumClients(); i++) {
            PipesClient pipesClient = new PipesClient(pipesConfig);
            this.clientQueue.offer(pipesClient);
            this.clients.add(pipesClient);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList arrayList = new ArrayList();
        Iterator<PipesClient> it = this.clients.iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (IOException e4) {
                arrayList.add(e4);
            }
        }
        if (arrayList.size() <= 0) {
        } else {
            throw ((IOException) arrayList.get(0));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r1 != null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.tika.pipes.PipesResult parse(org.apache.tika.pipes.FetchEmitTuple r6) {
        /*
            r5 = this;
            r0 = 0
            java.util.concurrent.ArrayBlockingQueue<org.apache.tika.pipes.PipesClient> r1 = r5.clientQueue     // Catch: java.lang.Throwable -> L25
            org.apache.tika.pipes.PipesConfig r2 = r5.pipesConfig     // Catch: java.lang.Throwable -> L25
            long r2 = r2.getMaxWaitForClientMillis()     // Catch: java.lang.Throwable -> L25
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L25
            java.lang.Object r1 = r1.poll(r2, r4)     // Catch: java.lang.Throwable -> L25
            org.apache.tika.pipes.PipesClient r1 = (org.apache.tika.pipes.PipesClient) r1     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L20
            org.apache.tika.pipes.PipesResult r6 = org.apache.tika.pipes.PipesResult.CLIENT_UNAVAILABLE_WITHIN_MS     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1c
        L17:
            java.util.concurrent.ArrayBlockingQueue<org.apache.tika.pipes.PipesClient> r0 = r5.clientQueue
            r0.offer(r1)
        L1c:
            return r6
        L1d:
            r6 = move-exception
            r0 = r1
            goto L26
        L20:
            org.apache.tika.pipes.PipesResult r6 = r1.process(r6)     // Catch: java.lang.Throwable -> L1d
            goto L17
        L25:
            r6 = move-exception
        L26:
            if (r0 == 0) goto L2d
            java.util.concurrent.ArrayBlockingQueue<org.apache.tika.pipes.PipesClient> r1 = r5.clientQueue
            r1.offer(r0)
        L2d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tika.pipes.PipesParser.parse(org.apache.tika.pipes.FetchEmitTuple):org.apache.tika.pipes.PipesResult");
    }
}
