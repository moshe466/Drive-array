package z4;

import com.google.gson.x;
import com.google.gson.y;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements y, Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public static final d f16177l = new d();

    /* renamed from: i, reason: collision with root package name */
    private boolean f16181i;

    /* renamed from: f, reason: collision with root package name */
    private double f16178f = -1.0d;

    /* renamed from: g, reason: collision with root package name */
    private int f16179g = 136;

    /* renamed from: h, reason: collision with root package name */
    private boolean f16180h = true;

    /* renamed from: j, reason: collision with root package name */
    private List<com.google.gson.a> f16182j = Collections.emptyList();

    /* renamed from: k, reason: collision with root package name */
    private List<com.google.gson.a> f16183k = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    class a<T> extends x<T> {

        /* renamed from: a, reason: collision with root package name */
        private x<T> f16184a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16185b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f16186c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f16187d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e5.a f16188e;

        a(boolean z10, boolean z11, com.google.gson.e eVar, e5.a aVar) {
            this.f16185b = z10;
            this.f16186c = z11;
            this.f16187d = eVar;
            this.f16188e = aVar;
        }

        private x<T> e() {
            x<T> xVar = this.f16184a;
            if (xVar != null) {
                return xVar;
            }
            x<T> m10 = this.f16187d.m(d.this, this.f16188e);
            this.f16184a = m10;
            return m10;
        }

        @Override // com.google.gson.x
        public T b(f5.a aVar) {
            if (!this.f16185b) {
                return e().b(aVar);
            }
            aVar.w0();
            return null;
        }

        @Override // com.google.gson.x
        public void d(f5.c cVar, T t10) {
            if (this.f16186c) {
                cVar.b0();
            } else {
                e().d(cVar, t10);
            }
        }
    }

    private boolean e(Class<?> cls) {
        if (this.f16178f == -1.0d || p((y4.d) cls.getAnnotation(y4.d.class), (y4.e) cls.getAnnotation(y4.e.class))) {
            return (!this.f16180h && l(cls)) || k(cls);
        }
        return true;
    }

    private boolean h(Class<?> cls, boolean z10) {
        Iterator<com.google.gson.a> it = (z10 ? this.f16182j : this.f16183k).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean k(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || m(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean l(Class<?> cls) {
        return cls.isMemberClass() && !m(cls);
    }

    private boolean m(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean n(y4.d dVar) {
        return dVar == null || dVar.value() <= this.f16178f;
    }

    private boolean o(y4.e eVar) {
        return eVar == null || eVar.value() > this.f16178f;
    }

    private boolean p(y4.d dVar, y4.e eVar) {
        return n(dVar) && o(eVar);
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
        Class<? super T> c10 = aVar.c();
        boolean e10 = e(c10);
        boolean z10 = e10 || h(c10, true);
        boolean z11 = e10 || h(c10, false);
        if (z10 || z11) {
            return new a(z11, z10, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(Class<?> cls, boolean z10) {
        return e(cls) || h(cls, z10);
    }

    public boolean i(Field field, boolean z10) {
        y4.a aVar;
        if ((this.f16179g & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f16178f != -1.0d && !p((y4.d) field.getAnnotation(y4.d.class), (y4.e) field.getAnnotation(y4.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f16181i && ((aVar = (y4.a) field.getAnnotation(y4.a.class)) == null || (!z10 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f16180h && l(field.getType())) || k(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z10 ? this.f16182j : this.f16183k;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
