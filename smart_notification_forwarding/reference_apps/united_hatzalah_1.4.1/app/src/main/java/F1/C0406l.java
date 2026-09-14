package f1;

import h1.EnumC0446a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: f1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0406l extends AbstractC0416w {

    /* renamed from: a, reason: collision with root package name */
    public final List f4580a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
    }

    public C0406l(List list) {
        this.f4580a = list;
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (g1.i iVar : this.f4580a) {
            sb.append(iVar.f4695a);
            ArrayList arrayList = iVar.f4696b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                sb.append((String) obj);
            }
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.j.d(sb2, "toString(...)");
        return sb2;
    }
}
