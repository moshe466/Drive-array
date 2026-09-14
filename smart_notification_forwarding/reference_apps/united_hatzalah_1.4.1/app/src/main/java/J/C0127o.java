package J;

import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: J.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0127o {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f1018a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f1019b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f1020c = new HashMap();

    public C0127o(Runnable runnable) {
        this.f1018a = runnable;
    }

    public final boolean a(MenuItem menuItem) {
        Iterator it = this.f1019b.iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.Y) ((InterfaceC0128p) it.next())).f3332a.p(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void b(InterfaceC0128p interfaceC0128p) {
        this.f1019b.remove(interfaceC0128p);
        C0126n c0126n = (C0126n) this.f1020c.remove(interfaceC0128p);
        if (c0126n != null) {
            c0126n.f1016a.b(c0126n.f1017b);
            c0126n.f1017b = null;
        }
        this.f1018a.run();
    }
}
