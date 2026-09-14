package a5;

import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class k implements y {

    /* renamed from: f, reason: collision with root package name */
    private final z4.c f229f;

    /* renamed from: g, reason: collision with root package name */
    private final com.google.gson.d f230g;

    /* renamed from: h, reason: collision with root package name */
    private final z4.d f231h;

    /* renamed from: i, reason: collision with root package name */
    private final e f232i;

    /* renamed from: j, reason: collision with root package name */
    private final c5.b f233j = c5.b.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Field f234d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f235e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f236f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f237g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ e5.a f238h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f239i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, String str, boolean z10, boolean z11, Field field, boolean z12, x xVar, com.google.gson.e eVar, e5.a aVar, boolean z13) {
            super(str, z10, z11);
            this.f234d = field;
            this.f235e = z12;
            this.f236f = xVar;
            this.f237g = eVar;
            this.f238h = aVar;
            this.f239i = z13;
        }

        @Override // a5.k.c
        void a(f5.a aVar, Object obj) {
            Object b10 = this.f236f.b(aVar);
            if (b10 == null && this.f239i) {
                return;
            }
            this.f234d.set(obj, b10);
        }

        @Override // a5.k.c
        void b(f5.c cVar, Object obj) {
            (this.f235e ? this.f236f : new m(this.f237g, this.f236f, this.f238h.e())).d(cVar, this.f234d.get(obj));
        }

        @Override // a5.k.c
        public boolean c(Object obj) {
            return this.f243b && this.f234d.get(obj) != obj;
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> extends x<T> {

        /* renamed from: a, reason: collision with root package name */
        private final z4.i<T> f240a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, c> f241b;

        b(z4.i<T> iVar, Map<String, c> map) {
            this.f240a = iVar;
            this.f241b = map;
        }

        @Override // com.google.gson.x
        public T b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            T a10 = this.f240a.a();
            try {
                aVar.d();
                while (aVar.N()) {
                    c cVar = this.f241b.get(aVar.g0());
                    if (cVar != null && cVar.f244c) {
                        cVar.a(aVar, a10);
                    }
                    aVar.w0();
                }
                aVar.D();
                return a10;
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            } catch (IllegalStateException e11) {
                throw new t(e11);
            }
        }

        @Override // com.google.gson.x
        public void d(f5.c cVar, T t10) {
            if (t10 == null) {
                cVar.b0();
                return;
            }
            cVar.g();
            try {
                for (c cVar2 : this.f241b.values()) {
                    if (cVar2.c(t10)) {
                        cVar.O(cVar2.f242a);
                        cVar2.b(cVar, t10);
                    }
                }
                cVar.D();
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String f242a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f243b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f244c;

        protected c(String str, boolean z10, boolean z11) {
            this.f242a = str;
            this.f243b = z10;
            this.f244c = z11;
        }

        abstract void a(f5.a aVar, Object obj);

        abstract void b(f5.c cVar, Object obj);

        abstract boolean c(Object obj);
    }

    public k(z4.c cVar, com.google.gson.d dVar, z4.d dVar2, e eVar) {
        this.f229f = cVar;
        this.f230g = dVar;
        this.f231h = dVar2;
        this.f232i = eVar;
    }

    private c b(com.google.gson.e eVar, Field field, String str, e5.a<?> aVar, boolean z10, boolean z11) {
        boolean a10 = z4.k.a(aVar.c());
        y4.b bVar = (y4.b) field.getAnnotation(y4.b.class);
        x<?> b10 = bVar != null ? this.f232i.b(this.f229f, eVar, aVar, bVar) : null;
        boolean z12 = b10 != null;
        if (b10 == null) {
            b10 = eVar.k(aVar);
        }
        return new a(this, str, z10, z11, field, z12, b10, eVar, aVar, a10);
    }

    static boolean d(Field field, boolean z10, z4.d dVar) {
        return (dVar.d(field.getType(), z10) || dVar.i(field, z10)) ? false : true;
    }

    private Map<String, c> e(com.google.gson.e eVar, e5.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type e10 = aVar.e();
        e5.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z10 = false;
            int i10 = 0;
            while (i10 < length) {
                Field field = declaredFields[i10];
                boolean c10 = c(field, true);
                boolean c11 = c(field, z10);
                if (c10 || c11) {
                    this.f233j.b(field);
                    Type p10 = z4.b.p(aVar2.e(), cls2, field.getGenericType());
                    List<String> f10 = f(field);
                    int size = f10.size();
                    c cVar = null;
                    int i11 = 0;
                    while (i11 < size) {
                        String str = f10.get(i11);
                        boolean z11 = i11 != 0 ? false : c10;
                        int i12 = i11;
                        c cVar2 = cVar;
                        int i13 = size;
                        List<String> list = f10;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, b(eVar, field, str, e5.a.b(p10), z11, c11)) : cVar2;
                        i11 = i12 + 1;
                        c10 = z11;
                        f10 = list;
                        size = i13;
                        field = field2;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(e10 + " declares multiple JSON fields named " + cVar3.f242a);
                    }
                }
                i10++;
                z10 = false;
            }
            aVar2 = e5.a.b(z4.b.p(aVar2.e(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.c();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        y4.c cVar = (y4.c) field.getAnnotation(y4.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f230g.translateName(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
        Class<? super T> c10 = aVar.c();
        if (Object.class.isAssignableFrom(c10)) {
            return new b(this.f229f.a(aVar), e(eVar, aVar, c10));
        }
        return null;
    }

    public boolean c(Field field, boolean z10) {
        return d(field, z10, this.f231h);
    }
}
