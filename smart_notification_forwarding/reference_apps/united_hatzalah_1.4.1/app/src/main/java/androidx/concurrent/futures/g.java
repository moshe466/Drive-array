package androidx.concurrent.futures;

/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final j f3031a;

    /* renamed from: b, reason: collision with root package name */
    public final J1.a f3032b;

    public g(j jVar, J1.a aVar) {
        this.f3031a = jVar;
        this.f3032b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3031a.value == this) {
            if (j.ATOMIC_HELPER.b(this.f3031a, this, j.getFutureValue(this.f3032b))) {
                j.complete(this.f3031a);
            }
        }
    }
}
