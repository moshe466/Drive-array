package M2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import t2.C0716r;

/* loaded from: classes.dex */
public abstract class f extends g {
    public static List B(d dVar) {
        j.e(dVar, "<this>");
        Iterator it = dVar.iterator();
        if (!it.hasNext()) {
            return C0716r.f6476a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return T.b.B(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
