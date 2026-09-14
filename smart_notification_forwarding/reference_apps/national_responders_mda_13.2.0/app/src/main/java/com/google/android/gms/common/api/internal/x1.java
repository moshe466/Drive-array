package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x1 implements z2.f {

    /* renamed from: a, reason: collision with root package name */
    private final g f5035a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5036b;

    /* renamed from: c, reason: collision with root package name */
    private final b f5037c;

    /* renamed from: d, reason: collision with root package name */
    private final long f5038d;

    /* renamed from: e, reason: collision with root package name */
    private final long f5039e;

    x1(g gVar, int i10, b bVar, long j10, long j11, String str, String str2) {
        this.f5035a = gVar;
        this.f5036b = i10;
        this.f5037c = bVar;
        this.f5038d = j10;
        this.f5039e = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x1 b(g gVar, int i10, b bVar) {
        boolean z10;
        if (!gVar.f()) {
            return null;
        }
        b2.r a10 = b2.q.b().a();
        if (a10 == null) {
            z10 = true;
        } else {
            if (!a10.l()) {
                return null;
            }
            z10 = a10.s();
            l1 w10 = gVar.w(bVar);
            if (w10 != null) {
                if (!(w10.v() instanceof b2.c)) {
                    return null;
                }
                b2.c cVar = (b2.c) w10.v();
                if (cVar.O() && !cVar.i()) {
                    b2.f c10 = c(w10, cVar, i10);
                    if (c10 == null) {
                        return null;
                    }
                    w10.H();
                    z10 = c10.t();
                }
            }
        }
        return new x1(gVar, i10, bVar, z10 ? System.currentTimeMillis() : 0L, z10 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static b2.f c(l1 l1Var, b2.c cVar, int i10) {
        int[] j10;
        int[] l10;
        b2.f M = cVar.M();
        if (M == null || !M.s() || ((j10 = M.j()) != null ? !g2.b.b(j10, i10) : !((l10 = M.l()) == null || !g2.b.b(l10, i10))) || l1Var.s() >= M.g()) {
            return null;
        }
        return M;
    }

    @Override // z2.f
    public final void a(z2.l lVar) {
        l1 w10;
        int i10;
        int i11;
        int i12;
        int i13;
        int g10;
        long j10;
        long j11;
        int i14;
        if (this.f5035a.f()) {
            b2.r a10 = b2.q.b().a();
            if ((a10 == null || a10.l()) && (w10 = this.f5035a.w(this.f5037c)) != null && (w10.v() instanceof b2.c)) {
                b2.c cVar = (b2.c) w10.v();
                boolean z10 = this.f5038d > 0;
                int E = cVar.E();
                if (a10 != null) {
                    z10 &= a10.s();
                    int g11 = a10.g();
                    int j12 = a10.j();
                    i10 = a10.t();
                    if (cVar.O() && !cVar.i()) {
                        b2.f c10 = c(w10, cVar, this.f5036b);
                        if (c10 == null) {
                            return;
                        }
                        boolean z11 = c10.t() && this.f5038d > 0;
                        j12 = c10.g();
                        z10 = z11;
                    }
                    i11 = g11;
                    i12 = j12;
                } else {
                    i10 = 0;
                    i11 = 5000;
                    i12 = 100;
                }
                g gVar = this.f5035a;
                if (lVar.p()) {
                    i13 = 0;
                    g10 = 0;
                } else {
                    if (lVar.n()) {
                        i13 = 100;
                    } else {
                        Exception k10 = lVar.k();
                        if (k10 instanceof a2.b) {
                            Status a11 = ((a2.b) k10).a();
                            int j13 = a11.j();
                            com.google.android.gms.common.a g12 = a11.g();
                            g10 = g12 == null ? -1 : g12.g();
                            i13 = j13;
                        } else {
                            i13 = 101;
                        }
                    }
                    g10 = -1;
                }
                if (z10) {
                    long j14 = this.f5038d;
                    j11 = System.currentTimeMillis();
                    j10 = j14;
                    i14 = (int) (SystemClock.elapsedRealtime() - this.f5039e);
                } else {
                    j10 = 0;
                    j11 = 0;
                    i14 = -1;
                }
                gVar.H(new b2.n(this.f5036b, i13, g10, j10, j11, null, null, E, i14), i10, i11, i12);
            }
        }
    }
}
