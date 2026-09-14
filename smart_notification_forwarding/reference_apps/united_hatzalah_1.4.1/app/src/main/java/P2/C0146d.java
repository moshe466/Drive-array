package P2;

/* renamed from: P2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0146d implements InterfaceC0160k {

    /* renamed from: a, reason: collision with root package name */
    public final C0144c[] f1649a;

    public C0146d(C0144c[] c0144cArr) {
        this.f1649a = c0144cArr;
    }

    @Override // P2.InterfaceC0160k
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (C0144c c0144c : this.f1649a) {
            Q q3 = c0144c.f1646f;
            if (q3 != null) {
                q3.dispose();
            } else {
                kotlin.jvm.internal.j.i("handle");
                throw null;
            }
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f1649a + ']';
    }
}
