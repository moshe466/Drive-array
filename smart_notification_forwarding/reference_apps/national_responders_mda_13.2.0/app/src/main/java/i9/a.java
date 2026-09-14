package i9;

import i9.d;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m8.l0;
import m8.r;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final List<Type> f10745a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Class<?>> f10746b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Object> f10747c;

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f10748d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f10749e;

    /* renamed from: f, reason: collision with root package name */
    private final EnumC0200a f10750f;

    /* renamed from: g, reason: collision with root package name */
    private final List<Method> f10751g;

    /* renamed from: i9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0200a {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    /* loaded from: classes.dex */
    public enum b {
        JAVA,
        KOTLIN
    }

    public a(Class<?> cls, List<String> list, EnumC0200a enumC0200a, b bVar, List<Method> list2) {
        int n10;
        int n11;
        int n12;
        List X;
        k.e(cls, "jClass");
        k.e(list, "parameterNames");
        k.e(enumC0200a, "callMode");
        k.e(bVar, "origin");
        k.e(list2, "methods");
        this.f10748d = cls;
        this.f10749e = list;
        this.f10750f = enumC0200a;
        this.f10751g = list2;
        n10 = r.n(list2, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f10745a = arrayList;
        List<Method> list3 = this.f10751g;
        n11 = r.n(list3, 10);
        ArrayList arrayList2 = new ArrayList(n11);
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            k.d(returnType, "it");
            Class<?> g10 = s9.b.g(returnType);
            if (g10 != null) {
                returnType = g10;
            }
            arrayList2.add(returnType);
        }
        this.f10746b = arrayList2;
        List<Method> list4 = this.f10751g;
        n12 = r.n(list4, 10);
        ArrayList arrayList3 = new ArrayList(n12);
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f10747c = arrayList3;
        if (this.f10750f == EnumC0200a.POSITIONAL_CALL && bVar == b.JAVA) {
            X = y.X(this.f10749e, "value");
            if (!X.isEmpty()) {
                throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.Class r7, java.util.List r8, i9.a.EnumC0200a r9, i9.a.b r10, java.util.List r11, int r12, y8.g r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L2a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = m8.o.n(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L13:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L2a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L13
        L2a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.a.<init>(java.lang.Class, java.util.List, i9.a$a, i9.a$b, java.util.List, int, y8.g):void");
    }

    @Override // i9.d
    public Object a(Object[] objArr) {
        List u02;
        Map p10;
        k.e(objArr, "args");
        d(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            int i12 = i11 + 1;
            Object f10 = (obj == null && this.f10750f == EnumC0200a.CALL_BY_NAME) ? this.f10747c.get(i11) : i9.b.f(obj, this.f10746b.get(i11));
            if (f10 == null) {
                i9.b.e(i11, this.f10749e.get(i11), this.f10746b.get(i11));
                throw null;
            }
            arrayList.add(f10);
            i10++;
            i11 = i12;
        }
        Class<?> cls = this.f10748d;
        u02 = y.u0(this.f10749e, arrayList);
        p10 = l0.p(u02);
        return i9.b.c(cls, p10, this.f10751g);
    }

    @Override // i9.d
    public List<Type> b() {
        return this.f10745a;
    }

    @Override // i9.d
    public /* bridge */ /* synthetic */ Member c() {
        return (Member) e();
    }

    public void d(Object[] objArr) {
        k.e(objArr, "args");
        d.a.a(this, objArr);
    }

    public Void e() {
        return null;
    }

    @Override // i9.d
    public Type i() {
        return this.f10748d;
    }
}
