package p0;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.savedstate.Recreator;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f13011d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final e f13012a;

    /* renamed from: b, reason: collision with root package name */
    private final c f13013b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13014c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d a(e eVar) {
            k.e(eVar, "owner");
            return new d(eVar, null);
        }
    }

    private d(e eVar) {
        this.f13012a = eVar;
        this.f13013b = new c();
    }

    public /* synthetic */ d(e eVar, g gVar) {
        this(eVar);
    }

    public static final d a(e eVar) {
        return f13011d.a(eVar);
    }

    public final c b() {
        return this.f13013b;
    }

    public final void c() {
        h b10 = this.f13012a.b();
        k.d(b10, "owner.lifecycle");
        if (!(b10.b() == h.c.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        b10.a(new Recreator(this.f13012a));
        this.f13013b.e(b10);
        this.f13014c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f13014c) {
            c();
        }
        h b10 = this.f13012a.b();
        k.d(b10, "owner.lifecycle");
        if (!b10.b().isAtLeast(h.c.STARTED)) {
            this.f13013b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + b10.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f13013b.g(bundle);
    }
}
