package jb;

import l8.w;
import x8.l;
import x8.p;
import x8.q;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final l<Object, Boolean> f11059a;

    /* renamed from: b, reason: collision with root package name */
    private static final q<Object, Object, Object, w> f11060b;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements l {

        /* renamed from: f, reason: collision with root package name */
        public static final a f11061f = new a();

        a() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void h(Object obj) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends y8.l implements l<Object, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f11062f = new b();

        b() {
            super(1);
        }

        public final boolean a(Object obj) {
            return true;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Object obj) {
            return Boolean.valueOf(a(obj));
        }
    }

    /* loaded from: classes.dex */
    static final class c extends y8.l implements l<Object, w> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f11063f = new c();

        c() {
            super(1);
        }

        public final void a(Object obj) {
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ w h(Object obj) {
            a(obj);
            return w.f11824a;
        }
    }

    /* renamed from: jb.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0223d extends y8.l implements p<Object, Object, w> {

        /* renamed from: f, reason: collision with root package name */
        public static final C0223d f11064f = new C0223d();

        C0223d() {
            super(2);
        }

        public final void a(Object obj, Object obj2) {
        }

        @Override // x8.p
        public /* bridge */ /* synthetic */ w g(Object obj, Object obj2) {
            a(obj, obj2);
            return w.f11824a;
        }
    }

    /* loaded from: classes.dex */
    static final class e extends y8.l implements q<Object, Object, Object, w> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f11065f = new e();

        e() {
            super(3);
        }

        public final void a(Object obj, Object obj2, Object obj3) {
        }

        @Override // x8.q
        public /* bridge */ /* synthetic */ w f(Object obj, Object obj2, Object obj3) {
            a(obj, obj2, obj3);
            return w.f11824a;
        }
    }

    /* loaded from: classes.dex */
    static final class f extends y8.l implements l<Object, Object> {

        /* renamed from: f, reason: collision with root package name */
        public static final f f11066f = new f();

        f() {
            super(1);
        }

        @Override // x8.l
        public final Object h(Object obj) {
            return obj;
        }
    }

    static {
        f fVar = f.f11066f;
        f11059a = b.f11062f;
        a aVar = a.f11061f;
        c cVar = c.f11063f;
        C0223d c0223d = C0223d.f11064f;
        f11060b = e.f11065f;
    }

    public static final <T> l<T, Boolean> a() {
        return (l<T, Boolean>) f11059a;
    }

    public static final q<Object, Object, Object, w> b() {
        return f11060b;
    }
}
