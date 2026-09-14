package q;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    /* renamed from: f, reason: collision with root package name */
    static int f13401f;

    /* renamed from: b, reason: collision with root package name */
    int f13403b;

    /* renamed from: c, reason: collision with root package name */
    int f13404c;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<p.e> f13402a = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    ArrayList<a> f13405d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f13406e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        public a(o oVar, p.e eVar, m.d dVar, int i10) {
            new WeakReference(eVar);
            dVar.x(eVar.L);
            dVar.x(eVar.M);
            dVar.x(eVar.N);
            dVar.x(eVar.O);
            dVar.x(eVar.P);
        }
    }

    public o(int i10) {
        this.f13403b = -1;
        this.f13404c = 0;
        int i11 = f13401f;
        f13401f = i11 + 1;
        this.f13403b = i11;
        this.f13404c = i10;
    }

    private String e() {
        int i10 = this.f13404c;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    private int j(m.d dVar, ArrayList<p.e> arrayList, int i10) {
        int x10;
        p.d dVar2;
        p.f fVar = (p.f) arrayList.get(0).I();
        dVar.D();
        fVar.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).g(dVar, false);
        }
        if (i10 == 0 && fVar.F0 > 0) {
            p.b.b(fVar, dVar, arrayList, 0);
        }
        if (i10 == 1 && fVar.G0 > 0) {
            p.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f13405d = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f13405d.add(new a(this, arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            x10 = dVar.x(fVar.L);
            dVar2 = fVar.N;
        } else {
            x10 = dVar.x(fVar.M);
            dVar2 = fVar.O;
        }
        int x11 = dVar.x(dVar2);
        dVar.D();
        return x11 - x10;
    }

    public boolean a(p.e eVar) {
        if (this.f13402a.contains(eVar)) {
            return false;
        }
        this.f13402a.add(eVar);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int size = this.f13402a.size();
        if (this.f13406e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                o oVar = arrayList.get(i10);
                if (this.f13406e == oVar.f13403b) {
                    g(this.f13404c, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f13403b;
    }

    public int d() {
        return this.f13404c;
    }

    public int f(m.d dVar, int i10) {
        if (this.f13402a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f13402a, i10);
    }

    public void g(int i10, o oVar) {
        Iterator<p.e> it = this.f13402a.iterator();
        while (it.hasNext()) {
            p.e next = it.next();
            oVar.a(next);
            int c10 = oVar.c();
            if (i10 == 0) {
                next.f12980t0 = c10;
            } else {
                next.f12982u0 = c10;
            }
        }
        this.f13406e = oVar.f13403b;
    }

    public void h(boolean z10) {
    }

    public void i(int i10) {
        this.f13404c = i10;
    }

    public String toString() {
        String str = e() + " [" + this.f13403b + "] <";
        Iterator<p.e> it = this.f13402a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().r();
        }
        return str + " >";
    }
}
