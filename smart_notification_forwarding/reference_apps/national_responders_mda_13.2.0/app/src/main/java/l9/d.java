package l9;

import ab.n;
import java.util.List;
import m8.p;
import m8.q;
import n9.x;
import y8.k;

/* loaded from: classes.dex */
public final class d extends ua.e {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11842a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.Function.ordinal()] = 1;
            iArr[c.SuspendFunction.ordinal()] = 2;
            f11842a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n nVar, b bVar) {
        super(nVar, bVar);
        k.e(nVar, "storageManager");
        k.e(bVar, "containingClass");
    }

    @Override // ua.e
    protected List<x> i() {
        e a10;
        List<x> b10;
        List<x> d10;
        int i10 = a.f11842a[((b) l()).f1().ordinal()];
        if (i10 == 1) {
            a10 = e.I.a((b) l(), false);
        } else {
            if (i10 != 2) {
                d10 = q.d();
                return d10;
            }
            a10 = e.I.a((b) l(), true);
        }
        b10 = p.b(a10);
        return b10;
    }
}
