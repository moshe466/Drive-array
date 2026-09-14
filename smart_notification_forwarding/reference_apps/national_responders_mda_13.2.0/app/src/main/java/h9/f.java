package h9;

import e9.g;
import h9.d0;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import n9.a1;
import n9.d1;
import n9.m0;
import n9.s0;

/* loaded from: classes.dex */
public abstract class f<R> implements e9.a<R>, a0 {

    /* renamed from: f, reason: collision with root package name */
    private final d0.a<ArrayList<e9.g>> f10530f;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends Annotation>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Annotation> b() {
            return k0.c(f.this.p());
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements x8.a<ArrayList<e9.g>> {

        /* loaded from: classes.dex */
        public static final class a<T> implements Comparator<T> {
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                int a10;
                a10 = o8.b.a(((e9.g) t10).c(), ((e9.g) t11).c());
                return a10;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h9.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0190b extends y8.l implements x8.a<m0> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ s0 f10533f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0190b(s0 s0Var) {
                super(0);
                this.f10533f = s0Var;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m0 b() {
                return this.f10533f;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class c extends y8.l implements x8.a<m0> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ s0 f10534f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(s0 s0Var) {
                super(0);
                this.f10534f = s0Var;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m0 b() {
                return this.f10534f;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class d extends y8.l implements x8.a<m0> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ n9.b f10535f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f10536g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(n9.b bVar, int i10) {
                super(0);
                this.f10535f = bVar;
                this.f10536g = i10;
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final m0 b() {
                d1 d1Var = this.f10535f.l().get(this.f10536g);
                y8.k.d(d1Var, "descriptor.valueParameters[i]");
                return d1Var;
            }
        }

        b() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList<e9.g> b() {
            int i10;
            n9.b p10 = f.this.p();
            ArrayList<e9.g> arrayList = new ArrayList<>();
            int i11 = 0;
            if (f.this.o()) {
                i10 = 0;
            } else {
                s0 f10 = k0.f(p10);
                if (f10 != null) {
                    arrayList.add(new q(f.this, 0, g.a.INSTANCE, new C0190b(f10)));
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                s0 U = p10.U();
                if (U != null) {
                    arrayList.add(new q(f.this, i10, g.a.EXTENSION_RECEIVER, new c(U)));
                    i10++;
                }
            }
            List<d1> l10 = p10.l();
            y8.k.d(l10, "descriptor.valueParameters");
            int size = l10.size();
            while (i11 < size) {
                arrayList.add(new q(f.this, i10, g.a.VALUE, new d(p10, i11)));
                i11++;
                i10++;
            }
            if (f.this.n() && (p10 instanceof x9.b) && arrayList.size() > 1) {
                m8.u.q(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends y8.l implements x8.a<x> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends y8.l implements x8.a<Type> {
            a() {
                super(0);
            }

            @Override // x8.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type b() {
                Type i10 = f.this.i();
                return i10 != null ? i10 : f.this.j().i();
            }
        }

        c() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x b() {
            bb.b0 i10 = f.this.p().i();
            y8.k.b(i10);
            y8.k.d(i10, "descriptor.returnType!!");
            return new x(i10, new a());
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.a<List<? extends z>> {
        d() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<z> b() {
            int n10;
            List<a1> m10 = f.this.p().m();
            y8.k.d(m10, "descriptor.typeParameters");
            n10 = m8.r.n(m10, 10);
            ArrayList arrayList = new ArrayList(n10);
            for (a1 a1Var : m10) {
                f fVar = f.this;
                y8.k.d(a1Var, "descriptor");
                arrayList.add(new z(fVar, a1Var));
            }
            return arrayList;
        }
    }

    public f() {
        y8.k.d(d0.d(new a()), "ReflectProperties.lazySo…or.computeAnnotations() }");
        d0.a<ArrayList<e9.g>> d10 = d0.d(new b());
        y8.k.d(d10, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.f10530f = d10;
        y8.k.d(d0.d(new c()), "ReflectProperties.lazySo…eturnType\n        }\n    }");
        y8.k.d(d0.d(new d()), "ReflectProperties.lazySo…this, descriptor) }\n    }");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type i() {
        Type[] lowerBounds;
        n9.b p10 = p();
        if (!(p10 instanceof n9.x)) {
            p10 = null;
        }
        n9.x xVar = (n9.x) p10;
        if (xVar == null || !xVar.q0()) {
            return null;
        }
        Object U = m8.o.U(j().b());
        if (!(U instanceof ParameterizedType)) {
            U = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) U;
        if (!y8.k.a(parameterizedType != null ? parameterizedType.getRawType() : null, p8.d.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        y8.k.d(actualTypeArguments, "continuationType.actualTypeArguments");
        Object D = m8.g.D(actualTypeArguments);
        if (!(D instanceof WildcardType)) {
            D = null;
        }
        WildcardType wildcardType = (WildcardType) D;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) m8.g.p(lowerBounds);
    }

    @Override // e9.a
    public R a(Object... objArr) {
        y8.k.e(objArr, "args");
        try {
            return (R) j().a(objArr);
        } catch (IllegalAccessException e10) {
            throw new f9.a(e10);
        }
    }

    public abstract i9.d<?> j();

    public abstract j k();

    /* renamed from: l */
    public abstract n9.b p();

    public List<e9.g> m() {
        ArrayList<e9.g> b10 = this.f10530f.b();
        y8.k.d(b10, "_parameters()");
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        return y8.k.a(c(), "<init>") && k().b().isAnnotation();
    }

    public abstract boolean o();
}
