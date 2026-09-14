package androidx.lifecycle;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class V {

    /* renamed from: a, reason: collision with root package name */
    public final e0.b f3589a = new e0.b();

    public final void a() {
        e0.b bVar = this.f3589a;
        if (bVar != null && !bVar.f4446d) {
            bVar.f4446d = true;
            synchronized (bVar.f4443a) {
                try {
                    Iterator it = bVar.f4444b.values().iterator();
                    while (it.hasNext()) {
                        e0.b.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = bVar.f4445c.iterator();
                    while (it2.hasNext()) {
                        e0.b.a((AutoCloseable) it2.next());
                    }
                    bVar.f4445c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        b();
    }

    public void b() {
    }
}
