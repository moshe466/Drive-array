package n9;

import kotlin.reflect.KProperty;
import ua.h;

/* loaded from: classes.dex */
public final class t0<T extends ua.h> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f12315e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f12316f = {y8.w.g(new y8.t(y8.w.b(t0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: a, reason: collision with root package name */
    private final e f12317a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, T> f12318b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f12319c;

    /* renamed from: d, reason: collision with root package name */
    private final ab.i f12320d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final <T extends ua.h> t0<T> a(e eVar, ab.n nVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, x8.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> lVar) {
            y8.k.e(eVar, "classDescriptor");
            y8.k.e(nVar, "storageManager");
            y8.k.e(gVar, "kotlinTypeRefinerForOwnerModule");
            y8.k.e(lVar, "scopeFactory");
            return new t0<>(eVar, nVar, lVar, gVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t0<T> f12321f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.checker.g f12322g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(t0<T> t0Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
            super(0);
            this.f12321f = t0Var;
            this.f12322g = gVar;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T b() {
            return (T) ((t0) this.f12321f).f12318b.h(this.f12322g);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements x8.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t0<T> f12323f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(t0<T> t0Var) {
            super(0);
            this.f12323f = t0Var;
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T b() {
            return (T) ((t0) this.f12323f).f12318b.h(((t0) this.f12323f).f12319c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private t0(e eVar, ab.n nVar, x8.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        this.f12317a = eVar;
        this.f12318b = lVar;
        this.f12319c = gVar;
        this.f12320d = nVar.a(new c(this));
    }

    public /* synthetic */ t0(e eVar, ab.n nVar, x8.l lVar, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, y8.g gVar2) {
        this(eVar, nVar, lVar, gVar);
    }

    private final T d() {
        return (T) ab.m.a(this.f12320d, this, f12316f[0]);
    }

    public final T c(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        if (!gVar.c(ra.a.l(this.f12317a))) {
            return d();
        }
        bb.t0 o10 = this.f12317a.o();
        y8.k.d(o10, "classDescriptor.typeConstructor");
        return !gVar.d(o10) ? d() : (T) gVar.b(this.f12317a, new b(this, gVar));
    }
}
