package h2;

import android.os.Process;

/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f10446f;

    public d(Runnable runnable, int i10) {
        this.f10446f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f10446f.run();
    }
}
