package f1;

import h1.EnumC0446a;
import java.util.List;
import s2.C0679d;

/* loaded from: classes.dex */
public final class S extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4557a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public S(List value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4557a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (C0679d c0679d : this.f4557a) {
            sb.append((String) c0679d.f6332a);
            sb.append((String) c0679d.f6333b);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
