package b2;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    private static q f4065b;

    /* renamed from: c, reason: collision with root package name */
    private static final r f4066c = new r(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    private r f4067a;

    private q() {
    }

    public static synchronized q b() {
        q qVar;
        synchronized (q.class) {
            if (f4065b == null) {
                f4065b = new q();
            }
            qVar = f4065b;
        }
        return qVar;
    }

    public r a() {
        return this.f4067a;
    }

    public final synchronized void c(r rVar) {
        if (rVar == null) {
            this.f4067a = f4066c;
            return;
        }
        r rVar2 = this.f4067a;
        if (rVar2 == null || rVar2.t() < rVar.t()) {
            this.f4067a = rVar;
        }
    }
}
