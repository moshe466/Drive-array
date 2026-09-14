package t2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: t2.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0714p extends AbstractC0713o {
    public static void a0(ArrayList arrayList, Iterable elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements instanceof Collection) {
            arrayList.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
    }
}
