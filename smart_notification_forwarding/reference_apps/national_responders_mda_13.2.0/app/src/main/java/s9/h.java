package s9;

import java.util.ArrayList;
import java.util.List;
import s9.d;

/* loaded from: classes.dex */
public final class h extends d implements ca.e {

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f14156c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(la.e eVar, Object[] objArr) {
        super(eVar);
        y8.k.e(objArr, "values");
        this.f14156c = objArr;
    }

    @Override // ca.e
    public List<d> d() {
        Object[] objArr = this.f14156c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            d.a aVar = d.f14153b;
            y8.k.b(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
