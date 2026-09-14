package p;

import java.util.HashSet;
import q.b;

/* loaded from: classes.dex */
public class k extends i {

    /* renamed from: y0, reason: collision with root package name */
    private boolean f13001y0 = false;

    public k() {
        new b.a();
    }

    @Override // p.i, p.h
    public void a(f fVar) {
        q1();
    }

    public void q1() {
        for (int i10 = 0; i10 < this.f12999x0; i10++) {
            e eVar = this.f12998w0[i10];
            if (eVar != null) {
                eVar.R0(true);
            }
        }
    }

    public boolean r1(HashSet<e> hashSet) {
        for (int i10 = 0; i10 < this.f12999x0; i10++) {
            if (hashSet.contains(this.f12998w0[i10])) {
                return true;
            }
        }
        return false;
    }

    public boolean s1() {
        return this.f13001y0;
    }
}
