package k9;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UBYTEARRAY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class m {
    private static final /* synthetic */ m[] $VALUES;
    public static final m UBYTEARRAY;
    public static final m UINTARRAY;
    public static final m ULONGARRAY;
    public static final m USHORTARRAY;
    private final la.a classId;
    private final la.e typeName;

    static {
        la.a e10 = la.a.e("kotlin/UByteArray");
        y8.k.d(e10, "fromString(\"kotlin/UByteArray\")");
        m mVar = new m("UBYTEARRAY", 0, e10);
        UBYTEARRAY = mVar;
        la.a e11 = la.a.e("kotlin/UShortArray");
        y8.k.d(e11, "fromString(\"kotlin/UShortArray\")");
        m mVar2 = new m("USHORTARRAY", 1, e11);
        USHORTARRAY = mVar2;
        la.a e12 = la.a.e("kotlin/UIntArray");
        y8.k.d(e12, "fromString(\"kotlin/UIntArray\")");
        m mVar3 = new m("UINTARRAY", 2, e12);
        UINTARRAY = mVar3;
        la.a e13 = la.a.e("kotlin/ULongArray");
        y8.k.d(e13, "fromString(\"kotlin/ULongArray\")");
        m mVar4 = new m("ULONGARRAY", 3, e13);
        ULONGARRAY = mVar4;
        $VALUES = new m[]{mVar, mVar2, mVar3, mVar4};
    }

    private m(String str, int i10, la.a aVar) {
        this.classId = aVar;
        la.e j10 = aVar.j();
        y8.k.d(j10, "classId.shortClassName");
        this.typeName = j10;
    }

    public static m valueOf(String str) {
        y8.k.e(str, "value");
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        m[] mVarArr = $VALUES;
        m[] mVarArr2 = new m[mVarArr.length];
        System.arraycopy(mVarArr, 0, mVarArr2, 0, mVarArr.length);
        return mVarArr2;
    }

    public final la.e getTypeName() {
        return this.typeName;
    }
}
