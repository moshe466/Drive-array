package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    volatile AsyncTaskLoader<D>.LoadTask j;
    volatile AsyncTaskLoader<D>.LoadTask k;
    long l;
    long m;
    private final Executor mExecutor;
    Handler n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        boolean c;
        private final CountDownLatch mDone = new CountDownLatch(1);

        LoadTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        public D a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.h();
            } catch (OperationCanceledException e) {
                if (isCancelled()) {
                    return null;
                }
                throw e;
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void b(D d) {
            try {
                AsyncTaskLoader.this.a(this, d);
            } finally {
                this.mDone.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void c(D d) {
            try {
                AsyncTaskLoader.this.b(this, d);
            } finally {
                this.mDone.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = false;
            AsyncTaskLoader.this.g();
        }

        public void waitForLoader() {
            try {
                this.mDone.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.m = -10000L;
        this.mExecutor = executor;
    }

    void a(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        onCanceled(d);
        if (this.k == loadTask) {
            rollbackContentChanged();
            this.m = SystemClock.uptimeMillis();
            this.k = null;
            deliverCancellation();
            g();
        }
    }

    void b(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        if (this.j != loadTask) {
            a(loadTask, d);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d);
            return;
        }
        commitContentChanged();
        this.m = SystemClock.uptimeMillis();
        this.j = null;
        deliverResult(d);
    }

    @Override // androidx.loader.content.Loader
    protected boolean b() {
        if (this.j == null) {
            return false;
        }
        if (!this.e) {
            this.h = true;
        }
        if (this.k != null) {
            if (this.j.c) {
                this.j.c = false;
                this.n.removeCallbacks(this.j);
            }
            this.j = null;
            return false;
        }
        if (this.j.c) {
            this.j.c = false;
            this.n.removeCallbacks(this.j);
            this.j = null;
            return false;
        }
        boolean cancel = this.j.cancel(false);
        if (cancel) {
            this.k = this.j;
            cancelLoadInBackground();
        }
        this.j = null;
        return cancel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.content.Loader
    public void c() {
        super.c();
        cancelLoad();
        this.j = new LoadTask();
        g();
    }

    public void cancelLoadInBackground() {
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.j);
            printWriter.print(" waiting=");
            printWriter.println(this.j.c);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.c);
        }
        if (this.l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void g() {
        if (this.k != null || this.j == null) {
            return;
        }
        if (this.j.c) {
            this.j.c = false;
            this.n.removeCallbacks(this.j);
        }
        if (this.l <= 0 || SystemClock.uptimeMillis() >= this.m + this.l) {
            this.j.executeOnExecutor(this.mExecutor, null);
        } else {
            this.j.c = true;
            this.n.postAtTime(this.j, this.m + this.l);
        }
    }

    @Nullable
    protected D h() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.k != null;
    }

    @Nullable
    public abstract D loadInBackground();

    public void onCanceled(@Nullable D d) {
    }

    public void setUpdateThrottle(long j) {
        this.l = j;
        if (j != 0) {
            this.n = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.j;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }
}
