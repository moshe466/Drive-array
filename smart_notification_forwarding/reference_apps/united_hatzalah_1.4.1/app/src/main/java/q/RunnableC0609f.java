package q;

/* renamed from: q.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0609f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6021a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6022b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CharSequence f6023c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p f6024d;

    public /* synthetic */ RunnableC0609f(p pVar, int i, CharSequence charSequence, int i3) {
        this.f6021a = i3;
        this.f6024d = pVar;
        this.f6022b = i;
        this.f6023c = charSequence;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [q.t, java.lang.Object] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6021a) {
            case 0:
                C0601A c0601a = this.f6024d.f6036b;
                if (c0601a.f5991c == null) {
                    c0601a.f5991c = new Object();
                }
                c0601a.f5991c.onAuthenticationError(this.f6022b, this.f6023c);
                return;
            default:
                this.f6024d.k(this.f6022b, this.f6023c);
                return;
        }
    }
}
