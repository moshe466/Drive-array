package V;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f2390c;

    public e(f fVar) {
        this.f2390c = fVar;
    }

    @Override // p3.h
    public final void x(Throwable th) {
        this.f2390c.f2391a.d(th);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [F0.c1, java.lang.Object] */
    @Override // p3.h
    public final void y(K1.m mVar) {
        f fVar = this.f2390c;
        fVar.f2393c = mVar;
        K1.m mVar2 = fVar.f2393c;
        new A.n(11);
        d dVar = fVar.f2391a.f2404h;
        ?? obj = new Object();
        obj.f476a = mVar2;
        obj.f477b = dVar;
        fVar.f2392b = obj;
        k kVar = fVar.f2391a;
        kVar.getClass();
        ArrayList arrayList = new ArrayList();
        kVar.f2397a.writeLock().lock();
        try {
            kVar.f2399c = 1;
            arrayList.addAll(kVar.f2398b);
            kVar.f2398b.clear();
            kVar.f2397a.writeLock().unlock();
            kVar.f2400d.post(new i(arrayList, kVar.f2399c, null));
        } catch (Throwable th) {
            kVar.f2397a.writeLock().unlock();
            throw th;
        }
    }
}
