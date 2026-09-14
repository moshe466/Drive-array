package xb;

import bc.r;
import bc.s;
import bc.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import okhttp3.q;
import xb.c;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    long f15788a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f15789b;

    /* renamed from: c, reason: collision with root package name */
    final int f15790c;

    /* renamed from: d, reason: collision with root package name */
    final g f15791d;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<q> f15792e;

    /* renamed from: f, reason: collision with root package name */
    private c.a f15793f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f15794g;

    /* renamed from: h, reason: collision with root package name */
    private final b f15795h;

    /* renamed from: i, reason: collision with root package name */
    final a f15796i;

    /* renamed from: j, reason: collision with root package name */
    final c f15797j;

    /* renamed from: k, reason: collision with root package name */
    final c f15798k;

    /* renamed from: l, reason: collision with root package name */
    xb.b f15799l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements r {

        /* renamed from: f, reason: collision with root package name */
        private final bc.c f15800f = new bc.c();

        /* renamed from: g, reason: collision with root package name */
        boolean f15801g;

        /* renamed from: h, reason: collision with root package name */
        boolean f15802h;

        a() {
        }

        private void c(boolean z10) {
            i iVar;
            long min;
            i iVar2;
            synchronized (i.this) {
                i.this.f15798k.k();
                while (true) {
                    try {
                        iVar = i.this;
                        if (iVar.f15789b > 0 || this.f15802h || this.f15801g || iVar.f15799l != null) {
                            break;
                        } else {
                            iVar.t();
                        }
                    } finally {
                    }
                }
                iVar.f15798k.u();
                i.this.e();
                min = Math.min(i.this.f15789b, this.f15800f.n0());
                iVar2 = i.this;
                iVar2.f15789b -= min;
            }
            iVar2.f15798k.k();
            try {
                i iVar3 = i.this;
                iVar3.f15791d.l0(iVar3.f15790c, z10 && min == this.f15800f.n0(), this.f15800f, min);
            } finally {
            }
        }

        @Override // bc.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (i.this) {
                if (this.f15801g) {
                    return;
                }
                if (!i.this.f15796i.f15802h) {
                    if (this.f15800f.n0() > 0) {
                        while (this.f15800f.n0() > 0) {
                            c(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f15791d.l0(iVar.f15790c, true, null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.f15801g = true;
                }
                i.this.f15791d.flush();
                i.this.d();
            }
        }

        @Override // bc.r
        public t e() {
            return i.this.f15798k;
        }

        @Override // bc.r, java.io.Flushable
        public void flush() {
            synchronized (i.this) {
                i.this.e();
            }
            while (this.f15800f.n0() > 0) {
                c(false);
                i.this.f15791d.flush();
            }
        }

        @Override // bc.r
        public void l(bc.c cVar, long j10) {
            this.f15800f.l(cVar, j10);
            while (this.f15800f.n0() >= 16384) {
                c(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements s {

        /* renamed from: f, reason: collision with root package name */
        private final bc.c f15804f = new bc.c();

        /* renamed from: g, reason: collision with root package name */
        private final bc.c f15805g = new bc.c();

        /* renamed from: h, reason: collision with root package name */
        private final long f15806h;

        /* renamed from: i, reason: collision with root package name */
        boolean f15807i;

        /* renamed from: j, reason: collision with root package name */
        boolean f15808j;

        b(long j10) {
            this.f15806h = j10;
        }

        private void d(long j10) {
            i.this.f15791d.k0(j10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // bc.s
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long G(bc.c r17, long r18) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xb.i.b.G(bc.c, long):long");
        }

        void c(bc.e eVar, long j10) {
            boolean z10;
            boolean z11;
            boolean z12;
            while (j10 > 0) {
                synchronized (i.this) {
                    z10 = this.f15808j;
                    z11 = true;
                    z12 = this.f15805g.n0() + j10 > this.f15806h;
                }
                if (z12) {
                    eVar.q(j10);
                    i.this.h(xb.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    eVar.q(j10);
                    return;
                }
                long G = eVar.G(this.f15804f, j10);
                if (G == -1) {
                    throw new EOFException();
                }
                j10 -= G;
                synchronized (i.this) {
                    if (this.f15805g.n0() != 0) {
                        z11 = false;
                    }
                    this.f15805g.n(this.f15804f);
                    if (z11) {
                        i.this.notifyAll();
                    }
                }
            }
        }

        @Override // bc.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long n02;
            c.a aVar;
            ArrayList arrayList;
            synchronized (i.this) {
                this.f15807i = true;
                n02 = this.f15805g.n0();
                this.f15805g.d();
                aVar = null;
                if (i.this.f15792e.isEmpty() || i.this.f15793f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(i.this.f15792e);
                    i.this.f15792e.clear();
                    aVar = i.this.f15793f;
                    arrayList = arrayList2;
                }
                i.this.notifyAll();
            }
            if (n02 > 0) {
                d(n02);
            }
            i.this.d();
            if (aVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    aVar.a((q) it.next());
                }
            }
        }

        @Override // bc.s
        public t e() {
            return i.this.f15797j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends bc.a {
        c() {
        }

        @Override // bc.a
        protected IOException o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bc.a
        protected void t() {
            i.this.h(xb.b.CANCEL);
        }

        public void u() {
            if (n()) {
                throw o(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(int i10, g gVar, boolean z10, boolean z11, q qVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f15792e = arrayDeque;
        this.f15797j = new c();
        this.f15798k = new c();
        this.f15799l = null;
        Objects.requireNonNull(gVar, "connection == null");
        this.f15790c = i10;
        this.f15791d = gVar;
        this.f15789b = gVar.f15730t.d();
        b bVar = new b(gVar.f15729s.d());
        this.f15795h = bVar;
        a aVar = new a();
        this.f15796i = aVar;
        bVar.f15808j = z11;
        aVar.f15802h = z10;
        if (qVar != null) {
            arrayDeque.add(qVar);
        }
        if (l() && qVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!l() && qVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean g(xb.b bVar) {
        synchronized (this) {
            if (this.f15799l != null) {
                return false;
            }
            if (this.f15795h.f15808j && this.f15796i.f15802h) {
                return false;
            }
            this.f15799l = bVar;
            notifyAll();
            this.f15791d.g0(this.f15790c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j10) {
        this.f15789b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    void d() {
        boolean z10;
        boolean m10;
        synchronized (this) {
            b bVar = this.f15795h;
            if (!bVar.f15808j && bVar.f15807i) {
                a aVar = this.f15796i;
                if (aVar.f15802h || aVar.f15801g) {
                    z10 = true;
                    m10 = m();
                }
            }
            z10 = false;
            m10 = m();
        }
        if (z10) {
            f(xb.b.CANCEL);
        } else {
            if (m10) {
                return;
            }
            this.f15791d.g0(this.f15790c);
        }
    }

    void e() {
        a aVar = this.f15796i;
        if (aVar.f15801g) {
            throw new IOException("stream closed");
        }
        if (aVar.f15802h) {
            throw new IOException("stream finished");
        }
        if (this.f15799l != null) {
            throw new n(this.f15799l);
        }
    }

    public void f(xb.b bVar) {
        if (g(bVar)) {
            this.f15791d.n0(this.f15790c, bVar);
        }
    }

    public void h(xb.b bVar) {
        if (g(bVar)) {
            this.f15791d.o0(this.f15790c, bVar);
        }
    }

    public int i() {
        return this.f15790c;
    }

    public r j() {
        synchronized (this) {
            if (!this.f15794g && !l()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f15796i;
    }

    public s k() {
        return this.f15795h;
    }

    public boolean l() {
        return this.f15791d.f15716f == ((this.f15790c & 1) == 1);
    }

    public synchronized boolean m() {
        if (this.f15799l != null) {
            return false;
        }
        b bVar = this.f15795h;
        if (bVar.f15808j || bVar.f15807i) {
            a aVar = this.f15796i;
            if (aVar.f15802h || aVar.f15801g) {
                if (this.f15794g) {
                    return false;
                }
            }
        }
        return true;
    }

    public t n() {
        return this.f15797j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(bc.e eVar, int i10) {
        this.f15795h.c(eVar, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        boolean m10;
        synchronized (this) {
            this.f15795h.f15808j = true;
            m10 = m();
            notifyAll();
        }
        if (m10) {
            return;
        }
        this.f15791d.g0(this.f15790c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(List<xb.c> list) {
        boolean m10;
        synchronized (this) {
            this.f15794g = true;
            this.f15792e.add(sb.c.H(list));
            m10 = m();
            notifyAll();
        }
        if (m10) {
            return;
        }
        this.f15791d.g0(this.f15790c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(xb.b bVar) {
        if (this.f15799l == null) {
            this.f15799l = bVar;
            notifyAll();
        }
    }

    public synchronized q s() {
        this.f15797j.k();
        while (this.f15792e.isEmpty() && this.f15799l == null) {
            try {
                t();
            } catch (Throwable th) {
                this.f15797j.u();
                throw th;
            }
        }
        this.f15797j.u();
        if (this.f15792e.isEmpty()) {
            throw new n(this.f15799l);
        }
        return this.f15792e.removeFirst();
    }

    void t() {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public t u() {
        return this.f15798k;
    }
}
