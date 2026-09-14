package q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    p f13380d;

    /* renamed from: f, reason: collision with root package name */
    int f13382f;

    /* renamed from: g, reason: collision with root package name */
    public int f13383g;

    /* renamed from: a, reason: collision with root package name */
    public d f13377a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13378b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13379c = false;

    /* renamed from: e, reason: collision with root package name */
    a f13381e = a.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    int f13384h = 1;

    /* renamed from: i, reason: collision with root package name */
    g f13385i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13386j = false;

    /* renamed from: k, reason: collision with root package name */
    List<d> f13387k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    List<f> f13388l = new ArrayList();

    /* loaded from: classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f13380d = pVar;
    }

    @Override // q.d
    public void a(d dVar) {
        Iterator<f> it = this.f13388l.iterator();
        while (it.hasNext()) {
            if (!it.next().f13386j) {
                return;
            }
        }
        this.f13379c = true;
        d dVar2 = this.f13377a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f13378b) {
            this.f13380d.a(this);
            return;
        }
        f fVar = null;
        int i10 = 0;
        for (f fVar2 : this.f13388l) {
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f13386j) {
            g gVar = this.f13385i;
            if (gVar != null) {
                if (!gVar.f13386j) {
                    return;
                } else {
                    this.f13382f = this.f13384h * gVar.f13383g;
                }
            }
            d(fVar.f13383g + this.f13382f);
        }
        d dVar3 = this.f13377a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f13387k.add(dVar);
        if (this.f13386j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f13388l.clear();
        this.f13387k.clear();
        this.f13386j = false;
        this.f13383g = 0;
        this.f13379c = false;
        this.f13378b = false;
    }

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

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13380d.f13408b.r());
        sb2.append(":");
        sb2.append(this.f13381e);
        sb2.append("(");
        sb2.append(this.f13386j ? Integer.valueOf(this.f13383g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f13388l.size());
        sb2.append(":d=");
        sb2.append(this.f13387k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
