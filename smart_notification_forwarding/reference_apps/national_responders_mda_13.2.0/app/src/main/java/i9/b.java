package i9;

import h9.b0;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m8.r;
import m8.y;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends l implements x8.l<Object, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f10752f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f10753g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Map f10754h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls, List list, Map map) {
            super(1);
            this.f10752f = cls;
            this.f10753g = list;
            this.f10754h = map;
        }

        public final boolean a(Object obj) {
            boolean a10;
            boolean z10;
            e9.b a11;
            Class cls = null;
            Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
            if (annotation != null && (a11 = w8.a.a(annotation)) != null) {
                cls = w8.a.b(a11);
            }
            if (k.a(cls, this.f10752f)) {
                List<Method> list = this.f10753g;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (Method method : list) {
                        Object obj2 = this.f10754h.get(method.getName());
                        Object invoke = method.invoke(obj, new Object[0]);
                        if (obj2 instanceof boolean[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                            a10 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                        } else if (obj2 instanceof char[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                            a10 = Arrays.equals((char[]) obj2, (char[]) invoke);
                        } else if (obj2 instanceof byte[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                            a10 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                        } else if (obj2 instanceof short[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                            a10 = Arrays.equals((short[]) obj2, (short[]) invoke);
                        } else if (obj2 instanceof int[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                            a10 = Arrays.equals((int[]) obj2, (int[]) invoke);
                        } else if (obj2 instanceof float[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                            a10 = Arrays.equals((float[]) obj2, (float[]) invoke);
                        } else if (obj2 instanceof long[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                            a10 = Arrays.equals((long[]) obj2, (long[]) invoke);
                        } else if (obj2 instanceof double[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                            a10 = Arrays.equals((double[]) obj2, (double[]) invoke);
                        } else if (obj2 instanceof Object[]) {
                            Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                            a10 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                        } else {
                            a10 = k.a(obj2, invoke);
                        }
                        if (!a10) {
                            z10 = false;
                            break;
                        }
                    }
                }
                z10 = true;
                if (z10) {
                    return true;
                }
            }
            return false;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Object obj) {
            return Boolean.valueOf(a(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i9.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0201b extends l implements x8.a<Integer> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f10755f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0201b(Map map) {
            super(0);
            this.f10755f = map;
        }

        public final int a() {
            int i10 = 0;
            for (Map.Entry entry : this.f10755f.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                i10 += (value instanceof boolean[] ? Arrays.hashCode((boolean[]) value) : value instanceof char[] ? Arrays.hashCode((char[]) value) : value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value instanceof short[] ? Arrays.hashCode((short[]) value) : value instanceof int[] ? Arrays.hashCode((int[]) value) : value instanceof float[] ? Arrays.hashCode((float[]) value) : value instanceof long[] ? Arrays.hashCode((long[]) value) : value instanceof double[] ? Arrays.hashCode((double[]) value) : value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode()) ^ (str.hashCode() * 127);
            }
            return i10;
        }

        @Override // x8.a
        public /* bridge */ /* synthetic */ Integer b() {
            return Integer.valueOf(a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f10756a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l8.h f10757b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e9.j f10758c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l8.h f10759d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e9.j f10760e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f10761f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f10762g;

        c(Class cls, l8.h hVar, e9.j jVar, l8.h hVar2, e9.j jVar2, a aVar, Map map) {
            this.f10756a = cls;
            this.f10757b = hVar;
            this.f10758c = jVar;
            this.f10759d = hVar2;
            this.f10760e = jVar2;
            this.f10761f = aVar;
            this.f10762g = map;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            List O;
            l8.h hVar;
            k.d(method, "method");
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.f10756a;
                        }
                    } else if (name.equals("hashCode")) {
                        hVar = this.f10759d;
                        return hVar.getValue();
                    }
                } else if (name.equals("toString")) {
                    hVar = this.f10757b;
                    return hVar.getValue();
                }
            }
            if (k.a(name, "equals") && objArr != null && objArr.length == 1) {
                return Boolean.valueOf(this.f10761f.a(m8.g.D(objArr)));
            }
            if (this.f10762g.containsKey(name)) {
                return this.f10762g.get(name);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Method is not supported: ");
            sb2.append(method);
            sb2.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            O = m8.k.O(objArr);
            sb2.append(O);
            sb2.append(')');
            throw new b0(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends l implements x8.a<String> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class f10763f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f10764g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class a extends l implements x8.l<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f10765f = new a();

            a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final CharSequence h(Map.Entry<String, ? extends Object> entry) {
                k.e(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                return key + '=' + (value instanceof boolean[] ? Arrays.toString((boolean[]) value) : value instanceof char[] ? Arrays.toString((char[]) value) : value instanceof byte[] ? Arrays.toString((byte[]) value) : value instanceof short[] ? Arrays.toString((short[]) value) : value instanceof int[] ? Arrays.toString((int[]) value) : value instanceof float[] ? Arrays.toString((float[]) value) : value instanceof long[] ? Arrays.toString((long[]) value) : value instanceof double[] ? Arrays.toString((double[]) value) : value instanceof Object[] ? Arrays.toString((Object[]) value) : value.toString());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Class cls, Map map) {
            super(0);
            this.f10763f = cls;
            this.f10764g = map;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String b() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('@');
            sb2.append(this.f10763f.getCanonicalName());
            y.O(this.f10764g.entrySet(), sb2, ", ", "(", ")", 0, null, a.f10765f, 48, null);
            String sb3 = sb2.toString();
            k.d(sb3, "StringBuilder().apply(builderAction).toString()");
            return sb3;
        }
    }

    public static final <T> T c(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        l8.h b10;
        l8.h b11;
        k.e(cls, "annotationClass");
        k.e(map, "values");
        k.e(list, "methods");
        a aVar = new a(cls, list, map);
        b10 = l8.j.b(new C0201b(map));
        b11 = l8.j.b(new d(cls, map));
        T t10 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, b11, null, b10, null, aVar, map));
        Objects.requireNonNull(t10, "null cannot be cast to non-null type T");
        return t10;
    }

    public static /* synthetic */ Object d(Class cls, Map map, List list, int i10, Object obj) {
        int n10;
        if ((i10 & 4) != 0) {
            Set keySet = map.keySet();
            n10 = r.n(keySet, 10);
            ArrayList arrayList = new ArrayList(n10);
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return c(cls, map, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Void e(int r3, java.lang.String r4, java.lang.Class<?> r5) {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            boolean r0 = y8.k.a(r5, r0)
            if (r0 == 0) goto Lf
            java.lang.Class<e9.b> r5 = e9.b.class
        La:
            e9.b r5 = y8.w.b(r5)
            goto L28
        Lf:
            boolean r0 = r5.isArray()
            if (r0 == 0) goto L24
            java.lang.Class r0 = r5.getComponentType()
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            boolean r0 = y8.k.a(r0, r1)
            if (r0 == 0) goto L24
            java.lang.Class<e9.b[]> r5 = e9.b[].class
            goto La
        L24:
            e9.b r5 = w8.a.e(r5)
        L28:
            java.lang.String r0 = r5.a()
            java.lang.Class<java.lang.Object[]> r1 = java.lang.Object[].class
            e9.b r1 = y8.w.b(r1)
            java.lang.String r1 = r1.a()
            boolean r0 = y8.k.a(r0, r1)
            if (r0 == 0) goto L6f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r5.a()
            r0.append(r1)
            r1 = 60
            r0.append(r1)
            java.lang.Class r5 = w8.a.b(r5)
            java.lang.Class r5 = r5.getComponentType()
            java.lang.String r1 = "kotlinClass.java.componentType"
            y8.k.d(r5, r1)
            e9.b r5 = w8.a.e(r5)
            java.lang.String r5 = r5.a()
            r0.append(r5)
            r5 = 62
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            goto L73
        L6f:
            java.lang.String r5 = r5.a()
        L73:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Argument #"
            r1.append(r2)
            r1.append(r3)
            r3 = 32
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = " is not of the required type "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b.e(int, java.lang.String, java.lang.Class):java.lang.Void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof e9.b) {
            obj = w8.a.b((e9.b) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof e9.b[]) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                e9.b[] bVarArr = (e9.b[]) obj;
                ArrayList arrayList = new ArrayList(bVarArr.length);
                for (e9.b bVar : bVarArr) {
                    arrayList.add(w8.a.b(bVar));
                }
                obj = arrayList.toArray(new Class[0]);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
