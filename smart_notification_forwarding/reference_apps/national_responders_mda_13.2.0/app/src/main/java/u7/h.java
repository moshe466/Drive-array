package u7;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h extends u7.a {

    /* renamed from: a, reason: collision with root package name */
    private s f14413a;

    /* renamed from: b, reason: collision with root package name */
    private k f14414b;

    /* renamed from: c, reason: collision with root package name */
    private o7.a f14415c;

    /* renamed from: d, reason: collision with root package name */
    private o7.j f14416d;

    /* loaded from: classes.dex */
    class a implements o7.j {

        /* renamed from: u7.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0297a implements g {
            C0297a(a aVar) {
            }

            @Override // u7.g
            public void a(String str) {
            }

            @Override // u7.g
            public void b(int i10, String str) {
            }

            @Override // u7.g
            public void c() {
            }
        }

        a() {
        }

        @Override // o7.j
        public void a(com.google.gson.n nVar) {
            String f10 = k7.c.f(nVar, "chSvr", true);
            String f11 = k7.c.f(nVar, "chId", true);
            com.google.gson.h f12 = nVar.B("members").f();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < f12.size(); i10++) {
                arrayList.add(f12.z(i10).s());
            }
            h.this.f14413a.r(f11, f10, new C0297a(this));
            com.google.gson.n nVar2 = new com.google.gson.n();
            nVar2.z("chId", f11);
            nVar2.x("members", f12);
            if (h.this.f14416d != null) {
                h.this.f14416d.a(nVar2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends u7.a {

        /* renamed from: a, reason: collision with root package name */
        private s f14418a;

        b(s sVar) {
            this.f14418a = sVar;
        }

        private void d() {
            v7.b.c("rollback", "start");
            this.f14418a.I(false);
            this.f14418a.p();
            this.f14418a.H(null);
        }

        @Override // u7.a
        public void a(int i10, String str) {
            d();
            v7.b.a("Login", "errorCode: " + i10 + " " + str);
            h.this.a(i10, str);
        }

        @Override // u7.a
        public void b(com.google.gson.n nVar) {
            int c10 = nVar.B("returnCode").c();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("returnCode:");
            sb2.append(c10);
            sb2.append(c10 == 0 ? " success" : " failed");
            v7.b.c("Login", sb2.toString());
            if (c10 != 0) {
                a(c10, nVar.B("errorMsg").s());
                return;
            }
            this.f14418a.I(true);
            this.f14418a.X();
            h.this.i();
        }

        @Override // u7.a
        public void c() {
            d();
            v7.b.a("Login", "onTimeout");
            h.this.c();
        }
    }

    public h(k kVar, o7.a aVar, o7.j jVar) {
        this.f14414b = kVar;
        this.f14415c = aVar;
        this.f14416d = jVar;
    }

    @Override // u7.a
    public void b(com.google.gson.n nVar) {
        try {
            int c10 = nVar.B("returnCode").c();
            if (c10 != 0) {
                this.f14413a.I(false);
                a(c10, nVar.B("errorMsg").s());
                return;
            }
            this.f14413a.U(nVar.B("sId").s());
            this.f14413a.b0(nVar.B("scopeId").s());
            this.f14413a.Z(this.f14414b);
            this.f14413a.a0(this.f14415c);
            this.f14413a.W(nVar.B("dssSvr").s());
            this.f14413a.f14441m.u(new a());
            this.f14413a.V(nVar.D("dipioId") ? nVar.B("dipioId").s() : null);
            s sVar = this.f14413a;
            sVar.O(new b(sVar));
        } catch (Throwable th) {
            this.f14413a.I(false);
            a(1, th.getMessage());
        }
    }

    public o7.j f() {
        return this.f14416d;
    }

    public o7.a g() {
        return this.f14415c;
    }

    public k h() {
        return this.f14414b;
    }

    public abstract void i();

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(s sVar) {
        this.f14413a = sVar;
    }
}
