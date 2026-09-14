package R;

import P2.C0163m;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import s2.C0683h;
import s2.C0684i;
import t2.AbstractC0707i;
import t2.C0716r;

/* loaded from: classes.dex */
public final class L extends kotlin.jvm.internal.k implements F2.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1787a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1788b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ L(Object obj, int i) {
        super(1);
        this.f1787a = i;
        this.f1788b = obj;
    }

    @Override // F2.l
    public final Object invoke(Object obj) {
        switch (this.f1787a) {
            case 0:
                Throwable th = (Throwable) obj;
                P p = (P) this.f1788b;
                if (th != null) {
                    p.f1810h.n(new b0(th));
                }
                if (p.f1811j.f6337b != C0683h.f6339a) {
                    ((Y) p.f1811j.a()).close();
                }
                return C0684i.f6340a;
            case 1:
                C0163m c0163m = (C0163m) this.f1788b;
                C0684i c0684i = C0684i.f6340a;
                c0163m.resumeWith(c0684i);
                return c0684i;
            case 2:
                ((Y2.h) this.f1788b).b();
                return C0684i.f6340a;
            case 3:
                Map.Entry entry = (Map.Entry) obj;
                kotlin.jvm.internal.j.e(entry, "entry");
                Collection collection = (Collection) this.f1788b;
                View view = (View) entry.getValue();
                WeakHashMap weakHashMap = J.S.f954a;
                return Boolean.valueOf(AbstractC0707i.b0(collection, J.J.e(view)));
            default:
                List it = (List) obj;
                kotlin.jvm.internal.j.e(it, "it");
                ArrayList arrayList = (ArrayList) this.f1788b;
                int intValue = ((Number) it.get(0)).intValue() + 1;
                K2.d dVar = new K2.d(intValue, ((Number) it.get(1)).intValue() - 1, 1);
                if (dVar.isEmpty()) {
                    return C0716r.f6476a;
                }
                return AbstractC0707i.q0(arrayList.subList(intValue, dVar.f1119b + 1));
        }
    }
}
