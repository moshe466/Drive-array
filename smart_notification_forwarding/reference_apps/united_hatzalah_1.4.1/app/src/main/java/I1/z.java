package I1;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public abstract class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TaskCompletionSource f930a;

    public z() {
        this.f930a = null;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f930a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    public abstract void b();

    public final TaskCompletionSource c() {
        return this.f930a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e4) {
            a(e4);
        }
    }

    public z(TaskCompletionSource taskCompletionSource) {
        this.f930a = taskCompletionSource;
    }
}
