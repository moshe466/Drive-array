package p1;

import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k1.m;
import k1.r;
import q1.n;

/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f13022f = Logger.getLogger(r.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final n f13023a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f13024b;

    /* renamed from: c, reason: collision with root package name */
    private final l1.b f13025c;

    /* renamed from: d, reason: collision with root package name */
    private final r1.c f13026d;

    /* renamed from: e, reason: collision with root package name */
    private final s1.b f13027e;

    public c(Executor executor, l1.b bVar, n nVar, r1.c cVar, s1.b bVar2) {
        this.f13024b = executor;
        this.f13025c = bVar;
        this.f13023a = nVar;
        this.f13026d = cVar;
        this.f13027e = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(c cVar, m mVar, k1.h hVar) {
        cVar.f13026d.u(mVar, hVar);
        cVar.f13023a.a(mVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(c cVar, m mVar, i1.h hVar, k1.h hVar2) {
        try {
            l1.g a10 = cVar.f13025c.a(mVar.b());
            if (a10 != null) {
                cVar.f13027e.c(b.a(cVar, mVar, a10.a(hVar2)));
                hVar.a(null);
            } else {
                String format = String.format("Transport backend '%s' is not registered", mVar.b());
                f13022f.warning(format);
                hVar.a(new IllegalArgumentException(format));
            }
        } catch (Exception e10) {
            f13022f.warning("Error scheduling event " + e10.getMessage());
            hVar.a(e10);
        }
    }

    @Override // p1.e
    public void a(m mVar, k1.h hVar, i1.h hVar2) {
        this.f13024b.execute(a.a(this, mVar, hVar2, hVar));
    }
}
