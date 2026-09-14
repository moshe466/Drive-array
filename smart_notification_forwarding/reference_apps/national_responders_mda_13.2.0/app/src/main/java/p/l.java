package p;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class l extends e {

    /* renamed from: w0, reason: collision with root package name */
    public ArrayList<e> f13002w0 = new ArrayList<>();

    public void c(e eVar) {
        this.f13002w0.add(eVar);
        if (eVar.I() != null) {
            ((l) eVar.I()).q1(eVar);
        }
        eVar.Z0(this);
    }

    public ArrayList<e> o1() {
        return this.f13002w0;
    }

    public void p1() {
        ArrayList<e> arrayList = this.f13002w0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.f13002w0.get(i10);
            if (eVar instanceof l) {
                ((l) eVar).p1();
            }
        }
    }

    public void q1(e eVar) {
        this.f13002w0.remove(eVar);
        eVar.r0();
    }

    @Override // p.e
    public void r0() {
        this.f13002w0.clear();
        super.r0();
    }

    public void r1() {
        this.f13002w0.clear();
    }

    @Override // p.e
    public void t0(m.c cVar) {
        super.t0(cVar);
        int size = this.f13002w0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f13002w0.get(i10).t0(cVar);
        }
    }
}
