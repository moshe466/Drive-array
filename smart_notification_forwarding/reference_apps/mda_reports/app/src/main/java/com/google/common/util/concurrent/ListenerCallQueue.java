package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class ListenerCallQueue<L> {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Event<L> {
        void call(L l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class PerListenerQueue<L> implements Runnable {
        final L a;
        final Executor b;

        @GuardedBy("this")
        final Queue<Event<L>> c = Queues.newArrayDeque();

        @GuardedBy("this")
        final Queue<Object> d = Queues.newArrayDeque();

        @GuardedBy("this")
        boolean e;

        PerListenerQueue(L l, Executor executor) {
            this.a = (L) Preconditions.checkNotNull(l);
            this.b = (Executor) Preconditions.checkNotNull(executor);
        }

        void a() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.e) {
                    z = false;
                } else {
                    this.e = true;
                }
            }
            if (z) {
                try {
                    this.b.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.e = false;
                        ListenerCallQueue.logger.log(Level.SEVERE, "Exception while running callbacks for " + this.a + " on " + this.b, (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        synchronized void a(Event<L> event, Object obj) {
            this.c.add(event);
            this.d.add(obj);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:28:0x004d
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r8 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r8)     // Catch: java.lang.Throwable -> L50
                boolean r2 = r8.e     // Catch: java.lang.Throwable -> L4d
                com.google.common.base.Preconditions.checkState(r2)     // Catch: java.lang.Throwable -> L4d
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r8.c     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L4d
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch: java.lang.Throwable -> L4d
                java.util.Queue<java.lang.Object> r3 = r8.d     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L4d
                if (r2 != 0) goto L20
                r8.e = r0     // Catch: java.lang.Throwable -> L4d
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r1
                r1 = 0
                goto L4e
            L20:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L4d
                L r4 = r8.a     // Catch: java.lang.RuntimeException -> L27 java.lang.Throwable -> L50
                r2.call(r4)     // Catch: java.lang.RuntimeException -> L27 java.lang.Throwable -> L50
                goto L0
            L27:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.a()     // Catch: java.lang.Throwable -> L50
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L50
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
                r6.<init>()     // Catch: java.lang.Throwable -> L50
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L50
                L r7 = r8.a     // Catch: java.lang.Throwable -> L50
                r6.append(r7)     // Catch: java.lang.Throwable -> L50
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L50
                r6.append(r3)     // Catch: java.lang.Throwable -> L50
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L50
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L50
                goto L0
            L4d:
                r2 = move-exception
            L4e:
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L4d
                throw r2     // Catch: java.lang.Throwable -> L50
            L50:
                r2 = move-exception
                if (r1 == 0) goto L5b
                monitor-enter(r8)
                r8.e = r0     // Catch: java.lang.Throwable -> L58
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L58
                goto L5b
            L58:
                r0 = move-exception
                monitor-exit(r8)     // Catch: java.lang.Throwable -> L58
                throw r0
            L5b:
                goto L5d
            L5c:
                throw r2
            L5d:
                goto L5c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            Iterator<PerListenerQueue<L>> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().a(event, obj);
            }
        }
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue<>(l, executor));
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).a();
        }
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }
}
