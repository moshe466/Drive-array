package k9;

import java.util.Set;
import m8.r0;

/* loaded from: classes.dex */
public enum i {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public static final a Companion;
    public static final Set<i> NUMBER_TYPES;
    private final l8.h arrayTypeFqName$delegate;
    private final la.e arrayTypeName;
    private final l8.h typeFqName$delegate;
    private final la.e typeName;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<la.b> {
        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.b b() {
            la.b c10 = k.f11246l.c(i.this.getArrayTypeName());
            y8.k.d(c10, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return c10;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<la.b> {
        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.b b() {
            la.b c10 = k.f11246l.c(i.this.getTypeName());
            y8.k.d(c10, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return c10;
        }
    }

    static {
        Set<i> e10;
        i iVar = CHAR;
        i iVar2 = BYTE;
        i iVar3 = SHORT;
        i iVar4 = INT;
        i iVar5 = FLOAT;
        i iVar6 = LONG;
        i iVar7 = DOUBLE;
        Companion = new a(null);
        e10 = r0.e(iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7);
        NUMBER_TYPES = e10;
    }

    i(String str) {
        l8.h a10;
        l8.h a11;
        la.e r10 = la.e.r(str);
        y8.k.d(r10, "identifier(typeName)");
        this.typeName = r10;
        la.e r11 = la.e.r(y8.k.j(str, "Array"));
        y8.k.d(r11, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = r11;
        kotlin.b bVar = kotlin.b.PUBLICATION;
        a10 = l8.j.a(bVar, new c());
        this.typeFqName$delegate = a10;
        a11 = l8.j.a(bVar, new b());
        this.arrayTypeFqName$delegate = a11;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static i[] valuesCustom() {
        i[] valuesCustom = values();
        i[] iVarArr = new i[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, iVarArr, 0, valuesCustom.length);
        return iVarArr;
    }

    public final la.b getArrayTypeFqName() {
        return (la.b) this.arrayTypeFqName$delegate.getValue();
    }

    public final la.e getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final la.b getTypeFqName() {
        return (la.b) this.typeFqName$delegate.getValue();
    }

    public final la.e getTypeName() {
        return this.typeName;
    }
}
