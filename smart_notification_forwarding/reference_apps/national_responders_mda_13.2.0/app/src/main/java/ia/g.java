package ia;

import ga.q;
import ga.t;
import java.util.ArrayList;
import java.util.List;
import m8.r;
import y8.k;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final List<q> f10827a;

    public g(t tVar) {
        int n10;
        k.e(tVar, "typeTable");
        List<q> B = tVar.B();
        if (tVar.C()) {
            int y10 = tVar.y();
            List<q> B2 = tVar.B();
            k.d(B2, "typeTable.typeList");
            n10 = r.n(B2, 10);
            ArrayList arrayList = new ArrayList(n10);
            int i10 = 0;
            for (Object obj : B2) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m8.q.m();
                }
                q qVar = (q) obj;
                if (i10 >= y10) {
                    qVar = qVar.d().R(true).c();
                }
                arrayList.add(qVar);
                i10 = i11;
            }
            B = arrayList;
        }
        k.d(B, "run {\n        val originalTypes = typeTable.typeList\n        if (typeTable.hasFirstNullable()) {\n            val firstNullable = typeTable.firstNullable\n            typeTable.typeList.mapIndexed { i, type ->\n                if (i >= firstNullable) {\n                    type.toBuilder().setNullable(true).build()\n                } else type\n            }\n        } else originalTypes\n    }");
        this.f10827a = B;
    }

    public final q a(int i10) {
        return this.f10827a.get(i10);
    }
}
