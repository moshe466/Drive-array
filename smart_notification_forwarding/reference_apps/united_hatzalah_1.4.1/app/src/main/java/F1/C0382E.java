package f1;

import h1.EnumC0446a;
import java.util.List;

/* renamed from: f1.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0382E extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4542a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        androidx.lifecycle.N n5 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0382E(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4542a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (g1.h hVar : this.f4542a) {
            sb.append(hVar.f4693a);
            sb.append(hVar.f4694b);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
