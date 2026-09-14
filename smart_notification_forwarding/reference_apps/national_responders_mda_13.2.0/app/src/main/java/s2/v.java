package s2;

import java.util.Comparator;

/* loaded from: classes.dex */
final class v implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        b2.p.k(cVar);
        b2.p.k(cVar2);
        int g10 = cVar.g();
        int g11 = cVar2.g();
        if (g10 != g11) {
            return g10 >= g11 ? 1 : -1;
        }
        int j10 = cVar.j();
        int j11 = cVar2.j();
        if (j10 == j11) {
            return 0;
        }
        return j10 < j11 ? -1 : 1;
    }
}
