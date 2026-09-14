package nb;

/* loaded from: classes.dex */
public final class q1<T> extends kotlinx.coroutines.internal.z<T> {

    /* renamed from: i, reason: collision with root package name */
    private ThreadLocal<l8.n<p8.f, Object>> f12424i;

    @Override // kotlinx.coroutines.internal.z, nb.a
    protected void k0(Object obj) {
        l8.n<p8.f, Object> nVar = this.f12424i.get();
        if (nVar != null) {
            kotlinx.coroutines.internal.f0.a(nVar.a(), nVar.b());
            this.f12424i.set(null);
        }
        Object a10 = r.a(obj, this.f11665h);
        p8.d<T> dVar = this.f11665h;
        p8.f c10 = dVar.c();
        Object c11 = kotlinx.coroutines.internal.f0.c(c10, null);
        q1<?> c12 = c11 != kotlinx.coroutines.internal.f0.f11611a ? t.c(dVar, c10, c11) : null;
        try {
            this.f11665h.b(a10);
            l8.w wVar = l8.w.f11824a;
        } finally {
            if (c12 == null || c12.n0()) {
                kotlinx.coroutines.internal.f0.a(c10, c11);
            }
        }
    }

    public final boolean n0() {
        if (this.f12424i.get() == null) {
            return false;
        }
        this.f12424i.set(null);
        return true;
    }

    public final void o0(p8.f fVar, Object obj) {
        this.f12424i.set(l8.t.a(fVar, obj));
    }
}
