package E1;

import F0.C0021d0;
import F0.C0047j2;
import F0.C0110z2;
import F0.G1;

/* loaded from: classes.dex */
public final class f implements F1.c {

    /* renamed from: a, reason: collision with root package name */
    public final F1.c f135a;

    public f(F1.c cVar) {
        this.f135a = cVar;
    }

    @Override // F1.c
    public Object zza() {
        d dVar = (d) this.f135a.zza();
        if (dVar != null) {
            return dVar;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }

    public /* synthetic */ f(e eVar) {
        int i = 2;
        C0047j2 c0047j2 = new C0047j2(eVar, i);
        this.f135a = F1.b.a(new f(F1.b.a(new C0110z2(F1.b.a(new C0021d0(c0047j2, F1.b.a(new G1(c0047j2, i)))), F1.b.a(new C0047j2(c0047j2, 1)), c0047j2))));
    }
}
