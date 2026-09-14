package i9;

import i9.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import l8.w;
import y8.k;
import y8.y;

/* loaded from: classes.dex */
public abstract class e<M extends Member> implements i9.d<M> {

    /* renamed from: e, reason: collision with root package name */
    public static final d f10766e = new d(null);

    /* renamed from: a, reason: collision with root package name */
    private final List<Type> f10767a;

    /* renamed from: b, reason: collision with root package name */
    private final M f10768b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f10769c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f10770d;

    /* loaded from: classes.dex */
    public static final class a extends e<Constructor<?>> implements i9.c {

        /* renamed from: f, reason: collision with root package name */
        private final Object f10771f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.reflect.Constructor<?> r8, java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                y8.k.e(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                y8.k.d(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                y8.k.d(r0, r1)
                int r1 = r0.length
                r2 = 2
                if (r1 > r2) goto L1f
                r0 = 0
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
                goto L2b
            L1f:
                int r1 = r0.length
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object[] r0 = m8.g.f(r0, r2, r1)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.util.Objects.requireNonNull(r0, r1)
            L2b:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f10771f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.a.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            Constructor<?> c10 = c();
            y yVar = new y(3);
            yVar.a(this.f10771f);
            yVar.b(objArr);
            yVar.a(null);
            return c10.newInstance(yVar.d(new Object[yVar.c()]));
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b(java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                y8.k.e(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                y8.k.d(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                y8.k.d(r0, r1)
                int r1 = r0.length
                r2 = 0
                r4 = 1
                if (r1 > r4) goto L1f
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r2]
                goto L2a
            L1f:
                int r1 = r0.length
                int r1 = r1 - r4
                java.lang.Object[] r0 = m8.g.f(r0, r2, r1)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.util.Objects.requireNonNull(r0, r1)
            L2a:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.b.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            Constructor<?> c10 = c();
            y yVar = new y(2);
            yVar.b(objArr);
            yVar.a(null);
            return c10.newInstance(yVar.d(new Object[yVar.c()]));
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e<Constructor<?>> implements i9.c {

        /* renamed from: f, reason: collision with root package name */
        private final Object f10772f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(java.lang.reflect.Constructor<?> r8, java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                y8.k.e(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                y8.k.d(r3, r0)
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                y8.k.d(r5, r0)
                r4 = 0
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f10772f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.c.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            Constructor<?> c10 = c();
            y yVar = new y(2);
            yVar.a(this.f10772f);
            yVar.b(objArr);
            return c10.newInstance(yVar.d(new Object[yVar.c()]));
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(y8.g gVar) {
            this();
        }
    }

    /* renamed from: i9.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0202e extends e<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public C0202e(java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                y8.k.e(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                y8.k.d(r3, r0)
                java.lang.Class r0 = r8.getDeclaringClass()
                java.lang.String r1 = "klass"
                y8.k.d(r0, r1)
                java.lang.Class r1 = r0.getDeclaringClass()
                if (r1 == 0) goto L29
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L29
                r4 = r1
                goto L2b
            L29:
                r0 = 0
                r4 = r0
            L2b:
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                y8.k.d(r5, r0)
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.C0202e.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            return c().newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f extends e<Field> {

        /* loaded from: classes.dex */
        public static final class a extends f implements i9.c {

            /* renamed from: f, reason: collision with root package name */
            private final Object f10773f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                k.e(field, "field");
                this.f10773f = obj;
            }

            @Override // i9.e.f, i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                return c().get(this.f10773f);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends f implements i9.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                k.e(field, "field");
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                k.e(field, "field");
            }
        }

        /* loaded from: classes.dex */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                k.e(field, "field");
            }

            @Override // i9.e
            public void d(Object[] objArr) {
                k.e(objArr, "args");
                super.d(objArr);
                e(m8.g.q(objArr));
            }
        }

        /* renamed from: i9.e$f$e, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0203e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0203e(Field field) {
                super(field, false, null);
                k.e(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private f(java.lang.reflect.Field r7, boolean r8) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericType()
                java.lang.String r0 = "field.genericType"
                y8.k.d(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r8 = 0
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r8]
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.f.<init>(java.lang.reflect.Field, boolean):void");
        }

        public /* synthetic */ f(Field field, boolean z10, y8.g gVar) {
            this(field, z10);
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            return c().get(f() != null ? m8.g.p(objArr) : null);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g extends e<Field> {

        /* renamed from: f, reason: collision with root package name */
        private final boolean f10774f;

        /* loaded from: classes.dex */
        public static final class a extends g implements i9.c {

            /* renamed from: g, reason: collision with root package name */
            private final Object f10775g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z10, Object obj) {
                super(field, z10, false, null);
                k.e(field, "field");
                this.f10775g = obj;
            }

            @Override // i9.e.g, i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                c().set(this.f10775g, m8.g.p(objArr));
                return w.f11824a;
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends g implements i9.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z10) {
                super(field, z10, false, null);
                k.e(field, "field");
            }

            @Override // i9.e.g, i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                c().set(null, m8.g.z(objArr));
                return w.f11824a;
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z10) {
                super(field, z10, true, null);
                k.e(field, "field");
            }
        }

        /* loaded from: classes.dex */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z10) {
                super(field, z10, true, null);
                k.e(field, "field");
            }

            @Override // i9.e.g, i9.e
            public void d(Object[] objArr) {
                k.e(objArr, "args");
                super.d(objArr);
                e(m8.g.q(objArr));
            }
        }

        /* renamed from: i9.e$g$e, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0204e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0204e(Field field, boolean z10) {
                super(field, z10, false, null);
                k.e(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private g(java.lang.reflect.Field r7, boolean r8, boolean r9) {
            /*
                r6 = this;
                java.lang.Class r2 = java.lang.Void.TYPE
                java.lang.String r0 = "Void.TYPE"
                y8.k.d(r2, r0)
                if (r9 == 0) goto Le
                java.lang.Class r9 = r7.getDeclaringClass()
                goto Lf
            Le:
                r9 = 0
            Lf:
                r3 = r9
                r9 = 1
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r9]
                r9 = 0
                java.lang.reflect.Type r0 = r7.getGenericType()
                java.lang.String r1 = "field.genericType"
                y8.k.d(r0, r1)
                r4[r9] = r0
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                r6.f10774f = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.g.<init>(java.lang.reflect.Field, boolean, boolean):void");
        }

        public /* synthetic */ g(Field field, boolean z10, boolean z11, y8.g gVar) {
            this(field, z10, z11);
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            d(objArr);
            c().set(f() != null ? m8.g.p(objArr) : null, m8.g.z(objArr));
            return w.f11824a;
        }

        @Override // i9.e
        public void d(Object[] objArr) {
            k.e(objArr, "args");
            super.d(objArr);
            if (this.f10774f && m8.g.z(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h extends e<Method> {

        /* renamed from: f, reason: collision with root package name */
        private final boolean f10776f;

        /* loaded from: classes.dex */
        public static final class a extends h implements i9.c {

            /* renamed from: g, reason: collision with root package name */
            private final Object f10777g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4, null);
                k.e(method, "method");
                this.f10777g = obj;
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                return g(this.f10777g, objArr);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends h implements i9.c {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4, null);
                k.e(method, "method");
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                return g(null, objArr);
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends h implements i9.c {

            /* renamed from: g, reason: collision with root package name */
            private final Object f10778g;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public c(java.lang.reflect.Method r5, java.lang.Object r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = "method"
                    y8.k.e(r5, r0)
                    java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
                    java.lang.String r1 = "method.genericParameterTypes"
                    y8.k.d(r0, r1)
                    int r1 = r0.length
                    r2 = 1
                    r3 = 0
                    if (r1 > r2) goto L16
                    java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r3]
                    goto L20
                L16:
                    int r1 = r0.length
                    java.lang.Object[] r0 = m8.g.f(r0, r2, r1)
                    java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                    java.util.Objects.requireNonNull(r0, r1)
                L20:
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r1 = 0
                    r4.<init>(r5, r3, r0, r1)
                    r4.f10778g = r6
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i9.e.h.c.<init>(java.lang.reflect.Method, java.lang.Object):void");
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                y yVar = new y(2);
                yVar.a(this.f10778g);
                yVar.b(objArr);
                return g(null, yVar.d(new Object[yVar.c()]));
            }
        }

        /* loaded from: classes.dex */
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, null, 6, null);
                k.e(method, "method");
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                Object[] f10;
                k.e(objArr, "args");
                d(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    f10 = new Object[0];
                } else {
                    f10 = m8.g.f(objArr, 1, objArr.length);
                    Objects.requireNonNull(f10, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return g(obj, f10);
            }
        }

        /* renamed from: i9.e$h$e, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0205e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0205e(Method method) {
                super(method, true, null, 4, null);
                k.e(method, "method");
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                Object[] f10;
                k.e(objArr, "args");
                d(objArr);
                e(m8.g.q(objArr));
                if (objArr.length <= 1) {
                    f10 = new Object[0];
                } else {
                    f10 = m8.g.f(objArr, 1, objArr.length);
                    Objects.requireNonNull(f10, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return g(null, f10);
            }
        }

        /* loaded from: classes.dex */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, null, 6, null);
                k.e(method, "method");
            }

            @Override // i9.d
            public Object a(Object[] objArr) {
                k.e(objArr, "args");
                d(objArr);
                return g(null, objArr);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private h(java.lang.reflect.Method r7, boolean r8, java.lang.reflect.Type[] r9) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericReturnType()
                java.lang.String r0 = "method.genericReturnType"
                y8.k.d(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r5 = 0
                r0 = r6
                r1 = r7
                r4 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                java.lang.reflect.Type r7 = r6.i()
                java.lang.Class r8 = java.lang.Void.TYPE
                boolean r7 = y8.k.a(r7, r8)
                r6.f10776f = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[]):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        /* synthetic */ h(java.lang.reflect.Method r1, boolean r2, java.lang.reflect.Type[] r3, int r4, y8.g r5) {
            /*
                r0 = this;
                r5 = r4 & 2
                if (r5 == 0) goto Le
                int r2 = r1.getModifiers()
                boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
                r2 = r2 ^ 1
            Le:
                r4 = r4 & 4
                if (r4 == 0) goto L1b
                java.lang.reflect.Type[] r3 = r1.getGenericParameterTypes()
                java.lang.String r4 = "method.genericParameterTypes"
                y8.k.d(r3, r4)
            L1b:
                r0.<init>(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.e.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[], int, y8.g):void");
        }

        public /* synthetic */ h(Method method, boolean z10, Type[] typeArr, y8.g gVar) {
            this(method, z10, typeArr);
        }

        protected final Object g(Object obj, Object[] objArr) {
            k.e(objArr, "args");
            return this.f10776f ? w.f11824a : c().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0027, code lost:
    
        if (r1 != null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private e(M r1, java.lang.reflect.Type r2, java.lang.Class<?> r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.f10768b = r1
            r0.f10769c = r2
            r0.f10770d = r3
            if (r3 == 0) goto L2a
            y8.y r1 = new y8.y
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.lang.reflect.Type[] r1 = (java.lang.reflect.Type[]) r1
            java.util.List r1 = m8.o.g(r1)
            if (r1 == 0) goto L2a
            goto L2e
        L2a:
            java.util.List r1 = m8.g.O(r4)
        L2e:
            r0.f10767a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.e.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    public /* synthetic */ e(Member member, Type type, Class cls, Type[] typeArr, y8.g gVar) {
        this(member, type, cls, typeArr);
    }

    @Override // i9.d
    public List<Type> b() {
        return this.f10767a;
    }

    @Override // i9.d
    public final M c() {
        return this.f10768b;
    }

    public void d(Object[] objArr) {
        k.e(objArr, "args");
        d.a.a(this, objArr);
    }

    protected final void e(Object obj) {
        if (obj == null || !this.f10768b.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final Class<?> f() {
        return this.f10770d;
    }

    @Override // i9.d
    public final Type i() {
        return this.f10769c;
    }
}
