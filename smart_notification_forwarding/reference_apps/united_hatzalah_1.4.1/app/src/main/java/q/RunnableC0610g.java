package q;

/* renamed from: q.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0610g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6025a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f6026b;

    public /* synthetic */ RunnableC0610g(p pVar, int i) {
        this.f6025a = i;
        this.f6026b = pVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [q.t, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6025a) {
            case 0:
                C0601A c0601a = this.f6026b.f6036b;
                if (c0601a.f5991c == null) {
                    c0601a.f5991c = new Object();
                }
                c0601a.f5991c.onAuthenticationFailed();
                return;
            default:
                this.f6026b.f6036b.f6007u = false;
                return;
        }
    }
}
