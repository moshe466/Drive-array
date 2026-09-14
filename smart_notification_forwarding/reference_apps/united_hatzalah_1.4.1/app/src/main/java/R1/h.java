package R1;

import W1.X;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f1992b = new h();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f1993a = new AtomicReference(new r(new K1.m(4)));

    /* JADX WARN: Type inference failed for: r0v2, types: [K1.b, java.lang.Object] */
    public final K1.b a(n nVar) {
        AtomicReference atomicReference = this.f1993a;
        r rVar = (r) atomicReference.get();
        rVar.getClass();
        Y1.a aVar = (Y1.a) nVar.f2003b;
        if (!rVar.f2014b.containsKey(new p(n.class, aVar))) {
            try {
                ?? obj = new Object();
                ((X) nVar.f2005d).ordinal();
                return obj;
            } catch (GeneralSecurityException e4) {
                throw new RuntimeException("Creating a LegacyProtoKey failed", e4);
            }
        }
        r rVar2 = (r) atomicReference.get();
        rVar2.getClass();
        p pVar = new p(n.class, aVar);
        HashMap hashMap = rVar2.f2014b;
        if (hashMap.containsKey(pVar)) {
            return ((a) hashMap.get(pVar)).f1980b.a(nVar);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + pVar + " available");
    }

    public final synchronized void b(a aVar) {
        K1.m mVar = new K1.m((r) this.f1993a.get());
        mVar.l(aVar);
        this.f1993a.set(new r(mVar));
    }

    public final synchronized void c(b bVar) {
        K1.m mVar = new K1.m((r) this.f1993a.get());
        mVar.m(bVar);
        this.f1993a.set(new r(mVar));
    }

    public final synchronized void d(i iVar) {
        K1.m mVar = new K1.m((r) this.f1993a.get());
        mVar.n(iVar);
        this.f1993a.set(new r(mVar));
    }

    public final synchronized void e(j jVar) {
        K1.m mVar = new K1.m((r) this.f1993a.get());
        mVar.o(jVar);
        this.f1993a.set(new r(mVar));
    }
}
