package com.google.crypto.tink.shaded.protobuf;

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
/* renamed from: com.google.crypto.tink.shaded.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC0346s {

    /* renamed from: b, reason: collision with root package name */
    public static final EnumC0346s f4150b;

    /* renamed from: c, reason: collision with root package name */
    public static final EnumC0346s f4151c;

    /* renamed from: d, reason: collision with root package name */
    public static final EnumC0346s[] f4152d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumC0346s[] f4153e;

    /* renamed from: a, reason: collision with root package name */
    public final int f4154a;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0346s EF0;

    static {
        C c4 = C.DOUBLE;
        EnumC0346s enumC0346s = new EnumC0346s("DOUBLE", 0, 0, 1, c4);
        C c5 = C.FLOAT;
        EnumC0346s enumC0346s2 = new EnumC0346s("FLOAT", 1, 1, 1, c5);
        C c6 = C.LONG;
        EnumC0346s enumC0346s3 = new EnumC0346s("INT64", 2, 2, 1, c6);
        EnumC0346s enumC0346s4 = new EnumC0346s("UINT64", 3, 3, 1, c6);
        C c7 = C.INT;
        EnumC0346s enumC0346s5 = new EnumC0346s("INT32", 4, 4, 1, c7);
        EnumC0346s enumC0346s6 = new EnumC0346s("FIXED64", 5, 5, 1, c6);
        EnumC0346s enumC0346s7 = new EnumC0346s("FIXED32", 6, 6, 1, c7);
        C c8 = C.BOOLEAN;
        EnumC0346s enumC0346s8 = new EnumC0346s("BOOL", 7, 7, 1, c8);
        C c9 = C.STRING;
        EnumC0346s enumC0346s9 = new EnumC0346s("STRING", 8, 8, 1, c9);
        C c10 = C.MESSAGE;
        EnumC0346s enumC0346s10 = new EnumC0346s("MESSAGE", 9, 9, 1, c10);
        C c11 = C.BYTE_STRING;
        EnumC0346s enumC0346s11 = new EnumC0346s("BYTES", 10, 10, 1, c11);
        EnumC0346s enumC0346s12 = new EnumC0346s("UINT32", 11, 11, 1, c7);
        C c12 = C.ENUM;
        EnumC0346s enumC0346s13 = new EnumC0346s("ENUM", 12, 12, 1, c12);
        EnumC0346s enumC0346s14 = new EnumC0346s("SFIXED32", 13, 13, 1, c7);
        EnumC0346s enumC0346s15 = new EnumC0346s("SFIXED64", 14, 14, 1, c6);
        EnumC0346s enumC0346s16 = new EnumC0346s("SINT32", 15, 15, 1, c7);
        EnumC0346s enumC0346s17 = new EnumC0346s("SINT64", 16, 16, 1, c6);
        EnumC0346s enumC0346s18 = new EnumC0346s("GROUP", 17, 17, 1, c10);
        EnumC0346s enumC0346s19 = new EnumC0346s("DOUBLE_LIST", 18, 18, 2, c4);
        EnumC0346s enumC0346s20 = new EnumC0346s("FLOAT_LIST", 19, 19, 2, c5);
        EnumC0346s enumC0346s21 = new EnumC0346s("INT64_LIST", 20, 20, 2, c6);
        EnumC0346s enumC0346s22 = new EnumC0346s("UINT64_LIST", 21, 21, 2, c6);
        EnumC0346s enumC0346s23 = new EnumC0346s("INT32_LIST", 22, 22, 2, c7);
        EnumC0346s enumC0346s24 = new EnumC0346s("FIXED64_LIST", 23, 23, 2, c6);
        EnumC0346s enumC0346s25 = new EnumC0346s("FIXED32_LIST", 24, 24, 2, c7);
        EnumC0346s enumC0346s26 = new EnumC0346s("BOOL_LIST", 25, 25, 2, c8);
        EnumC0346s enumC0346s27 = new EnumC0346s("STRING_LIST", 26, 26, 2, c9);
        EnumC0346s enumC0346s28 = new EnumC0346s("MESSAGE_LIST", 27, 27, 2, c10);
        EnumC0346s enumC0346s29 = new EnumC0346s("BYTES_LIST", 28, 28, 2, c11);
        EnumC0346s enumC0346s30 = new EnumC0346s("UINT32_LIST", 29, 29, 2, c7);
        EnumC0346s enumC0346s31 = new EnumC0346s("ENUM_LIST", 30, 30, 2, c12);
        EnumC0346s enumC0346s32 = new EnumC0346s("SFIXED32_LIST", 31, 31, 2, c7);
        EnumC0346s enumC0346s33 = new EnumC0346s("SFIXED64_LIST", 32, 32, 2, c6);
        EnumC0346s enumC0346s34 = new EnumC0346s("SINT32_LIST", 33, 33, 2, c7);
        EnumC0346s enumC0346s35 = new EnumC0346s("SINT64_LIST", 34, 34, 2, c6);
        EnumC0346s enumC0346s36 = new EnumC0346s("DOUBLE_LIST_PACKED", 35, 35, 3, c4);
        f4150b = enumC0346s36;
        EnumC0346s enumC0346s37 = new EnumC0346s("FLOAT_LIST_PACKED", 36, 36, 3, c5);
        EnumC0346s enumC0346s38 = new EnumC0346s("INT64_LIST_PACKED", 37, 37, 3, c6);
        EnumC0346s enumC0346s39 = new EnumC0346s("UINT64_LIST_PACKED", 38, 38, 3, c6);
        EnumC0346s enumC0346s40 = new EnumC0346s("INT32_LIST_PACKED", 39, 39, 3, c7);
        EnumC0346s enumC0346s41 = new EnumC0346s("FIXED64_LIST_PACKED", 40, 40, 3, c6);
        EnumC0346s enumC0346s42 = new EnumC0346s("FIXED32_LIST_PACKED", 41, 41, 3, c7);
        EnumC0346s enumC0346s43 = new EnumC0346s("BOOL_LIST_PACKED", 42, 42, 3, c8);
        EnumC0346s enumC0346s44 = new EnumC0346s("UINT32_LIST_PACKED", 43, 43, 3, c7);
        EnumC0346s enumC0346s45 = new EnumC0346s("ENUM_LIST_PACKED", 44, 44, 3, c12);
        EnumC0346s enumC0346s46 = new EnumC0346s("SFIXED32_LIST_PACKED", 45, 45, 3, c7);
        EnumC0346s enumC0346s47 = new EnumC0346s("SFIXED64_LIST_PACKED", 46, 46, 3, c6);
        EnumC0346s enumC0346s48 = new EnumC0346s("SINT32_LIST_PACKED", 47, 47, 3, c7);
        EnumC0346s enumC0346s49 = new EnumC0346s("SINT64_LIST_PACKED", 48, 48, 3, c6);
        f4151c = enumC0346s49;
        f4153e = new EnumC0346s[]{enumC0346s, enumC0346s2, enumC0346s3, enumC0346s4, enumC0346s5, enumC0346s6, enumC0346s7, enumC0346s8, enumC0346s9, enumC0346s10, enumC0346s11, enumC0346s12, enumC0346s13, enumC0346s14, enumC0346s15, enumC0346s16, enumC0346s17, enumC0346s18, enumC0346s19, enumC0346s20, enumC0346s21, enumC0346s22, enumC0346s23, enumC0346s24, enumC0346s25, enumC0346s26, enumC0346s27, enumC0346s28, enumC0346s29, enumC0346s30, enumC0346s31, enumC0346s32, enumC0346s33, enumC0346s34, enumC0346s35, enumC0346s36, enumC0346s37, enumC0346s38, enumC0346s39, enumC0346s40, enumC0346s41, enumC0346s42, enumC0346s43, enumC0346s44, enumC0346s45, enumC0346s46, enumC0346s47, enumC0346s48, enumC0346s49, new EnumC0346s("GROUP_LIST", 49, 49, 2, c10), new EnumC0346s("MAP", 50, 50, 4, C.VOID)};
        EnumC0346s[] values = values();
        f4152d = new EnumC0346s[values.length];
        for (EnumC0346s enumC0346s50 : values) {
            f4152d[enumC0346s50.f4154a] = enumC0346s50;
        }
    }

    public EnumC0346s(String str, int i, int i3, int i4, C c4) {
        this.f4154a = i3;
        int b4 = T.k.b(i4);
        if (b4 != 1) {
            if (b4 == 3) {
                c4.getClass();
            }
        } else {
            c4.getClass();
        }
        if (i4 == 1) {
            c4.ordinal();
        }
    }

    public static EnumC0346s valueOf(String str) {
        return (EnumC0346s) Enum.valueOf(EnumC0346s.class, str);
    }

    public static EnumC0346s[] values() {
        return (EnumC0346s[]) f4153e.clone();
    }
}
