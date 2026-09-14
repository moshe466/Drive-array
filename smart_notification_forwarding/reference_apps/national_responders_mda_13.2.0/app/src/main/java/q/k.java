package q;

import java.util.Iterator;
import q.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends p {
    public k(p.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f13414h.f13387k.add(fVar);
        fVar.f13388l.add(this.f13414h);
    }

    @Override // q.p, q.d
    public void a(d dVar) {
        p.a aVar = (p.a) this.f13408b;
        int s12 = aVar.s1();
        Iterator<f> it = this.f13414h.f13388l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = it.next().f13383g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (s12 == 0 || s12 == 2) {
            this.f13414h.d(i11 + aVar.t1());
        } else {
            this.f13414h.d(i10 + aVar.t1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void d() {
        p pVar;
        p.e eVar = this.f13408b;
        if (eVar instanceof p.a) {
            this.f13414h.f13378b = true;
            p.a aVar = (p.a) eVar;
            int s12 = aVar.s1();
            boolean r12 = aVar.r1();
            int i10 = 0;
            if (s12 == 0) {
                this.f13414h.f13381e = f.a.LEFT;
                while (i10 < aVar.f12999x0) {
                    p.e eVar2 = aVar.f12998w0[i10];
                    if (r12 || eVar2.T() != 8) {
                        f fVar = eVar2.f12947d.f13414h;
                        fVar.f13387k.add(this.f13414h);
                        this.f13414h.f13388l.add(fVar);
                    }
                    i10++;
                }
            } else {
                if (s12 != 1) {
                    if (s12 == 2) {
                        this.f13414h.f13381e = f.a.TOP;
                        while (i10 < aVar.f12999x0) {
                            p.e eVar3 = aVar.f12998w0[i10];
                            if (r12 || eVar3.T() != 8) {
                                f fVar2 = eVar3.f12949e.f13414h;
                                fVar2.f13387k.add(this.f13414h);
                                this.f13414h.f13388l.add(fVar2);
                            }
                            i10++;
                        }
                    } else {
                        if (s12 != 3) {
                            return;
                        }
                        this.f13414h.f13381e = f.a.BOTTOM;
                        while (i10 < aVar.f12999x0) {
                            p.e eVar4 = aVar.f12998w0[i10];
                            if (r12 || eVar4.T() != 8) {
                                f fVar3 = eVar4.f12949e.f13415i;
                                fVar3.f13387k.add(this.f13414h);
                                this.f13414h.f13388l.add(fVar3);
                            }
                            i10++;
                        }
                    }
                    q(this.f13408b.f12949e.f13414h);
                    pVar = this.f13408b.f12949e;
                    q(pVar.f13415i);
                }
                this.f13414h.f13381e = f.a.RIGHT;
                while (i10 < aVar.f12999x0) {
                    p.e eVar5 = aVar.f12998w0[i10];
                    if (r12 || eVar5.T() != 8) {
                        f fVar4 = eVar5.f12947d.f13415i;
                        fVar4.f13387k.add(this.f13414h);
                        this.f13414h.f13388l.add(fVar4);
                    }
                    i10++;
                }
            }
            q(this.f13408b.f12947d.f13414h);
            pVar = this.f13408b.f12947d;
            q(pVar.f13415i);
        }
    }

    @Override // q.p
    public void e() {
        p.e eVar = this.f13408b;
        if (eVar instanceof p.a) {
            int s12 = ((p.a) eVar).s1();
            if (s12 == 0 || s12 == 1) {
                this.f13408b.j1(this.f13414h.f13383g);
            } else {
                this.f13408b.k1(this.f13414h.f13383g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void f() {
        this.f13409c = null;
        this.f13414h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public boolean m() {
        return false;
    }
}
