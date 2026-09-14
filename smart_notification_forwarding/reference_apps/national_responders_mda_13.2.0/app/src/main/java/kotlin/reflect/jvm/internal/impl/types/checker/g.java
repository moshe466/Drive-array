package kotlin.reflect.jvm.internal.impl.types.checker;

import bb.b0;
import bb.t0;
import java.util.Collection;
import n9.d0;

/* loaded from: classes.dex */
public abstract class g {

    /* loaded from: classes.dex */
    public static final class a extends g {

        /* renamed from: a, reason: collision with root package name */
        public static final a f11566a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public n9.e a(la.a aVar) {
            y8.k.e(aVar, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public <S extends ua.h> S b(n9.e eVar, x8.a<? extends S> aVar) {
            y8.k.e(eVar, "classDescriptor");
            y8.k.e(aVar, "compute");
            return aVar.b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean c(d0 d0Var) {
            y8.k.e(d0Var, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean d(t0 t0Var) {
            y8.k.e(t0Var, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public Collection<b0> f(n9.e eVar) {
            y8.k.e(eVar, "classDescriptor");
            Collection<b0> x10 = eVar.o().x();
            y8.k.d(x10, "classDescriptor.typeConstructor.supertypes");
            return x10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public b0 g(b0 b0Var) {
            y8.k.e(b0Var, "type");
            return b0Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public n9.e e(n9.m mVar) {
            y8.k.e(mVar, "descriptor");
            return null;
        }
    }

    public abstract n9.e a(la.a aVar);

    public abstract <S extends ua.h> S b(n9.e eVar, x8.a<? extends S> aVar);

    public abstract boolean c(d0 d0Var);

    public abstract boolean d(t0 t0Var);

    public abstract n9.h e(n9.m mVar);

    public abstract Collection<b0> f(n9.e eVar);

    public abstract b0 g(b0 b0Var);
}
