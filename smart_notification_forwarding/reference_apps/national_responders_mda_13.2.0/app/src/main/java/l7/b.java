package l7;

import java.util.Date;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private a[] f11802a;

    public b(a... aVarArr) {
        this.f11802a = aVarArr;
    }

    @Override // l7.a
    public void a(k7.b bVar, int i10, String str, Date date, String str2) {
        a[] aVarArr = this.f11802a;
        if (aVarArr == null) {
            return;
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar, i10, str, date, str2);
        }
    }
}
