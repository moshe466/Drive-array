package u7;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements o7.g {

    /* renamed from: a, reason: collision with root package name */
    private s f14490a;

    public w(s sVar) {
        this.f14490a = sVar;
    }

    @Override // o7.g
    public void b(int i10, String str) {
        v7.b.a("Reconnect", "errorCode: " + i10 + " " + str);
    }

    @Override // o7.g
    public void c(com.google.gson.n nVar) {
        v7.b.c("Reconnect", "processResponse");
        this.f14490a.N();
    }

    @Override // o7.g
    public void d() {
        v7.b.a("Reconnect", "timeout");
    }
}
