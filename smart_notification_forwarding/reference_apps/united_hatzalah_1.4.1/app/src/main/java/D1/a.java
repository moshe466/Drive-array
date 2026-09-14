package D1;

import android.util.SparseArray;
import java.util.HashMap;
import q1.d;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f109a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f110b;

    static {
        HashMap hashMap = new HashMap();
        f110b = hashMap;
        hashMap.put(d.f6150a, 0);
        hashMap.put(d.f6151b, 1);
        hashMap.put(d.f6152c, 2);
        for (d dVar : hashMap.keySet()) {
            f109a.append(((Integer) f110b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f110b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i) {
        d dVar = (d) f109a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(e0.a.c(i, "Unknown Priority for value "));
    }
}
