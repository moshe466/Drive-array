package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public class z<T> extends nb.a<T> implements r8.d {

    /* renamed from: h, reason: collision with root package name */
    public final p8.d<T> f11665h;

    @Override // nb.g1
    protected final boolean K() {
        return true;
    }

    @Override // r8.d
    public final r8.d a() {
        p8.d<T> dVar = this.f11665h;
        if (dVar instanceof r8.d) {
            return (r8.d) dVar;
        }
        return null;
    }

    @Override // r8.d
    public final StackTraceElement e() {
        return null;
    }

    @Override // nb.a
    protected void k0(Object obj) {
        p8.d<T> dVar = this.f11665h;
        dVar.b(nb.r.a(obj, dVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nb.g1
    public void m(Object obj) {
        p8.d a10;
        a10 = q8.c.a(this.f11665h);
        g.c(a10, nb.r.a(obj, this.f11665h), null, 2, null);
    }
}
