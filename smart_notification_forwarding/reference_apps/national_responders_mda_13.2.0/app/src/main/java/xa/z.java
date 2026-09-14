package xa;

import n9.b;

/* loaded from: classes.dex */
public final class z {

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15671a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15672b;

        static {
            int[] iArr = new int[ga.j.values().length];
            iArr[ga.j.DECLARATION.ordinal()] = 1;
            iArr[ga.j.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ga.j.DELEGATION.ordinal()] = 3;
            iArr[ga.j.SYNTHESIZED.ordinal()] = 4;
            f15671a = iArr;
            int[] iArr2 = new int[b.a.values().length];
            iArr2[b.a.DECLARATION.ordinal()] = 1;
            iArr2[b.a.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[b.a.DELEGATION.ordinal()] = 3;
            iArr2[b.a.SYNTHESIZED.ordinal()] = 4;
            int[] iArr3 = new int[ga.x.values().length];
            iArr3[ga.x.INTERNAL.ordinal()] = 1;
            iArr3[ga.x.PRIVATE.ordinal()] = 2;
            iArr3[ga.x.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ga.x.PROTECTED.ordinal()] = 4;
            iArr3[ga.x.PUBLIC.ordinal()] = 5;
            iArr3[ga.x.LOCAL.ordinal()] = 6;
            f15672b = iArr3;
        }
    }

    public static final n9.u a(y yVar, ga.x xVar) {
        n9.u uVar;
        y8.k.e(yVar, "<this>");
        int i10 = xVar == null ? -1 : a.f15672b[xVar.ordinal()];
        String str = "PRIVATE";
        switch (i10) {
            case 1:
                uVar = n9.t.f12302d;
                str = "INTERNAL";
                break;
            case 2:
            default:
                uVar = n9.t.f12299a;
                break;
            case 3:
                uVar = n9.t.f12300b;
                str = "PRIVATE_TO_THIS";
                break;
            case 4:
                uVar = n9.t.f12301c;
                str = "PROTECTED";
                break;
            case 5:
                uVar = n9.t.f12303e;
                str = "PUBLIC";
                break;
            case 6:
                uVar = n9.t.f12304f;
                str = "LOCAL";
                break;
        }
        y8.k.d(uVar, str);
        return uVar;
    }

    public static final b.a b(y yVar, ga.j jVar) {
        y8.k.e(yVar, "<this>");
        int i10 = jVar == null ? -1 : a.f15671a[jVar.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return b.a.FAKE_OVERRIDE;
            }
            if (i10 == 3) {
                return b.a.DELEGATION;
            }
            if (i10 == 4) {
                return b.a.SYNTHESIZED;
            }
        }
        return b.a.DECLARATION;
    }
}
