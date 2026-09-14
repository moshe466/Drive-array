package pa;

import bb.b0;
import bb.i0;
import n9.d0;

/* loaded from: classes.dex */
public final class j extends g<l8.n<? extends la.a, ? extends la.e>> {

    /* renamed from: b, reason: collision with root package name */
    private final la.a f13332b;

    /* renamed from: c, reason: collision with root package name */
    private final la.e f13333c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(la.a aVar, la.e eVar) {
        super(l8.t.a(aVar, eVar));
        y8.k.e(aVar, "enumClassId");
        y8.k.e(eVar, "enumEntryName");
        this.f13332b = aVar;
        this.f13333c = eVar;
    }

    @Override // pa.g
    public b0 a(d0 d0Var) {
        y8.k.e(d0Var, "module");
        n9.e a10 = n9.w.a(d0Var, this.f13332b);
        i0 i0Var = null;
        if (a10 != null) {
            if (!na.d.A(a10)) {
                a10 = null;
            }
            if (a10 != null) {
                i0Var = a10.s();
            }
        }
        if (i0Var != null) {
            return i0Var;
        }
        i0 j10 = bb.t.j("Containing class for error-class based enum entry " + this.f13332b + '.' + this.f13333c);
        y8.k.d(j10, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return j10;
    }

    public final la.e c() {
        return this.f13333c;
    }

    @Override // pa.g
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13332b.j());
        sb2.append('.');
        sb2.append(this.f13333c);
        return sb2.toString();
    }
}
