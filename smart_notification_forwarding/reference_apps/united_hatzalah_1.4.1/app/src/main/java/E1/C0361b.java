package e1;

import F0.C0047j2;
import R.U;
import R1.n;
import d1.C0358a;
import kotlin.jvm.internal.k;
import s2.C0680e;

/* renamed from: e1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0361b extends k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f4450b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0361b(n nVar, int i) {
        super(0);
        this.f4449a = i;
        this.f4450b = nVar;
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [kotlin.jvm.internal.k, F2.a] */
    @Override // F2.a
    public final Object invoke() {
        switch (this.f4449a) {
            case 0:
                Object G3 = T.b.G(1000L, new U((C0358a) this.f4450b.f2003b, 4));
                if (G3 instanceof C0680e) {
                    G3 = "";
                }
                return new C0360a((String) G3);
            case 1:
                Object G4 = T.b.G(1000L, new U((C0047j2) this.f4450b.f2002a, 5));
                String str = "";
                if (G4 instanceof C0680e) {
                    G4 = "";
                }
                String str2 = (String) G4;
                if (str2 != null) {
                    str = str2;
                }
                return new C0362c(str);
            default:
                Object obj = this.f4450b.f2004c;
                Object G5 = T.b.G(3000L, new k(0));
                if (G5 instanceof C0680e) {
                    G5 = null;
                }
                String str3 = (String) G5;
                if (str3 == null) {
                    str3 = "";
                }
                return new C0363d(str3);
        }
    }
}
