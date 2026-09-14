package q;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends p {
    public j(p.e eVar) {
        super(eVar);
        eVar.f12947d.f();
        eVar.f12949e.f();
        this.f13412f = ((p.g) eVar).p1();
    }

    private void q(f fVar) {
        this.f13414h.f13387k.add(fVar);
        fVar.f13388l.add(this.f13414h);
    }

    @Override // q.p, q.d
    public void a(d dVar) {
        f fVar = this.f13414h;
        if (fVar.f13379c && !fVar.f13386j) {
            this.f13414h.d((int) ((fVar.f13388l.get(0).f13383g * ((p.g) this.f13408b).s1()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void d() {
        f fVar;
        p pVar;
        f fVar2;
        p.g gVar = (p.g) this.f13408b;
        int q12 = gVar.q1();
        int r12 = gVar.r1();
        gVar.s1();
        if (gVar.p1() == 1) {
            f fVar3 = this.f13414h;
            if (q12 != -1) {
                fVar3.f13388l.add(this.f13408b.X.f12947d.f13414h);
                this.f13408b.X.f12947d.f13414h.f13387k.add(this.f13414h);
                fVar2 = this.f13414h;
            } else if (r12 != -1) {
                fVar3.f13388l.add(this.f13408b.X.f12947d.f13415i);
                this.f13408b.X.f12947d.f13415i.f13387k.add(this.f13414h);
                fVar2 = this.f13414h;
                q12 = -r12;
            } else {
                fVar3.f13378b = true;
                fVar3.f13388l.add(this.f13408b.X.f12947d.f13415i);
                this.f13408b.X.f12947d.f13415i.f13387k.add(this.f13414h);
                q(this.f13408b.f12947d.f13414h);
                pVar = this.f13408b.f12947d;
            }
            fVar2.f13382f = q12;
            q(this.f13408b.f12947d.f13414h);
            pVar = this.f13408b.f12947d;
        } else {
            f fVar4 = this.f13414h;
            if (q12 != -1) {
                fVar4.f13388l.add(this.f13408b.X.f12949e.f13414h);
                this.f13408b.X.f12949e.f13414h.f13387k.add(this.f13414h);
                fVar = this.f13414h;
            } else if (r12 != -1) {
                fVar4.f13388l.add(this.f13408b.X.f12949e.f13415i);
                this.f13408b.X.f12949e.f13415i.f13387k.add(this.f13414h);
                fVar = this.f13414h;
                q12 = -r12;
            } else {
                fVar4.f13378b = true;
                fVar4.f13388l.add(this.f13408b.X.f12949e.f13415i);
                this.f13408b.X.f12949e.f13415i.f13387k.add(this.f13414h);
                q(this.f13408b.f12949e.f13414h);
                pVar = this.f13408b.f12949e;
            }
            fVar.f13382f = q12;
            q(this.f13408b.f12949e.f13414h);
            pVar = this.f13408b.f12949e;
        }
        q(pVar.f13415i);
    }

    @Override // q.p
    public void e() {
        if (((p.g) this.f13408b).p1() == 1) {
            this.f13408b.j1(this.f13414h.f13383g);
        } else {
            this.f13408b.k1(this.f13414h.f13383g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void f() {
        this.f13414h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public boolean m() {
        return false;
    }
}
