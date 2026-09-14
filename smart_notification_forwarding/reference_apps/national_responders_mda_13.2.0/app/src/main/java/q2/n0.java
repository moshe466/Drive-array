package q2;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public final class n0 extends b2.h {
    public static final /* synthetic */ int I = 0;
    private final l.g F;
    private final l.g G;
    private final l.g H;

    public n0(Context context, Looper looper, b2.e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.o oVar) {
        super(context, looper, 23, eVar, fVar, oVar);
        this.F = new l.g();
        this.G = new l.g();
        this.H = new l.g();
    }

    private final boolean r0(z1.c cVar) {
        z1.c cVar2;
        z1.c[] j10 = j();
        if (j10 == null) {
            return false;
        }
        int length = j10.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                cVar2 = null;
                break;
            }
            cVar2 = j10[i10];
            if (cVar.g().equals(cVar2.g())) {
                break;
            }
            i10++;
        }
        return cVar2 != null && cVar2.j() >= cVar.j();
    }

    @Override // b2.c
    public final z1.c[] A() {
        return s2.z.f14069l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final String J() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // b2.c
    protected final String K() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // b2.c
    public final void R(int i10) {
        super.R(i10);
        synchronized (this.F) {
            this.F.clear();
        }
        synchronized (this.G) {
            this.G.clear();
        }
        synchronized (this.H) {
            this.H.clear();
        }
    }

    @Override // b2.c
    public final boolean X() {
        return true;
    }

    @Override // b2.c
    public final int h() {
        return 11717000;
    }

    public final void q0(l.a aVar, boolean z10, z2.m mVar) {
        synchronized (this.G) {
            l0 l0Var = (l0) this.G.remove(aVar);
            if (l0Var == null) {
                mVar.c(Boolean.FALSE);
                return;
            }
            l0Var.x0();
            if (!z10) {
                mVar.c(Boolean.TRUE);
            } else if (r0(s2.z.f14067j)) {
                ((v1) I()).a0(o0.g(null, l0Var, null, null), new d0(this, Boolean.TRUE, mVar));
            } else {
                ((v1) I()).S(new s0(2, null, null, l0Var, null, new f0(Boolean.TRUE, mVar), null));
            }
        }
    }

    public final void s0(s2.m mVar, PendingIntent pendingIntent, z2.m mVar2) {
        b2.p.l(mVar, "geofencingRequest can't be null.");
        b2.p.l(pendingIntent, "PendingIntent must be specified.");
        ((v1) I()).n0(mVar, pendingIntent, new a0(mVar2));
    }

    public final void t0(s2.g gVar, z2.a aVar, final z2.m mVar) {
        D();
        if (r0(s2.z.f14062e)) {
            final b2.k F = ((v1) I()).F(gVar, new e0(this, mVar));
            if (aVar != null) {
                aVar.b(new z2.i() { // from class: q2.x
                    @Override // z2.i
                    public final void a() {
                        b2.k kVar = b2.k.this;
                        int i10 = n0.I;
                        try {
                            kVar.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                });
                return;
            }
            return;
        }
        com.google.android.gms.common.api.internal.l b10 = com.google.android.gms.common.api.internal.m.b(new b0(this, mVar), k1.a(), "GetCurrentLocation");
        final l.a b11 = b10.b();
        b11.getClass();
        c0 c0Var = new c0(this, b10, mVar);
        z2.m mVar2 = new z2.m();
        LocationRequest.a aVar2 = new LocationRequest.a(gVar.s(), 0L);
        aVar2.e(0L);
        aVar2.b(gVar.g());
        aVar2.c(gVar.j());
        aVar2.d(gVar.l());
        aVar2.h(gVar.w());
        aVar2.j(gVar.t());
        aVar2.g(true);
        aVar2.i(gVar.v());
        aVar2.k(gVar.u());
        u0(c0Var, aVar2.a(), mVar2);
        mVar2.a().c(new z2.f() { // from class: q2.y
            @Override // z2.f
            public final void a(z2.l lVar) {
                z2.m mVar3 = z2.m.this;
                int i10 = n0.I;
                if (lVar.p()) {
                    return;
                }
                Exception k10 = lVar.k();
                k10.getClass();
                mVar3.d(k10);
            }
        });
        if (aVar != null) {
            aVar.b(new z2.i() { // from class: q2.z
                @Override // z2.i
                public final void a() {
                    try {
                        n0.this.q0(b11, true, new z2.m());
                    } catch (RemoteException unused) {
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x001a, B:8:0x0028, B:9:0x003b, B:11:0x0044, B:12:0x0080, B:16:0x0057, B:17:0x002e), top: B:3:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0(q2.h0 r18, com.google.android.gms.location.LocationRequest r19, z2.m r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            r2 = r20
            com.google.android.gms.common.api.internal.l r3 = r18.zza()
            com.google.android.gms.common.api.internal.l$a r4 = r3.b()
            r4.getClass()
            z1.c r5 = s2.z.f14067j
            boolean r5 = r1.r0(r5)
            l.g r6 = r1.G
            monitor-enter(r6)
            l.g r7 = r1.G     // Catch: java.lang.Throwable -> L82
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L82
            q2.l0 r7 = (q2.l0) r7     // Catch: java.lang.Throwable -> L82
            r8 = 0
            if (r7 == 0) goto L2e
            if (r5 == 0) goto L28
            goto L2e
        L28:
            r7.z(r3)     // Catch: java.lang.Throwable -> L82
            r13 = r7
            r7 = r8
            goto L3b
        L2e:
            q2.l0 r3 = new q2.l0     // Catch: java.lang.Throwable -> L82
            r9 = r18
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L82
            l.g r9 = r1.G     // Catch: java.lang.Throwable -> L82
            r9.put(r4, r3)     // Catch: java.lang.Throwable -> L82
            r13 = r3
        L3b:
            r17.D()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = r4.a()     // Catch: java.lang.Throwable -> L82
            if (r5 == 0) goto L57
            android.os.IInterface r4 = r17.I()     // Catch: java.lang.Throwable -> L82
            q2.v1 r4 = (q2.v1) r4     // Catch: java.lang.Throwable -> L82
            q2.o0 r3 = q2.o0.g(r7, r13, r8, r3)     // Catch: java.lang.Throwable -> L82
            q2.d0 r5 = new q2.d0     // Catch: java.lang.Throwable -> L82
            r5.<init>(r1, r8, r2)     // Catch: java.lang.Throwable -> L82
            r4.d0(r3, r0, r5)     // Catch: java.lang.Throwable -> L82
            goto L80
        L57:
            android.os.IInterface r4 = r17.I()     // Catch: java.lang.Throwable -> L82
            q2.v1 r4 = (q2.v1) r4     // Catch: java.lang.Throwable -> L82
            com.google.android.gms.location.LocationRequest$a r5 = new com.google.android.gms.location.LocationRequest$a     // Catch: java.lang.Throwable -> L82
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L82
            r5.i(r8)     // Catch: java.lang.Throwable -> L82
            com.google.android.gms.location.LocationRequest r0 = r5.a()     // Catch: java.lang.Throwable -> L82
            q2.q0 r11 = q2.q0.g(r8, r0)     // Catch: java.lang.Throwable -> L82
            q2.g0 r15 = new q2.g0     // Catch: java.lang.Throwable -> L82
            r15.<init>(r2, r13)     // Catch: java.lang.Throwable -> L82
            q2.s0 r0 = new q2.s0     // Catch: java.lang.Throwable -> L82
            r10 = 1
            r12 = 0
            r14 = 0
            r9 = r0
            r16 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> L82
            r4.S(r0)     // Catch: java.lang.Throwable -> L82
        L80:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
            return
        L82:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L82
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.n0.u0(q2.h0, com.google.android.gms.location.LocationRequest, z2.m):void");
    }

    public final void v0(PendingIntent pendingIntent, z2.m mVar) {
        b2.p.l(pendingIntent, "PendingIntent must be specified.");
        ((v1) I()).c0(pendingIntent, new a0(mVar), D().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final /* synthetic */ IInterface x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof v1 ? (v1) queryLocalInterface : new u1(iBinder);
    }
}
