package ub;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.c0;
import okhttp3.i;
import okhttp3.o;
import okhttp3.s;
import okhttp3.v;
import ub.f;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final okhttp3.a f14588a;

    /* renamed from: b, reason: collision with root package name */
    private f.a f14589b;

    /* renamed from: c, reason: collision with root package name */
    private c0 f14590c;

    /* renamed from: d, reason: collision with root package name */
    private final i f14591d;

    /* renamed from: e, reason: collision with root package name */
    public final okhttp3.d f14592e;

    /* renamed from: f, reason: collision with root package name */
    public final o f14593f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f14594g;

    /* renamed from: h, reason: collision with root package name */
    private final f f14595h;

    /* renamed from: i, reason: collision with root package name */
    private int f14596i;

    /* renamed from: j, reason: collision with root package name */
    private c f14597j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14598k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f14599l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f14600m;

    /* renamed from: n, reason: collision with root package name */
    private vb.c f14601n;

    /* loaded from: classes.dex */
    public static final class a extends WeakReference<g> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f14602a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f14602a = obj;
        }
    }

    public g(i iVar, okhttp3.a aVar, okhttp3.d dVar, o oVar, Object obj) {
        this.f14591d = iVar;
        this.f14588a = aVar;
        this.f14592e = dVar;
        this.f14593f = oVar;
        this.f14595h = new f(aVar, p(), dVar, oVar);
        this.f14594g = obj;
    }

    private Socket e(boolean z10, boolean z11, boolean z12) {
        Socket socket;
        if (z12) {
            this.f14601n = null;
        }
        if (z11) {
            this.f14599l = true;
        }
        c cVar = this.f14597j;
        if (cVar == null) {
            return null;
        }
        if (z10) {
            cVar.f14570k = true;
        }
        if (this.f14601n != null) {
            return null;
        }
        if (!this.f14599l && !cVar.f14570k) {
            return null;
        }
        l(cVar);
        if (this.f14597j.f14573n.isEmpty()) {
            this.f14597j.f14574o = System.nanoTime();
            if (sb.a.f14194a.e(this.f14591d, this.f14597j)) {
                socket = this.f14597j.q();
                this.f14597j = null;
                return socket;
            }
        }
        socket = null;
        this.f14597j = null;
        return socket;
    }

    private c f(int i10, int i11, int i12, int i13, boolean z10) {
        c cVar;
        Socket n10;
        c cVar2;
        Socket socket;
        c0 c0Var;
        boolean z11;
        boolean z12;
        f.a aVar;
        synchronized (this.f14591d) {
            if (this.f14599l) {
                throw new IllegalStateException("released");
            }
            if (this.f14601n != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f14600m) {
                throw new IOException("Canceled");
            }
            cVar = this.f14597j;
            n10 = n();
            cVar2 = this.f14597j;
            socket = null;
            if (cVar2 != null) {
                cVar = null;
            } else {
                cVar2 = null;
            }
            if (!this.f14598k) {
                cVar = null;
            }
            if (cVar2 == null) {
                sb.a.f14194a.h(this.f14591d, this.f14588a, this, null);
                c cVar3 = this.f14597j;
                if (cVar3 != null) {
                    cVar2 = cVar3;
                    z11 = true;
                    c0Var = null;
                } else {
                    c0Var = this.f14590c;
                }
            } else {
                c0Var = null;
            }
            z11 = false;
        }
        sb.c.h(n10);
        if (cVar != null) {
            this.f14593f.h(this.f14592e, cVar);
        }
        if (z11) {
            this.f14593f.g(this.f14592e, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (c0Var != null || ((aVar = this.f14589b) != null && aVar.b())) {
            z12 = false;
        } else {
            this.f14589b = this.f14595h.e();
            z12 = true;
        }
        synchronized (this.f14591d) {
            if (this.f14600m) {
                throw new IOException("Canceled");
            }
            if (z12) {
                List<c0> a10 = this.f14589b.a();
                int size = a10.size();
                int i14 = 0;
                while (true) {
                    if (i14 >= size) {
                        break;
                    }
                    c0 c0Var2 = a10.get(i14);
                    sb.a.f14194a.h(this.f14591d, this.f14588a, this, c0Var2);
                    c cVar4 = this.f14597j;
                    if (cVar4 != null) {
                        this.f14590c = c0Var2;
                        cVar2 = cVar4;
                        z11 = true;
                        break;
                    }
                    i14++;
                }
            }
            if (!z11) {
                if (c0Var == null) {
                    c0Var = this.f14589b.c();
                }
                this.f14590c = c0Var;
                this.f14596i = 0;
                cVar2 = new c(this.f14591d, c0Var);
                a(cVar2, false);
            }
        }
        if (!z11) {
            cVar2.d(i10, i11, i12, i13, z10, this.f14592e, this.f14593f);
            p().a(cVar2.p());
            synchronized (this.f14591d) {
                this.f14598k = true;
                sb.a.f14194a.i(this.f14591d, cVar2);
                if (cVar2.n()) {
                    socket = sb.a.f14194a.f(this.f14591d, this.f14588a, this);
                    cVar2 = this.f14597j;
                }
            }
            sb.c.h(socket);
        }
        this.f14593f.g(this.f14592e, cVar2);
        return cVar2;
    }

    private c g(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        while (true) {
            c f10 = f(i10, i11, i12, i13, z10);
            synchronized (this.f14591d) {
                if (f10.f14571l == 0) {
                    return f10;
                }
                if (f10.m(z11)) {
                    return f10;
                }
                j();
            }
        }
    }

    private void l(c cVar) {
        int size = cVar.f14573n.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (cVar.f14573n.get(i10).get() == this) {
                cVar.f14573n.remove(i10);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket n() {
        c cVar = this.f14597j;
        if (cVar == null || !cVar.f14570k) {
            return null;
        }
        return e(false, false, true);
    }

    private d p() {
        return sb.a.f14194a.j(this.f14591d);
    }

    public void a(c cVar, boolean z10) {
        if (this.f14597j != null) {
            throw new IllegalStateException();
        }
        this.f14597j = cVar;
        this.f14598k = z10;
        cVar.f14573n.add(new a(this, this.f14594g));
    }

    public void b() {
        vb.c cVar;
        c cVar2;
        synchronized (this.f14591d) {
            this.f14600m = true;
            cVar = this.f14601n;
            cVar2 = this.f14597j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.c();
        }
    }

    public vb.c c() {
        vb.c cVar;
        synchronized (this.f14591d) {
            cVar = this.f14601n;
        }
        return cVar;
    }

    public synchronized c d() {
        return this.f14597j;
    }

    public boolean h() {
        f.a aVar;
        return this.f14590c != null || ((aVar = this.f14589b) != null && aVar.b()) || this.f14595h.c();
    }

    public vb.c i(v vVar, s.a aVar, boolean z10) {
        try {
            vb.c o10 = g(aVar.a(), aVar.b(), aVar.c(), vVar.y(), vVar.F(), z10).o(vVar, aVar, this);
            synchronized (this.f14591d) {
                this.f14601n = o10;
            }
            return o10;
        } catch (IOException e10) {
            throw new e(e10);
        }
    }

    public void j() {
        c cVar;
        Socket e10;
        synchronized (this.f14591d) {
            cVar = this.f14597j;
            e10 = e(true, false, false);
            if (this.f14597j != null) {
                cVar = null;
            }
        }
        sb.c.h(e10);
        if (cVar != null) {
            this.f14593f.h(this.f14592e, cVar);
        }
    }

    public void k() {
        c cVar;
        Socket e10;
        synchronized (this.f14591d) {
            cVar = this.f14597j;
            e10 = e(false, true, false);
            if (this.f14597j != null) {
                cVar = null;
            }
        }
        sb.c.h(e10);
        if (cVar != null) {
            sb.a.f14194a.k(this.f14592e, null);
            this.f14593f.h(this.f14592e, cVar);
            this.f14593f.a(this.f14592e);
        }
    }

    public Socket m(c cVar) {
        if (this.f14601n != null || this.f14597j.f14573n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<g> reference = this.f14597j.f14573n.get(0);
        Socket e10 = e(true, false, false);
        this.f14597j = cVar;
        cVar.f14573n.add(reference);
        return e10;
    }

    public c0 o() {
        return this.f14590c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x001c, code lost:
    
        if (r7 != xb.b.CANCEL) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x0062, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:8:0x0012, B:11:0x001e, B:13:0x0044, B:15:0x004e, B:19:0x0054, B:28:0x001a, B:30:0x0021, B:32:0x0025, B:34:0x002b, B:36:0x002f, B:38:0x0035, B:41:0x003b), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(java.io.IOException r7) {
        /*
            r6 = this;
            okhttp3.i r0 = r6.f14591d
            monitor-enter(r0)
            boolean r1 = r7 instanceof xb.n     // Catch: java.lang.Throwable -> L62
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L21
            xb.n r7 = (xb.n) r7     // Catch: java.lang.Throwable -> L62
            xb.b r7 = r7.f15828f     // Catch: java.lang.Throwable -> L62
            xb.b r1 = xb.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L62
            if (r7 != r1) goto L1a
            int r7 = r6.f14596i     // Catch: java.lang.Throwable -> L62
            int r7 = r7 + r4
            r6.f14596i = r7     // Catch: java.lang.Throwable -> L62
            if (r7 <= r4) goto L43
            goto L1e
        L1a:
            xb.b r1 = xb.b.CANCEL     // Catch: java.lang.Throwable -> L62
            if (r7 == r1) goto L43
        L1e:
            r6.f14590c = r3     // Catch: java.lang.Throwable -> L62
            goto L41
        L21:
            ub.c r1 = r6.f14597j     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L43
            boolean r1 = r1.n()     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L2f
            boolean r1 = r7 instanceof xb.a     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L43
        L2f:
            ub.c r1 = r6.f14597j     // Catch: java.lang.Throwable -> L62
            int r1 = r1.f14571l     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L41
            okhttp3.c0 r1 = r6.f14590c     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L1e
            if (r7 == 0) goto L1e
            ub.f r5 = r6.f14595h     // Catch: java.lang.Throwable -> L62
            r5.a(r1, r7)     // Catch: java.lang.Throwable -> L62
            goto L1e
        L41:
            r7 = 1
            goto L44
        L43:
            r7 = 0
        L44:
            ub.c r1 = r6.f14597j     // Catch: java.lang.Throwable -> L62
            java.net.Socket r7 = r6.e(r7, r2, r4)     // Catch: java.lang.Throwable -> L62
            ub.c r2 = r6.f14597j     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L54
            boolean r2 = r6.f14598k     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L53
            goto L54
        L53:
            r3 = r1
        L54:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L62
            sb.c.h(r7)
            if (r3 == 0) goto L61
            okhttp3.o r7 = r6.f14593f
            okhttp3.d r0 = r6.f14592e
            r7.h(r0, r3)
        L61:
            return
        L62:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L62
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.g.q(java.io.IOException):void");
    }

    public void r(boolean z10, vb.c cVar, long j10, IOException iOException) {
        c cVar2;
        Socket e10;
        boolean z11;
        this.f14593f.p(this.f14592e, j10);
        synchronized (this.f14591d) {
            if (cVar != null) {
                if (cVar == this.f14601n) {
                    if (!z10) {
                        this.f14597j.f14571l++;
                    }
                    cVar2 = this.f14597j;
                    e10 = e(z10, false, true);
                    if (this.f14597j != null) {
                        cVar2 = null;
                    }
                    z11 = this.f14599l;
                }
            }
            throw new IllegalStateException("expected " + this.f14601n + " but was " + cVar);
        }
        sb.c.h(e10);
        if (cVar2 != null) {
            this.f14593f.h(this.f14592e, cVar2);
        }
        if (iOException != null) {
            this.f14593f.b(this.f14592e, sb.a.f14194a.k(this.f14592e, iOException));
        } else if (z11) {
            sb.a.f14194a.k(this.f14592e, null);
            this.f14593f.a(this.f14592e);
        }
    }

    public String toString() {
        c d10 = d();
        return d10 != null ? d10.toString() : this.f14588a.toString();
    }
}
