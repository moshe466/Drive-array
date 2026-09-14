package f1;

import h1.EnumC0446a;
import java.util.Map;

/* renamed from: f1.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0388K extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final Map f4548a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        androidx.lifecycle.N n5 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0388K(Map value) {
        kotlin.jvm.internal.j.e(value, "value");
        this.f4548a = value;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.f4548a.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append((String) entry.getValue());
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
