package F1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource f742a;

    public l() {
        this.f742a = null;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e4) {
            TaskCompletionSource taskCompletionSource = this.f742a;
            if (taskCompletionSource != null) {
                taskCompletionSource.trySetException(e4);
            }
        }
    }

    public l(TaskCompletionSource taskCompletionSource) {
        this.f742a = taskCompletionSource;
    }
}
