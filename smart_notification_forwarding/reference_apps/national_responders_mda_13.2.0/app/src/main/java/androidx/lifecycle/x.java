package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.h;
import k0.a;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b<p0.e> f3238a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b<f0> f3239b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b<Bundle> f3240c = new a();

    /* loaded from: classes.dex */
    public static final class a implements a.b<Bundle> {
        a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements a.b<p0.e> {
        b() {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements a.b<f0> {
        c() {
        }
    }

    /* loaded from: classes.dex */
    static final class d extends y8.l implements x8.l<k0.a, z> {

        /* renamed from: f, reason: collision with root package name */
        public static final d f3241f = new d();

        d() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z h(k0.a aVar) {
            y8.k.e(aVar, "$this$initializer");
            return new z();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends p0.e & f0> void a(T t10) {
        y8.k.e(t10, "<this>");
        h.c b10 = t10.b().b();
        y8.k.d(b10, "lifecycle.currentState");
        if (!(b10 == h.c.INITIALIZED || b10 == h.c.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10.f().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            y yVar = new y(t10.f(), t10);
            t10.f().h("androidx.lifecycle.internal.SavedStateHandlesProvider", yVar);
            t10.b().a(new SavedStateHandleAttacher(yVar));
        }
    }

    public static final z b(f0 f0Var) {
        y8.k.e(f0Var, "<this>");
        k0.c cVar = new k0.c();
        cVar.a(y8.w.b(z.class), d.f3241f);
        return (z) new b0(f0Var, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", z.class);
    }
}
