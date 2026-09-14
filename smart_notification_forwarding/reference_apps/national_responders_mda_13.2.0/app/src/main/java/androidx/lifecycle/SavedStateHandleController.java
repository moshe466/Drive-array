package androidx.lifecycle;

import androidx.lifecycle.h;

/* loaded from: classes.dex */
final class SavedStateHandleController implements j {

    /* renamed from: a, reason: collision with root package name */
    private final String f3182a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f3183b;

    /* renamed from: c, reason: collision with root package name */
    private final w f3184c;

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        if (bVar == h.b.ON_DESTROY) {
            this.f3183b = false;
            lVar.b().c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(p0.c cVar, h hVar) {
        if (this.f3183b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f3183b = true;
        hVar.a(this);
        cVar.h(this.f3182a, this.f3184c.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f3183b;
    }
}
