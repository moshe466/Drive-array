package k1;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public class r implements q {

    /* renamed from: e, reason: collision with root package name */
    private static volatile s f11183e;

    /* renamed from: a, reason: collision with root package name */
    private final t1.a f11184a;

    /* renamed from: b, reason: collision with root package name */
    private final t1.a f11185b;

    /* renamed from: c, reason: collision with root package name */
    private final p1.e f11186c;

    /* renamed from: d, reason: collision with root package name */
    private final q1.h f11187d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(t1.a aVar, t1.a aVar2, p1.e eVar, q1.h hVar, q1.l lVar) {
        this.f11184a = aVar;
        this.f11185b = aVar2;
        this.f11186c = eVar;
        this.f11187d = hVar;
        lVar.a();
    }

    private h b(l lVar) {
        return h.a().i(this.f11184a.a()).k(this.f11185b.a()).j(lVar.g()).h(new g(lVar.b(), lVar.d())).g(lVar.c().a()).d();
    }

    public static r c() {
        s sVar = f11183e;
        if (sVar != null) {
            return sVar.d();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<i1.b> d(e eVar) {
        return eVar instanceof f ? Collections.unmodifiableSet(((f) eVar).a()) : Collections.singleton(i1.b.b("proto"));
    }

    public static void f(Context context) {
        if (f11183e == null) {
            synchronized (r.class) {
                if (f11183e == null) {
                    f11183e = d.f().a(context).c();
                }
            }
        }
    }

    @Override // k1.q
    public void a(l lVar, i1.h hVar) {
        this.f11186c.a(lVar.f().e(lVar.c().c()), b(lVar), hVar);
    }

    public q1.h e() {
        return this.f11187d;
    }

    public i1.g g(e eVar) {
        return new n(d(eVar), m.a().b(eVar.c()).c(eVar.b()).a(), this);
    }
}
