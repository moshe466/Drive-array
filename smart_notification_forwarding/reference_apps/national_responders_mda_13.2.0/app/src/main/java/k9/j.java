package k9;

import bb.b0;
import bb.c0;
import bb.n0;
import java.util.List;
import k9.k;
import kotlin.reflect.KProperty;
import m8.p;
import mb.r;
import n9.a1;
import n9.d0;
import n9.f0;
import n9.w;
import y8.t;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static final b f11228d = new b(null);

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f11229e;

    /* renamed from: a, reason: collision with root package name */
    private final f0 f11230a;

    /* renamed from: b, reason: collision with root package name */
    private final l8.h f11231b;

    /* renamed from: c, reason: collision with root package name */
    private final a f11232c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f11233a;

        public a(int i10) {
            this.f11233a = i10;
        }

        public final n9.e a(j jVar, e9.j<?> jVar2) {
            String k10;
            y8.k.e(jVar, "types");
            y8.k.e(jVar2, "property");
            k10 = r.k(jVar2.c());
            return jVar.b(k10, this.f11233a);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(y8.g gVar) {
            this();
        }

        public final b0 a(d0 d0Var) {
            List b10;
            y8.k.e(d0Var, "module");
            n9.e a10 = w.a(d0Var, k.a.Z);
            if (a10 == null) {
                return null;
            }
            c0 c0Var = c0.f4165a;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
            List<a1> B = a10.o().B();
            y8.k.d(B, "kPropertyClass.typeConstructor.parameters");
            Object d02 = m8.o.d0(B);
            y8.k.d(d02, "kPropertyClass.typeConstructor.parameters.single()");
            b10 = p.b(new n0((a1) d02));
            return c0.g(b11, a10, b10);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<ua.h> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0 f11234f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d0 d0Var) {
            super(0);
            this.f11234f = d0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ua.h b() {
            return this.f11234f.C(k.f11243i).A();
        }
    }

    static {
        e9.j[] jVarArr = new e9.j[9];
        jVarArr[1] = y8.w.g(new t(y8.w.b(j.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[2] = y8.w.g(new t(y8.w.b(j.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[3] = y8.w.g(new t(y8.w.b(j.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[4] = y8.w.g(new t(y8.w.b(j.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[5] = y8.w.g(new t(y8.w.b(j.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[6] = y8.w.g(new t(y8.w.b(j.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[7] = y8.w.g(new t(y8.w.b(j.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        jVarArr[8] = y8.w.g(new t(y8.w.b(j.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f11229e = jVarArr;
    }

    public j(d0 d0Var, f0 f0Var) {
        l8.h a10;
        y8.k.e(d0Var, "module");
        y8.k.e(f0Var, "notFoundClasses");
        this.f11230a = f0Var;
        a10 = l8.j.a(kotlin.b.PUBLICATION, new c(d0Var));
        this.f11231b = a10;
        this.f11232c = new a(1);
        new a(1);
        new a(1);
        new a(2);
        new a(3);
        new a(1);
        new a(2);
        new a(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n9.e b(String str, int i10) {
        List<Integer> b10;
        la.e r10 = la.e.r(str);
        y8.k.d(r10, "identifier(className)");
        n9.h g10 = d().g(r10, u9.d.FROM_REFLECTION);
        n9.e eVar = g10 instanceof n9.e ? (n9.e) g10 : null;
        if (eVar != null) {
            return eVar;
        }
        f0 f0Var = this.f11230a;
        la.a aVar = new la.a(k.f11243i, r10);
        b10 = p.b(Integer.valueOf(i10));
        return f0Var.d(aVar, b10);
    }

    private final ua.h d() {
        return (ua.h) this.f11231b.getValue();
    }

    public final n9.e c() {
        return this.f11232c.a(this, f11229e[1]);
    }
}
