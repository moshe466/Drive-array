package d1;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private d f8638a;

    /* renamed from: b, reason: collision with root package name */
    private c f8639b;

    /* renamed from: c, reason: collision with root package name */
    private f f8640c;

    /* renamed from: d, reason: collision with root package name */
    private h f8641d;

    /* renamed from: e, reason: collision with root package name */
    private e f8642e;

    /* renamed from: f, reason: collision with root package name */
    private g f8643f;

    /* renamed from: g, reason: collision with root package name */
    private b f8644g;

    /* renamed from: h, reason: collision with root package name */
    private b f8645h;

    /* renamed from: i, reason: collision with root package name */
    private i f8646i;

    /* renamed from: j, reason: collision with root package name */
    private c1.b f8647j;

    public void a(e1.a aVar) {
        c1.b bVar = this.f8647j;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public void b(int i10) {
        d dVar = this.f8638a;
        if (dVar != null) {
            dVar.a(i10);
        }
    }

    public void c(int i10, int i11) {
        e eVar = this.f8642e;
        if (eVar != null) {
            eVar.a(i10, i11);
        }
    }

    public boolean d(int i10, Throwable th) {
        f fVar = this.f8640c;
        if (fVar == null) {
            return false;
        }
        fVar.a(i10, th);
        return true;
    }

    public void e(int i10, float f10) {
        g gVar = this.f8643f;
        if (gVar != null) {
            gVar.a(i10, f10);
        }
    }

    public void f(int i10) {
        h hVar = this.f8641d;
        if (hVar != null) {
            hVar.a(i10);
        }
    }

    public boolean g(MotionEvent motionEvent) {
        i iVar = this.f8646i;
        return iVar != null && iVar.a(motionEvent);
    }

    public b h() {
        return this.f8644g;
    }

    public b i() {
        return this.f8645h;
    }

    public c j() {
        return this.f8639b;
    }

    public void k(c1.b bVar) {
        this.f8647j = bVar;
    }

    public void l(b bVar) {
        this.f8644g = bVar;
    }

    public void m(b bVar) {
        this.f8645h = bVar;
    }

    public void n(c cVar) {
        this.f8639b = cVar;
    }

    public void o(d dVar) {
        this.f8638a = dVar;
    }

    public void p(e eVar) {
        this.f8642e = eVar;
    }

    public void q(f fVar) {
        this.f8640c = fVar;
    }

    public void r(g gVar) {
        this.f8643f = gVar;
    }

    public void s(h hVar) {
        this.f8641d = hVar;
    }

    public void t(i iVar) {
        this.f8646i = iVar;
    }
}
