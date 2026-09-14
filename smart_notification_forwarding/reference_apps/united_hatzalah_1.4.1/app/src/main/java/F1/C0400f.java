package f1;

import h1.EnumC0446a;
import java.util.Iterator;
import java.util.List;
import t2.AbstractC0707i;

/* renamed from: f1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0400f extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4574a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0400f(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4574a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        Iterator it = AbstractC0707i.l0(new M0.a(3), this.f4574a).iterator();
        while (it.hasNext()) {
            sb.append(((g1.k) it.next()).f4699a);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
