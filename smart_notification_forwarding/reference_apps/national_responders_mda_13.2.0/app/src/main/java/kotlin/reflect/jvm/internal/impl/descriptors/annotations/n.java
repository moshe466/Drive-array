package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import l8.t;
import m8.l0;
import m8.y;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ANNOTATION_CLASS' uses external variables
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
    private static final Set<n> ALL_TARGET_SET;
    public static final n ANNOTATION_CLASS;
    public static final n ANONYMOUS_FUNCTION;
    public static final n CLASS;
    public static final n CLASS_ONLY;
    public static final n COMPANION_OBJECT;
    public static final n CONSTRUCTOR;
    public static final a Companion;
    private static final Set<n> DEFAULT_TARGET_SET;
    public static final n DESTRUCTURING_DECLARATION;
    public static final n ENUM_CLASS;
    public static final n ENUM_ENTRY;
    public static final n EXPRESSION;
    public static final n FIELD;
    public static final n FILE;
    public static final n FUNCTION;
    public static final n INITIALIZER;
    public static final n INTERFACE;
    public static final n LAMBDA_EXPRESSION;
    public static final n LOCAL_CLASS;
    public static final n LOCAL_FUNCTION;
    public static final n LOCAL_VARIABLE;
    public static final n MEMBER_FUNCTION;
    public static final n MEMBER_PROPERTY;
    public static final n MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final n MEMBER_PROPERTY_WITH_BACKING_FIELD;
    public static final n MEMBER_PROPERTY_WITH_DELEGATE;
    public static final n OBJECT;
    public static final n OBJECT_LITERAL;
    public static final n PROPERTY;
    public static final n PROPERTY_GETTER;
    public static final n PROPERTY_PARAMETER;
    public static final n PROPERTY_SETTER;
    public static final n STAR_PROJECTION;
    public static final n TOP_LEVEL_FUNCTION;
    public static final n TOP_LEVEL_PROPERTY;
    public static final n TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE;
    public static final n TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD;
    public static final n TOP_LEVEL_PROPERTY_WITH_DELEGATE;
    public static final n TYPE;
    public static final n TYPEALIAS;
    public static final n TYPE_PARAMETER;
    public static final n TYPE_PROJECTION;
    private static final Map<e, n> USE_SITE_MAPPING;
    public static final n VALUE_PARAMETER;
    private static final HashMap<String, n> map;
    private final String description;
    private final boolean isDefault;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        Set<n> r02;
        Set<n> a02;
        Map<e, n> k10;
        n nVar = new n("CLASS", 0, "class", false, 2, null);
        CLASS = nVar;
        boolean z10 = false;
        int i10 = 2;
        y8.g gVar = null;
        n nVar2 = new n("ANNOTATION_CLASS", 1, "annotation class", z10, i10, gVar);
        ANNOTATION_CLASS = nVar2;
        n nVar3 = new n("TYPE_PARAMETER", 2, "type parameter", false);
        TYPE_PARAMETER = nVar3;
        n nVar4 = new n("PROPERTY", 3, "property", z10, i10, gVar);
        PROPERTY = nVar4;
        boolean z11 = false;
        int i11 = 2;
        y8.g gVar2 = null;
        n nVar5 = new n("FIELD", 4, "field", z11, i11, gVar2);
        FIELD = nVar5;
        n nVar6 = new n("LOCAL_VARIABLE", 5, "local variable", z10, i10, gVar);
        LOCAL_VARIABLE = nVar6;
        n nVar7 = new n("VALUE_PARAMETER", 6, "value parameter", z11, i11, gVar2);
        VALUE_PARAMETER = nVar7;
        n nVar8 = new n("CONSTRUCTOR", 7, "constructor", false, 2, null);
        CONSTRUCTOR = nVar8;
        boolean z12 = false;
        int i12 = 2;
        y8.g gVar3 = null;
        n nVar9 = new n("FUNCTION", 8, "function", z12, i12, gVar3);
        FUNCTION = nVar9;
        n nVar10 = new n("PROPERTY_GETTER", 9, "getter", false, 2, null);
        PROPERTY_GETTER = nVar10;
        n nVar11 = new n("PROPERTY_SETTER", 10, "setter", z12, i12, gVar3);
        PROPERTY_SETTER = nVar11;
        n nVar12 = new n("TYPE", 11, "type usage", false);
        TYPE = nVar12;
        n nVar13 = new n("EXPRESSION", 12, "expression", false);
        EXPRESSION = nVar13;
        n nVar14 = new n("FILE", 13, "file", false);
        FILE = nVar14;
        n nVar15 = new n("TYPEALIAS", 14, "typealias", false);
        TYPEALIAS = nVar15;
        n nVar16 = new n("TYPE_PROJECTION", 15, "type projection", false);
        TYPE_PROJECTION = nVar16;
        n nVar17 = new n("STAR_PROJECTION", 16, "star projection", false);
        STAR_PROJECTION = nVar17;
        n nVar18 = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
        PROPERTY_PARAMETER = nVar18;
        n nVar19 = new n("CLASS_ONLY", 18, "class", false);
        CLASS_ONLY = nVar19;
        n nVar20 = new n("OBJECT", 19, "object", false);
        OBJECT = nVar20;
        n nVar21 = new n("COMPANION_OBJECT", 20, "companion object", false);
        COMPANION_OBJECT = nVar21;
        n nVar22 = new n("INTERFACE", 21, "interface", false);
        INTERFACE = nVar22;
        n nVar23 = new n("ENUM_CLASS", 22, "enum class", false);
        ENUM_CLASS = nVar23;
        n nVar24 = new n("ENUM_ENTRY", 23, "enum entry", false);
        ENUM_ENTRY = nVar24;
        n nVar25 = new n("LOCAL_CLASS", 24, "local class", false);
        LOCAL_CLASS = nVar25;
        n nVar26 = new n("LOCAL_FUNCTION", 25, "local function", false);
        LOCAL_FUNCTION = nVar26;
        n nVar27 = new n("MEMBER_FUNCTION", 26, "member function", false);
        MEMBER_FUNCTION = nVar27;
        n nVar28 = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
        TOP_LEVEL_FUNCTION = nVar28;
        n nVar29 = new n("MEMBER_PROPERTY", 28, "member property", false);
        MEMBER_PROPERTY = nVar29;
        n nVar30 = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
        MEMBER_PROPERTY_WITH_BACKING_FIELD = nVar30;
        n nVar31 = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
        MEMBER_PROPERTY_WITH_DELEGATE = nVar31;
        n nVar32 = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
        MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = nVar32;
        n nVar33 = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
        TOP_LEVEL_PROPERTY = nVar33;
        n nVar34 = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
        TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = nVar34;
        n nVar35 = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
        TOP_LEVEL_PROPERTY_WITH_DELEGATE = nVar35;
        n nVar36 = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
        TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = nVar36;
        n nVar37 = new n("INITIALIZER", 36, "initializer", false);
        INITIALIZER = nVar37;
        n nVar38 = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
        DESTRUCTURING_DECLARATION = nVar38;
        n nVar39 = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
        LAMBDA_EXPRESSION = nVar39;
        n nVar40 = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
        ANONYMOUS_FUNCTION = nVar40;
        n nVar41 = new n("OBJECT_LITERAL", 40, "object literal", false);
        OBJECT_LITERAL = nVar41;
        $VALUES = new n[]{nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7, nVar8, nVar9, nVar10, nVar11, nVar12, nVar13, nVar14, nVar15, nVar16, nVar17, nVar18, nVar19, nVar20, nVar21, nVar22, nVar23, nVar24, nVar25, nVar26, nVar27, nVar28, nVar29, nVar30, nVar31, nVar32, nVar33, nVar34, nVar35, nVar36, nVar37, nVar38, nVar39, nVar40, nVar41};
        Companion = new a(null);
        map = new HashMap<>();
        n[] values = values();
        int length = values.length;
        int i13 = 0;
        while (i13 < length) {
            n nVar42 = values[i13];
            i13++;
            map.put(nVar42.name(), nVar42);
        }
        n[] values2 = values();
        ArrayList arrayList = new ArrayList();
        for (n nVar43 : values2) {
            if (nVar43.isDefault()) {
                arrayList.add(nVar43);
            }
        }
        r02 = y.r0(arrayList);
        DEFAULT_TARGET_SET = r02;
        a02 = m8.k.a0(values());
        ALL_TARGET_SET = a02;
        e eVar = e.CONSTRUCTOR_PARAMETER;
        n nVar44 = VALUE_PARAMETER;
        e eVar2 = e.FIELD;
        n nVar45 = FIELD;
        k10 = l0.k(t.a(eVar, nVar44), t.a(eVar2, nVar45), t.a(e.PROPERTY, PROPERTY), t.a(e.FILE, FILE), t.a(e.PROPERTY_GETTER, PROPERTY_GETTER), t.a(e.PROPERTY_SETTER, PROPERTY_SETTER), t.a(e.RECEIVER, nVar44), t.a(e.SETTER_PARAMETER, nVar44), t.a(e.PROPERTY_DELEGATE_FIELD, nVar45));
        USE_SITE_MAPPING = k10;
    }

    private n(String str, int i10, String str2, boolean z10) {
        this.description = str2;
        this.isDefault = z10;
    }

    /* synthetic */ n(String str, int i10, String str2, boolean z10, int i11, y8.g gVar) {
        this(str, i10, str2, (i11 & 2) != 0 ? true : z10);
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

    public final boolean isDefault() {
        return this.isDefault;
    }
}
