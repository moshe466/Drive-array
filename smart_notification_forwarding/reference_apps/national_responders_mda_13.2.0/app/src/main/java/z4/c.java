package z4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.g<?>> f16166a;

    /* renamed from: b, reason: collision with root package name */
    private final c5.b f16167b = c5.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class a<T> implements z4.i<T> {
        a(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class b<T> implements z4.i<T> {
        b(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: z4.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0342c<T> implements z4.i<T> {
        C0342c(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class d<T> implements z4.i<T> {
        d(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new z4.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class e<T> implements z4.i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final z4.m f16168a = z4.m.b();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f16169b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f16170c;

        e(c cVar, Class cls, Type type) {
            this.f16169b = cls;
            this.f16170c = type;
        }

        @Override // z4.i
        public T a() {
            try {
                return (T) this.f16168a.c(this.f16169b);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f16170c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class f<T> implements z4.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f16171a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f16172b;

        f(c cVar, com.google.gson.g gVar, Type type) {
            this.f16171a = gVar;
            this.f16172b = type;
        }

        @Override // z4.i
        public T a() {
            return (T) this.f16171a.a(this.f16172b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class g<T> implements z4.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.g f16173a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f16174b;

        g(c cVar, com.google.gson.g gVar, Type type) {
            this.f16173a = gVar;
            this.f16174b = type;
        }

        @Override // z4.i
        public T a() {
            return (T) this.f16173a.a(this.f16174b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class h<T> implements z4.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f16175a;

        h(c cVar, Constructor constructor) {
            this.f16175a = constructor;
        }

        @Override // z4.i
        public T a() {
            try {
                return (T) this.f16175a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke " + this.f16175a + " with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke " + this.f16175a + " with no args", e12.getTargetException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class i<T> implements z4.i<T> {
        i(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class j<T> implements z4.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f16176a;

        j(c cVar, Type type) {
            this.f16176a = type;
        }

        @Override // z4.i
        public T a() {
            Type type = this.f16176a;
            if (!(type instanceof ParameterizedType)) {
                throw new com.google.gson.l("Invalid EnumSet type: " + this.f16176a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new com.google.gson.l("Invalid EnumSet type: " + this.f16176a.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class k<T> implements z4.i<T> {
        k(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class l<T> implements z4.i<T> {
        l(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class m<T> implements z4.i<T> {
        m(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public class n<T> implements z4.i<T> {
        n(c cVar) {
        }

        @Override // z4.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, com.google.gson.g<?>> map) {
        this.f16166a = map;
    }

    private <T> z4.i<T> b(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f16167b.b(declaredConstructor);
            }
            return new h(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> z4.i<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new i(this) : EnumSet.class.isAssignableFrom(cls) ? new j(this, type) : Set.class.isAssignableFrom(cls) ? new k(this) : Queue.class.isAssignableFrom(cls) ? new l(this) : new m(this);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new n(this) : ConcurrentMap.class.isAssignableFrom(cls) ? new a(this) : SortedMap.class.isAssignableFrom(cls) ? new b(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(e5.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new d(this) : new C0342c(this);
        }
        return null;
    }

    private <T> z4.i<T> d(Type type, Class<? super T> cls) {
        return new e(this, cls, type);
    }

    public <T> z4.i<T> a(e5.a<T> aVar) {
        Type e10 = aVar.e();
        Class<? super T> c10 = aVar.c();
        com.google.gson.g<?> gVar = this.f16166a.get(e10);
        if (gVar != null) {
            return new f(this, gVar, e10);
        }
        com.google.gson.g<?> gVar2 = this.f16166a.get(c10);
        if (gVar2 != null) {
            return new g(this, gVar2, e10);
        }
        z4.i<T> b10 = b(c10);
        if (b10 != null) {
            return b10;
        }
        z4.i<T> c11 = c(e10, c10);
        return c11 != null ? c11 : d(e10, c10);
    }

    public String toString() {
        return this.f16166a.toString();
    }
}
