package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f2587b;

    /* renamed from: a, reason: collision with root package name */
    private final l f2588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f2589a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f2590b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f2591c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f2592d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2589a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f2590b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2591c = declaredField3;
                declaredField3.setAccessible(true);
                f2592d = true;
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to get visible insets from AttachInfo ");
                sb2.append(e10.getMessage());
            }
        }

        public static k0 a(View view) {
            if (f2592d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2589a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f2590b.get(obj);
                        Rect rect2 = (Rect) f2591c.get(obj);
                        if (rect != null && rect2 != null) {
                            k0 a10 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a10.r(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get insets from AttachInfo. ");
                    sb2.append(e10.getMessage());
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final f f2593a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            this.f2593a = i10 >= 30 ? new e() : i10 >= 29 ? new d() : i10 >= 20 ? new c() : new f();
        }

        public b(k0 k0Var) {
            int i10 = Build.VERSION.SDK_INT;
            this.f2593a = i10 >= 30 ? new e(k0Var) : i10 >= 29 ? new d(k0Var) : i10 >= 20 ? new c(k0Var) : new f(k0Var);
        }

        public k0 a() {
            return this.f2593a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.b bVar) {
            this.f2593a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.b bVar) {
            this.f2593a.f(bVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private static Field f2594e;

        /* renamed from: f, reason: collision with root package name */
        private static boolean f2595f;

        /* renamed from: g, reason: collision with root package name */
        private static Constructor<WindowInsets> f2596g;

        /* renamed from: h, reason: collision with root package name */
        private static boolean f2597h;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsets f2598c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b f2599d;

        c() {
            this.f2598c = h();
        }

        c(k0 k0Var) {
            super(k0Var);
            this.f2598c = k0Var.t();
        }

        private static WindowInsets h() {
            if (!f2595f) {
                try {
                    f2594e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f2595f = true;
            }
            Field field = f2594e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!f2597h) {
                try {
                    f2596g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException unused3) {
                }
                f2597h = true;
            }
            Constructor<WindowInsets> constructor = f2596g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        @Override // androidx.core.view.k0.f
        k0 b() {
            a();
            k0 u10 = k0.u(this.f2598c);
            u10.p(this.f2602b);
            u10.s(this.f2599d);
            return u10;
        }

        @Override // androidx.core.view.k0.f
        void d(androidx.core.graphics.b bVar) {
            this.f2599d = bVar;
        }

        @Override // androidx.core.view.k0.f
        void f(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f2598c;
            if (windowInsets != null) {
                this.f2598c = windowInsets.replaceSystemWindowInsets(bVar.f2364a, bVar.f2365b, bVar.f2366c, bVar.f2367d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f2600c;

        d() {
            this.f2600c = new WindowInsets.Builder();
        }

        d(k0 k0Var) {
            super(k0Var);
            WindowInsets t10 = k0Var.t();
            this.f2600c = t10 != null ? new WindowInsets.Builder(t10) : new WindowInsets.Builder();
        }

        @Override // androidx.core.view.k0.f
        k0 b() {
            a();
            k0 u10 = k0.u(this.f2600c.build());
            u10.p(this.f2602b);
            return u10;
        }

        @Override // androidx.core.view.k0.f
        void c(androidx.core.graphics.b bVar) {
            this.f2600c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.k0.f
        void d(androidx.core.graphics.b bVar) {
            this.f2600c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.k0.f
        void e(androidx.core.graphics.b bVar) {
            this.f2600c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.k0.f
        void f(androidx.core.graphics.b bVar) {
            this.f2600c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.k0.f
        void g(androidx.core.graphics.b bVar) {
            this.f2600c.setTappableElementInsets(bVar.e());
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(k0 k0Var) {
            super(k0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final k0 f2601a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b[] f2602b;

        f() {
            this(new k0((k0) null));
        }

        f(k0 k0Var) {
            this.f2601a = k0Var;
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f2602b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[m.a(1)];
                androidx.core.graphics.b bVar2 = this.f2602b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f2601a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f2601a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f2602b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f2602b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f2602b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        k0 b() {
            a();
            return this.f2601a;
        }

        void c(androidx.core.graphics.b bVar) {
        }

        void d(androidx.core.graphics.b bVar) {
        }

        void e(androidx.core.graphics.b bVar) {
        }

        void f(androidx.core.graphics.b bVar) {
        }

        void g(androidx.core.graphics.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        private static boolean f2603h;

        /* renamed from: i, reason: collision with root package name */
        private static Method f2604i;

        /* renamed from: j, reason: collision with root package name */
        private static Class<?> f2605j;

        /* renamed from: k, reason: collision with root package name */
        private static Field f2606k;

        /* renamed from: l, reason: collision with root package name */
        private static Field f2607l;

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f2608c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b[] f2609d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b f2610e;

        /* renamed from: f, reason: collision with root package name */
        private k0 f2611f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b f2612g;

        g(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var);
            this.f2610e = null;
            this.f2608c = windowInsets;
        }

        g(k0 k0Var, g gVar) {
            this(k0Var, new WindowInsets(gVar.f2608c));
        }

        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.b t(int i10, boolean z10) {
            androidx.core.graphics.b bVar = androidx.core.graphics.b.f2363e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVar = androidx.core.graphics.b.a(bVar, u(i11, z10));
                }
            }
            return bVar;
        }

        private androidx.core.graphics.b v() {
            k0 k0Var = this.f2611f;
            return k0Var != null ? k0Var.g() : androidx.core.graphics.b.f2363e;
        }

        private androidx.core.graphics.b w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f2603h) {
                x();
            }
            Method method = f2604i;
            if (method != null && f2605j != null && f2606k != null) {
                try {
                    Object invoke = method.invoke(view, new Object[0]);
                    if (invoke == null) {
                        return null;
                    }
                    Rect rect = (Rect) f2606k.get(f2607l.get(invoke));
                    if (rect != null) {
                        return androidx.core.graphics.b.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get visible insets. (Reflection error). ");
                    sb2.append(e10.getMessage());
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f2604i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2605j = cls;
                f2606k = cls.getDeclaredField("mVisibleInsets");
                f2607l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f2606k.setAccessible(true);
                f2607l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to get visible insets. (Reflection error). ");
                sb2.append(e10.getMessage());
            }
            f2603h = true;
        }

        @Override // androidx.core.view.k0.l
        void d(View view) {
            androidx.core.graphics.b w10 = w(view);
            if (w10 == null) {
                w10 = androidx.core.graphics.b.f2363e;
            }
            q(w10);
        }

        @Override // androidx.core.view.k0.l
        void e(k0 k0Var) {
            k0Var.r(this.f2611f);
            k0Var.q(this.f2612g);
        }

        @Override // androidx.core.view.k0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f2612g, ((g) obj).f2612g);
            }
            return false;
        }

        @Override // androidx.core.view.k0.l
        public androidx.core.graphics.b g(int i10) {
            return t(i10, false);
        }

        @Override // androidx.core.view.k0.l
        final androidx.core.graphics.b k() {
            if (this.f2610e == null) {
                this.f2610e = androidx.core.graphics.b.b(this.f2608c.getSystemWindowInsetLeft(), this.f2608c.getSystemWindowInsetTop(), this.f2608c.getSystemWindowInsetRight(), this.f2608c.getSystemWindowInsetBottom());
            }
            return this.f2610e;
        }

        @Override // androidx.core.view.k0.l
        k0 m(int i10, int i11, int i12, int i13) {
            b bVar = new b(k0.u(this.f2608c));
            bVar.c(k0.m(k(), i10, i11, i12, i13));
            bVar.b(k0.m(i(), i10, i11, i12, i13));
            return bVar.a();
        }

        @Override // androidx.core.view.k0.l
        boolean o() {
            return this.f2608c.isRound();
        }

        @Override // androidx.core.view.k0.l
        public void p(androidx.core.graphics.b[] bVarArr) {
            this.f2609d = bVarArr;
        }

        @Override // androidx.core.view.k0.l
        void q(androidx.core.graphics.b bVar) {
            this.f2612g = bVar;
        }

        @Override // androidx.core.view.k0.l
        void r(k0 k0Var) {
            this.f2611f = k0Var;
        }

        protected androidx.core.graphics.b u(int i10, boolean z10) {
            androidx.core.graphics.b g10;
            int i11;
            if (i10 == 1) {
                return z10 ? androidx.core.graphics.b.b(0, Math.max(v().f2365b, k().f2365b), 0, 0) : androidx.core.graphics.b.b(0, k().f2365b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    androidx.core.graphics.b v10 = v();
                    androidx.core.graphics.b i12 = i();
                    return androidx.core.graphics.b.b(Math.max(v10.f2364a, i12.f2364a), 0, Math.max(v10.f2366c, i12.f2366c), Math.max(v10.f2367d, i12.f2367d));
                }
                androidx.core.graphics.b k10 = k();
                k0 k0Var = this.f2611f;
                g10 = k0Var != null ? k0Var.g() : null;
                int i13 = k10.f2367d;
                if (g10 != null) {
                    i13 = Math.min(i13, g10.f2367d);
                }
                return androidx.core.graphics.b.b(k10.f2364a, 0, k10.f2366c, i13);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return j();
                }
                if (i10 == 32) {
                    return h();
                }
                if (i10 == 64) {
                    return l();
                }
                if (i10 != 128) {
                    return androidx.core.graphics.b.f2363e;
                }
                k0 k0Var2 = this.f2611f;
                androidx.core.view.d e10 = k0Var2 != null ? k0Var2.e() : f();
                return e10 != null ? androidx.core.graphics.b.b(e10.b(), e10.d(), e10.c(), e10.a()) : androidx.core.graphics.b.f2363e;
            }
            androidx.core.graphics.b[] bVarArr = this.f2609d;
            g10 = bVarArr != null ? bVarArr[m.a(8)] : null;
            if (g10 != null) {
                return g10;
            }
            androidx.core.graphics.b k11 = k();
            androidx.core.graphics.b v11 = v();
            int i14 = k11.f2367d;
            if (i14 > v11.f2367d) {
                return androidx.core.graphics.b.b(0, 0, 0, i14);
            }
            androidx.core.graphics.b bVar = this.f2612g;
            return (bVar == null || bVar.equals(androidx.core.graphics.b.f2363e) || (i11 = this.f2612g.f2367d) <= v11.f2367d) ? androidx.core.graphics.b.f2363e : androidx.core.graphics.b.b(0, 0, 0, i11);
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        private androidx.core.graphics.b f2613m;

        h(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f2613m = null;
        }

        h(k0 k0Var, h hVar) {
            super(k0Var, hVar);
            this.f2613m = null;
            this.f2613m = hVar.f2613m;
        }

        @Override // androidx.core.view.k0.l
        k0 b() {
            return k0.u(this.f2608c.consumeStableInsets());
        }

        @Override // androidx.core.view.k0.l
        k0 c() {
            return k0.u(this.f2608c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.k0.l
        final androidx.core.graphics.b i() {
            if (this.f2613m == null) {
                this.f2613m = androidx.core.graphics.b.b(this.f2608c.getStableInsetLeft(), this.f2608c.getStableInsetTop(), this.f2608c.getStableInsetRight(), this.f2608c.getStableInsetBottom());
            }
            return this.f2613m;
        }

        @Override // androidx.core.view.k0.l
        boolean n() {
            return this.f2608c.isConsumed();
        }

        @Override // androidx.core.view.k0.l
        public void s(androidx.core.graphics.b bVar) {
            this.f2613m = bVar;
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {
        i(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        i(k0 k0Var, i iVar) {
            super(k0Var, iVar);
        }

        @Override // androidx.core.view.k0.l
        k0 a() {
            return k0.u(this.f2608c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.k0.g, androidx.core.view.k0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f2608c, iVar.f2608c) && Objects.equals(this.f2612g, iVar.f2612g);
        }

        @Override // androidx.core.view.k0.l
        androidx.core.view.d f() {
            return androidx.core.view.d.e(this.f2608c.getDisplayCutout());
        }

        @Override // androidx.core.view.k0.l
        public int hashCode() {
            return this.f2608c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        private androidx.core.graphics.b f2614n;

        /* renamed from: o, reason: collision with root package name */
        private androidx.core.graphics.b f2615o;

        /* renamed from: p, reason: collision with root package name */
        private androidx.core.graphics.b f2616p;

        j(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
            this.f2614n = null;
            this.f2615o = null;
            this.f2616p = null;
        }

        j(k0 k0Var, j jVar) {
            super(k0Var, jVar);
            this.f2614n = null;
            this.f2615o = null;
            this.f2616p = null;
        }

        @Override // androidx.core.view.k0.l
        androidx.core.graphics.b h() {
            if (this.f2615o == null) {
                this.f2615o = androidx.core.graphics.b.d(this.f2608c.getMandatorySystemGestureInsets());
            }
            return this.f2615o;
        }

        @Override // androidx.core.view.k0.l
        androidx.core.graphics.b j() {
            if (this.f2614n == null) {
                this.f2614n = androidx.core.graphics.b.d(this.f2608c.getSystemGestureInsets());
            }
            return this.f2614n;
        }

        @Override // androidx.core.view.k0.l
        androidx.core.graphics.b l() {
            if (this.f2616p == null) {
                this.f2616p = androidx.core.graphics.b.d(this.f2608c.getTappableElementInsets());
            }
            return this.f2616p;
        }

        @Override // androidx.core.view.k0.g, androidx.core.view.k0.l
        k0 m(int i10, int i11, int i12, int i13) {
            return k0.u(this.f2608c.inset(i10, i11, i12, i13));
        }

        @Override // androidx.core.view.k0.h, androidx.core.view.k0.l
        public void s(androidx.core.graphics.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    private static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        static final k0 f2617q = k0.u(WindowInsets.CONSUMED);

        k(k0 k0Var, WindowInsets windowInsets) {
            super(k0Var, windowInsets);
        }

        k(k0 k0Var, k kVar) {
            super(k0Var, kVar);
        }

        @Override // androidx.core.view.k0.g, androidx.core.view.k0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.k0.g, androidx.core.view.k0.l
        public androidx.core.graphics.b g(int i10) {
            return androidx.core.graphics.b.d(this.f2608c.getInsets(n.a(i10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        static final k0 f2618b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final k0 f2619a;

        l(k0 k0Var) {
            this.f2619a = k0Var;
        }

        k0 a() {
            return this.f2619a;
        }

        k0 b() {
            return this.f2619a;
        }

        k0 c() {
            return this.f2619a;
        }

        void d(View view) {
        }

        void e(k0 k0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && androidx.core.util.c.a(k(), lVar.k()) && androidx.core.util.c.a(i(), lVar.i()) && androidx.core.util.c.a(f(), lVar.f());
        }

        androidx.core.view.d f() {
            return null;
        }

        androidx.core.graphics.b g(int i10) {
            return androidx.core.graphics.b.f2363e;
        }

        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f2363e;
        }

        androidx.core.graphics.b j() {
            return k();
        }

        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f2363e;
        }

        androidx.core.graphics.b l() {
            return k();
        }

        k0 m(int i10, int i11, int i12, int i13) {
            return f2618b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.b[] bVarArr) {
        }

        void q(androidx.core.graphics.b bVar) {
        }

        void r(k0 k0Var) {
        }

        public void s(androidx.core.graphics.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }
    }

    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i10) {
            int statusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= statusBars;
                }
            }
            return i11;
        }
    }

    static {
        f2587b = Build.VERSION.SDK_INT >= 30 ? k.f2617q : l.f2618b;
    }

    private k0(WindowInsets windowInsets) {
        l gVar;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            gVar = new k(this, windowInsets);
        } else if (i10 >= 29) {
            gVar = new j(this, windowInsets);
        } else if (i10 >= 28) {
            gVar = new i(this, windowInsets);
        } else if (i10 >= 21) {
            gVar = new h(this, windowInsets);
        } else {
            if (i10 < 20) {
                this.f2588a = new l(this);
                return;
            }
            gVar = new g(this, windowInsets);
        }
        this.f2588a = gVar;
    }

    public k0(k0 k0Var) {
        if (k0Var == null) {
            this.f2588a = new l(this);
            return;
        }
        l lVar = k0Var.f2588a;
        int i10 = Build.VERSION.SDK_INT;
        this.f2588a = (i10 < 30 || !(lVar instanceof k)) ? (i10 < 29 || !(lVar instanceof j)) ? (i10 < 28 || !(lVar instanceof i)) ? (i10 < 21 || !(lVar instanceof h)) ? (i10 < 20 || !(lVar instanceof g)) ? new l(this) : new g(this, (g) lVar) : new h(this, (h) lVar) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    static androidx.core.graphics.b m(androidx.core.graphics.b bVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, bVar.f2364a - i10);
        int max2 = Math.max(0, bVar.f2365b - i11);
        int max3 = Math.max(0, bVar.f2366c - i12);
        int max4 = Math.max(0, bVar.f2367d - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? bVar : androidx.core.graphics.b.b(max, max2, max3, max4);
    }

    public static k0 u(WindowInsets windowInsets) {
        return v(windowInsets, null);
    }

    public static k0 v(WindowInsets windowInsets, View view) {
        k0 k0Var = new k0((WindowInsets) androidx.core.util.h.f(windowInsets));
        if (view != null && a0.R(view)) {
            k0Var.r(a0.G(view));
            k0Var.d(view.getRootView());
        }
        return k0Var;
    }

    @Deprecated
    public k0 a() {
        return this.f2588a.a();
    }

    @Deprecated
    public k0 b() {
        return this.f2588a.b();
    }

    @Deprecated
    public k0 c() {
        return this.f2588a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f2588a.d(view);
    }

    public androidx.core.view.d e() {
        return this.f2588a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k0) {
            return androidx.core.util.c.a(this.f2588a, ((k0) obj).f2588a);
        }
        return false;
    }

    public androidx.core.graphics.b f(int i10) {
        return this.f2588a.g(i10);
    }

    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f2588a.i();
    }

    @Deprecated
    public int h() {
        return this.f2588a.k().f2367d;
    }

    public int hashCode() {
        l lVar = this.f2588a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f2588a.k().f2364a;
    }

    @Deprecated
    public int j() {
        return this.f2588a.k().f2366c;
    }

    @Deprecated
    public int k() {
        return this.f2588a.k().f2365b;
    }

    public k0 l(int i10, int i11, int i12, int i13) {
        return this.f2588a.m(i10, i11, i12, i13);
    }

    public boolean n() {
        return this.f2588a.n();
    }

    @Deprecated
    public k0 o(int i10, int i11, int i12, int i13) {
        return new b(this).c(androidx.core.graphics.b.b(i10, i11, i12, i13)).a();
    }

    void p(androidx.core.graphics.b[] bVarArr) {
        this.f2588a.p(bVarArr);
    }

    void q(androidx.core.graphics.b bVar) {
        this.f2588a.q(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(k0 k0Var) {
        this.f2588a.r(k0Var);
    }

    void s(androidx.core.graphics.b bVar) {
        this.f2588a.s(bVar);
    }

    public WindowInsets t() {
        l lVar = this.f2588a;
        if (lVar instanceof g) {
            return ((g) lVar).f2608c;
        }
        return null;
    }
}
