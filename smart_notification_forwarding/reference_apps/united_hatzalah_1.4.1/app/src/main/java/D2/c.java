package D2;

import M2.d;
import P2.s0;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f114a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f115b;

    public /* synthetic */ c(Object obj, int i) {
        this.f114a = i;
        this.f115b = obj;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Iterator, w2.d, java.lang.Object, M2.e] */
    @Override // M2.d
    public final Iterator iterator() {
        switch (this.f114a) {
            case 0:
                return new b(this);
            case 1:
                s0 s0Var = (s0) this.f115b;
                ?? obj = new Object();
                obj.f1415c = m3.b.k(s0Var, obj, obj);
                return obj;
            case 2:
                return (Iterator) this.f115b;
            default:
                return new N2.d((String) this.f115b);
        }
    }
}
