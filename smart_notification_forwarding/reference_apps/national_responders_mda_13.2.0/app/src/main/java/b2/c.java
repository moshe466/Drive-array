package b2;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class c<T extends IInterface> {
    private static final z1.c[] C = new z1.c[0];
    private volatile e1 A;
    protected AtomicInteger B;

    /* renamed from: a, reason: collision with root package name */
    private int f3921a;

    /* renamed from: b, reason: collision with root package name */
    private long f3922b;

    /* renamed from: c, reason: collision with root package name */
    private long f3923c;

    /* renamed from: d, reason: collision with root package name */
    private int f3924d;

    /* renamed from: e, reason: collision with root package name */
    private long f3925e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f3926f;

    /* renamed from: g, reason: collision with root package name */
    p1 f3927g;

    /* renamed from: h, reason: collision with root package name */
    private final Context f3928h;

    /* renamed from: i, reason: collision with root package name */
    private final i f3929i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.android.gms.common.c f3930j;

    /* renamed from: k, reason: collision with root package name */
    final Handler f3931k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f3932l;

    /* renamed from: m, reason: collision with root package name */
    private final Object f3933m;

    /* renamed from: n, reason: collision with root package name */
    private m f3934n;

    /* renamed from: o, reason: collision with root package name */
    protected InterfaceC0067c f3935o;

    /* renamed from: p, reason: collision with root package name */
    private IInterface f3936p;

    /* renamed from: q, reason: collision with root package name */
    private final ArrayList f3937q;

    /* renamed from: r, reason: collision with root package name */
    private b1 f3938r;

    /* renamed from: s, reason: collision with root package name */
    private int f3939s;

    /* renamed from: t, reason: collision with root package name */
    private final a f3940t;

    /* renamed from: u, reason: collision with root package name */
    private final b f3941u;

    /* renamed from: v, reason: collision with root package name */
    private final int f3942v;

    /* renamed from: w, reason: collision with root package name */
    private final String f3943w;

    /* renamed from: x, reason: collision with root package name */
    private volatile String f3944x;

    /* renamed from: y, reason: collision with root package name */
    private com.google.android.gms.common.a f3945y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3946z;

    /* loaded from: classes.dex */
    public interface a {
        void i(int i10);

        void p(Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface b {
        void n(com.google.android.gms.common.a aVar);
    }

    /* renamed from: b2.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067c {
        void a(com.google.android.gms.common.a aVar);
    }

    /* loaded from: classes.dex */
    protected class d implements InterfaceC0067c {
        public d() {
        }

        @Override // b2.c.InterfaceC0067c
        public final void a(com.google.android.gms.common.a aVar) {
            if (aVar.t()) {
                c cVar = c.this;
                cVar.n(null, cVar.H());
            } else if (c.this.f3941u != null) {
                c.this.f3941u.n(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r10, android.os.Looper r11, int r12, b2.c.a r13, b2.c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            b2.i r3 = b2.i.b(r10)
            com.google.android.gms.common.c r4 = com.google.android.gms.common.c.h()
            b2.p.k(r13)
            b2.p.k(r14)
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.<init>(android.content.Context, android.os.Looper, int, b2.c$a, b2.c$b, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, i iVar, com.google.android.gms.common.c cVar, int i10, a aVar, b bVar, String str) {
        this.f3926f = null;
        this.f3932l = new Object();
        this.f3933m = new Object();
        this.f3937q = new ArrayList();
        this.f3939s = 1;
        this.f3945y = null;
        this.f3946z = false;
        this.A = null;
        this.B = new AtomicInteger(0);
        p.l(context, "Context must not be null");
        this.f3928h = context;
        p.l(looper, "Looper must not be null");
        p.l(iVar, "Supervisor must not be null");
        this.f3929i = iVar;
        p.l(cVar, "API availability must not be null");
        this.f3930j = cVar;
        this.f3931k = new y0(this, looper);
        this.f3942v = i10;
        this.f3940t = aVar;
        this.f3941u = bVar;
        this.f3943w = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void h0(c cVar, e1 e1Var) {
        cVar.A = e1Var;
        if (cVar.X()) {
            f fVar = e1Var.f3975i;
            q.b().c(fVar == null ? null : fVar.u());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void i0(c cVar, int i10) {
        int i11;
        int i12;
        synchronized (cVar.f3932l) {
            i11 = cVar.f3939s;
        }
        if (i11 == 3) {
            cVar.f3946z = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = cVar.f3931k;
        handler.sendMessage(handler.obtainMessage(i12, cVar.B.get(), 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean l0(c cVar, int i10, int i11, IInterface iInterface) {
        synchronized (cVar.f3932l) {
            if (cVar.f3939s != i10) {
                return false;
            }
            cVar.n0(i11, iInterface);
            return true;
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    static /* bridge */ /* synthetic */ boolean m0(b2.c r2) {
        /*
            boolean r0 = r2.f3946z
            r1 = 0
            if (r0 == 0) goto L6
            goto L24
        L6:
            java.lang.String r0 = r2.J()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L11
            goto L24
        L11:
            java.lang.String r0 = r2.G()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1c
            goto L24
        L1c:
            java.lang.String r2 = r2.J()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class.forName(r2)     // Catch: java.lang.ClassNotFoundException -> L24
            r1 = 1
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.c.m0(b2.c):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void n0(int i10, IInterface iInterface) {
        p1 p1Var;
        p.a((i10 == 4) == (iInterface != 0));
        synchronized (this.f3932l) {
            this.f3939s = i10;
            this.f3936p = iInterface;
            if (i10 == 1) {
                b1 b1Var = this.f3938r;
                if (b1Var != null) {
                    i iVar = this.f3929i;
                    String c10 = this.f3927g.c();
                    p.k(c10);
                    iVar.e(c10, this.f3927g.b(), this.f3927g.a(), b1Var, c0(), this.f3927g.d());
                    this.f3938r = null;
                }
            } else if (i10 == 2 || i10 == 3) {
                b1 b1Var2 = this.f3938r;
                if (b1Var2 != null && (p1Var = this.f3927g) != null) {
                    String c11 = p1Var.c();
                    String b10 = p1Var.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calling connect() while still connected, missing disconnect() for ");
                    sb2.append(c11);
                    sb2.append(" on ");
                    sb2.append(b10);
                    i iVar2 = this.f3929i;
                    String c12 = this.f3927g.c();
                    p.k(c12);
                    iVar2.e(c12, this.f3927g.b(), this.f3927g.a(), b1Var2, c0(), this.f3927g.d());
                    this.B.incrementAndGet();
                }
                b1 b1Var3 = new b1(this, this.B.get());
                this.f3938r = b1Var3;
                p1 p1Var2 = (this.f3939s != 3 || G() == null) ? new p1(L(), K(), false, i.a(), N()) : new p1(D().getPackageName(), G(), true, i.a(), false);
                this.f3927g = p1Var2;
                if (p1Var2.d() && h() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f3927g.c())));
                }
                i iVar3 = this.f3929i;
                String c13 = this.f3927g.c();
                p.k(c13);
                if (!iVar3.f(new i1(c13, this.f3927g.b(), this.f3927g.a(), this.f3927g.d()), b1Var3, c0(), B())) {
                    String c14 = this.f3927g.c();
                    String b11 = this.f3927g.b();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unable to connect to service: ");
                    sb3.append(c14);
                    sb3.append(" on ");
                    sb3.append(b11);
                    j0(16, null, this.B.get());
                }
            } else if (i10 == 4) {
                p.k(iInterface);
                P(iInterface);
            }
        }
    }

    public z1.c[] A() {
        return C;
    }

    protected Executor B() {
        return null;
    }

    public Bundle C() {
        return null;
    }

    public final Context D() {
        return this.f3928h;
    }

    public int E() {
        return this.f3942v;
    }

    protected Bundle F() {
        return new Bundle();
    }

    protected String G() {
        return null;
    }

    protected Set<Scope> H() {
        return Collections.emptySet();
    }

    public final T I() {
        T t10;
        synchronized (this.f3932l) {
            if (this.f3939s == 5) {
                throw new DeadObjectException();
            }
            w();
            t10 = (T) this.f3936p;
            p.l(t10, "Client is connected but service is null");
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String J();

    protected abstract String K();

    protected String L() {
        return "com.google.android.gms";
    }

    public f M() {
        e1 e1Var = this.A;
        if (e1Var == null) {
            return null;
        }
        return e1Var.f3975i;
    }

    protected boolean N() {
        return h() >= 211700000;
    }

    public boolean O() {
        return this.A != null;
    }

    protected void P(T t10) {
        this.f3923c = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q(com.google.android.gms.common.a aVar) {
        this.f3924d = aVar.g();
        this.f3925e = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(int i10) {
        this.f3921a = i10;
        this.f3922b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(int i10, IBinder iBinder, Bundle bundle, int i11) {
        Handler handler = this.f3931k;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, new c1(this, i10, iBinder, bundle)));
    }

    public boolean T() {
        return false;
    }

    public void U(String str) {
        this.f3944x = str;
    }

    public void V(int i10) {
        Handler handler = this.f3931k;
        handler.sendMessage(handler.obtainMessage(6, this.B.get(), i10));
    }

    protected void W(InterfaceC0067c interfaceC0067c, int i10, PendingIntent pendingIntent) {
        p.l(interfaceC0067c, "Connection progress callbacks cannot be null.");
        this.f3935o = interfaceC0067c;
        Handler handler = this.f3931k;
        handler.sendMessage(handler.obtainMessage(3, this.B.get(), i10, pendingIntent));
    }

    public boolean X() {
        return false;
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f3932l) {
            z10 = this.f3939s == 4;
        }
        return z10;
    }

    public boolean b() {
        return false;
    }

    protected final String c0() {
        String str = this.f3943w;
        return str == null ? this.f3928h.getClass().getName() : str;
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i10;
        IInterface iInterface;
        m mVar;
        synchronized (this.f3932l) {
            i10 = this.f3939s;
            iInterface = this.f3936p;
        }
        synchronized (this.f3933m) {
            mVar = this.f3934n;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) J()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (mVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(mVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f3923c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j10 = this.f3923c;
            append.println(j10 + " " + simpleDateFormat.format(new Date(j10)));
        }
        if (this.f3922b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i11 = this.f3921a;
            printWriter.append((CharSequence) (i11 != 1 ? i11 != 2 ? i11 != 3 ? String.valueOf(i11) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j11 = this.f3922b;
            append2.println(j11 + " " + simpleDateFormat.format(new Date(j11)));
        }
        if (this.f3925e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) a2.d.a(this.f3924d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j12 = this.f3925e;
            append3.println(j12 + " " + simpleDateFormat.format(new Date(j12)));
        }
    }

    public void f(String str) {
        this.f3926f = str;
        p();
    }

    public boolean g() {
        return true;
    }

    public int h() {
        return com.google.android.gms.common.c.f5093a;
    }

    public boolean i() {
        boolean z10;
        synchronized (this.f3932l) {
            int i10 = this.f3939s;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public final z1.c[] j() {
        e1 e1Var = this.A;
        if (e1Var == null) {
            return null;
        }
        return e1Var.f3973g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j0(int i10, Bundle bundle, int i11) {
        Handler handler = this.f3931k;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, new d1(this, i10, null)));
    }

    public String k() {
        p1 p1Var;
        if (!a() || (p1Var = this.f3927g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return p1Var.b();
    }

    public String m() {
        return this.f3926f;
    }

    public void n(j jVar, Set<Scope> set) {
        Bundle F = F();
        int i10 = this.f3942v;
        String str = this.f3944x;
        int i11 = com.google.android.gms.common.c.f5093a;
        Scope[] scopeArr = g.f3983t;
        Bundle bundle = new Bundle();
        z1.c[] cVarArr = g.f3984u;
        g gVar = new g(6, i10, i11, null, null, scopeArr, bundle, null, cVarArr, cVarArr, true, 0, false, str);
        gVar.f3988i = this.f3928h.getPackageName();
        gVar.f3991l = F;
        if (set != null) {
            gVar.f3990k = (Scope[]) set.toArray(new Scope[0]);
        }
        if (r()) {
            Account z10 = z();
            if (z10 == null) {
                z10 = new Account("<<default account>>", "com.google");
            }
            gVar.f3992m = z10;
            if (jVar != null) {
                gVar.f3989j = jVar.asBinder();
            }
        } else if (T()) {
            gVar.f3992m = z();
        }
        gVar.f3993n = C;
        gVar.f3994o = A();
        if (X()) {
            gVar.f3997r = true;
        }
        try {
            try {
                synchronized (this.f3933m) {
                    m mVar = this.f3934n;
                    if (mVar != null) {
                        mVar.E(new a1(this, this.B.get()), gVar);
                    }
                }
            } catch (RemoteException | RuntimeException unused) {
                S(8, null, null, this.B.get());
            }
        } catch (DeadObjectException unused2) {
            V(3);
        } catch (SecurityException e10) {
            throw e10;
        }
    }

    public void o(e eVar) {
        eVar.a();
    }

    public void p() {
        this.B.incrementAndGet();
        synchronized (this.f3937q) {
            int size = this.f3937q.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((z0) this.f3937q.get(i10)).d();
            }
            this.f3937q.clear();
        }
        synchronized (this.f3933m) {
            this.f3934n = null;
        }
        n0(1, null);
    }

    public Intent q() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean r() {
        return false;
    }

    public void t(InterfaceC0067c interfaceC0067c) {
        p.l(interfaceC0067c, "Connection progress callbacks cannot be null.");
        this.f3935o = interfaceC0067c;
        n0(2, null);
    }

    public void v() {
        int j10 = this.f3930j.j(this.f3928h, h());
        if (j10 == 0) {
            t(new d());
        } else {
            n0(1, null);
            W(new d(), j10, null);
        }
    }

    protected final void w() {
        if (!a()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T x(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y() {
        return false;
    }

    public Account z() {
        return null;
    }
}
