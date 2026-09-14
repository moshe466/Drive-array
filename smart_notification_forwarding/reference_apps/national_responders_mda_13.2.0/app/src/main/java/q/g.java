package q;

import q.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f13389m;

    public g(p pVar) {
        super(pVar);
        this.f13381e = pVar instanceof l ? f.a.HORIZONTAL_DIMENSION : f.a.VERTICAL_DIMENSION;
    }

    @Override // q.f
    public void d(int i10) {
        if (this.f13386j) {
            return;
        }
        this.f13386j = true;
        this.f13383g = i10;
        for (d dVar : this.f13387k) {
            dVar.a(dVar);
        }
    }
}
