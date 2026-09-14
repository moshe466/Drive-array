package androidx.loader.content;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class h extends FutureTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f3646a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(a aVar, g gVar) {
        super(gVar);
        this.f3646a = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        a aVar = this.f3646a;
        AtomicBoolean atomicBoolean = aVar.f3639e;
        try {
            Object obj = get();
            if (!atomicBoolean.get()) {
                aVar.a(obj);
            }
        } catch (InterruptedException unused) {
        } catch (CancellationException unused2) {
            if (!atomicBoolean.get()) {
                aVar.a(null);
            }
        } catch (ExecutionException e4) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
