package u7;

/* loaded from: classes.dex */
public abstract class d extends c {

    /* renamed from: a, reason: collision with root package name */
    private s f14412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u7.c
    public void a(com.google.gson.n nVar) {
        String s10 = nVar.B("msgId").s();
        long l10 = nVar.B("msgOrigTime").l();
        long l11 = nVar.B("msgSvrTime").l();
        String s11 = nVar.B("location").s();
        b(new v7.n(s10, nVar.B("cId").u() ? "" : nVar.B("cId").s(), l10, l11, s11, this.f14412a, nVar.B("duration").l()));
    }

    public abstract void b(v7.n nVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(s sVar) {
        this.f14412a = sVar;
    }
}
