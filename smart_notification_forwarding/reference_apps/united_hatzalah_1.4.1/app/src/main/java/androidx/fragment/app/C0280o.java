package androidx.fragment.app;

import android.transition.Transition;

/* renamed from: androidx.fragment.app.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0280o extends AbstractC0276k {

    /* renamed from: b, reason: collision with root package name */
    public final Object f3468b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3469c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3470d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0280o(E0 e02, boolean z3, boolean z4) {
        super(e02);
        Object exitTransition;
        boolean z5;
        Object obj;
        G g3 = e02.f3291c;
        if (e02.f3289a == 2) {
            if (z3) {
                exitTransition = g3.getReenterTransition();
            } else {
                exitTransition = g3.getEnterTransition();
            }
        } else if (z3) {
            exitTransition = g3.getReturnTransition();
        } else {
            exitTransition = g3.getExitTransition();
        }
        this.f3468b = exitTransition;
        if (e02.f3289a == 2) {
            if (z3) {
                z5 = g3.getAllowReturnTransitionOverlap();
            } else {
                z5 = g3.getAllowEnterTransitionOverlap();
            }
        } else {
            z5 = true;
        }
        this.f3469c = z5;
        if (z4) {
            if (z3) {
                obj = g3.getSharedElementReturnTransition();
            } else {
                obj = g3.getSharedElementEnterTransition();
            }
        } else {
            obj = null;
        }
        this.f3470d = obj;
    }

    public final z0 b() {
        Object obj = this.f3468b;
        z0 c4 = c(obj);
        Object obj2 = this.f3470d;
        z0 c5 = c(obj2);
        if (c4 != null && c5 != null && c4 != c5) {
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.f3425a.f3291c + " returned Transition " + obj + " which uses a different Transition  type than its shared element transition " + obj2).toString());
        }
        if (c4 == null) {
            return c5;
        }
        return c4;
    }

    public final z0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        x0 x0Var = s0.f3512a;
        if (obj instanceof Transition) {
            return x0Var;
        }
        z0 z0Var = s0.f3513b;
        if (z0Var != null && z0Var.e(obj)) {
            return z0Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f3425a.f3291c + " is not a valid framework Transition or AndroidX Transition");
    }
}
