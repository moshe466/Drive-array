package androidx.lifecycle;

import androidx.lifecycle.h;
import java.util.Iterator;
import p0.c;

/* loaded from: classes.dex */
class LegacySavedStateHandleController {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements c.a {
        a() {
        }

        @Override // p0.c.a
        public void a(p0.e eVar) {
            if (!(eVar instanceof f0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            e0 F = ((f0) eVar).F();
            p0.c f10 = eVar.f();
            Iterator<String> it = F.c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.a(F.b(it.next()), f10, eVar.b());
            }
            if (F.c().isEmpty()) {
                return;
            }
            f10.i(a.class);
        }
    }

    static void a(a0 a0Var, p0.c cVar, h hVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) a0Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.i()) {
            return;
        }
        savedStateHandleController.h(cVar, hVar);
        b(cVar, hVar);
    }

    private static void b(final p0.c cVar, final h hVar) {
        h.c b10 = hVar.b();
        if (b10 == h.c.INITIALIZED || b10.isAtLeast(h.c.STARTED)) {
            cVar.i(a.class);
        } else {
            hVar.a(new j() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.j
                public void d(l lVar, h.b bVar) {
                    if (bVar == h.b.ON_START) {
                        h.this.c(this);
                        cVar.i(a.class);
                    }
                }
            });
        }
    }
}
