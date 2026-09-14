package androidx.lifecycle;

import android.app.Application;
import java.util.Objects;
import k0.a;

/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f3195a;

    /* renamed from: b, reason: collision with root package name */
    private final b f3196b;

    /* renamed from: c, reason: collision with root package name */
    private final k0.a f3197c;

    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public static final a.b<Application> f3198b;

        /* renamed from: androidx.lifecycle.b0$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0051a {

            /* renamed from: androidx.lifecycle.b0$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            private static final class C0052a implements a.b<Application> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0052a f3199a = new C0052a();

                private C0052a() {
                }
            }

            private C0051a() {
            }

            public /* synthetic */ C0051a(y8.g gVar) {
                this();
            }
        }

        static {
            new C0051a(null);
            f3198b = C0051a.C0052a.f3199a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        <T extends a0> T a(Class<T> cls, k0.a aVar);

        <T extends a0> T b(Class<T> cls);
    }

    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a.b<String> f3200a;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: androidx.lifecycle.b0$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            private static final class C0053a implements a.b<String> {

                /* renamed from: a, reason: collision with root package name */
                public static final C0053a f3201a = new C0053a();

                private C0053a() {
                }
            }

            private a() {
            }

            public /* synthetic */ a(y8.g gVar) {
                this();
            }
        }

        static {
            new a(null);
            f3200a = a.C0053a.f3201a;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public void a(a0 a0Var) {
            y8.k.e(a0Var, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(e0 e0Var, b bVar) {
        this(e0Var, bVar, null, 4, null);
        y8.k.e(e0Var, "store");
        y8.k.e(bVar, "factory");
    }

    public b0(e0 e0Var, b bVar, k0.a aVar) {
        y8.k.e(e0Var, "store");
        y8.k.e(bVar, "factory");
        y8.k.e(aVar, "defaultCreationExtras");
        this.f3195a = e0Var;
        this.f3196b = bVar;
        this.f3197c = aVar;
    }

    public /* synthetic */ b0(e0 e0Var, b bVar, k0.a aVar, int i10, y8.g gVar) {
        this(e0Var, bVar, (i10 & 4) != 0 ? a.C0224a.f11122b : aVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b0(androidx.lifecycle.f0 r3, androidx.lifecycle.b0.b r4) {
        /*
            r2 = this;
            java.lang.String r0 = "owner"
            y8.k.e(r3, r0)
            java.lang.String r0 = "factory"
            y8.k.e(r4, r0)
            androidx.lifecycle.e0 r0 = r3.F()
            java.lang.String r1 = "owner.viewModelStore"
            y8.k.d(r0, r1)
            k0.a r3 = androidx.lifecycle.d0.a(r3)
            r2.<init>(r0, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.b0.<init>(androidx.lifecycle.f0, androidx.lifecycle.b0$b):void");
    }

    public <T extends a0> T a(Class<T> cls) {
        y8.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends a0> T b(String str, Class<T> cls) {
        T t10;
        y8.k.e(str, "key");
        y8.k.e(cls, "modelClass");
        T t11 = (T) this.f3195a.b(str);
        if (!cls.isInstance(t11)) {
            k0.d dVar = new k0.d(this.f3197c);
            dVar.b(c.f3200a, str);
            try {
                t10 = (T) this.f3196b.a(cls, dVar);
            } catch (AbstractMethodError unused) {
                t10 = (T) this.f3196b.b(cls);
            }
            this.f3195a.d(str, t10);
            return t10;
        }
        Object obj = this.f3196b;
        d dVar2 = obj instanceof d ? (d) obj : null;
        if (dVar2 != null) {
            y8.k.d(t11, "viewModel");
            dVar2.a(t11);
        }
        Objects.requireNonNull(t11, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return t11;
    }
}
