package f1;

import h1.EnumC0446a;
import java.util.List;

/* loaded from: classes.dex */
public final class T extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4558a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public T(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4558a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (g1.m mVar : this.f4558a) {
            sb.append(mVar.f4702a);
            sb.append(mVar.f4703b);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
