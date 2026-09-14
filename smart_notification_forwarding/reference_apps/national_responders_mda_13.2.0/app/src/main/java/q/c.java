package q;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class c extends p {

    /* renamed from: k, reason: collision with root package name */
    ArrayList<p> f13367k;

    /* renamed from: l, reason: collision with root package name */
    private int f13368l;

    public c(p.e eVar, int i10) {
        super(eVar);
        this.f13367k = new ArrayList<>();
        this.f13412f = i10;
        q();
    }

    private void q() {
        p.e eVar;
        p.e eVar2 = this.f13408b;
        do {
            eVar = eVar2;
            eVar2 = eVar2.J(this.f13412f);
        } while (eVar2 != null);
        this.f13408b = eVar;
        this.f13367k.add(eVar.L(this.f13412f));
        p.e H = eVar.H(this.f13412f);
        while (H != null) {
            this.f13367k.add(H.L(this.f13412f));
            H = H.H(this.f13412f);
        }
        Iterator<p> it = this.f13367k.iterator();
        while (it.hasNext()) {
            p next = it.next();
            int i10 = this.f13412f;
            if (i10 == 0) {
                next.f13408b.f12943b = this;
            } else if (i10 == 1) {
                next.f13408b.f12945c = this;
            }
        }
        if ((this.f13412f == 0 && ((p.f) this.f13408b.I()).L1()) && this.f13367k.size() > 1) {
            ArrayList<p> arrayList = this.f13367k;
            this.f13408b = arrayList.get(arrayList.size() - 1).f13408b;
        }
        this.f13368l = this.f13412f == 0 ? this.f13408b.x() : this.f13408b.Q();
    }

    private p.e r() {
        for (int i10 = 0; i10 < this.f13367k.size(); i10++) {
            p pVar = this.f13367k.get(i10);
            if (pVar.f13408b.T() != 8) {
                return pVar.f13408b;
            }
        }
        return null;
    }

    private p.e s() {
        for (int size = this.f13367k.size() - 1; size >= 0; size--) {
            p pVar = this.f13367k.get(size);
            if (pVar.f13408b.T() != 8) {
                return pVar.f13408b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:292:0x03d3, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9  */
    @Override // q.p, q.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(q.d r27) {
        /*
            Method dump skipped, instructions count: 1010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.c.a(q.d):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
    
        b(r5.f13415i, r1, -r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        if (r1 != null) goto L30;
     */
    @Override // q.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r5 = this;
            java.util.ArrayList<q.p> r0 = r5.f13367k
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L16
            java.lang.Object r1 = r0.next()
            q.p r1 = (q.p) r1
            r1.d()
            goto L6
        L16:
            java.util.ArrayList<q.p> r0 = r5.f13367k
            int r0 = r0.size()
            r1 = 1
            if (r0 >= r1) goto L20
            return
        L20:
            java.util.ArrayList<q.p> r2 = r5.f13367k
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            q.p r2 = (q.p) r2
            p.e r2 = r2.f13408b
            java.util.ArrayList<q.p> r4 = r5.f13367k
            int r0 = r0 - r1
            java.lang.Object r0 = r4.get(r0)
            q.p r0 = (q.p) r0
            p.e r0 = r0.f13408b
            int r4 = r5.f13412f
            if (r4 != 0) goto L70
            p.d r1 = r2.L
            p.d r0 = r0.N
            q.f r2 = r5.i(r1, r3)
            int r1 = r1.e()
            p.e r4 = r5.r()
            if (r4 == 0) goto L52
            p.d r1 = r4.L
            int r1 = r1.e()
        L52:
            if (r2 == 0) goto L59
            q.f r4 = r5.f13414h
            r5.b(r4, r2, r1)
        L59:
            q.f r1 = r5.i(r0, r3)
            int r0 = r0.e()
            p.e r2 = r5.s()
            if (r2 == 0) goto L6d
            p.d r0 = r2.N
            int r0 = r0.e()
        L6d:
            if (r1 == 0) goto Lab
            goto La5
        L70:
            p.d r2 = r2.M
            p.d r0 = r0.O
            q.f r3 = r5.i(r2, r1)
            int r2 = r2.e()
            p.e r4 = r5.r()
            if (r4 == 0) goto L88
            p.d r2 = r4.M
            int r2 = r2.e()
        L88:
            if (r3 == 0) goto L8f
            q.f r4 = r5.f13414h
            r5.b(r4, r3, r2)
        L8f:
            q.f r1 = r5.i(r0, r1)
            int r0 = r0.e()
            p.e r2 = r5.s()
            if (r2 == 0) goto La3
            p.d r0 = r2.O
            int r0 = r0.e()
        La3:
            if (r1 == 0) goto Lab
        La5:
            q.f r2 = r5.f13415i
            int r0 = -r0
            r5.b(r2, r1, r0)
        Lab:
            q.f r0 = r5.f13414h
            r0.f13377a = r5
            q.f r0 = r5.f13415i
            r0.f13377a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q.c.d():void");
    }

    @Override // q.p
    public void e() {
        for (int i10 = 0; i10 < this.f13367k.size(); i10++) {
            this.f13367k.get(i10).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public void f() {
        this.f13409c = null;
        Iterator<p> it = this.f13367k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // q.p
    public long j() {
        int size = this.f13367k.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = j10 + r4.f13414h.f13382f + this.f13367k.get(i10).j() + r4.f13415i.f13382f;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // q.p
    public boolean m() {
        int size = this.f13367k.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f13367k.get(i10).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f13412f == 0 ? "horizontal : " : "vertical : ");
        Iterator<p> it = this.f13367k.iterator();
        while (it.hasNext()) {
            p next = it.next();
            sb2.append("<");
            sb2.append(next);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
