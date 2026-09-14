package f1;

import h1.EnumC0446a;
import java.util.List;

/* renamed from: f1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0405k extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4579a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0405k(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4579a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (g1.b bVar : this.f4579a) {
            sb.append(bVar.f4665a);
            sb.append(bVar.f4666b);
            sb.append(bVar.f4667c);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
