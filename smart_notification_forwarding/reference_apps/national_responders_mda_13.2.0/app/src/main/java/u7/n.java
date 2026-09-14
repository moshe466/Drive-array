package u7;

/* loaded from: classes.dex */
public abstract class n extends a {

    /* renamed from: a, reason: collision with root package name */
    private long f14422a;

    public n() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(long j10) {
        this.f14422a = j10;
    }

    @Override // u7.a
    public void a(int i10, String str) {
    }

    @Override // u7.a
    public void b(com.google.gson.n nVar) {
        try {
            int c10 = nVar.B("returnCode").c();
            if (c10 == 0) {
                d(nVar.B("msgId").s(), this.f14422a, nVar.B("msgSvrTime").l());
            } else {
                a(c10, nVar.B("errorMsg").s());
            }
        } catch (Exception e10) {
            a(1, e10.getMessage());
        }
    }

    @Override // u7.a
    public void c() {
    }

    public abstract void d(String str, long j10, long j11);
}
