package u7;

/* loaded from: classes.dex */
public abstract class j extends u7.a {

    /* renamed from: a, reason: collision with root package name */
    private s f14420a;

    /* loaded from: classes.dex */
    class a implements g {
        a() {
        }

        @Override // u7.g
        public void a(String str) {
            j.this.d(str);
        }

        @Override // u7.g
        public void b(int i10, String str) {
            j.this.a(i10, str);
        }

        @Override // u7.g
        public void c() {
            j.this.a(99, "timeOut");
        }
    }

    @Override // u7.a
    public void b(com.google.gson.n nVar) {
        try {
            int c10 = nVar.B("returnCode").c();
            if (c10 == 0) {
                String s10 = nVar.B("chId").s();
                String s11 = nVar.B("chSvr").s();
                nVar.B("validFor").c();
                this.f14420a.r(s10, s11, new a());
            } else {
                a(c10, nVar.B("errorMsg").s());
            }
        } catch (Exception e10) {
            a(1, e10.getMessage());
        }
    }

    public abstract void d(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(s sVar) {
        this.f14420a = sVar;
    }
}
