package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Set;
import m8.y;

/* loaded from: classes.dex */
public enum e {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);

    public static final Set<e> ALL;
    public static final Set<e> ALL_EXCEPT_ANNOTATIONS;
    public static final a Companion = new a(null);
    private final boolean includeByDefault;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        Set<e> r02;
        Set<e> a02;
        e[] valuesCustom = valuesCustom();
        ArrayList arrayList = new ArrayList();
        for (e eVar : valuesCustom) {
            if (eVar.getIncludeByDefault()) {
                arrayList.add(eVar);
            }
        }
        r02 = y.r0(arrayList);
        ALL_EXCEPT_ANNOTATIONS = r02;
        a02 = m8.k.a0(valuesCustom());
        ALL = a02;
    }

    e(boolean z10) {
        this.includeByDefault = z10;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] valuesCustom = values();
        e[] eVarArr = new e[valuesCustom.length];
        System.arraycopy(valuesCustom, 0, eVarArr, 0, valuesCustom.length);
        return eVarArr;
    }

    public final boolean getIncludeByDefault() {
        return this.includeByDefault;
    }
}
