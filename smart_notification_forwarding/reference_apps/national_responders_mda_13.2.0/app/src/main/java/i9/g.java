package i9;

import h9.k0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import y8.k;

/* loaded from: classes.dex */
public final class g<M extends Member> implements d<M> {

    /* renamed from: a, reason: collision with root package name */
    private final a f10779a;

    /* renamed from: b, reason: collision with root package name */
    private final d<M> f10780b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f10781c;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final d9.c f10782a;

        /* renamed from: b, reason: collision with root package name */
        private final Method[] f10783b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f10784c;

        public a(d9.c cVar, Method[] methodArr, Method method) {
            k.e(cVar, "argumentRange");
            k.e(methodArr, "unbox");
            this.f10782a = cVar;
            this.f10783b = methodArr;
            this.f10784c = method;
        }

        public final d9.c a() {
            return this.f10782a;
        }

        public final Method[] b() {
            return this.f10783b;
        }

        public final Method c() {
            return this.f10784c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if ((r9 instanceof i9.c) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c8, code lost:
    
        if (na.f.b(r2) != false) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e4 A[LOOP:0: B:36:0x00de->B:38:0x00e4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(n9.b r8, i9.d<? extends M> r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.g.<init>(n9.b, i9.d, boolean):void");
    }

    @Override // i9.d
    public Object a(Object[] objArr) {
        Object invoke;
        k.e(objArr, "args");
        a aVar = this.f10779a;
        d9.c a10 = aVar.a();
        Method[] b10 = aVar.b();
        Method c10 = aVar.c();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        k.d(copyOf, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int c11 = a10.c();
        int f10 = a10.f();
        if (c11 <= f10) {
            while (true) {
                Method method = b10[c11];
                Object obj = objArr[c11];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        k.d(returnType, "method.returnType");
                        obj = k0.d(returnType);
                    }
                }
                copyOf[c11] = obj;
                if (c11 == f10) {
                    break;
                }
                c11++;
            }
        }
        Object a11 = this.f10780b.a(copyOf);
        return (c10 == null || (invoke = c10.invoke(null, a11)) == null) ? a11 : invoke;
    }

    @Override // i9.d
    public List<Type> b() {
        return this.f10780b.b();
    }

    @Override // i9.d
    public M c() {
        return this.f10780b.c();
    }

    @Override // i9.d
    public Type i() {
        return this.f10780b.i();
    }
}
