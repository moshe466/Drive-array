package androidx.lifecycle;

import android.os.Looper;
import n.C0590a;
import n.C0591b;

/* loaded from: classes.dex */
public class B extends A {
    @Override // androidx.lifecycle.A
    public void h(Object obj) {
        A.a("setValue");
        this.f3546g++;
        this.f3544e = obj;
        c(null);
    }

    public final void i(Object obj) {
        boolean z3;
        synchronized (this.f3540a) {
            if (this.f3545f == A.f3539k) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f3545f = obj;
        }
        if (!z3) {
            return;
        }
        C0590a B3 = C0590a.B();
        G.a aVar = this.f3548j;
        C0591b c0591b = B3.f5875b;
        if (c0591b.f5878d == null) {
            synchronized (c0591b.f5876b) {
                try {
                    if (c0591b.f5878d == null) {
                        c0591b.f5878d = C0591b.B(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        c0591b.f5878d.post(aVar);
    }
}
