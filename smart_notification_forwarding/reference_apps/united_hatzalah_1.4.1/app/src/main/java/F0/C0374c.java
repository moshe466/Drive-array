package f0;

import androidx.lifecycle.B;
import androidx.lifecycle.C;

/* renamed from: f0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0374c extends B implements androidx.loader.content.d {

    /* renamed from: l, reason: collision with root package name */
    public final androidx.loader.content.e f4479l;

    /* renamed from: m, reason: collision with root package name */
    public Object f4480m;

    /* renamed from: n, reason: collision with root package name */
    public C0375d f4481n;

    public C0374c(androidx.loader.content.e eVar) {
        this.f4479l = eVar;
        eVar.registerListener(0, this);
    }

    @Override // androidx.lifecycle.A
    public final void e() {
        this.f4479l.startLoading();
    }

    @Override // androidx.lifecycle.A
    public final void f() {
        this.f4479l.stopLoading();
    }

    @Override // androidx.lifecycle.A
    public final void g(C c4) {
        super.g(c4);
        this.f4480m = null;
        this.f4481n = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.t, java.lang.Object] */
    public final void j() {
        ?? r02 = this.f4480m;
        C0375d c0375d = this.f4481n;
        if (r02 != 0 && c0375d != null) {
            super.g(c0375d);
            d(r02, c0375d);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #0 : ");
        I.d.a(this.f4479l, sb);
        sb.append("}}");
        return sb.toString();
    }
}
