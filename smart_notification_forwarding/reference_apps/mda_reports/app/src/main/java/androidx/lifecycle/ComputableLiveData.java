package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {
    final Executor a;
    final LiveData<T> b;
    final AtomicBoolean c;
    final AtomicBoolean d;

    @VisibleForTesting
    final Runnable e;

    @VisibleForTesting
    final Runnable f;

    public ComputableLiveData() {
        this(ArchTaskExecutor.getIOThreadExecutor());
    }

    public ComputableLiveData(@NonNull Executor executor) {
        this.c = new AtomicBoolean(true);
        this.d = new AtomicBoolean(false);
        this.e = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            @WorkerThread
            public void run() {
                boolean z;
                do {
                    if (ComputableLiveData.this.d.compareAndSet(false, true)) {
                        Object obj = null;
                        z = false;
                        while (ComputableLiveData.this.c.compareAndSet(true, false)) {
                            try {
                                obj = ComputableLiveData.this.a();
                                z = true;
                            } finally {
                                ComputableLiveData.this.d.set(false);
                            }
                        }
                        if (z) {
                            ComputableLiveData.this.b.postValue(obj);
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        return;
                    }
                } while (ComputableLiveData.this.c.get());
            }
        };
        this.f = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.3
            @Override // java.lang.Runnable
            @MainThread
            public void run() {
                boolean hasActiveObservers = ComputableLiveData.this.b.hasActiveObservers();
                if (ComputableLiveData.this.c.compareAndSet(false, true) && hasActiveObservers) {
                    ComputableLiveData computableLiveData = ComputableLiveData.this;
                    computableLiveData.a.execute(computableLiveData.e);
                }
            }
        };
        this.a = executor;
        this.b = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData.1
            @Override // androidx.lifecycle.LiveData
            protected void b() {
                ComputableLiveData computableLiveData = ComputableLiveData.this;
                computableLiveData.a.execute(computableLiveData.e);
            }
        };
    }

    @WorkerThread
    protected abstract T a();

    @NonNull
    public LiveData<T> getLiveData() {
        return this.b;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.f);
    }
}
