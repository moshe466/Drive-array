package androidx.lifecycle;

import androidx.lifecycle.h;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements j {

    /* renamed from: a, reason: collision with root package name */
    private final y f3181a;

    public SavedStateHandleAttacher(y yVar) {
        y8.k.e(yVar, "provider");
        this.f3181a = yVar;
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        y8.k.e(lVar, "source");
        y8.k.e(bVar, "event");
        if (bVar == h.b.ON_CREATE) {
            lVar.b().c(this);
            this.f3181a.c();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + bVar).toString());
        }
    }
}
