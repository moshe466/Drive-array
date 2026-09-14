package p1;

import k1.m;

/* loaded from: classes.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final c f13015f;

    /* renamed from: g, reason: collision with root package name */
    private final m f13016g;

    /* renamed from: h, reason: collision with root package name */
    private final i1.h f13017h;

    /* renamed from: i, reason: collision with root package name */
    private final k1.h f13018i;

    private a(c cVar, m mVar, i1.h hVar, k1.h hVar2) {
        this.f13015f = cVar;
        this.f13016g = mVar;
        this.f13017h = hVar;
        this.f13018i = hVar2;
    }

    public static Runnable a(c cVar, m mVar, i1.h hVar, k1.h hVar2) {
        return new a(cVar, mVar, hVar, hVar2);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.f13015f, this.f13016g, this.f13017h, this.f13018i);
    }
}
