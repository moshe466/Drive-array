package androidx.lifecycle;

import java.io.Closeable;
import l0.C0514d;

/* loaded from: classes.dex */
public final class M implements r, Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final String f3568a;

    /* renamed from: b, reason: collision with root package name */
    public final L f3569b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3570c;

    public M(String str, L l3) {
        this.f3568a = str;
        this.f3569b = l3;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        if (enumC0303m == EnumC0303m.ON_DESTROY) {
            this.f3570c = false;
            interfaceC0309t.getLifecycle().b(this);
        }
    }

    public final void b(AbstractC0305o lifecycle, C0514d registry) {
        kotlin.jvm.internal.j.e(registry, "registry");
        kotlin.jvm.internal.j.e(lifecycle, "lifecycle");
        if (!this.f3570c) {
            this.f3570c = true;
            lifecycle.a(this);
            registry.c(this.f3568a, this.f3569b.f3567e);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
