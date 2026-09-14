package fa;

import ea.o;
import fa.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import la.e;
import n9.v0;
import pa.f;
import v9.y;

/* loaded from: classes.dex */
public class b implements o.c {

    /* renamed from: j, reason: collision with root package name */
    private static final boolean f9664j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: k, reason: collision with root package name */
    private static final Map<la.a, a.EnumC0166a> f9665k;

    /* renamed from: a, reason: collision with root package name */
    private int[] f9666a = null;

    /* renamed from: b, reason: collision with root package name */
    private ka.c f9667b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f9668c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f9669d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f9670e = null;

    /* renamed from: f, reason: collision with root package name */
    private String[] f9671f = null;

    /* renamed from: g, reason: collision with root package name */
    private String[] f9672g = null;

    /* renamed from: h, reason: collision with root package name */
    private String[] f9673h = null;

    /* renamed from: i, reason: collision with root package name */
    private a.EnumC0166a f9674i = null;

    /* renamed from: fa.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0168b implements o.b {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f9675a = new ArrayList();

        private static /* synthetic */ void e(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i10 != 2) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classLiteralValue";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i10 != 2) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // ea.o.b
        public void a() {
            f((String[]) this.f9675a.toArray(new String[0]));
        }

        @Override // ea.o.b
        public void b(f fVar) {
            if (fVar == null) {
                e(2);
            }
        }

        @Override // ea.o.b
        public void c(la.a aVar, e eVar) {
            if (aVar == null) {
                e(0);
            }
            if (eVar == null) {
                e(1);
            }
        }

        @Override // ea.o.b
        public void d(Object obj) {
            if (obj instanceof String) {
                this.f9675a.add((String) obj);
            }
        }

        protected abstract void f(String[] strArr);
    }

    /* loaded from: classes.dex */
    private class c implements o.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends AbstractC0168b {
            a() {
            }

            private static /* synthetic */ void e(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            @Override // fa.b.AbstractC0168b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                b.this.f9671f = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: fa.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0169b extends AbstractC0168b {
            C0169b() {
            }

            private static /* synthetic */ void e(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            @Override // fa.b.AbstractC0168b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                b.this.f9672g = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i10 == 7) {
                objArr[0] = "classId";
            } else if (i10 == 4) {
                objArr[0] = "enumClassId";
            } else if (i10 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i10) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private o.b h() {
            return new a();
        }

        private o.b i() {
            return new C0169b();
        }

        @Override // ea.o.a
        public void a() {
        }

        @Override // ea.o.a
        public void b(e eVar, la.a aVar, e eVar2) {
            if (eVar == null) {
                g(3);
            }
            if (aVar == null) {
                g(4);
            }
            if (eVar2 == null) {
                g(5);
            }
        }

        @Override // ea.o.a
        public o.b c(e eVar) {
            if (eVar == null) {
                g(2);
            }
            String k10 = eVar.k();
            if ("d1".equals(k10)) {
                return h();
            }
            if ("d2".equals(k10)) {
                return i();
            }
            return null;
        }

        @Override // ea.o.a
        public void d(e eVar, f fVar) {
            if (eVar == null) {
                g(0);
            }
            if (fVar == null) {
                g(1);
            }
        }

        @Override // ea.o.a
        public o.a e(e eVar, la.a aVar) {
            if (eVar == null) {
                g(6);
            }
            if (aVar != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // ea.o.a
        public void f(e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String k10 = eVar.k();
            if ("k".equals(k10)) {
                if (obj instanceof Integer) {
                    b.this.f9674i = a.EnumC0166a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(k10)) {
                if (obj instanceof int[]) {
                    b.this.f9666a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(k10)) {
                if (obj instanceof int[]) {
                    b.this.f9667b = new ka.c((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(k10)) {
                if (obj instanceof String) {
                    b.this.f9668c = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(k10)) {
                if (obj instanceof Integer) {
                    b.this.f9669d = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(k10) && (obj instanceof String)) {
                b.this.f9670e = (String) obj;
            }
        }
    }

    /* loaded from: classes.dex */
    private class d implements o.a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends AbstractC0168b {
            a() {
            }

            private static /* synthetic */ void e(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            @Override // fa.b.AbstractC0168b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                b.this.f9671f = strArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: fa.b$d$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0170b extends AbstractC0168b {
            C0170b() {
            }

            private static /* synthetic */ void e(int i10) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            @Override // fa.b.AbstractC0168b
            protected void f(String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                b.this.f9672g = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i10 == 7) {
                objArr[0] = "classId";
            } else if (i10 == 4) {
                objArr[0] = "enumClassId";
            } else if (i10 != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i10) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private o.b h() {
            return new a();
        }

        private o.b i() {
            return new C0170b();
        }

        @Override // ea.o.a
        public void a() {
        }

        @Override // ea.o.a
        public void b(e eVar, la.a aVar, e eVar2) {
            if (eVar == null) {
                g(3);
            }
            if (aVar == null) {
                g(4);
            }
            if (eVar2 == null) {
                g(5);
            }
        }

        @Override // ea.o.a
        public o.b c(e eVar) {
            if (eVar == null) {
                g(2);
            }
            String k10 = eVar.k();
            if ("data".equals(k10) || "filePartClassNames".equals(k10)) {
                return h();
            }
            if ("strings".equals(k10)) {
                return i();
            }
            return null;
        }

        @Override // ea.o.a
        public void d(e eVar, f fVar) {
            if (eVar == null) {
                g(0);
            }
            if (fVar == null) {
                g(1);
            }
        }

        @Override // ea.o.a
        public o.a e(e eVar, la.a aVar) {
            if (eVar == null) {
                g(6);
            }
            if (aVar != null) {
                return null;
            }
            g(7);
            return null;
        }

        @Override // ea.o.a
        public void f(e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String k10 = eVar.k();
            if (!"version".equals(k10)) {
                if ("multifileClassName".equals(k10)) {
                    b.this.f9668c = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                b.this.f9666a = iArr;
                if (b.this.f9667b == null) {
                    b.this.f9667b = new ka.c(iArr);
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f9665k = hashMap;
        hashMap.put(la.a.m(new la.b("kotlin.jvm.internal.KotlinClass")), a.EnumC0166a.CLASS);
        hashMap.put(la.a.m(new la.b("kotlin.jvm.internal.KotlinFileFacade")), a.EnumC0166a.FILE_FACADE);
        hashMap.put(la.a.m(new la.b("kotlin.jvm.internal.KotlinMultifileClass")), a.EnumC0166a.MULTIFILE_CLASS);
        hashMap.put(la.a.m(new la.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.EnumC0166a.MULTIFILE_CLASS_PART);
        hashMap.put(la.a.m(new la.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.EnumC0166a.SYNTHETIC_CLASS);
    }

    private static /* synthetic */ void d(int i10) {
        Object[] objArr = new Object[3];
        if (i10 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    private boolean o() {
        a.EnumC0166a enumC0166a = this.f9674i;
        return enumC0166a == a.EnumC0166a.CLASS || enumC0166a == a.EnumC0166a.FILE_FACADE || enumC0166a == a.EnumC0166a.MULTIFILE_CLASS_PART;
    }

    @Override // ea.o.c
    public void a() {
    }

    @Override // ea.o.c
    public o.a c(la.a aVar, v0 v0Var) {
        a.EnumC0166a enumC0166a;
        if (aVar == null) {
            d(0);
        }
        if (v0Var == null) {
            d(1);
        }
        if (aVar.b().equals(y.f14813a)) {
            return new c();
        }
        if (f9664j || this.f9674i != null || (enumC0166a = f9665k.get(aVar)) == null) {
            return null;
        }
        this.f9674i = enumC0166a;
        return new d();
    }

    public fa.a n() {
        if (this.f9674i == null || this.f9666a == null) {
            return null;
        }
        ka.f fVar = new ka.f(this.f9666a, (this.f9669d & 8) != 0);
        if (!fVar.h()) {
            this.f9673h = this.f9671f;
            this.f9671f = null;
        } else if (o() && this.f9671f == null) {
            return null;
        }
        a.EnumC0166a enumC0166a = this.f9674i;
        ka.c cVar = this.f9667b;
        if (cVar == null) {
            cVar = ka.c.f11303f;
        }
        return new fa.a(enumC0166a, fVar, cVar, this.f9671f, this.f9673h, this.f9672g, this.f9668c, this.f9669d, this.f9670e);
    }
}
