package xb;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import xb.h;

/* loaded from: classes.dex */
public final class g implements Closeable {

    /* renamed from: z, reason: collision with root package name */
    private static final ExecutorService f15715z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), sb.c.G("OkHttp Http2Connection", true));

    /* renamed from: f, reason: collision with root package name */
    final boolean f15716f;

    /* renamed from: g, reason: collision with root package name */
    final h f15717g;

    /* renamed from: i, reason: collision with root package name */
    final String f15719i;

    /* renamed from: j, reason: collision with root package name */
    int f15720j;

    /* renamed from: k, reason: collision with root package name */
    int f15721k;

    /* renamed from: l, reason: collision with root package name */
    boolean f15722l;

    /* renamed from: m, reason: collision with root package name */
    private final ScheduledExecutorService f15723m;

    /* renamed from: n, reason: collision with root package name */
    private final ExecutorService f15724n;

    /* renamed from: o, reason: collision with root package name */
    final l f15725o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f15726p;

    /* renamed from: r, reason: collision with root package name */
    long f15728r;

    /* renamed from: t, reason: collision with root package name */
    final m f15730t;

    /* renamed from: u, reason: collision with root package name */
    boolean f15731u;

    /* renamed from: v, reason: collision with root package name */
    final Socket f15732v;

    /* renamed from: w, reason: collision with root package name */
    final xb.j f15733w;

    /* renamed from: x, reason: collision with root package name */
    final j f15734x;

    /* renamed from: y, reason: collision with root package name */
    final Set<Integer> f15735y;

    /* renamed from: h, reason: collision with root package name */
    final Map<Integer, xb.i> f15718h = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    long f15727q = 0;

    /* renamed from: s, reason: collision with root package name */
    m f15729s = new m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15736g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ xb.b f15737h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i10, xb.b bVar) {
            super(str, objArr);
            this.f15736g = i10;
            this.f15737h = bVar;
        }

        @Override // sb.b
        public void k() {
            try {
                g.this.n0(this.f15736g, this.f15737h);
            } catch (IOException unused) {
                g.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15739g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f15740h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i10, long j10) {
            super(str, objArr);
            this.f15739g = i10;
            this.f15740h = j10;
        }

        @Override // sb.b
        public void k() {
            try {
                g.this.f15733w.c0(this.f15739g, this.f15740h);
            } catch (IOException unused) {
                g.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15742g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f15743h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i10, List list) {
            super(str, objArr);
            this.f15742g = i10;
            this.f15743h = list;
        }

        @Override // sb.b
        public void k() {
            if (g.this.f15725o.a(this.f15742g, this.f15743h)) {
                try {
                    g.this.f15733w.O(this.f15742g, xb.b.CANCEL);
                    synchronized (g.this) {
                        g.this.f15735y.remove(Integer.valueOf(this.f15742g));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15745g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f15746h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f15747i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i10, List list, boolean z10) {
            super(str, objArr);
            this.f15745g = i10;
            this.f15746h = list;
            this.f15747i = z10;
        }

        @Override // sb.b
        public void k() {
            boolean b10 = g.this.f15725o.b(this.f15745g, this.f15746h, this.f15747i);
            if (b10) {
                try {
                    g.this.f15733w.O(this.f15745g, xb.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (b10 || this.f15747i) {
                synchronized (g.this) {
                    g.this.f15735y.remove(Integer.valueOf(this.f15745g));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15749g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ bc.c f15750h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f15751i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f15752j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i10, bc.c cVar, int i11, boolean z10) {
            super(str, objArr);
            this.f15749g = i10;
            this.f15750h = cVar;
            this.f15751i = i11;
            this.f15752j = z10;
        }

        @Override // sb.b
        public void k() {
            try {
                boolean d10 = g.this.f15725o.d(this.f15749g, this.f15750h, this.f15751i, this.f15752j);
                if (d10) {
                    g.this.f15733w.O(this.f15749g, xb.b.CANCEL);
                }
                if (d10 || this.f15752j) {
                    synchronized (g.this) {
                        g.this.f15735y.remove(Integer.valueOf(this.f15749g));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f15754g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ xb.b f15755h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i10, xb.b bVar) {
            super(str, objArr);
            this.f15754g = i10;
            this.f15755h = bVar;
        }

        @Override // sb.b
        public void k() {
            g.this.f15725o.c(this.f15754g, this.f15755h);
            synchronized (g.this) {
                g.this.f15735y.remove(Integer.valueOf(this.f15754g));
            }
        }
    }

    /* renamed from: xb.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0334g {

        /* renamed from: a, reason: collision with root package name */
        Socket f15757a;

        /* renamed from: b, reason: collision with root package name */
        String f15758b;

        /* renamed from: c, reason: collision with root package name */
        bc.e f15759c;

        /* renamed from: d, reason: collision with root package name */
        bc.d f15760d;

        /* renamed from: e, reason: collision with root package name */
        h f15761e = h.f15765a;

        /* renamed from: f, reason: collision with root package name */
        l f15762f = l.f15825a;

        /* renamed from: g, reason: collision with root package name */
        boolean f15763g;

        /* renamed from: h, reason: collision with root package name */
        int f15764h;

        public C0334g(boolean z10) {
            this.f15763g = z10;
        }

        public g a() {
            return new g(this);
        }

        public C0334g b(h hVar) {
            this.f15761e = hVar;
            return this;
        }

        public C0334g c(int i10) {
            this.f15764h = i10;
            return this;
        }

        public C0334g d(Socket socket, String str, bc.e eVar, bc.d dVar) {
            this.f15757a = socket;
            this.f15758b = str;
            this.f15759c = eVar;
            this.f15760d = dVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public static final h f15765a = new a();

        /* loaded from: classes.dex */
        class a extends h {
            a() {
            }

            @Override // xb.g.h
            public void b(xb.i iVar) {
                iVar.f(xb.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void b(xb.i iVar);
    }

    /* loaded from: classes.dex */
    final class i extends sb.b {

        /* renamed from: g, reason: collision with root package name */
        final boolean f15766g;

        /* renamed from: h, reason: collision with root package name */
        final int f15767h;

        /* renamed from: i, reason: collision with root package name */
        final int f15768i;

        i(boolean z10, int i10, int i11) {
            super("OkHttp %s ping %08x%08x", g.this.f15719i, Integer.valueOf(i10), Integer.valueOf(i11));
            this.f15766g = z10;
            this.f15767h = i10;
            this.f15768i = i11;
        }

        @Override // sb.b
        public void k() {
            g.this.m0(this.f15766g, this.f15767h, this.f15768i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends sb.b implements h.b {

        /* renamed from: g, reason: collision with root package name */
        final xb.h f15770g;

        /* loaded from: classes.dex */
        class a extends sb.b {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ xb.i f15772g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, xb.i iVar) {
                super(str, objArr);
                this.f15772g = iVar;
            }

            @Override // sb.b
            public void k() {
                try {
                    g.this.f15717g.b(this.f15772g);
                } catch (IOException e10) {
                    yb.f.j().p(4, "Http2Connection.Listener failure for " + g.this.f15719i, e10);
                    try {
                        this.f15772g.f(xb.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        class b extends sb.b {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // sb.b
            public void k() {
                g gVar = g.this;
                gVar.f15717g.a(gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c extends sb.b {

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ m f15775g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f15775g = mVar;
            }

            @Override // sb.b
            public void k() {
                try {
                    g.this.f15733w.c(this.f15775g);
                } catch (IOException unused) {
                    g.this.v();
                }
            }
        }

        j(xb.h hVar) {
            super("OkHttp %s", g.this.f15719i);
            this.f15770g = hVar;
        }

        private void l(m mVar) {
            try {
                g.this.f15723m.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f15719i}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // xb.h.b
        public void a(boolean z10, m mVar) {
            xb.i[] iVarArr;
            long j10;
            int i10;
            synchronized (g.this) {
                int d10 = g.this.f15730t.d();
                if (z10) {
                    g.this.f15730t.a();
                }
                g.this.f15730t.h(mVar);
                l(mVar);
                int d11 = g.this.f15730t.d();
                iVarArr = null;
                if (d11 == -1 || d11 == d10) {
                    j10 = 0;
                } else {
                    j10 = d11 - d10;
                    g gVar = g.this;
                    if (!gVar.f15731u) {
                        gVar.f15731u = true;
                    }
                    if (!gVar.f15718h.isEmpty()) {
                        iVarArr = (xb.i[]) g.this.f15718h.values().toArray(new xb.i[g.this.f15718h.size()]);
                    }
                }
                g.f15715z.execute(new b("OkHttp %s settings", g.this.f15719i));
            }
            if (iVarArr == null || j10 == 0) {
                return;
            }
            for (xb.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.c(j10);
                }
            }
        }

        @Override // xb.h.b
        public void b(boolean z10, int i10, bc.e eVar, int i11) {
            if (g.this.f0(i10)) {
                g.this.a0(i10, eVar, i11, z10);
                return;
            }
            xb.i D = g.this.D(i10);
            if (D == null) {
                g.this.o0(i10, xb.b.PROTOCOL_ERROR);
                long j10 = i11;
                g.this.k0(j10);
                eVar.q(j10);
                return;
            }
            D.o(eVar, i11);
            if (z10) {
                D.p();
            }
        }

        @Override // xb.h.b
        public void c() {
        }

        @Override // xb.h.b
        public void d(boolean z10, int i10, int i11) {
            if (!z10) {
                try {
                    g.this.f15723m.execute(new i(true, i10, i11));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (g.this) {
                    g.this.f15726p = false;
                    g.this.notifyAll();
                }
            }
        }

        @Override // xb.h.b
        public void e(int i10, int i11, int i12, boolean z10) {
        }

        @Override // xb.h.b
        public void f(boolean z10, int i10, int i11, List<xb.c> list) {
            if (g.this.f0(i10)) {
                g.this.c0(i10, list, z10);
                return;
            }
            synchronized (g.this) {
                xb.i D = g.this.D(i10);
                if (D != null) {
                    D.q(list);
                    if (z10) {
                        D.p();
                        return;
                    }
                    return;
                }
                g gVar = g.this;
                if (gVar.f15722l) {
                    return;
                }
                if (i10 <= gVar.f15720j) {
                    return;
                }
                if (i10 % 2 == gVar.f15721k % 2) {
                    return;
                }
                xb.i iVar = new xb.i(i10, g.this, false, z10, sb.c.H(list));
                g gVar2 = g.this;
                gVar2.f15720j = i10;
                gVar2.f15718h.put(Integer.valueOf(i10), iVar);
                g.f15715z.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f15719i, Integer.valueOf(i10)}, iVar));
            }
        }

        @Override // xb.h.b
        public void g(int i10, long j10) {
            g gVar = g.this;
            if (i10 == 0) {
                synchronized (gVar) {
                    g gVar2 = g.this;
                    gVar2.f15728r += j10;
                    gVar2.notifyAll();
                }
                return;
            }
            xb.i D = gVar.D(i10);
            if (D != null) {
                synchronized (D) {
                    D.c(j10);
                }
            }
        }

        @Override // xb.h.b
        public void h(int i10, int i11, List<xb.c> list) {
            g.this.d0(i11, list);
        }

        @Override // xb.h.b
        public void i(int i10, xb.b bVar, bc.f fVar) {
            xb.i[] iVarArr;
            fVar.B();
            synchronized (g.this) {
                iVarArr = (xb.i[]) g.this.f15718h.values().toArray(new xb.i[g.this.f15718h.size()]);
                g.this.f15722l = true;
            }
            for (xb.i iVar : iVarArr) {
                if (iVar.i() > i10 && iVar.l()) {
                    iVar.r(xb.b.REFUSED_STREAM);
                    g.this.g0(iVar.i());
                }
            }
        }

        @Override // xb.h.b
        public void j(int i10, xb.b bVar) {
            if (g.this.f0(i10)) {
                g.this.e0(i10, bVar);
                return;
            }
            xb.i g02 = g.this.g0(i10);
            if (g02 != null) {
                g02.r(bVar);
            }
        }

        @Override // sb.b
        protected void k() {
            xb.b bVar;
            xb.b bVar2 = xb.b.INTERNAL_ERROR;
            try {
                try {
                    this.f15770g.f(this);
                    do {
                    } while (this.f15770g.d(false, this));
                    bVar = xb.b.NO_ERROR;
                    try {
                        try {
                            g.this.j(bVar, xb.b.CANCEL);
                        } catch (IOException unused) {
                            xb.b bVar3 = xb.b.PROTOCOL_ERROR;
                            g.this.j(bVar3, bVar3);
                            sb.c.g(this.f15770g);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            g.this.j(bVar, bVar2);
                        } catch (IOException unused2) {
                        }
                        sb.c.g(this.f15770g);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                bVar = bVar2;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                g.this.j(bVar, bVar2);
                sb.c.g(this.f15770g);
                throw th;
            }
            sb.c.g(this.f15770g);
        }
    }

    g(C0334g c0334g) {
        m mVar = new m();
        this.f15730t = mVar;
        this.f15731u = false;
        this.f15735y = new LinkedHashSet();
        this.f15725o = c0334g.f15762f;
        boolean z10 = c0334g.f15763g;
        this.f15716f = z10;
        this.f15717g = c0334g.f15761e;
        int i10 = z10 ? 1 : 2;
        this.f15721k = i10;
        if (z10) {
            this.f15721k = i10 + 2;
        }
        if (z10) {
            this.f15729s.i(7, 16777216);
        }
        String str = c0334g.f15758b;
        this.f15719i = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, sb.c.G(sb.c.r("OkHttp %s Writer", str), false));
        this.f15723m = scheduledThreadPoolExecutor;
        if (c0334g.f15764h != 0) {
            i iVar = new i(false, 0, 0);
            int i11 = c0334g.f15764h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i11, i11, TimeUnit.MILLISECONDS);
        }
        this.f15724n = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), sb.c.G(sb.c.r("OkHttp %s Push Observer", str), true));
        mVar.i(7, 65535);
        mVar.i(5, 16384);
        this.f15728r = mVar.d();
        this.f15732v = c0334g.f15757a;
        this.f15733w = new xb.j(c0334g.f15760d, z10);
        this.f15734x = new j(new xb.h(c0334g.f15759c, z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private xb.i N(int r11, java.util.List<xb.c> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            xb.j r7 = r10.f15733w
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L76
            int r0 = r10.f15721k     // Catch: java.lang.Throwable -> L73
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            xb.b r0 = xb.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L73
            r10.h0(r0)     // Catch: java.lang.Throwable -> L73
        L13:
            boolean r0 = r10.f15722l     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L6d
            int r8 = r10.f15721k     // Catch: java.lang.Throwable -> L73
            int r0 = r8 + 2
            r10.f15721k = r0     // Catch: java.lang.Throwable -> L73
            xb.i r9 = new xb.i     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r13 == 0) goto L3a
            long r0 = r10.f15728r     // Catch: java.lang.Throwable -> L73
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3a
            long r0 = r9.f15789b     // Catch: java.lang.Throwable -> L73
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L38
            goto L3a
        L38:
            r13 = 0
            goto L3b
        L3a:
            r13 = 1
        L3b:
            boolean r0 = r9.m()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L4a
            java.util.Map<java.lang.Integer, xb.i> r0 = r10.f15718h     // Catch: java.lang.Throwable -> L73
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L73
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L73
        L4a:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            if (r11 != 0) goto L53
            xb.j r0 = r10.f15733w     // Catch: java.lang.Throwable -> L76
            r0.b0(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L76
            goto L5c
        L53:
            boolean r0 = r10.f15716f     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L65
            xb.j r0 = r10.f15733w     // Catch: java.lang.Throwable -> L76
            r0.N(r11, r8, r12)     // Catch: java.lang.Throwable -> L76
        L5c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L64
            xb.j r11 = r10.f15733w
            r11.flush()
        L64:
            return r9
        L65:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L76
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L76
            throw r11     // Catch: java.lang.Throwable -> L76
        L6d:
            xb.a r11 = new xb.a     // Catch: java.lang.Throwable -> L73
            r11.<init>()     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L73
        L73:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L76
        L76:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: xb.g.N(int, java.util.List, boolean):xb.i");
    }

    private synchronized void b0(sb.b bVar) {
        if (!H()) {
            this.f15724n.execute(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            xb.b bVar = xb.b.PROTOCOL_ERROR;
            j(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    synchronized xb.i D(int i10) {
        return this.f15718h.get(Integer.valueOf(i10));
    }

    public synchronized boolean H() {
        return this.f15722l;
    }

    public synchronized int M() {
        return this.f15730t.e(Integer.MAX_VALUE);
    }

    public xb.i O(List<xb.c> list, boolean z10) {
        return N(0, list, z10);
    }

    void a0(int i10, bc.e eVar, int i11, boolean z10) {
        bc.c cVar = new bc.c();
        long j10 = i11;
        eVar.R(j10);
        eVar.G(cVar, j10);
        if (cVar.n0() == j10) {
            b0(new e("OkHttp %s Push Data[%s]", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, cVar, i11, z10));
            return;
        }
        throw new IOException(cVar.n0() + " != " + i11);
    }

    void c0(int i10, List<xb.c> list, boolean z10) {
        try {
            b0(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, list, z10));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        j(xb.b.NO_ERROR, xb.b.CANCEL);
    }

    void d0(int i10, List<xb.c> list) {
        synchronized (this) {
            if (this.f15735y.contains(Integer.valueOf(i10))) {
                o0(i10, xb.b.PROTOCOL_ERROR);
                return;
            }
            this.f15735y.add(Integer.valueOf(i10));
            try {
                b0(new c("OkHttp %s Push Request[%s]", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void e0(int i10, xb.b bVar) {
        b0(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, bVar));
    }

    boolean f0(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public void flush() {
        this.f15733w.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized xb.i g0(int i10) {
        xb.i remove;
        remove = this.f15718h.remove(Integer.valueOf(i10));
        notifyAll();
        return remove;
    }

    public void h0(xb.b bVar) {
        synchronized (this.f15733w) {
            synchronized (this) {
                if (this.f15722l) {
                    return;
                }
                this.f15722l = true;
                this.f15733w.v(this.f15720j, bVar, sb.c.f14196a);
            }
        }
    }

    public void i0() {
        j0(true);
    }

    void j(xb.b bVar, xb.b bVar2) {
        xb.i[] iVarArr = null;
        try {
            h0(bVar);
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        synchronized (this) {
            if (!this.f15718h.isEmpty()) {
                iVarArr = (xb.i[]) this.f15718h.values().toArray(new xb.i[this.f15718h.size()]);
                this.f15718h.clear();
            }
        }
        if (iVarArr != null) {
            for (xb.i iVar : iVarArr) {
                try {
                    iVar.f(bVar2);
                } catch (IOException e11) {
                    if (e != null) {
                        e = e11;
                    }
                }
            }
        }
        try {
            this.f15733w.close();
        } catch (IOException e12) {
            if (e == null) {
                e = e12;
            }
        }
        try {
            this.f15732v.close();
        } catch (IOException e13) {
            e = e13;
        }
        this.f15723m.shutdown();
        this.f15724n.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void j0(boolean z10) {
        if (z10) {
            this.f15733w.d();
            this.f15733w.a0(this.f15729s);
            if (this.f15729s.d() != 65535) {
                this.f15733w.c0(0, r6 - 65535);
            }
        }
        new Thread(this.f15734x).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void k0(long j10) {
        long j11 = this.f15727q + j10;
        this.f15727q = j11;
        if (j11 >= this.f15729s.d() / 2) {
            p0(0, this.f15727q);
            this.f15727q = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f15733w.H());
        r6 = r3;
        r8.f15728r -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l0(int r9, boolean r10, bc.c r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            xb.j r12 = r8.f15733w
            r12.f(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.f15728r     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, xb.i> r3 = r8.f15718h     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            xb.j r3 = r8.f15733w     // Catch: java.lang.Throwable -> L56
            int r3 = r3.H()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f15728r     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f15728r = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            xb.j r4 = r8.f15733w
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.f(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L65
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L56
            r9.interrupt()     // Catch: java.lang.Throwable -> L56
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xb.g.l0(int, boolean, bc.c, long):void");
    }

    void m0(boolean z10, int i10, int i11) {
        boolean z11;
        if (!z10) {
            synchronized (this) {
                z11 = this.f15726p;
                this.f15726p = true;
            }
            if (z11) {
                v();
                return;
            }
        }
        try {
            this.f15733w.M(z10, i10, i11);
        } catch (IOException unused) {
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n0(int i10, xb.b bVar) {
        this.f15733w.O(i10, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(int i10, xb.b bVar) {
        try {
            this.f15723m.execute(new a("OkHttp %s stream %d", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0(int i10, long j10) {
        try {
            this.f15723m.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f15719i, Integer.valueOf(i10)}, i10, j10));
        } catch (RejectedExecutionException unused) {
        }
    }
}
