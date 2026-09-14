package u7;

/* loaded from: classes.dex */
public abstract class m extends a {
    @Override // u7.a
    public void b(com.google.gson.n nVar) {
        try {
            int c10 = nVar.B("returnCode").c();
            if (c10 == 0) {
                d();
            } else {
                a(c10, nVar.B("errorMsg").s());
            }
        } catch (Exception e10) {
            a(1, e10.getMessage());
        }
    }

    public abstract void d();
}
