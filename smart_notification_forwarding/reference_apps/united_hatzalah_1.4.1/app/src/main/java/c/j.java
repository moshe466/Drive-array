package c;

import F0.Q2;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.L;
import org.apache.tika.pipes.PipesConfigBase;

/* loaded from: classes.dex */
public final class j implements i, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f3823a = SystemClock.uptimeMillis() + PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f3824b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3825c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ L f3826d;

    public j(L l3) {
        this.f3826d = l3;
    }

    public final void a(View view) {
        if (!this.f3825c) {
            this.f3825c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        kotlin.jvm.internal.j.e(runnable, "runnable");
        this.f3824b = runnable;
        View decorView = this.f3826d.getWindow().getDecorView();
        kotlin.jvm.internal.j.d(decorView, "getDecorView(...)");
        if (this.f3825c) {
            if (kotlin.jvm.internal.j.a(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
                return;
            } else {
                decorView.postInvalidate();
                return;
            }
        }
        decorView.postOnAnimation(new Q2(this, 3));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z3;
        Runnable runnable = this.f3824b;
        if (runnable != null) {
            runnable.run();
            this.f3824b = null;
            o fullyDrawnReporter = this.f3826d.getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3836b) {
                z3 = fullyDrawnReporter.f3837c;
            }
            if (z3) {
                this.f3825c = false;
                this.f3826d.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        if (SystemClock.uptimeMillis() > this.f3823a) {
            this.f3825c = false;
            this.f3826d.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3826d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
