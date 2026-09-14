package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.ag;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class Tasks {

    /* loaded from: classes.dex */
    interface a extends OnFailureListener, OnSuccessListener<Object> {
    }

    /* loaded from: classes.dex */
    static final class b implements a {
        private final CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void a() {
            this.a.await();
        }

        public final boolean a(long j, TimeUnit timeUnit) {
            return this.a.await(j, timeUnit);
        }

        @Override // com.google.android.play.core.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.a.countDown();
        }

        @Override // com.google.android.play.core.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }
    }

    private Tasks() {
    }

    public static <ResultT> Task<ResultT> a(Exception exc) {
        l lVar = new l();
        lVar.a(exc);
        return lVar;
    }

    public static <ResultT> Task<ResultT> a(ResultT resultt) {
        l lVar = new l();
        lVar.a((l) resultt);
        return lVar;
    }

    private static <ResultT> ResultT a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    private static void a(Task<?> task, a aVar) {
        task.addOnSuccessListener(TaskExecutors.a, aVar);
        task.addOnFailureListener(TaskExecutors.a, aVar);
    }

    public static <ResultT> ResultT await(Task<ResultT> task) {
        ag.a(task, "Task must not be null");
        if (task.isComplete()) {
            return (ResultT) a((Task) task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        bVar.a();
        return (ResultT) a((Task) task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) {
        ag.a(task, "Task must not be null");
        ag.a(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (ResultT) a((Task) task);
        }
        b bVar = new b((byte) 0);
        a(task, bVar);
        if (bVar.a(j, timeUnit)) {
            return (ResultT) a((Task) task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
