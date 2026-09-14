package na;

import java.util.Comparator;
import n9.p0;
import n9.x;
import n9.z0;

/* loaded from: classes.dex */
public class g implements Comparator<n9.m> {

    /* renamed from: a, reason: collision with root package name */
    public static final g f12339a = new g();

    private g() {
    }

    private static Integer b(n9.m mVar, n9.m mVar2) {
        int c10 = c(mVar2) - c(mVar);
        if (c10 != 0) {
            return Integer.valueOf(c10);
        }
        if (d.B(mVar) && d.B(mVar2)) {
            return 0;
        }
        int compareTo = mVar.c().compareTo(mVar2.c());
        if (compareTo != 0) {
            return Integer.valueOf(compareTo);
        }
        return null;
    }

    private static int c(n9.m mVar) {
        if (d.B(mVar)) {
            return 8;
        }
        if (mVar instanceof n9.l) {
            return 7;
        }
        if (mVar instanceof p0) {
            return ((p0) mVar).U() == null ? 6 : 5;
        }
        if (mVar instanceof x) {
            return ((x) mVar).U() == null ? 4 : 3;
        }
        if (mVar instanceof n9.e) {
            return 2;
        }
        return mVar instanceof z0 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(n9.m mVar, n9.m mVar2) {
        Integer b10 = b(mVar, mVar2);
        if (b10 != null) {
            return b10.intValue();
        }
        return 0;
    }
}
