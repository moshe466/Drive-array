package u7;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import u7.b0;
import v7.m;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: v, reason: collision with root package name */
    private static final x f14428v;

    /* renamed from: a, reason: collision with root package name */
    private Object f14429a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private ReentrantReadWriteLock f14430b;

    /* renamed from: c, reason: collision with root package name */
    private Lock f14431c;

    /* renamed from: d, reason: collision with root package name */
    private Lock f14432d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f14433e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, v7.c> f14434f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Object> f14435g;

    /* renamed from: h, reason: collision with root package name */
    private String f14436h;

    /* renamed from: i, reason: collision with root package name */
    private l7.b f14437i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, v7.m> f14438j;

    /* renamed from: k, reason: collision with root package name */
    private o7.f f14439k;

    /* renamed from: l, reason: collision with root package name */
    o7.o f14440l;

    /* renamed from: m, reason: collision with root package name */
    o7.n f14441m;

    /* renamed from: n, reason: collision with root package name */
    private AtomicBoolean f14442n;

    /* renamed from: o, reason: collision with root package name */
    protected AtomicBoolean f14443o;

    /* renamed from: p, reason: collision with root package name */
    private String f14444p;

    /* renamed from: q, reason: collision with root package name */
    private String f14445q;

    /* renamed from: r, reason: collision with root package name */
    private o7.a f14446r;

    /* renamed from: s, reason: collision with root package name */
    private u7.c f14447s;

    /* renamed from: t, reason: collision with root package name */
    private b0<m, v7.h> f14448t;

    /* renamed from: u, reason: collision with root package name */
    private u7.a f14449u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o7.k {
        a() {
        }

        @Override // o7.k
        public void a(int i10) {
            synchronized (s.this.f14433e) {
                s.this.f14433e.notifyAll();
            }
        }

        @Override // o7.k
        public void b(byte[] bArr) {
            synchronized (s.this.f14433e) {
                s.this.f14433e.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements u7.g {
        b(s sVar) {
        }

        @Override // u7.g
        public void a(String str) {
            v7.b.c("JoinChannel", "onComplete " + str);
        }

        @Override // u7.g
        public void b(int i10, String str) {
            v7.b.c("JoinChannel", "handleFailure " + i10 + " " + str);
        }

        @Override // u7.g
        public void c() {
            v7.b.c("JoinChannel", "onTimeout");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends u7.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u7.k f14451a;

        c(u7.k kVar) {
            this.f14451a = kVar;
        }

        @Override // u7.k
        public void c(String str, String str2, v7.c cVar, String str3, String str4, long j10, long j11, String str5) {
            if (s.this.f14438j.containsKey(str)) {
                ((v7.m) s.this.f14438j.get(str)).n(j10);
            }
            u7.k kVar = this.f14451a;
            if (kVar != null) {
                kVar.c(str, str2, cVar, str3, str4, j10, j11, str5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends o7.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o7.a f14453a;

        d(o7.a aVar) {
            this.f14453a = aVar;
        }

        @Override // o7.a
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10) {
            try {
                try {
                    com.google.gson.n nVar = new com.google.gson.n();
                    nVar.z("reqType", "extPttAck");
                    nVar.z("chId", str);
                    nVar.z("sId", s.this.t());
                    v7.m mVar = (v7.m) s.this.f14438j.get(str);
                    mVar.h().h(nVar, s.f14428v, u.f14484e);
                    mVar.m();
                } catch (Exception e10) {
                    s.this.f14437i.a(k7.b.error, 0, "ASDKManager.setOnReceivePttListener()", new Date(), e10.getMessage());
                }
            } finally {
                this.f14453a.a(str, str2, str3, str4, str5, str6, str7, j10);
            }
        }

        @Override // o7.a
        public boolean c(String str) {
            return this.f14453a.c(str);
        }
    }

    /* loaded from: classes.dex */
    class e extends u7.a {
        e() {
        }

        @Override // u7.a
        public void a(int i10, String str) {
            v7.b.a("Register", "errorCode: " + i10 + " " + str);
            s.this.I(false);
        }

        @Override // u7.a
        public void b(com.google.gson.n nVar) {
            try {
                int c10 = nVar.B("returnCode").c();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("returnCode:");
                sb2.append(c10);
                sb2.append(c10 == 0 ? " success" : " failed");
                v7.b.c("Register", sb2.toString());
                if (c10 == 0) {
                    s.this.I(true);
                } else {
                    a(c10, nVar.B("errorMsg").s());
                }
            } catch (Exception e10) {
                v7.b.b("Register", e10);
                a(1, e10.getMessage());
            }
        }

        @Override // u7.a
        public void c() {
            v7.b.a("Register", "onTimeout");
            s.this.I(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements o7.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14456a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v7.m f14457b;

        f(String str, v7.m mVar) {
            this.f14456a = str;
            this.f14457b = mVar;
        }

        @Override // o7.g
        public void b(int i10, String str) {
        }

        @Override // o7.g
        public void c(com.google.gson.n nVar) {
            v7.b.d("ASDKManager", "DCS.onReconnect({}).processResponse({})", this.f14456a, nVar);
            if (!nVar.B("status").s().equals("success")) {
                this.f14457b.j(m.e.CHANNELING_RECONNECTING);
                return;
            }
            try {
                s sVar = s.this;
                sVar.A(this.f14457b, sVar.s());
            } catch (Exception e10) {
                v7.b.d("ASDKManager", "DCS.onReconnect.joinChannel({}) failed due to an exception: {}", this.f14456a, e10.getMessage());
            }
        }

        @Override // o7.g
        public void d() {
            v7.b.d("ASDKManager", "DCS.onReconnect({}).handleTimeout()", this.f14456a);
            this.f14457b.j(m.e.CHANNELING_DOWN);
        }
    }

    /* loaded from: classes.dex */
    class g extends u7.h {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ u7.h f14459e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(u7.k kVar, o7.a aVar, o7.j jVar, u7.h hVar) {
            super(kVar, aVar, jVar);
            this.f14459e = hVar;
        }

        @Override // u7.a
        public void a(int i10, String str) {
            s.this.I(false);
            this.f14459e.a(i10, str);
        }

        @Override // u7.a
        public void c() {
            s.this.I(false);
            this.f14459e.c();
        }

        @Override // u7.h
        public void i() {
            this.f14459e.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements o7.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v7.m f14461a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14462b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.gson.n f14463c;

        /* loaded from: classes.dex */
        class a implements o7.k {
            a() {
            }

            @Override // o7.k
            public void a(int i10) {
            }

            @Override // o7.k
            public void b(byte[] bArr) {
                h.this.f14461a.j(m.e.VOICE_UP);
            }
        }

        h(s sVar, v7.m mVar, String str, com.google.gson.n nVar) {
            this.f14461a = mVar;
            this.f14462b = str;
            this.f14463c = nVar;
        }

        @Override // o7.g
        public void b(int i10, String str) {
            if (i10 == 13) {
                this.f14461a.i().q(1, new a());
                this.f14461a.h().h(this.f14463c, this, u.f14486g);
            }
        }

        @Override // o7.g
        public void c(com.google.gson.n nVar) {
            this.f14461a.i().A(this.f14462b);
        }

        @Override // o7.g
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends u7.n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v7.m f14465b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ u7.n f14466c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(s sVar, long j10, v7.m mVar, u7.n nVar) {
            super(j10);
            this.f14465b = mVar;
            this.f14466c = nVar;
        }

        @Override // u7.n, u7.a
        public void a(int i10, String str) {
            this.f14466c.a(i10, str);
        }

        @Override // u7.n, u7.a
        public void c() {
            this.f14466c.c();
        }

        @Override // u7.n
        public void d(String str, long j10, long j11) {
            this.f14465b.n(j10);
            this.f14466c.d(str, j10, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements o7.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v7.m f14467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14468b;

        j(s sVar, v7.m mVar, String str) {
            this.f14467a = mVar;
            this.f14468b = str;
        }

        @Override // o7.k
        public void a(int i10) {
            v7.b.d("ASDKManager", "enterChannel({}): re-registering failed with error {}", this.f14468b, Integer.valueOf(i10));
        }

        @Override // o7.k
        public void b(byte[] bArr) {
            this.f14467a.j(m.e.VOICE_UP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements o7.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v7.m f14469a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ u7.g f14470b;

        /* loaded from: classes.dex */
        class a implements o7.k {
            a() {
            }

            @Override // o7.k
            public void a(int i10) {
                v7.b.d("ASDKManager", "joinChannel({}) -> register failed with error {}", k.this.f14469a.f(), Integer.valueOf(i10));
            }

            @Override // o7.k
            public void b(byte[] bArr) {
                k.this.f14469a.j(m.e.VOICE_UP);
            }
        }

        k(v7.m mVar, u7.g gVar) {
            this.f14469a = mVar;
            this.f14470b = gVar;
        }

        @Override // o7.g
        public void b(int i10, String str) {
            v7.b.d("ASDKManager", "joinChannel({}).thread failed: ({}) {}", this.f14469a.f(), Integer.valueOf(i10), str);
            this.f14470b.b(i10, str);
        }

        @Override // o7.g
        public void c(com.google.gson.n nVar) {
            try {
                int c10 = nVar.B("returnCode").c();
                if (c10 != 0) {
                    b(c10, nVar.B("errorMsg").s());
                    return;
                }
                this.f14469a.j(m.e.CHANNELING_UP);
                this.f14469a.i().q(1, new a());
                v7.b.c("Channels", "OpenChannels.put(" + this.f14469a.f() + ")");
                v7.m mVar = (v7.m) s.this.f14438j.put(this.f14469a.f(), this.f14469a);
                if (mVar != null && mVar != this.f14469a) {
                    mVar.e();
                }
                this.f14470b.a(s.this.f14444p);
            } catch (Throwable th) {
                b(1, th.getMessage());
            }
        }

        @Override // o7.g
        public void d() {
            this.f14470b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends u7.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u7.l f14473a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o7.b f14474b;

        /* loaded from: classes.dex */
        class a implements o7.k {
            a() {
            }

            @Override // o7.k
            public void a(int i10) {
                v7.b.a("callTCPVoiceApi", "errorCode: " + i10);
                synchronized (s.this.f14433e) {
                    s.this.f14433e.notifyAll();
                }
            }

            @Override // o7.k
            public void b(byte[] bArr) {
                v7.b.c("callTCPVoiceApi", "processResponse");
                synchronized (s.this.f14433e) {
                    s.this.f14433e.notifyAll();
                }
            }
        }

        l(u7.l lVar, o7.b bVar) {
            this.f14473a = lVar;
            this.f14474b = bVar;
        }

        @Override // u7.t
        public void a(int i10) {
            v7.b.a("requestPttSession", "errorCode: " + i10);
            s.this.f14433e.set(false);
            u7.l lVar = this.f14473a;
            if (lVar != null) {
                lVar.a(i10);
            }
        }

        @Override // u7.l
        public void c(int i10, String str) {
            v7.b.c("requestPttSession", "returnCode: " + i10 + " requestId:" + str);
            synchronized (s.this.f14429a) {
                if (s.this.f14433e.get()) {
                    v7.b.c("requestPttSession", "onComplete");
                    u7.l lVar = this.f14473a;
                    if (lVar != null) {
                        lVar.c(i10, str);
                    }
                } else {
                    v7.b.c("requestPttSession", "callTCPVoiceApi");
                    this.f14474b.q(4, new a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum m {
        LOGGED_OUT,
        LOGGED_IN,
        SIGNALING_UP,
        SIGNALING_DOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements b0.a<m, v7.h> {
        n() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<m, v7.h> b0Var, m mVar) {
            b0.a<m, v7.h> oVar;
            if (mVar == m.LOGGED_OUT) {
                oVar = new p();
            } else if (mVar != m.SIGNALING_DOWN) {
                return;
            } else {
                oVar = new o();
            }
            b0Var.b(oVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.h a() {
            return v7.h.FULL_SERVICE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements b0.a<m, v7.h> {
        o() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<m, v7.h> b0Var, m mVar) {
            b0.a<m, v7.h> nVar;
            if (mVar == m.LOGGED_OUT) {
                nVar = new p();
            } else if (mVar != m.SIGNALING_UP) {
                return;
            } else {
                nVar = new n();
            }
            b0Var.b(nVar);
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.h a() {
            return v7.h.IN_SESSION;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements b0.a<m, v7.h> {
        p() {
        }

        @Override // u7.b0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(b0<m, v7.h> b0Var, m mVar) {
            if (mVar == m.LOGGED_IN) {
                b0Var.b(new o());
            }
        }

        @Override // u7.b0.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public v7.h a() {
            return v7.h.NO_SERVICE;
        }
    }

    static {
        new Date(0L);
        f14428v = new x(null);
    }

    public s(String str, l7.a... aVarArr) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f14430b = reentrantReadWriteLock;
        this.f14431c = reentrantReadWriteLock.readLock();
        this.f14432d = this.f14430b.writeLock();
        this.f14433e = new AtomicBoolean(false);
        this.f14434f = new HashMap();
        this.f14435g = new HashMap();
        new HashMap();
        ic.c.i(s.class.getSimpleName());
        this.f14438j = new HashMap();
        this.f14442n = new AtomicBoolean(false);
        this.f14443o = new AtomicBoolean(false);
        this.f14448t = new b0<>(new p());
        this.f14449u = new e();
        this.f14439k = new o7.f(str);
        o7.e.f12571b = y();
        this.f14437i = new l7.b(aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(v7.m mVar, u7.g gVar) {
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "joinChannel");
        nVar.z("sId", t());
        nVar.z("chId", mVar.f());
        mVar.h().h(nVar, new k(mVar, gVar), u.f14483d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(String str) {
        try {
            v7.b.c("beginPttSession", "start");
            z();
            o7.b i10 = this.f14438j.get(this.f14444p).i();
            do {
                d0(i10);
            } while (this.f14433e.get());
            Q();
            v7.b.c("beginPttSession", "end");
            i10.q(4, new a());
        } catch (Throwable th) {
            v7.b.d("ASDKManager", "beginPttSession({}).thread threw exception: {}", str, th.getMessage());
            v7.b.b("beginPttSession", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(com.google.gson.n nVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D() {
        o7.p.d().f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(boolean z10) {
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? m.SIGNALING_UP : m.SIGNALING_DOWN;
        v7.b.d("ASDKManager", "Service state event - {}", objArr);
        this.f14448t.a(z10 ? m.SIGNALING_UP : m.SIGNALING_DOWN);
    }

    private void n() {
        this.f14446r = null;
        this.f14447s = null;
        this.f14433e.set(false);
        this.f14444p = null;
        Iterator<v7.m> it = this.f14438j.values().iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        this.f14438j.clear();
        this.f14448t.a(m.SIGNALING_DOWN);
        this.f14442n.set(false);
        v7.b.c("notifyRegistration", "false");
        this.f14443o.set(false);
        o7.n nVar = this.f14441m;
        if (nVar != null) {
            nVar.o();
            this.f14441m = null;
        }
        o7.o oVar = this.f14440l;
        if (oVar != null) {
            oVar.i();
            this.f14440l = null;
        }
        this.f14445q = null;
        this.f14434f.clear();
        this.f14435g.clear();
        this.f14448t.a(m.LOGGED_OUT);
        try {
            this.f14432d.lock();
            this.f14436h = null;
        } finally {
            this.f14432d.unlock();
        }
    }

    private v7.m o(String str, String str2) {
        v7.m mVar = new v7.m(str);
        o7.o a10 = o7.e.a(str2, t(), new f(str, mVar));
        mVar.p(a10);
        o7.n k10 = a10.k();
        u7.c cVar = this.f14447s;
        if (cVar != null) {
            k10.v(new z(cVar));
        }
        mVar.o(k10);
        Matcher matcher = o7.e.f12570a.matcher(str2);
        matcher.find();
        o7.b a11 = o7.e.f12571b.a(matcher.group(1), Integer.valueOf(matcher.group(2)).intValue(), t(), str);
        a11.E(this.f14446r);
        mVar.q(a11);
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u7.g s() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        Iterator<Map.Entry<String, v7.m>> it = this.f14438j.entrySet().iterator();
        while (it.hasNext()) {
            v7.m value = it.next().getValue();
            if (!value.k() && !value.l()) {
                it.remove();
                value.e();
            }
        }
    }

    public void G(v7.j jVar, boolean z10, u7.h hVar) {
        int i10;
        String str;
        g gVar = new g(hVar.h(), hVar.g(), hVar.f(), hVar);
        gVar.j(this);
        if (!this.f14442n.compareAndSet(false, true)) {
            i10 = 101;
            str = "A login process in progress";
        } else {
            if (z10 || !this.f14443o.get()) {
                com.google.gson.n nVar = new com.google.gson.n();
                nVar.z("reqType", "login");
                nVar.z("scope", jVar.f14723a);
                nVar.z("user", jVar.f14724b);
                nVar.z("hashedPass", jVar.f14725c);
                nVar.z("apiVersion", "1.2");
                v7.g gVar2 = jVar.f14726d;
                if (gVar2 != null) {
                    nVar.z("lang", gVar2.toString());
                }
                nVar.z("phoneNum", jVar.f14727e);
                this.f14439k.b(nVar, new x(gVar));
                return;
            }
            this.f14442n.set(false);
            i10 = 100;
            str = "Logout is not required since already logged in";
        }
        gVar.a(i10, str);
    }

    public void H(u7.m mVar) {
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "logout");
        nVar.z("sId", t());
        this.f14439k.b(nVar, new x(mVar));
        v7.b.c("notifyRegistration", "false");
        this.f14443o.set(false);
        this.f14448t.a(m.LOGGED_OUT);
        n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(boolean z10) {
        v7.b.c("notifyRegistration", "" + z10);
        if (this.f14442n.compareAndSet(true, false)) {
            this.f14443o.set(z10);
        }
        this.f14448t.a(z10 ? m.SIGNALING_UP : m.SIGNALING_DOWN);
    }

    public void J(List<String> list, u7.j jVar) {
        if (!this.f14443o.get()) {
            v7.b.a("openChannelWith", "isNotLoggedIn");
            jVar.a(40, "A successful login is required");
            return;
        }
        v7.b.c("openChannelWith", "start");
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "openChannel");
        nVar.z("sId", t());
        com.google.gson.h hVar = new com.google.gson.h();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hVar.y(it.next());
        }
        nVar.x("recipient", hVar);
        jVar.e(this);
        x xVar = new x(jVar);
        v7.b.c("openChannelWith", "callAPI");
        this.f14440l.h(nVar, xVar, u.f14482c);
    }

    public void K(String str, String str2) {
        if (this.f14438j.containsKey(str)) {
            com.google.gson.n nVar = new com.google.gson.n();
            nVar.z("reqType", "playVoiceHistory");
            nVar.z("sId", t());
            nVar.z("chId", str);
            nVar.z("msgId", str2);
            v7.m mVar = this.f14438j.get(str);
            mVar.h().h(nVar, new h(this, mVar, str, nVar), u.f14486g);
        }
    }

    public void L(u7.a aVar) {
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "getDssServerAddress");
        nVar.z("sId", t());
        this.f14439k.b(nVar, new x(aVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        o7.p.d().b();
        new Thread(new Runnable() { // from class: u7.p
            @Override // java.lang.Runnable
            public final void run() {
                s.D();
            }
        }).start();
    }

    public void N() {
        v7.b.c("Register", "processResponse");
        O(this.f14449u);
    }

    public void O(u7.a aVar) {
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "register");
        nVar.z("sId", t());
        String v10 = v();
        if (v10 != null && !v10.isEmpty()) {
            nVar.z("extToken", v10);
        }
        this.f14440l.h(nVar, new x(aVar), u.f14480a);
    }

    public void P(String str, u7.d dVar) {
        if (this.f14438j.containsKey(str)) {
            dVar.c(this);
            this.f14438j.get(str).g().r(new z(dVar));
        }
    }

    protected abstract void Q();

    public void R(String str, String str2, u7.l lVar) {
        v7.b.c("requestPttSession", "start");
        synchronized (this.f14429a) {
            if (!this.f14433e.getAndSet(true)) {
                this.f14444p = str;
                if (this.f14438j.containsKey(str)) {
                    v7.m mVar = this.f14438j.get(str);
                    o7.b i10 = mVar.i();
                    a0 a0Var = new a0(new l(lVar, i10));
                    i10.D(str2);
                    i10.r(3, a0Var, i10.x());
                    mVar.m();
                } else {
                    this.f14433e.set(false);
                    v7.b.a("requestPttSession", "channel is not found");
                    if (lVar != null) {
                        lVar.a(40);
                    }
                }
            } else if (lVar != null) {
                v7.b.a("requestPttSession", "code 42. no session in progress");
                lVar.a(42);
            }
        }
    }

    public void S(String str, u7.l lVar) {
        R(str, "-1:-1,-1:-1", lVar);
    }

    public void T(String str, String str2, String str3, u7.n nVar) {
        if (!this.f14438j.containsKey(str)) {
            if (nVar != null) {
                nVar.a(40, "Channel is not set");
                return;
            }
            return;
        }
        com.google.gson.n nVar2 = new com.google.gson.n();
        nVar2.z("reqType", "sendTxtMsg");
        nVar2.z("chId", str);
        nVar2.z("location", str3);
        nVar2.z("txtMsg", str2);
        long currentTimeMillis = System.currentTimeMillis();
        nVar2.y("msgOrigTime", Long.valueOf(currentTimeMillis));
        v7.m mVar = this.f14438j.get(str);
        mVar.h().h(nVar2, new x(new i(this, currentTimeMillis, mVar, nVar)), u.f14485f);
        mVar.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(String str) {
        try {
            this.f14432d.lock();
            this.f14436h = str;
            this.f14448t.a(m.LOGGED_IN);
        } finally {
            this.f14432d.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(String str) {
    }

    public void W(String str) {
        o7.h hVar = new o7.h() { // from class: u7.q
            @Override // o7.h
            public final void a(boolean z10) {
                s.this.E(z10);
            }
        };
        o7.o b10 = o7.e.b(str, t(), new w(this));
        this.f14440l = b10;
        b10.m(hVar);
        o7.n k10 = this.f14440l.k();
        this.f14441m = k10;
        k10.t(hVar);
        this.f14445q = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        v7.b.c("notifyRegistration", "true");
        this.f14443o.set(true);
    }

    public void Y(u7.i iVar) {
        new y(iVar);
    }

    public void Z(u7.k kVar) {
        this.f14447s = new c(kVar);
    }

    public void a0(o7.a aVar) {
        this.f14446r = new d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0(String str) {
        try {
            this.f14432d.lock();
        } finally {
            this.f14432d.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0() {
        if (this.f14441m.q() + u.f14488i < System.currentTimeMillis()) {
            N();
        }
        for (v7.m mVar : this.f14438j.values()) {
            if (mVar.g().q() + u.f14488i < System.currentTimeMillis()) {
                try {
                    A(mVar, s());
                } catch (Exception e10) {
                    v7.b.d("ASDKManager", "sustainConnectivity() threw an exception on joining the channel {}: {}", mVar.f(), e10.getMessage());
                }
            }
        }
    }

    protected abstract void d0(o7.b bVar);

    public void m(final String str) {
        synchronized (this.f14429a) {
            if (this.f14433e.get()) {
                new Thread(new Runnable() { // from class: u7.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.B(str);
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.f14441m.o();
        this.f14441m = null;
        this.f14440l.i();
        this.f14441m = null;
    }

    public void q() {
        synchronized (this.f14429a) {
            synchronized (this.f14433e) {
                try {
                    if (this.f14433e.getAndSet(false)) {
                        this.f14433e.wait(u.f14487h);
                    }
                } catch (InterruptedException e10) {
                    v7.b.d("ASDKManager", "endPttSession() threw exception: {}", e10.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str, String str2, u7.g gVar) {
        v7.b.d("ASDKManager", "enterChannel({})", str);
        if (!this.f14438j.containsKey(str)) {
            A(o(str, str2), gVar);
            return;
        }
        v7.m mVar = this.f14438j.get(str);
        o7.b i10 = mVar.i();
        if (System.currentTimeMillis() - i10.y() > 15000) {
            i10.q(1, new j(this, mVar, str));
        }
        gVar.a(str);
    }

    public String t() {
        try {
            this.f14431c.lock();
            return this.f14436h;
        } finally {
            this.f14431c.unlock();
        }
    }

    public void u(List<String> list, u7.f fVar) {
        if (!this.f14443o.get()) {
            fVar.a(40, "A successful login is required");
            return;
        }
        com.google.gson.h hVar = new com.google.gson.h();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hVar.y(it.next());
        }
        com.google.gson.n nVar = new com.google.gson.n();
        nVar.z("reqType", "getUsersStatus");
        nVar.z("sId", t());
        nVar.x("users", hVar);
        this.f14440l.h(nVar, new x(fVar), u.f14481b);
    }

    protected abstract String v();

    /* JADX INFO: Access modifiers changed from: protected */
    public o7.j w() {
        o7.n nVar = this.f14441m;
        return nVar != null ? nVar.p() : new o7.j() { // from class: u7.r
            @Override // o7.j
            public final void a(com.google.gson.n nVar2) {
                s.C(nVar2);
            }
        };
    }

    public String x() {
        return this.f14445q;
    }

    protected abstract o7.l y();

    protected abstract void z();
}
