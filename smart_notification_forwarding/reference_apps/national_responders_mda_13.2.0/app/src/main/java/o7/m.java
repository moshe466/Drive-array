package o7;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    protected g f12576a;

    public m(com.google.gson.n nVar, g gVar) {
        this.f12576a = gVar;
    }

    public void a(int i10, String str) {
        g gVar = this.f12576a;
        if (gVar != null) {
            gVar.b(i10, str);
        }
    }

    public void b() {
        g gVar = this.f12576a;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void c(com.google.gson.n nVar) {
        if (this.f12576a != null) {
            int c10 = nVar.B("returnCode").c();
            if (c10 == 0) {
                this.f12576a.c(nVar);
            } else {
                com.google.gson.k B = nVar.B("errorMsg");
                this.f12576a.b(c10, B == null ? "" : B.s());
            }
        }
    }
}
