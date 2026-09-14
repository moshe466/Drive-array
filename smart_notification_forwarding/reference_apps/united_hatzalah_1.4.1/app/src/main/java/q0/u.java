package q0;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import t.C0689e;
import t.C0694j;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final C0615a f6126a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f6127b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f6128c;

    /* JADX WARN: Type inference failed for: r0v0, types: [q0.v, q0.a] */
    static {
        ?? vVar = new v();
        vVar.f6132z = false;
        vVar.H(new h(2));
        vVar.H(new q());
        vVar.H(new h(1));
        f6126a = vVar;
        f6127b = new ThreadLocal();
        f6128c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [t.j, t.e, java.lang.Object] */
    public static C0689e a() {
        C0689e c0689e;
        ThreadLocal threadLocal = f6127b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c0689e = (C0689e) weakReference.get()) != null) {
            return c0689e;
        }
        ?? c0694j = new C0694j(0);
        threadLocal.set(new WeakReference(c0694j));
        return c0694j;
    }
}
