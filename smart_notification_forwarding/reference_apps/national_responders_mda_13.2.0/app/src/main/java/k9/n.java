package k9;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UBYTE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class n {
    private static final /* synthetic */ n[] $VALUES;
    public static final n UBYTE;
    public static final n UINT;
    public static final n ULONG;
    public static final n USHORT;
    private final la.a arrayClassId;
    private final la.a classId;
    private final la.e typeName;

    static {
        la.a e10 = la.a.e("kotlin/UByte");
        y8.k.d(e10, "fromString(\"kotlin/UByte\")");
        n nVar = new n("UBYTE", 0, e10);
        UBYTE = nVar;
        la.a e11 = la.a.e("kotlin/UShort");
        y8.k.d(e11, "fromString(\"kotlin/UShort\")");
        n nVar2 = new n("USHORT", 1, e11);
        USHORT = nVar2;
        la.a e12 = la.a.e("kotlin/UInt");
        y8.k.d(e12, "fromString(\"kotlin/UInt\")");
        n nVar3 = new n("UINT", 2, e12);
        UINT = nVar3;
        la.a e13 = la.a.e("kotlin/ULong");
        y8.k.d(e13, "fromString(\"kotlin/ULong\")");
        n nVar4 = new n("ULONG", 3, e13);
        ULONG = nVar4;
        $VALUES = new n[]{nVar, nVar2, nVar3, nVar4};
    }

    private n(String str, int i10, la.a aVar) {
        this.classId = aVar;
        la.e j10 = aVar.j();
        y8.k.d(j10, "classId.shortClassName");
        this.typeName = j10;
        this.arrayClassId = new la.a(aVar.h(), la.e.r(y8.k.j(j10.k(), "Array")));
    }

    public static n valueOf(String str) {
        y8.k.e(str, "value");
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        n[] nVarArr = $VALUES;
        n[] nVarArr2 = new n[nVarArr.length];
        System.arraycopy(nVarArr, 0, nVarArr2, 0, nVarArr.length);
        return nVarArr2;
    }

    public final la.a getArrayClassId() {
        return this.arrayClassId;
    }

    public final la.a getClassId() {
        return this.classId;
    }

    public final la.e getTypeName() {
        return this.typeName;
    }
}
