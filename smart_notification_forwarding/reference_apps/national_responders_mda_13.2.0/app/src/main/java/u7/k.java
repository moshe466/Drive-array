package u7;

/* loaded from: classes.dex */
public abstract class k extends c {
    private v7.c b(com.google.gson.n nVar, String str) {
        String s10 = nVar.B("user").s();
        String s11 = nVar.B("name").s();
        com.google.gson.k B = nVar.B("desc");
        return new v7.c(str, s10, s11, B.u() ? "" : B.s(), -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // u7.c
    public void a(com.google.gson.n nVar) {
        String s10 = nVar.B("chId").s();
        String s11 = nVar.B("cId").s();
        c(s10, s11, b(nVar, s11), nVar.B("msgId").s(), nVar.B("txtMsg").s(), nVar.B("msgOrigTime").l(), nVar.B("msgSvrTime").l(), nVar.B("location").s());
    }

    public abstract void c(String str, String str2, v7.c cVar, String str3, String str4, long j10, long j11, String str5);
}
