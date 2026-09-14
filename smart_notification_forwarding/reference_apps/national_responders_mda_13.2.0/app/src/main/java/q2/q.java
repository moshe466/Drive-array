package q2;

import a2.a;
import a2.e;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.Executor;
import s2.g;

/* loaded from: classes.dex */
public final class q extends a2.e implements s2.h {

    /* renamed from: j, reason: collision with root package name */
    static final a.g f13527j;

    /* renamed from: k, reason: collision with root package name */
    public static final a2.a f13528k;

    static {
        a.g gVar = new a.g();
        f13527j = gVar;
        f13528k = new a2.a("LocationServices.API", new n(), gVar);
    }

    public q(Context context) {
        super(context, f13528k, a.d.f53a, e.a.f65c);
    }

    private final z2.l x(final LocationRequest locationRequest, com.google.android.gms.common.api.internal.l lVar) {
        final p pVar = new p(this, lVar, new o() { // from class: q2.g
            @Override // q2.o
            public final void a(n0 n0Var, l.a aVar, boolean z10, z2.m mVar) {
                n0Var.q0(aVar, z10, mVar);
            }
        });
        return l(com.google.android.gms.common.api.internal.q.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.h
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                a2.a aVar = q.f13528k;
                ((n0) obj).u0(p.this, locationRequest, (z2.m) obj2);
            }
        }).d(pVar).e(lVar).c(2436).a());
    }

    @Override // s2.h
    public final z2.l<Void> c(s2.n nVar) {
        return m(com.google.android.gms.common.api.internal.m.c(nVar, s2.n.class.getSimpleName()), 2418).h(new Executor() { // from class: q2.m
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }, new z2.c() { // from class: q2.j
            @Override // z2.c
            public final Object a(z2.l lVar) {
                a2.a aVar = q.f13528k;
                return null;
            }
        });
    }

    @Override // s2.h
    public final z2.l<Location> g(int i10, final z2.a aVar) {
        g.a aVar2 = new g.a();
        aVar2.b(i10);
        final s2.g a10 = aVar2.a();
        if (aVar != null) {
            b2.p.b(!aVar.a(), "cancellationToken may not be already canceled");
        }
        z2.l<Location> k10 = k(com.google.android.gms.common.api.internal.v.a().b(new com.google.android.gms.common.api.internal.r() { // from class: q2.k
            @Override // com.google.android.gms.common.api.internal.r
            public final void c(Object obj, Object obj2) {
                a2.a aVar3 = q.f13528k;
                ((n0) obj).t0(s2.g.this, aVar, (z2.m) obj2);
            }
        }).e(2415).a());
        if (aVar == null) {
            return k10;
        }
        final z2.m mVar = new z2.m(aVar);
        k10.i(new z2.c() { // from class: q2.l
            @Override // z2.c
            public final Object a(z2.l lVar) {
                z2.m mVar2 = z2.m.this;
                a2.a aVar3 = q.f13528k;
                if (lVar.p()) {
                    mVar2.e((Location) lVar.l());
                    return null;
                }
                Exception k11 = lVar.k();
                k11.getClass();
                mVar2.d(k11);
                return null;
            }
        });
        return mVar.a();
    }

    @Override // s2.h
    public final z2.l<Void> h(LocationRequest locationRequest, s2.n nVar, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            b2.p.l(looper, "invalid null looper");
        }
        return x(locationRequest, com.google.android.gms.common.api.internal.m.a(nVar, looper, s2.n.class.getSimpleName()));
    }
}
