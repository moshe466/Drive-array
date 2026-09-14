package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.j;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.z;

/* loaded from: classes.dex */
public abstract class i extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11419a;

        static {
            int[] iArr = new int[z.c.values().length];
            f11419a = iArr;
            try {
                iArr[z.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11419a[z.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<MessageType extends i, BuilderType extends b> extends a.AbstractC0232a<BuilderType> {

        /* renamed from: f, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d f11420f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;

        @Override // 
        public BuilderType n() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.d o() {
            return this.f11420f;
        }

        public abstract BuilderType p(MessageType messagetype);

        public final BuilderType q(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f11420f = dVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements r {

        /* renamed from: g, reason: collision with root package name */
        private h<e> f11421g = h.g();

        /* renamed from: h, reason: collision with root package name */
        private boolean f11422h;

        /* JADX INFO: Access modifiers changed from: private */
        public h<e> s() {
            this.f11421g.q();
            this.f11422h = false;
            return this.f11421g;
        }

        private void t() {
            if (this.f11422h) {
                return;
            }
            this.f11421g = this.f11421g.clone();
            this.f11422h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void u(MessageType messagetype) {
            t();
            this.f11421g.r(((d) messagetype).f11423f);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<MessageType extends d<MessageType>> extends i implements r {

        /* renamed from: f, reason: collision with root package name */
        private final h<e> f11423f;

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<e, Object>> f11424a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f11425b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f11426c;

            private a(boolean z10) {
                Iterator<Map.Entry<e, Object>> p10 = d.this.f11423f.p();
                this.f11424a = p10;
                if (p10.hasNext()) {
                    this.f11425b = p10.next();
                }
                this.f11426c = z10;
            }

            /* synthetic */ a(d dVar, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                while (true) {
                    Map.Entry<e, Object> entry = this.f11425b;
                    if (entry == null || entry.getKey().getNumber() >= i10) {
                        return;
                    }
                    e key = this.f11425b.getKey();
                    if (this.f11426c && key.p() == z.c.MESSAGE && !key.f()) {
                        fVar.f0(key.getNumber(), (q) this.f11425b.getValue());
                    } else {
                        h.z(key, this.f11425b.getValue(), fVar);
                    }
                    this.f11425b = this.f11424a.hasNext() ? this.f11424a.next() : null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d() {
            this.f11423f = h.t();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d(c<MessageType, ?> cVar) {
            this.f11423f = cVar.s();
        }

        private void A(f<MessageType, ?> fVar) {
            if (fVar.b() != b()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i
        public void n() {
            this.f11423f.q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i
        public boolean q(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, g gVar, int i10) {
            return i.r(this.f11423f, b(), eVar, fVar, gVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean t() {
            return this.f11423f.n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int u() {
            return this.f11423f.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type v(f<MessageType, Type> fVar) {
            A(fVar);
            Object h10 = this.f11423f.h(fVar.f11436d);
            return h10 == null ? fVar.f11434b : (Type) fVar.a(h10);
        }

        public final <Type> Type w(f<MessageType, List<Type>> fVar, int i10) {
            A(fVar);
            return (Type) fVar.e(this.f11423f.i(fVar.f11436d, i10));
        }

        public final <Type> int x(f<MessageType, List<Type>> fVar) {
            A(fVar);
            return this.f11423f.j(fVar.f11436d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean y(f<MessageType, Type> fVar) {
            A(fVar);
            return this.f11423f.m(fVar.f11436d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d<MessageType>.a z() {
            return new a(this, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements h.b<e> {

        /* renamed from: f, reason: collision with root package name */
        final j.b<?> f11428f;

        /* renamed from: g, reason: collision with root package name */
        final int f11429g;

        /* renamed from: h, reason: collision with root package name */
        final z.b f11430h;

        /* renamed from: i, reason: collision with root package name */
        final boolean f11431i;

        /* renamed from: j, reason: collision with root package name */
        final boolean f11432j;

        e(j.b<?> bVar, int i10, z.b bVar2, boolean z10, boolean z11) {
            this.f11428f = bVar;
            this.f11429g = i10;
            this.f11430h = bVar2;
            this.f11431i = z10;
            this.f11432j = z11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public q.a e(q.a aVar, q qVar) {
            return ((b) aVar).p((i) qVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public boolean f() {
            return this.f11431i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public z.b g() {
            return this.f11430h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public int getNumber() {
            return this.f11429g;
        }

        @Override // java.lang.Comparable
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f11429g - eVar.f11429g;
        }

        public j.b<?> k() {
            return this.f11428f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public z.c p() {
            return this.f11430h.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        public boolean q() {
            return this.f11432j;
        }
    }

    /* loaded from: classes.dex */
    public static class f<ContainingType extends q, Type> {

        /* renamed from: a, reason: collision with root package name */
        final ContainingType f11433a;

        /* renamed from: b, reason: collision with root package name */
        final Type f11434b;

        /* renamed from: c, reason: collision with root package name */
        final q f11435c;

        /* renamed from: d, reason: collision with root package name */
        final e f11436d;

        /* renamed from: e, reason: collision with root package name */
        final Method f11437e;

        f(ContainingType containingtype, Type type, q qVar, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.g() == z.b.MESSAGE && qVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f11433a = containingtype;
            this.f11434b = type;
            this.f11435c = qVar;
            this.f11436d = eVar;
            this.f11437e = j.a.class.isAssignableFrom(cls) ? i.l(cls, "valueOf", Integer.TYPE) : null;
        }

        Object a(Object obj) {
            if (!this.f11436d.f()) {
                return e(obj);
            }
            if (this.f11436d.p() != z.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.f11433a;
        }

        public q c() {
            return this.f11435c;
        }

        public int d() {
            return this.f11436d.getNumber();
        }

        Object e(Object obj) {
            return this.f11436d.p() == z.c.ENUM ? i.m(this.f11437e, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f11436d.p() == z.c.ENUM ? Integer.valueOf(((j.a) obj).getNumber()) : obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(b bVar) {
    }

    static Method l(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb2 = new StringBuilder(name.length() + 45 + valueOf.length());
            sb2.append("Generated message class \"");
            sb2.append(name);
            sb2.append("\" missing method \"");
            sb2.append(valueOf);
            sb2.append("\".");
            throw new RuntimeException(sb2.toString(), e10);
        }
    }

    static Object m(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> o(ContainingType containingtype, q qVar, j.b<?> bVar, int i10, z.b bVar2, boolean z10, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), qVar, new e(bVar, i10, bVar2, true, z10), cls);
    }

    public static <ContainingType extends q, Type> f<ContainingType, Type> p(ContainingType containingtype, Type type, q qVar, j.b<?> bVar, int i10, z.b bVar2, Class cls) {
        return new f<>(containingtype, type, qVar, new e(bVar, i10, bVar2, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.q> boolean r(kotlin.reflect.jvm.internal.impl.protobuf.h<kotlin.reflect.jvm.internal.impl.protobuf.i.e> r5, MessageType r6, kotlin.reflect.jvm.internal.impl.protobuf.e r7, kotlin.reflect.jvm.internal.impl.protobuf.f r8, kotlin.reflect.jvm.internal.impl.protobuf.g r9, int r10) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.i.r(kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.q, kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f, kotlin.reflect.jvm.internal.impl.protobuf.g, int):boolean");
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public s<? extends q> i() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, g gVar, int i10) {
        return eVar.P(i10, fVar);
    }
}
