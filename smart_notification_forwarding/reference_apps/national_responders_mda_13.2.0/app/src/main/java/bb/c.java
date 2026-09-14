package bb;

import bb.f;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f4164a = new c();

    private c() {
    }

    private final boolean c(f fVar, db.i iVar, db.l lVar) {
        if (fVar.B0(iVar)) {
            return true;
        }
        if (fVar.m(iVar)) {
            return false;
        }
        if (fVar.C0() && fVar.H(iVar)) {
            return true;
        }
        return fVar.W(fVar.a(iVar), lVar);
    }

    private final boolean e(f fVar, db.i iVar, db.i iVar2) {
        if (e.f4187b) {
            if (!fVar.h0(iVar) && !fVar.u(fVar.a(iVar))) {
                fVar.v0(iVar);
            }
            if (!fVar.h0(iVar2)) {
                fVar.v0(iVar2);
            }
        }
        if (fVar.m(iVar2) || fVar.x0(iVar)) {
            return true;
        }
        if (((iVar instanceof db.c) && fVar.U((db.c) iVar)) || a(fVar, iVar, f.b.C0071b.f4199a)) {
            return true;
        }
        if (fVar.x0(iVar2) || a(fVar, iVar2, f.b.d.f4201a) || fVar.w0(iVar)) {
            return false;
        }
        return b(fVar, iVar, fVar.a(iVar2));
    }

    public final boolean a(f fVar, db.i iVar, f.b bVar) {
        String Q;
        y8.k.e(fVar, "<this>");
        y8.k.e(iVar, "type");
        y8.k.e(bVar, "supertypesPolicy");
        if (!((fVar.w0(iVar) && !fVar.m(iVar)) || fVar.x0(iVar))) {
            fVar.u0();
            ArrayDeque<db.i> r02 = fVar.r0();
            y8.k.b(r02);
            Set<db.i> s02 = fVar.s0();
            y8.k.b(s02);
            r02.push(iVar);
            while (!r02.isEmpty()) {
                if (s02.size() > 1000) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Too many supertypes for type: ");
                    sb2.append(iVar);
                    sb2.append(". Supertypes = ");
                    Q = m8.y.Q(s02, null, null, null, 0, null, null, 63, null);
                    sb2.append(Q);
                    throw new IllegalStateException(sb2.toString().toString());
                }
                db.i pop = r02.pop();
                y8.k.d(pop, "current");
                if (s02.add(pop)) {
                    f.b bVar2 = fVar.m(pop) ? f.b.c.f4200a : bVar;
                    if (!(!y8.k.a(bVar2, f.b.c.f4200a))) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        continue;
                    } else {
                        Iterator<db.h> it = fVar.T(fVar.a(pop)).iterator();
                        while (it.hasNext()) {
                            db.i a10 = bVar2.a(fVar, it.next());
                            if ((fVar.w0(a10) && !fVar.m(a10)) || fVar.x0(a10)) {
                                fVar.m0();
                            } else {
                                r02.add(a10);
                            }
                        }
                    }
                }
            }
            fVar.m0();
            return false;
        }
        return true;
    }

    public final boolean b(f fVar, db.i iVar, db.l lVar) {
        String Q;
        y8.k.e(fVar, "<this>");
        y8.k.e(iVar, "start");
        y8.k.e(lVar, "end");
        if (c(fVar, iVar, lVar)) {
            return true;
        }
        fVar.u0();
        ArrayDeque<db.i> r02 = fVar.r0();
        y8.k.b(r02);
        Set<db.i> s02 = fVar.s0();
        y8.k.b(s02);
        r02.push(iVar);
        while (!r02.isEmpty()) {
            if (s02.size() > 1000) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Too many supertypes for type: ");
                sb2.append(iVar);
                sb2.append(". Supertypes = ");
                Q = m8.y.Q(s02, null, null, null, 0, null, null, 63, null);
                sb2.append(Q);
                throw new IllegalStateException(sb2.toString().toString());
            }
            db.i pop = r02.pop();
            y8.k.d(pop, "current");
            if (s02.add(pop)) {
                f.b bVar = fVar.m(pop) ? f.b.c.f4200a : f.b.C0071b.f4199a;
                if (!(!y8.k.a(bVar, f.b.c.f4200a))) {
                    bVar = null;
                }
                if (bVar == null) {
                    continue;
                } else {
                    Iterator<db.h> it = fVar.T(fVar.a(pop)).iterator();
                    while (it.hasNext()) {
                        db.i a10 = bVar.a(fVar, it.next());
                        if (c(fVar, a10, lVar)) {
                            fVar.m0();
                            return true;
                        }
                        r02.add(a10);
                    }
                }
            }
        }
        fVar.m0();
        return false;
    }

    public final boolean d(f fVar, db.i iVar, db.i iVar2) {
        y8.k.e(fVar, "context");
        y8.k.e(iVar, "subType");
        y8.k.e(iVar2, "superType");
        return e(fVar, iVar, iVar2);
    }
}
