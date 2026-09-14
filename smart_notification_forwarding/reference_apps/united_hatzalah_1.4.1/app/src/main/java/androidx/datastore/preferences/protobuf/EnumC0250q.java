package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: androidx.datastore.preferences.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0250q {

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0250q f3227b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0250q f3228c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0250q[] f3229d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0250q[] f3230e;

    /* renamed from: a, reason: collision with root package name */
    public final int f3231a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0250q EF0;

    static {
        EnumC0256x enumC0256x = EnumC0256x.DOUBLE;
        EnumC0250q enumC0250q = new EnumC0250q("DOUBLE", 0, 0, 1, enumC0256x);
        EnumC0256x enumC0256x2 = EnumC0256x.FLOAT;
        EnumC0250q enumC0250q2 = new EnumC0250q("FLOAT", 1, 1, 1, enumC0256x2);
        EnumC0256x enumC0256x3 = EnumC0256x.LONG;
        EnumC0250q enumC0250q3 = new EnumC0250q("INT64", 2, 2, 1, enumC0256x3);
        EnumC0250q enumC0250q4 = new EnumC0250q("UINT64", 3, 3, 1, enumC0256x3);
        EnumC0256x enumC0256x4 = EnumC0256x.INT;
        EnumC0250q enumC0250q5 = new EnumC0250q("INT32", 4, 4, 1, enumC0256x4);
        EnumC0250q enumC0250q6 = new EnumC0250q("FIXED64", 5, 5, 1, enumC0256x3);
        EnumC0250q enumC0250q7 = new EnumC0250q("FIXED32", 6, 6, 1, enumC0256x4);
        EnumC0256x enumC0256x5 = EnumC0256x.BOOLEAN;
        EnumC0250q enumC0250q8 = new EnumC0250q("BOOL", 7, 7, 1, enumC0256x5);
        EnumC0256x enumC0256x6 = EnumC0256x.STRING;
        EnumC0250q enumC0250q9 = new EnumC0250q("STRING", 8, 8, 1, enumC0256x6);
        EnumC0256x enumC0256x7 = EnumC0256x.MESSAGE;
        EnumC0250q enumC0250q10 = new EnumC0250q("MESSAGE", 9, 9, 1, enumC0256x7);
        EnumC0256x enumC0256x8 = EnumC0256x.BYTE_STRING;
        EnumC0250q enumC0250q11 = new EnumC0250q("BYTES", 10, 10, 1, enumC0256x8);
        EnumC0250q enumC0250q12 = new EnumC0250q("UINT32", 11, 11, 1, enumC0256x4);
        EnumC0256x enumC0256x9 = EnumC0256x.ENUM;
        EnumC0250q enumC0250q13 = new EnumC0250q("ENUM", 12, 12, 1, enumC0256x9);
        EnumC0250q enumC0250q14 = new EnumC0250q("SFIXED32", 13, 13, 1, enumC0256x4);
        EnumC0250q enumC0250q15 = new EnumC0250q("SFIXED64", 14, 14, 1, enumC0256x3);
        EnumC0250q enumC0250q16 = new EnumC0250q("SINT32", 15, 15, 1, enumC0256x4);
        EnumC0250q enumC0250q17 = new EnumC0250q("SINT64", 16, 16, 1, enumC0256x3);
        EnumC0250q enumC0250q18 = new EnumC0250q("GROUP", 17, 17, 1, enumC0256x7);
        EnumC0250q enumC0250q19 = new EnumC0250q("DOUBLE_LIST", 18, 18, 2, enumC0256x);
        EnumC0250q enumC0250q20 = new EnumC0250q("FLOAT_LIST", 19, 19, 2, enumC0256x2);
        EnumC0250q enumC0250q21 = new EnumC0250q("INT64_LIST", 20, 20, 2, enumC0256x3);
        EnumC0250q enumC0250q22 = new EnumC0250q("UINT64_LIST", 21, 21, 2, enumC0256x3);
        EnumC0250q enumC0250q23 = new EnumC0250q("INT32_LIST", 22, 22, 2, enumC0256x4);
        EnumC0250q enumC0250q24 = new EnumC0250q("FIXED64_LIST", 23, 23, 2, enumC0256x3);
        EnumC0250q enumC0250q25 = new EnumC0250q("FIXED32_LIST", 24, 24, 2, enumC0256x4);
        EnumC0250q enumC0250q26 = new EnumC0250q("BOOL_LIST", 25, 25, 2, enumC0256x5);
        EnumC0250q enumC0250q27 = new EnumC0250q("STRING_LIST", 26, 26, 2, enumC0256x6);
        EnumC0250q enumC0250q28 = new EnumC0250q("MESSAGE_LIST", 27, 27, 2, enumC0256x7);
        EnumC0250q enumC0250q29 = new EnumC0250q("BYTES_LIST", 28, 28, 2, enumC0256x8);
        EnumC0250q enumC0250q30 = new EnumC0250q("UINT32_LIST", 29, 29, 2, enumC0256x4);
        EnumC0250q enumC0250q31 = new EnumC0250q("ENUM_LIST", 30, 30, 2, enumC0256x9);
        EnumC0250q enumC0250q32 = new EnumC0250q("SFIXED32_LIST", 31, 31, 2, enumC0256x4);
        EnumC0250q enumC0250q33 = new EnumC0250q("SFIXED64_LIST", 32, 32, 2, enumC0256x3);
        EnumC0250q enumC0250q34 = new EnumC0250q("SINT32_LIST", 33, 33, 2, enumC0256x4);
        EnumC0250q enumC0250q35 = new EnumC0250q("SINT64_LIST", 34, 34, 2, enumC0256x3);
        EnumC0250q enumC0250q36 = new EnumC0250q("DOUBLE_LIST_PACKED", 35, 35, 3, enumC0256x);
        f3227b = enumC0250q36;
        EnumC0250q enumC0250q37 = new EnumC0250q("FLOAT_LIST_PACKED", 36, 36, 3, enumC0256x2);
        EnumC0250q enumC0250q38 = new EnumC0250q("INT64_LIST_PACKED", 37, 37, 3, enumC0256x3);
        EnumC0250q enumC0250q39 = new EnumC0250q("UINT64_LIST_PACKED", 38, 38, 3, enumC0256x3);
        EnumC0250q enumC0250q40 = new EnumC0250q("INT32_LIST_PACKED", 39, 39, 3, enumC0256x4);
        EnumC0250q enumC0250q41 = new EnumC0250q("FIXED64_LIST_PACKED", 40, 40, 3, enumC0256x3);
        EnumC0250q enumC0250q42 = new EnumC0250q("FIXED32_LIST_PACKED", 41, 41, 3, enumC0256x4);
        EnumC0250q enumC0250q43 = new EnumC0250q("BOOL_LIST_PACKED", 42, 42, 3, enumC0256x5);
        EnumC0250q enumC0250q44 = new EnumC0250q("UINT32_LIST_PACKED", 43, 43, 3, enumC0256x4);
        EnumC0250q enumC0250q45 = new EnumC0250q("ENUM_LIST_PACKED", 44, 44, 3, enumC0256x9);
        EnumC0250q enumC0250q46 = new EnumC0250q("SFIXED32_LIST_PACKED", 45, 45, 3, enumC0256x4);
        EnumC0250q enumC0250q47 = new EnumC0250q("SFIXED64_LIST_PACKED", 46, 46, 3, enumC0256x3);
        EnumC0250q enumC0250q48 = new EnumC0250q("SINT32_LIST_PACKED", 47, 47, 3, enumC0256x4);
        EnumC0250q enumC0250q49 = new EnumC0250q("SINT64_LIST_PACKED", 48, 48, 3, enumC0256x3);
        f3228c = enumC0250q49;
        f3230e = new EnumC0250q[]{enumC0250q, enumC0250q2, enumC0250q3, enumC0250q4, enumC0250q5, enumC0250q6, enumC0250q7, enumC0250q8, enumC0250q9, enumC0250q10, enumC0250q11, enumC0250q12, enumC0250q13, enumC0250q14, enumC0250q15, enumC0250q16, enumC0250q17, enumC0250q18, enumC0250q19, enumC0250q20, enumC0250q21, enumC0250q22, enumC0250q23, enumC0250q24, enumC0250q25, enumC0250q26, enumC0250q27, enumC0250q28, enumC0250q29, enumC0250q30, enumC0250q31, enumC0250q32, enumC0250q33, enumC0250q34, enumC0250q35, enumC0250q36, enumC0250q37, enumC0250q38, enumC0250q39, enumC0250q40, enumC0250q41, enumC0250q42, enumC0250q43, enumC0250q44, enumC0250q45, enumC0250q46, enumC0250q47, enumC0250q48, enumC0250q49, new EnumC0250q("GROUP_LIST", 49, 49, 2, enumC0256x7), new EnumC0250q("MAP", 50, 50, 4, EnumC0256x.VOID)};
        EnumC0250q[] values = values();
        f3229d = new EnumC0250q[values.length];
        for (EnumC0250q enumC0250q50 : values) {
            f3229d[enumC0250q50.f3231a] = enumC0250q50;
        }
    }

    public EnumC0250q(String str, int i, int i3, int i4, EnumC0256x enumC0256x) {
        this.f3231a = i3;
        int b4 = T.k.b(i4);
        if (b4 != 1) {
            if (b4 == 3) {
                enumC0256x.getClass();
            }
        } else {
            enumC0256x.getClass();
        }
        if (i4 == 1) {
            enumC0256x.ordinal();
        }
    }

    public static EnumC0250q valueOf(String str) {
        return (EnumC0250q) Enum.valueOf(EnumC0250q.class, str);
    }

    public static EnumC0250q[] values() {
        return (EnumC0250q[]) f3230e.clone();
    }
}
