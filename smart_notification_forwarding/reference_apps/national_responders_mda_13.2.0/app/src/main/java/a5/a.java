package a5;

import com.google.gson.x;
import com.google.gson.y;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a<E> extends x<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final y f191c = new C0009a();

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f192a;

    /* renamed from: b, reason: collision with root package name */
    private final x<E> f193b;

    /* renamed from: a5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0009a implements y {
        C0009a() {
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            Type e10 = aVar.e();
            if (!(e10 instanceof GenericArrayType) && (!(e10 instanceof Class) || !((Class) e10).isArray())) {
                return null;
            }
            Type g10 = z4.b.g(e10);
            return new a(eVar, eVar.k(e5.a.b(g10)), z4.b.k(g10));
        }
    }

    public a(com.google.gson.e eVar, x<E> xVar, Class<E> cls) {
        this.f193b = new m(eVar, xVar, cls);
        this.f192a = cls;
    }

    @Override // com.google.gson.x
    public Object b(f5.a aVar) {
        if (aVar.m0() == f5.b.NULL) {
            aVar.i0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.c();
        while (aVar.N()) {
            arrayList.add(this.f193b.b(aVar));
        }
        aVar.v();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f192a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    @Override // com.google.gson.x
    public void d(f5.c cVar, Object obj) {
        if (obj == null) {
            cVar.b0();
            return;
        }
        cVar.f();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f193b.d(cVar, Array.get(obj, i10));
        }
        cVar.v();
    }
}
