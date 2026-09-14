package v7;

import o7.o;
import u7.b0;
import u7.u;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private String f14728a;

    /* renamed from: b, reason: collision with root package name */
    private o f14729b;

    /* renamed from: c, reason: collision with root package name */
    private o7.n f14730c;

    /* renamed from: d, reason: collision with root package name */
    private o7.b f14731d;

    /* renamed from: e, reason: collision with root package name */
    private long f14732e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14733f = false;

    /* renamed from: g, reason: collision with root package name */
    private b0<e, v7.e> f14734g = new b0<>(new f());

    /* renamed from: h, reason: collision with root package name */
    private o7.k f14735h = new a();

    /* renamed from: i, reason: collision with root package name */
    private o7.h f14736i = new b();

    /* renamed from: j, reason: collision with root package name */
    private o7.h f14737j = new c();

    /* loaded from: classes.dex */
    class a implements o7.k {
        a() {
        }

        @Override // o7.k
        public void a(int i10) {
            v7.b.d("OpenChannel", "[{}].register() failed with error {}", m.this.f14728a, Integer.valueOf(i10));
            m.this.f14734g.a(e.VOICE_UP);
        }

        @Override // o7.k
        public void b(byte[] bArr) {
            v7.b.d("OpenChannel", "[{}] register(): The UDP connection responded", m.this.f14728a);
            m.this.f14734g.a(e.VOICE_UP);
        }
    }

    /* loaded from: classes.dex */
    class b implements o7.h {
        b() {
        }

        @Override // o7.h
        public void a(boolean z10) {
            m.this.f14734g.a(z10 ? e.CHANNELING_UP : e.CHANNELING_DOWN);
        }
    }

    /* loaded from: classes.dex */
    class c implements o7.h {
        c() {
        }

        @Override // o7.h
        public void a(boolean z10) {
            m.this.f14734g.a(z10 ? e.VOICE_UP : e.VOICE_DOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements b0.a<e, v7.e> {
        d() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            b0.a<e, v7.e> fVar;
            v7.b.d("OpenChannel", "[{}].ChannelingReadyState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.CHANNELING_DOWN) {
                fVar = new h();
            } else if (eVar != e.VOICE_UP) {
                return;
            } else {
                fVar = new f();
            }
            b0Var.b(fVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.CHANNELING_READY;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        CHANNELING_UP,
        CHANNELING_RECONNECTING,
        CHANNELING_DOWN,
        VOICE_UP,
        VOICE_DOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements b0.a<e, v7.e> {
        f() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            v7.b.d("OpenChannel", "[{}].FullServiceState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.CHANNELING_DOWN) {
                b0Var.b(new j());
                v7.b.d("OpenChannel", "[{}].FullServiceState.handleStateEvent(CHANNELING_DOWN) pings the UDP connection", m.this.f14728a);
                m.this.f14731d.q(1, m.this.f14735h);
            } else if (eVar == e.VOICE_DOWN) {
                b0Var.b(new d());
            }
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.FULL_SERVICE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements b0.a<e, v7.e> {
        g() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            b0.a<e, v7.e> hVar;
            v7.b.d("OpenChannel", "[{}].NoServiceReconnectingState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.VOICE_UP) {
                hVar = new i();
            } else if (eVar == e.CHANNELING_UP) {
                hVar = new d();
            } else if (eVar != e.CHANNELING_DOWN) {
                return;
            } else {
                hVar = new h();
            }
            b0Var.b(hVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.CHANNELING_RECONNECTING;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements b0.a<e, v7.e> {
        h() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            b0.a<e, v7.e> gVar;
            v7.b.d("OpenChannel", "[{}].NoServiceState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.CHANNELING_UP) {
                gVar = new d();
            } else if (eVar == e.VOICE_UP) {
                gVar = new j();
            } else if (eVar != e.CHANNELING_RECONNECTING) {
                return;
            } else {
                gVar = new g();
            }
            b0Var.b(gVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.NO_SERVICE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b0.a<e, v7.e> {
        i() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            b0.a<e, v7.e> jVar;
            v7.b.d("OpenChannel", "[{}].VoiceReadyReconnectingState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.CHANNELING_UP) {
                jVar = new f();
            } else if (eVar != e.CHANNELING_DOWN) {
                return;
            } else {
                jVar = new j();
            }
            b0Var.b(jVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.CHANNELING_RECONNECTING;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements b0.a<e, v7.e> {
        j() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<e, v7.e> b0Var, e eVar) {
            b0.a<e, v7.e> iVar;
            v7.b.d("OpenChannel", "[{}].VoiceReadyState.handleStateEvent({})", m.this.f14728a, eVar.toString());
            if (eVar == e.VOICE_DOWN) {
                iVar = new h();
            } else if (eVar == e.CHANNELING_UP) {
                iVar = new f();
            } else if (eVar != e.CHANNELING_RECONNECTING) {
                return;
            } else {
                iVar = new i();
            }
            b0Var.b(iVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.e a() {
            return v7.e.VOICE_READY;
        }
    }

    static {
        ic.c.i(m.class.getSimpleName());
    }

    public m(String str) {
        this.f14728a = str;
    }

    public void e() {
        this.f14731d.s();
        this.f14730c.o();
        this.f14729b.i();
    }

    public String f() {
        return this.f14728a;
    }

    public o7.n g() {
        return this.f14730c;
    }

    public o h() {
        return this.f14729b;
    }

    public o7.b i() {
        return this.f14731d;
    }

    public void j(e eVar) {
        this.f14734g.a(eVar);
    }

    public boolean k() {
        return this.f14732e + u.f14489j > System.currentTimeMillis();
    }

    public boolean l() {
        return this.f14733f;
    }

    public void m() {
        n(System.currentTimeMillis());
    }

    public void n(long j10) {
        this.f14732e = j10;
    }

    public void o(o7.n nVar) {
        this.f14730c = nVar;
        nVar.t(this.f14736i);
    }

    public void p(o oVar) {
        this.f14729b = oVar;
        oVar.m(this.f14736i);
    }

    public void q(o7.b bVar) {
        this.f14731d = bVar;
        bVar.C(this.f14737j);
    }
}
