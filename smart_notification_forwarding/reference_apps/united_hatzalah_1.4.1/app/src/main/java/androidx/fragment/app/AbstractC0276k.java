package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0276k {

    /* renamed from: a, reason: collision with root package name */
    public final E0 f3425a;

    public AbstractC0276k(E0 operation) {
        kotlin.jvm.internal.j.e(operation, "operation");
        this.f3425a = operation;
    }

    public final boolean a() {
        int i;
        E0 e02 = this.f3425a;
        View view = e02.f3291c.mView;
        if (view != null) {
            i = 4;
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility != 0) {
                    if (visibility != 4) {
                        if (visibility == 8) {
                            i = 3;
                        } else {
                            throw new IllegalArgumentException(e0.a.c(visibility, "Unknown visibility "));
                        }
                    }
                } else {
                    i = 2;
                }
            }
        } else {
            i = 0;
        }
        int i3 = e02.f3289a;
        if (i != i3) {
            if (i == 2 || i3 == 2) {
                return false;
            }
            return true;
        }
        return true;
    }
}
