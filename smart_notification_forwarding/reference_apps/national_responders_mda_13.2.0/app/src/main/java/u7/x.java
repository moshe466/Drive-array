package u7;

/* loaded from: classes.dex */
public class x implements o7.g {

    /* renamed from: a, reason: collision with root package name */
    private a f14491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(a aVar) {
        this.f14491a = aVar;
    }

    @Override // o7.g
    public void b(int i10, String str) {
        a aVar = this.f14491a;
        if (aVar != null) {
            aVar.a(i10, str);
        }
        v7.b.a("SDKCallBack", "error[" + i10 + "] " + str);
    }

    @Override // o7.g
    public void c(com.google.gson.n nVar) {
        int i10;
        String str;
        a aVar = this.f14491a;
        if (aVar != null) {
            aVar.b(nVar);
        }
        try {
            i10 = nVar.B("returnCode").c();
        } catch (Exception e10) {
            e10.printStackTrace();
            i10 = -1;
        }
        if (i10 == -1) {
            str = "no returnCode";
        } else {
            if (i10 == 0) {
                return;
            }
            str = "returnCode:" + i10 + " failed";
        }
        v7.b.c("processResponse", str);
    }

    @Override // o7.g
    public void d() {
        a aVar = this.f14491a;
        if (aVar != null) {
            aVar.c();
        }
        v7.b.a("SDKCallBack", "onTimeout");
    }
}
