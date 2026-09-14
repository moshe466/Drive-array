package f1;

import h1.EnumC0446a;
import java.util.Iterator;
import java.util.List;

/* renamed from: f1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0401g extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4575a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0401g(List list) {
        this.f4575a = list;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f4575a.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
