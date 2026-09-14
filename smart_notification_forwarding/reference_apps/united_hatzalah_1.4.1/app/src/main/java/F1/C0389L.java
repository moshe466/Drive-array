package f1;

import h1.EnumC0446a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import s2.C0679d;
import t2.AbstractC0705g;
import t2.AbstractC0709k;

/* renamed from: f1.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0389L extends AbstractC0416w {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f4549b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f4550c;

    /* renamed from: a, reason: collision with root package name */
    public final g1.c f4551a;

    static {
        androidx.lifecycle.N n4 = c1.b.f3867a;
        EnumC0446a[] enumC0446aArr = EnumC0446a.f4934a;
        f4549b = m3.b.M("processor");
        f4550c = AbstractC0705g.T(new String[]{"bogomips", "cpu mhz"});
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, java.lang.Iterable] */
    public C0389L(g1.c value) {
        kotlin.jvm.internal.j.e(value, "value");
        ?? r02 = value.f4669a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : r02) {
            String lowerCase = ((String) ((C0679d) obj).f6332a).toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.j.d(lowerCase, "toLowerCase(...)");
            if (!f4549b.contains(lowerCase)) {
                arrayList.add(obj);
            }
        }
        ?? r9 = value.f4670b;
        ArrayList arrayList2 = new ArrayList(AbstractC0709k.Y(r9, 10));
        for (List list : r9) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list) {
                String lowerCase2 = ((String) ((C0679d) obj2).f6332a).toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.j.d(lowerCase2, "toLowerCase(...)");
                if (!f4550c.contains(lowerCase2)) {
                    arrayList3.add(obj2);
                }
            }
            arrayList2.add(arrayList3);
        }
        this.f4551a = new g1.c(arrayList, arrayList2);
    }

    @Override // f1.AbstractC0416w
    public final String a() {
        StringBuilder sb = new StringBuilder();
        g1.c cVar = this.f4551a;
        sb.append(cVar.f4669a);
        sb.append(cVar.f4670b);
        return sb.toString();
    }
}
