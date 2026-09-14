package a0;

import androidx.fragment.app.AbstractC0272g0;
import androidx.fragment.app.G;
import androidx.fragment.app.strictmode.Violation;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2749a = b.f2748a;

    public static b a(G g3) {
        while (g3 != null) {
            if (g3.isAdded()) {
                j.d(g3.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            g3 = g3.getParentFragment();
        }
        return f2749a;
    }

    public static void b(Violation violation) {
        if (AbstractC0272g0.J(3)) {
            violation.f3514a.getClass();
        }
    }

    public static final void c(G fragment, String previousFragmentId) {
        j.e(fragment, "fragment");
        j.e(previousFragmentId, "previousFragmentId");
        b(new Violation(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId));
        a(fragment).getClass();
    }
}
