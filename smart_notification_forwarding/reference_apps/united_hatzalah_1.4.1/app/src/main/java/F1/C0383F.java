package f1;

import h1.EnumC0446a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t2.AbstractC0707i;
import t2.AbstractC0709k;

/* renamed from: f1.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0383F extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4543a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0383F(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4543a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        List<g1.h> list = this.f4543a;
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(list, 10));
        for (g1.h hVar : list) {
            arrayList.add(hVar.f4693a + hVar.f4694b);
        }
        Iterator it = AbstractC0707i.l0(new M0.a(4), arrayList).iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
