package i9;

import i9.d;
import i9.e;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import y8.k;

/* loaded from: classes.dex */
public abstract class i implements d<Method> {

    /* renamed from: a, reason: collision with root package name */
    private final Type f10785a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f10786b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Type> f10787c;

    /* loaded from: classes.dex */
    public static final class a extends i implements c {

        /* renamed from: d, reason: collision with root package name */
        private final Object f10788d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.reflect.Method r3, java.lang.Object r4) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                y8.k.e(r3, r0)
                java.util.List r0 = m8.o.d()
                r1 = 0
                r2.<init>(r3, r0, r1)
                r2.f10788d = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.i.a.<init>(java.lang.reflect.Method, java.lang.Object):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            k.e(objArr, "args");
            e(objArr);
            return d(this.f10788d, objArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b(java.lang.reflect.Method r3) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                y8.k.e(r3, r0)
                java.lang.Class r0 = r3.getDeclaringClass()
                java.util.List r0 = m8.o.b(r0)
                r1 = 0
                r2.<init>(r3, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i9.i.b.<init>(java.lang.reflect.Method):void");
        }

        @Override // i9.d
        public Object a(Object[] objArr) {
            Object[] f10;
            k.e(objArr, "args");
            e(objArr);
            Object obj = objArr[0];
            e.d dVar = e.f10766e;
            if (objArr.length <= 1) {
                f10 = new Object[0];
            } else {
                f10 = m8.g.f(objArr, 1, objArr.length);
                Objects.requireNonNull(f10, "null cannot be cast to non-null type kotlin.Array<T>");
            }
            return d(obj, f10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private i(Method method, List<? extends Type> list) {
        this.f10786b = method;
        this.f10787c = list;
        Class<?> returnType = method.getReturnType();
        k.d(returnType, "unboxMethod.returnType");
        this.f10785a = returnType;
    }

    public /* synthetic */ i(Method method, List list, y8.g gVar) {
        this(method, list);
    }

    @Override // i9.d
    public final List<Type> b() {
        return this.f10787c;
    }

    protected final Object d(Object obj, Object[] objArr) {
        k.e(objArr, "args");
        return this.f10786b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void e(Object[] objArr) {
        k.e(objArr, "args");
        d.a.a(this, objArr);
    }

    @Override // i9.d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Method c() {
        return null;
    }

    @Override // i9.d
    public final Type i() {
        return this.f10785a;
    }
}
