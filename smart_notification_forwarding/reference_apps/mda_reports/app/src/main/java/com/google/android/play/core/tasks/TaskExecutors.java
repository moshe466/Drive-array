package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new a();
    static final Executor a = new k();

    /* loaded from: classes.dex */
    static final class a implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
