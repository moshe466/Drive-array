package na;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class i {
    public abstract void a(n9.b bVar);

    public abstract void b(n9.b bVar, n9.b bVar2);

    public abstract void c(n9.b bVar, n9.b bVar2);

    public void d(n9.b bVar, Collection<? extends n9.b> collection) {
        y8.k.e(bVar, "member");
        y8.k.e(collection, "overridden");
        bVar.r0(collection);
    }
}
