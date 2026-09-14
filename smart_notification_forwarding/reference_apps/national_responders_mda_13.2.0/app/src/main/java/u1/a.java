package u1;

import android.util.SparseArray;
import i1.d;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static SparseArray<d> f14353a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private static EnumMap<d, Integer> f14354b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>((Class<d>) d.class);
        f14354b = enumMap;
        enumMap.put((EnumMap<d, Integer>) d.DEFAULT, (d) 0);
        f14354b.put((EnumMap<d, Integer>) d.VERY_LOW, (d) 1);
        f14354b.put((EnumMap<d, Integer>) d.HIGHEST, (d) 2);
        for (d dVar : f14354b.keySet()) {
            f14353a.append(f14354b.get(dVar).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = f14354b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i10) {
        d dVar = f14353a.get(i10);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
