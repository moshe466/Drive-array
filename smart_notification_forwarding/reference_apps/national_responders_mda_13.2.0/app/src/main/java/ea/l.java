package ea;

import ea.j;

/* loaded from: classes.dex */
final class l implements k<j> {

    /* renamed from: a, reason: collision with root package name */
    public static final l f9321a = new l();

    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9322a;

        static {
            int[] iArr = new int[k9.i.valuesCustom().length];
            iArr[k9.i.BOOLEAN.ordinal()] = 1;
            iArr[k9.i.CHAR.ordinal()] = 2;
            iArr[k9.i.BYTE.ordinal()] = 3;
            iArr[k9.i.SHORT.ordinal()] = 4;
            iArr[k9.i.INT.ordinal()] = 5;
            iArr[k9.i.FLOAT.ordinal()] = 6;
            iArr[k9.i.LONG.ordinal()] = 7;
            iArr[k9.i.DOUBLE.ordinal()] = 8;
            f9322a = iArr;
        }
    }

    private l() {
    }

    @Override // ea.k
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public j e(j jVar) {
        y8.k.e(jVar, "possiblyPrimitiveType");
        if (!(jVar instanceof j.d)) {
            return jVar;
        }
        j.d dVar = (j.d) jVar;
        if (dVar.i() == null) {
            return jVar;
        }
        String f10 = sa.c.c(dVar.i().getWrapperFqName()).f();
        y8.k.d(f10, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return b(f10);
    }

    @Override // ea.k
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public j a(String str) {
        sa.d dVar;
        j cVar;
        y8.k.e(str, "representation");
        str.length();
        char charAt = str.charAt(0);
        sa.d[] values = sa.d.values();
        int length = values.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                dVar = null;
                break;
            }
            dVar = values[i10];
            if (dVar.getDesc().charAt(0) == charAt) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            return new j.d(dVar);
        }
        if (charAt == 'V') {
            return new j.d(null);
        }
        if (charAt == '[') {
            String substring = str.substring(1);
            y8.k.d(substring, "(this as java.lang.String).substring(startIndex)");
            cVar = new j.a(a(substring));
        } else {
            if (charAt == 'L') {
                mb.s.C(str, ';', false, 2, null);
            }
            String substring2 = str.substring(1, str.length() - 1);
            y8.k.d(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new j.c(substring2);
        }
        return cVar;
    }

    @Override // ea.k
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public j.c b(String str) {
        y8.k.e(str, "internalName");
        return new j.c(str);
    }

    @Override // ea.k
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public j c(k9.i iVar) {
        y8.k.e(iVar, "primitiveType");
        switch (a.f9322a[iVar.ordinal()]) {
            case 1:
                return j.f9309a.a();
            case 2:
                return j.f9309a.c();
            case 3:
                return j.f9309a.b();
            case 4:
                return j.f9309a.h();
            case 5:
                return j.f9309a.f();
            case 6:
                return j.f9309a.e();
            case 7:
                return j.f9309a.g();
            case 8:
                return j.f9309a.d();
            default:
                throw new l8.l();
        }
    }

    @Override // ea.k
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public j f() {
        return b("java/lang/Class");
    }

    @Override // ea.k
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String d(j jVar) {
        String desc;
        y8.k.e(jVar, "type");
        if (jVar instanceof j.a) {
            return y8.k.j("[", d(((j.a) jVar).i()));
        }
        if (jVar instanceof j.d) {
            sa.d i10 = ((j.d) jVar).i();
            return (i10 == null || (desc = i10.getDesc()) == null) ? "V" : desc;
        }
        if (!(jVar instanceof j.c)) {
            throw new l8.l();
        }
        return 'L' + ((j.c) jVar).i() + ';';
    }
}
